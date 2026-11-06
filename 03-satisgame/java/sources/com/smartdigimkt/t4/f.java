package com.smartdigimkt.t4;

import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public String a;
    public final WeakReference b;
    public com.smartdigimkt.m3.d c;
    public boolean e = false;
    public final e d = new e(this);

    public f(h hVar) {
        this.b = new WeakReference(hVar);
    }

    public final synchronized void a() {
        com.smartdigimkt.m3.d dVar = this.c;
        if (dVar != null) {
            dVar.c();
        }
        this.c = null;
    }

    public final synchronized void b() {
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        com.smartdigimkt.p4.e eVarB = com.smartdigimkt.o4.o.a().b(this.a);
        if (this.c != null) {
            a();
        }
        if (eVarB != null && eVarB.n == 1) {
            this.e = true;
            long j = eVarB.o;
            if (j <= 2000) {
                j = 2000;
            }
            com.smartdigimkt.m3.d dVar = new com.smartdigimkt.m3.d(j, this.d);
            this.c = dVar;
            dVar.b();
        }
    }
}
