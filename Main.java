import interfaces.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> k1= new ArrayList<>();
        k1.add("morbilanga");
        Option o1=new Option(1,"quepaaaasa",1,1,k1 );
        System.out.println(o1.keywords);
    }
}
