# Spring Security Modules

One Spring Boot project per security concept.

| # | Folder | Topic |
|---|--------|-------|
| 01 | [01-basic-auth/](01-basic-auth/) | HTTP Basic Authentication |
| 02 | [02-form-login/](02-form-login/) | Form-based login |
| 03 | [03-jwt-authentication/](03-jwt-authentication/) | JWT access tokens |
| 04 | [04-role-based-auth/](04-role-based-auth/) | Roles & permissions |
| 05 | [05-refresh-token/](05-refresh-token/) | Refresh token rotation |
| 06 | [06-oauth2-google/](06-oauth2-google/) | OAuth2 with Google |
| 07 | [07-oauth2-github/](07-oauth2-github/) | OAuth2 with GitHub |
| 08 | [08-method-security/](08-method-security/) | @PreAuthorize, @Secured |
| 09 | [09-custom-filter/](09-custom-filter/) | Custom security filters |
| 10 | [10-production-security/](10-production-security/) | CORS, CSRF, headers, rate limit |

## Enterprise Focus

For each module, understand:

- **What** — feature behavior
- **Why** — threat model / use case
- **How** — filter chain, token flow
- **When not to use** — trade-offs

Copy template from [../resources/templates/spring-boot-module/](../resources/templates/spring-boot-module/).
