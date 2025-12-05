# 🚀 Microservices Architecture - Saga Pattern Implementation

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apache-maven)

**A comprehensive e-commerce project built to learn and practice Saga Pattern and microservices architecture**

</div>

---

## 📋 Table of Contents

- [About the Project](#-about-the-project)
- [Architecture](#-architecture)
- [Services](#-services)
- [Technologies](#-technologies)
- [Installation](#-installation)
- [Usage](#-usage)
- [API Endpoints](#-api-endpoints)
- [Saga Pattern](#-saga-pattern)
- [Development](#-development)

---

## 🎯 About the Project

This project is a comprehensive e-commerce system developed to learn and implement **Saga Pattern** and **microservices architecture**. The project incorporates modern software development practices and distributed system design patterns.

### Key Features

- ✅ **Microservices Architecture**: Modular structure where each service has its own database and can operate independently
- ✅ **API Gateway**: Centralized entry point that routes all requests
- ✅ **JWT Authentication**: Secure authentication and authorization
- ✅ **Distributed Transactions**: Distributed transaction management with Saga pattern
- ✅ **Service Isolation**: Each service can be developed and deployed independently
- ✅ **Scalability**: Ready infrastructure for horizontal scaling

---

## 🏗️ Architecture

The project is designed according to **microservices architecture** principles. Each service has its own responsibility and can operate independently from other services.

```
┌─────────────────────────────────────────────────────────────┐
│                      API Gateway (8080)                      │
│                   Spring Cloud Gateway                       │
└──────────────┬──────────────────────────────────────────────┘
               │
               ├─────────────────────────────────────────┐
               │                                         │
       ┌───────▼────────┐                       ┌───────▼────────┐
       │  Auth Service  │                       │  Order Service │
       │    (8084)      │                       │     (8081)     │
       │   PostgreSQL   │                       │   PostgreSQL   │
       └────────────────┘                       └────────────────┘
               │                                         │
       ┌───────▼────────┐                       ┌───────▼────────┐
       │  User Service  │                       │ Product Service│
       │    (8083)      │                       │     (8082)     │
       │   PostgreSQL   │                       │   PostgreSQL   │
       └────────────────┘                       └────────────────┘
               │                                         │
       ┌───────▼────────┐                       ┌───────▼────────┐
       │Notification Svc│                       │Inventory Svc   │
       │    (8086)      │                       │     (8085)     │
       │   PostgreSQL   │                       │   PostgreSQL   │
       └────────────────┘                       └────────────────┘
```

### Architecture Principles

1. **Single Responsibility**: Each service is responsible for a single business domain
2. **Database Per Service**: Each service has its own database
3. **API Gateway Pattern**: All requests are routed through the gateway
4. **Decentralized Data Management**: Each service manages its own data
5. **Independent Deployment**: Services can be deployed independently of each other

---

## 🔧 Services

### 1. **Gateway Service** (Port: 8080)

- **Responsibility**: API Gateway, request routing, authentication
- **Technology**: Spring Cloud Gateway
- **Features**:
  - Centralized entry point
  - JWT token validation
  - Request/Response filtering
  - Ready infrastructure for load balancing

### 2. **Auth Service** (Port: 8084)

- **Responsibility**: Authentication and authorization
- **Features**:
  - User registration
  - User login
  - JWT token generation
  - Token validation

### 3. **Order Service** (Port: 8081)

- **Responsibility**: Order management
- **Features**:
  - Order creation
  - Order status tracking
  - Order history
  - Saga orchestration (future feature)

### 4. **Product Service** (Port: 8082)

- **Responsibility**: Product catalog management
- **Features**:
  - Product CRUD operations
  - Product search and filtering
  - Category management
  - Price management

### 5. **User Service** (Port: 8083)

- **Responsibility**: User profile management
- **Features**:
  - User profile
  - Profile updates
  - User preferences
  - Address management

### 6. **Inventory Service** (Port: 8085)

- **Responsibility**: Stock management
- **Features**:
  - Stock tracking
  - Stock reservation
  - Stock updates
  - Stock alerts

### 7. **Notification Service** (Port: 8086)

- **Responsibility**: Notification delivery
- **Features**:
  - Email notifications
  - Order status notifications
  - User notifications
  - Notification history

---

## 💻 Technologies

### Backend Framework

- **Spring Boot 3.5.7**: Modern Java framework
- **Spring Cloud Gateway**: API Gateway implementation
- **Spring Security**: Security and authentication
- **Spring Data JPA**: ORM and database operations

### Database

- **PostgreSQL**: Separate PostgreSQL database for each service
- **Hibernate**: ORM framework

### Build & Dependency Management

- **Maven**: Project management and build tool
- **Java 17**: LTS Java version

### Security

- **JWT (JSON Web Tokens)**: Stateless authentication
- **Spring Security**: Authorization and authentication

### Development Tools

- **Lombok**: Reduce boilerplate code
- **Spring DevTools**: Hot reload and development conveniences

---

## 🚀 Installation

### Requirements

- ☕ **Java 17** or higher
- 🐘 **PostgreSQL 12** or higher
- 📦 **Maven 3.6** or higher
- 🔧 **Git**

### 1. Clone the Repository

```bash
git clone <repository-url>
cd mserv
```

### 2. Create PostgreSQL Databases

Create a separate database for each service:

```sql
CREATE DATABASE orders_db;
CREATE DATABASE products_db;
CREATE DATABASE users_db;
CREATE DATABASE auth_db;
CREATE DATABASE inventory_db;
CREATE DATABASE notifications_db;
```

### 3. Configure Database Connections

Update the database information in each service's `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<db_name>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
```

### 4. Build and Start Services

#### Automatic Startup (Recommended)

```bash
chmod +x start.sh
./start.sh
```

This script:

- ✅ Builds all services
- ✅ Creates JAR files
- ✅ Starts services in the background
- ✅ Writes log files to the `logs/` folder

#### Manual Startup

For each service separately:

```bash
cd <service-name>
mvn clean package -DskipTests
java -jar target/<service-name>-0.0.1-SNAPSHOT.jar
```

### 5. Stop Services

```bash
chmod +x stop.sh
./stop.sh
```

---

## 📖 Usage

### Checking Service Status

```bash
# View running Java processes
ps aux | grep java

# Follow log files
tail -f logs/Order-Service.log
tail -f logs/Gateway-Service.log
```

### Sending Requests Through API Gateway

All requests should be sent through the Gateway (Port: 8080):

```bash
# Auth - Login
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username": "user", "password": "pass"}'

# Protected endpoint - Create order
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <your-jwt-token>" \
  -d '{...}'
```

---

## 🔌 API Endpoints

### Authentication (Port: 8080)

| Method | Endpoint         | Description           | Auth |
| ------ | ---------------- | --------------------- | ---- |
| POST   | `/auth/register` | New user registration | ❌   |
| POST   | `/auth/login`    | User login            | ❌   |

### Orders (Port: 8080)

| Method | Endpoint           | Description      | Auth |
| ------ | ------------------ | ---------------- | ---- |
| POST   | `/api/orders`      | Create new order | ✅   |
| GET    | `/api/orders/{id}` | Order details    | ✅   |
| GET    | `/api/orders`      | All orders       | ✅   |

### Products (Port: 8080)

| Method | Endpoint             | Description     | Auth |
| ------ | -------------------- | --------------- | ---- |
| GET    | `/api/products`      | All products    | ✅   |
| GET    | `/api/products/{id}` | Product details | ✅   |
| POST   | `/api/products`      | Add new product | ✅   |
| PUT    | `/api/products/{id}` | Update product  | ✅   |
| DELETE | `/api/products/{id}` | Delete product  | ✅   |

### Users (Port: 8080)

| Method | Endpoint             | Description    | Auth |
| ------ | -------------------- | -------------- | ---- |
| GET    | `/api/users/profile` | User profile   | ✅   |
| PUT    | `/api/users/profile` | Update profile | ✅   |

### Inventory (Port: 8080)

| Method | Endpoint                     | Description  | Auth |
| ------ | ---------------------------- | ------------ | ---- |
| GET    | `/api/inventory/{productId}` | Stock status | ✅   |
| PUT    | `/api/inventory/{productId}` | Update stock | ✅   |

### Notifications (Port: 8080)

| Method | Endpoint             | Description       | Auth |
| ------ | -------------------- | ----------------- | ---- |
| GET    | `/api/notifications` | Notifications     | ✅   |
| POST   | `/api/notifications` | Send notification | ✅   |

---

## 🔄 Saga Pattern

Saga Pattern is a design pattern used to manage **distributed transactions** in microservices architecture.

### What is Saga Pattern?

In traditional monolithic applications, database transactions are managed with ACID principles. However, in microservices architecture, since each service has its own database, approaches like **2-Phase Commit** for transactions spanning multiple services lead to performance issues.

Saga Pattern breaks long-running transactions into **smaller, independent transactions** and proceeds to the next step when each transaction succeeds. When an error occurs, it performs rollback operations with **compensating transactions**.

### Example Scenario: Order Creation

```
1. Order Service    → Create order (PENDING)
2. Inventory Service → Reserve stock
3. Payment Service  → Process payment
4. Order Service    → Update order status (CONFIRMED)
5. Notification Svc → Send notification to user
```

**Error Case**: If payment fails at step 3:

```
3. Payment Service  → ❌ Payment failed
4. Inventory Service → ↩️ Cancel stock reservation (Compensating)
5. Order Service    → ↩️ Cancel order (Compensating)
6. Notification Svc → 📧 Send error notification to user
```

### Saga Pattern Types

#### 1. **Choreography-based Saga**

- Each service does its own work and publishes events
- No central orchestrator
- Services listen to each other's events

#### 2. **Orchestration-based Saga** (Planned for this project)

- A central orchestrator manages the entire process
- Easier debugging and monitoring
- Better error handling

### Future Enhancements

- [ ] Kafka/RabbitMQ integration
- [ ] Saga Orchestrator implementation
- [ ] Event Sourcing pattern
- [ ] Compensating transactions
- [ ] Saga state management

---

## 🛠️ Development

### Adding a New Service

1. Add module to parent `pom.xml`
2. Create new service folder
3. Configure `pom.xml` and `application.properties`
4. Add route to Gateway
5. Add service to `start.sh` and `stop.sh` scripts

### Testing

```bash
# Run all tests
mvn test

# Run tests for a specific service
cd <service-name>
mvn test
```

### Log Management

Log files are stored in the `logs/` folder:

```bash
# View all logs
ls -la logs/

# Follow a specific service
tail -f logs/Order-Service.log

# Filter errors
grep ERROR logs/*.log
```

---

## 📚 Learning Resources

- [Microservices Pattern](https://microservices.io/patterns/microservices.html)
- [Saga Pattern](https://microservices.io/patterns/data/saga.html)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [JWT Authentication](https://jwt.io/introduction)

---

## 🤝 Contributing

This project was developed for learning purposes. Contributions are welcome!

1. Fork the project
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📝 License

This project is for educational purposes and can be used freely.

---

## 👨‍💻 Developer

**Burak Can**

This project was developed to learn Saga Pattern and microservices architecture.

---

<div align="center">

**⭐ If you like the project, don't forget to give it a star! ⭐**

</div>
