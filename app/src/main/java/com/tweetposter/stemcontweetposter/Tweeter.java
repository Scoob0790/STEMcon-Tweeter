package com.tweetposter.stemcontweetposter;

import android.os.AsyncTask;
import android.util.Log;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

class Tweeter extends AsyncTask<String, Void, Boolean> {

    static String TWITTER_CONSUMER_KEY = "K0UAHloL1Hh9z9dJ1Ah3AbJwP";
    static String TWITTER_CONSUMER_SECRET = "vQWI3wvIDKDPtSMXlBsD1YvmmeZVpXdyR2MkWpy21lVwaGxCmr";

    static String TWITTER_ACCESS_TOKEN = "841386099272425472-cwtd4Tos4t5MPbooVMBI1Bd3HdZsTUo";
    static String TWITTER_ACCESS_TOKEN_SECRET = "Vm210Oa5I3eOoMFEmThHXjW3YvKEVolX0NxvCdu7kzoU9";

    //    //Account Login Credentials
//    static final String USERNAME = "STEMcon_tweeter";
//    static final String PASSWORD = "R!u1z1J^!FN3";

    @Override
    protected Boolean doInBackground(String... message) {
        //Post Tweet Message
        AccessToken a = new AccessToken(TWITTER_ACCESS_TOKEN,TWITTER_ACCESS_TOKEN_SECRET);
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
        twitter.setOAuthAccessToken(a);
        try {
            Log.d("Sending Tweet:", message[0]);
            twitter4j.Status response = twitter.updateStatus(message[0]);
            Log.d("Status", "> " + response.getText());
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            Log.d("Twitter Update Error", e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}
