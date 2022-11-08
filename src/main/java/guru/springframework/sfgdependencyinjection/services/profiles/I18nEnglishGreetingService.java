package guru.springframework.sfgdependencyinjection.services.profiles;

import guru.springframework.sfgdependencyinjection.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdependencyinjection.services.GreetingService;

public class I18nEnglishGreetingService implements GreetingService {

	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		super();
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String sayGreeting() {
		return "Hello World - EN";
	}

}
