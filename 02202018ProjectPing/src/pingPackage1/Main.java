package pingPackage1;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 02/20/2018
 *
 * @author Alexander Clifford
 */
public class Main {

    public static void main(String[] args) {
        int serverRun = 0;
        int menuChoice = 0;
        Scanner inputScan = new Scanner(System.in);
        ArrayList<Server> serverList = new ArrayList();
        Server home1Server = new Server(5409,"home1Server");
        Server home2Server = new Server(5409,"home2Server");
        Server home3Server = new Server(5409,"home3Server");
        Server currentServer = home1Server;
        serverList.add(home1Server);
        serverList.add(home2Server);
        serverList.add(home3Server);
        
        do {
            System.out.println("\t\tHello, welcome to the server game.");
            System.out.println("\t\tPlease choose an option.");
           
            
            System.out.println("\n Current Server: " + currentServer.getServerName());
            
            System.out.println("\n 1. Choose Server\t2. Ping Server from "+ currentServer.getServerName());
            menuChoice = inputScan.nextInt();
            
            
            //Choose Server dialouge
            if (menuChoice == 1) {
                System.out.println("Please choose a server from the available servers: ");
                for (int i=0; i != serverList.size(); i++) {
                    System.out.printf("%d. "+ serverList.get(i).getServerName()+"\n",i+1);
                }
                menuChoice = inputScan.nextInt();
                while (menuChoice <= 0 || menuChoice > serverList.size()) {
                    System.out.println("Choice not valid, please try again");
                    menuChoice = inputScan.nextInt();
                }
                currentServer = serverList.get(menuChoice-1);
                serverRun++;
            }
            
            //Ping server dialouge
            if (menuChoice == 2) {
                System.out.println("Which server would you like to ping?");
                for (int i=0; i != serverList.size(); i++) {
                    System.out.printf("%d. "+ serverList.get(i).getServerName()+"\n",i+1);
                }
                menuChoice = inputScan.nextInt();
                while (menuChoice <= 0 || menuChoice > serverList.size()) {
                    System.out.println("Choice not valid, please try again");
                    menuChoice = inputScan.nextInt();
                }
                System.out.println(currentServer.ping(serverList.get(menuChoice-1)));
            
            }
            
            if (menuChoice == 3) {
                System.out.println("Welcome to Server Settings\nWhich setting would you like to change?");
                
            }
        } while (menuChoice != 4);

        
        
        /*
        Server johnServer = new Server(5);
        Server alexServer = new Server(2456);

        System.out.println("Server 1's IP is " + johnServer.getServerIP());

        System.out.println(johnServer.ping(alexServer));
        
        alexServer.addServer(johnServer);
        alexServer.addServer(alexServer);
        */
    }

}
