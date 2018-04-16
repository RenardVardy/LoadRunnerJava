package com.performancetestgurus.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Interface to send traffic to the simple server
 * 
 * @author Reanrd Vardy
 *
 * Copyright (C) 2018 Renard Vardy, www.performancetestgururus.com/copyright
 * 
*/

public class SimpleClient {
	
	public static String sendMessage(String serverAddress, int port, String message) {
		try {
			Socket clientSocket = new Socket(serverAddress, port);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println(message + "\n\u0004\n");
			
			StringBuilder replyMessage = new StringBuilder();
      	    String line;
      	      while ((line = in.readLine()) != null && !line.equals("\u0004")){
            	  replyMessage.append(line+"\n");
      	      }
      	  
          in.close();
          out.close();
          clientSocket.close(); 
          return replyMessage.toString();
          
	    } catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
