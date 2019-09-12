package run.victor.brewery.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import run.victor.brewery.api.model.BeerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/beers/" + UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    void addBeer() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String json = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/beers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String json = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/beers/"+ UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());
    }
}