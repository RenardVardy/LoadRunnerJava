package com.performancetestgurus.SimpleServer;

/**
 * Example use of API for LoadRunner Java API example
 * 
 * @author Reanrd Vardy
 *
 * Copyright (C) 2018 Renard Vardy, www.performancetestgururus.com/copyright
 * 
*/

public class App 
{
    public static void main(String args[]) {
    	System.out.println(SimpleClient.sendMessage("127.0.0.1", 8081, "linkedin.com/in/renard-vardy"));
    }
}
