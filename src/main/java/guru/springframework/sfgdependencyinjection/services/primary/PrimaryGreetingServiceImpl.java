package guru.springframework.sfgdependencyinjection.services.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Primary
@Service
public class PrimaryGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World Primary Bean";
	}

}
