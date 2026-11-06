package com.anythink.core.common.v;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.h.bv;
import java.lang.reflect.Constructor;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class u {
    protected static u a = new u();
    protected static final String b = k.b(com.anythink.core.common.d.j.x);
    protected static final String c = ah.a(com.anythink.core.common.d.j.y);

    private static boolean a(int i) {
        return 6 == i;
    }

    public static ATBaseAdAdapter a(String str) throws NoSuchMethodException {
        if (str == null) {
            return null;
        }
        Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(ATBaseAdAdapter.class);
        if (clsAsSubclass == 0) {
            Log.w("anythink", "can not find adapter");
        }
        Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    private static ATBaseAdAdapter a(Class<? extends com.anythink.core.common.d.f> cls) throws NoSuchMethodException {
        if (cls == null) {
            Log.w("anythink", "can not find adapter");
        }
        Constructor<? extends com.anythink.core.common.d.f> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    public static com.anythink.core.common.h.p a(bv bvVar) {
        com.anythink.core.common.h.p pVarC;
        com.anythink.core.common.d.s sVarC;
        if (ATSDK.isCnSDK()) {
            int iG = bvVar.g();
            if (iG == 46) {
                return d(bvVar);
            }
            if (iG > 100000) {
                String strM = bvVar.m();
                if (!TextUtils.isEmpty(strM) && (sVarC = com.anythink.core.common.d.t.b().c()) != null && sVarC.isContainsPlStr(strM)) {
                    return d(bvVar);
                }
                pVarC = null;
            } else {
                pVarC = c(bvVar);
            }
        } else {
            pVarC = c(bvVar);
        }
        return pVarC == null ? c(bvVar) : pVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.anythink.core.common.h.p c(bv bvVar) {
        try {
            String strB = !(6 == bvVar.g()) ? "" : b(bvVar.m());
            ATBaseAdAdapter aTBaseAdAdapterA = !TextUtils.isEmpty(strB) ? a(strB) : null;
            if (aTBaseAdAdapterA == null) {
                aTBaseAdAdapterA = a(bvVar.m());
            }
            try {
                m.a(bvVar.g(), aTBaseAdAdapterA.getInternalNetworkSDKVersion());
            } catch (Throwable unused) {
            }
            return new com.anythink.core.common.h.p(aTBaseAdAdapterA);
        } catch (Throwable th) {
            return new com.anythink.core.common.h.p(th);
        }
    }

    private static com.anythink.core.common.h.p d(final bv bvVar) {
        final com.anythink.core.common.h.p[] pVarArr = new com.anythink.core.common.h.p[1];
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
            if (sVarC != null) {
                sVarC.addPlLoadStateListener(new com.anythink.core.common.k.d() { // from class: com.anythink.core.common.v.u.1
                    @Override // com.anythink.core.common.k.d
                    public final void a() {
                        pVarArr[0] = u.c(bvVar);
                        countDownLatch.countDown();
                    }
                });
            }
            try {
                countDownLatch.await(com.anythink.basead.exoplayer.i.a.f, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            th = null;
        } catch (Throwable th) {
            th = th;
            th.printStackTrace();
        }
        com.anythink.core.common.h.p pVar = pVarArr[0];
        return pVar == null ? new com.anythink.core.common.h.p(th) : pVar;
    }

    private static void a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
        try {
            m.a(bvVar.g(), aTBaseAdAdapter.getInternalNetworkSDKVersion());
        } catch (Throwable unused) {
        }
    }

    private static String a(int i, String str) {
        return !(6 == i) ? "" : b(str);
    }

    private static String b(String str) {
        try {
            String strA = a();
            String[] strArrSplit = str.replace(strA + com.anythink.core.common.d.j.z, "").split("\\.");
            if (strArrSplit != null && strArrSplit.length > 1) {
                String str2 = strArrSplit[strArrSplit.length - 1];
                String str3 = c;
                String str4 = b;
                return strA + com.anythink.core.common.d.j.z + strArrSplit[0] + com.anythink.core.common.d.j.z + str4.toLowerCase(Locale.ENGLISH) + com.anythink.core.common.d.j.z + str2.replace(str3, str4.toUpperCase(Locale.ENGLISH));
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a() {
        String[] strArrSplit = u.class.getPackage().getName().split("\\.");
        if (strArrSplit == null) {
            return "";
        }
        try {
            return strArrSplit.length > 1 ? strArrSplit[0] + com.anythink.core.common.d.j.z + strArrSplit[1] : "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
