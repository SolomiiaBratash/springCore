package com.bratash.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLogger eventLogger;
    Event event;
    FileEventLogger fileEventLogger;
    CacheFileEventLogger cacheFileEventLogger;

    public App(
            Client client,
            ConsoleEventLogger eventLogger,
            Event event,
            FileEventLogger fileEventLogger,
            CacheFileEventLogger cacheFileEventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event = event;
        this.fileEventLogger = fileEventLogger;
        this.cacheFileEventLogger = cacheFileEventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
        App app = (App)configurableApplicationContext.getBean("app");
        for(int i = 0; i < 15; i++){
            app.cacheFileEventLogger.logEvent(app.event);
        }
        configurableApplicationContext.close();
    }
}
