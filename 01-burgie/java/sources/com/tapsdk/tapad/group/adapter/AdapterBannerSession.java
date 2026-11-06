package com.tapsdk.tapad.group.adapter;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterBannerSession extends AdapterAdSession {
    View getView();

    default boolean show(Activity activity, int i, int i2) {
        return AdapterViewSupport.attachBanner(activity, getView(), i, i2);
    }
}
