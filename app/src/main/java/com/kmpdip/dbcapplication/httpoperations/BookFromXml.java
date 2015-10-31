package com.kmpdip.dbcapplication.httpoperations;

import com.kmpdip.dbcapplication.data.interfaces.IBookHttpSearch;
import com.kmpdip.dbcapplication.data.structure.Book;

/**
 * Created by Ioanna on 10/31/2015.
 */
public class BookFromXml implements IBookHttpSearch {
    private static BookFromXml instance = new BookFromXml();

    private BookFromXml(){
    }

    public BookFromXml getInstance(){
        return instance;
    }

    @Override
    public Book createBookFromXMLResponse(String bookid) {
        Book.BookBuilder builder=new Book.BookBuilder();
        Book book=builder.title("").author("").build();
        String response=consumeWebService(bookid);
        return book;
    }



    private String consumeWebService(String bookid) {
        return null;
    }


}
