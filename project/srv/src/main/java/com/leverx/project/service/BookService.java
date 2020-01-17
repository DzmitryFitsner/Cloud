package com.leverx.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.bookshop.Books;
import my.bookshop.Authors;
import com.leverx.project.repository.book.BookRepository;
import com.leverx.project.repository.author.AuthorRepository;

@Service
public class BookService {

    private static final int RICH_BOOKS_COUNT = 3;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public void setRichAuthor(Books book) {
        Optional<Authors> bookAuthor = authorRepository.findById(book.getAuthorId().toString());
        if (bookAuthor.isPresent()){
            Authors author = bookAuthor.get();
            List<Books> bookList = authorRepository.getBooksByAuthorId(author.getId().toString());
            if (bookList.size() >= RICH_BOOKS_COUNT && !author.getRich()) {
                authorRepository.setSingleAttrById(author.getId().toString(), "rich", true);
            }
        }
    }

    public boolean isValidTITLE(Stream<Books> books) {
		List<String> titleList = books.map(Books::getTitle).collect(Collectors.toList());
		List<Books> bookList = bookRepository.getBooksByTITLE(titleList);
		boolean validTitle = false;
		if (bookList.isEmpty()) {
			validTitle = true;
		}
		return validTitle;
	}
	
}

