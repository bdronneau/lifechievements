package com.lifechievements.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.lifechievements.model.Achievement;
import com.lifechievements.model.Category;

public class JsonDAO {

	private Context context;

	public static final String ACHIEVEMENTS_JSON_PATH = "jsonData";

	/**
	 * Default constructor
	 * 
	 * @param context
	 */
	public JsonDAO(Context context) {
		this.context = context;
		// Initialize the singleton
		if (jsonDbHolder.jsonDb == null)
			initJsonDb();
	}

	/**
	 * Singleton-like behaviour for jsonDb which contains all the
	 * achievements/categories data
	 */
	private static class jsonDbHolder {

		private static ArrayList<Category> jsonDb;

	}

	public ArrayList<Category> getJsonDb() {
		return jsonDbHolder.jsonDb;
	}

	public void setJsonDb(ArrayList<Category> jsonDb) {
		jsonDbHolder.jsonDb = jsonDb;
	}

	/**
	 * Get JSON file in a JSONObject
	 * 
	 * @param file
	 *            : path/name of the file
	 * 
	 * @return : JSONObject which contain the file
	 */
	public JSONObject getJSONFromFile(String file) {
		JSONObject result = null;
		String json = null;
		// Reading text file from assets folder
		try {
			InputStream is = context.getAssets().open(file);
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
			json = null;
		}

		// try parse the string to a JSON object if content is not null
		if (json != null && json != "") {
			try {
				result = new JSONObject(json);
			} catch (JSONException e) {
				Log.e("JSON Parser", "Error parsing data " + e.toString());
				result = null;
			}
		}
		return result;
	}

	/**
	 * Parse the json from the assets into a full list of categories
	 * 
	 * @param jsonObject
	 * @return
	 */
	public ArrayList<Category> parseJSONObjectToArrayList(JSONObject jsonObject) {
		ArrayList<Category> results = new ArrayList<Category>();

		try {
			JSONArray array = jsonObject.getJSONArray("achievements");

			for (int i = 0; i < array.length(); i++) {
				results.add(parseCategory(array.getJSONObject(i)));
			}
			// Return null if we can't parse the jsonObject properly
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
			results = null;
		}

		return results;
	}

	/**
	 * @param jsonObject
	 * @return parsed Category
	 * @throws JSONException
	 */
	private Category parseCategory(JSONObject jsonObject) throws JSONException {
		Category result = null;

		List<Achievement> listAchievements = new ArrayList<Achievement>();
		List<Category> listSubCategories = new ArrayList<Category>();

		// Fill in the list of achievements
		JSONArray arrayAch = jsonObject.getJSONArray("children");
		for (int i = 0; i < arrayAch.length(); i++) {
			listAchievements.add(parseAchievement(arrayAch.getJSONObject(i)));
		}

		// Fill in the list of subcategories
		JSONArray arraySubCat = jsonObject.getJSONArray("subCategories");
		for (int i = 0; i < arraySubCat.length(); i++) {
			// recursive call to this method
			listSubCategories.add(parseCategory(arraySubCat.getJSONObject(i)));
		}

		result = new Category(jsonObject.getString("category"),
				jsonObject.getString("icon"), listAchievements,
				listSubCategories);

		return result;

	}

	/**
	 * @param jsonObject
	 * @return parsed Achievement
	 * @throws JSONException
	 */
	private Achievement parseAchievement(JSONObject jsonObject)
			throws JSONException {
		Achievement result = null;

		result = new Achievement(jsonObject.getInt("id"),
				jsonObject.getString("icon"), jsonObject.getString("title"),
				jsonObject.getString("description"));

		return result;
	}

	/**
	 * Initializes our db object with the content of the json
	 */
	private void initJsonDb() {
		String[] list;
		ArrayList<Category> listCategory = new ArrayList<Category>();
		try {
			list = context.getAssets().list(JsonDAO.ACHIEVEMENTS_JSON_PATH);

			if (list.length > 0) {
				// This is a folder
				for (String file : list) {
					JSONObject fullObject = getJSONFromFile(JsonDAO.ACHIEVEMENTS_JSON_PATH
							+ "/" + file);
					listCategory.add(parseJSONObjectToArrayList(fullObject).get(0));

				}
			}
			jsonDbHolder.jsonDb = listCategory;
		} catch (IOException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}
	}
}
