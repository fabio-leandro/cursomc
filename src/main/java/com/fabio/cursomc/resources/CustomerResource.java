package com.fabio.cursomc.resources;

import com.fabio.cursomc.domain.Customer;
import com.fabio.cursomc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }
}
