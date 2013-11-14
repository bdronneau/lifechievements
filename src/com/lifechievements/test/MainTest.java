package com.lifechievements.test;

import org.json.JSONObject;
import org.junit.Test;

import com.lifechievements.dao.JsonDAO;

public class MainTest {

	@Test
	public void testEnVrac(){
		JsonDAO dao = new JsonDAO();
		JSONObject result = dao.getJSONFromFile("");
	}
}
