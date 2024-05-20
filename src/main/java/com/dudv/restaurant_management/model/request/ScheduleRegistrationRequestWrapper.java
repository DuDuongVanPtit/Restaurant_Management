package com.dudv.restaurant_management.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleRegistrationRequestWrapper {
    private List<ScheduleRegistrationRequest> scheduleRegistrationRequests;
    private Long id;
}
