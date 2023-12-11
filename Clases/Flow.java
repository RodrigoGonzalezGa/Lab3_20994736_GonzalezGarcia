package Clases;
import interfaces.Iflow;

import java.util.ArrayList;
import java.util.List;

public class Flow implements Iflow{
    public int id;
    public String nombremsg;
    public List<Option> optionlist;
    public Flow(int id, String msg, Option... oplist){
        this.id=id;
        this.nombremsg=msg;
        this.optionlist=new ArrayList<Option>();
        for(Option op: oplist){
            if(!this.optionlist.contains(op)){
                this.optionlist.add(op);
            }
        }
        this.optionlist=new  ArrayList<Option>(List.of(oplist));
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
    public List<Option> getoptions() {
        return this.optionlist;
    }
    @Override
    public void flowAddOption(Option... opl){
            for(Option op: opl){
                if(!(this.checkidrepeat(op))){
                    this.optionlist.add(op);
                }
            }
    }
    @Override
    public boolean checkidrepeat(Option op){
        for(Option opfromlist: this.optionlist){
            if(op.id==opfromlist.id){
                return true;
            }
        }
        return false;
    }

}
