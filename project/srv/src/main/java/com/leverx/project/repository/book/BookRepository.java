package com.leverx.project.repository.book;

import java.util.List;

import my.bookshop.Books;
import com.leverx.project.repository.Repository;

public interface BookRepository extends Repository<Books, String> {
	
	public void setSingleAttrById(String id, String prop, Object value);
	
	// public List<Books> getBooksByTITLE(List<String> titleList);
	
}