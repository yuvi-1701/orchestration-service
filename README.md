# First Service

## Overview

The First Service is responsible for orchestrating calls to the Second and Third services. It exposes two endpoints:

- A **GET** method to check if the service is running.
- A **POST** method that makes calls to Service 2 and Service 3 using the same payload.

## Features

- **GET `/ping`**: Returns the string `Up` if the service is running.
- **POST `/saga`**: Orchestrates calls to Service 2 and Service 3 with the provided JSON payload. The responses are concatenated and returned.

## Setup

```bash
# 1. Clone the repository:
git clone <repository-url>
cd first-service

# 2. Build the project:
mvn clean install

# 3. Run the application:
mvn spring-boot:run

## Endpoints

curl --location 'http://orchastration-service-4-env.eba-aqp6rdi8.ap-southeast-2.elasticbeanstalk.com/api/v1/ping'

curl --location 'http://orchastration-service-4-env.eba-aqp6rdi8.ap-southeast-2.elasticbeanstalk.com/api/v1/saga' \
--header 'Content-Type: application/json' \
--data '{
  "name": "Jane",
  "surname": "Doe"
}'

