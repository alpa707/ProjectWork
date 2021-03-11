package kz.abzal;

import kz.abzal.Entities.User;
import kz.abzal.Frames.FLogin;
import kz.abzal.data.IDB;
import kz.abzal.data.PostgresDB;
import kz.abzal.repositories.IRepositories;
import kz.abzal.repositories.LoginRepositories;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();//making connection
        User user = new User();//making user
        LoginRepositories repos = new LoginRepositories(db, user);//making repo
        Controller control = new Controller(repos);//making controller
        FLogin login = new FLogin(control);//creating first frame
        login.start();//starting first UI
    }
}
