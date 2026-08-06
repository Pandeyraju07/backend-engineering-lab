package com.lab.fundamentals.stack;

import java.util.Stack;

/**
 * Stack balance — parentheses in policy expressions, plus nested approval depth counting.
 */
public class StackBalanceDemo {

    public static void main(String[] args) {
        System.out.println("Balanced ((A)): " + isBalanced("((A))"));
        System.out.println("Max nested depth (()()): " + maxNestedDepth("(()())"));
        System.out.println("Approval depth: " + nestedApprovalDepth("[[HR][LEGAL]]"));
    }

    /** True when (), [], {} are correctly nested/balanced. */
    static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /** Maximum nesting depth of parentheses only; returns -1 if unbalanced. */
    static int maxNestedDepth(String expression) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? maxDepth : -1;
    }

    /**
     * Nested approval brackets like {@code [[HR][LEGAL]]} — returns max bracket depth,
     * or -1 when brackets are unbalanced.
     */
    static int nestedApprovalDepth(String approvalTree) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < approvalTree.length(); i++) {
            char ch = approvalTree.charAt(i);
            if (ch == '[') {
                stack.push(ch);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (ch == ']') {
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? maxDepth : -1;
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
