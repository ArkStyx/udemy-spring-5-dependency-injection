package guru.springframework.sfgdependencyinjection.controllers;

import org.springframework.stereotype.Controller;

import guru.springframework.sfgdependencyinjection.services.primary.PrimaryGreetingServiceImpl;

@Controller
public class MyController {

	private final PrimaryGreetingServiceImpl primaryGreetingServiceImpl;
	
	public MyController(PrimaryGreetingServiceImpl primaryGreetingServiceImpl) {
		super();
		this.primaryGreetingServiceImpl = primaryGreetingServiceImpl;
	}

	public String sayHello() {
		return primaryGreetingServiceImpl.sayGreeting();
	}
}
