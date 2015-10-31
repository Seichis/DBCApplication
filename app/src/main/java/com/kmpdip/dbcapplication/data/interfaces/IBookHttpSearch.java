package com.kmpdip.dbcapplication.data.interfaces;

import com.kmpdip.dbcapplication.data.structure.Book;

import java.util.List;
import java.util.Timer;

/**
 * Created by Ioanna on 10/31/2015.
 */
public interface IBookHttpSearch {

    Book createBookFromXMLResponse(String bookid);

}
