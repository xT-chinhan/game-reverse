package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.by;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    protected static t a = new t();
    protected static final String b = j.b(com.anythink.core.common.d.i.C);
    protected static final String c = af.b(com.anythink.core.common.d.i.D);
    private static volatile JSONObject d = null;
    private static final Map<String, Constructor<?>> e = new ConcurrentHashMap();
    private static final Map<String, com.anythink.core.common.h.p> f = new ConcurrentHashMap();

    private static boolean a(int i) {
        return 6 == i;
    }

    public static ATBaseAdAdapter a(String str) throws NoSuchMethodException {
        if (str == null) {
            return null;
        }
        Map<String, Constructor<?>> map = e;
        Constructor<?> declaredConstructor = map.get(str);
        if (declaredConstructor == null) {
            Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(ATBaseAdAdapter.class);
            if (clsAsSubclass == 0) {
                Log.w("anythink", "can not find adapter");
            }
            declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            map.put(str, declaredConstructor);
        }
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    public static com.anythink.core.common.h.p a(by byVar) {
        com.anythink.core.common.h.p pVarD;
        com.anythink.core.common.d.r rVarC;
        if (ATSDK.isCnSDK()) {
            int iN = byVar.n();
            if (iN == 46) {
                return e(byVar);
            }
            if (iN > 100000) {
                String strT = byVar.t();
                if (!TextUtils.isEmpty(strT) && (rVarC = com.anythink.core.common.d.s.b().c()) != null && rVarC.isContainsPlStr(strT)) {
                    return e(byVar);
                }
                pVarD = null;
            } else {
                pVarD = d(byVar);
            }
        } else {
            pVarD = d(byVar);
        }
        return pVarD == null ? d(byVar) : pVarD;
    }

    public static com.anythink.core.common.h.p b(by byVar) {
        try {
            String strT = byVar.t();
            String strG = byVar.G();
            Map<String, com.anythink.core.common.h.p> map = f;
            com.anythink.core.common.h.p pVarA = map.get(strG + "_" + strT);
            if (pVarA == null && (pVarA = a(byVar)) != null) {
                map.put(strG + "_" + strT, pVarA);
            }
            return pVarA;
        } catch (Throwable th) {
            return new com.anythink.core.common.h.p(th);
        }
    }

    public static void a() {
        if (d == null) {
            synchronized (t.class) {
                if (d == null) {
                    try {
                        Context contextG = com.anythink.core.common.d.s.b().g();
                        int iA = p.a(contextG, "common_custom_data", "string");
                        if (iA > 0) {
                            String string = contextG.getResources().getString(iA);
                            if (!TextUtils.isEmpty(string)) {
                                d = new JSONObject(string);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (d == null) {
                    d = new JSONObject();
                }
            }
        }
    }

    private static String a(by byVar, String str) {
        if (byVar.n() >= 100000) {
            return str;
        }
        a();
        if (d != null && d.length() > 0) {
            Iterator<String> itKeys = d.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                str = str.replaceAll(next, d.optString(next));
            }
        }
        byVar.d(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.anythink.core.common.h.p d(by byVar) {
        ATBaseAdAdapter aTBaseAdAdapterA;
        int iInternalBaseOnAdapterBridgeVersion;
        int requireAdapterBridgeVersion;
        try {
            String strB = !(6 == byVar.n()) ? "" : b(byVar.t());
            if (TextUtils.isEmpty(strB)) {
                aTBaseAdAdapterA = null;
            } else {
                try {
                    aTBaseAdAdapterA = a(a(byVar, strB));
                } catch (Throwable unused) {
                    aTBaseAdAdapterA = null;
                }
            }
            if (aTBaseAdAdapterA == null) {
                aTBaseAdAdapterA = a(a(byVar, byVar.t()));
            }
            if (aTBaseAdAdapterA != null && byVar.n() < 100000 && (iInternalBaseOnAdapterBridgeVersion = aTBaseAdAdapterA.internalBaseOnAdapterBridgeVersion()) != (requireAdapterBridgeVersion = ATSDK.getRequireAdapterBridgeVersion())) {
                com.anythink.core.common.h.p pVar = new com.anythink.core.common.h.p(new Exception(String.format("Adapter Bridge version (%s) does not match SDK required version (%s).", Integer.valueOf(iInternalBaseOnAdapterBridgeVersion), Integer.valueOf(requireAdapterBridgeVersion))));
                pVar.a(ErrorCode.adapterBridgeVersionError);
                return pVar;
            }
            try {
                l.a(byVar.n(), aTBaseAdAdapterA.getInternalNetworkSDKVersion());
            } catch (Throwable unused2) {
            }
            return new com.anythink.core.common.h.p(aTBaseAdAdapterA);
        } catch (Throwable th) {
            return new com.anythink.core.common.h.p(th);
        }
    }

    private static com.anythink.core.common.h.p e(final by byVar) {
        final com.anythink.core.common.h.p[] pVarArr = new com.anythink.core.common.h.p[1];
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
            if (rVarC != null) {
                rVarC.addPlLoadStateListener(new com.anythink.core.common.j.d() { // from class: com.anythink.core.common.u.t.1
                    @Override // com.anythink.core.common.j.d
                    public final void a() {
                        pVarArr[0] = t.d(byVar);
                        countDownLatch.countDown();
                    }
                });
            }
            try {
                countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            th = null;
        } catch (Throwable th) {
            th = th;
            th.printStackTrace();
        }
        com.anythink.core.common.h.p pVar = pVarArr[0];
        return pVar == null ? new com.anythink.core.common.h.p(th) : pVar;
    }

    private static void a(by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        try {
            l.a(byVar.n(), aTBaseAdAdapter.getInternalNetworkSDKVersion());
        } catch (Throwable unused) {
        }
    }

    private static String a(int i, String str) {
        return !(6 == i) ? "" : b(str);
    }

    private static String b(String str) {
        try {
            String strB = b();
            String[] strArrSplit = str.replace(strB + com.anythink.core.common.d.i.E, "").split("\\.");
            if (strArrSplit != null && strArrSplit.length > 1) {
                String str2 = strArrSplit[strArrSplit.length - 1];
                String str3 = c;
                String str4 = b;
                return strB + com.anythink.core.common.d.i.E + strArrSplit[0] + com.anythink.core.common.d.i.E + str4.toLowerCase(Locale.ENGLISH) + com.anythink.core.common.d.i.E + str2.replace(str3, str4.toUpperCase(Locale.ENGLISH));
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String b() {
        String[] strArrSplit = t.class.getPackage().getName().split("\\.");
        if (strArrSplit == null) {
            return "";
        }
        try {
            return strArrSplit.length > 1 ? strArrSplit[0] + com.anythink.core.common.d.i.E + strArrSplit[1] : "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
