package com.android.chat.mine.activity;

import com.android.chat.R;
import com.android.chat.util.PreferenceConstants;
import com.android.chat.util.PreferenceUtils;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

public class SplashActivity extends Activity {

	private Handler mHandler;
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mine_layout_splash);
		mContext=this;
		String password=PreferenceUtils.getPrefString(mContext, PreferenceConstants.PASSWORD, "");
		if(!TextUtils.isEmpty(password)){//如果密码不为空则跳转到主页面
			mHandler.postDelayed(gotoMainAct, 3000);
		}else{//否则,跳转到登陆页面
			mHandler.postDelayed(gotoLoginAct, 3000);
		}
	}
	
	//跳转到登陆页面
	Runnable gotoLoginAct=new Runnable() {
		@Override
		public void run() {
			startActivity(new Intent(SplashActivity.this,LoginActivity.class));
			finish();
		}
	};
	//跳转到主页面
	Runnable gotoMainAct=new Runnable() {
		@Override
		public void run() {
			startActivity(new Intent(SplashActivity.this,MainActivity.class));
			finish();
		}
	};
}
