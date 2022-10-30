package guru.springframework.sfgdependencyinjection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.sfgdependencyinjection.controllers.SetterInjectedController;
import guru.springframework.sfgdependencyinjection.services.GreetingServiceImpl;

@SpringBootTest
public class SetterInjectedControllerTest {

	SetterInjectedController controller;
	
	@BeforeEach
	void setUp() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new GreetingServiceImpl());
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}
}
