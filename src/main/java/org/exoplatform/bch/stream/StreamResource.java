package org.exoplatform.bch.stream;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.exoplatform.bch.activity.Activity;
import org.exoplatform.bch.stream.StreamStorage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
@Path("/stream")
@Api(value="/stream", description = "Operations about eXo Platform Activity streams")
@Produces("application/json")
public class StreamResource {

    @GET
    @ApiOperation(value = "Get stream for authenticated user",
            response = Activity.class, responseContainer="List",
            notes = "This can only be done by the logged in user.",
            position = 0)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Activity Stream not found") })
    public Response getStream() {
        return Response.ok().entity(StreamStorage.getStream()).build();
    }
}
