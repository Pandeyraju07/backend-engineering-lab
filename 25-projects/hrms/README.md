# HRMS Backend (Master Portfolio Project)

**Difficulty:** Intermediate → Expert  
**Recommended:** Upgrade this project weekly as you learn new topics.

## Modules (planned)

- [ ] Auth (JWT + RBAC)
- [ ] Employee management
- [ ] Attendance
- [ ] Leave management
- [ ] Payroll
- [ ] Notifications (RabbitMQ)
- [ ] Audit events (Kafka)
- [ ] Redis caching
- [ ] Reports & exports

## Tech Stack (target)

| Layer | Technology |
|-------|------------|
| API | Spring Boot 3, REST |
| Security | Spring Security, JWT |
| Database | PostgreSQL + Flyway |
| Cache | Redis |
| Messaging | RabbitMQ → Kafka |
| Containers | Docker, Kubernetes |
| Observability | Actuator, Prometheus, Grafana |

## Evolution

```
v1  Monolith CRUD
v2  Security
v3  Cache
v4  Messaging
v5  Microservices split
v6  Cloud deploy
```

Copy Spring Boot template to start:

```powershell
xcopy /E /I resources\templates\spring-boot-module 25-projects\hrms
```
