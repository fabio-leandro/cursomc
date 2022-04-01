package com.fabio.cursomc.services;

import com.fabio.cursomc.domain.Demand;
import com.fabio.cursomc.exceptions.ObjectNotFoundException;
import com.fabio.cursomc.repositories.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    public Demand getById(Integer id){
        return demandRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Demand not found with id -> "+id));
    }
}
