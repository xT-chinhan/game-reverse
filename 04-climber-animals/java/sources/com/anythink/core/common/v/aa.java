package com.anythink.core.common.v;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aa {
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
        Context contextG = com.anythink.core.common.d.t.b().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", m.e());
            jSONObject.put("os_vc", m.d());
            jSONObject.put("package_name", m.m(contextG));
            jSONObject.put("app_vn", m.i(contextG));
            jSONObject.put("app_vc", m.h(contextG));
            jSONObject.put("brand", m.b());
            jSONObject.put("model", m.a());
            jSONObject.put("screen", m.l(contextG));
            jSONObject.put("network_type", String.valueOf(m.o(contextG)));
            jSONObject.put("mnc", m.c(contextG));
            jSONObject.put("mcc", m.b(contextG));
            jSONObject.put("language", m.e(contextG));
            jSONObject.put("timezone", m.c());
            jSONObject.put("sdk_ver", p.a());
            jSONObject.put("gp_ver", m.g());
            jSONObject.put("ua", m.i());
            jSONObject.put("orient", m.f(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.d.t.b().n())) {
                jSONObject.put("channel", com.anythink.core.common.d.t.b().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.d.t.b().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.d.t.b().o());
            }
            jSONObject.put("upid", com.anythink.core.common.d.t.b().B());
            jSONObject.put("ps_id", com.anythink.core.common.d.t.b().r());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject c() {
        String strQ;
        Context contextG = com.anythink.core.common.d.t.b().g();
        JSONObject jSONObject = new JSONObject();
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(contextG).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null) {
            try {
                strQ = bVarB.Q();
            } catch (Exception unused) {
            }
        } else {
            strQ = "";
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(strQ)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strQ);
                if (!jSONObject2.isNull("a") && jSONObject2.optInt("a") != 1) {
                    z2 = false;
                }
            } catch (Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? m.d(contextG) : "");
        jSONObject.put("gaid", m.f());
        com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
        if (sVarC != null) {
            sVarC.fillRequestData(jSONObject, bVarB);
        }
        if (ATSDK.isCnSDK()) {
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String strN = m.n(contextG);
        jSONObject.put("it_src", TextUtils.isEmpty(strN) ? "" : strN);
        return jSONObject;
    }

    public static JSONObject a() {
        JSONObject jSONObjectB = b();
        JSONObject jSONObjectC = c();
        try {
            jSONObjectB.put("app_id", com.anythink.core.common.d.t.b().p());
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
