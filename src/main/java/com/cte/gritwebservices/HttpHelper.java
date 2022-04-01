package com.cte.gritwebservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {

	public static String UrlResponse(String url, String verb, String body, String charset) throws IOException {
		HttpURLConnection myConnection = getConnection(url, verb, charset);
		
		if (verb.toUpperCase().equals("POST")) {
			addBody(myConnection, body, charset);
		}
		
		int responseCode = myConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			return readStream(myConnection, charset);
		} else {
			return "Could not read URL: " + url + " as " + verb;
		}
	}

	private static HttpURLConnection getConnection(String urlString, String verb, String charset) throws IOException {
		URL urlObj = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod(verb.toUpperCase());
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Charset", charset);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset="+charset); 

		return con;
	}
	
	private static void addBody(HttpURLConnection con, String body, String charset) throws IOException {
		con.setDoOutput(true);
		OutputStream myOutputStream = con.getOutputStream();
		myOutputStream.write(body.getBytes(charset));
		myOutputStream.flush();
		myOutputStream.close();	
		
	}
	
	private static String readStream(HttpURLConnection con, String charset) throws IOException {
		BufferedReader inputStreamReader = new BufferedReader(
				new InputStreamReader(con.getInputStream(),charset));

		String textLine;
		StringBuffer resultText = new StringBuffer();
		
		while ( (textLine = inputStreamReader.readLine()) != null  ) {
			resultText.append(textLine);
		}
		inputStreamReader.close();
		
		return resultText.toString();
	}
	
}

