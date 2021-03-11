package kz.abzal.data;

import java.sql.Connection;
public interface IDB { //Interface for database
    Connection getConnection();
}
