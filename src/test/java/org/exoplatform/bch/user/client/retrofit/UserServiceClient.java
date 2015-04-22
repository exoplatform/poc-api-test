package org.exoplatform.bch.user.client.retrofit;

import org.exoplatform.bch.user.User;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface UserServiceClient {

    @GET("/users/{user}")
    User getUser(@Path("user") long userId);
}
