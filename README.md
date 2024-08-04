# GCP-secrets
This project provides a simple Java application for retrieving secrets from Google Cloud Platform (GCP) Secret Manager. It demonstrates how to use the GCP Secret Manager client library to access secret versions programmatically.

## Features
### Retrieve Secrets: 
  Access and fetch a secret stored in GCP Secret Manager.
### Error Handling: 
  Handles common exceptions such as API errors and IO issues.
### Configuration: 
  Configurable to use different project IDs and secret names.

## Prerequisites:

Java 8 at least (Built on 17).
Gradle 8 (Built on 8.9)
Access to a GCP project with Secret Manager enabled.
Project ID and Secret Name from GCP.

## Setup:
Clone the repository
Navigate to the project directory: cd your-repo
Build the project using Gradle: ./gradlew build

## Usage:

Update the Config class with your GCP project ID and secret name.
Run the application through a main class or via command: java -jar build/libs/your-repo.jar
The secret will be printed to the console if accessed successfully.
