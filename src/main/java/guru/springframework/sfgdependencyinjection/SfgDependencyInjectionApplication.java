package guru.springframework.sfgdependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdependencyinjection.controllers.MyController;
import guru.springframework.sfgdependencyinjection.controllers.pets.PetController;
import guru.springframework.sfgdependencyinjection.controllers.profiles.I18nController;
import guru.springframework.sfgdependencyinjection.controllers.types.ConstructorInjectedController;
import guru.springframework.sfgdependencyinjection.controllers.types.PropertyInjectedController;
import guru.springframework.sfgdependencyinjection.controllers.types.SetterInjectedController;

@SpringBootApplication
public class SfgDependencyInjectionApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SfgDependencyInjectionApplication.class, args);
		
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("----- The Best Pet is ");
		System.out.println(petController.whichPetIsTheBest());
		
		System.out.println("----- Profile Controller");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		
		System.out.println("----- Primary Bean Controller");
		/* Le Contexte Spring cree une instance de MyController  - Donc pas besoin de new */
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());
		
		System.out.println("----- Property Injected Controller");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("----- Setter Injected Controller");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		
		System.out.println("----- Constructor Injected Controller");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
