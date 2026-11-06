package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final String A = "it_src";
    public static final String a = "platform";
    public static final String b = "os_vn";
    public static final String c = "os_vc";
    public static final String d = "package_name";
    public static final String e = "app_vn";
    public static final String f = "app_vc";
    public static final String g = "brand";
    public static final String h = "model";
    public static final String i = "screen";
    public static final String j = "network_type";
    public static final String k = "mnc";
    public static final String l = "mcc";
    public static final String m = "language";
    public static final String n = "timezone";
    public static final String o = "sdk_ver";
    public static final String p = "gp_ver";
    public static final String q = "nw_ver";
    public static final String r = "ua";
    public static final String s = "orient";
    public static final String t = "system";
    public static final String u = "android_id";
    public static final String v = "gaid";
    public static final String w = "channel";
    public static final String x = "sub_channel";
    public static final String y = "upid";
    public static final String z = "ps_id";

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        Context contextG = com.anythink.core.common.d.s.b().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", l.e());
            jSONObject.put("os_vc", l.d());
            jSONObject.put("package_name", l.j(contextG));
            jSONObject.put("app_vn", l.h(contextG));
            jSONObject.put("app_vc", l.g(contextG));
            jSONObject.put("brand", l.b());
            jSONObject.put("model", l.a());
            jSONObject.put("screen", l.i(contextG));
            jSONObject.put("network_type", String.valueOf(l.l(contextG)));
            jSONObject.put("mnc", l.c(contextG));
            jSONObject.put("mcc", l.b(contextG));
            jSONObject.put("language", l.e(contextG));
            jSONObject.put("timezone", l.c());
            jSONObject.put("sdk_ver", o.a());
            jSONObject.put("gp_ver", l.g());
            jSONObject.put("ua", l.i());
            jSONObject.put("orient", l.f(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().n())) {
                jSONObject.put("channel", com.anythink.core.common.d.s.b().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.d.s.b().o());
            }
            jSONObject.put("upid", com.anythink.core.common.d.s.b().C());
            jSONObject.put("ps_id", com.anythink.core.common.d.s.b().r());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject c() {
        String strI;
        Context contextG = com.anythink.core.common.d.s.b().g();
        JSONObject jSONObject = new JSONObject();
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(contextG).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null) {
            try {
                strI = bVarB.I();
            } catch (Exception unused) {
            }
        } else {
            strI = "";
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(strI)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strI);
                if (!jSONObject2.isNull("a") && jSONObject2.optInt("a") != 1) {
                    z2 = false;
                }
            } catch (Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? l.d(contextG) : "");
        jSONObject.put("gaid", l.f());
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        if (rVarC != null) {
            rVarC.fillRequestData(jSONObject, bVarB);
        }
        if (ATSDK.isCnSDK()) {
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String strK = l.k(contextG);
        jSONObject.put("it_src", TextUtils.isEmpty(strK) ? "" : strK);
        return jSONObject;
    }

    public static JSONObject a() {
        JSONObject jSONObjectB = b();
        JSONObject jSONObjectC = c();
        try {
            jSONObjectB.put("app_id", com.anythink.core.common.d.s.b().p());
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectB.put(next, jSONObjectC.opt(next));
            }
        } catch (JSONException unused) {
        }
        return jSONObjectB;
    }
}
