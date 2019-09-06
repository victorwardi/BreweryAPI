package run.victor.brewery.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.victor.brewery.api.model.CustomerDTO;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/4/2019
 */

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomer(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Victor Wardi")
                .build();
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(UUID.randomUUID());
        return customerDTO;

    }

    @Override
    public CustomerDTO updateCustomer(UUID customerId, CustomerDTO customer) {
        customer.setId(UUID.randomUUID());
        return customer;
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Customer has been deleted.");
    }
}
