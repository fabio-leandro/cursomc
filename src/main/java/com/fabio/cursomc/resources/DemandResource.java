package com.fabio.cursomc.resources;

import com.fabio.cursomc.domain.Demand;
import com.fabio.cursomc.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demands")
public class DemandResource {

    @Autowired
    private DemandService demandService;

    @GetMapping("/{id}")
    public ResponseEntity<Demand> getById(@PathVariable Integer id){
        return ResponseEntity.ok(demandService.getById(id));
    }

}
