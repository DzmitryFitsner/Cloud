namespace my.bookshop;

using cuid from '@sap/cds/common';

entity Books : cuid{
  key ID : Integer;
  title  : String;
  stock  : Integer;
  description : String(200);
  author : Association to Authors;
  inspected : Boolean default true;
}

entity Authors : cuid{
  key ID : Integer;
  name   : String;
  description : String(200);
  rich : Boolean default false;
  books  : Association to many Books on books.author = $self;

}