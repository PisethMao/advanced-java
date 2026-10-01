package com.piseth.localdatetimedemo.controller;

import com.piseth.localdatetimedemo.domain.Meeting;
import com.piseth.localdatetimedemo.dto.CreateMeetingRequest;
import com.piseth.localdatetimedemo.service.MeetingService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meetings")
public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meeting createMeeting(@Valid @RequestBody CreateMeetingRequest request) {
        return meetingService.createMeeting(request);
    }

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }
}
