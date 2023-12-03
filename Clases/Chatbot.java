package Clases;

import interfaces.Ichatbot;
import java.util.ArrayList;
import java.util.List;

public class Chatbot implements Ichatbot {
    public int id;
    public String name;
    public String msg;
    public int flowid;
    public int initialflow;
    public List<Flow> flowlist;
    public Chatbot(int id, String name,String msg, int flowid,Flow... fl){
        this.id=id;
        this.name=name;
        this.msg=msg;
        this.flowid=flowid;
        this.initialflow=flowid;
        this.flowlist=new ArrayList<Flow>();
        for(Flow flow: fl){
            if(!this.flowlist.contains(flow)){
                this.flowlist.add(flow);
            }
        }
    }
    @Override
    public int getid(){
        return this.id;
    }
    @Override
    public String getname(){
        return this.name;
    }
    @Override
    public String getmsg(){
        return this.msg;
    }
    @Override
    public int getflowid(){
        return this.flowid;
    }
    @Override
    public int getinitialflow(){
        return this.initialflow;
    }
    @Override
    public List<Flow> getflows(){
        return this.flowlist;
    }
    @Override
    public void chatbotAddFlow(Flow... flowlist){
        for (Flow fl: flowlist){
            if(!this.flowlist.contains(fl)){
                this.flowlist.add(fl);
            }
        }
    }

}
