package com.dudv.restaurant_management.model.request.admin;

import lombok.Data;

@Data
public class CreateScheduleRequest {
    Double hourWage;
    Double bonusPercentage;
    Double deductionPercentage;
    Integer maxPerson;

    //week-startDate-endDate;
    String dateDescription;
}
