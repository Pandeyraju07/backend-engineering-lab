package com.lab.fundamentals.statickeyword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticKeywordDemoTest {

    @BeforeEach
    void resetGenerator() {
        StaticFieldDemo.reset();
    }

    @Test
    void staticFieldCounterIssuesSequentialIds() {
        assertEquals(0, StaticFieldDemo.currentCount());
        assertEquals("EMP-0001", StaticFieldDemo.nextId());
        assertEquals("EMP-0002", StaticFieldDemo.nextId());
        assertEquals(2, StaticFieldDemo.currentCount());
    }

    @Test
    void staticBlockSetsCompanyNameOnce() {
        assertEquals("Acme HRMS Labs", StaticBlockDemo.companyName());
        assertEquals("Acme HRMS Labs/EMP-0001", StaticBlockDemo.brandedId("EMP-0001"));
    }

    @Test
    void staticNestedFactoryCreatesTenantScopedIds() {
        StaticNestedDemo.IdFactory factory = StaticNestedDemo.defaultFactory();

        assertEquals("HR", factory.tenant());
        assertEquals("HR:CTR-0001", factory.create("CTR"));
        assertEquals("EMP", StaticNestedDemo.sampleConfig().defaultPrefix());
    }

    @Test
    void runStaticFlowIntegratesFieldBlockAndNested() {
        StaticKeywordDemo.StaticFlowResult result = StaticKeywordDemo.runStaticFlow();

        assertEquals("EMP-0001", result.firstId());
        assertEquals("EMP-0002", result.secondId());
        assertEquals(2, result.issuedCount());
        assertEquals("Acme HRMS Labs", result.companyName());
        assertEquals("Acme HRMS Labs/EMP-0001", result.brandedFirstId());
        assertTrue(result.nestedFactoryId().startsWith("HR:CTR-"));
        assertEquals("HR", result.factoryTenant());
        assertEquals("EMP", result.configPrefix());
    }
}
