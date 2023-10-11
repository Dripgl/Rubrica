package Service;

import DAO.DAO;

import Model.EntityWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class AbstractService<Model extends EntityWrapper> implements Service<Model>{

    protected final Logger logger = LogManager.getLogger(AbstractService.class);

    protected DAO<Model> dao;

    public AbstractService(DAO<Model> dao) {this.dao = dao; }

    @Override
    public void add(Model m) {
        Model added = dao.add(m);
        if(added != null)
            logger.info(" {} added successfully", added);
    }

    @Override
    public List<Model> getAll() {
        try {
            return dao.getAll();
        } catch (Exception e) {
            logger.error("Error in reading csv file", e);
        }
        return null;
    }

}
