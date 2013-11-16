package com.lifechievements.test;

import junit.framework.TestSuite;
import android.test.suitebuilder.TestSuiteBuilder;

public class MainTest extends TestSuite {
	
	public static TestSuite suite() {
        return new TestSuiteBuilder(MainTest.class).includeAllPackagesUnderHere().build();
    }
}
