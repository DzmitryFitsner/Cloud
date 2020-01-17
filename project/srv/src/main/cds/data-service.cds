namespace leverx.com.project;

using my.bookshop as data from '../../../../db/index';

service BookService {

    @Capabilities : {
        Insertable : true,
        Updatable  : true,
        Deletable  : true
    }
    entity Books as projection on data.Books 
    actions {
    	action inspect(inspected: Boolean);
    }
    
    @Capabilities : {
        Insertable : true,
        Updatable  : true,
        Deletable  : true
    }
    entity Authors as projection on data.Authors
    actions {
    	function booksOwned() returns Integer;
    };
    
    function hasUninspectedBook(authorId: String) returns Boolean;
    
}