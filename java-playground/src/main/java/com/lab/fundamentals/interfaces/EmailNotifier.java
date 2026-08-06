package com.lab.fundamentals.interfaces;

/** Email channel implementation of Notifiable. */
class EmailNotifier implements Notifiable {

    private final String recipient;

    EmailNotifier(String recipient) {
        this.recipient = recipient;
    }

    String recipient() {
        return recipient;
    }

    @Override
    public String channel() {
        return "EMAIL";
    }

    @Override
    public String notify(String message) {
        return "EMAIL→%s: %s".formatted(recipient, message);
    }
}
