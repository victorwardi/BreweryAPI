package run.victor.brewery.api.mapper;

import org.mapstruct.Mapper;
import run.victor.brewery.api.domain.Customer;
import run.victor.brewery.api.model.CustomerDTO;

/**
 * Created by Victor Wardi - @victorwardi on 9/16/2019
 */
@Mapper
public interface CustomerMapper {

    Customer customerDTOtoCustomer(CustomerDTO customerDTO);

    CustomerDTO customertoCustomerDTO(Customer customer);
}
