package com.mcto.sspsdk.internal;

import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s9 {
    public static HandlerThread a;
    public static HandlerThread b;
    public static HandlerThread c;
    public static HandlerThread d;

    public static synchronized Looper a() {
        if (d == null) {
            HandlerThread handlerThread = new HandlerThread("ssp_player_callback");
            d = handlerThread;
            handlerThread.start();
        }
        return d.getLooper();
    }
}
