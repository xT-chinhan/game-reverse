package com.smartdigimkt.z;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {
    public static int a(Context context, int i) {
        return (i == 1 || i == 4) ? com.smartdigimkt.r4.k.a(context, "myoffer_shake_full_title_download_type", "string") : com.smartdigimkt.r4.k.a(context, "myoffer_shake_full_title", "string");
    }

    public static boolean b(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (c(cVar, aVar) && 1 == ((com.smartdigimkt.b3.l) cVar).U) {
            return true;
        }
        return c(cVar, aVar) && 3 == ((com.smartdigimkt.b3.l) cVar).U;
    }

    public static boolean c(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null || aVar.s == null || !"4".equals(String.valueOf(aVar.c)) || !(cVar instanceof com.smartdigimkt.b3.l) || aVar.k == 67) {
            return false;
        }
        return com.smartdigimkt.b3.h.a(2, aVar.s.R1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        if (r12.a() == false) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(com.smartdigimkt.a3.a r12) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.z.c0.d(com.smartdigimkt.a3.a):boolean");
    }

    public static boolean e(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null || aVar.s == null || !"4".equals(String.valueOf(aVar.c)) || !(cVar instanceof com.smartdigimkt.b3.l) || aVar.k == 67) {
            return false;
        }
        return com.smartdigimkt.b3.h.a(1, aVar.s.R1);
    }

    public static boolean f(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        if (aVar == null || (eVar = aVar.s) == null) {
            return false;
        }
        String strValueOf = String.valueOf(eVar.a);
        strValueOf.getClass();
        strValueOf.hashCode();
        byte b = -1;
        switch (strValueOf.hashCode()) {
            case 48:
                if (strValueOf.equals("0")) {
                    b = 0;
                }
                break;
            case 50:
                if (strValueOf.equals("2")) {
                    b = 1;
                }
                break;
            case 52:
                if (strValueOf.equals("4")) {
                    b = 2;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
                return cVar != null && cVar.h();
            default:
                return false;
        }
    }

    public static boolean g(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null) {
            return false;
        }
        String strValueOf = String.valueOf(aVar.c);
        strValueOf.getClass();
        if (strValueOf.equals("4") && aVar.s.B0 > 0) {
            return (TextUtils.isEmpty(cVar.f) && TextUtils.isEmpty(cVar.e)) ? false : true;
        }
        return false;
    }

    public static boolean h(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null) {
            return false;
        }
        String strValueOf = String.valueOf(aVar.c);
        strValueOf.getClass();
        strValueOf.hashCode();
        switch (strValueOf) {
            case "0":
            case "2":
            case "4":
                return cVar.h() && com.smartdigimkt.d0.s.a(cVar, aVar.s);
            case "1":
                return true;
            case "3":
                return cVar.n == 1 && cVar.h();
            default:
                return false;
        }
    }

    public static boolean i(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null || aVar.s == null) {
            return false;
        }
        return (e(cVar, aVar) && 1 == ((com.smartdigimkt.b3.l) cVar).U) || (e(cVar, aVar) && 3 == ((com.smartdigimkt.b3.l) cVar).U);
    }

    public static int j(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        int i;
        boolean z = false;
        if (aVar == null || (eVar = aVar.s) == null || cVar == null) {
            return 0;
        }
        int i2 = aVar.c;
        int i3 = 4;
        if ((i2 == 3 || i2 == 4) && eVar.A0 == 1) {
            return 0;
        }
        String str = cVar.l;
        if (eVar.q1 == 1) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            int i4 = zIsEmpty ? 2 : 1;
            boolean z2 = !zIsEmpty;
            if (z2 && !str.startsWith("http")) {
                z2 = false;
                i4 = 3;
            }
            if (!z2 || (i = cVar.o) == 2 || i == 3) {
                z = z2;
                i3 = i4;
            }
            if (z && TextUtils.isEmpty(cVar.k)) {
                return 5;
            }
            return i3;
        }
        return 0;
    }

    public static boolean a(com.smartdigimkt.b3.c cVar) {
        return (TextUtils.isEmpty(cVar.e) && TextUtils.isEmpty(cVar.c) && TextUtils.isEmpty(cVar.d)) ? false : true;
    }

    public static int a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar != null && aVar != null) {
            boolean zH = cVar.h();
            boolean z = (TextUtils.isEmpty(cVar.f) && TextUtils.isEmpty(cVar.a(cVar.w))) ? false : true;
            if (cVar.d() == 3) {
                return zH ? 7 : 8;
            }
            if (zH && z) {
                return 3;
            }
            if (zH) {
                return 2;
            }
            if (z) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean b(com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        if (aVar != null && (eVar = aVar.s) != null && (dVar = eVar.R1) != null && com.smartdigimkt.b3.h.a(2, dVar)) {
            String strA = dVar.a();
            if (!TextUtils.isEmpty(strA)) {
                try {
                    if (a(new JSONObject(strA.trim())) == 1) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static boolean c(com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        if (aVar == null || (eVar = aVar.s) == null || (dVar = eVar.R1) == null || !com.smartdigimkt.b3.h.a(2, dVar)) {
            return false;
        }
        String strA = dVar.a();
        return strA == null || strA.trim().isEmpty();
    }

    public static int a(com.smartdigimkt.a3.a aVar, Context context) {
        if (aVar == null) {
            return 1;
        }
        com.smartdigimkt.b3.e eVar = aVar.s;
        if (eVar != null && aVar.c == 4) {
            return eVar.m;
        }
        return com.smartdigimkt.r4.h.y(context);
    }

    public static int a(Context context, com.smartdigimkt.b3.c cVar) {
        int i = cVar.o;
        if (i != 1 && i != 4) {
            return com.smartdigimkt.r4.k.a(context, "myoffer_cta_learn_more", "string");
        }
        return com.smartdigimkt.r4.k.a(context, "myoffer_cta_install_now", "string");
    }

    public static String a(com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        if (aVar == null || (eVar = aVar.s) == null || (dVar = eVar.R1) == null || !com.smartdigimkt.b3.h.a(2, dVar)) {
            return "";
        }
        String strA = dVar.a();
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        try {
            return new JSONObject(strA.trim()).optString("ic_u", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int a(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject.has("v_m") && (objOpt = jSONObject.opt("v_m")) != null && !JSONObject.NULL.equals(objOpt)) {
            if (objOpt instanceof Number) {
                return ((Number) objOpt).intValue();
            }
            if (objOpt instanceof String) {
                String strTrim = ((String) objOpt).trim();
                if (strTrim.isEmpty()) {
                    return 0;
                }
                try {
                    return Integer.parseInt(strTrim);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
            if (objOpt instanceof Boolean) {
                return ((Boolean) objOpt).booleanValue() ? 1 : 0;
            }
        }
        return 0;
    }

    public static boolean a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.e eVar, com.smartdigimkt.h0.m mVar, int i) {
        com.smartdigimkt.h0.a aVar;
        int i2;
        if (cVar == null || eVar == null || mVar == null || (aVar = mVar.g) == null) {
            return false;
        }
        int i3 = cVar.o;
        if (eVar.h != 1 || i != i3) {
            return false;
        }
        int i4 = i == 4 ? eVar.i : 0;
        if (i == 1) {
            i4 = eVar.j;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                if (aVar.s == 0 && ((i2 = aVar.t) == 1 || i2 == 5 || i2 == 6 || i2 == 24 || i2 == 25 || i2 == 40 || i2 == 41)) {
                    return false;
                }
            }
        } else if (aVar.s != 2) {
            return false;
        }
        return true;
    }

    public static boolean d(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        if (cVar == null || aVar == null) {
            return false;
        }
        String strValueOf = String.valueOf(aVar.c);
        strValueOf.getClass();
        if (strValueOf.equals("3")) {
            return !h(cVar, aVar);
        }
        return false;
    }

    public static boolean a(com.smartdigimkt.b3.e eVar) {
        if (eVar == null || eVar.k0 != 1) {
            return false;
        }
        return !(TextUtils.equals(String.valueOf(eVar.a), "4") || TextUtils.equals(String.valueOf(eVar.a), "3") || TextUtils.equals(String.valueOf(eVar.a), "1")) || eVar.I0 == 1;
    }
}
