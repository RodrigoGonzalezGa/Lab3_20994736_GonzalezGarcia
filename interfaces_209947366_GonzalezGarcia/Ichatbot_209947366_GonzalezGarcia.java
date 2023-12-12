package interfaces_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.*;
import java.util.List;

public interface Ichatbot_209947366_GonzalezGarcia {
    int getid();
    String getname();
    String getmsg();
    int getflowid();
    int getinitialflow();
    List<Flow_209947366_GonzalezGarcia> getflows();
    boolean checkidrepeat(Flow_209947366_GonzalezGarcia fl);
    void chatbotAddFlow(Flow_209947366_GonzalezGarcia... flowlist);
    void resetchatbot();
    void setflowactual(int flid);

}
