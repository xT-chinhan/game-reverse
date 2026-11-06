package com.mcto.sspsdk.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c3 implements Runnable {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ e3 b;

    public c3(e3 e3Var, ArrayList arrayList) {
        this.b = e3Var;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.c.onNativeAdLoad(this.a);
        } catch (Throwable th) {
        }
    }
}
