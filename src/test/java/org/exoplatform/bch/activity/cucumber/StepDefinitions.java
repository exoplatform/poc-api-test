package org.exoplatform.bch.activity.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.exoplatform.bch.activity.Activity;
import org.exoplatform.bch.activity.client.retrofit.ApiRequestInterceptor;
import org.exoplatform.bch.activity.client.retrofit.RestClient;
import retrofit.RestAdapter;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bdechateauvieux on 4/23/15.
 */
public class StepDefinitions {
    private static final String USERNAME = null;
    private static final String PASSWORD = null;

    private final RestClient activityClient;
    List<Activity> stream = null;
    private Long activityId;

    public StepDefinitions() {
        ApiRequestInterceptor requestInterceptor = new ApiRequestInterceptor(USERNAME, PASSWORD);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .setRequestInterceptor(requestInterceptor)
                .build();
        activityClient = restAdapter.create(RestClient.class);
    }

    @Given("^I publish an activity with title \"(.*)\"$")
    public void iPublishActivity(String title) throws Throwable {
        //TODO authenticate
        activityId = activityClient.post(new Activity(title));
    }

    @When("^I consult my Activity Stream$")
    public void iConsultActivityStream() throws Throwable {
        //TODO authenticate
        stream = activityClient.getStream();
    }

    @Then("^this activity is present in the stream$")
    public void thisActivityIsPresentInTheStream() throws Throwable {
        //TODO authenticate
        assertThat(stream.get(0).getId(), is(activityId));
    }
}
