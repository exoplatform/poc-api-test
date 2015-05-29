package org.exoplatform.fqa.calendar;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.exoplatform.ConnectedStepDefinitions;
import org.exoplatform.bch.calendar.category.Calendar;
import org.exoplatform.client.retrofit.User;
import retrofit.client.Response;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


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
       Response hResponse= getClient().createCalendar(monCal);
        httpErrorStatus = hResponse.getStatus();
    }


    @And("^The calendar \"(.*)\" is show")
    public void The_calendar_exist(String leCal) throws Throwable {
        //TODO Get the calendar by id and check if exist
  //     assertTrue( activityClient.getCalendarSearchResult(leCal)!=null);
    }


    @Given("^As ([^\"]*), I create a calendar with name \"([^\"]*)\"$")
    public void As_mary_I_create_a_calendar_with_name(String user, String arg1) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
       Response hResponse= getClient(User.valueOf(user)).createCalendar(monCal);
        httpErrorStatus = hResponse.getStatus();
    }

    @When("^As ([^\"]*), I get calendar$")
    public void As_john_I_get_calendar(String user) throws Throwable {
        calendars = getClient(User.valueOf(user)).getCalendar().getData();
    }


    @Then("^Calendar named \"([^\"]*)\" is not show$")
    public void Calendar_named_is_not_show(String arg1) throws Throwable {
        assertThat(calendars, not(hasItem(hasProperty("name", equalTo(arg1)))));
    }

    @And("^As ([^\"]*), I delete calendar named \"([^\"]*)\"$")
    public void As_mary_I_delete_calendar_named(String user, String arg1) throws Throwable {
        String idOfcal="";
        for(Calendar o: calendars) {
            if (o.getName().equals(arg1))
                idOfcal = o.getId();
        }
        getClient(User.valueOf(user)).deleteCalendar(idOfcal);
    }

    @Given("^As ([^\"]*), I create a calendar with name \"([^\"]*)\" and groups \"([^\"]*)\".$")
    public void As_mary_I_create_a_calendar_with_name_and_groups_(String user,String arg1, String arg2) throws Throwable {
        String[] groupArray = new String[1];
        groupArray[0] = arg2;
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
        monCal.setGroups(groupArray);
        getClient(User.valueOf(user)).createCalendar(monCal);
    }

    @Then("^Calendar named \"([^\"]*)\" is show$")
    public void Calendar_named_is_show(String arg1) throws Throwable {
        assertThat(calendars, hasItem(hasProperty("name", equalTo(arg1))));
    }

    @Given("^As ([^\"]*), I create a calendar with name \"([^\"]*)\" and give view permission for \"([^\"]*)\" .$")
    public void As_mary_I_create_a_calendar_with_name_and_give_view_permission_for_(String user,String arg1, String arg2) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
        monCal.setViewPermission(arg2);
        getClient(User.valueOf(user)).createCalendar(monCal);
    }

    @When("^Calendar type ([^\"]*) with name ([^\"]*) is show$")
    public void Calendar_type_type_with_name_name_is_show(String arg1, String arg2) throws Throwable {
   //     assertThat(calendars, hasItem(hasProperty("type", equalTo(arg1))));
        assertThat(calendars, hasItems(hasProperty("type", equalTo(arg1)),hasProperty("name", equalTo(arg2))));
    }

    @Given("^As ([^\"]*), I create a calendar with name \"([^\"]*)\" and edit right for ([^\"]*)")
    public void As_mary_I_create_a_calendar_with_name_and_edit_right_for_john(String user, String arg1,String arg2) throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName(arg1);
        monCal.setEditPermission(arg2);
        getClient(User.valueOf(user)).createCalendar(monCal);
    }

    @Given("^I ask for ics$")
    public void I_ask_for_ics() throws Throwable {
        String idCal="calendar9eae9ac57f00010107f1dc1a1ad2b506";
    getClient(User.mary).getIcs(idCal);
    }


//    Status

    @Then("^I receive error : bad request, 400$")
    public void returnMessageBadRequest400(){
        assertThat(this.httpErrorStatus, is(400));
    }

    @Then("^I receive error : Unauthorized, 401$")
    public void returnMessageUnauthorized401(){
        assertThat(this.httpErrorStatus, is(401));
    }
}
