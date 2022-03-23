package com.fabio.cursomc.services;

import com.fabio.cursomc.domain.Customer;
import com.fabio.cursomc.exceptions.ObjectNotFoundException;
import com.fabio.cursomc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Integer id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Customer not found with id ->"+id));
    }


}
