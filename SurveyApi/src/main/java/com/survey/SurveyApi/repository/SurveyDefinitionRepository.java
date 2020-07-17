package com.survey.SurveyApi.repository;


import com.survey.SurveyApi.entity.SurveyDefinition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDefinitionRepository extends JpaRepository<SurveyDefinition, Long> {
    public SurveyDefinition findByName(String name);
}