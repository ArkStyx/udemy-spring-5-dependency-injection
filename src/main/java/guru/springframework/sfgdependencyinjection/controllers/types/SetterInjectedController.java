package guru.springframework.sfgdependencyinjection.controllers.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Controller
public class SetterInjectedController {

	
	/*
	 * La seconde meilleure façon d'injecter des dépendances
	 */
	private GreetingService greetingService;

	@Qualifier("setterGreetingServiceImpl")
	@Autowired
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
	
}
