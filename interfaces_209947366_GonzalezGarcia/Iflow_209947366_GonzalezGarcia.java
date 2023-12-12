package interfaces_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.Option_209947366_GonzalezGarcia;
import java.util.List;
public interface Iflow_209947366_GonzalezGarcia {
    int getid();
    String getnamemsg();
    List<Option_209947366_GonzalezGarcia> getoptions();
    void flowAddOption(Option_209947366_GonzalezGarcia... opl);
    boolean checkidrepeat(Option_209947366_GonzalezGarcia op);
}
