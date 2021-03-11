package kz.abzal.repositories;

import kz.abzal.Entities.User;
import kz.abzal.data.IDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginRepositories implements IRepositories{
    private final IDB db;
    private final User user;
    public LoginRepositories(IDB db, User user){
        this.db=db;
        this.user = user;
    }
    public boolean checkPass(String login, String pass) {
        Connection con= null;
        try {
            //cheking password
            con=db.getConnection();
            String sql= String.format("SELECT * FROM Logins WHERE login = '%s'",login);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int uid = -1;
            String l = null; //setting vars null, so later we can check
            String p = null;
            while (rs.next()){
                uid = rs.getInt("id");
                l = rs.getString("login");
                p = rs.getString("pass");
            }
            if (l != null){// if there is some data in db
                user.setId(uid);
                if (l.equals(login) && p.equals(pass)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }

        } catch (SQLException throwables) {
            return false;
        } finally {
            try {
                assert con != null; // closing connection
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public User getUserById(int id) {
        Connection con= null;
        try {
            //String pass = String.valueOf(pass_chr);
            con=db.getConnection();
            String sql= String.format("SELECT * FROM Persons WHERE id = '%d'",id);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            //creating user from db data
            user.setId(rs.getInt("id"));
            user.setFull_name(rs.getString("fullname"));
            user.setBalance(rs.getInt("balance"));
            user.setDeposit_balance(rs.getInt("deposit_balance"));
            user.setCredit_balance(rs.getInt("credit_balance"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            try {
                assert con != null;
                con.close();//closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void addToId(int id,int sum) {
        Connection con= null;
        try{
            //getting balance
            con=db.getConnection();
            String sql= String.format("SELECT balance FROM Persons WHERE id = '%d'",id);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int balance = rs.getInt("balance") + sum;
            //increasing balance
            sql= String.format("UPDATE Persons SET balance = %d WHERE id = '%d'",balance,id);
            st = con.createStatement();
            st.executeUpdate(sql);

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void subToId(int id,int sum) {
        Connection con= null;
        try{
            //getting balance
            con=db.getConnection();
            String sql= String.format("SELECT balance FROM Persons WHERE id = '%d'",id);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            System.out.println(id);
            System.out.println(sum);
            //decreasing balance
            int balance = rs.getInt("balance") - sum;
            System.out.println(balance);
            sql= String.format("UPDATE Persons SET balance = %d WHERE id = '%d'",balance,id);
            st = con.createStatement();
            st.executeUpdate(sql);

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void resetCredit(int id) {
        Connection con= null;
        try{
            //setting loan to 9
            con=db.getConnection();
            String sql= String.format("UPDATE Persons SET credit_balance = 0 WHERE id = '%d'",id);
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    //some getters
    public IDB getDb() {
        return db;
    }

    public User getUser() {
        return user;
    }
}
