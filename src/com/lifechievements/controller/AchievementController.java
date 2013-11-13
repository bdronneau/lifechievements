package com.lifechievements.controller;

import java.util.ArrayList;
import java.util.List;

import com.lifechievements.dao.AchievementDAO;
import com.lifechievements.model.Achievement;

public class AchievementController {

	private AchievementDAO dao;

	public AchievementController() {
		dao = new AchievementDAO();
	}

	public AchievementDAO getDao() {
		return dao;
	}

	public int getCount() {
		// TODO return the number of sections to display
		return 0;
	}

	public List<Achievement> getAchievementsForPage(int i) {
		List<Achievement> ret = new ArrayList<Achievement>();
		// TODO return the achievement for the selected page
		return ret;
	}
}
