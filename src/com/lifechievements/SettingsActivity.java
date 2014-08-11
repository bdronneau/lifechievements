package com.lifechievements;

import com.lifechievements.components.SettingsFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.app.Activity;

public class SettingsActivity extends Activity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  //Setting Layout for settings : no change from default...
  setContentView(R.layout.settings);
 
  //Display return arrow in title bar
  getActionBar().setDisplayHomeAsUpEnabled(true);
  
  //Load Fragment Setting
  getFragmentManager().beginTransaction().replace(android.R.id.content,
                new SettingsFragment()).commit();
 }
 
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()) {
     // Respond to the action bar's Up/Home button
     case android.R.id.home:
    	 //End current activity
    	 finish();
    	 return true;
	 default :
		 return super.onOptionsItemSelected(item);
     }
 }

}