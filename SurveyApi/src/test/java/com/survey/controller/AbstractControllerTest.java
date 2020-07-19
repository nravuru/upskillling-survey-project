package com.survey.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.entity.AbstractEntity;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerTest<E extends AbstractEntity> {

    private static String BASIC_ADMIN_DIGEST_HEADER_VALUE = "Basic "
            + new String(Base64.getEncoder().encode(("admin@Test.com:pwd").getBytes()));

    private static String BASIC_USER_DIGEST_HEADER_VALUE = "Basic "
            + new String(Base64.getEncoder().encode(("user@Test.com:pwd").getBytes()));

    protected ObjectMapper mapper = new ObjectMapper();

    protected boolean authenticationEnabled = false;

    @LocalServerPort
    protected int port;
    @Autowired
    protected MockMvc mockMvc;

    protected abstract String getEndPointUrl();

    protected abstract boolean executeDeleteAll();

    protected abstract MultiValueMap<String, String> getAddRecordDetails();

    protected abstract MultiValueMap<String, String> getUpdateRecordDetails();

    private Class<E> entityClass;

    public AbstractControllerTest(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Test
    public void getAll() throws Exception {
        if (isAuthenticationEnabled()) {
            this.mockMvc
                    .perform(get(getEndPointUrl()).header(HttpHeaders.AUTHORIZATION, getBasicAdminDigestHeaderValue()))
                    .andDo(print()).andExpect(status().isOk());
        } else {
            this.mockMvc.perform(get(getEndPointUrl())).andDo(print()).andExpect(status().isOk());
        }
    }

    public E getById(Long id) throws Exception {
        E result = null;

       

        if (null != id) {
            MvcResult response = null;

            if (isAuthenticationEnabled()) {
                response = this.mockMvc
                        .perform(get(getEndPointUrl() + id.toString()).header(HttpHeaders.AUTHORIZATION,
                                getBasicAdminDigestHeaderValue()))
                        .andDo(print()).andExpect(status().isOk()).andReturn();
            } else {
                response = this.mockMvc.perform(get(getEndPointUrl() + id.toString())).andDo(print())
                        .andExpect(status().isOk()).andReturn();
            }

            result = mapper.readValue(response.getResponse().getContentAsString().getBytes(), getEntityClass());
        }

        return result;
    }

    public E add(MultiValueMap<String, String> addEntity) throws Exception {
        E result = null;

        if (addEntity != null && !addEntity.isEmpty()) {
            MvcResult response = null;

            if (isAuthenticationEnabled()) {
                response = this.mockMvc
                        .perform(put(getEndPointUrl())
                                .header(HttpHeaders.AUTHORIZATION, getBasicUserDigestHeaderValue()).params(addEntity))
                        .andDo(print()).andExpect(status().isOk()).andReturn();
            } else {
                response = this.mockMvc.perform(put(getEndPointUrl()).params(addEntity)).andDo(print()).andExpect(status().isOk()).andReturn();
            }

            result = mapper.readValue(response.getResponse().getContentAsString().getBytes(), getEntityClass());
        }

        return result;
    }

    @Test
    public void update() throws Exception {
        MultiValueMap<String, String> updateEntity = getUpdateRecordDetails();

        if (isAuthenticationEnabled()) {
            this.mockMvc.perform(post(getEndPointUrl())
                    .header(HttpHeaders.AUTHORIZATION, getBasicUserDigestHeaderValue()).params(updateEntity))
                    .andDo(print()).andExpect(status().isOk());
        } else {
            this.mockMvc.perform(post(getEndPointUrl()).params(updateEntity)).andDo(print()).andExpect(status().isOk());
        }
    }

    @Test
    public void deleteById() throws Exception {
        Long id = 123L;
        if (null != id) {
            if (isAuthenticationEnabled()) {
                this.mockMvc.perform(delete(getEndPointUrl() + id.toString()).header(HttpHeaders.AUTHORIZATION,
                        getBasicUserDigestHeaderValue())).andDo(print()).andExpect(status().isOk());
            } else {
                this.mockMvc.perform(delete(getEndPointUrl() + id.toString())).andDo(print())
                        .andExpect(status().isOk());
            }
        }
    }

    @Test
    public void deleteAll() throws Exception {
        if (isAuthenticationEnabled()) {
            this.mockMvc
                    .perform(
                            delete(getEndPointUrl()).header(HttpHeaders.AUTHORIZATION, getBasicUserDigestHeaderValue()))
                    .andDo(print()).andExpect(status().isOk());
        } else {
            this.mockMvc.perform(delete(getEndPointUrl())).andDo(print()).andExpect(status().isOk());
        }
    }

    protected String getBasicAdminDigestHeaderValue() {
        return BASIC_ADMIN_DIGEST_HEADER_VALUE;
    }

    protected String getBasicUserDigestHeaderValue() {
        return BASIC_USER_DIGEST_HEADER_VALUE;
    }

    public boolean isAuthenticationEnabled() {
        return authenticationEnabled;
    }

    protected Class<E> getEntityClass() {
        return entityClass;
    }
}