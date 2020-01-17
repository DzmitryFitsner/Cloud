package com.leverx.project.repository.author;

import java.util.List;

import my.bookshop.Books;
import my.bookshop.Authors;
import com.leverx.project.repository.Repository;

public interface AuthorRepository extends Repository<Authors, String> {

    public List<Books> getBooksByAuthorId(String id);

    public void setSingleAttrById(String id, String prop, Object value);

    public Authors createAuthor (Authors author);
}