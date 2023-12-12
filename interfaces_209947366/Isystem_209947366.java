package interfaces_209947366;
import Clases_209947366.*;

import java.util.List;

public interface Isystem_209947366 {
    String systemgetname();
    int systemgetchtact();
    List<Chatbot_209947366> getchatbotlist();
    User_209947366 getactiveuser();
    List<User_209947366> getuserlist();
    int getinitialcht();
    void systemAddChatbot(Chatbot_209947366... cht);
    void systemAddUser(User_209947366 newuser);
    void systemLogin(User_209947366 user);
    void systemLogout();
    void systemtalk(String msg);
    void systemsynthesis(User_209947366 user);





}
