package com.kmpdip.dbcapplication.data.structure;


public class Recommendation {

    private Book book; // Book to be recommended
    private String user_action; // User action on the recommendation
    private static Recommendation r = new Recommendation();

    // Singleton instance of the class
    public static Recommendation getRecommendationInstance(Book book){
        return r;
    }

    // Private constructor initializing with the book to recommend
    private Recommendation(){
    }

    public String getUser_action() {
        return user_action;
    }

    public void setUser_action(String user_action) {
        this.user_action = user_action;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}

