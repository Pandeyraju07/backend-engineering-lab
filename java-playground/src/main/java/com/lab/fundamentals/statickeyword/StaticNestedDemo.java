package com.lab.fundamentals.statickeyword;

/**
 * Static nested class — IdFactory lives inside the demo without needing an outer instance.
 */
public class StaticNestedDemo {

    public static void main(String[] args) {
        IdFactory factory = defaultFactory();
        System.out.println(factory.create("CTR"));
    }

    static IdFactory defaultFactory() {
        return new IdFactory("HR");
    }

    static String createWithFactory(String prefix) {
        return defaultFactory().create(prefix);
    }

    /** Static nested id factory — no enclosing StaticNestedDemo instance required. */
    static class IdFactory {

        private final String tenant;

        IdFactory(String tenant) {
            this.tenant = tenant == null || tenant.isBlank() ? "HR" : tenant.trim();
        }

        String create(String prefix) {
            String safePrefix = prefix == null || prefix.isBlank() ? "EMP" : prefix.trim();
            return tenant + ":" + EmployeeIdGenerator.nextId(safePrefix);
        }

        String tenant() {
            return tenant;
        }
    }

    /** Alternate nested config holder for company-scoped defaults. */
    static class Config {

        private final String defaultPrefix;

        Config(String defaultPrefix) {
            this.defaultPrefix = defaultPrefix;
        }

        String defaultPrefix() {
            return defaultPrefix;
        }
    }

    static Config sampleConfig() {
        return new Config("EMP");
    }
}
