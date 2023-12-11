package Clases;

import interfaces.Iuser;

public class User implements Iuser {
    public String name;
    public String history;
    public boolean isadmin;

    public User(String name){
        super();
        this.name=name;
        this.history="";
        this.isadmin=false;
    }
    @Override
    public String getname(){
        return this.name;
    }
    @Override
    public String gethistory(){
        return this.history;
    }
    @Override
    public void appendhistory(String text){
        this.history=this.history+text;
    }
}
