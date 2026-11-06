package com.varbto.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ Context a;

    public n(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            String strA = o.a(this.a);
            if (strA == null) {
                strA = "";
            }
            o.a = strA;
            try {
                m.a("SystemInfoCollector", "initStaticHeader() >>> ok, length=" + o.a.length(), new Object[0]);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            o.a("initStaticHeader() >>> failed", th);
            o.a = "";
        }
    }
}
