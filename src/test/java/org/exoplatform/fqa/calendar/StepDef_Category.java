package org.exoplatform.fqa.calendar;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import cucumber.api.PendingException;
import org.exoplatform.ConnectedStepDefinitions;
import org.exoplatform.bch.calendar.category.Category;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef_Category extends ConnectedStepDefinitions {
    List<Category> categories = null;




    @When("^I get the list of categories$")
    public void iGetTheListOfCategories() throws Throwable {
        //TODO authenticate
    	categories = getClient().getCategories().getData();
        System.out.println(categories);
    }

    
    @Then("^the list contains the default categories$")
    public void theListOfCategoryContainsTheDefaultCategories() throws Throwable {
        //TODO authenticate
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameAll"))));
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameMeeting"))));
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameCalls"))));
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameClients"))));
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameHoliday"))));
        assertThat(categories, hasItem(hasProperty("name", equalTo("defaultEventCategoryNameAnniversary"))));
    }

    @Given("^I add a personnal category$")
    public void I_had_a_personnal_category() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
