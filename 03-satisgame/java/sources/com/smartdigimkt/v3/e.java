package com.smartdigimkt.v3;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ f c;

    public e(f fVar, Context context, boolean z) {
        this.c = fVar;
        this.a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.e.get()) {
            try {
                Intent intentA = f.a(this.c, this.a);
                intentA.putExtra("a", 4);
                intentA.putExtra(com.anythink.core.e.d.a, this.b ? "1" : "2");
                com.smartdigimkt.w2.a.a(this.a).a(intentA);
            } catch (Throwable unused) {
            }
        }
    }
}
