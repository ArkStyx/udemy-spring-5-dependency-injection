package com.springframework.pets.factories;

import com.springframework.pets.CatPetService;
import com.springframework.pets.DogPetService;
import com.springframework.pets.PetService;

import guru.springframework.sfgdependencyinjection.utilities.ProfilUtilities;

public class PetServiceFactory {

	public PetService getPetService(String petType) {
		switch (petType) {
			case ProfilUtilities.DOG:
				return new DogPetService();
			case ProfilUtilities.CAT:
				return new CatPetService();
			default:
				return new DogPetService();
		}
	}
	
}
