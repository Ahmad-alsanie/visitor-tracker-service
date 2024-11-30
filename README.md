# Visitor Tracker Service

This repository contains a Spring Boot application that uses AWS DynamoDB to track the number of visitors to your website. The application leverages the AWS SDK for Java to interact with DynamoDB and stores visitor count data, making it easy to track activity in real-time.

## Features

- Tracks the number of visitors to your website.
- Uses AWS DynamoDB as the backend data store.
- Provides REST endpoints to increment and retrieve visitor counts.
- Built using Spring Boot, with a focus on scalability and flexibility.

## Technologies Used

- **Java**: Programming language for the backend.
- **Spring Boot**: Framework used to build the application.
- **AWS DynamoDB**: NoSQL database used to store visitor counts.
- **AWS SDK for Java**: To interact with DynamoDB.

## Getting Started

### Prerequisites

- Java 11 or later
- Maven
- AWS account with DynamoDB permissions

### Running the Application

1. **Clone the repository**:

   ```shell
   git clone https://github.com/Ahmad-alsanie/visitor-tracker-service.git
   cd visitor-tracker-service
   ```
   
2. **Add AWS Credentials**:
Configure your AWS credentials in one of the following ways:

Set environment variables `AWS_ACCESS_KEY_ID` and `AWS_SECRET_ACCESS_KEY`.

Use an `~/.aws/credentials` file.

3. Modify the DynamoDB configuration in the code to include your credentials directly (for development purposes).
4. Build and run the application:

```shell
mvn spring-boot:run
```

### Endpoints

1. Increment Visitor Count: POST /visitor/increment

2. Get Visitor Count: GET /visitor/count

### Example DynamoDB Table Setup

If you want to create the DynamoDB table manually using AWS CLI:

```shell
aws dynamodb create-table \
    --table-name VisitorCount \
    --attribute-definitions AttributeName=Page,AttributeType=S \
    --key-schema AttributeName=Page,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
```

### License

This project is licensed under the MIT License. See the LICENSE file for more details.

### Contributing

Contributions are welcome! Please create a pull request or raise an issue if you have suggestions or find any bugs.