package com.kmpdip.dbcapplication.httpoperations;

import android.util.Log;

import com.kmpdip.dbcapplication.data.interfaces.IBookHttpSearch;
import com.kmpdip.dbcapplication.data.structure.Book;

import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
        String[] response=consumeWebService(bookid);
        Book book=builder.title(response[0]).author(response[1]).description(response[2]).date(response[3]).genre(response[4]).build();
        return book;
    }



    private String[] consumeWebService(String bookid)
    {
        String DBCURL = "http://oss-services.dbc.dk/opensearch/?action=search&query={query}&agency=100200&profile=test&start=1&stepValue=5";
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        InputStream is;
        Document dom;
        String bookAuthor = "", bookAbstract = "", bookSubjects = "", bookTitle = "", bookDate="";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

        final String result = restTemplate.getForObject(DBCURL, String.class, bookid);

        try {
            factory = DocumentBuilderFactory.newInstance();
            is = new ByteArrayInputStream(result.getBytes("UTF-8"));
            builder = factory.newDocumentBuilder();
            dom = builder.parse(is);

            bookTitle = getTagContent("dc:title", dom);
            bookAuthor = getTagContent("dc:creator",dom);
            bookAbstract = getTagContent("dcterms:abstract",dom);
            bookDate = getTagContent("dc:date", dom);
            bookSubjects = getSubjects("dc:subject", dom);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{bookTitle, bookAuthor, bookAbstract, bookDate, bookSubjects};
    }

    private String getTagContent(String tagName, Document dom){
        NodeList bookOutput = dom.getElementsByTagName(tagName);
        String bookTag="";
        for (int i = 0; i < bookOutput.getLength(); i++) {
            bookTag = bookOutput.item(i).getTextContent();
            break;
        }
        return bookTag;
    }

    private String getSubjects(String tagName, Document dom){
        NodeList bookOutput = dom.getElementsByTagName(tagName);
        String subjects = "";
        for (int i=0; i < bookOutput.getLength(); i++ ){
            subjects = bookOutput.item(i).getTextContent() + ", " + subjects;
        }
        return subjects;
    }
}
