package org.exoplatform.bch.user.client.retrofit;

import org.exoplatform.bch.activity.Activity;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface ActivityResourceClient {

    @GET("/activity/{activity}")
    Activity getActivity(@Path("activity") long activityId);
}
