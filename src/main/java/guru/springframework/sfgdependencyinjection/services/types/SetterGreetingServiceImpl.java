package guru.springframework.sfgdependencyinjection.services.types;

import org.springframework.stereotype.Service;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Service
public class SetterGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Setter";
	}

}
