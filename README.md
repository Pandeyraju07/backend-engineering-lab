# Backend Engineering Lab

Enterprise-grade learning workspace for **Java + Spring Boot + Microservices + System Design**.

> One repository. Structured practice. Production mindset.

## Quick Start

| What | Where |
|------|-------|
| Track progress | [ROADMAP.md](ROADMAP.md) |
| Daily learning log | [LEARNING_LOG.md](LEARNING_LOG.md) |
| Interview prep | [INTERVIEW_NOTES.md](INTERVIEW_NOTES.md) |
| Architecture decisions | [ARCHITECTURE.md](ARCHITECTURE.md) |
| Java-only code | [java-playground/](java-playground/) |
| Full applications | [25-projects/](25-projects/) |

## Repository Map

```
backend-engineering-lab/
├── java-playground/          # Single Maven project — Java core, collections, concurrency, patterns
├── 01-java-fundamentals/     # Phase 1 — basics, OOP, collections, Java 8+
├── 02-java-advanced/         # Phase 2 — multithreading, JVM, web tech, testing
├── 03-design-patterns/       # Creational, structural, behavioral
├── 04-jvm-internals/         # Memory, GC, class loading, tuning
├── 05-data-structures/       # Collections deep dive, trees, graphs
├── 06-algorithms/            # Sorting, searching, DP
├── 07-sql/                   # Scripts, optimization, transactions
├── 08-mongodb/               # NoSQL practice
├── 09-spring-core/           # IoC, DI, MVC, AOP
├── 10-spring-boot/           # One Spring Boot app per concept (01–15)
├── 11-rest-api/              # HTTP, status codes, REST best practices
├── 12-spring-security/       # Auth, JWT, OAuth2 (01–10)
├── 13-testing/               # JUnit, Mockito, TestContainers
├── 14-redis/                 # Caching patterns
├── 15-rabbitmq/              # Exchanges, DLQ, production patterns (01–10)
├── 16-kafka/                 # Producer, consumer, streams (01–10)
├── 17-microservices/         # Spring Cloud, patterns
├── 18-docker/                # Dockerfile, Compose, multi-stage
├── 19-kubernetes/            # Manifests, Helm
├── 20-cloud/                 # AWS, Azure, GCP
├── 21-system-design/         # HLD practice problems
├── 22-low-level-design/      # LLD practice (parking lot, elevator, etc.)
├── 23-performance/           # JVM, SQL, load testing, profiling
├── 24-observability/         # Logging, metrics, tracing
├── 25-projects/              # Portfolio-grade applications
├── notes/                    # Topic-wise knowledge base
├── diagrams/                 # Architecture & sequence diagrams
├── interview/                # Question banks by topic
└── resources/                # Books, courses, official docs links
```

## How Each Module Works

Every numbered folder follows the same enterprise learning pattern:

```
<module>/
├── README.md           # Goals, checklist, resources
├── theory/             # Concepts & notes
├── examples/           # Runnable demos
├── exercises/          # Hands-on tasks
├── projects/           # Mini projects (where applicable)
├── interview/          # Q&A for this topic
├── best-practices/     # Production guidelines
├── pitfalls/           # Common mistakes
└── performance/        # Optimization notes
```

### Spring Boot & Security Modules

Folders like `10-spring-boot/` and `12-spring-security/` contain **one standalone Spring Boot project per concept**. Each subfolder (e.g. `03-jwt-authentication/`) is its own Maven project — import individually in IntelliJ.

### Java Playground

Use `java-playground/` for language features without Spring overhead:

```
java-playground/src/main/java/com/lab/
├── java/           # Basics, OOP, exceptions
├── collections/    # List, Set, Map demos
├── streams/        # Stream API, Optional
├── concurrency/    # Threads, ExecutorService, CompletableFuture
├── patterns/       # Design pattern implementations
├── jvm/            # Memory & GC experiments
└── interview/      # Common coding problems
```

Run from `java-playground/`:

```bash
mvn clean test
mvn exec:java -Dexec.mainClass="com.lab.collections.HashMapDemo"
```

## Learning Workflow (Enterprise Approach)

For every topic, go through **8 steps** — don't stop at theory:

1. **Theory** — What problem does it solve?
2. **Code** — Implement in `examples/` or `java-playground/`
3. **Apply** — Use it in a `25-projects/` feature
4. **Read docs** — Official documentation, not just blogs
5. **Production patterns** — Cache aside, retry, circuit breaker, etc.
6. **Interview** — Document in `interview/` or `notes/`
7. **Performance** — Measure latency, memory, throughput
8. **Project** — Ship something real

### Weekly Cycle

| Day | Focus |
|-----|-------|
| Mon | Theory |
| Tue | Coding |
| Wed | Build / extend project |
| Thu | Read production / open-source code |
| Fri | Optimize & debug |
| Sat | Interview questions |
| Sun | Revision & notes |

## Priority for Experienced Developers (15+ months)

Skip beginner tutorials. Focus on gaps:

| Priority | Topics |
|----------|--------|
| **P0** | JVM, concurrency, SQL optimization, Spring internals, JWT/OAuth2, Redis, testing |
| **P1** | Kafka, RabbitMQ advanced, Docker, K8s, Spring Cloud, observability |
| **P2** | System design (HLD/LLD), cloud architecture, performance tuning |

## Portfolio Projects

Build one system and **upgrade it weekly** instead of 20 CRUD apps:

```
25-projects/hrms/  →  auth → modules → RabbitMQ → Redis → Kafka → Docker → K8s → AWS
```

See [25-projects/README.md](25-projects/README.md) for the full project list.

## Skill Dashboard

Update weekly in [ROADMAP.md](ROADMAP.md):

| Area | Progress |
|------|----------|
| Java Fundamentals | ☐ 0% |
| Advanced Java | ☐ 0% |
| Spring Framework | ☐ 0% |
| Spring Boot | ☐ 0% |
| REST APIs | ☐ 0% |
| Database | ☐ 0% |
| Security | ☐ 0% |
| Microservices | ☐ 0% |
| DevOps | ☐ 0% |
| System Design | ☐ 0% |
| Observability | ☐ 0% |

## Timeline

| Pace | Duration |
|------|----------|
| Part-time (2–3 hrs/day) | 8–10 months |
| Full-time (6–8 hrs/day) | 4–5 months |

---

**Measure progress by production capabilities**, not checkboxes checked.
Example: *"I can build a secure auth service with JWT, Redis cache, RabbitMQ events, tests, and observability."*
