import Clases_209947366.Chatbot_209947366;
import Clases_209947366.Flow_209947366;
import Clases_209947366.Menu.MenuPrincipal_209947366;
import Clases_209947366.Option_209947366;


public class Main {
    public static void main(String[] args) {
        //Elementos iniciales del sistema
        Option_209947366 o1=new Option_209947366(1,"1) Mall",1,1,"Mall","Tiendas");
        Option_209947366 o2=new Option_209947366(2,"2) Restaurante",2,1,"Comer","Almorzar");
        Flow_209947366 f1=new Flow_209947366(1,"A donde quieres ir?",o1,o2);
        Chatbot_209947366 c1=new Chatbot_209947366(0,"Inicial","Bienvenido, a donde quieres ir?",1,f1);
        Option_209947366 o3=new Option_209947366(1,"1)Modelos de plastico",1,2,"gunpla","modelo","modelo de plastico");
        Option_209947366 o4=new Option_209947366(2,"2)Herramientas de modelaje",1,2,"Herramientas","Alicate","Lija");
        Option_209947366 o5=new Option_209947366(3,"Pintura",1,2,"Pintura","Tamiya","GW","paint","pintar");
        Flow_209947366 f2= new Flow_209947366(2,"Bienvenido a la tienda de hobby",o3,o4,o5);
        Option_209947366 o6=new Option_209947366(1,"1)Tienda de Hobbie",1,2,"Hobbie","Plamo","Maquetas");
        Option_209947366 o7=new Option_209947366(2,"2)Tienda de ropa",1,3,"Ropa","Poleras");
        Flow_209947366 f3=new Flow_209947366(1,"A donde quieres ir?",o6,o7);
        Chatbot_209947366 c2= new Chatbot_209947366(1,"Mall","bienvenido al Mall",1,f3);
        Option_209947366 o8=new Option_209947366(1,"1)Poleras",1,3,"Poleras");
        Option_209947366 o9=new Option_209947366(2,"2)Pantalones",1,3,"Pantalones");
        Flow_209947366 f4=new Flow_209947366(3,"Que ropa quieres comprar?",o8,o9);
        c2.chatbotAddFlow(f2,f4);
        Option_209947366 o10=new Option_209947366(1,"1) Vegano",2,1,"Vegano","Veganismo");
        Option_209947366 o11=new Option_209947366(2,"2) Italiano",2,1,"Italiano");
        Flow_209947366 f5=new Flow_209947366(1,"A que tipo de restaurante quieres ir?",o10,o11);
        Chatbot_209947366 c3=new Chatbot_209947366(2,"Restaurante","Bienvenido a la calle de los restaurantes",1,f5);

        MenuPrincipal_209947366 m1=new MenuPrincipal_209947366();
        m1.sistema.systemAddChatbot(c1,c2,c3);
        m1.run();



    }
}
