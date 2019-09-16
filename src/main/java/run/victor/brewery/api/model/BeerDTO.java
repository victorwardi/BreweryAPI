package run.victor.brewery.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.victor.brewery.api.model.enums.BeerStyleEnum;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    @Null
    private UUID id;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;

    @NotNull(message = "Beer style is required.")
    private BeerStyleEnum beerStyle;

    @NotNull
    @Positive
    private Long upc;

    private BigDecimal price;

}
