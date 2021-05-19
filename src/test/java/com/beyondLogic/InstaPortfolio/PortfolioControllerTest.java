package com.beyondLogic.InstaPortfolio;

import com.beyondLogic.InstaPortfolio.Service.PortfolioItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class PortfolioControllerTest {

        @Autowired
        MockMvc mockMvc;

        @MockBean
        PortfolioItemService portfolioItemService;

        @Test
        public void testShowPortfolioItemForm() throws Exception {
            mockMvc.perform(get("/portfolioItemForm"))
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(view().name("portfolioItemForm"))
                    .andExpect(model().size(1))
                    .andExpect(model().attributeExists("portfolioItem"));
        }

        @Test
        public void testSubmitPortfolioItemForm() throws Exception{
            mockMvc.perform(post("/portfolioItemForm").param("title", "Project 3")
            .param("description","description of portfolio")
            .param("projectUrl","url")
            .param("projectType","Frontend")
            .param("tools","Adobe XD")
            .param("programmingLanguage","None"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/portfolio"));
        }

        //TestGetPortfolioPage


}
