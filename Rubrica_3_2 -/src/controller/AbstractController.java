package controller;

import java.util.List;
import Model.EntityWrapper;
import Service.Service;

public abstract  class AbstractController<Model extends EntityWrapper> implements  Controller<Model> {

    protected Service<Model> service;

    public AbstractController(Service<Model> service) { this.service = service; }

    @Override
    public List<Model> getAll() {return service.getAll(); }

    @Override
    public void add(Model m) {service.add(m); }

}
