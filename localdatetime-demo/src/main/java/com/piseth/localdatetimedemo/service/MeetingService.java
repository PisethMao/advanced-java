package com.piseth.localdatetimedemo.service;

import com.piseth.localdatetimedemo.domain.Meeting;
import com.piseth.localdatetimedemo.dto.CreateMeetingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MeetingService {
    private final List<Meeting> meetings = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Meeting createMeeting(CreateMeetingRequest request) {
        LocalDateTime now = LocalDateTime.now();
        if (request.getStartDateTime().isBefore(now)) {
            throw new IllegalArgumentException("Meeting start date/time cannot be in the past");
        }
        if (!request.getEndDateTime().isAfter(request.getStartDateTime())) {
            throw new IllegalArgumentException("Meeting end date/time must be after start date/time");
        }
        Meeting meeting = new Meeting(
                idGenerator.getAndIncrement(),
                request.getTitle(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                now
        );
        meetings.add(meeting);
        return meeting;
    }

    public List<Meeting> getAllMeetings() {
        return meetings;
    }
}
