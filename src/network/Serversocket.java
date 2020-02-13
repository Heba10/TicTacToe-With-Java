/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import GameLogic.BoardPostion;
import java.io.*;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marwa
 */
public class Serversocket implements Runnable{
    
    DataInputStream in; 
    DataOutputStream out;
    ServerSocket creatorPlayer;
    Socket joinedPlayer;
    public Serversocket() throws IOException{
        creatorPlayer=new ServerSocket(9000);
        Thread acceptThread=new Thread(this);
        acceptThread.start();
    }

    @Override
    public void run() {
        try {
            joinedPlayer=creatorPlayer.accept();
            in=new DataInputStream(joinedPlayer.getInputStream());
            out=new DataOutputStream(joinedPlayer.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Serversocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendGameMove(BoardPostion pos) throws IOException
    {
        sendMyName("blabla");
        int x=pos.getX();
        int y=pos.getY();
        String send=x+"-"+y;
        out.writeUTF(send);
        
//        out.flush();
    }
    
    public void receiveGameMove(BoardPostion pos) throws IOException
    {
        if(in==null)
            System.out.println("in is null ");
        if(in!=null)
        {
            String recieved=in.readUTF();
            String arr[]=new String [2];
            arr=recieved.split("-");
            pos.setX(Integer.parseInt(arr[0]));
            pos.setY(Integer.parseInt(arr[1]));
        }
        
        
//        System.out.println(" recieved= "+recieved);
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
