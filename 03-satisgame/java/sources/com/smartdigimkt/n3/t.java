package com.smartdigimkt.n3;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    public static void a(com.smartdigimkt.v4.a aVar, boolean z) {
        if (aVar == null || TextUtils.isEmpty(aVar.g)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = a;
        l lVarA = (l) concurrentHashMap.get(aVar.g);
        if (lVarA == null) {
            lVarA = l.a(aVar);
        } else {
            l lVarA2 = l.a(aVar);
            if (lVarA2 != null) {
                if (!TextUtils.isEmpty(lVarA2.g)) {
                    lVarA.g = lVarA2.g;
                }
                if (!TextUtils.isEmpty(lVarA2.h)) {
                    lVarA.h = lVarA2.h;
                }
                if (!TextUtils.isEmpty(lVarA2.i)) {
                    lVarA.i = lVarA2.i;
                }
                int i = lVarA2.j;
                if (i >= 0) {
                    lVarA.j = i;
                }
                long j = lVarA2.k;
                if (j >= 0) {
                    lVarA.k = j;
                }
                long j2 = lVarA2.m;
                if (j2 >= 0) {
                    lVarA.m = j2;
                }
                lVarA.l = lVarA2.l;
                com.smartdigimkt.a3.a aVar2 = lVarA2.f;
                if (aVar2 != null) {
                    lVarA.f = aVar2;
                }
                int i2 = lVarA2.p;
                if (i2 >= 0) {
                    lVarA.p = i2;
                }
                com.smartdigimkt.b3.k kVar = lVarA2.q;
                if (kVar != null) {
                    lVarA.q = kVar;
                }
                if (lVarA2.n) {
                    lVarA.n = true;
                    lVarA.o = lVarA2.o;
                }
            }
        }
        lVarA.n = true;
        lVarA.o = z;
        l lVar = (l) concurrentHashMap.get(lVarA.a);
        if (lVar != null && lVar.n) {
            lVarA.n = true;
            lVarA.o = lVar.o;
        }
        concurrentHashMap.put(lVarA.a, lVarA);
        if (TextUtils.isEmpty(lVarA.b)) {
            return;
        }
        b.put(lVarA.b, lVarA.a);
    }
}
