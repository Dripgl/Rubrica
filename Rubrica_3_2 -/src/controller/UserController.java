package controller;

import Service.UserService;
import Model.User;

public class UserController extends AbstractController<User> {

    public UserController() {super(new UserService());}
}
