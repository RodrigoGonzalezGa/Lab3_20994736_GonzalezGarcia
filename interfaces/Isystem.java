package interfaces;
import Clases.*;

import java.util.List;

public interface Isystem {
    String systemgetname();
    int systemgetchtact();
    List<Chatbot> getchatbotlist();
    User getactiveuser();
    List<User> getuserlist();
    int getinitialcht();
    void systemAddChatbot(Chatbot... cht);
    void systemAddUser(User user);
    void systemLogin(User user);
    void systemLogout();




}
