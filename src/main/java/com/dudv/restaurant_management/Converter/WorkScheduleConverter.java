package com.dudv.restaurant_management.Converter;

import com.dudv.restaurant_management.Utils.DateUtils;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import com.dudv.restaurant_management.model.request.ScheduleRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class WorkScheduleConverter {
    @Autowired
    private DateUtils dateUtils;

    public WorkScheduleEntity toWorkScheduleEntity(ScheduleRegistrationRequest scheduleRegistrationRequest) throws ParseException {
        WorkScheduleEntity workScheduleEntity = new WorkScheduleEntity();
        Date date = dateUtils.getDate1(scheduleRegistrationRequest.getDate());
        String description = scheduleRegistrationRequest.getDescription();
        workScheduleEntity.setDate(date);
        workScheduleEntity.setDescription(description);
        workScheduleEntity.setStatus(0);
        return workScheduleEntity;
    }
}
