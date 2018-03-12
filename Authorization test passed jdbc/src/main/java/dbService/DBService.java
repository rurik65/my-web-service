package dbService;

import dbService.dataSets.UsersDataSet;

public interface DBService {
    void addUser(String name, String password) throws dbService.DBException;
    UsersDataSet getUserLogin(String name) throws dbService.DBException;
}
