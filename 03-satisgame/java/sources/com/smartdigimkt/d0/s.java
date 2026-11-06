package com.smartdigimkt.d0;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static final HashMap a = new HashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap(3);

    public static boolean a(int i, String str) {
        String strB = com.smartdigimkt.r4.i.b(str);
        com.smartdigimkt.i3.n nVarA = com.smartdigimkt.i3.n.a();
        nVarA.getClass();
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return new File(nVarA.b(i, strB)).exists();
    }

    public static void b(int i, String str) {
        HashMap map = a;
        Integer num = (Integer) map.get(str);
        if (num == null || num.intValue() < i) {
            map.put(str, Integer.valueOf(i));
        }
    }

    public static String c(com.smartdigimkt.b3.c cVar) {
        return com.smartdigimkt.f.i.a(new StringBuilder().append(cVar.x).append("_"), cVar.a, "_3");
    }

    public static boolean b(com.smartdigimkt.b3.c cVar) {
        if (cVar != null && cVar.d() == 3) {
            if (b.containsKey(c(cVar))) {
                return true;
            }
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (eVar != null && eVar.w1 != 1) {
                return !TextUtils.isEmpty(d(cVar));
            }
        }
        return false;
    }

    public static String d(com.smartdigimkt.b3.c cVar) {
        if (cVar == null) {
            return "";
        }
        com.smartdigimkt.i3.n nVarA = com.smartdigimkt.i3.n.a();
        com.smartdigimkt.b3.e eVar = cVar.w;
        String strB = nVarA.b(eVar != null ? eVar.t1 : "");
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA != null && !aVarA.g) {
            String str = aVarA.N;
            if (!TextUtils.isEmpty(str)) {
                String strB2 = com.smartdigimkt.i3.n.a().b(str);
                if (!TextUtils.isEmpty(strB2)) {
                    return strB2;
                }
            }
        }
        return "";
    }

    public static boolean a(com.smartdigimkt.b3.e eVar, int i, com.smartdigimkt.b3.c cVar) {
        if (TextUtils.equals(String.valueOf(i), "1")) {
            if (!TextUtils.isEmpty(cVar.i)) {
                return a(cVar, eVar);
            }
            if (eVar.i0 != 1 && eVar.j0 <= 0) {
                return a(cVar);
            }
            if (TextUtils.isEmpty(cVar.f)) {
                return false;
            }
            return a(cVar);
        }
        if (TextUtils.equals(String.valueOf(i), "3")) {
            if (cVar.n == 1 && !TextUtils.isEmpty(cVar.i)) {
                return a(cVar, eVar);
            }
            return a(cVar);
        }
        if (TextUtils.equals(String.valueOf(i), "4")) {
            return a(cVar, eVar) || a(cVar);
        }
        return true;
    }

    public static boolean a(com.smartdigimkt.b3.c cVar) {
        if (TextUtils.isEmpty(cVar.f)) {
            return false;
        }
        String strB = com.smartdigimkt.r4.i.b(cVar.f);
        com.smartdigimkt.i3.n nVarA = com.smartdigimkt.i3.n.a();
        nVarA.getClass();
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return new File(nVarA.b(1, strB)).exists();
    }

    public static boolean a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null) {
            return false;
        }
        if (cVar.D == -1) {
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            if (bVarE != null && bVarE.a()) {
                bVarE.fillDataFetchStatus(SDKContext.getInstance().d(), cVar, aVar);
            } else {
                cVar.D = 0;
            }
        }
        com.smartdigimkt.b3.e eVar = aVar.s;
        com.smartdigimkt.b3.e eVar2 = cVar.w;
        if (eVar2 != null) {
            eVar = eVar2;
        }
        return a(eVar, aVar.c, cVar);
    }

    public static boolean a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.e eVar) {
        boolean z;
        int i = eVar.S;
        String str = cVar.i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        com.smartdigimkt.t2.z zVarA = com.smartdigimkt.t2.z.a();
        synchronized (zVarA) {
            z = zVarA.a(str) >= i;
        }
        if (z) {
            c0.a(cVar, eVar);
        }
        return z;
    }
}
