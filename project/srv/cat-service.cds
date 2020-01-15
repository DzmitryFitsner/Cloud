using my.bookshop as my from '../db/data-model';

service CatalogService {
    @readonly entity BookService as projection on my.Books;
    @readonly entity AuthorService as projection on my.Authors;

}