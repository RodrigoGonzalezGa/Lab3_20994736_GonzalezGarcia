package interfaces_209947366;
import Clases_209947366.Option_209947366;
import java.util.List;
public interface Iflow_209947366 {
    int getid();
    String getnamemsg();
    List<Option_209947366> getoptions();
    void flowAddOption(Option_209947366... opl);
    boolean checkidrepeat(Option_209947366 op);
}
