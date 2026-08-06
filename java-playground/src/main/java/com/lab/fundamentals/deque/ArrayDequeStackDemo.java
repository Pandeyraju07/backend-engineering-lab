package com.lab.fundamentals.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** ArrayDeque as stack — push/pop undo trail of HRMS admin actions. */
public class ArrayDequeStackDemo {

    public static void main(String[] args) {
        Deque<String> undo = newUndoStack();
        pushAction(undo, "UPDATE_SALARY:EMP-1");
        pushAction(undo, "APPROVE_LEAVE:LR-9");
        System.out.println("Undone: " + popUndo(undo));
        System.out.println("Peek next undo: " + peekUndo(undo));
    }

    static Deque<String> newUndoStack() {
        return new ArrayDeque<>();
    }

    static void pushAction(Deque<String> undoStack, String action) {
        undoStack.push(action);
    }

    static String popUndo(Deque<String> undoStack) {
        return undoStack.isEmpty() ? null : undoStack.pop();
    }

    static String peekUndo(Deque<String> undoStack) {
        return undoStack.peek();
    }

    static List<String> drainUndo(Deque<String> undoStack) {
        List<String> actions = new ArrayList<>();
        String next;
        while ((next = popUndo(undoStack)) != null) {
            actions.add(next);
        }
        return actions;
    }

    static int depth(Deque<String> undoStack) {
        return undoStack.size();
    }
}
