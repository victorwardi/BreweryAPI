package run.victor.brewery.api.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.victor.brewery.api.model.enums.BeerStyleEnum;

/**
 * Created by Victor Wardi - @victorwardi on 9/16/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

        private UUID id;
        private Integer version;

        private OffsetDateTime createdDate;
        private OffsetDateTime lastModifiedDate;

        private String beerName;
        private BeerStyleEnum beerStyle;

        private Long upc;
        private BigDecimal price;
}
