package com.smartdigimkt.m;

import android.app.NotificationManager;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            NotificationManager notificationManager = this.a.a;
            if (notificationManager != null) {
                notificationManager.cancelAll();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
