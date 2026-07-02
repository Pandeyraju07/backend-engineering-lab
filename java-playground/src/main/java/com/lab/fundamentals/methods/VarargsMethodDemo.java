package com.lab.fundamentals.methods;

import java.util.ArrayList;
import java.util.List;

/** Varargs methods — flexible number of arguments (bulk HRMS operations). */
public class VarargsMethodDemo {

    public static void main(String[] args) {
        double totalBonus = distributeBonus(2_000, "EMP-1", "EMP-2", "EMP-3");
        List<String> channels = sendNotifications("Welcome to HRMS", "EMAIL", "SMS", "PUSH");

        System.out.println("Varargs: totalBonus=" + totalBonus);
        System.out.println("Varargs: notifications=" + channels);
    }

    static double distributeBonus(double amount, String... employeeIds) {
        if (employeeIds.length == 0 || amount <= 0) {
            return 0;
        }
        return amount * employeeIds.length;
    }

    static List<String> sendNotifications(String message, String... channels) {
        List<String> logs = new ArrayList<>(channels.length);
        for (String channel : channels) {
            logs.add("Sent [" + channel + "]: " + message);
        }
        return logs;
    }
}
