/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Marwa
 */
public class UDPClient {
    
    public UDPClient() throws UnknownHostException, SocketException, IOException {
//        System.out.println("waiting for client");
        String broadcastMessage=InetAddress.getLocalHost().getHostAddress();
        InetAddress address=InetAddress.getByName("255.255.255.255");
        DatagramSocket addressSocket = new DatagramSocket();
        addressSocket.setBroadcast(true);
        byte[] buffer = broadcastMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5555);
        addressSocket.send(packet);
//        System.out.println("packet is sent");
        addressSocket.close();
        
        
    }
    
    
    
    
}
