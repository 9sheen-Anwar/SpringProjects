package com.debug.debugapp;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall2 {
	public static void main(String[] args) throws IOException, InterruptedException{
        String url= "http://localhost:8082/jasperserver-pro/rest_v2/reports/public/Samples/Reports/AccountDetailReportDemo.html";
        String url1="http://localhost:8082/jasperserver-pro/rest_v2/reports/public/Samples/Reports/AllAccounts.html";
      
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url1)).build();
       
     //   var client = HttpClient.newBuilder().build();
        
        HttpClient client = HttpClient.newBuilder()
        		  .authenticator(new Authenticator() {
        		      @Override
        		      protected PasswordAuthentication getPasswordAuthentication() {
        		          return new PasswordAuthentication("jasperadmin", "jasperadmin".toCharArray());
        		      }
        		  })
        		  .build();
       
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
        System.out.println(response.statusCode());
   
        System.out.println(response.body());
    }

}
