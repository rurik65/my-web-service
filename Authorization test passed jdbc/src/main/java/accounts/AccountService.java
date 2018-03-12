package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.DBServiceImpl;
import dbService.dataSets.UsersDataSet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private DBService dbServiceProfile;

    public AccountService() {
        dbServiceProfile = new DBServiceImpl();
    }

    public void addNewUser(UserProfile userProfile) throws dbService.DBException{
        try {
            dbServiceProfile.addUser(userProfile.getLogin(), userProfile.getPass());
        }catch (Exception e){throw new dbService.DBException(e);
        }
    }

    public UserProfile getUserByLogin(String login) throws dbService.DBException{
       try {
           UsersDataSet dataSet = dbServiceProfile.getUserLogin(login);

        return new UserProfile(dataSet.getName(), dataSet.getPassword());
    } catch (NullPointerException e){ e.printStackTrace();return new UserProfile("","test");}
    catch (Exception e){throw new dbService.DBException(e);}

 //   public UserProfile getUserBySessionId(String sessionId) {return sessionIdToProfile.get(sessionId);}

  /*  public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }*/

 /*   public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }*/
}
}
