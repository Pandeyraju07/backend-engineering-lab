# RabbitMQ Modules

| # | Folder | Pattern |
|---|--------|---------|
| 01 | [01-producer-consumer/](01-producer-consumer/) | Basic queue |
| 02 | [02-direct-exchange/](02-direct-exchange/) | Direct routing |
| 03 | [03-topic-exchange/](03-topic-exchange/) | Topic routing |
| 04 | [04-fanout/](04-fanout/) | Broadcast |
| 05 | [05-headers/](05-headers/) | Header-based routing |
| 06 | [06-delayed-message/](06-delayed-message/) | Delayed delivery |
| 07 | [07-dead-letter-queue/](07-dead-letter-queue/) | DLQ pattern |
| 08 | [08-retry/](08-retry/) | Retry with backoff |
| 09 | [09-priority-queue/](09-priority-queue/) | Priority messages |
| 10 | [10-production-patterns/](10-production-patterns/) | Idempotency, outbox |

Each module: Spring Boot + RabbitMQ via Docker Compose.

Template: [../resources/templates/spring-boot-module/](../resources/templates/spring-boot-module/)
