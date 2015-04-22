package org.exoplatform.bch;

import org.exoplatform.bch.user.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
@ApplicationPath("/")
public class UserApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(UserResource.class);
        resources.add(com.wordnik.swagger.jersey.listing.ApiListingResourceJSON.class);
        return resources;
    }
}
