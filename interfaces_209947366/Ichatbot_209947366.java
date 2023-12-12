package interfaces_209947366;
import Clases_209947366.*;
import java.util.List;

public interface Ichatbot_209947366 {
    int getid();
    String getname();
    String getmsg();
    int getflowid();
    int getinitialflow();
    List<Flow_209947366> getflows();
    boolean checkidrepeat(Flow_209947366 fl);
    void chatbotAddFlow(Flow_209947366... flowlist);
    void resetchatbot();
    void setflowactual(int flid);

}
