package Clases_209947366_GonzalezGarcia;
import interfaces_209947366_GonzalezGarcia.Isystem_209947366_GonzalezGarcia;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.*;

/**
 * Clase que representa el sistema que almacena los chatbot
 */
public class System_209947366_GonzalezGarcia implements Isystem_209947366_GonzalezGarcia {
    /**
     * nombre del sistema
     */
    public String name;
    /**
     * Id del Chatbto actual
     */
    public int chtact;
    /**
     * Usuario que tiene sesion iniciada (inicialmente ninguno)
     */
    public User_209947366_GonzalezGarcia activeuser=null;
    /**
     * Lista de Usuarios y Administradores
     */
    public List<User_209947366_GonzalezGarcia> userlist;
    /**
     * Lista de Chatbots del Sistema
     */
    public List<Chatbot_209947366_GonzalezGarcia> chatbotlist;
    /**
     * Id del Chatbot inicial
     */
    public int initialcht;
    /**
     * Formato de fechas
     */
    public DateTimeFormatter formatofecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    /**
     * Fecha a añadir
     */
    public LocalDateTime fecha;

    /**
     * Constructor de la clase System
     * @param name String: nombre del sistema
     * @param chtact Int: ID del Chatbot inicial
     * @param chtlist List Chatbot: Lista de Chatbots
     */
    public System_209947366_GonzalezGarcia(String name, int chtact, Chatbot_209947366_GonzalezGarcia... chtlist){
        this.name=name;
        this.chtact=chtact;
        this.initialcht=chtact;
        this.chatbotlist=new ArrayList<Chatbot_209947366_GonzalezGarcia>();
        for(Chatbot_209947366_GonzalezGarcia cht: chtlist){
            if(!checkrepeatid(cht)){
                this.chatbotlist.add(cht);
            }
        }
        this.userlist=new ArrayList<User_209947366_GonzalezGarcia>();


    }

    /**
     * Selector del Nombre del System
     * @return String: Nombre del System
     */
    @Override
    public String systemgetname(){
        return this.name;
    }

    /**
     * Selector del Id del Chatbot actual
     * @return ID Chatbot
     */
    @Override
    public int systemgetchtact(){
        return this.chtact;
    }

    /**
     * Selector de la lista de Chatbots de un System
     * @return List Chatbot: Lista de Chatbot
     */
    @Override
    public List<Chatbot_209947366_GonzalezGarcia> getchatbotlist(){
        return this.chatbotlist;
    }

    /**
     * Selector del Usuario activo
     * @return User: Usuario activo
     */
    @Override
    public User_209947366_GonzalezGarcia getactiveuser(){
        return this.activeuser;
    }

    /**
     * Selector de la Lista de Usuarios
     * @return List User: Lista de usuarios
     */
    @Override
    public List<User_209947366_GonzalezGarcia> getuserlist(){
        return this.userlist;
    }

    /**
     * Selector del Id del Chatbot inicial
     * @return Int :ID Chatbot
     */
    @Override
    public int getinitialcht(){
        return this.initialcht;
    }

    /**
     * Modificador que permite añadir Chatbots al System
     * @param chtl Chatbot: Chatbtos a añadir
     */
    @Override
    public void systemAddChatbot(Chatbot_209947366_GonzalezGarcia... chtl){
        for (Chatbot_209947366_GonzalezGarcia cht: chtl){
            if(!checkrepeatid(cht)){
                this.chatbotlist.add(cht);
            }
        }
    }

    /**
     * Modificador que permite añadir Usuarios al System
     * @param newuser User: Usuario a añadir
     */
    @Override
    public void systemAddUser(User_209947366_GonzalezGarcia newuser){
        for(User_209947366_GonzalezGarcia userinlist:this.userlist){
            if(userinlist.name.equals(newuser.name)){
                return;
            }
        }
        this.userlist.add(newuser);
    }

    /**
     * Modificador que permite que un usuario inicie sesion
     * @param user User
     */
    @Override
    public void systemLogin(User_209947366_GonzalezGarcia user){
        if(this.activeuser==null && !this.userlist.isEmpty()  && this.userlist.contains(user)){
        this.activeuser=user;
        }

    }

    /**
     * Modificador que permite que un Usuario cierre sesion y se reinicie el estado del sistema
     */
    @Override
    public void systemLogout(){
        this.chtact=this.initialcht;
        for(Chatbot_209947366_GonzalezGarcia cht:this.chatbotlist){
            cht.resetchatbot();
        }
        this.activeuser=null;
    }

    /**
     * Verifica que no se repita el id de un Chatbot en una lista
     * @param cht Chatbot: Chatbot que se quiere añadir
     * @return Booleano que indica la presencia del id
     */
    public boolean checkrepeatid(Chatbot_209947366_GonzalezGarcia cht){
        for(Chatbot_209947366_GonzalezGarcia chtfromlist:this.chatbotlist){
            if(chtfromlist.id==cht.id){
                return true;
            }
        }
        return false;
    }

    /**
     * Permite al usuario interactuar con el sistema de Chatbot y la interaccion se añade al historial del usuario
     * @param msg String: mensaje del usuario
     */
    @Override
    public void systemtalk(String msg) {
        if (this.activeuser == null) {
            return;
        }
        fecha = LocalDateTime.now();
        String fechaformateada = fecha.format(formatofecha);
        this.activeuser.appendhistory(fechaformateada + " - " + this.activeuser.getname() + ":" + msg + "\n");
        for (Chatbot_209947366_GonzalezGarcia cht : this.chatbotlist) {
            if (cht.id == this.chtact) {
                for (Flow_209947366_GonzalezGarcia fl : cht.flowlist) {
                    if (fl.id == cht.flowid) {
                        for (Option_209947366_GonzalezGarcia op : fl.optionlist) {
                            String opidasstring= Integer.toString(op.id);
                            if (op.keywords.contains(msg.toLowerCase())) {
                                this.chtact = op.chtlink;
                                cht.flowid = op.flowlink;
                                for (Chatbot_209947366_GonzalezGarcia chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow_209947366_GonzalezGarcia flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.id) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option_209947366_GonzalezGarcia optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }
                                        }
                                    }
                                }

                            }
                            else if(opidasstring.equals(msg)){
                                this.chtact = op.chtlink;
                                cht.flowid = op.flowlink;
                                for (Chatbot_209947366_GonzalezGarcia chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow_209947366_GonzalezGarcia flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.flowid) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option_209947366_GonzalezGarcia optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }

                                        }
                                    }
                                }
                            }
                            else{
                                for (Chatbot_209947366_GonzalezGarcia chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow_209947366_GonzalezGarcia flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.flowid) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option_209947366_GonzalezGarcia optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }

                                        }
                                    }
                                }
                                return;
                            }
                        }
                        //añadir chatbot actual al historial
                        this.activeuser.appendhistory(fechaformateada + " - " + cht.name
                                + ":" + fl.nombremsg + "\n");
                        for (Option_209947366_GonzalezGarcia optoadd : fl.optionlist) {
                            this.activeuser.appendhistory(optoadd.msg + "\n");
                        }
                        return;
                    }
                }
            }
        }
    }

    /**
     * Presenta el historial de interacciones de un usuario
     * @param user User: Usuario al cual se le vera el historial
     */
    @Override
    public void systemsynthesis(User_209947366_GonzalezGarcia user){
        java.lang.System.out.println(user.history);
    }
    }

