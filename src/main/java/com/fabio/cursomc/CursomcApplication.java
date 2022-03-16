package com.fabio.cursomc;

import com.fabio.cursomc.domain.Category;
import com.fabio.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null,"Informatica");
		Category c2 = new Category(null, "Office");

		categoryRepository.saveAll(Arrays.asList(c1,c2));

	}
}
