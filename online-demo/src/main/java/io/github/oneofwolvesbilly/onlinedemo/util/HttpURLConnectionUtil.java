package io.github.oneofwolvesbilly.onlinedemo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpURLConnectionUtil {

	public static String doGet(String httpUrl) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		StringBuffer result = new StringBuffer();
		
		try {
			URL url = new URL(httpUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.connect();
			
			if(connection.getResponseCode() == 200 ) {
				inputStream= connection.getInputStream();
				if(inputStream != null) {
					bufferedReader = new BufferedReader( new InputStreamReader(inputStream,"UTF-8"));
					String readLine = null;
					while((readLine = bufferedReader.readLine()) != null) {
						result.append(readLine);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			if(inputStream != null ) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			connection.disconnect();
		}
		return result.toString();
	}
}
