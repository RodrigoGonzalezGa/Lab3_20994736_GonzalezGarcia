package interfaces_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.*;

import java.util.List;

public interface Isystem_209947366_GonzalezGarcia {
    String systemgetname();
    int systemgetchtact();
    List<Chatbot_209947366_GonzalezGarcia> getchatbotlist();
    User_209947366_GonzalezGarcia getactiveuser();
    List<User_209947366_GonzalezGarcia> getuserlist();
    int getinitialcht();
    void systemAddChatbot(Chatbot_209947366_GonzalezGarcia... cht);
    void systemAddUser(User_209947366_GonzalezGarcia newuser);
    void systemLogin(User_209947366_GonzalezGarcia user);
    void systemLogout();
    void systemtalk(String msg);
    void systemsynthesis(User_209947366_GonzalezGarcia user);





}
