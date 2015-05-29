package org.exoplatform.fqa.calendar;

/**
 * Created by bdechateauvieux on 4/23/15.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.StepDefinition;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/org/exoplatform/fqa/calendar/calendar_calendar.feature",tags = {"~@eXoApiError","@Test"})
public class CalendarFuncTest {

}
