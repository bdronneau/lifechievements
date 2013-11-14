package com.lifechievements.dao;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            json = null;
        }
		
		 // try parse the string to a JSON object if content is not null
        if (json != null || json == ""){
        	try {
	        	myFile = new JSONObject(json);
	        } catch (JSONException e) {
	            Log.e("JSON Parser", "Error parsing data " + e.toString());
	            myFile = null;
	        }
        }   
		return myFile;
	}
	
	
	public ArrayList JSONObjectToArrayList(JSONObject jsonObjt){
		ArrayList arrayListFull = null;
				
		return arrayListFull;
	}
}
