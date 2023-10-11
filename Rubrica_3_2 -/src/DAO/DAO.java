package DAO;

import Model.EntityWrapper;

import java.util.List;

public interface DAO<Model extends EntityWrapper> {

    Model add(Model m);

    List<Model> getAll() throws Exception;
}
