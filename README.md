# Fibonacci Service

## Overview
Fibonacci Service is a Spring Boot application written in Kotlin that provides an API for calculating Fibonacci numbers. The service is designed to be lightweight and scalable, integrating with a Zeebe broker for workflow execution.

## Features
- REST API for Fibonacci sequence calculations
- Helm configuration for Kubernetes deployment

## Prerequisites
- Java 17+
- Docker (optional for containerized deployment)
- Helm (for Kubernetes deployment)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/micsigen/fibonacci-service.git
   cd fibonacci-service
   ```
2. Build and run the application locally:
   ```sh
   ./gradlew bootRun
   ```

## API Usage
Once running, access the Fibonacci API:
```sh
curl -X GET "http://localhost:8080/fibonacci?n=10"
```

## Publishing
Create a docker image into a local docker repository:
    ```sh
    ./gradlew jibDockerBuild
    ```

## Deployment
To package the application using Helm, run:
```sh
helm package fibonacci/
```

## License
This project is licensed under the Apache License. See `LICENSE` for details.

