import interfaces.*;

import Clases.*;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Option o1=new Option(1,"quepaaaasa",1,1,"hola","davinki??");
        Option o2=new Option(2,"quepaaaasa",1,1,"pan","queso" );
        Flow f1= new Flow(1,"Hola", o1,o2);
        f1.flowAddOption(o2);
        Admin a1=new Admin("Blahaj");
        a1.appendhistory("sharks are cool");
        Chatbot c1= new Chatbot(1,"aaa","bbbbb",1);
        System.out.println(c1.flowid);
        System.out.println("  ini:");
        System.out.println(c1.initialflow);
        //ejemplo de copia de lista, sirve de algo? idk
        /*List<String> sl1 =new ArrayList<String>();
        sl1.add("a");
        sl1.add("b");
        List<String> sl2 = new ArrayList<String>(sl1);
        sl2.add("morbilanga");*/



    }
}
