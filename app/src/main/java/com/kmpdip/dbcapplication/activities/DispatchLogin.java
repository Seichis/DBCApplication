package com.kmpdip.dbcapplication.activities;

import com.parse.ui.ParseLoginDispatchActivity;

/**
 * Launcher activity. When the user is not logged in he is redirected to the login screen else he is redirected in the MainActivity
 */
public class DispatchLogin extends ParseLoginDispatchActivity {

    @Override
    protected Class<?> getTargetClass() {
        return MainActivity.class;
    }
}