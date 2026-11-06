package com.tapsdk.tapad;

import com.tapsdk.tapad.exceptions.AdException;

/* JADX INFO: loaded from: classes2.dex */
public interface Callback {
    void onError(AdException adException);

    void onSuccess();
}
