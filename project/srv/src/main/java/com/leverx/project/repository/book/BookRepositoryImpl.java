package com.leverx.project.repository.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.bookshop.Books;
import my.bookshop.Books_;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.Update;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.ql.cqn.CqnUpdate;
import com.sap.cds.services.persistence.PersistenceService;

@Repository
public class BookRepositoryImpl implements BookRepository {

@Autowired
	private PersistenceService persistenceService;

    @Override
	public Optional<Books> findById(String id) {
		CqnSelect query = Select.from(Books_.class).distinct().byId(id);
		return Optional.of(persistenceService.run(query).single().as(Books.class));
	}

	@Override
	public List<Books> findAll() {
		CqnSelect query = Select.from(Books_.class);
		return persistenceService.run(query).listOf(Books.class);
	}

	@Override
	public void setSingleAttrById(String id, String prop, Object value) {
		CqnUpdate query = Update.entity(Books_.class).byId(id).data(prop, value);
		persistenceService.run(query);
	}

	@Override
	public List<Books> getBooksByTITLE(List<String> titleList) {
		CqnSelect query = Select.from(Books_.class).where(book -> book.title().in(titleList.stream().toArray(String[]::new)));
		return persistenceService.run(query).listOf(Books.class);
	}
}