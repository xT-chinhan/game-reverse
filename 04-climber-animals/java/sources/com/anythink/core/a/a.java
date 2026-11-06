package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.p;
import com.anythink.core.common.h.bo;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u;
import com.anythink.core.d.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a g;
    p a;
    Context d;
    private final String f = getClass().getSimpleName();
    ConcurrentHashMap<String, bo> e = new ConcurrentHashMap<>(3);
    SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat c = new SimpleDateFormat("yyyyMMddHH");

    public static a a(Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private a(Context context) {
        this.a = p.a(com.anythink.core.common.e.e.a(context));
        this.d = context;
    }

    public final void a() {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a.a(a.this.b.format(new Date(System.currentTimeMillis())));
            }
        }, 2);
    }

    public final int a(l lVar, String str) {
        try {
            if (lVar == null) {
                return b.n;
            }
            int iA = b.a(t.b().g()).a(str, String.valueOf(lVar.aq()), lVar.av(), lVar.aw());
            if (iA != b.n) {
                return iA;
            }
            if (!t.b().v()) {
                if (lVar.av() == -1 && lVar.aw() == -1) {
                    return b.n;
                }
                bo boVarA = a(str, lVar.aq());
                int iIntValue = boVarA != null ? boVarA.c : 0;
                int iIntValue2 = boVarA != null ? boVarA.d : 0;
                Date date = new Date();
                int i = Integer.parseInt(b.b(date));
                int i2 = Integer.parseInt(b.c(date));
                ConcurrentHashMap<String, Long> concurrentHashMap = b.a(t.b().g()).j;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    Long l = concurrentHashMap.get("day_" + i + "_" + str);
                    if (l != null) {
                        iIntValue += l.intValue();
                    }
                    Long l2 = concurrentHashMap.get("hour_" + i2 + "_" + str);
                    if (l2 != null) {
                        iIntValue2 += l2.intValue();
                    }
                }
                if (lVar.av() != -1 && iIntValue >= lVar.av()) {
                    return 2;
                }
                if (lVar.aw() != -1 && iIntValue2 >= lVar.aw()) {
                    return 2;
                }
            }
            return b.n;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int a(String str, bv bvVar, int i) {
        try {
            int iG = bvVar.g();
            String strZ = bvVar.z();
            b bVarA = b.a(t.b().g());
            String strValueOf = String.valueOf(iG);
            String strValueOf2 = String.valueOf(i);
            long jI = bvVar.i();
            long j = bvVar.j();
            bvVar.y();
            int iA = bVarA.a(strValueOf, strZ, strValueOf2, jI, j);
            if (iA != b.n) {
                return iA;
            }
            if (!t.b().v()) {
                if (bvVar.j() == -1 && bvVar.i() == -1) {
                    return b.n;
                }
                bo.a aVarA = a(str, bvVar.z(), i);
                if (aVarA == null) {
                    return b.n;
                }
                int iIntValue = aVarA.d;
                int iIntValue2 = aVarA.e;
                Date date = new Date();
                int i2 = Integer.parseInt(b.b(date));
                int i3 = Integer.parseInt(b.c(date));
                ConcurrentHashMap<String, Long> concurrentHashMap = b.a(t.b().g()).m;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    Long l = concurrentHashMap.get("day_" + i2 + "_" + strZ);
                    if (l != null) {
                        iIntValue += l.intValue();
                    }
                    Long l2 = concurrentHashMap.get("hour_" + i3 + "_" + strZ);
                    if (l2 != null) {
                        iIntValue2 += l2.intValue();
                    }
                }
                if (bvVar.j() != -1 && iIntValue2 >= bvVar.j()) {
                    return 2;
                }
                if (bvVar.i() != -1 && iIntValue >= bvVar.i()) {
                    return 2;
                }
            }
            return b.n;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final bo a(String str, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = this.b.format(new Date(jCurrentTimeMillis));
        String str3 = this.c.format(new Date(jCurrentTimeMillis));
        bo boVarA = this.e.get(str);
        if (boVarA != null) {
            if (!TextUtils.equals(boVarA.g, str2)) {
                String str4 = boVarA.g;
                boVarA.c = 0;
                boVarA.g = str2;
                boVarA.d = 0;
                boVarA.f = str3;
            } else if (!TextUtils.equals(boVarA.f, str3)) {
                String str5 = boVarA.f;
                boVarA.d = 0;
                boVarA.f = str3;
            }
        }
        synchronized (u.a().a(str)) {
            if (boVarA == null) {
                boVarA = this.a.a(str, str2, str3);
                if (boVarA == null) {
                    boVarA = new bo();
                    boVarA.b = str;
                    boVarA.a = i;
                }
                boVarA.g = str2;
                boVarA.f = str3;
                this.e.put(str, boVarA);
            }
        }
        return boVarA;
    }

    public final bo.a a(String str, String str2, int i) {
        bo.a aVarA;
        bo boVarA = a(str, i);
        if (boVarA == null || (aVarA = boVarA.a(str2)) == null) {
            return null;
        }
        if (!TextUtils.equals(aVarA.c, boVarA.g)) {
            String str3 = aVarA.a;
            String str4 = aVarA.c;
            String str5 = boVarA.g;
            aVarA.c = boVarA.g;
            aVarA.d = 0;
            aVarA.b = boVarA.f;
            aVarA.e = 0;
        } else if (!TextUtils.equals(aVarA.b, boVarA.f)) {
            String str6 = aVarA.a;
            String str7 = aVarA.b;
            String str8 = boVarA.f;
            aVarA.b = boVarA.f;
            aVarA.e = 0;
        }
        return aVarA;
    }

    public final int[] a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int[] iArrA = this.a.a(i, this.b.format(new Date(jCurrentTimeMillis)), this.c.format(new Date(jCurrentTimeMillis)));
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        return iArrA;
    }

    public static void a(n nVar, String str, String str2, String str3) {
        b.a(t.b().g()).a(nVar.Y(), str, str2, str3);
    }
}
