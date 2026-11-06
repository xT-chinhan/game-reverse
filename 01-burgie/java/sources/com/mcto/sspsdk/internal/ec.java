package com.mcto.sspsdk.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class ec implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public ec(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fc.a(this.a, this.b, 1000);
    }
}
