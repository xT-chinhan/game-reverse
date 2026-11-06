package com.byazt.ehw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 21})
public class x {
    public static void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str == null) {
                str = "";
            }
            com.byazt.lq.s.qg(7, str);
        } catch (Throwable unused) {
        }
    }

    public static void n(com.byazt.hnb.q qVar) {
        com.byazt.orb.n.n(qVar);
        com.byazt.wq.qg.n().n(qVar);
    }

    public static String qg(com.byazt.hnb.q qVar) {
        JSONObject jSONObjectN;
        if (qVar != null) {
            String type = qVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            com.byazt.zve.qg qgVarN = qVar.n();
            if (qgVarN != null && !TextUtils.isEmpty(qgVarN.n()) && (jSONObjectN = n(qgVarN)) != null) {
                return jSONObjectN.toString();
            }
        }
        return "error";
    }

    public static String s(com.byazt.hnb.q qVar) {
        if (qVar == null) {
            return null;
        }
        String type = qVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        com.byazt.zve.qg qgVarN = qVar.n();
        return (qgVarN == null || TextUtils.isEmpty(qgVarN.n())) ? "error" : qgVarN.n();
    }

    private static JSONObject n(com.byazt.zve.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        String strN = qgVar.n();
        long jS = qgVar.s();
        boolean zQg = qgVar.qg();
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", strN);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(zQg));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(jS));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(n(com.byazt.nf.rv.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    public static com.byazt.zve.qg s(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        final int iN = n(com.byazt.nf.rv.getContext());
        return new com.byazt.zve.qg() { // from class: com.byazt.ehw.x.1
            @Override // com.byazt.zve.qg
            public boolean qg() {
                return false;
            }

            @Override // com.byazt.zve.qg
            public String n() {
                return str;
            }

            @Override // com.byazt.zve.qg
            public long s() {
                return iN;
            }
        };
    }

    private static int n(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int n() {
        return ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).l() ? 1 : 0;
    }
}
