package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.f;
import com.anythink.core.common.h.g;
import com.anythink.core.common.h.k;
import com.anythink.core.common.v.af;
import com.anythink.core.d.l;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c d;
    final String a = "c";
    ConcurrentHashMap<String, g> b = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, g> c = new ConcurrentHashMap<>();

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        int iA = b.a(context).a(str);
        return iA != b.n ? iA : b.n;
    }

    public final int a(Context context, String str, l lVar) {
        if (context == null || lVar == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        int iAE = lVar.aE();
        long jAF = lVar.aF();
        int iA = b.a(context).a(iAE, jAF, str);
        if (iA != b.n) {
            return iA;
        }
        if (t.b().v() || !a(context, iAE, jAF, u.b.c, a(str, ""), this.b, str, 0)) {
            return b.n;
        }
        return 8;
    }

    public static void b(Context context, String str, l lVar) {
        if (context == null || lVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).a(lVar.aE(), lVar.aF(), str, lVar.aq());
    }

    public final int a(Context context, bv bvVar, String str, int i) {
        if (context == null || bvVar == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        int iBn = bvVar.bn();
        long jBo = bvVar.bo();
        String strZ = bvVar.z();
        String strA = a(str, strZ);
        int iA = b.a(context).a(iBn, jBo, bvVar.g(), strZ, String.valueOf(i));
        if (iA != b.n) {
            return iA;
        }
        if (t.b().v() || !a(context, iBn, jBo, u.b.c, strA, this.c, strZ, 1)) {
            return b.n;
        }
        return 18;
    }

    public static void a(Context context, bv bvVar, String str) {
        if (context == null || bvVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (context != null && bvVar != null && !TextUtils.isEmpty(str)) {
            b.a(context).d(bvVar);
        }
        int iBn = bvVar.bn();
        long jBo = bvVar.bo();
        String strZ = bvVar.z();
        b.a(context).b(iBn, jBo, bvVar.g(), strZ, String.valueOf(bvVar.bf()));
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + "_" + str2;
    }

    private static boolean a(Context context, int i, long j, String str, String str2, ConcurrentHashMap<String, g> concurrentHashMap, String str3, int i2) {
        ConcurrentHashMap<String, f> concurrentHashMap2;
        f fVar;
        int i3;
        f fVar2;
        Object[] objArr = new Object[4];
        Integer.valueOf(i);
        Long.valueOf(j);
        boolean z = false;
        if (i > 0 && j > 0 && concurrentHashMap != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            g gVar = concurrentHashMap.get(str2);
            if (gVar == null) {
                gVar = new g();
                String strC = af.c(context, str, str2, "");
                if (!TextUtils.isEmpty(strC)) {
                    gVar.a(strC);
                }
                concurrentHashMap.put(str2, gVar);
            }
            int i4 = gVar.a;
            long j2 = gVar.b;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (i2 != 0) {
                if (i2 == 1 && (concurrentHashMap2 = b.a(t.b().g()).f) != null && !TextUtils.isEmpty(str3) && (fVar = concurrentHashMap2.get(str3)) != null && jCurrentTimeMillis - j2 <= j && jCurrentTimeMillis - fVar.i() <= j) {
                    i3 = fVar.a;
                    i4 += i3;
                }
            } else {
                ConcurrentHashMap<String, f> concurrentHashMap3 = b.a(t.b().g()).c;
                if (concurrentHashMap3 != null && !TextUtils.isEmpty(str3) && (fVar2 = concurrentHashMap3.get(str3)) != null && jCurrentTimeMillis - j2 <= j && jCurrentTimeMillis - fVar2.i() <= j) {
                    i3 = fVar2.a;
                    i4 += i3;
                }
            }
            if (i4 >= i && System.currentTimeMillis() - j2 <= j) {
                z = true;
            }
            gVar.toString();
        }
        return z;
    }

    private static void a(Context context, int i, long j, String str, String str2, ConcurrentHashMap<String, g> concurrentHashMap) {
        Object[] objArr = new Object[4];
        Integer.valueOf(i);
        Long.valueOf(j);
        if (i <= 0 || j <= 0 || concurrentHashMap == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        g gVar = concurrentHashMap.get(str2);
        if (gVar == null) {
            String strC = af.c(context, str, str2, "");
            g gVar2 = new g();
            if (!TextUtils.isEmpty(strC)) {
                gVar2.a(strC);
            }
            concurrentHashMap.put(str2, gVar2);
            gVar = gVar2;
        }
        if (System.currentTimeMillis() - gVar.b > j) {
            gVar.b = System.currentTimeMillis();
            gVar.a = 0;
        }
        gVar.a++;
        gVar.toString();
        af.b(context, str, str2, gVar.toString());
    }

    public static void b(Context context, bv bvVar, String str) {
        if (context == null || bvVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).a(bvVar);
    }

    public static k a(Context context, bv bvVar) {
        if (context == null || bvVar == null) {
            return null;
        }
        return b.a(context).b(bvVar);
    }

    public static void b(Context context, bv bvVar) {
        if (context == null || bvVar == null) {
            return;
        }
        b.a(context).c(bvVar);
    }

    private static void c(Context context, bv bvVar, String str) {
        if (context == null || bvVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).d(bvVar);
    }
}
