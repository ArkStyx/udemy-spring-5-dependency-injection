package guru.springframework.sfgdependencyinjection.services.types;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class ConstructorGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Constructor";
	}

}
