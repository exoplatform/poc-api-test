package org.exoplatform.bch.user;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
@Path("/users")
@Api("/users")
public class UserResource {

    @GET
    @Path("/{user}")
    @Produces("application/json")
    @ApiOperation(value = "Get user by Id",
            response = User.class,
            notes = "This can only be done by the logged in user.",
            position = 0)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid user id supplied"),
            @ApiResponse(code = 404, message = "User not found") })
    public User getUser(@PathParam("user") long id) {
        return new User(0, "BCH");
    }
}
