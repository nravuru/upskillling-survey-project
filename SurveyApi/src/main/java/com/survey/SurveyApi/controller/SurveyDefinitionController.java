package com.survey.SurveyApi.controller;

import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.survey.SurveyApi.entity.SurveyDefinition;
import com.survey.SurveyApi.repository.SurveyDefinitionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surveyDefinitions")
public class SurveyDefinitionController extends AbstractController<SurveyDefinition> {

    @Autowired
    private SurveyDefinitionRepository sdRepository;

    @Override
    public JpaRepository<SurveyDefinition, Long> getRepository() {
        return sdRepository;
    }

    @PutMapping("/")
    public SurveyDefinition addSurveyDefinition(@RequestParam(required = true, name = "name") @NotBlank String name,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date endDate,
            @RequestParam(name = "thresholdCount", required = false) Long thresholdCount) {
        SurveyDefinition newSd = new SurveyDefinition();

        newSd.setName(name.toUpperCase());
        newSd.setStartDate(startDate.toInstant().atZone(ZoneId.systemDefault()));
        newSd.setStartDate(endDate.toInstant().atZone(ZoneId.systemDefault()));
        newSd.setThresholdCount(thresholdCount);

        return save(newSd);
    }

    @PostMapping("/")
    public SurveyDefinition updateSurveyDefinition(@RequestParam(name = "id", required = true) Long id,
            @RequestParam(name = "name", required = false) @NotBlank String name,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date endDate,
            @RequestParam(name = "thresholdCount", required = false) Long thresholdCount) {
        SurveyDefinition surveyDefinition = getById(id);

        if (null != surveyDefinition) {
            surveyDefinition.setName(name.toUpperCase());
            save(surveyDefinition);
        }

        return surveyDefinition;
    }

}