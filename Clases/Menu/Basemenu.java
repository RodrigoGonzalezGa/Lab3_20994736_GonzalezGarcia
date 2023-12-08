package Clases.Menu;

import Clases.Option;
import java.util.Scanner;
import java.util.List;

public abstract class Basemenu {
    String mensajeinicial;
    Scanner usersel=new Scanner(System.in);
    int selection;
    abstract void showop();

}
