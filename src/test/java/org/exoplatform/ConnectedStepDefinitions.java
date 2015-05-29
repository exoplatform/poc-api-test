package org.exoplatform;

import cucumber.api.java.en.Then;
import org.exoplatform.client.retrofit.RestClient;

import org.exoplatform.client.retrofit.ApiRequestInterceptor;
import org.exoplatform.bch.calendar.category.Category;

import org.exoplatform.client.retrofit.User;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

/**
 * Created by bdechateauvieux on 4/23/15.
 */
public class ConnectedStepDefinitions {

    protected int httpErrorStatus;
    protected RestClient getClient(User user){

        ApiRequestInterceptor requestInterceptor = new ApiRequestInterceptor(user.getUserName(), user.getPassword());

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.1.53:8080")
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(LogLevel.FULL)
                .build();
        return restAdapter.create(RestClient.class);
    }

    protected RestClient getClient(){
        return getClient(User.john);
    }
}
