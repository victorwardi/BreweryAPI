package run.victor.brewery.api.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import run.victor.brewery.api.model.BeerDTO;
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
        return new ResponseEntity<>(beerDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addBeer(@Valid @RequestBody BeerDTO beer) {

        BeerDTO beerDTO = beerService.addBeer(beer);
        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/beer/" + beerDTO.getId().toString());
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrosHandler(ConstraintViolationException e) {

        List<String> erros = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            erros.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}
