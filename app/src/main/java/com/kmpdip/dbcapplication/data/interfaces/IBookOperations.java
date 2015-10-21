package com.kmpdip.dbcapplication.data.interfaces;



import com.kmpdip.dbcapplication.data.structure.Book;
import com.parse.ParseUser;

import java.util.List;

// Inteface for interacting with the books from the database
// Can be used for showing the library of the user and to create books for recommendations
// The idea is to check which books belong to the same cluster as the user and recommend books that he has not read or liked

public interface IBookOperations {
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksByGenre(String genre);
    public List<Book> getBooksByUserClass(String userClass);
    public List<String> getReadBooks(ParseUser user);
    public List<String> getLikedBooks(ParseUser user);
    public List<String> getWantToReadBooks(ParseUser user);
}
