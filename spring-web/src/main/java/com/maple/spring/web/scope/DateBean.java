package com.maple.spring.web.scope;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateBean {

    private final String name;
    private final String time;

    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    public DateBean(String name) {
        this.name = name;
        this.time = LocalDateTime.now(ZoneId.of("Asia/Shanghai")).format(DATE_FORMATTER);
    }

    public String info() {
        return name + " <-> " + time;
    }
}
