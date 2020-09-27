package resources;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void beforeScenario(Scenario s)
	{
		System.out.println("Starting the scenario "+s.getName() + s.getId());
	}
	
	
	@After
	public void afterScenario(Scenario s)
	{
		System.out.println("Scenario execution completed"+s.getName() + s.getStatus());
	}
	

}
