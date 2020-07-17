package com.survey.SurveyApi.controller;

import com.survey.SurveyApi.entity.SurveyDefinition;

import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class SurveyDefinitionControllerTest extends AbstractControllerTest<SurveyDefinition> {

    public SurveyDefinitionControllerTest() {
        super(SurveyDefinition.class);
    }

    private static String URL = "/surveyDefinitions/";

    @Override
    protected String getEndPointUrl() {
        return URL;
    }

    @Test
    public void add() throws Exception {
       MultiValueMap<String, String> addEntity = getAddRecordDetails();
       SurveyDefinition newRecord = add(addEntity);
       System.out.println("New Servey Definition: " + newRecord);
        
    }

    @Override
    protected MultiValueMap<String, String> getAddRecordDetails() {
        MultiValueMap<String, String> addSd = new LinkedMultiValueMap<>();

        addSd.add("name", "New Survey");

        return addSd;
    }

    @Override
    protected MultiValueMap<String, String> getUpdateRecordDetails() {
        MultiValueMap<String, String> updateRole = new LinkedMultiValueMap<>();

        updateRole.add("id", "3");
        updateRole.add("name", "updatedRole");

        return updateRole;
    }

    @Override
    protected boolean executeDeleteAll() {
        return Boolean.TRUE;
    }

    @Test
    public void testRun() {
        System.out.println("Test Running...");
    }

    @Test
    public void getAll() throws Exception {
            super.getAll();
    }
}