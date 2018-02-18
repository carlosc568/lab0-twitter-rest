package es.unizar.tmdad.lab0.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.SearchMetadata;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TwitterLookupService {
   
    private String consumerKey = System.getenv("twitter.consumerKey");

    
    private String consumerSecret = System.getenv("twitter.consumerSecret");

    
    private String accessToken = System.getenv("twitter.accessToken");

    
    private String accessTokenSecret = System.getenv("twitter.accessTokenSecret");

    public SearchResults search(String query) {
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        return twitter.searchOperations().search(query);
    }

    public SearchResults emptyAnswer() {
        return new SearchResults(Collections.emptyList(), new SearchMetadata(0,0 ));
    }
}

