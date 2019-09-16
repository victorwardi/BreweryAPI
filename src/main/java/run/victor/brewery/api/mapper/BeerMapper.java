package run.victor.brewery.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import run.victor.brewery.api.domain.Beer;
import run.victor.brewery.api.model.BeerDTO;

/**
 * Created by Victor Wardi - @victorwardi on 9/16/2019
 */
@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    @Mappings({
        @Mapping(target="beerName", source="beer.name")
    })
    BeerDTO beerToBeerDTO(Beer beer);

    @Mappings({
        @Mapping(target="name", source="beerDTO.beerName")
    })
    Beer beerDTOtoBeer(BeerDTO beerDTO);
}
