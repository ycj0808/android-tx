package com.android.chat.activity;

import com.android.chat.service.ChatService;

public interface FragmentCallBack {
	public ChatService getService();

	public MainActivity getMainActivity();
}
