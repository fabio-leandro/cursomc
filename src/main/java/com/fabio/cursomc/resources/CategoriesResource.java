package com.fabio.cursomc.resources;

import com.fabio.cursomc.domain.Category;
import com.fabio.cursomc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Category category){
        Category obj = categoryService.insert(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category){
        return ResponseEntity.ok(categoryService.updateById(id,category));
    }

}
