package com.lifechievements.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//For getAssets
import android.app.Activity;
import android.util.Log;


public class JsonDAO extends Activity  {


	
	/*
	 * Default constructor
	 */
	public JsonDAO(){
		//TODO : initialization 
	}
	
	/*
	 * Get JSON file in a JSONObject
	 * 
	 * @param file : path/name of the file
	 * @return : JSONObject which contain the file
	 */
	public JSONObject getJSONFromFile(String file)
	{
		JSONObject myFile = null;
		String json = null;
			// Reading text file from assets folder
			try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("jsonData/achievements.json")));
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
	            json = sb.toString();
	        } catch (Exception e) {
	            Log.e("Buffer Error", "Error converting result " + e.toString());
	        }
			
			 // try parse the string to a JSON object
	        try {
	        	myFile = new JSONObject(json);
	        } catch (JSONException e) {
	            Log.e("JSON Parser", "Error parsing data " + e.toString());
	        }
		return myFile;
	
	}

}
