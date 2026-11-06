package com.smartdigimkt.r4;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ Context a;

    public f(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.a(this.a);
    }
}
