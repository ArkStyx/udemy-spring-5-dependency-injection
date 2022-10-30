package guru.springframework.sfgdependencyinjection.controllers;

import org.springframework.stereotype.Controller;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Controller
public class ConstructorInjectedController {

	private final GreetingService greetingService;

	public ConstructorInjectedController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
