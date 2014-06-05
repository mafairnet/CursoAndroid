package com.example.pricedevsandroid.ArraysAdapters;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.pricedevsandroid.models.Hotel;
import com.example.pricedevsandroid.utils.ImageLoader;

import com.example.pricedevsandroid.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelArrayAdapter extends ArrayAdapter<Hotel>{
	
	private static final String ASSETS_DIR = "images/systems/";
	
	/*
	 * Contexto principal de la aplicacion
	 */
	private Context context;
	
	/*
	 * Direccion de la imagen dle logo del hotel
	 */
	private ImageView hotelLogo;
	
	/*
	 * Nombre del Hotel
	 */
	private TextView hotelName;
	
	/*
	 * 
	 */
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	public HotelArrayAdapter(Context context, int textViewResourceId, List<Hotel> objects)
	{
		super(context, textViewResourceId, objects);
		this.context = context;
		this.hotels = objects;
	}
	
	public int getCount()
	{
		return this.hotels.size();
	}

	public Hotel getItem(int index)
	{
		return this.hotels.get(index);
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		
		if (row == null) {
			// ROW INFLATION
			LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.iconrow, parent, false);
		}

		// Get item
		Hotel hotel = getItem(position);
		
		// Get reference to ImageView 
		//hotelLogo = (ImageView) row.findViewById(R.id.icon);
		
		// Get reference to TextView - country_name
		hotelName = (TextView) row.findViewById(R.id.row_toptext);

		//Set country name
		hotelName.setText(hotel.getName());
		
		// Set country icon usign File path
		//String imgFilePath = ASSETS_DIR + hotel.getLogo();
		
		/*try
		{*/
			/*Bitmap bitmap = BitmapFactory.decodeStream(this.context.getResources().getAssets().open(imgFilePath));
			hotelLogo.setImageBitmap(bitmap);*/
			/*URL url = new URL(hotel.getLogo());
			InputStream content = (InputStream)url.getContent();
			Drawable image = Drawable.createFromStream(content , "src");
			hotelLogo.setImageDrawable(image);*/
		/*}*/
		
		/*catch (MalformedURLException e) {
		    Log.e("log", "bad url "+ e.getMessage());
		}*/
		
		/*catch (IOException e) {
			Log.e("log", "io error "+ e.getMessage());
		}*/
			
		/*try {
			URL url = new URL(hotel.getLogo());
			Log.e("IMG", hotel.getLogo());
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			hotelLogo.setImageBitmap(myBitmap);
		} catch (IOException e) {
			Log.e("ERROR",e.getMessage());
		}*/
		
		/*try {
	        InputStream is = (InputStream) new URL(hotel.getLogo()).getContent();
	        Drawable d = Drawable.createFromStream(is, "src name");
	        hotelLogo.setImageDrawable(d);
	    } catch (Exception e) {
	    	Log.e("ERROR",e.toString());
	    }*/
		int loader = R.drawable.loader;
		ImageLoader imgLoader = new ImageLoader(parent.getContext().getApplicationContext());
		imgLoader.DisplayImage(hotel.getLogo(), loader, hotelLogo);
			
		return row;
	}
}


 
