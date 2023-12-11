package Clases;

import interfaces.Ioption;

import java.util.ArrayList;
import java.util.List;

public class Option implements Ioption {
    public int id;
    public String msg;
    public int chtlink;
    public int flowlink;
    public List<String> keywords;
    public Option(int id,String msg,int chtlink,int flowlink,String... keywords){
        this.id=id;
        this.msg=msg;
        this.chtlink=chtlink;
        this.flowlink=flowlink;
        this.keywords= new ArrayList<>();
        for(String key:keywords){
            this.keywords.add(key.toLowerCase());
        }
    }


    @Override
    public int getid() {
        return id;

    }
    @Override
    public String getmsg(){
        return msg;
    }
    @Override
    public int getchtlink(){
        return chtlink;
    }
    @Override
    public int getflowlink(){
        return flowlink;
    }
    @Override
    public List<String> getkeywords(){
        return keywords;
    }
}