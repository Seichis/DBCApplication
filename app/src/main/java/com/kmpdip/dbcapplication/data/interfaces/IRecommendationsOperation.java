package com.kmpdip.dbcapplication.data.interfaces;

import com.kmpdip.dbcapplication.data.structure.Recommendation;
import com.kmpdip.dbcapplication.data.structure.UserToClassify;


import java.util.List;


public interface IRecommendationsOperation {
    // Classify User to a cluster
    void classifyUser(UserToClassify user);

    // create recommendations for a user
    void setRecommendations(UserToClassify user);

    // Return the list of recommendations given a criterion. Criterions are author, user class, genre
    List<Recommendation> getRecommendations(String criterion);

    // Save the user action on the recommendation like,dislike,wants to read
    void saveUserAction(Recommendation recommendation);


}
