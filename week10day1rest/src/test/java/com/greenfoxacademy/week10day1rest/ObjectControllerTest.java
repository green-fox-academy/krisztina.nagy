package com.greenfoxacademy.week10day1rest;

import com.greenfoxacademy.week10day1rest.controller.ObjectController;
import com.greenfoxacademy.week10day1rest.repository.LogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ObjectController.class)
public class ObjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LogServiceImpl mockIdServiceImpl;

    @Test
    public void testGetDoubleError() throws Exception {
        this.mockMvc.perform(get("/doubling"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error", is("Please provide an input!")));

    }

    @Test
    public void testGetDoubleOk() throws Exception {
        this.mockMvc.perform(get("/doubling?input=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result", is(10)))
            .andExpect(jsonPath("$.received", is(5)));
    }
    
}
