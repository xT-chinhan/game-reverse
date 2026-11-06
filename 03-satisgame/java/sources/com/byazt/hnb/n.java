package com.byazt.hnb;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.l;
import com.byazt.tk.w;
import com.byazt.vf.oa;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1322, 19})
public class n {
    public static String n;

    public static void n(JSONObject jSONObject) {
        if (tj.rv.equals("privacy")) {
            return;
        }
        try {
            com.byazt.hsi.n nVarQ = ((oa) com.byazt.qp.q.n("device_info_new")).q(!com.byazt.ehw.n.qg());
            float fQg = 0.0f;
            float fN = nVarQ == null ? 0.0f : nVarQ.n();
            if (nVarQ != null) {
                fQg = nVarQ.qg();
            }
            jSONObject.put("latitude", fN);
            jSONObject.put("longitude", fQg);
        } catch (JSONException unused) {
        }
    }

    public static void n(com.byazt.zq.q qVar, List<String> list) {
        if (tj.rv.equals("privacy") || !qVar.n()) {
            return;
        }
        list.add("android.permission.ACCESS_COARSE_LOCATION");
        list.add("android.permission.ACCESS_FINE_LOCATION");
    }

    public static void qg(JSONObject jSONObject) {
        com.byazt.hsi.n nVarQ;
        if (tj.rv.equals("privacy") || (nVarQ = ((oa) com.byazt.qp.q.n("device_info_new")).q(!com.byazt.ehw.n.qg())) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("latitude", nVarQ.n());
            jSONObject2.put("longitude", nVarQ.qg());
            jSONObject.put("geo", jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void s(JSONObject jSONObject) {
        try {
            if (tj.rv.equals("privacy")) {
                jSONObject.put("imei_md5", n());
            } else {
                jSONObject.put("imei", DeviceUtils.n((Boolean) null));
            }
        } catch (JSONException unused) {
        }
    }

    public static String n() {
        if (TextUtils.isEmpty(n)) {
            String strN = DeviceUtils.n((Boolean) null);
            if (!TextUtils.isEmpty(strN)) {
                n = l.qg(strN);
            }
        }
        return n;
    }

    public static void n(Context context, JSONObject jSONObject) {
        if (tj.rv.equals("privacy")) {
            return;
        }
        try {
            JSONArray jSONArrayN = com.byazt.ges.l.n(context);
            if (jSONArrayN != null) {
                jSONObject.put("app_list", jSONArrayN);
            }
        } catch (JSONException unused) {
        }
    }

    public static void qg() {
        if (tj.rv.equals("privacy")) {
            return;
        }
        ((oa) com.byazt.qp.q.n("device_info_new")).q(!com.byazt.ehw.n.qg());
    }

    public static void n(String str) {
        if (tj.rv.equals("privacy")) {
            return;
        }
        com.byazt.ges.s.n().n(str);
    }

    public static boolean qg(String str) {
        if (tj.rv.equals("privacy")) {
            return false;
        }
        return com.byazt.ges.l.n(str);
    }

    public static void n(Context context) {
        if (tj.rv.equals("privacy") || (rv.qg().pz() & 8) != 0) {
            return;
        }
        com.byazt.qfb.n.n(context);
    }

    public static File qg(Context context) {
        if (tj.rv.equals("privacy")) {
            return w.n(context, "Download/Pangolin", false, null);
        }
        return w.n(context, Environment.DIRECTORY_DOWNLOADS, false, null);
    }
}
