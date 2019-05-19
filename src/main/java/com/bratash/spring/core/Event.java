package com.bratash.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    int id;
    String msg = "Hello";
    Date date;
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        Random random = new Random();
        id = random.nextInt();
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + getId() +
                ", msg='" + getMsg() + '\'' +
                ", date=" + dateFormat.format(date) +
                '}' + "\n";
    }
}
