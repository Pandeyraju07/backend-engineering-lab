package com.lab.fundamentals.stack;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackDemoTest {

    @Test
    void pushPopUsesLegacyStackLifo() {
        Stack<String> chain = StackPushPopDemo.newApprovalStack();
        StackPushPopDemo.pushStep(chain, "MANAGER");
        StackPushPopDemo.pushStep(chain, "HR");
        StackPushPopDemo.pushStep(chain, "FINANCE");

        assertEquals("FINANCE", StackPushPopDemo.peekStep(chain));
        assertEquals("FINANCE", StackPushPopDemo.popStep(chain));
        assertEquals(List.of("HR", "MANAGER"), StackPushPopDemo.drainSteps(chain));
    }

    @Test
    void balanceDetectsParenthesesAndApprovalDepth() {
        assertTrue(StackBalanceDemo.isBalanced("((A))"));
        assertFalse(StackBalanceDemo.isBalanced("((A)"));
        assertEquals(2, StackBalanceDemo.maxNestedDepth("(()())"));
        assertEquals(-1, StackBalanceDemo.maxNestedDepth("(()"));
        assertEquals(2, StackBalanceDemo.nestedApprovalDepth("[[HR][LEGAL]]"));
        assertEquals(-1, StackBalanceDemo.nestedApprovalDepth("[[HR]"));
    }

    @Test
    void approvalFlowIntegratesPushPopAndBalance() {
        StackDemo.StackFlowResult result = StackDemo.runApprovalFlow(
                List.of("MANAGER", "HR", "FINANCE"),
                "((policy))",
                "[[HR][LEGAL]]"
        );

        assertEquals("FINANCE", result.peekedTop());
        assertEquals("FINANCE", result.lastPopped());
        assertEquals(2, result.depthAfterPop());
        assertEquals(List.of("HR", "MANAGER"), result.remainingSteps());
        assertTrue(result.policyBalanced());
        assertEquals(2, result.policyParenDepth());
        assertEquals(2, result.nestedApprovalDepth());
    }
}
