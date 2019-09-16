package run.victor.brewery.api.mapper;

import org.mapstruct.Mapper;
import run.victor.brewery.api.domain.Beer;
import run.victor.brewery.api.model.BeerDTO;

/**
 * Created by Victor Wardi - @victorwardi on 9/16/2019
 */
@Mapper
public interface BeerMapper {

    Beer beerDTOtoBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDTO(Beer beer);
}
