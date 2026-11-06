package com.smartdigimkt.n3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ com.smartdigimkt.a3.a b;
    public final /* synthetic */ String c;

    public i(l lVar, com.smartdigimkt.a3.a aVar, String str) {
        this.a = lVar;
        this.b = aVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(String.valueOf(this.a.c), String.valueOf(66));
            cVar.a = "3000022";
            cVar.a(this.b);
            if (TextUtils.isEmpty(cVar.b)) {
                cVar.b = this.a.a;
            }
            if (TextUtils.isEmpty(cVar.c)) {
                cVar.c = this.a.b;
            }
            cVar.m = String.valueOf(this.a.c);
            if (!TextUtils.isEmpty(this.a.g)) {
                cVar.l = this.a.g;
            }
            if (!TextUtils.isEmpty(this.a.h)) {
                cVar.n = this.a.h;
            }
            l lVar = this.a;
            if (lVar.c == 0 && !TextUtils.isEmpty(lVar.i)) {
                cVar.o = this.a.i;
            }
            int i = this.a.j;
            if (i >= 0) {
                cVar.p = String.valueOf(i);
            }
            l lVar2 = this.a;
            String str = "1";
            if (lVar2.c == 0 && "0".equals(lVar2.i)) {
                long j = this.a.k;
                if (j >= 0) {
                    cVar.q = String.valueOf(j);
                }
                cVar.r = this.a.l ? "1" : "0";
            }
            l lVar3 = this.a;
            if (lVar3.n) {
                cVar.s = lVar3.o ? "1" : "0";
                int i2 = lVar3.p;
                if (i2 != 7 && i2 != 8) {
                    str = "0";
                }
                cVar.v = str;
                String strB = n.b(lVar3.q);
                if (!TextUtils.isEmpty(strB)) {
                    cVar.w = strB;
                }
                com.smartdigimkt.b3.k kVar = this.a.q;
                int i3 = kVar != null ? kVar.k : -1;
                if (i3 >= 1 && i3 <= 4) {
                    cVar.x = String.valueOf(i3);
                }
            }
            long j2 = this.a.m;
            if (j2 >= 0) {
                cVar.t = String.valueOf(j2);
            }
            cVar.u = this.c;
            k.a(cVar);
        } catch (Throwable unused) {
        }
    }
}
