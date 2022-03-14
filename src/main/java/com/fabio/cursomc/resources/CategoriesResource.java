package com.fabio.cursomc.resources;

import com.fabio.cursomc.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories(){
        Category cat1 = new Category(1, "Informatica");
        Category cat2 = new Category(2, "Office");
        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);
        return categories;
    }

}
