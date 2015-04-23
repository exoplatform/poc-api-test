package org.exoplatform.bch.activity;

import org.eclipse.jetty.server.Server;
import org.exoplatform.bch.activity.client.retrofit.RestClient;
import org.exoplatform.bch.stream.StreamResource;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.*;
import retrofit.RestAdapter;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public class ActivityResourceIntTest {

    private static Server server;
    private static RestClient service;

    @BeforeClass
    public static void startServer() throws Exception {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig(ActivityResource.class, StreamResource.class);
        server = JettyHttpContainerFactory.createServer(baseUri, config);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .build();
        service = restAdapter.create(RestClient.class);
    }

    @Test
    public void getActivity() throws Exception {
        //Given
        //When
        Activity activity = service.getActivity(0);
        //Then
        assertThat(activity.getTitle(), is("RDBMS Guidelines has been modified on wiki by Benoit"));
    }

    @Test
    public void getStream() throws Exception {
        //Given
        service.post(new Activity("I'm working on Functional Tests for REST API"));
        //When
        List<Activity> stream = service.getStream();
        //Then
        assertThat(stream.get(stream.size()-1).getTitle(), is("I'm working on Functional Tests for REST API"));
    }

    @AfterClass
    public static void shutdownServer() throws Exception {
        server.stop();
    }


}
