package com.springapp.resources;

import java.util.ArrayList;
import java.util.List;

import com.springapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(2, "Escritório");
		
		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		
		return list;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Category category = service.find(id);

		return ResponseEntity.ok().body(category);
	}
}
