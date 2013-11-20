package com.lifechievements.dao;

import java.util.List;

import com.lifechievements.model.Category;

import android.content.Context;

public class CategoryDAO {

	private JsonDAO jdao;

	public CategoryDAO(Context context) {
		jdao = new JsonDAO(context);
	}

	public List<Category> findAll() {
		return jdao.getJsonDb();
	}

}
