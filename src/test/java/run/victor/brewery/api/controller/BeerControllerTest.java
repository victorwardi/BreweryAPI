package run.victor.brewery.api.controller;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import run.victor.brewery.api.model.BeerDTO;
import run.victor.brewery.api.model.enums.BeerStyleEnum;
import run.victor.brewery.api.repository.BeerRepository;
import run.victor.brewery.api.service.BeerService;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */

@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerRepository beerRepository;

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDTO validBeer;

    @BeforeEach
    void setUp() {

        validBeer = BeerDTO.builder()
            .beerName("Beer1")
            .beerStyle(BeerStyleEnum.ALE)
            .price(new BigDecimal(10.0))
            .upc(123456L)

            .build();
    }

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(
            get("/api/v1/beers/{beerId}", UUID.randomUUID().toString())
                .param("iscold", "yes")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(document("v1/beer",
                pathParameters(
                    parameterWithName("beerId").description("UUID of desired beer to get.")
                ),
                requestParameters(
                    parameterWithName("iscold").description("Is Beer Cold Query param")
                ),
                responseFields(
                    fieldWithPath("id").description("Id of Beer"),
                    fieldWithPath("version").description("Version number"),
                    fieldWithPath("createdDate").description("Date Created"),
                    fieldWithPath("lastModifiedDate").description("Date Updated"),
                    fieldWithPath("beerName").description("Beer Name"),
                    fieldWithPath("beerStyle").description("Beer Style"),
                    fieldWithPath("upc").description("UPC of Beer"),
                    fieldWithPath("price").description("Price"),
                    fieldWithPath("quantityOnHand").description("Quantity On hand")
                )));
    }

    @Test
    void addBeer() throws Exception {

        String json = objectMapper.writeValueAsString(validBeer);
        mockMvc.perform(
            post("/api/v1/beers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated())
            .andDo(document("v1/beer",
                requestFields(
                    fieldWithPath("id").ignored(),
                    fieldWithPath("version").ignored(),
                    fieldWithPath("createdDate").ignored(),
                    fieldWithPath("lastModifiedDate").ignored(),
                    fieldWithPath("beerName").description("Name of the beer"),
                    fieldWithPath("beerStyle").description("Style of Beer"),
                    fieldWithPath("upc").description("Beer UPC").attributes(),
                    fieldWithPath("price").description("Beer Price"),
                    fieldWithPath("quantityOnHand").ignored()
                )));
            ;
    }

    @Test
    void updateBeer() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String json = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(
            put("/api/v1/beers/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isNoContent());
    }
}