package com.lab.fundamentals.stack;

import java.util.List;
import java.util.Stack;

/**
 * HRMS approval workflow — legacy Stack push/pop plus nested-balance checks in one flow.
 */
public class StackDemo {

    public static void main(String[] args) {
        StackFlowResult result = runApprovalFlow(
                List.of("MANAGER", "HR", "FINANCE"),
                "((policy))",
                "[[HR][LEGAL]]"
        );
        System.out.println(result);
    }

    static StackFlowResult runApprovalFlow(
            List<String> steps,
            String policyExpression,
            String approvalTree
    ) {
        Stack<String> chain = StackPushPopDemo.newApprovalStack();
        for (String step : steps) {
            StackPushPopDemo.pushStep(chain, step);
        }

        String top = StackPushPopDemo.peekStep(chain);
        String lastPopped = StackPushPopDemo.popStep(chain);
        int remainingDepth = StackPushPopDemo.depth(chain);
        List<String> remaining = StackPushPopDemo.drainSteps(chain);

        boolean policyBalanced = StackBalanceDemo.isBalanced(policyExpression);
        int parenDepth = StackBalanceDemo.maxNestedDepth(policyExpression);
        int approvalDepth = StackBalanceDemo.nestedApprovalDepth(approvalTree);

        return new StackFlowResult(
                top,
                lastPopped,
                remainingDepth,
                remaining,
                policyBalanced,
                parenDepth,
                approvalDepth
        );
    }

    record StackFlowResult(
            String peekedTop,
            String lastPopped,
            int depthAfterPop,
            List<String> remainingSteps,
            boolean policyBalanced,
            int policyParenDepth,
            int nestedApprovalDepth
    ) {
        @Override
        public String toString() {
            return ("StackFlow{top=%s, popped=%s, depthAfterPop=%d, remaining=%s, "
                    + "policyBalanced=%b, parenDepth=%d, approvalDepth=%d}")
                    .formatted(peekedTop, lastPopped, depthAfterPop, remainingSteps,
                            policyBalanced, policyParenDepth, nestedApprovalDepth);
        }
    }
}
