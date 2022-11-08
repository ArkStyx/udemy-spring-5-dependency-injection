package guru.springframework.sfgdependencyinjection.services.types;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class SetterGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Setter";
	}

}
