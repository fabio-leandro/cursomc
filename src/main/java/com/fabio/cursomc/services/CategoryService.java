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
                .orElseThrow(()-> new ObjectNotFoundException("The object not found for "+Category.class.getSimpleName()+
                        " and with id -> "+id));
    }

    public Category insert(Category category){
        return categoryRepository.save(category);
    }

    public Category updateById(Integer id, Category category){
        findById(id);
        return categoryRepository.save(category);
    }


}
