package com.smartdigimkt.v3;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ f b;

    public b(f fVar, Context context) {
        this.b = fVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVar = this.b;
            String str = fVar.a;
            fVar.e.get();
            this.b.f.get();
            this.b.g.get();
            if (this.b.e.get() && this.b.g.get() && this.b.f.get()) {
                Intent intentA = f.a(this.b, this.a);
                intentA.putExtra("a", 1);
                com.smartdigimkt.w2.a.a(this.a).a(intentA);
            }
        } catch (Throwable unused) {
        }
    }
}
