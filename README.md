# Spring Security Demo Application

A Spring Boot application demonstrating security features with PostgreSQL database integration.

## 📋 Table of Contents
- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## 🔍 Overview

This is a Spring Boot application built to demonstrate security features including authentication and authorization. The application uses PostgreSQL as the database and includes Spring Security for handling authentication and authorization.

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Security**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**
- **Docker & Docker Compose**

## 📋 Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java 21** or higher
- **Maven 3.6+**
- **Docker** and **Docker Compose**
- **Git**

### Verify Installation

```bash
java -version
mvn -version
docker --version
docker-compose --version
```

## 🗄️ Database Setup

This application uses PostgreSQL as the database. You can set it up using Docker Compose.

### Using Docker Compose (Recommended)

1. **Start the database services:**
   ```bash
   docker-compose up -d
   ```

   This will start:
   - PostgreSQL database on port `5432`
   - Adminer (database management tool) on port `8081`

2. **Verify the database is running:**
   ```bash
   docker-compose ps
   ```

3. **Access Adminer (Optional):**
   - Open your browser and go to `http://localhost:8081`
   - Login with:
     - **System:** PostgreSQL
     - **Server:** db
     - **Username:** postgres
     - **Password:** example
     - **Database:** postgres

### Manual PostgreSQL Setup

If you prefer to install PostgreSQL manually:

1. Install PostgreSQL on your system
2. Create a database named `postgres`
3. Update the connection details in `src/main/resources/application.yml` if needed

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/SangTruongTan/spring_security.git
cd spring_security
```

### 2. Build the Application

```bash
mvn clean install
```

Or if you want to skip tests:

```bash
mvn clean install -DskipTests
```

## ▶️ Running the Application

### Option 1: Using Maven (Development)

1. **Start the database:**
   ```bash
   docker-compose up -d
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

### Option 2: Using Java JAR

1. **Build the JAR file:**
   ```bash
   mvn clean package
   ```

2. **Run the JAR:**
   ```bash
   java -jar target/security-0.0.1-SNAPSHOT.jar
   ```

### Option 3: Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Application URLs

Once the application is running, you can access:

- **Application:** http://localhost:8082
- **Database Admin (Adminer):** http://localhost:8081
- **Actuator Health:** http://localhost:8082/actuator/health

## 🧪 Testing

### Run Unit Tests

```bash
mvn test
```

### Run Integration Tests

```bash
mvn verify
```

### Run All Tests with Coverage

```bash
mvn clean test jacoco:report
```

## 📚 API Documentation

The application runs on port `8082` by default. 

### Available Endpoints

- **Health Check:** `GET /actuator/health`
- **Application Info:** `GET /actuator/info`

*Note: Add more specific API endpoints here as you develop them.*

## 📁 Project Structure

```
spring_security/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/myexample/security/
│   │   │       ├── SecurityApplication.java    # Main application class
│   │   │       └── user/
│   │   │           └── User.java              # User entity
│   │   └── resources/
│   │       ├── application.yml                # Application configuration
│   │       └── templates/                     # Thymeleaf templates (if any)
│   └── test/
│       └── java/
│           └── com/myexample/security/
│               └── SecurityApplicationTests.java
├── docker-compose.yml                         # Database setup
├── pom.xml                                   # Maven configuration
└── README.md                                 # This file
```

## 🔧 Configuration

### Application Properties

The application configuration is located in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: example
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
server:
  port: 8082
```

### Environment Variables

You can override configuration using environment variables:

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/mydb
export SPRING_DATASOURCE_USERNAME=myuser
export SPRING_DATASOURCE_PASSWORD=mypassword
export SERVER_PORT=8080
```

## 🐳 Docker Support

### Database Only (Current Setup)

```bash
docker-compose up -d
```

### Future: Full Application Docker Support

To containerize the entire application, you can add a Dockerfile:

```dockerfile
FROM openjdk:21-jdk-slim
COPY target/security-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🔍 Troubleshooting

### Common Issues

1. **Port 8082 already in use:**
   ```bash
   # Check what's using the port
   lsof -i :8082
   # Kill the process or change the port in application.yml
   ```

2. **Database connection issues:**
   ```bash
   # Check if PostgreSQL is running
   docker-compose ps
   # Restart the database
   docker-compose restart db
   ```

3. **Java version issues:**
   ```bash
   # Check Java version
   java -version
   # Make sure you're using Java 21+
   ```

### Logs

View application logs:
```bash
# If running with Maven
mvn spring-boot:run

# If running JAR file
java -jar target/security-0.0.1-SNAPSHOT.jar --logging.level.com.myexample=DEBUG
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

If you encounter any issues or have questions, please:

1. Check the [troubleshooting section](#troubleshooting)
2. Search existing [GitHub Issues](https://github.com/SangTruongTan/spring_security/issues)
3. Create a new issue if needed

---

**Happy Coding! 🚀**