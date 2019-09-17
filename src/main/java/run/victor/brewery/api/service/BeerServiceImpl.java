package run.victor.brewery.api.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.victor.brewery.api.mapper.BeerMapper;
import run.victor.brewery.api.model.BeerDTO;
import run.victor.brewery.api.repository.BeerRepository;

/**
 * Created by Victor Wardi - @victorwardi on 9/3/2019
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    @Override
    public BeerDTO getBeerById(UUID beerId) {
       return  beerMapper.beerToBeerDTO(beerRepository.findById(beerId).get());
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
