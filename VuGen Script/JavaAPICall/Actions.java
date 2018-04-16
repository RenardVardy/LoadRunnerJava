/*
 * LoadRunner Java script. (Build: _build_number_)
 * 
 * Script Description: Sample API VuGen Script
 *
 * @author Reanrd Vardy
 * 
 * Copyright (C) 2018 Renard Vardy, www.performancetestgururus.com/copyright 
 *                     
 */

import lrapi.lr;

public class Actions
{

	public int init() throws Throwable {
		return 0;
	}//end of init


	public int action() throws Throwable {
		
		lr.start_transaction("API Call");
		String returnValue = com.performancetestgurus.SimpleServer.SimpleClient.
			sendMessage("127.0.0.1", 8081, "www.linkedin.com/in/renard-vardy");
		lr.log_message(returnValue);
		if(returnValue.contains("performancetestgurus.com")){
			lr.end_transaction("API Call", lr.AUTO);
		}
		else{
			lr.end_transaction("API Call", lr.FAIL);
		}

		return 0;
	}//end of action


	public int end() throws Throwable {
		return 0;
	}//end of end
}
