package com.bytedance.ms.xr.ms;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile c f583ms;
    private final ah xr;

    public static c ms(Context context) {
        if (f583ms == null) {
            synchronized (c.class) {
                if (f583ms == null) {
                    f583ms = new c(context);
                }
            }
        }
        return f583ms;
    }

    private c(Context context) {
        this.xr = new ah(context);
    }

    public void ms() {
        this.xr.ms();
    }
}
