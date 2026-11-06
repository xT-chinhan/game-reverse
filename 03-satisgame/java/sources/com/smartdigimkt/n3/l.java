package com.smartdigimkt.n3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public String a;
    public String b;
    public int c;
    public boolean d;
    public boolean e;
    public com.smartdigimkt.a3.a f;
    public String g;
    public String h;
    public String i;
    public boolean l;
    public boolean n;
    public boolean o;
    public com.smartdigimkt.b3.k q;
    public int j = -1;
    public long k = -1;
    public long m = -1;
    public int p = -1;

    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    public static l a(com.smartdigimkt.v4.a aVar) {
        String str;
        String str2 = null;
        if (aVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.a = aVar.g;
        lVar.b = aVar.e;
        lVar.c = aVar.c;
        int i = aVar.m;
        lVar.d = i == 1;
        lVar.e = i == 2;
        lVar.f = aVar.p;
        lVar.p = aVar.k;
        com.smartdigimkt.b3.k kVar = aVar.j;
        lVar.q = kVar;
        if (kVar != null) {
            lVar.g = kVar.f;
            lVar.i = kVar.h;
            lVar.j = kVar.g;
            long jA = com.smartdigimkt.b3.k.a(0L, 0L);
            if (jA >= 0) {
                lVar.k = jA;
            }
            long jA2 = com.smartdigimkt.b3.k.a(kVar.d, kVar.e);
            if (jA2 >= 0) {
                lVar.m = jA2;
            }
        }
        com.smartdigimkt.a3.a aVar2 = aVar.p;
        if (aVar2 != null) {
            lVar.l = aVar2.v;
        }
        com.smartdigimkt.v4.d dVar = aVar.u;
        if (dVar != null) {
            Object obj = dVar.a;
            if (obj instanceof com.smartdigimkt.e1.d) {
                com.smartdigimkt.e1.d dVar2 = (com.smartdigimkt.e1.d) obj;
                if (dVar2 == null) {
                    str = null;
                } else {
                    com.smartdigimkt.b3.b bVar = dVar2.e;
                    if (bVar instanceof com.smartdigimkt.b3.l) {
                        str = bVar.c0;
                    } else {
                        str = null;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
            }
        }
        lVar.h = str2;
        return lVar;
    }
}
