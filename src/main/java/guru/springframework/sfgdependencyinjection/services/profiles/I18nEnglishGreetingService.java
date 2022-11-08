package guru.springframework.sfgdependencyinjection.services.profiles;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class I18nEnglishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - EN";
	}

}
