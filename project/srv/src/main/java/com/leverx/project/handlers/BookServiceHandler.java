package com.leverx.project.handlers;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsService;

import my.bookshop.Books;
import catalogservice.BookService;

import my.bookshop.Books_;
import catalogservice.BookService_;

@Component
@ServiceName(BookService_.CDS_NAME)
public class BookServiceHandler implements EventHandler {

    // @Autowired
    // BookService bookService;

    @After(event = CdsService.EVENT_CREATE, entity = Books_.CDS_NAME)
    public void checkRich(CdsCreateEventContext context) {
       
        
    }

    @Before(event = CdsService.EVENT_CREATE, entity = Books_.CDS_NAME)
    public void checkExistingTITLE(Stream<Books> books) {
        // if (!bookService.isValidTITLE(books)) {
        //     throw new ServiceException(ErrorStatuses.CONFLICT, "TITLE duplicate error!");
        // }
    }
}