package guru.springframework.sfgdependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdependencyinjection.controllers.MyController;

@SpringBootApplication
public class SfgDependencyInjectionApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SfgDependencyInjectionApplication.class, args);
		
		/* Le Contexte Spring cree une instance de MyController  - Donc pas besoin de new */
		MyController myController = (MyController) ctx.getBean("myController");
		
		String greetings = myController.sayHello();
		System.out.println("greetings : " + greetings);
	}

}
