package com.performancetestgurus.SimpleServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
 * Java simple server to accept traffic over LoadRunner VuGen Java API example
 * 
 * @author Reanrd Vardy
 * 
 * Copyright (C) 2018 Renard Vardy, www.performancetestgururus.com/copyright
 */
public class SimpleServer {

    public static void main(String args[]) throws IOException {

    	@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8081);
        System.out.println("Listening for connection on port 8081....");
        while (true) {
        	//Read and echo input to standard out
            Socket socket = server.accept(); 
            BufferedReader in = new BufferedReader(new InputStreamReader
            		(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null && !line.equals("\u0004")){
                System.out.println(line); 
            }	   
            //Respond to the request
            Date today = new Date();
            String httpResponse = "performancetestgurus.com\n"
                   + today + "\n\u0004\n";
            socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        }
    }
}