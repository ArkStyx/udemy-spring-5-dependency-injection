package guru.springframework.sfgdependencyinjection.services.types;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class PropertyGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Property";
	}

}
