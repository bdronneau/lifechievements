package com.lifechievements.controller;

import java.util.List;

import android.content.Context;

import com.lifechievements.dao.CategoryDAO;
import com.lifechievements.model.Category;

public class CategoryController {

	private CategoryDAO dao;

	public CategoryController(Context context) {
		dao = new CategoryDAO(context);
	}

	public List<Category> findAll() {
		return dao.findAll();
	}

}
