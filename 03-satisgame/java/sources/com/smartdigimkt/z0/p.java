package com.smartdigimkt.z0;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements c {
    public final q a(Looper looper, Handler.Callback callback) {
        return new q(new Handler(looper, callback));
    }
}
