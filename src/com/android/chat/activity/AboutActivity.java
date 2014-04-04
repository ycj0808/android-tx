package com.android.chat.activity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.android.chat.ui.swipeback.SwipeBackActivity;
import com.android.chat.ui.view.ChangeLog;
import com.android.chat.R;

public class AboutActivity extends SwipeBackActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		TextView tv = (TextView) findViewById(R.id.app_information);
		Linkify.addLinks(tv, Linkify.ALL);
	}

	public void showChangeLog(View view) {
		new ChangeLog(this).getFullLogDialog().show();
	}
}
