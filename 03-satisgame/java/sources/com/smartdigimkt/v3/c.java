package com.smartdigimkt.v3;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f c;

    public c(f fVar, Context context, String str) {
        this.c = fVar;
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Intent intentA = f.a(this.c, this.a);
            intentA.putExtra("a", 2);
            intentA.putExtra(com.anythink.core.e.d.a, this.b);
            com.smartdigimkt.w2.a.a(this.a).a(intentA);
        } catch (Throwable unused) {
        }
    }
}
