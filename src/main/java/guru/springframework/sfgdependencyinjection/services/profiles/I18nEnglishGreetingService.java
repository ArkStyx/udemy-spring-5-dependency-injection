package guru.springframework.sfgdependencyinjection.services.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - EN";
	}

}
