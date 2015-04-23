package org.exoplatform.bch.activity.client.retrofit;

import org.exoplatform.bch.activity.Activity;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.List;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface RestClient {

    @GET("/activity/{activity}")
    Activity getActivity(@Path("activity") long activityId);

    @POST("/activity")
    Long post(@Body Activity activity);

    @GET("/stream")
    List<Activity> getStream();
}
