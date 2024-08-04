package org.example;

import java.io.IOException;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.secretmanager.v1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;

public class App {
    public static String getSecret(String projectId, String secretName) throws Exception {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName =
                    SecretVersionName.of(projectId, secretName, "latest");
            AccessSecretVersionRequest request =
                    AccessSecretVersionRequest.newBuilder()
                            .setName(secretVersionName.toString())
                            .build();
            return client.accessSecretVersion(request).getPayload().getData().toStringUtf8();
        } catch (IOException e) {
            System.err.println("Failed to create SecretManagerServiceClient: " + e.getMessage());
        } catch (ApiException e) {
            System.err.println("API Exception occurred: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            String secret = getSecret(Config.PROJECT_ID, Config.SECRET_NAME);
            if (secret != null) {
                System.out.println("Secret: " + secret);
            } else {
                System.out.println("Failed to access secret.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while accessing the secret: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
