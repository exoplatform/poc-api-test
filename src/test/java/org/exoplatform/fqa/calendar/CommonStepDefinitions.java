package org.exoplatform.fqa.calendar;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.exoplatform.ConnectedStepDefinitions;
import org.exoplatform.bch.calendar.category.Calendar;

/**
 * Created by rosso on 5/15/15.
 */
public class CommonStepDefinitions extends ConnectedStepDefinitions {


    @Then("^I receive error : bad request, 400$")
    public void returnMessageBadRequest400(){
        //TODO : Check the return message is 400
    }

    @Then("^I receive error : Unauthorized, 401$")
    public void returnMessageUnauthorized401(){
        //TODO : Check the return message is 401
    }

    @Given("^Je test$")
    public void Je_test() throws Throwable {
        Calendar monCal = new Calendar();
        monCal.setName("romain");
        monCal.setOwner("john");
        getClient().createCalendar(monCal);
    }


    @Given("^I log with \"([^\"]*)\"$")
    public void I_log_with(String arg1) throws Throwable {

        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
