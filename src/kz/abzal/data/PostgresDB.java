package kz.abzal.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements IDB{
    @Override
    public Connection getConnection(){// Connecting to database
        String connectionURL= "jdbc:postgresql://127.0.0.1:5432/postgres"; // link of postgres online dabatabe
        try{
            Class.forName("org.postgresql.Driver"); // postgresql driver
            Connection con= DriverManager.getConnection(connectionURL, "postgres","Alpa101p"); // connecting
            return con;
        } catch (Exception e){ //catching connection exceptions
            System.out.println(e); // output the error
            return null;
        }
    }
}
