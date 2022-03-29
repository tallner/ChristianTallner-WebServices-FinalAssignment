package com.cte.gritwebservices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpHelper {

	public static String UrlResponse(String url, String verb, String body) throws IOException {
		HttpURLConnection myConnection = getConnection(url, verb);
		
		if (verb.toUpperCase().equals("POST")) {
			addBody(myConnection, body);
		}
		
		int responseCode = myConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			return readStream(myConnection);
		} else {
			return "Could not read URL: " + url + " as " + verb;
		}
	}

	private static HttpURLConnection getConnection(String urlString, String verb) throws IOException {
		URL urlObj = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod(verb.toUpperCase());
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		return con;
	}
	
	private static void addBody(HttpURLConnection con, String body) throws IOException {
		con.setDoOutput(true);
		OutputStream myOutputStream = con.getOutputStream();
		myOutputStream.write(body.getBytes());
		myOutputStream.flush();
		myOutputStream.close();			
	}
	
	private static String readStream(HttpURLConnection con) throws IOException {
		BufferedReader inputStreamReader = new BufferedReader(
				new InputStreamReader(
						con.getInputStream()));

		String textLine;
		StringBuffer resultText = new StringBuffer();
		
		while ( (textLine = inputStreamReader.readLine()) != null  ) {
			resultText.append(textLine);
		}
		inputStreamReader.close();
		
		return resultText.toString();
	}
	
	public static String httpPOSTtest() throws IOException {
		String urlParameters  = "player1Move=rocky&player2Move=scissors";
		URL url = new URL("http://localhost:8080/rsp");
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput(true);
//		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
//		conn.setRequestProperty("charset", "utf-8");
//		conn.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length ));
//		conn.setUseCaches(false);
		try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
		   wr.write( urlParameters.getBytes() );
		   wr.flush();
		   wr.close();
		  // System.out.println(postData.);
		}
		
		/*
		 * String result = ""; try(BufferedReader br = new BufferedReader( new
		 * InputStreamReader(conn.getInputStream(), "utf-8"))) { StringBuilder response
		 * = new StringBuilder(); String responseLine = null; while ((responseLine =
		 * br.readLine()) != null) { response.append(responseLine.trim()); }
		 * System.out.println(response.toString()); result = response.toString(); }
		 * return result;
		 */
		
		int responseCode = conn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			return readStream(conn);
		} else {
			return "Could not read URL: " + url + " " + responseCode;
		}
	}

}

