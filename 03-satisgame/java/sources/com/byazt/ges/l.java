package com.byazt.ges;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.vgx.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1374, 18})
public class l {
    public static final String n = null;
    public static long qg = -1;

    public static JSONArray n(final Context context) {
        if (System.currentTimeMillis() - qg <= 1000) {
            return null;
        }
        qg = System.currentTimeMillis();
        if (!com.byazt.ivn.q.q() || !qg() || !rv.qg().hy() || !com.byazt.vyf.s.cy().hd().s()) {
            return null;
        }
        com.byazt.qit.l.n(new x("getIncrementalInstallApps") { // from class: com.byazt.ges.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.s(context);
            }
        }, 1);
        return n();
    }

    private static JSONArray n() {
        try {
            String strQg = com.byazt.ikv.n.n().qg("install_app_incremental_string", n);
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            return new JSONArray((Collection) q(strQg));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Context context) {
        try {
            List<String> listN = s.n().n(context);
            if (listN != null && !listN.isEmpty()) {
                List<String> listQ = q(com.byazt.ikv.n.n().qg("install_app_string", n));
                qg(n(listN));
                if (listQ != null && !listQ.isEmpty()) {
                    listN.removeAll(listQ);
                }
                s(n(listN));
            }
        } catch (Exception unused) {
        }
    }

    private static void qg(String str) {
        com.byazt.ikv.n.n().n("install_app_string", str);
    }

    private static void s(String str) {
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        sVarN.n("install_app_incremental_string", str);
        sVarN.n("apptime", System.currentTimeMillis());
    }

    private static boolean qg() {
        long jQg = com.byazt.ikv.n.n().qg("apptime", -1L);
        return jQg == -1 || System.currentTimeMillis() - jQg > 43200000;
    }

    private static List<String> q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String n(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            n(0, 0, null);
            return false;
        }
        if (w.h() && !w.qg(str)) {
            n(0, 0, null);
        }
        return false;
    }

    private static void n(final int i, final int i2, final String str) {
        com.byazt.eji.s.n().n("call_active_api", new com.byazt.rs.n() { // from class: com.byazt.ges.l.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("call_api_status", i);
                    jSONObject2.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }
}
