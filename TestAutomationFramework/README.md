# Test Automation Framework

This project is a Test Automation Framework built using Maven. It is designed to facilitate automated testing of applications.

## Project Structure

```
TestAutomationFramework
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── Main.java
│   │   └── resources
│   │       └── config.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── MainTest.java
│       └── resources
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6 or higher

### Building the Project

To build the project, navigate to the root directory of the project and run the following command:

```
mvn clean install
```

### Running the Application

To run the application, execute the following command:

```
mvn exec:java -Dexec.mainClass="com.example.Main"
```

### Running Tests

To run the tests, use the following command:

```
mvn test
```

## Configuration

The configuration settings for the application can be found in the `src/main/resources/config.properties` file. You can modify the key-value pairs as needed.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.