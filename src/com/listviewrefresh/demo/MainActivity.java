package com.listviewrefresh.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.listviewrefresh.demo.delete.DeleteListviewItemActivity;
import com.listviewrefresh.demo.horinzontallistview.HorinzontalListviewActivity;
import com.listviewrefresh.demo.pinned.PinnedSectionListActivity;
import com.listviewrefresh.demo.refresh.RefreshListViewActivity;
import com.listviewrefresh.demo.waterdrop.refresh.WaterdropListActivity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, DeleteListviewItemActivity.class));
			}
		});
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, HorinzontalListviewActivity.class));
			}
		});
		findViewById(R.id.button3).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PinnedSectionListActivity.class));
			}
		});
		findViewById(R.id.button4).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, RefreshListViewActivity.class));
			}
		});
		findViewById(R.id.button5).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, WaterdropListActivity.class));
			}
		});
	}

}
