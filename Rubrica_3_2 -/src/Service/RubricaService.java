package Service;

import DAO.RubricaDAO;
import Model.Contact;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class RubricaService extends AbstractService<Contact> {

    private final static Logger logger = LogManager.getLogger(RubricaService.class);

    //private final static RubricaDAO dao = new RubricaDAO();

    public RubricaService() { super(new RubricaDAO());}

    public Contact searchContact(String name, String surname){
        Contact toReturn;
        toReturn = null;
        try {
            toReturn = ((RubricaDAO) dao).get(name, surname);
        } catch (IOException e) {
            logger.error("Error in reading phonebook file", e);
        }
        if (toReturn == null)
            logger.warn("Contact with name : {}, surname: {} not found", name, surname);
            else
                logger.info("Found contact: {}", toReturn.toString());
                return toReturn;
    }

   /* public List<Contact> getAll(){
        try {
            return dao.getAll();
        } catch (IOException | CsvValidationException e){
            logger.error("");
        }
        return null;
    }*/

    public void prova(){
        logger.fatal("OK");
        logger.error("OK");
        logger.warn("OK");
        logger.info("OK");
        logger.debug("OK");
    }
}
