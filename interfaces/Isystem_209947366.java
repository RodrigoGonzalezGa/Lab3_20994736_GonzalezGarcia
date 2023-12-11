package interfaces;
import Clases.*;

import java.util.List;

public interface Isystem_209947366 {
    String systemgetname();
    int systemgetchtact();
    List<Chatbot> getchatbotlist();
    User getactiveuser();
    List<User> getuserlist();
    int getinitialcht();
    void systemAddChatbot(Chatbot... cht);
    void systemAddUser(User newuser);
    void systemLogin(User user);
    void systemLogout();
    void systemtalk(String msg);
    void systemsynthesis(User user);





}
