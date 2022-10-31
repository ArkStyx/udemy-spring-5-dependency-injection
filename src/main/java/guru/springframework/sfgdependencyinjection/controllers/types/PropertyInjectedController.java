package guru.springframework.sfgdependencyinjection.controllers.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdependencyinjection.services.GreetingService;

@Controller
public class PropertyInjectedController {

	/* 
	 * La pire façon d'injecter une dependance 
	 */
	@Qualifier("propertyGreetingServiceImpl")
	@Autowired
	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
