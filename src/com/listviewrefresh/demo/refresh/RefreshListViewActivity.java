package com.listviewrefresh.demo.refresh;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import com.listviewrefresh.demo.R;
import com.listviewrefresh.demo.refresh.XListView.IXListViewListener;

public class RefreshListViewActivity extends Activity implements IXListViewListener {
	private XListView mListView;
	private ArrayAdapter<String> mAdapter;
	private ArrayList<String> items = new ArrayList<String>();
	private Handler mHandler;
	private int start = 0;
	private static int refreshCnt = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refresh_listview);
		geneItems();
		mListView = (XListView) findViewById(R.id.xListView);
		mListView.setPullLoadEnable(true);
		mAdapter = new ArrayAdapter<String>(this, R.layout.activity_refresh_list_item, items);
		mListView.setAdapter(mAdapter);
		mListView.setXListViewListener(this);
		mHandler = new Handler();
	}

	private void geneItems() {
		for (int i = 0; i != 20; ++i) {
			items.add("refresh cnt " + (++start));
		}
	}

	private void onLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}
	
	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				start = ++refreshCnt;
				items.clear();
				geneItems();
				mAdapter = new ArrayAdapter<String>(RefreshListViewActivity.this, R.layout.activity_refresh_list_item, items);
				mListView.setAdapter(mAdapter);
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				geneItems();
				mAdapter.notifyDataSetChanged();
				onLoad();
			}
		}, 2000);
	}

}