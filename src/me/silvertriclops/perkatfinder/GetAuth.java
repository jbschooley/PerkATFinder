package me.silvertriclops.perkatfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class GetAuth {
	public static String[] getAuth(String email, String password) {
		String[] data = new String[3];
		
		try {
			StringBuilder moo = new StringBuilder();
			URL url = new URL("https://api.perk.com/oauth/token");
			Map<String,Object> params = new LinkedHashMap<>();
			params.put("grant_type", "password");
			params.put("device_type", "perk_lite_chrome");
			params.put("client_id", randString(5));
			params.put("client_secret", randString(20));
			params.put("username", email);
			params.put("password", password);
			
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String,Object> param : params.entrySet()) {
			    if (postData.length() != 0) postData.append('&');
			    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			    postData.append('=');
			    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);
			
			InputStreamReader ins;
			if (conn.getResponseCode() == 200) {
			    ins = new InputStreamReader(conn.getInputStream(), "UTF-8");
			} else {
			    ins = new InputStreamReader(conn.getErrorStream(), "UTF-8");
			}
			Reader in = new BufferedReader(ins);
			for (int c = in.read(); c != -1; c = in.read()) {
				//System.out.print((char)c);
				moo.append((char)c);
			}
			String html = moo.toString();
			JSONObject json = new JSONObject(html);
			if (json.has("access_token") && json.has("user_id")) {
				data[0] = "0";
				data[1] = Integer.toString(json.getInt("user_id"));
				data[2] = json.getString("access_token");
				return data;
			} else {
				data[0] = "1";
				return data;
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
			data[0] = "2";
			return data;
		}
	}
	
	public static String randString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
}
