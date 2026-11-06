package com.smartdigimkt.n3;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public static void a(String str, com.smartdigimkt.e1.d dVar, String str2, com.smartdigimkt.h3.b bVar, AtomicBoolean atomicBoolean) {
        String str3;
        com.smartdigimkt.a3.a aVar;
        String str4;
        String strA;
        int i;
        if (bVar == null || atomicBoolean == null) {
            return;
        }
        String str5 = null;
        if (TextUtils.isEmpty(str2)) {
            str3 = (dVar == null || (aVar = dVar.c) == null) ? null : aVar.g;
        } else {
            str3 = str2;
        }
        ConcurrentHashMap concurrentHashMap = t.a;
        if (TextUtils.isEmpty(str3)) {
            str4 = TextUtils.isEmpty(str) ? null : (String) t.b.get(str);
        } else {
            str4 = str3;
        }
        l lVar = TextUtils.isEmpty(str4) ? null : (l) t.a.get(str4);
        if (lVar == null || lVar.d || lVar.e) {
            return;
        }
        com.smartdigimkt.a3.a aVar2 = lVar.f;
        if ((aVar2 == null || (i = aVar2.k) == 0 || i == 66) && atomicBoolean.compareAndSet(false, true)) {
            if (dVar != null) {
                com.smartdigimkt.b3.b bVar2 = dVar.e;
                String str6 = bVar2 instanceof com.smartdigimkt.b3.l ? bVar2.c0 : null;
                if (!TextUtils.isEmpty(str6)) {
                    lVar.h = str6;
                }
                com.smartdigimkt.a3.a aVar3 = dVar.c;
                if (aVar3 != null) {
                    lVar.f = aVar3;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = aVar3.g;
                    }
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.smartdigimkt.a3.a aVar4 = lVar.f;
            synchronized (bVar) {
                bVar.f();
                long jC = bVar.c("entryQueue") + bVar.c("stateCheck");
                long j = bVar.p;
                if (j < 0) {
                    j = 0;
                }
                long jC2 = jC + j + bVar.c("strategy");
                long j2 = bVar.o;
                long j3 = j2 >= 0 ? j2 : 0L;
                long jMax = Math.max(0L, bVar.c("bidToken") - j3);
                long jC3 = bVar.c("bid");
                long jC4 = bVar.c("offer");
                long jC5 = bVar.c("resource");
                long j4 = bVar.k;
                long jMax2 = j4 >= 0 ? Math.max(0L, j4 - bVar.a) : 0L;
                long j5 = bVar.k;
                long jMax3 = j5 >= 0 ? Math.max(0L, jElapsedRealtime - j5) : 0L;
                strA = n.a(jC2, j3, jMax, jC3, jC4, jC5, Math.max(0L, (((((jMax2 - jC2) - j3) - jMax) - jC3) - jC4) - jC5), jMax3, jMax2 + jMax3);
            }
            com.smartdigimkt.q3.f.a().a(new i(lVar, aVar4, strA), 0L, 8);
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            } else if (!TextUtils.isEmpty(str)) {
                str5 = (String) t.b.get(str);
            }
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            t.a.remove(str5);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap concurrentHashMap2 = t.b;
            if (str5.equals(concurrentHashMap2.get(str))) {
                concurrentHashMap2.remove(str);
            }
        }
    }
}
