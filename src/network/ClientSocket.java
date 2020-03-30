/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import GameLogic.BoardPostion;
import java.io.BufferedReader;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author Marwa
 */
public class ClientSocket implements Runnable{
    String SevrerAddress;
    DataInputStream in; 
    DataOutputStream out;
    BoardPostion pos;
    public ClientSocket() throws UnknownHostException, IOException{
       SevrerAddress=UDPServer.getServerAddress();
       Socket joinedPlayer=new Socket(InetAddress.getLocalHost(),9000);
       in=new DataInputStream(joinedPlayer.getInputStream());
       out=new DataOutputStream(joinedPlayer.getOutputStream());
       
    }

    @Override
    public void run() {
//       
//     while(true){
//          
////          System.out.println("inside while of ru client");
//          Platform.runLater(()->{
//             try {
//                 System.out.println("hereeee");
//                do{
//                String recieved=in.readUTF();
//                int arr[]=new int[2];
//                String arr2[]=new String[2];
//                arr2= recieved.split("-");
//                pos
//                 System.out.println("x is: " +x);
//                // int y=in.read();
//                }while(in==null);
//                System.out.println("hkiii");
//             //   System.out.println(in.read());
//             
//             }catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//                
//                }
        
    }
    public void receiveGameMove(BoardPostion pos) throws IOException
    {
//        receiveOtherPlayerName();
        String recieved=in.readUTF();
        String arr[]=new String [2];
        arr=recieved.split("-");
        pos.setX(Integer.parseInt(arr[0]));
        pos.setY(Integer.parseInt(arr[1]));
//        System.out.println(" recieved= "+recieved);
    }
     public void sendGameMove(BoardPostion pos) throws IOException
    {
        int x=pos.getX();
        int y=pos.getY();
        String send=x+"-"+y;
        out.writeUTF(send);
        
//        out.flush();
    }
     
    public void sendMyName(String name) throws IOException
    {
        out.writeUTF(name);
    }
    
    public String receiveOtherPlayerName() throws IOException
    {
        return in.readUTF();
    } 
    
    
}
