package org.exoplatform.client.retrofit;

import org.exoplatform.bch.calendar.category.Calendar;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.DELETE;
import retrofit.client.Response;
import retrofit.http.Path;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public interface RestClient {


    @GET("/rest/private/v1/calendar/categories")
    CategorySearchResult getCategories();

    @GET("/rest/private/v1/calendar/calendars")
    CalendarSearchResult getCalendar();

    @POST("/rest/private/v1/calendar/calendars")
    Response createCalendar(@Body Calendar calendar);

    @DELETE("/rest/private/v1/calendar/calendars")
    Response deleteCalendar(Calendar calendar);

    //TODO get the calendar with a specific id
    @GET("/rest/private/v1/calendar/calendars/{idcal}")
   CalendarSearchResult getCalendarSearchResult(@Path("idcal") String idCal);


}
