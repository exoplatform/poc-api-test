package org.exoplatform;

import org.exoplatform.client.retrofit.RestClient;

import org.exoplatform.client.retrofit.ApiRequestInterceptor;
import org.exoplatform.bch.calendar.category.Category;

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
public class BaseStepDefinitions {
    private static final String USERNAME = "john";
    private static final String PASSWORD = "gtn";

    private final RestClient activityClient;
    List<Category> categories = null;
    public BaseStepDefinitions() {
        ApiRequestInterceptor requestInterceptor = new ApiRequestInterceptor(USERNAME, PASSWORD);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(LogLevel.FULL)
                .build();
        activityClient = restAdapter.create(RestClient.class);
    }

}
