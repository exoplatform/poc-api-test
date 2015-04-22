package org.exoplatform.bch;

import com.wordnik.swagger.jersey.listing.ApiListingResourceJSON;
import org.exoplatform.bch.swagger.JacksonJsonProvider;
import org.exoplatform.bch.activity.ActivityResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
@ApplicationPath("/api")
public class ExoRestApiApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(ActivityResource.class);
        resources.add(ApiListingResourceJSON.class);
        resources.add(JacksonJsonProvider.class);
        return resources;
    }
}
