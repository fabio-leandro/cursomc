package com.fabio.cursomc.services;

import com.fabio.cursomc.domain.Category;
import com.fabio.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(Integer id){
        return categoryRepository.findById(id);
    }

}
