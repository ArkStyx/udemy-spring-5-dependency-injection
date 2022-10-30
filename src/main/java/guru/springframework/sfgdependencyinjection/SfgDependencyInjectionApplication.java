package guru.springframework.sfgdependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdependencyinjection.controllers.ConstructorInjectedController;
import guru.springframework.sfgdependencyinjection.controllers.MyController;
import guru.springframework.sfgdependencyinjection.controllers.PropertyInjectedController;
import guru.springframework.sfgdependencyinjection.controllers.SetterInjectedController;

@SpringBootApplication
public class SfgDependencyInjectionApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SfgDependencyInjectionApplication.class, args);
		
		/* Le Contexte Spring cree une instance de MyController  - Donc pas besoin de new */
		MyController myController = (MyController) ctx.getBean("myController");
		String greetings = myController.sayHello();
		System.out.println("greetings : " + greetings);
		
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
