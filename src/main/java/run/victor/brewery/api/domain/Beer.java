package run.victor.brewery.api.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Victor Wardi - @victorwardi on 9/16/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

        private UUID id;
        private Integer version;

        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private String name;
        private String beerStyle;

        private Long upc;
        private BigDecimal price;
}
