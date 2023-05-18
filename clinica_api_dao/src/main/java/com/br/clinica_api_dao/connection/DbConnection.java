package com.br.clinica_api_dao.connection;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mariadb://150.136.101.49:3306/clinica_db";
    private static final String USERNAME = "admin";// Pega o valor definido no arquivo application.properties
    private static final String PASSWORD = "Xz.89";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
