package run.victor.brewery.api.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import run.victor.brewery.api.model.BeerDTO;
import run.victor.brewery.api.model.enums.BeerStyleEnum;
import run.victor.brewery.api.service.BeerService;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019.
 */
@Validated
@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        BeerDTO beerDTO = beerService.getBeerById(beerId);
        beerDTO = BeerDTO.builder()
            .id(UUID.randomUUID())
            .beerName("Beer1")
            .beerStyle(BeerStyleEnum.ALE)
            .price(new BigDecimal(10.0))
            .upc(123456L)
            .quantityOnHand(50)
            .createdDate(OffsetDateTime.now())
            .build();
        return new ResponseEntity<>(beerDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addBeer(@Valid @RequestBody BeerDTO beer) {


        BeerDTO beerDTO = null;
        try {
            beerDTO = beerService.addBeer(beer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/beer/");
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer(@NotNull  @PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beer) {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }

}
