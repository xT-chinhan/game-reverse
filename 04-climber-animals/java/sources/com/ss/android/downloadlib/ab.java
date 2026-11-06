package com.ss.android.downloadlib;

/* JADX INFO: loaded from: classes3.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ab f4336ms;
    private com.ss.android.download.api.config.c xr = null;

    private ab() {
    }

    public static ab ms() {
        if (f4336ms == null) {
            synchronized (ab.class) {
                if (f4336ms == null) {
                    f4336ms = new ab();
                }
            }
        }
        return f4336ms;
    }

    public com.ss.android.download.api.config.c xr() {
        return this.xr;
    }
}
