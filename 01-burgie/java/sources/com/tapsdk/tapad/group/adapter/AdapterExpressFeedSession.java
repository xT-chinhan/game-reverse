package com.tapsdk.tapad.group.adapter;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterExpressFeedSession extends AdapterAdSession {
    default void render(Activity activity, AdapterExpressFeedRenderOptions adapterExpressFeedRenderOptions) {
        render(adapterExpressFeedRenderOptions);
    }

    void render(AdapterExpressFeedRenderOptions adapterExpressFeedRenderOptions);
}
