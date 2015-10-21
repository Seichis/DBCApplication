package com.kmpdip.dbcapplication.data.structure;


public class Recommendation {
    private final Book book;
    private final String userAction;

    public static class RecommendationBuilder{
        private final Book book;
        private String userAction;

        public RecommendationBuilder(Book b){
            this.book=b;
        }
        public RecommendationBuilder userAction(String s){
            this.userAction=s;
            return this;
        }

        public Recommendation build(){
            return new Recommendation(this);
        }
    }


    private Recommendation(RecommendationBuilder builder){
        book=builder.book;
        userAction=builder.userAction;
    }
}

