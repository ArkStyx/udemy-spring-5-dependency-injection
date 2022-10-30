package guru.springframework.sfgdependencyinjection.services;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World";
	}

}
