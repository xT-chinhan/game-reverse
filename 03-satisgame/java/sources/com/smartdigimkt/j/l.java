package com.smartdigimkt.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ m b;

    public l(m mVar, Context context) {
        this.b = mVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null || !com.smartdigimkt.r4.k.d(this.a, "android.permission.ACCESS_NETWORK_STATE")) {
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (com.smartdigimkt.r4.k.c(this.a) && activeNetworkInfo.getType() == 1) {
                this.b.a.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
