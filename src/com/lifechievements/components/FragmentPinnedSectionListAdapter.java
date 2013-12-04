package com.lifechievements.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hb.views.PinnedSectionListView.PinnedSectionListAdapter;
import com.lifechievements.R;
import com.lifechievements.model.Achievement;
import com.lifechievements.model.Category;

public class FragmentPinnedSectionListAdapter extends BaseAdapter implements
		PinnedSectionListAdapter {

	private final static int TYPE_ITEM_CATEGORY = 0;
	private final static int TYPE_ITEM_ACHIEVEMENT = 1;

	private Context mContext;
	private Category mCategory;
	private List<Object> mList;

	public FragmentPinnedSectionListAdapter(Context context, Category category) {
		this.mContext = context;
		this.mCategory = category;
		this.mList = new ArrayList<Object>();
		initList();
	}

	public List<Object> getListObject() {
		return mList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// if (convertView == null) {
		// TODO do not create a view everytime
		// We must create a View:
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// }
		// Here we can do changes to the convertView, such as set a text on a
		// TextView
		// or an image on an ImageView.

		if (getItemViewType(position) == TYPE_ITEM_ACHIEVEMENT) {

			convertView = inflater.inflate(
					R.layout.pinned_section_achievement_row, parent, false);
			TextView textView = (TextView) convertView
					.findViewById(R.id.achievement);

			textView.setText(((Achievement) mList.get(position)).getTitle());

		} else if (getItemViewType(position) == TYPE_ITEM_CATEGORY) {

			convertView = inflater.inflate(
					R.layout.pinned_section_achievement_pinned_row, parent,
					false);
			TextView textView = (TextView) convertView
					.findViewById(R.id.pinned_achievement);
			textView.setText(((Category) mList.get(position)).getTitle());
		}

		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		Object obj = mList.get(position);
		if (obj instanceof Category) {
			return TYPE_ITEM_CATEGORY;
		} else if (obj instanceof Achievement) {
			return TYPE_ITEM_ACHIEVEMENT;
		}
		return -1;
	}

	@Override
	public boolean isItemViewTypePinned(int viewType) {
		return viewType == TYPE_ITEM_CATEGORY;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * BEGIN business methods
	 */

	/**
	 * Sets up mList
	 */
	private void initList() {

		Stack<Category> tmpCategories = new Stack<Category>();
		tmpCategories.push(mCategory);

		Category category = null;
		while (tmpCategories.size() > 0) {
			category = tmpCategories.pop();

			// Add all categories but the section to the list
			if (category != mCategory)
				mList.add(category);

			// Adds all achievements
			try {
				for (Achievement achievement : category.getChildren()) {
					mList.add(achievement);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Adds all subcategories
			if (category.getSubCat().size() > 0) {
				for (Category tmpCategory : category.getSubCat()) {
					tmpCategories.push(tmpCategory);
				}
			}
		}
	}
	/**
	 * END business methods
	 */

}
