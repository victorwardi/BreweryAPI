package run.victor.brewery.api.service;

import run.victor.brewery.api.model.BeerDTO;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/3/2019
 */
public interface BeerService {

    BeerDTO getBeerById(UUID beerId);

    BeerDTO addBeer(BeerDTO beer);

    BeerDTO updateBeer(UUID beerId, BeerDTO beer);

    void deleteById(UUID beerId);
}
