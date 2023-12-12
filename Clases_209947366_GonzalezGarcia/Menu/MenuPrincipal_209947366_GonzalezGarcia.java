package Clases_209947366_GonzalezGarcia.Menu;

import Clases_209947366_GonzalezGarcia.*;

import java.util.Scanner;

/**
 * Clase que representa al menu que permite al usuario interactuar con el sistema
 */
public class MenuPrincipal_209947366_GonzalezGarcia {
    /**
     * Sistema default del menu
     */
    public System_209947366_GonzalezGarcia sistema=new System_209947366_GonzalezGarcia("sistema inicial",0);
    /**
     * lector para leer los inputs del usuario
     */
    public Scanner lector;
    /**
     * Nombre de usuarios a añadir
     */
    public String nombreu;
    /**
     * booleano que permite representar que el menu seguira o no corriendo
     */
    public boolean repetir;

    /**
     * Constructor del Menu
     */
    public MenuPrincipal_209947366_GonzalezGarcia(){
        this.lector=new Scanner(System.in);
        this.repetir=true;
    }

    /**
     * Metodo que permite que el menu corra
     * Si no hay usuario: Permite que añadir usuarios y administradores e iniciar sesion
     * Si el usuario es Admin: Permite añadir chatbots, flows y options, ademas de visualizarlos
     * Si el usuario no es admin: Permite que este interactue con el sistema y vea historiales
     */
    public void run(){
        while(repetir){
            if( sistema.activeuser==null){
                System.out.println("Que desea hacer?(ingrese el numero de la opcion):\n\n" +
                                   "1)Añadir Usuario\n2)Añadir Admin\n3)Log-in\n4)Salir");
                int opcionselec=lector.nextInt();
                switch(opcionselec){
                    case 1:
                        lector.nextLine();
                        System.out.println("Ingrese el nombre de usuario");
                        nombreu=lector.nextLine();
                        sistema.systemAddUser(new User_209947366_GonzalezGarcia(nombreu));
                        break;
                    case 2:
                        lector.nextLine();
                        System.out.println("Ingrese el nombre de Admin");
                        nombreu=lector.nextLine();
                        sistema.systemAddUser(new Admin_209947366_GonzalezGarcia(nombreu));
                        break;
                    case 3:
                        lector.nextLine();
                        System.out.println("Con que usuario desea iniciar sesion?");
                        for(User_209947366_GonzalezGarcia user: sistema.userlist){
                            System.out.println("Nombre:  "+user.name +"  Es administrador?: "+(user.isadmin?"Si":"No"));
                        }
                        nombreu=lector.nextLine();
                        for(User_209947366_GonzalezGarcia user: sistema.userlist){
                            if(nombreu.equals(user.name)){
                                sistema.systemLogin(user);
                            }
                        }
                        break;
                    case 4:
                        this.repetir=false;
                }
            }
            else if(sistema.activeuser.isadmin){
                System.out.println("Que desea hacer?\n\n"+
                        "1)Añadir Chatbot\n" +
                                "2)Añadir Flow\n" +
                                "3)Añadir Option\n" +
                                "4)Visualizar Chatbots\n" +
                                "5)Visualizar Chatbots con Flows y Options\n" +
                                "6)Log-out\n");
                int opcionselec=lector.nextInt();
                int contador=1;
                int select;
                int id;
                String msg;
                int chtlink;
                int flwlink;

                switch(opcionselec){
                    case 1:
                        int idcht;
                        String nombrec;
                        String mensaje;
                        int flowinicial;
                        System.out.println("Ingrese el ID del Chatbot");
                        idcht=lector.nextInt();
                        lector.nextLine();
                        System.out.println("Ingrese el nombre del Chatbot");
                        nombrec= lector.nextLine();
                        System.out.println("Ingrese el mensaje del Chatbot");
                        mensaje= lector.nextLine();
                        System.out.println("Ingrese el ID del Flow inicial del Chatbot");
                        flowinicial=lector.nextInt();
                        lector.nextLine();
                        sistema.systemAddChatbot(new Chatbot_209947366_GonzalezGarcia(idcht,nombrec,mensaje,flowinicial));
                        break;
                    case 2:
                        System.out.println("Ingrese a que Chatbot desea añadir el Flow? (Ingrese el numero de la opcion, no el ID)\n");
                        for(Chatbot_209947366_GonzalezGarcia cht:sistema.chatbotlist){
                            System.out.println(contador+") ID:"+cht.id+" Nombre:"+cht.name+"\n");
                            contador+=1;

                        }
                        select=lector.nextInt();
                        lector.nextLine();
                        System.out.println("Ingrese el ID del Flow\n");
                        id=lector.nextInt();
                        lector.nextLine();
                        System.out.println("Ingrese el mensaje del Flow\n");
                        msg=lector.nextLine();
                        sistema.chatbotlist.get(select-1).chatbotAddFlow(new Flow_209947366_GonzalezGarcia(id,msg));
                        break;
                    case 3:
                        Option_209947366_GonzalezGarcia optoadd;
                        System.out.println("Ingrese a que Chatbot se le quiere añadir el Option (Ingrese el numero de la opcion, no el ID)\n");
                        for(Chatbot_209947366_GonzalezGarcia cht:sistema.chatbotlist){
                            System.out.println(contador+") ID:"+cht.id+" Nombre:"+cht.name+"\n");
                            contador+=1;

                        }
                        select=lector.nextInt();
                        lector.nextLine();
                        System.out.println("Ingrese a que Flow se le quiere añadir el Option (Ingrese el numero de la opcion, no el ID)\n");
                        contador=1;
                        for(Flow_209947366_GonzalezGarcia flow:sistema.chatbotlist.get(select-1).flowlist){
                           System.out.println(contador+")"+ " ID:"+flow.id+" Nombre:"+flow.nombremsg);
                           contador+=1;
                        }
                        int selectorflow=lector.nextInt();
                        System.out.println("inserte el ID del Option");
                        id=lector.nextInt();
                        lector.nextLine();
                        System.out.println("inserte el mensaje del Option");
                        msg=lector.nextLine();
                        System.out.println("inserte el link al Chatbot del Option");
                        chtlink=lector.nextInt();
                        lector.nextLine();
                        System.out.println("inserte el link al Flow del Option");
                        flwlink=lector.nextInt();
                        lector.nextLine();
                        optoadd=new Option_209947366_GonzalezGarcia(id,msg,chtlink,flwlink);
                        String keytoadd="continuar";
                        while(!(keytoadd.equals(""))){
                            System.out.println("Inserte la keyword a añadir (si desea detenerse, solo presione ENTER)");
                            keytoadd=lector.nextLine();
                            if(!keytoadd.isEmpty()){ optoadd.keywords.add(keytoadd);}
                        }
                        sistema.chatbotlist.get(select-1).flowlist.get(selectorflow-1).flowAddOption(optoadd);
                        break;
                    case 4:
                        for(Chatbot_209947366_GonzalezGarcia cht:sistema.chatbotlist){
                            System.out.println("ID:"+cht.id+" Nombre:"+cht.name+" Mensaje:"+cht.msg+"\n");
                        }
                        break;
                    case 5:
                        for(Chatbot_209947366_GonzalezGarcia cht:sistema.chatbotlist){
                            System.out.println("ID:"+cht.id+" Nombre:"+cht.name+" Mensaje:"+cht.msg+"\n");
                            System.out.println("Flujos del Chatbot:"+cht.name);
                            for(Flow_209947366_GonzalezGarcia flow: cht.flowlist){
                                System.out.println("    ID:"+flow.id+" Nombre:"+flow.nombremsg+"\n");
                                System.out.println("    Options del Flujo"+flow.id);
                                for(Option_209947366_GonzalezGarcia op:flow.optionlist){
                                    System.out.print("        ID:"+op.id+") Mensaje:"+op.msg+" Keywords:");

                                    for(String keyword: op.keywords){
                                        System.out.print(keyword+" ");
                                    }
                                    System.out.println();
                                }
                            }
                        }
                        break;
                    case 6:
                        sistema.systemLogout();



                }
            }
            else{

                System.out.println("### Menu Usuario ###\n" +
                        "Que desea hacer? (ingrese el numero de la opcion)\n"+
                        "1)Hablar con el Chatbot\n"+
                        "2)Mostrar historial\n"+
                        "3)Log-out");
                int opcionselec=lector.nextInt();
                switch(opcionselec){
                    case 1:

                        for(Chatbot_209947366_GonzalezGarcia cht: sistema.chatbotlist){
                            if(cht.id==sistema.chtact){
                                for(Flow_209947366_GonzalezGarcia flow:cht.flowlist){
                                    if(flow.id==cht.flowid){
                                        System.out.println(flow.nombremsg);
                                        for(Option_209947366_GonzalezGarcia op: flow.optionlist){
                                            System.out.println(op.id+") "+op.msg);
                                        }
                                    }
                                }
                            }
                        }
                        lector.nextLine();
                        String msg=lector.nextLine();
                        sistema.systemtalk(msg);
                        break;
                    case 2:
                        sistema.systemsynthesis(sistema.activeuser);
                        break;
                    case 3:
                        sistema.systemLogout();
                        break;
                }


            }
        }
    }

}
