package kz.abzal;

import kz.abzal.Entities.User;
import kz.abzal.repositories.IRepositories;

import java.sql.Array;

public class Controller {
    //controller class between repositories and GUI
    private final IRepositories repo;

    public Controller(IRepositories repo ){
        this.repo=repo;
    }
    public boolean checkPass(String login, String pass){
        return repo.checkPass(login,pass);
    }

    public IRepositories getRepo() {
        return repo;
    }
    public User getUserById(int id){
        return repo.getUserById(id);
    }
    public void addToId(int id, int sum){
        repo.addToId(id,sum);
    }
    public void subToId(int id, int sum){
        repo.subToId(id,sum);

    }
    public void resetCredit(int id){
        repo.resetCredit(id);
    }
}
