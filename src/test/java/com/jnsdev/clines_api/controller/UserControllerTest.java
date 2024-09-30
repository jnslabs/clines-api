package com.jnsdev.clines_api.controller;

import com.jnsdev.clines_api.repository.Entity.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 16:26
 */
@SpringBootTest
@TestPropertySource(properties = {"DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

    @AfterEach
    public void setup() {
        entityManager.clear();
    }

    @Test
    void shouldCreateByReturnLong() throws Exception {
        var json = "{\"name\": \"fulano\", \"email\": \"fulano@email.com\", \"password\": \"123456\"}";

        mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", Matchers.matchesPattern("/users/\\d+")))
                .andExpect(jsonPath("$.name").value("fulano"))
                .andExpect(jsonPath("$.email").value("fulano@email.com"));
    }

    @Test
    void shouldReturnAnUserById() throws Exception {
        var user = new User("fulano", "fulano@email.com", "123456");

        User persisted = entityManager.persistAndFlush(user);

        mockMvc.perform(get("/users/" + persisted.getId()))
                .andExpect(status().isOk()).andDo(log())
                .andExpect(jsonPath("$.name", equalTo(user.getName())))
                .andExpect(jsonPath("$.email", equalTo(user.getEmail())));
    }


    @Test
    void shouldReturn404WhenNotExistUserById() throws Exception {
        mockMvc.perform(get("/users/999")).andExpect(status().isNotFound());
    }

}
