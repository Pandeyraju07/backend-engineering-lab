# Spring Boot Module Template

Copy this entire folder when creating a new Spring Boot learning module.

```powershell
# Example: create first Spring Boot project
xcopy /E /I resources\templates\spring-boot-module 10-spring-boot\01-first-project
```

Then update:
1. `pom.xml` → `artifactId`, `name`, `description`
2. Rename package `com.lab.template` → e.g. `com.lab.springboot.firstproject`
3. Rename `TemplateApplication.java` → e.g. `FirstProjectApplication.java`
4. Add module-specific README with theory + checklist

## Included

- Spring Web + Validation
- Sample REST controller
- Global exception handler stub
- `application.yml` with sensible defaults
- Basic integration test
