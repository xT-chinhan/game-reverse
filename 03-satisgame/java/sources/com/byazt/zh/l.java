package com.byazt.zh;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1161, 18})
public class l {
    public static String n;
    public static int q;
    public static String qg;
    public static String s;

    public static boolean qg() {
        return true;
    }

    public static void n() {
        if (qg() && com.byazt.vyf.s.cy().an() && q()) {
            com.byazt.vyf.s.cy().f();
        }
    }

    public static boolean s() {
        return tj.l >= 7300;
    }

    public static boolean q() {
        JSONObject jSONObjectJe = rv.qg().je();
        return jSONObjectJe == null || jSONObjectJe.optInt("can_req_plugin", 1) == 1;
    }

    public static int l() {
        try {
            JSONObject jSONObjectJe = rv.qg().je();
            if (jSONObjectJe != null) {
                return jSONObjectJe.optInt("load_pl_conf", 0);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int s(String str) {
        try {
            JSONObject jSONObjectJe = rv.qg().je();
            if (jSONObjectJe != null) {
                return jSONObjectJe.optInt(str, 0);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = s("use_dex_load_".concat(String.valueOf(str))) == 1;
        MediationConstant.ADN_GDT.equals(str);
        return z;
    }

    public static String w() {
        if (!TextUtils.isEmpty(qg)) {
            return qg;
        }
        try {
            Object objInvoke = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                qg = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String x() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            Object objInvoke = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                n = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String fs() {
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                s = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int rv() {
        if (q == 0) {
            q = com.byazt.wl.l.s("com.byted.mixed");
        }
        return q;
    }

    public static void n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            n nVar = (n) com.byazt.qp.q.n("adapter_dex");
            if (nVar != null) {
                Map<String, Map<String, Object>> mapN = nVar.n();
                Map<String, Object> concurrentHashMap = mapN.get(str);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    mapN.put(str, concurrentHashMap);
                } else {
                    Object obj = concurrentHashMap.get(str2);
                    int iIntValue = obj == null ? 0 : ((Integer) obj).intValue();
                    if (iIntValue != 0 && iIntValue >= i) {
                        return;
                    }
                }
                concurrentHashMap.put(str2, Integer.valueOf(i));
            }
        } catch (Throwable unused) {
        }
    }

    public static void n(String str, int i) {
        n("common_dex", str, i);
    }

    public static int qg(String str) {
        try {
            n nVar = (n) com.byazt.qp.q.n("adapter_dex");
            if (nVar == null) {
                return -1;
            }
            Map<String, Map<String, Object>> mapN = nVar.n();
            if (mapN == null) {
                return 0;
            }
            Map<String, Object> map = mapN.get("common_dex");
            int iIntValue = map != null ? ((Integer) map.get("dex_status")).intValue() : 0;
            Map<String, Object> map2 = str == null ? null : mapN.get(str);
            return iIntValue + (map2 != null ? ((Integer) map2.get("dex_status")).intValue() : 0);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
