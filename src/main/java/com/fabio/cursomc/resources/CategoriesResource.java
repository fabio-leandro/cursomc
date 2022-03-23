package com.fabio.cursomc.resources;

import com.fabio.cursomc.domain.Category;
import com.fabio.cursomc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

}
