package com.basry.customerqueryside.services;

import com.basry.coreapi.queries.GetAllCustomersQuery;
import com.basry.coreapi.queries.GetCustomerByIdQuery;
import com.basry.customerqueryside.entities.Customer;
import com.basry.customerqueryside.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerQueryHandler {
    private CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer customer(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId()).orElseThrow(()-> new RuntimeException("Customer not found"));
    }
}
