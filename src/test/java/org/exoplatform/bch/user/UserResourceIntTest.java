package org.exoplatform.bch.user;

import org.eclipse.jetty.server.Server;
import org.exoplatform.bch.user.client.retrofit.UserServiceClient;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public class UserResourceIntTest {

    private Server server;

    @Before
    public void startServer() throws Exception {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig(UserResource.class);
        server = JettyHttpContainerFactory.createServer(baseUri, config);
    }


    @Test
    public void getUserWithRetrofit() throws Exception {
        //Given
        //When
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .build();

        UserServiceClient service = restAdapter.create(UserServiceClient.class);
        User user = service.getUser(0);
        //Then
        assertThat(user.getName(), is("BCH"));
    }

    @After
    public void shutdownServer() throws Exception {
        server.stop();
    }


}
