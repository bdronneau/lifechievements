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
		
		List<Category> listCategory = dao.parseJSONObjectToArrayList(fullObject);
		
		assertNotNull(listCategory);
	}
	
	public void testJsonDb(){
		JsonDAO dao1 = new JsonDAO(getInstrumentation().getContext());
		JsonDAO dao2 = new JsonDAO(getInstrumentation().getContext());
		
		
		//Test the holder behaviour
		assertNotNull(dao1.getJsonDb());
		dao2.setJsonDb(null);
		assertNull(dao1.getJsonDb());
	}
}
