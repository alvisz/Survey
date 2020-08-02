package com.alviszalamans.survey;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.alviszalamans.survey.data.entity.Application;
import com.alviszalamans.survey.data.repository.ApplicationRepository;
import com.alviszalamans.survey.web.controllers.SurveyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig.class)
class SurveyWebControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SurveyController surveyController;

    @Autowired
    private ApplicationRepository applicationRepository;


    @Test
    public void TestIfPageLoads() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("survey"));
    }

    @Test
    void contextLoads() {
        assertThat(surveyController).isNotNull();
    }

    @Test
    public void shouldNotSubmitBecauseNameIsTooShort() throws Exception {
        this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","No") // Name should always be firstName+LastName
                .param("sectors","1,2,3")
                .param("terms", "true")).andExpect(content().string(containsString("Your name must be at least 5 characters long")));
    }

    @Test
    public void shouldNotSubmitBecauseNoSectorsSelected() throws Exception {
        this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","Vasya Krasavchik")
                .param("sectors","")
                .param("terms", "true")).andExpect(content().string(containsString("Please pick 1 to 5 sectors")));
    }

    @Test
    public void shouldNotSubmitBecauseTooManySectorsSelected() throws Exception {
        this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","Vasya Krasavchik")
                .param("sectors","1,2,3,4,5,6")
                .param("terms", "true")).andExpect(content().string(containsString("Please pick 1 to 5 sectors")));
    }

    @Test
    public void shouldNotSubmitBecauseTermsNotAccepted() throws Exception {
        this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","Vasya Krasavchik")
                .param("sectors","1,2,3,4")
                .param("terms", "false")).andExpect(content().string(containsString("Please agree to terms")));
    }

    @Test
    public void shouldSubmitTheFormSuccessfully() throws Exception {
        this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","Vasya Krasavchik")
                .param("sectors","1,2,3,4")
                .param("terms", "true")).andExpect(content().string(containsString("Your answer has been submitted.")));
    }

    @Test
    public void shouldReturnFormWithDataSubmitted() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/").sessionAttr("id",0L)
                .param("fullName","Vasya Krasavchik")
                .param("sectors","19,18")
                .param("terms", "true"))
                .andExpect(content().string(containsString("Your answer has been submitted.")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Vasya Krasavchik")));
    }


    @Test
    public void shouldReturnDefaultMessage() throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Please enter your name")));
    }

    @Test
    public void shouldAddApplicationToDb(){
        Application testApp = new Application();
        testApp.setFullName("Test person");
        testApp.setSectors(new int[]{19,18});
        testApp.setTerms(true);
        Long id = applicationRepository.save(testApp).getResultId();

        assertThat(id).isNotNull();

        Optional<Application> findApp = applicationRepository.findById(id);

        assertThat(findApp).isNotEmpty();
    }

}
