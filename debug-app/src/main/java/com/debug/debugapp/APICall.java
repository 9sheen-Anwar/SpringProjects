package com.debug.debugapp;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall {
	public static void main(String[] args) throws IOException, InterruptedException{
        var url= "http://localhost:8082/jasperserver-pro/rest_v2/reports/public/Samples/Reports/AccountDetailReportDemo.html";
        var url1="http://localhost:8082/jasperserver-pro/rest_v2/reports/public/Samples/Reports/AllAccounts.html";
        //Creating HTTP Request
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url1)).build();
        //Creating HTTP Client to send request to server
     //   var client = HttpClient.newBuilder().build();
        
        var client = HttpClient.newBuilder()
        		  .authenticator(new Authenticator() {
        		      @Override
        		      protected PasswordAuthentication getPasswordAuthentication() {
        		          return new PasswordAuthentication("jasperadmin", "jasperadmin".toCharArray());
        		      }
        		  })
        		  .build();
        //sending req with the help of client
        //BodyHandler determine how to handle response received, here we are expecting response as string
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //Printing response code and body in console output
        System.out.println(response.statusCode());
      //  System.out.println(response.);
        System.out.println(response.body());
    }

}
