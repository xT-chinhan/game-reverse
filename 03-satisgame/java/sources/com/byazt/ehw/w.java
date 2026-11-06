package com.byazt.ehw;

import android.text.TextUtils;
import com.anythink.core.common.g.c;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.bytedance.JProtect;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 13})
public class w {
    public static volatile String n;
    public static volatile long qg;

    public static String n() {
        return ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[0];
    }

    public static String qg() {
        return ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[1];
    }

    public static String s() {
        Map<String, String> mapL = ((oa) com.byazt.qp.q.n("device_info_new")).l(false);
        String str = mapL != null ? mapL.get("zaid_ipv6") : null;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static JSONArray n(com.byazt.vf.n nVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> mapL = ((oa) com.byazt.qp.q.n("device_info_new")).l(false);
            if (mapL == null) {
                return jSONArray;
            }
            String str = mapL.get("register_ipv6");
            return !TextUtils.isEmpty(str) ? new JSONArray(str) : jSONArray;
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    public static String[] n(boolean z, com.byazt.vf.n nVar) {
        String[] strArr = {"", ""};
        try {
            Map<String, String> mapL = ((oa) com.byazt.qp.q.n("device_info_new")).l(z);
            if (mapL != null) {
                strArr[0] = mapL.get("enc_ipv4");
                strArr[1] = mapL.get("enc_ipv6");
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ed.s.n().s("dev14", ((k) com.byazt.qp.q.n("encrypt_service")).s(str));
        n = str;
        qg = System.currentTimeMillis();
    }

    @JProtect
    public static String qg(String str) {
        if (!TextUtils.isEmpty(n) && !DeviceUtils.n(qg, c.a)) {
            return n;
        }
        String strS = com.byazt.ed.s.n().s("dev14", c.a);
        if (TextUtils.isEmpty(strS)) {
            if (str == null) {
                str = n();
            }
            n = str;
        } else {
            n = ((k) com.byazt.qp.q.n("encrypt_service")).q(strS);
        }
        qg = System.currentTimeMillis();
        return n;
    }

    public static String[] qg(com.byazt.vf.n nVar) {
        String[] strArr = {"", ""};
        Map<String, String> mapL = ((oa) com.byazt.qp.q.n("device_info_new")).l(false);
        if (mapL != null) {
            strArr[0] = mapL.get("local_ipv4");
            strArr[1] = mapL.get("local_ipv6");
        }
        return strArr;
    }
}
