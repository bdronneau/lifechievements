package com.lifechievements.test;

import junit.framework.TestSuite;

import org.json.JSONObject;
import org.junit.Test;

import android.test.suitebuilder.TestSuiteBuilder;

import com.lifechievements.dao.JsonDAO;

public class MainTest extends TestSuite {
	
	public static TestSuite suite() {
        return new TestSuiteBuilder(MainTest.class).includeAllPackagesUnderHere().build();
    }
}
