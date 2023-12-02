import interfaces.*;

import Clases.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Option o1=new Option(1,"quepaaaasa",1,1,"hola","davinki??");
        Option o2=new Option(2,"quepaaaasa",1,1,"pan","queso" );
        System.out.println(o1.getkeywords());
        Flow f1= new Flow(1,"Hola", o1, o2);
        System.out.println(f1.getoptions());


    }
}
