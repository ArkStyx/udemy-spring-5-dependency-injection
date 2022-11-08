package guru.springframework.sfgdependencyinjection.services.primary;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class PrimaryGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Primary Bean";
	}

}
