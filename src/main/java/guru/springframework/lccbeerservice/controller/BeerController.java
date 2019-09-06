package guru.springframework.lccbeerservice.controller;

import guru.springframework.lccbeerservice.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */
@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId")UUID beerId) {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerDTO> addBeer(@RequestBody BeerDTO beer) {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer( @PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer) {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

}
