package com.kmpdip.dbcapplication.data.structure;

import java.util.List;

public class UserToClassify {
    private final String age;
    private final String ID;
    private final String gender;
    private final List<Float> genrePrefs;
    private final String userClass;
    private final String criterion;

    public static class UserToClassifyBuilder{
        private String age;
        private String ID;
        private String gender;
        private List<Float> genrePrefs;
        private String userClass;
        private String criterion;

        public UserToClassifyBuilder(){
        }

        public UserToClassifyBuilder userClass(String s){
            userClass=s;
            return this;
        }
        public UserToClassifyBuilder genrePrefs(List<Float> s){
            genrePrefs=s;
            return this;
        }
        public UserToClassifyBuilder ID(String s){
            ID=s;
            return this;
        }
        public UserToClassifyBuilder age(String s){
            age=s;
            return this;
        }
        public UserToClassifyBuilder gender(String s){
            gender=s;
            return this;
        }
        public UserToClassifyBuilder criterion(String s){
            criterion=s;
            return this;
        }
        public UserToClassify build(){
            return new UserToClassify(this);
        }
    }


    private UserToClassify(UserToClassifyBuilder builder){

        age = builder.age;
        ID = builder.ID;
        gender = builder.gender;
        genrePrefs = builder.genrePrefs;
        userClass = builder.userClass;
        criterion=builder.criterion;
    }
}
