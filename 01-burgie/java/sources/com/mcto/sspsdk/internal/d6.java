package com.mcto.sspsdk.internal;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
public final class d6 implements Runnable {
    public final /* synthetic */ Typeface a;
    public final /* synthetic */ e6 b;

    public d6(e6 e6Var, Typeface typeface) {
        this.b = e6Var;
        this.a = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.setTypeface(this.a);
    }
}
