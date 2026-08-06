package com.lab.fundamentals.interfaces;

/** HRMS notification contract. */
interface Notifiable {

    String notify(String message);

    String channel();
}
