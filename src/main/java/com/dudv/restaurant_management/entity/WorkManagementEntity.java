package com.dudv.restaurant_management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_management")
public class WorkManagementEntity extends BaseEntity{
    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "hour_wage")
    private Double hourWage;

    @Column(name = "person_limit")
    private Integer personLimit;

    @Column(name = "bonus_percentage")
    private Double percentageBonus;

    @Column(name = "deduction_percentage")
    private Double deductionPercentage;

    @Column(name = "status")
    private Integer status = 0;

    @OneToMany(mappedBy = "workManagement", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<WorkScheduleEntity> workScheduleEntities = new ArrayList<>();
}
