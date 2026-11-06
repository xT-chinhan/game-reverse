package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYExpressFeedAdLoader implements AdapterExpressFeedLoader {
    private static final int ERROR_IQY_EXPRESS_FEED_UNSUPPORTED = 10002;

    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader
    public void load(Context context, AdapterLoadRequest request, AdapterLoadCallback<AdapterExpressFeedSession> callback) {
        callback.onFailure(10002, "爱奇艺模板信息流未接入");
    }
}
