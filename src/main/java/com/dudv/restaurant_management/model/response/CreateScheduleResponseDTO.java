package com.dudv.restaurant_management.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class CreateScheduleResponseDTO {
    private Date startDate;
    private Date endDate;
    private String description;
    private Double percentageBonus;
    private Double deductionPercentage;
    private Integer status;
    private Integer personLimit;
}
