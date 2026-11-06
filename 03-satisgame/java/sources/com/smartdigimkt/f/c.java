package com.smartdigimkt.f;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ h b;

    public c(h hVar, Context context) {
        this.b = hVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            u.a().a(new b(this));
            u.a().a(this.a);
        } catch (Throwable unused) {
        }
    }
}
