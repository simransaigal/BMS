package BMS.core.repository.impl;

import BMS.core.entities.BookEntity;
import BMS.core.repository.BookDAO;
import BMS.core.repository.RepositoryInterface;

import java.util.*;

public class BookRepository implements RepositoryInterface<BookEntity> {
    private final List<BookEntity> books;
    final BookDAO dao;
    public BookRepository(BookDAO dao){
        this.dao = dao;
        books = new ArrayList<>();
    }
    public List<BookEntity> get() {
        return dao.findAll();
//        return books;
    }
    public BookEntity add(BookEntity book){
        return dao.create(book);
//        Unique
//        books.add(book);
//        return book;
    }

    public BookEntity update(BookEntity book){
        for(int itr = 0;itr<books.size();itr++){
            if(books.get(itr).getIsbn()==book.getIsbn()){
                books.set(itr,book);
                return book;
            }
        }
//
        return add(book);
    }

    public BookEntity delete(BookEntity book){
        for(int itr = 0;itr<books.size();itr++){
            if(books.get(itr).getIsbn()==book.getIsbn()){
                books.remove(itr);
                return book;
            }
        }
        return new BookEntity();
    }
}
