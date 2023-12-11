package interfaces;
import Clases.Option;
import java.util.List;
public interface Iflow {
    int getid();
    String getnamemsg();
    List<Option> getoptions();
    void flowAddOption(Option... opl);
    boolean checkidrepeat(Option op);
}
