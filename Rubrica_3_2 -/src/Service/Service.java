package Service;

import java.util.List;
import Model.EntityWrapper;

public interface Service<Model extends EntityWrapper> {

    void add(Model m);

    List<Model> getAll();
}
