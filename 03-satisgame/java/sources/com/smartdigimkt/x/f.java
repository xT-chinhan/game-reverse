package com.smartdigimkt.x;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.m1.d dVarA = com.smartdigimkt.m1.d.a();
        Context context = this.a.a.g;
        if (dVarA.b()) {
            String str = dVarA.c;
            dVarA.e = true;
            try {
                new com.smartdigimkt.f4.g(str).a(1, (com.smartdigimkt.a4.b) new com.smartdigimkt.m1.b(dVarA, context));
            } catch (Throwable unused) {
                dVarA.e = false;
            }
        }
    }
}
