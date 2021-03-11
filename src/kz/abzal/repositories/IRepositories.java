package kz.abzal.repositories;

import kz.abzal.Entities.User;

public interface IRepositories {
    User getUser();
    boolean checkPass(String login, String pass);
    User getUserById(int id);

    void addToId(int id, int sum);
    void subToId(int id, int sum);

    void resetCredit(int id);
}
