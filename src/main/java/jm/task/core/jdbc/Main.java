package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.service.UserService;


import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import static jm.task.core.jdbc.util.Util.getSession;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;






    }
}
