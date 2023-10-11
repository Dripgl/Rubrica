package controller;

import Service.RubricaService;
import Model.Contact;

public class RubricaController extends AbstractController<Contact> {

    public RubricaController(){

        super(new RubricaService());

    }

    public Contact searchContact(String name, String surname) {
        return ((RubricaService) service).searchContact(name, surname);
    }

    public void prova() { ((RubricaService)service).prova();}

}

