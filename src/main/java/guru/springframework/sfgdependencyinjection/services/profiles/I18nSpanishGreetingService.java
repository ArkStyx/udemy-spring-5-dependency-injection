package guru.springframework.sfgdependencyinjection.services.profiles;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class I18nSpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hola Todo El Mundo - ES";
	}

}
