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
import static java.lang.System.in;
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
import sun.net.www.content.audio.x_aiff;
/**
 *
 * @author Marwa
 */
public class Client implements Runnable{
    String ServerAddress;
    Socket socket;
    ServerSocket s;
    BufferedReader in ;
    PrintStream outer;
    String playerName="client player";
    String player2;
    public Client() throws IOException, UnknownHostException, InterruptedException {
        getAddress();
       establishConnection();
    }
    public void getAddress() throws SocketException, IOException{
//        DatagramSocket socket = new DatagramSocket(5555);
//        byte[] buffer = new byte[25];
//        DatagramPacket recieve = new DatagramPacket(buffer, buffer.length);
//        socket.receive(recieve);
//        byte recieved[]=recieve.getData();
//        ServerAddress=new String(recieved);
//        System.out.println(ServerAddress);
//        socket.close();
        


        System.out.println("waiting for client");
        String broadcastMessage=InetAddress.getLocalHost().getHostAddress();
        InetAddress address=InetAddress.getByName("255.255.255.255");
        DatagramSocket addressSocket = new DatagramSocket();
        addressSocket.setBroadcast(true);
        byte[] buffer = broadcastMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5555);
        addressSocket.send(packet);
        System.out.println("packet is sent");
        addressSocket.close();
        boolean connect=true;
    }
    public void establishConnection() throws UnknownHostException, IOException, InterruptedException{
//        so=new Socket(InetAddress.getByName(ServerAddress), 9000);
//        establishGame();
         s=new ServerSocket(9000);
        Platform.runLater(()->{
            try {
                socket=s.accept();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Thread thread= new Thread(this);
        thread.start();
        establishGame();
        
    }
    public void establishGame() throws IOException, InterruptedException{
        System.out.println("server reached ");
        
//        Thread thread=new Thread();
//        thread.setPriority(1000);
       // Thread.sleep(1000);
       
        Platform.runLater(()->{
             try {
             in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             outer=new PrintStream(socket.getOutputStream());
                 System.out.println("streams created");
//            outer.writeUTF(playerName);
//            player2=in.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
//                in.close();
            
        }
        });
//        thread.start();
}

    @Override
    public void run() {
        try {
            //        System.out.println("thread");
//        try {
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream outer=new DataOutputStream(socket.getOutputStream());
//            outer.writeUTF("hello");
//        } catch (IOException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                in.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    socket=s.accept();
    System.out.println("i am client");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPlayerName(String name){
        playerName=name;
    }
    public String getPlayer2(){
        return player2;
    }
    public int getMove(int x){
        return x;
    }
    
    public void sendGameMove(BoardPostion pos)
    {
        System.out.println("send game move method");
        int x=pos.getX();
        System.out.println(x);
        int y=pos.getY();
        Platform.runLater(()->{
//            try {
//                outer.writeInt(x);
//                outer.writeInt(y);
//            } catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
    }
    public void receiveGameMove(BoardPostion pos) throws IOException
    {
        System.out.println("receive game move method");
//       while(pos.getY()==-1){
//            Platform.runLater(()->{
//            try {
//                pos.setX(in.readInt());
//                pos.setY(in.readInt());
//            } catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        Platform.runLater(()->{
            try {
              //  System.out.println(in.readLine());
//                int x=Integer.parseInt(in.readUTF());
//                int y=Integer.parseInt(in.readUTF());
//                System.out.println("x====="+x);
//                System.out.println("y====="+y);
           // pos.setX(x);
           // pos.setY(y);
           
//            pos.setY(in.readInt());
            } catch(Exception ex)
            {
                
            }
            });
//            pos.setX(in.readInt());
//                pos.setY(in.readInt());
//                return new BoardPostion(x,y);
//        return new BoardPostion();
    
    }
}

