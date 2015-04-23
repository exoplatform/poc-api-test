package org.exoplatform.bch.activity;

/**
 * Created by bdechateauvieux on 4/23/15.
 */

import cucumber.api.junit.Cucumber;
import org.eclipse.jetty.server.Server;
import org.exoplatform.bch.stream.StreamResource;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@RunWith(Cucumber.class)
public class ActivityFuncTest {

    private static Server server;

    @BeforeClass
    public static void startServer() throws Exception {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig(ActivityResource.class, StreamResource.class);
        server = JettyHttpContainerFactory.createServer(baseUri, config);
    }

    @AfterClass
    public static void shutdownServer() throws Exception {
        server.stop();
    }
}
