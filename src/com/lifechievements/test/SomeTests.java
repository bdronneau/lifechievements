package com.lifechievements.test;

import java.util.List;

import org.json.JSONObject;

import android.test.InstrumentationTestCase;

import com.lifechievements.dao.JsonDAO;
import com.lifechievements.model.Category;


public class SomeTests extends InstrumentationTestCase {
    
	public void testEnVrac() {
		// we re passing a test context to our DAO
		JsonDAO dao = new JsonDAO(getInstrumentation().getContext());
		JSONObject fullObject = dao.getJSONFromFile("jsonData/achievements.json");
		
		List<Category> listCategory = dao.JSONObjectToArrayList(fullObject);
		
		assertNotNull(listCategory);
	}
}
