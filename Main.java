import Clases_209947366_GonzalezGarcia.Chatbot_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.Flow_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.Menu.MenuPrincipal_209947366_GonzalezGarcia;
import Clases_209947366_GonzalezGarcia.Option_209947366_GonzalezGarcia;


public class Main {
    public static void main(String[] args) {
        //Elementos iniciales del sistema
        Option_209947366_GonzalezGarcia o1=new Option_209947366_GonzalezGarcia(1,"1) Mall",1,1,"Mall","Tiendas");
        Option_209947366_GonzalezGarcia o2=new Option_209947366_GonzalezGarcia(2,"2) Restaurante",2,1,"Comer","Almorzar");
        Flow_209947366_GonzalezGarcia f1=new Flow_209947366_GonzalezGarcia(1,"A donde quieres ir?",o1,o2);
        Chatbot_209947366_GonzalezGarcia c1=new Chatbot_209947366_GonzalezGarcia(0,"Inicial","Bienvenido, a donde quieres ir?",1,f1);
        Option_209947366_GonzalezGarcia o3=new Option_209947366_GonzalezGarcia(1,"1)Modelos de plastico",1,2,"gunpla","modelo","modelo de plastico");
        Option_209947366_GonzalezGarcia o4=new Option_209947366_GonzalezGarcia(2,"2)Herramientas de modelaje",1,2,"Herramientas","Alicate","Lija");
        Option_209947366_GonzalezGarcia o5=new Option_209947366_GonzalezGarcia(3,"Pintura",1,2,"Pintura","Tamiya","GW","paint","pintar");
        Flow_209947366_GonzalezGarcia f2= new Flow_209947366_GonzalezGarcia(2,"Bienvenido a la tienda de hobby",o3,o4,o5);
        Option_209947366_GonzalezGarcia o6=new Option_209947366_GonzalezGarcia(1,"1)Tienda de Hobbie",1,2,"Hobbie","Plamo","Maquetas");
        Option_209947366_GonzalezGarcia o7=new Option_209947366_GonzalezGarcia(2,"2)Tienda de ropa",1,3,"Ropa","Poleras");
        Flow_209947366_GonzalezGarcia f3=new Flow_209947366_GonzalezGarcia(1,"A donde quieres ir?",o6,o7);
        Chatbot_209947366_GonzalezGarcia c2= new Chatbot_209947366_GonzalezGarcia(1,"Mall","bienvenido al Mall",1,f3);
        Option_209947366_GonzalezGarcia o8=new Option_209947366_GonzalezGarcia(1,"1)Poleras",1,3,"Poleras");
        Option_209947366_GonzalezGarcia o9=new Option_209947366_GonzalezGarcia(2,"2)Pantalones",1,3,"Pantalones");
        Flow_209947366_GonzalezGarcia f4=new Flow_209947366_GonzalezGarcia(3,"Que ropa quieres comprar?",o8,o9);
        c2.chatbotAddFlow(f2,f4);
        Option_209947366_GonzalezGarcia o10=new Option_209947366_GonzalezGarcia(1,"1) Vegano",2,1,"Vegano","Veganismo");
        Option_209947366_GonzalezGarcia o11=new Option_209947366_GonzalezGarcia(2,"2) Italiano",2,1,"Italiano");
        Flow_209947366_GonzalezGarcia f5=new Flow_209947366_GonzalezGarcia(1,"A que tipo de restaurante quieres ir?",o10,o11);
        Chatbot_209947366_GonzalezGarcia c3=new Chatbot_209947366_GonzalezGarcia(2,"Restaurante","Bienvenido a la calle de los restaurantes",1,f5);

        MenuPrincipal_209947366_GonzalezGarcia m1=new MenuPrincipal_209947366_GonzalezGarcia();
        m1.sistema.systemAddChatbot(c1,c2,c3);
        m1.run();



    }
}
