# Architecture Guide

How this lab is organized and how to extend it with new modules.

## Principles

1. **One concept per Spring Boot project** — avoids config conflicts
2. **One Maven project for pure Java** — `java-playground/` for language features
3. **Consistent folder layout** — every module has theory → examples → exercises → interview
4. **Projects accumulate complexity** — upgrade `25-projects/hrms/` instead of starting over

## Adding a New Spring Boot Module

1. Copy template from `resources/templates/spring-boot-module/`
2. Place under the correct numbered folder (e.g. `10-spring-boot/16-new-topic/`)
3. Update the module README checklist
4. Log progress in `LEARNING_LOG.md`

## Adding Java Examples

Place classes under `java-playground/src/main/java/com/lab/<package>/`:

| Package | Purpose |
|---------|---------|
| `com.lab.java` | Basics, OOP, exceptions |
| `com.lab.collections` | Collection framework demos |
| `com.lab.streams` | Stream API, Optional |
| `com.lab.concurrency` | Threads, executors |
| `com.lab.patterns` | Design patterns |
| `com.lab.jvm` | Memory experiments |
| `com.lab.interview` | Coding problems |

## System Design Module Structure

Each problem in `21-system-design/<name>/`:

```
requirements.md    # Functional & non-functional requirements
api.md             # REST API design
database.sql       # Schema
hld.md             # High-level design (components, data flow)
lld.md             # Class design, patterns
sequence.md        # Key flows
notes.md           # Trade-offs, scaling, failure modes
```

## Portfolio Project Evolution

Recommended upgrade path for `25-projects/hrms/`:

```
v1  Monolith CRUD + MySQL
v2  Spring Security + JWT
v3  Redis caching
v4  RabbitMQ notifications
v5  Kafka event streaming
v6  Docker + Docker Compose
v7  Kubernetes deployment
v8  Spring Cloud (Gateway, Config, Discovery)
v9  Observability (Prometheus, Grafana, OpenTelemetry)
v10 Multi-region / sharding (system design exercise)
```

## Naming Conventions

- Folders: `kebab-case` with numeric prefix for ordering
- Java packages: `com.lab.<topic>`
- Spring Boot apps: `com.lab.<module>.<concept>` (e.g. `com.lab.security.jwt`)
- Commits: `feat(10-spring-boot): add profile-based configuration demo`
