package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static HandlerThread a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        a = handlerThread;
        handlerThread.start();
    }
}
