package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.service.UserService;


import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("max", "payne", (byte) 35);
        userService.saveUser("harry", "debua", (byte) 47);
        userService.saveUser("robbin", "hood", (byte) 30);
        userService.saveUser("cup", "head", (byte) 2);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
