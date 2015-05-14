package org.exoplatform.client.retrofit;

import retrofit.http.GET;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface RestClient {


    @GET("/rest/private/v1/calendar/categories")
    CategorySearchResult getCategories();
}
