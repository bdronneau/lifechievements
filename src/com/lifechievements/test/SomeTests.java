package com.lifechievements.test;

import org.json.JSONObject;

import android.test.InstrumentationTestCase;

import com.lifechievements.dao.JsonDAO;


public class SomeTests extends InstrumentationTestCase {
    
	public void testEnVrac() {
		// we re passing a test context to our DAO
		JsonDAO dao = new JsonDAO(getInstrumentation().getContext());
		JSONObject result = dao.getJSONFromFile("jsonData/achievements.json");
	}
}
