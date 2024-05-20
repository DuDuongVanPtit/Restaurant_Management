package com.dudv.restaurant_management.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_schedule")
public class WorkScheduleEntity extends BaseEntity{
    @Column(name = "work_date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "day")
    private String day;

    @Column(name = "shift")
    private String shift;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "work_management_id")
    private WorkManagementEntity workManagement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
