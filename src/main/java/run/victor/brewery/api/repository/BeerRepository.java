package run.victor.brewery.api.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import run.victor.brewery.api.domain.Beer;

/**
 * Created by Victor Wardi - @victorwardi on 9/17/2019
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
