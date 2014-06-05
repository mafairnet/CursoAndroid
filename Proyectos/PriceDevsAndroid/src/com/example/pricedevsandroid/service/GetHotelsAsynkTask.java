package com.example.pricedevsandroid.service;

import java.util.ArrayList;

import android.os.AsyncTask;

import com.example.pricedevsandroid.models.Hotel;


public class GetHotelsAsynkTask extends AsyncTask<Void, Void, ArrayList<Hotel>> {

    private Exception exception;

    @Override
	protected ArrayList<Hotel> doInBackground(Void... params) {
        try {
            HotelService service = new HotelService();
            return service.getHotels();
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    protected void onPostExecute(ArrayList<Hotel> hotels) {
        // TODO: check this.exception 
        // TODO: do something with the feed
    }

}
