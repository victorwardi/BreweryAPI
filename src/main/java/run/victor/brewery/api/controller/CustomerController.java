package run.victor.brewery.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import run.victor.brewery.api.model.CustomerDTO;
import run.victor.brewery.api.service.CustomerService;

import java.util.UUID;

/**
 * Created by Victor Wardi - @victorwardi on 9/4/2019
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomers (@PathVariable UUID customerId){
        return  new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customer){
        CustomerDTO customerDTO = customerService.addCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customers" + customerDTO.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer (@PathVariable UUID customerId, @RequestBody CustomerDTO customer){
        CustomerDTO customerDTO = customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCostumer( @PathVariable UUID customerId){
        customerService.deleteById(customerId);
    }

}

