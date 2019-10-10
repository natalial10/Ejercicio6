package com.eiv.ejercicio6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration

public class App {

    public static final ApplicationContext CTX;
    private static final String SQL;


    static {

        CTX = new ClassPathXmlApplicationContext("app-config.xml");
        SQL = "SELECT * FROM bancos ORDER BY banco";

    }
    
    public static void main(String[] args) {

        App app = CTX.getBean(App.class);

        app.run();

    }

    public void run() {


        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                System.out.println(String.format("BANCOS:[%s] %s",
                        rs.getString("banco"),rs.getString("denominacion")));
        
            }

        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage(), e);

        }

    }


    @Autowired private Connection connection;
}

