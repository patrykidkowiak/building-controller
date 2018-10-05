package com.building.controller.conversion.controller;

import com.building.controller.aop.ApplicationErrorHandler;
import com.building.controller.controller.HomeController;
import com.building.controller.exception.HomeNotFoundException;
import com.building.controller.model.ApplicationUser;
import com.building.controller.model.Home;
import com.building.controller.service.HomeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    @MockBean
    private HomeService homeService;

    private MockMvc mockMvc;

    private List<Home> homes;

    @Before
    public void initHomes() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc =
                MockMvcBuilders.standaloneSetup(homeController)
                        .setControllerAdvice(new ApplicationErrorHandler())
                        .build();

        ApplicationUser user = new ApplicationUser();
        user.setId(1L);


        homes = new ArrayList<>();
        Home home1 = new Home();
        home1.setId(1L);
        home1.setHomeName("HOME1");
        home1.setUser(user);
        homes.add(home1);

        Home home2 = new Home();
        home2.setId(2L);
        home2.setHomeName("HOME2");
        home2.setUser(user);
        homes.add(home2);
    }

    @Test
    public void should_return_owner_by_id() throws Exception {
        given(homeService.findHomeById(1)).willReturn(homes.get(0));

        mockMvc
                .perform(get("/api/v1/home/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.homeName").value("HOME1"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_error_when_home_not_found() throws Exception {
        given(homeService.findHomeById(Mockito.anyLong())).willThrow(HomeNotFoundException.class);
        mockMvc.perform(get("/api/v1/home/21")).andExpect(status().isNotFound());
    }

    @Test
    public void should_return_bad_request_when_id_is_not_a_number() throws Exception {
        mockMvc.perform(get("/api/v1/home/this-is-not-a-number")).andExpect(status().isBadRequest());
    }


    @Test
    public void should_create_home() throws Exception {
        Home home= homes.get(0);
        home.setId(null);
        ObjectMapper objectMapper = new ObjectMapper();
        String ownerAsJson = objectMapper.writeValueAsString(home);
        mockMvc
                .perform(
                        post("/api/v1/home")
                                .content(ownerAsJson)
                                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }
}
