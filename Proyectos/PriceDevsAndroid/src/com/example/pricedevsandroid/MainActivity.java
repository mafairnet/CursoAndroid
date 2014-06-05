package com.example.pricedevsandroid;

import java.util.ArrayList;
import java.util.List;

import com.example.pricedevsandroid.ArraysAdapters.HotelArrayAdapter;
import com.example.pricedevsandroid.models.Hotel;
import com.example.pricedevsandroid.service.GetHotelsAsynkTask;
import com.example.pricedevsandroid.service.HotelService;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {
	
	/*
	 * 
	 */
	static View rootView;
	
	/*
	 * Variable del Objeto contenedor del ListView
	 */
	static ListView listView;
	
	/*
	 * (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	static List<Hotel> hotelList;
	
	/*
	 * (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	static HotelArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			hotelList = new ArrayList<Hotel>();
			
			//Cargamos el contenido de la lista de hoteles con valores estaticos
			//A futuro estos se deben que cargar dinamicamente
			
			try
			{
				hotelList = new GetHotelsAsynkTask().execute().get();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
//			Hotel tempHotel = new Hotel();
//			
//			tempHotel.setId(0);
//			tempHotel.setName("Mayan Palace");
//			tempHotel.setLogo("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn1/t1.0-1/p160x160/1010531_675077915846338_1351905964_a.jpg");
//			tempHotel.setDescription("");
//			tempHotel.setLat(0.0);
//			tempHotel.setLon(0.0);
//			tempHotel.setMainImage("");
//		
//			hotelList.add(tempHotel);
//			
//			tempHotel = new Hotel();
//			
//			tempHotel.setId(1);
//			tempHotel.setName("Club Med");
//			tempHotel.setLogo("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn1/t1.0-1/p160x160/1010531_675077915846338_1351905964_a.jpg");
//			tempHotel.setDescription("");
//			tempHotel.setLat(0.0);
//			tempHotel.setLon(0.0);
//			tempHotel.setMainImage("");
//		
//			hotelList.add(tempHotel);
//			
//			tempHotel = new Hotel();
//			
//			tempHotel.setId(2);
//			tempHotel.setName("Holiday Inn");
//			tempHotel.setLogo("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn1/t1.0-1/p160x160/1010531_675077915846338_1351905964_a.jpg");
//			tempHotel.setDescription("");
//			tempHotel.setLat(0.0);
//			tempHotel.setLon(0.0);
//			tempHotel.setMainImage("");
//		
//			hotelList.add(tempHotel);
//			
//			tempHotel = new Hotel();
//			
//			tempHotel.setId(3);
//			tempHotel.setName("Hotel One");
//			tempHotel.setLogo("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn1/t1.0-1/p160x160/1010531_675077915846338_1351905964_a.jpg");
//			tempHotel.setDescription("");
//			tempHotel.setLat(0.0);
//			tempHotel.setLon(0.0);
//			tempHotel.setMainImage("");
//		
//			hotelList.add(tempHotel);
			
			// Create a customized ArrayAdapter
			adapter = new HotelArrayAdapter( rootView.getContext(), R.layout.iconrow, hotelList);
			
			// Get reference to ListView holder
			listView = (ListView) rootView.findViewById(R.id.hotelsListView);
			
			listView.setAdapter(adapter);
			
			listView.setOnItemClickListener(new OnItemClickListener()
			{
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            	//TODO: Abrir la vista detallada del hotel
	            	TextView textView = (TextView) view.findViewById(R.id.row_toptext);
	            	String text = textView.getText().toString();
	            	Toast.makeText(rootView.getContext().getApplicationContext(), "Hotel seleccionado: "+text, Toast.LENGTH_SHORT).show();
	            }
	        });
			return rootView;
		}
	}
	
	/*@Override protected void onListItemClick(ListView listView, View view, int position, long id) {
		
		super.onListItemClick(listView, view, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(this, "Selección: " + Integer.toString(position)+  " - " + o.toString(),Toast.LENGTH_LONG).show();
	}*/


}
