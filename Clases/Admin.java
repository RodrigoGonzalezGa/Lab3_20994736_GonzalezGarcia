package Clases;

public class Admin extends User{
    public Admin(String name){
        super(name);
        this.name=name;
        this.history="";
        this.isadmin=true;
    }

}
