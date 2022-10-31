package guru.springframework.sfgdependencyinjection.services.types;

import org.springframework.stereotype.Service;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Constructor";
	}

}
