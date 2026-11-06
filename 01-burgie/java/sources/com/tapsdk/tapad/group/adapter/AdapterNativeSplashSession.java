package com.tapsdk.tapad.group.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterNativeSplashSession extends AdapterSplashSession, AdapterNativeCreativeSession {
    void bind(Activity activity, AdapterNativeSplashBinding adapterNativeSplashBinding);

    View getMediaView(Context context);

    default void setVideoMuted(boolean z) {
    }

    default boolean updateSplashInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        return false;
    }
}
