package DAO;

import Model.EntityWrapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDAO<Model extends EntityWrapper> implements DAO<Model> {

    protected final Logger logger = LogManager.getLogger(AbstractDAO.class);

    protected String FILENAME;

    public AbstractDAO(String FILENAME){ this.FILENAME = FILENAME; }

    Class<Model> getParameterClass() {
        return (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    @Override
    public Model add(Model m) {

    Model toReturn = null;

    try {
        FileWriter fileWriter = new FileWriter(FILENAME, true);

        StatefulBeanToCsvBuilder<Model> statefulBeanToCsvBuilder = new StatefulBeanToCsvBuilder<Model>(fileWriter).withSeparator(',').withQuotechar('\'').withApplyQuotesToAll(false);
        StatefulBeanToCsv<Model> statefulBeanToCsv = statefulBeanToCsvBuilder.build();

        statefulBeanToCsv.write(m);
        fileWriter.close();
        toReturn = m;
    } catch (IOException e) {
        logger.error("Error in adding contact: {}", m.toString(), e);
    }catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
        logger.error("Error in parsing contact: {} into csv entry ", m.toString(), e);
    }
    return toReturn;

    }

    @Override
public List<Model> getAll() {
        try {
            FileReader fileReader = new FileReader(FILENAME);

            CsvToBeanBuilder<Model> builder = new CsvToBeanBuilder<Model>(fileReader).withType(getParameterClass()).withSeparator(',').withSkipLines(0);
            CsvToBean<Model> csvToBean = builder.build();
            List<Model> list = csvToBean.parse();

            fileReader.close();
            return list;
        } catch (IOException e) {
            logger.error("Error in reading fil {}", FILENAME, e);
        }

        return null;
    }
}
