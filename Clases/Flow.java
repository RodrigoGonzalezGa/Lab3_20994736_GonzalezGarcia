package Clases;
import interfaces.Iflow;
import java.util.List;

public class Flow implements Iflow {
    public int id;
    public String nombremsg;
    public List<Option> optionlist;
    public Flow(int id, String msg, Option... oplist){
        this.id=id;
        this.nombremsg=msg;
        this.optionlist=List.of(oplist);
    }
    @Override
    public int getid(){
        return this.id;
    }
    @Override
    public String getnamemsg(){
        return this.nombremsg;
    }
    @Override
    public List<Option> getoptions(){
        return this.optionlist;
    }
    public void flowAddOption(Option... opl){
        for (Option op: opl) {
            if(this.optionlist.contains(op)) {
                this.optionlist.add(op);
            }
        }
    }
}
