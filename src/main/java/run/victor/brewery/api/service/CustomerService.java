package run.victor.brewery.api.service;

import run.victor.brewery.api.model.CustomerDTO;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/4/2019
 */
public interface CustomerService {

    CustomerDTO getCustomer(UUID id);
    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(UUID customerId, CustomerDTO customer);

    void deleteById(UUID customerId);
}
