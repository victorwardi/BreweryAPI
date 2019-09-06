package run.victor.brewery.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.victor.brewery.api.model.BeerDTO;
import run.victor.brewery.api.model.enums.BeerStyleEnum;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/3/2019
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Stela Artois")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTO addBeer(BeerDTO beer) {
        beer.setId(UUID.randomUUID());
        return beer;
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beer) {
        beer.setId(UUID.randomUUID());
        return beer;
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Beer has been deleted.");
    }
}
