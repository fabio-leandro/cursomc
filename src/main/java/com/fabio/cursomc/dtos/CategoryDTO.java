package com.fabio.cursomc.dtos;

import com.fabio.cursomc.domain.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "The name cannot be empty.")
    @Size(min = 2,max = 50, message = "The name must have between 2 and 80 characters.")
    private String name;

    public CategoryDTO(){
    };

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
