package com.lifechievements.dao;

import java.util.List;

import com.lifechievements.model.Achievement;
import com.lifechievements.model.Category;

public class AchievementDAO {
	
	private static String JSON_URL = "assets/achievement.json";
	private JsonDAO jdao;
	
	public AchievementDAO(){
		//init dao with  json file
	}
	
	
	public List<Achievement> findAllForCategory(Category category){
		return null;
	}

}
