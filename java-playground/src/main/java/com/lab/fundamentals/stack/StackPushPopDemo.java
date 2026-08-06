package com.lab.fundamentals.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Legacy java.util.Stack push/pop — approval chain breadcrumbs (teaching demo). */
public class StackPushPopDemo {

    public static void main(String[] args) {
        Stack<String> approvals = newApprovalStack();
        pushStep(approvals, "MANAGER");
        pushStep(approvals, "HR");
        pushStep(approvals, "FINANCE");
        System.out.println("Pop: " + popStep(approvals));
        System.out.println("Peek: " + peekStep(approvals));
    }

    static Stack<String> newApprovalStack() {
        return new Stack<>();
    }

    static String pushStep(Stack<String> stack, String step) {
        return stack.push(step);
    }

    static String popStep(Stack<String> stack) {
        return stack.isEmpty() ? null : stack.pop();
    }

    static String peekStep(Stack<String> stack) {
        return stack.isEmpty() ? null : stack.peek();
    }

    static List<String> drainSteps(Stack<String> stack) {
        List<String> steps = new ArrayList<>();
        String next;
        while ((next = popStep(stack)) != null) {
            steps.add(next);
        }
        return steps;
    }

    static int depth(Stack<String> stack) {
        return stack.size();
    }
}
