package com.piseth.localdatetimedemo.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Meeting {
    private final Long id;
    private final String title;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final LocalDateTime createdAt;

    public Meeting(
            Long id,
            String title,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createdAt = createdAt;
    }

}
