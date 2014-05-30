package com.example.viewbannerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oliver.viewbanner.view.BannerView;
import com.oliver.viewbanner.view.ImagePageAdapter;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private BannerView viewBanner;
		private int[] imageResId; // 图片ID

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			viewBanner = (BannerView) rootView.findViewById(R.id.viewBanner);
			imageResId = new int[] { R.drawable.c, R.drawable.b, R.drawable.a,
					R.drawable.c, R.drawable.b, R.drawable.a };
			ImagePageAdapter imagePageAdapter = new ImagePageAdapter(
					getActivity(), imageResId.length);
			imagePageAdapter
					.addImagePageAdapterListener(new ImagePageAdapter.ImagePageAdapterListener() {

						@Override
						public void dispalyImage(ImageView banner, int position) {
							banner.setImageResource(imageResId[position]);

						}

					});
			viewBanner.setBannerAdapter(imagePageAdapter);
			return rootView;
		}
	}

}
