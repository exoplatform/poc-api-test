package org.exoplatform.client.retrofit;

import org.exoplatform.bch.calendar.category.Calendar;
import retrofit.http.*;
import retrofit.client.Response;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface RestClient {


    @GET("/rest/private/v1/calendar/categories")
    CategorySearchResult getCategories();

    @GET("/rest/private/v1/calendar/calendars")
    CalendarSearchResult getCalendar();

    @POST("/rest/private/v1/calendar/calendars/")
    Response createCalendar(@Body Calendar calendar);

    @DELETE("/rest/private/v1/calendar/calendars/{id}")
    Response deleteCalendar(@Path("id") String itemId);

    @GET("/rest/private/v1/calendar/calendars/{id}/ics")
    Response getIcs(@Path("id") String itemId);
}
