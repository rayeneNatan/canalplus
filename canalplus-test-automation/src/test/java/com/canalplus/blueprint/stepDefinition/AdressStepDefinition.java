package com.canalplus.blueprint.stepDefinition;

import org.springframework.test.context.ActiveProfiles;

import cucumber.api.java8.Fr;

@ActiveProfiles("test")
public class AdressStepDefinition extends StepDefinition implements Fr {

    public AdressStepDefinition() {

	Etantdonné("un abonné avec une adresse principale active en France", () -> {
	    saveSubscriber();
	});

	Lorsque("le conseiller connecté à FACE modifie ladresse de l'abonné sans date d'effet", () -> {
	   updateAddress();
	});

	Alors("l'adresse de l'abonné modifiée est enregistrée sur lensemble des contrats de l'abonné", () -> {
	    getSubscriberContracts();
	});

	Alors("un mouvement de modification dadresse est créé", () -> {
	    getCreatedMovement();
	});

	Lorsque("le conseiller connecté à EC modifie ladresse de l'abonné sans date d'effet", () -> {

	});

    }

}
