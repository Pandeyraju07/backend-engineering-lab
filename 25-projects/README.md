# Portfolio Projects

Production-style applications that grow with your skills. **Upgrade one project weekly** instead of starting new CRUD apps every time.

## Recommended Master Project

**`hrms/`** — Human Resource Management System

Evolution path:

```
v1  Monolith + MySQL + REST
v2  Spring Security + JWT + RBAC
v3  Redis (employee cache, session)
v4  RabbitMQ (email/SMS notifications)
v5  Kafka (audit events, payroll pipeline)
v6  Docker + Docker Compose
v7  Kubernetes manifests
v8  Spring Cloud (Gateway, Config, Discovery)
v9  Observability stack
v10 Sharding / read replicas (system design)
```

## All Projects

| Folder | Difficulty | Stack focus |
|--------|------------|-------------|
| [employee-management/](employee-management/) | Beginner | CRUD, validation, MySQL |
| [hrms/](hrms/) | Intermediate → Expert | Full enterprise stack |
| [loan-management/](loan-management/) | Intermediate | Transactions, workflows |
| [expense-management/](expense-management/) | Intermediate | Approval flows, reporting |
| [banking-system/](banking-system/) | Intermediate | ACID, security |
| [prepaid-card-system/](prepaid-card-system/) | Intermediate | Payments, ledger |
| [e-commerce/](e-commerce/) | Intermediate | Inventory, orders |
| [inventory-system/](inventory-system/) | Intermediate | Stock, reservations |
| [notification-service/](notification-service/) | Advanced | Kafka/RabbitMQ, templates |
| [food-delivery/](food-delivery/) | Advanced | Geo, dispatch, real-time |

## Each Project Should Include

- [ ] README with setup instructions
- [ ] OpenAPI / Swagger docs
- [ ] Dockerfile + docker-compose.yml
- [ ] Unit + integration tests
- [ ] Structured logging + correlation ID
- [ ] Health checks (Actuator)
- [ ] Database migrations (Flyway/Liquibase)

## Project README Template

See [../resources/templates/project-readme.md](../resources/templates/project-readme.md)
