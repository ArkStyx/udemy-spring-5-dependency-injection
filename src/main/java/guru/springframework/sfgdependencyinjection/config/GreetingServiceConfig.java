package guru.springframework.sfgdependencyinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import guru.springframework.sfgdependencyinjection.services.primary.PrimaryGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.profiles.I18nEnglishGreetingService;
import guru.springframework.sfgdependencyinjection.services.profiles.I18nSpanishGreetingService;
import guru.springframework.sfgdependencyinjection.services.types.ConstructorGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.types.PropertyGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.types.SetterGreetingServiceImpl;

@Configuration
public class GreetingServiceConfig {

	/*
	 * Ici c'est juste un cas d'exemple. On doit prefere @Service dans la classe ConstructorGreetingServiceImpl
	 * 
	 * Le cas présenté ici est quand on doit utiliser une librairie tiers-partie
	 * 
	 * Dans le cas où le code nous appartient, nous utilisons les stereotypes Spring pour declarer nos composants
	 */
	@Bean
	ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
		return new ConstructorGreetingServiceImpl();
	}
	
	@Bean
	PropertyGreetingServiceImpl propertyGreetingServiceImpl() {
		return new PropertyGreetingServiceImpl();
	}
	
	@Bean
	SetterGreetingServiceImpl setterGreetingServiceImpl() {
		return new SetterGreetingServiceImpl();
	}
	
	/* ---------------------------------------------------------------------------------------------------- */
	
	@Primary
	@Bean
	PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
		return new PrimaryGreetingServiceImpl();
	}
	
	/* ---------------------------------------------------------------------------------------------------- */
	
	/*
	 * Ici le service n'est pas nommé "i18nEnglishGreetingService" (le nom de la classe sans la 1ere lettre en capitale).
	 * Il est nommé "i18nService", ce qui correspond à l'annotation @Service("i18nService")
	 */
	@Profile("EN")
	@Bean()
	I18nEnglishGreetingService i18nService() {
		return new I18nEnglishGreetingService();
	}
	
	@Profile({"ES", "default"})
	@Bean("i18nService")
	I18nSpanishGreetingService i18nSpanishGreetingService() {
		return new I18nSpanishGreetingService();
	}
	
	
	
//	@Profile("EN")
//	@Bean("i18nService")
//	I18nEnglishGreetingService i18nEnglishGreetingService() {
//		return new I18nEnglishGreetingService();
//	}

	
	
	
}
