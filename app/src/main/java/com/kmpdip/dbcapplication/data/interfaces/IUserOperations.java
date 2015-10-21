package com.kmpdip.dbcapplication.data.interfaces;

import com.parse.ParseUser;

public interface IUserOperations {
    // Save the user to the shared preferences so that we can check if he has added or removed books from facebook
    void saveUserInPreferences(ParseUser user);

    // Check if the user need to be updated. If the user is not in the shared preferences then it is his first time and return should return false.
    boolean isDifferent(ParseUser user);

    // Update the user profile on Parse if there are changes.
    // IMPORTANT This should not be called very frequently (once per day or if enough changes have occured)
    void updateUserOnParse(ParseUser user);


}
