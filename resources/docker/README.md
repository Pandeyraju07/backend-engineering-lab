# Local Infrastructure

Docker Compose stacks for practicing messaging, caching, and databases locally.

## Stacks

| File | Services |
|------|----------|
| [docker-compose.dev.yml](docker-compose.dev.yml) | MySQL, Redis, RabbitMQ, MongoDB |
| [kafka-compose.yml](kafka-compose.yml) | Kafka + Zookeeper (or KRaft) |

## Usage

```bash
cd resources/docker
docker compose -f docker-compose.dev.yml up -d
docker compose -f docker-compose.dev.yml down
```

Default ports (do not commit credentials to git in real projects):

| Service | Port |
|---------|------|
| MySQL | 3306 |
| Redis | 6379 |
| RabbitMQ | 5672, 15672 (UI) |
| MongoDB | 27017 |
