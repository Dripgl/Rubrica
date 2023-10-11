package DAO;

import Model.User;

public class UserDAO extends AbstractDAO<User> {

    public UserDAO() { super("user.csv");}
}
