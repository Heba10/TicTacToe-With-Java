/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import GameLogic.BoardPostion;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Marwa
 */
public class Server {
    private Socket so;
        String ServerAddress;
   //     private long Integer=9000;
        private boolean connect=false;
        BufferedReader in;
        PrintStream outer;
        String playerName="server player";
    String player2;

    public Server() throws IOException, InterruptedException 
    {
        try {
            sendAddress();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        establishConnection();
    }
    public void sendAddress() throws UnknownHostException, SocketException, IOException{
//        while(Integer>0){
//            System.out.println("waiting for client");
//        String broadcastMessage=InetAddress.getLocalHost().getHostAddress();
//        InetAddress address=InetAddress.getByName("255.255.255.255");
//        DatagramSocket addressSocket = new DatagramSocket();
//        addressSocket.setBroadcast(true);
//        byte[] buffer = broadcastMessage.getBytes();
//        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5555);
//        addressSocket.send(packet);
//        System.out.println("packet is sent");
//        addressSocket.close();
//        Integer--;
//        connect=true;}
        
        DatagramSocket socket = new DatagramSocket(5555);
        byte[] buffer = new byte[25];
        DatagramPacket recieve = new DatagramPacket(buffer, buffer.length);
        socket.receive(recieve);
        byte recieved[]=recieve.getData();
        ServerAddress=new String(recieved);
        System.out.println(ServerAddress);
        socket.close();
        
    }
    public void establishConnection() throws IOException, InterruptedException{
//        if(connect){
//        ServerSocket s=new ServerSocket(9000);
//        socket=s.accept();
//        establishGame();
//        }
        so=new Socket(InetAddress.getByName(ServerAddress), 9000);
        establishGame();
    }
    
    public void establishGame( ) throws InterruptedException, IOException{
//       Thread thread=new Thread("Network logic");
//       thread.start();
//        thread.setPriority(1000);
   // Thread.sleep(1000);
   outer = new PrintStream(so.getOutputStream());
    in=new BufferedReader(new InputStreamReader(so.getInputStream()));
//        Platform.runLater(()->{
//             System.out.println("thread server");  
//             System.out.println("iam server");
//            try{
//            outer = new DataOutputStream(so.getOutputStream());
//            in=new DataInputStream(so.getInputStream());
////            outer.writeUTF(playerName);
////            player2=in.readUTF();
////                System.out.println(in.readUTF());
//            
//            } catch(IOException ex)
//            {
//                ex.printStackTrace();
//            }
//        });
   }    

//    @Override
//    public void run() {
//        
//        System.out.println("thread server");    
//            try{
//            outer = new PrintStream(so.getOutputStream());
//            in=new DataInputStream(so.getInputStream());
//                System.out.println(in.readUTF());
//            
//            } catch(IOException ex)
//            {
//                ex.printStackTrace();
//            }
//            
//        
//    
//}
    
     public void sendGameMove(BoardPostion pos) throws IOException
    {
        
        int x=pos.getX();
        int y=pos.getY();
//        Platform.runLater(()->{
//            try {
//                outer.writeInt(x);
//                outer.writeInt(y);
//            } catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//            outer.println("played");
            outer.println(x);
            outer.println(y);
    //    outer.writeInt(x);
//        outer.writeInt(y);
    }
     
     public void receiveGameMove(BoardPostion pos)
    {
//       int x=pos.getX();
//       int y=pos.getY();
            Platform.runLater(()->{
            try {
                pos.setX(in.read());
                pos.setY(in.read());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
//        return new BoardPostion();
    }
     
     public void setPlayerName(String name)
     {
         playerName=name;
     }

    public String getPlayer2() {
        return player2;
    }
     
    
}
