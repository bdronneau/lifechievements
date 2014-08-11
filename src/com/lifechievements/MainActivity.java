package com.lifechievements;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

//TODO : DELETE this because is debug 
import android.widget.Toast;

import com.lifechievements.components.FragmentPinnedSectionListAdapter;
import com.lifechievements.controller.CategoryController;
import com.lifechievements.model.Category;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	CategoryController categoryController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		categoryController = new CategoryController(this);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	   switch (item.getItemId()) {
	       case R.id.menu_connect:
	         Toast.makeText(this, "Connect", Toast.LENGTH_SHORT).show();
	         return true;           
	       case R.id.menu_about:
	         Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
	         return true;           
	        case R.id.menu_settings:
	          //Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
	          //Intent intent = new Intent(this, SettingsActivity.class);
	         //this.startActivity(intent);
	          startActivity(new Intent(this, SettingsActivity.class));
	          return true;           
	        default:
	          return super.onOptionsItemSelected(item);
	    }
	}
	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new PinnedSectionListFragment();
			
			Bundle args = new Bundle();
            args.putInt(PinnedSectionListFragment.ARG_SECTION_NUMBER, position);
            fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return categoryController.findAll().size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return categoryController.findSectionByPosition(position).getTitle();
		}
	}

	public static class PinnedSectionListFragment extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";
		
		public PinnedSectionListFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.pinned_section_list_view,
					container, false);
			ListView pinnedSectionListView = (ListView) rootView
					.findViewById(R.id.pinned_section_list);

			CategoryController cc = new CategoryController(getActivity());
			List<Category> list = cc.findAll();

			FragmentPinnedSectionListAdapter pinnedSectionListAdapter = new FragmentPinnedSectionListAdapter(
					getActivity(), list.get(getArguments().getInt(
                            ARG_SECTION_NUMBER)));

			pinnedSectionListView.setAdapter(pinnedSectionListAdapter);
			return rootView;
		}
	}

}
