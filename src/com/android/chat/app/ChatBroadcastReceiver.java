package com.android.chat.app;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.text.TextUtils;

import com.android.chat.service.ChatService;
import com.android.chat.util.LogUtil;
import com.android.chat.util.PreferenceConstants;
import com.android.chat.util.PreferenceUtils;

public class ChatBroadcastReceiver extends BroadcastReceiver {
	public static final String BOOT_COMPLETED_ACTION = "com.way.action.BOOT_COMPLETED";
	public static ArrayList<EventHandler> mListeners = new ArrayList<EventHandler>();

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		LogUtil.i("action = " + action);
		if (TextUtils.equals(action, ConnectivityManager.CONNECTIVITY_ACTION)) {
			if (mListeners.size() > 0)// 通知接口完成加载
				for (EventHandler handler : mListeners) {
					handler.onNetChange();
				}
		} else if (intent.getAction().equals(Intent.ACTION_SHUTDOWN)) {
			LogUtil.d("System shutdown, stopping service.");
			Intent xmppServiceIntent = new Intent(context, ChatService.class);
			context.stopService(xmppServiceIntent);
		} else {
			if (!TextUtils.isEmpty(PreferenceUtils.getPrefString(context,
					PreferenceConstants.PASSWORD, ""))
					&& PreferenceUtils.getPrefBoolean(context,
							PreferenceConstants.AUTO_START, true)) {
				Intent i = new Intent(context, ChatService.class);
				i.setAction(BOOT_COMPLETED_ACTION);
				context.startService(i);
			}
		}
	}

	public static abstract interface EventHandler {

		public abstract void onNetChange();
	}
}
