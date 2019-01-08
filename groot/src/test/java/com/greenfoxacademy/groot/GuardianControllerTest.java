package com.greenfoxacademy.groot;


import com.greenfoxacademy.groot.Controller.GuardianController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGroot_withInput() throws Exception{
        this.mockMvc.perform(get("/groot?message=somemessage"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.translated", is("I am Groot!")))
            .andExpect(jsonPath("$.received", is("somemessage")));
    }

    @Test
    public void getGroot_withoutInput() throws Exception{
        this.mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("I am Groot!")));
    }



    @Test
    public void getYondu_withInput() throws Exception{
        this.mockMvc.perform(get("/yondu?distance=100.0&time=10.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed", is(10.0)));
    }

    @Test
    public void getYondu_withZeroTimeInput() throws Exception{
        this.mockMvc.perform(get("/yondu?distance=1.0&time=0.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed", is("Infinity")));
    }

    @Test
    public void getYondu_withZeroDistanceInput() throws Exception{
        this.mockMvc.perform(get("/yondu?distance=0.0&time=1.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed", is(0.0)));
    }

    @Test
    public void getYondu_withZeroInputs() throws Exception{
        this.mockMvc.perform(get("/yondu?distance=0.0&time=0.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed", is("NaN")));
    }

    @Test
    public void getYondu_withNoTime() throws Exception{
        this.mockMvc.perform(get("/yondu?distance=0.0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide the distance and the time!")));
    }

    @Test
    public void getYondu_withNoDistance() throws Exception{
        this.mockMvc.perform(get("/yondu?time=0.0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide the distance and the time!")));
    }

    @Test
    public void getYondu_withNoInputs() throws Exception{
        this.mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide the distance and the time!")));
    }
}
