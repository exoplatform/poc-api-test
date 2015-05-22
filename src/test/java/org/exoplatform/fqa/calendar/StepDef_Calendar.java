package org.exoplatform.fqa.calendar;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.exoplatform.ConnectedStepDefinitions;
import org.exoplatform.bch.calendar.category.Calendar;
import org.exoplatform.client.retrofit.User;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by rosso on 5/15/15.
 */
public class StepDef_Calendar extends ConnectedStepDefinitions {
    List<Calendar> calendars = null;

    @When("^I create a calendar with name \"(.*)\"$")
    public void iPublishAnCategoryWithTitle(String name) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(name);
        getClient().createCalendar(monCal);
    }

    @Then("^the HTTP status code of the response is (\\d+)$")
    public void theHttpStatusCodeOfTheResponseIs(int statusCode) throws Throwable {
        System.out.println("code erreur" + statusCode);
    }


    @When("^I create a calendar with name \"(.*)\" and user name different from owner$")
    public void I_create_a_calendar_with_name_and_user_name_different_from_owner(String arg1) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
        monCal.setOwner("mary");
        getClient().createCalendar(monCal);
    }


    @And("^The calendar \"(.*)\" exist$")
    public void The_calendar_exist(String leCal) throws Throwable {
        //TODO Get the calendar by id and check if exist
  //     assertTrue( activityClient.getCalendarSearchResult(leCal)!=null);
    }

    @When("^I get calendar$")
    public void I_get_calendar() throws Throwable {
        calendars = getClient().getCalendar().getData();
    }

    @Given("^As ([^\"]*), I create a calendar with name \"([^\"]*)\"$")
    public void As_mary_I_create_a_calendar_with_name(String user, String arg1) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
       getClient(User.valueOf(user)).createCalendar(monCal);
    }

    @When("^As ([^\"]*),  I get calendar$")
    public void As_john_I_get_calendar(String user) throws Throwable {
        calendars = getClient(User.valueOf(user)).getCalendar().getData();
    }


    @Then("^Calendar named \"([^\"]*)\" is not show$")
    public void Calendar_named_is_not_show(String arg1) throws Throwable {
        assertThat(calendars, not(hasItem(hasProperty("name", equalTo("")))));
    }

    @And("^As ([^\"]*), I delete calendar named \"([^\"]*)\"$")
    public void As_mary_I_delete_calendar_named(String user, String arg1) throws Throwable {
        calendars = getClient(User.valueOf(user)).getCalendar().getData();
        
   //     getClient(User.valueOf(user)).deleteCalendar(arg1);
    }
}
