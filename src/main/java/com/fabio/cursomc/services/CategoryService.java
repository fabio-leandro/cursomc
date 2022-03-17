package com.fabio.cursomc.services;

import com.fabio.cursomc.domain.Category;
import com.fabio.cursomc.exceptions.ObjectNotFoundException;
import com.fabio.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("The object not found for "+Category.class.getName()+
                        " and with id -> "+id));
    }

}
