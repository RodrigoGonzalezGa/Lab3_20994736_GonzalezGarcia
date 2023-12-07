package Clases;

public class Admin extends User{
    boolean isadmin=true;
    public Admin(String name){
        super(name);
        this.name=name;
        this.history="";
    }

}
