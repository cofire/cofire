package com.cofire.basic.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) {
        // String serverName = args[0];
        // int port = Integer.parseInt(args[1]);
        String serverName = "localhost";
        int port = 6066;
        try {
            System.out.println("ip:" + serverName + " port:" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程地址" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("读入数据 " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}