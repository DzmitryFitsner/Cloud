package com.leverx.project.repository.author;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.bookshop.Books;
import my.bookshop.Books_;
import my.bookshop.Authors;
import my.bookshop.Authors_;
import catalogservice.BookService_;

import com.sap.cds.ql.Insert;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.Update;
import com.sap.cds.ql.cqn.CqnInsert;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.ql.cqn.CqnUpdate;
import com.sap.cds.services.persistence.PersistenceService;

@Repository 
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
	private PersistenceService persistenceService;

    @Override 
    public Optional<Authors> findById(String id) {
        CqnSelect query = Select.from(Authors_.class).distinct().byId(id);
        return Optional.of(persistenceService.run(query).single().as(Authors.class));
    }

    @Override 
    public List<Authors> findAll() {
        CqnSelect query = Select.from(Authors_.class);
        return persistenceService.run(query).listOf(Authors.class);
    }

    @Override
	public List<Books> getBooksByAuthorId(String id) {
		CqnSelect query = Select.from(Books_.class);
        // .where(book -> book.author_ID().eq(id));
		return persistenceService.run(query).listOf(Books.class);
	}

    @Override
	public void setSingleAttrById(String id, String prop, Object value) {
		CqnUpdate query = Update.entity(Authors_.class).byId(id).data(prop, value);
		persistenceService.run(query);
	}

    @Override
	public Authors createAuthor(Authors author) {
		CqnInsert query = Insert.into(Authors_.class).entry(author);
		return persistenceService.run(query).single().as(Authors.class);
	}
}
