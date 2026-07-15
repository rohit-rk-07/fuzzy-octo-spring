package com.rohit;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

	public static void main(String[] args) throws LifecycleException {
		// TODO Auto-generated method stub
		Tomcat tomcat = new Tomcat();
		
		Context context = tomcat.addContext("", null);
		Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
		context.addServletMappingDecoded("/hello", "HelloServlet");
		
		tomcat.start();
		tomcat.getServer().await();
	}

}
