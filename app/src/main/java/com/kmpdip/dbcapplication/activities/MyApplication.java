package com.kmpdip.dbcapplication.activities;

import android.app.Application;

import com.kmpdip.dbcapplication.R;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by tRiF on 28/7/2015.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        ParseFacebookUtils.initialize(this);
    }
}