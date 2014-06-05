package com.example.pricedevsandroid.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.pricedevsandroid.models.Hotel;

public class HotelService {

	public ArrayList<Hotel> getHotels(){
		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet post = new HttpGet(
				     "http://test-api.pricetravel.com.mx/services/hotels?destinationId=16&destinationType=3");
			post.addHeader("Authorization", "Basic YXBpLnRlc3Q6UHJpY2VUcmF2ZWwyMDE0");
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() != 200)
			{
				return new ArrayList<Hotel>();
			}
			
			String responseString = getResponseString(response);
			JSONArray hotelsJSON = new JSONArray(responseString);
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			for (int i = 0; i < hotelsJSON.length(); i++) {
			    JSONObject row = hotelsJSON.getJSONObject(i);
			    Hotel hotel = new Hotel();
			    hotel.setId(row.getInt("Id"));
			    hotel.setName(row.getString("Name"));
			    hotels.add(hotel);
			}
			return hotels;
		}
		catch(Exception ex){
			String message = ex.getMessage();
			return new ArrayList<Hotel>();
		}
	}
	
	public String getResponseString(HttpResponse response) throws IOException{
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
		    result.append(line);
		}

		return result.toString();
	}
}
