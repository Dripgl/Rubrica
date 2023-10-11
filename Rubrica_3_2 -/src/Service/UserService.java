package Service;

import DAO.UserDAO;
import Model.User;

public class UserService extends AbstractService<User> {

    public UserService(){ super(new UserDAO());}
}
