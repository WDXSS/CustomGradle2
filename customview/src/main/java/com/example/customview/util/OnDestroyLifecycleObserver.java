package com.example.customview.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public interface OnDestroyLifecycleObserver extends LifecycleObserver {

	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	public void onDestroy();

}
