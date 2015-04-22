package org.exoplatform.bch.activity;

import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
@Path("/activity")
@Api(value="/activity", description = "Operations about eXo Platform social activities")
@Produces("application/json")
public class ActivityResource {

    @GET
    @Path("/{activity}")
    @ApiOperation(value = "Get activity by Id",
            response = Activity.class,
            notes = "This can only be done by the logged in user.",
            position = 0)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid activity id supplied"),
            @ApiResponse(code = 404, message = "Activity not found") })
    public Response getActivity(
            @ApiParam(value = "The id that needs to be fetched. Use 0 for testing. ", required = true)
            @PathParam("activity") long id) {
        Activity activity = new Activity(id, "RDBMS Guidelines has been modified on wiki by Benoit");
        return Response.ok().entity(activity).build();
    }

    @POST
    @ApiOperation(value = "Create activity",
            notes = "This can only be done by the logged in user.",
            position = 1)
    public Response createActivity(
            @ApiParam(value = "Created activity object", required = true) Activity activity) {
        //Nothing
        return Response.ok().entity("").build();
    }
}
