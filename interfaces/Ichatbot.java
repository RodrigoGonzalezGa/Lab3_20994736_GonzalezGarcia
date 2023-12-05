package interfaces;
import Clases.*;
import java.util.List;

public interface Ichatbot {
    int getid();
    String getname();
    String getmsg();
    int getflowid();
    int getinitialflow();
    List<Flow> getflows();
    void chatbotAddFlow(Flow... flowlist);
    void resetchatbot();
    void setflowactual(int flid);

}
