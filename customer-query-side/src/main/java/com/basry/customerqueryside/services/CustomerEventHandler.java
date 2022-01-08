package com.basry.customerqueryside.services;

import com.basry.coreapi.events.CustomerCreatedEvent;
import com.basry.customerqueryside.entities.Customer;
import com.basry.customerqueryside.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerEventHandler {
    CustomerRepository customerRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("********************************");
        log.info("CustomerCreatedEvent occurred");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customerRepository.save(customer);
    }
}
