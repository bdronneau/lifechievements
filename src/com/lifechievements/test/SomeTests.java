package com.lifechievements.test;

import org.json.JSONObject;

import com.lifechievements.dao.JsonDAO;

import junit.framework.Assert;
import android.test.AndroidTestCase;


public class SomeTests extends AndroidTestCase {

    public void testSomething() throws Throwable {
       Assert.assertTrue(1 + 1 == 2);
    }

    public void testSomethingElse() throws Throwable {
       Assert.assertTrue(1 + 1 == 3);
    }
    
	public void testEnVrac() {
		JsonDAO dao = new JsonDAO();
		JSONObject result = dao.getJSONFromFile("");
	}
}
