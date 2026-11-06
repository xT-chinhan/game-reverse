package com.tapsdk.tapad.internal.oaid;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface OaidSource {

    public interface OaidFetchCallback {
        void onComplete(String str);
    }

    void fetchAsync(Context context, OaidFetchCallback oaidFetchCallback);

    String getCached();

    String getName();
}
