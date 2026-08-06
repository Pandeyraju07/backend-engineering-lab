package com.lab.fundamentals.statickeyword;

/**
 * HRMS static-keyword lesson — shared counter, static block, and nested factory in one flow.
 */
public class StaticKeywordDemo {

    public static void main(String[] args) {
        StaticFlowResult result = runStaticFlow();
        System.out.println(result);
    }

    static StaticFlowResult runStaticFlow() {
        StaticFieldDemo.reset();

        String firstId = StaticFieldDemo.nextId();
        String secondId = StaticFieldDemo.nextId();
        int issuedCount = StaticFieldDemo.currentCount();

        String company = StaticBlockDemo.companyName();
        String branded = StaticBlockDemo.brandedId(firstId);

        StaticNestedDemo.IdFactory factory = StaticNestedDemo.defaultFactory();
        String nestedId = factory.create("CTR");
        String configPrefix = StaticNestedDemo.sampleConfig().defaultPrefix();

        return new StaticFlowResult(
                firstId,
                secondId,
                issuedCount,
                company,
                branded,
                nestedId,
                factory.tenant(),
                configPrefix
        );
    }

    record StaticFlowResult(
            String firstId,
            String secondId,
            int issuedCount,
            String companyName,
            String brandedFirstId,
            String nestedFactoryId,
            String factoryTenant,
            String configPrefix
    ) {
        @Override
        public String toString() {
            return ("StaticFlowResult{first=%s, second=%s, count=%d, company=%s, "
                    + "branded=%s, nested=%s, tenant=%s, prefix=%s}")
                    .formatted(firstId, secondId, issuedCount, companyName,
                            brandedFirstId, nestedFactoryId, factoryTenant, configPrefix);
        }
    }
}
