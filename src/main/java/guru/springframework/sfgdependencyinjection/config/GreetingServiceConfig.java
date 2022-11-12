package guru.springframework.sfgdependencyinjection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.pets.PetService;
import com.springframework.pets.factories.PetServiceFactory;

import guru.springframework.sfgdependencyinjection.datasource.FakeDataSource;
import guru.springframework.sfgdependencyinjection.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdependencyinjection.services.primary.PrimaryGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.profiles.I18nEnglishGreetingService;
import guru.springframework.sfgdependencyinjection.services.profiles.I18nSpanishGreetingService;
import guru.springframework.sfgdependencyinjection.services.types.ConstructorGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.types.PropertyGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.services.types.SetterGreetingServiceImpl;
import guru.springframework.sfgdependencyinjection.utilities.ProfilUtilities;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

	/*
	 * Ici c'est juste un cas d'exemple. On doit prefere @Service dans la classe ConstructorGreetingServiceImpl
	 * 
	 * Le cas présenté ici est quand on doit utiliser une librairie tiers-partie
	 * 
	 * Dans le cas où le code nous appartient, nous utilisons les stereotypes Spring pour declarer nos composants
	 */
	//@Bean		====>	DEPLACE DANS LE FICHIER sfgdi-config.xml
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
	
	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
	
	/*
	 * Ici on utilise @Bean("i18nService"), ce qui correspond à l'annotation @Service("i18nService")
	 */
	@Profile("EN")
	@Bean("i18nService")
	I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}
	
	@Profile({"ES", "default"})
	@Bean("i18nService")
	I18nSpanishGreetingService i18nSpanishGreetingService() {
		return new I18nSpanishGreetingService();
	}
	
	/* ---------------------------------------------------------------------------------------------------- */
	
	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}

	@Profile({ProfilUtilities.DOG, "default"})
	@Bean("petService")
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return	petServiceFactory.getPetService(ProfilUtilities.DOG);
	}
	
	@Profile(ProfilUtilities.CAT)
	@Bean("petService")
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService(ProfilUtilities.CAT);
	}
	
	/* ---------------------------------------------------------------------------------------------------- */
	
	/*
	 * IMPORTANT : Annoter la classe avec "@PropertySource("classpath:datasource.properties")" !!!!!
	 */
//	@Bean
//	FakeDataSource fakeDataSource(@Value("${guru.userName}") String userName, 
//								@Value("${guru.password}")String password, 
//								@Value("${guru.jdbcUrl}")String jdbcUrl) {
//		FakeDataSource fakeDataSource = new FakeDataSource();
//		fakeDataSource.setUserName(userName);
//		fakeDataSource.setPassword(password);
//		fakeDataSource.setJdbcUrl(jdbcUrl);
//		return fakeDataSource;
//	}
	
	/*
	 * SfgConfiguration etait un @Bean de type @Configuration, on peut l'utiliser directement ici
	 */
	@Bean
	FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUserName(sfgConfiguration.getUserName());
		fakeDataSource.setPassword(sfgConfiguration.getPassword());
		fakeDataSource.setJdbcUrl(sfgConfiguration.getJdbcUrl());
		return fakeDataSource;
	}
	
	
}
