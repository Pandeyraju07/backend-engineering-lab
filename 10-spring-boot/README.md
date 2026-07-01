# Spring Boot Modules

One **standalone Spring Boot project per concept**. Import each subfolder separately in IntelliJ.

## Modules

| # | Folder | Topic |
|---|--------|-------|
| 01 | [01-first-project/](01-first-project/) | Hello World, project structure |
| 02 | [02-configuration/](02-configuration/) | Properties, YAML, @ConfigurationProperties |
| 03 | [03-profiles/](03-profiles/) | dev / staging / prod profiles |
| 04 | [04-validation/](04-validation/) | Bean Validation, custom validators |
| 05 | [05-global-exception/](05-global-exception/) | @ControllerAdvice, error responses |
| 06 | [06-file-upload/](06-file-upload/) | Multipart, storage |
| 07 | [07-pagination/](07-pagination/) | Pageable, sorting, filtering |
| 08 | [08-scheduler/](08-scheduler/) | @Scheduled, cron |
| 09 | [09-mail/](09-mail/) | Email templates |
| 10 | [10-swagger/](10-swagger/) | OpenAPI 3, SpringDoc |
| 11 | [11-actuator/](11-actuator/) | Health, metrics, info |
| 12 | [12-cache/](12-cache/) | @Cacheable, Redis |
| 13 | [13-async/](13-async/) | @Async, CompletableFuture |
| 14 | [14-logging/](14-logging/) | Logback, MDC, correlation ID |
| 15 | [15-production-config/](15-production-config/) | Production-ready defaults |

## Create a New Module

```bash
# Copy template
cp -r ../resources/templates/spring-boot-module/ 16-your-topic/
# Or on Windows:
xcopy /E /I ..\resources\templates\spring-boot-module 16-your-topic
```

Then customize `pom.xml` artifactId and main application class.

## Checklist (per module)

- [ ] Theory documented in README
- [ ] Runnable example with tests
- [ ] Production best practices noted
- [ ] Interview questions in README or `interview/`
