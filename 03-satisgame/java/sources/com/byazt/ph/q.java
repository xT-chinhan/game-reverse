package com.byazt.ph;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 513, 5})
public class q {
    public static int n() {
        JSONObject jSONObjectQi = rv.qg().qi();
        if (jSONObjectQi == null) {
            return 0;
        }
        return jSONObjectQi.optInt("live_max_count", 0);
    }

    public static int qg() {
        JSONObject jSONObjectQi = rv.qg().qi();
        if (jSONObjectQi != null && tj.l >= 7200) {
            return jSONObjectQi.optInt("live_init_max_count", 0);
        }
        return 0;
    }

    public static boolean s() {
        return n() > 0;
    }

    public static boolean q() {
        return qg() > 0;
    }

    public static int l() {
        JSONObject jSONObjectQi = rv.qg().qi();
        if (jSONObjectQi == null) {
            return 0;
        }
        return jSONObjectQi.optInt("pangle_max_count", 0);
    }

    public static boolean w() {
        return l() > 0;
    }

    public static boolean n(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return w();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return s();
        }
        return false;
    }

    public static int qg(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return l();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return n();
        }
        return 0;
    }

    public static JSONObject x() {
        return rv.qg().ml();
    }

    public static boolean fs() {
        return x() != null && x().optBoolean("enable", false);
    }

    public static JSONObject rv() {
        return rv.qg().zb();
    }

    public static boolean tj() {
        JSONObject jSONObjectRv = rv();
        return jSONObjectRv != null && jSONObjectRv.optBoolean("miniapp", false);
    }

    public static boolean cp() {
        JSONObject jSONObjectRv = rv();
        return jSONObjectRv != null && jSONObjectRv.optBoolean("open_scheme", false);
    }

    public static JSONObject d() {
        return rv.qg().fx();
    }

    public static boolean oa() {
        return d() != null && d().optBoolean("enable", false);
    }

    public static String sz() {
        JSONObject jSONObjectD = d();
        return jSONObjectD != null ? jSONObjectD.optString(ImagesContract.URL, "api-access.pangolin-sdk-toutiao.com") : "api-access.pangolin-sdk-toutiao.com";
    }

    public static JSONObject k() {
        return rv.qg().mk();
    }

    public static boolean cy() {
        return k() != null && k().optBoolean("enable", false);
    }
}
