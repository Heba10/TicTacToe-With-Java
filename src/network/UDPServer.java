/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Marwa
 */
public class UDPServer {
  
    private static String ServerAddress;
    
    public UDPServer() throws SocketException, IOException {
      DatagramSocket socket = new DatagramSocket(5555);
        byte[] buffer = new byte[25];
        DatagramPacket recieve = new DatagramPacket(buffer, buffer.length);
        socket.receive(recieve);
        byte recieved[]=recieve.getData();
        ServerAddress=new String(recieved);
//        System.out.println(ServerAddress);
        socket.close();
    }
    
    
    public static String getServerAddress(){
        return ServerAddress;
    }
    
}
