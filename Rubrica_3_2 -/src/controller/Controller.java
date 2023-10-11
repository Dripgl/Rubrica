package controller;

import java.util.List;
import Model.EntityWrapper;

public interface Controller<Model extends EntityWrapper> {

    List<Model> getAll();

    void add(Model m);
}
