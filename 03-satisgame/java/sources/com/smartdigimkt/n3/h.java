package com.smartdigimkt.n3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public h(com.smartdigimkt.v4.a aVar, boolean z, boolean z2) {
        this.a = aVar;
        this.b = z;
        this.c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String code;
        String message;
        com.smartdigimkt.z3.a aVar;
        try {
            com.smartdigimkt.v4.a aVar2 = this.a;
            com.smartdigimkt.a3.a aVar3 = aVar2.p;
            com.smartdigimkt.b3.k kVar = aVar2.j;
            int i = aVar2.c;
            com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(String.valueOf(i), String.valueOf(66));
            cVar.a = "1004704";
            cVar.a(aVar3);
            cVar.m = "2";
            cVar.n = String.valueOf(i);
            if (kVar != null) {
                cVar.l = kVar.f;
                if (!TextUtils.isEmpty(kVar.h)) {
                    cVar.o = kVar.h;
                }
                cVar.p = String.valueOf(kVar.b - kVar.a);
                cVar.q = String.valueOf(kVar.c - kVar.a);
                cVar.r = String.valueOf(kVar.g);
                cVar.s = String.valueOf(0L);
                String str = "1";
                cVar.t = (aVar3 == null || !aVar3.v) ? "0" : "1";
                cVar.u = String.valueOf(kVar.b - kVar.c);
                if (!kVar.i) {
                    str = "0";
                }
                cVar.v = str;
                long j = kVar.d;
                if (j > 0) {
                    long j2 = kVar.e;
                    if (j2 > 0) {
                        cVar.w = String.valueOf(j2 - j);
                    }
                }
                int i2 = this.a.k;
                if (i2 >= 0) {
                    cVar.x = String.valueOf(i2);
                }
                if (kVar.j == 0) {
                    cVar.z = "0";
                }
                int i3 = kVar.k;
                if (i3 == 1 || i3 == 2) {
                    cVar.B = String.valueOf(i3);
                }
            }
            if (this.b || (aVar = this.a.t) == null) {
                code = null;
                message = null;
            } else {
                code = aVar.getCode();
                message = this.a.t.getMessage();
            }
            com.smartdigimkt.v4.a aVar4 = this.a;
            cVar.y = n.a(aVar4.i, kVar, this.b, aVar4.m, this.c, code, message);
            cVar.A = n.a(kVar);
            k.a(cVar);
        } catch (Throwable unused) {
        }
    }
}
