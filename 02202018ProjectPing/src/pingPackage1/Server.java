package pingPackage1;

import java.util.ArrayList;

/**
 * 02/20/2018
 *
 * @author Alexander Clifford
 */
public class Server {

    ArrayList<Server> serverTable = new ArrayList();

    private int iP;
    private int pingStatus = 1;
    private String serverName;

    Server(int addressEnter, String svrName) {
        this.serverName = svrName;
        
        iP = addressEnter;
        String strIP = String.valueOf(iP);
        if (strIP.length() > 4) {
            strIP = strIP.substring(0, 3);
        }
        else if (strIP.length() < 4 || strIP.length() > 0) {
            switch (strIP.length()) {
                case 3: strIP = strIP.concat("0"); break;
                case 2: strIP = strIP.concat("00"); break;
                case 1: strIP = strIP.concat("000"); break;
                
            }
            
        }
        else if (strIP.length() <= 0) {
            System.out.println("iP not recognized, please set a 1-4 number iP address with setServerIP"
                    + "");
        } 
        
        iP = Integer.parseInt(strIP);
        this.serverTable.add(this);
        pingStatus = 1;
    }

    public String ping(Server beingPinged) {
        return beingPinged.returnPing();
    }
    
    public String returnPing() {
        if (pingStatus == 1) {
            return "Pong";
        }
        return "Did not recieve Pong...";
    }

    public int getServerIP() {
        return this.iP;
    }
    
    public String getServerName() {
        return this.serverName;
    }

    public void addServer(Server newServer) {
        if (serverTable.contains(newServer)) {
            System.out.println("Server already in table at list number " + serverTable.lastIndexOf(newServer));
        } 
        else {
            this.serverTable.add(newServer);
            System.out.println(newServer.getServerIP() + " added at list number " + serverTable.lastIndexOf(newServer));
        }
    }
}
