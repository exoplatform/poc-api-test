package org.exoplatform.fqa.calendar;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import org.exoplatform.BaseStepDefinitions;
import org.exoplatform.client.retrofit.ApiRequestInterceptor;
import org.exoplatform.client.retrofit.RestClient;
import org.exoplatform.bch.calendar.category.Category;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef_Calendar_Category extends BaseStepDefinitions{
	private static final String USERNAME = "john";
    private static final String PASSWORD = "gtn";

    private final RestClient activityClient;
    List<Category> categories = null;

    public StepDef_Calendar_Category() {
        ApiRequestInterceptor requestInterceptor = new ApiRequestInterceptor(USERNAME, PASSWORD);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(LogLevel.FULL)
                .build();
        activityClient = restAdapter.create(RestClient.class);
    }

    @Given("^I publish an category with title \"(.*)\"$")
    public void iPublishAnCategoryWithTitle(String title) throws Throwable {
        //TODO authenticate
    }

    @When("^I get the list of categories$")
    public void iGetTheListOfCategories() throws Throwable {
        //TODO authenticate
    	categories = activityClient.getCategories().getData();
        System.out.println(categories);
    }

    @Then("^the list contains more than 1 item$")
    public void theListOfCategoryContainsMoreThanOneItem() throws Throwable {
        //TODO authenticate
     assertTrue(categories.size()>0);
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
}
