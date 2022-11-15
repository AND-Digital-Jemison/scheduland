package com.andjemison.scheduland;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void checkDogStatusIsOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/dog").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getDogInFirstHalfOfAlphabet() throws Exception {
        DogController dogController = new DogController(new TestDogImageRetriever("https://images.dog.ceo/breeds/bulldog-boston/n02096585_8323.jpg"));
        assert(dogController.getDog());
    }
    @Test
    public void checkDogIsNotInFirstHalfOfAlphabet() throws Exception{
        DogController dogController = new DogController(new TestDogImageRetriever("https://images.dog.ceo/breeds/poodle/n02096585_8323.jpg"));
        assertFalse(dogController.getDog());
    }


}
