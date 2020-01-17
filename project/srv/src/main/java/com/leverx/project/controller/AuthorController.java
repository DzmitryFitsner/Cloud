package com.leverx.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import my.bookshop.Books;
import my.bookshop.Authors;
import com.leverx.project.repository.author.AuthorRepositoryImpl;

@RestController
public class AuthorController {

    @Autowired
	private AuthorRepositoryImpl authorRepository;

    @PostMapping("/authors")
	public Authors createAuthor(@RequestBody Authors author) {
		return authorRepository.createAuthor(author);
	}
	
	@GetMapping("/authors/{id}/books")
	public List<Books> getAuthorBooks(@PathVariable String id) {
		return authorRepository.getBooksByAuthorId(id);
	}
	
	@GetMapping("/authors")
	public List<Authors> getAllAuthors() {
		return authorRepository.findAll();
	}

}