package com.dudv.restaurant_management.model.response;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class WorkManagementDTO {
    private Long id;

    private Date startDate;

    private Date endDate;

    private Double hourWage;

    private Integer personLimit;

    private Double percentageBonus;

    private Double deductionPercentage;
}
