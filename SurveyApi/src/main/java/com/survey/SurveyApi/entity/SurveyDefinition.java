package com.survey.SurveyApi.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "SURVEY_DEFINITION")
public class SurveyDefinition extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a Z")
    @Column(name = "START_DT", insertable = true, updatable = false)
    private ZonedDateTime startDate;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a Z")
    @Column(name = "END_DT", insertable = true, updatable = true)
    private ZonedDateTime endDate;

    @Column(name = "THRESHOLD_COUNT")
    private Long thresholdCount;

    @Column(name = "COMPLETED_COUNT")
    private Long completedCount;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getThresholdCount() {
        return thresholdCount;
    }

    public void setThresholdCount(Long thresholdCount) {
        this.thresholdCount = thresholdCount;
    }

    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

}