package guru.springframework.sfgdependencyinjection.controllers.pets;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdependencyinjection.services.pets.PetService;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController {

    private final PetService petService;

    public PetController(@Qualifier("petService") PetService petService) {
		super();
		this.petService = petService;
	}

	public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
