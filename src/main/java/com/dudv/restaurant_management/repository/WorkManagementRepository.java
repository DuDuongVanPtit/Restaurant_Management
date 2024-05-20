package com.dudv.restaurant_management.repository;

import com.dudv.restaurant_management.entity.WorkManagementEntity;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WorkManagementRepository extends JpaRepository<WorkManagementEntity, Long> {
    WorkManagementEntity findByStartDateAndEndDate(Date startDate, Date endDate);
}
