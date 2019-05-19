package com.bratash.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLogger eventLogger;
    Event event;
    FileEventLogger fileEventLogger;

    public App(
            Client client,
            ConsoleEventLogger eventLogger,
            Event event,
            FileEventLogger fileEventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event = event;
        this.fileEventLogger = fileEventLogger;

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App)applicationContext.getBean("app");
        app.eventLogger.logEvent(app.event);
        app.fileEventLogger.logEvent(app.event);
    }
}
