# VitalOps — Emergency Operations Management Engine

VitalOps is a real-time emergency operations orchestration backend built using Java Spring Boot, Hibernate/JPA, and PostgreSQL.

The system intelligently manages emergency patient triage, hospital resource allocation, ICU scheduling, and operational overload monitoring using backend orchestration logic and DSA-driven prioritization.

---

# Problem Statement

Modern hospitals face critical operational challenges during emergency surges:

- Delayed patient prioritization
- ICU bed shortages
- Doctor allocation inefficiencies
- Lack of real-time operational monitoring
- Overloaded emergency departments
- Manual triage bottlenecks

Traditional hospital systems mainly focus on record storage instead of intelligent emergency workflow orchestration.

VitalOps solves this problem by providing a backend-driven operational intelligence system for dynamic patient prioritization and hospital resource management.

---

# Features

## Smart Emergency Triage Engine
- PriorityQueue-based patient prioritization
- Dynamic emergency scheduling
- Severity-based triage logic

## ICU Resource Allocation
- Dynamic ICU bed allocation
- Doctor assignment workflows
- Resource availability tracking

## Real-Time Overload Detection
- Sliding-window based surge monitoring
- Emergency overload alerts
- Critical patient load tracking

## REST APIs
- Emergency patient intake
- ICU allocation APIs
- Monitoring APIs
- Queue analytics

## Swagger Documentation
- Interactive API testing dashboard
- Professional API documentation

---

# DSA Concepts Used

| Concept | Usage |
|---|---|
| Priority Queue / Heap | Emergency patient prioritization |
| Queue Processing | Patient triage workflows |
| Sliding Window | Overload detection |
| Hash-based lookups | Resource tracking |

---

# Tech Stack

## Backend
- Java 17
- Spring Boot

## ORM
- Hibernate / JPA

## Database
- PostgreSQL

## API Testing & Documentation
- Swagger OpenAPI
- Postman

---

# Architecture

```text
                +----------------+
                |    Postman     |
                +-------+--------+
                        |
                        v
              +------------------+
              |   REST APIs      |
              | (Controllers)    |
              +--------+---------+
                       |
                       v
              +------------------+
              | Business Logic   |
              |   (Services)     |
              +--------+---------+
                       |
                       v
              +------------------+
              |  Repositories    |
              |   Spring Data    |
              +--------+---------+
                       |
                       v
              +------------------+
              |   PostgreSQL     |
              +------------------+

       Priority Queue + Monitoring Engine
```

---

# Project Structure

```text
src/main/java/com/vitalops/

├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── triage/
├── scheduler/
├── utils/
├── exception/
├── config/
└── VitalopsApplication.java
```

---

# Core APIs

## Patient APIs

### Add Emergency Patient
```http
POST /patients
```

### Get Highest Priority Patient
```http
GET /patients/critical
```

### Get Queue Size
```http
GET /patients/queue-size
```

---

## Resource Allocation APIs

### Allocate Doctor
```http
POST /allocate/doctor
```

### Allocate ICU Bed
```http
POST /allocate/icu
```

---

## Monitoring APIs

### Detect Overload
```http
GET /monitor/overload
```

### Get Critical Load
```http
GET /monitor/critical-load
```

---

# Example Patient Request

```json
{
  "name": "Rahul",
  "age": 72,
  "severity": 10,
  "department": "ICU",
  "status": "CRITICAL"
}
```

---

# Setup Instructions

## Clone Repository

```bash
git clone <repo-url>
```

---

## Configure PostgreSQL

Create database:

```sql
CREATE DATABASE vitalops;
```

---

## Update application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vitalops
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

---

## Run Application

```bash
.\mvnw.cmd spring-boot:run
```

---

# Swagger UI

Open:

```text
http://localhost:8080/swagger-ui/index.html
```

---
## Design Decisions

- Layered architecture for maintainability.
- PriorityQueue used for emergency patient scheduling.
- Repository pattern implemented through Spring Data JPA.
- PostgreSQL used for transactional persistence.
- Sliding window monitoring for overload detection.

---
# Future Enhancements

- Redis-based queue caching
- Authentication & authorization
- Docker deployment
- Kafka event streaming
- Graph-based patient dependency analysis
- Predictive emergency analytics
