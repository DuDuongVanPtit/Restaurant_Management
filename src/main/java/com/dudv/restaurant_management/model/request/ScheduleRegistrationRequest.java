package com.dudv.restaurant_management.model.request;

import lombok.Data;

@Data
public class ScheduleRegistrationRequest {
    private String day;
    private String shift;
    private String date;
    private String description;
}
