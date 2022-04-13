package com.example.myloginapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;




public class HttpURLSample {

	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
	/*	//Method 2: java.net.http.HttpClient
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
		client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
		
		
		*/
		
		//Method 1: java.net.HttpURLConnection
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		
		URL url;
        {
            try {
                url = new URL("https://jsonplaceholder.typicode.com/albums");
                connection= (HttpURLConnection) url.openConnection();

                //Request setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int status = connection.getResponseCode();
                System.out.println(status);
                
                if (status >299) {
                	reader = new BufferedReader (new InputStreamReader (connection.getErrorStream()));
                	while ((line=reader.readLine()) != null) {
                		responseContent.append(line);
                	}
                	
                	reader.close();
                }
                
                else {
                	reader = new BufferedReader (new InputStreamReader(connection.getInputStream()));
                	
                	while ((line=reader.readLine()) != null) {
                		responseContent.append(line);
                	}
                	
                	reader.close();
                }
                
                System.out.println(responseContent.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            finally {
            	connection.disconnect();
            }
        }
        
    }

}
