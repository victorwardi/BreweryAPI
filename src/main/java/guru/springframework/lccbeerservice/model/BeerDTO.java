package guru.springframework.lccbeerservice.model;

import guru.springframework.lccbeerservice.model.enums.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private UUID id;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;
    private BeerStyleEnum beerStyle;

    private Long upc;

    private BigDecimal price;

}
