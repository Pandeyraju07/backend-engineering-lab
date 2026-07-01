# 01 — First Spring Boot Project

**Goal:** Understand Spring Boot project layout, auto-configuration, and a minimal REST API.

## Topics

- [ ] Spring Initializr / Maven structure
- [ ] `@SpringBootApplication` and component scanning
- [ ] `application.yml` configuration
- [ ] REST controller + JSON response
- [ ] `@RestControllerAdvice` for errors
- [ ] Integration test with MockMvc

## Run

```bash
cd 10-spring-boot/01-first-project
mvn spring-boot:run
curl http://localhost:8080/api/v1/health
```

## Checklist

- [ ] App starts without errors
- [ ] Health endpoint returns 200
- [ ] Tests pass (`mvn test`)
- [ ] README updated with learnings

## Interview

- What does `@SpringBootApplication` include?
- How does Spring Boot auto-configuration work?
- Difference between `@Controller` and `@RestController`?
