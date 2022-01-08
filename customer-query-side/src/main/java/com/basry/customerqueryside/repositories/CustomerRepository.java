package com.basry.customerqueryside.repositories;

import com.basry.customerqueryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
