package com.anythink.core.common.g;

import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    protected static final String a = "cn-api.anythinktech.com";
    protected static final String b = "cn-api-sec.anythinktech.com";
    public static final String c = "https://se.anythinktech.com/v2/open/ns";
    public static final String d = "https://se.anythinktech.com/v2/open/api_hb";
    public static final String e = "https://cn-api.anythinktech.com/v2/open/app";
    public static final String f = "https://cn-api-sec.anythinktech.com/v2/open/app";
    public static final String g = "https://cn-api.anythinktech.com/v2/open/placement";
    public static final String h = "https://cn-api-sec.anythinktech.com/v2/open/placement";
    public static final String i = "https://ssapi.anythinktech.com/sdk/realtime_waterfall";
    public static final String j = "https://cn-api.anythinktech.com/v2/open/pl_wf";
    public static final String k = "https://cn-da.anythinktech.com/v1/open/da";
    public static final String l = "https://cn-tk.anythinktech.com/v2/open/anr";
    public static final String m = "https://cn-tk.anythinktech.com/v1/open/tk";
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s = "";
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x = "https:///gdpr/PrivacyPolicySetting.html";

    public static String a() {
        return "cn-api.anythinktech.com";
    }

    public static String b() {
        return i.g.a.c;
    }

    private static String c() {
        return "cn-api-sec.anythinktech.com";
    }

    private static String d() {
        return i.g.a.d;
    }

    private static String e() {
        return i.g.a.e;
    }

    private static String g() {
        return i.g.a.f;
    }

    static {
        String strE;
        StringBuilder sb = new StringBuilder("https://");
        if (ATSDK.isCnSDK()) {
            strE = "cn-api.anythinktech.com";
        } else {
            c.a();
            strE = c.e();
        }
        n = sb.append(strE).append("/v2/open/eu").toString();
        o = "https://adx.anythinktech.com/bid";
        p = "https://adx.anythinktech.com/request";
        q = "https://adxcn-tk.anythinktech.com/v1";
        r = "https://adx.anythinktech.com/openapi/req";
        t = "https://cn-tk.anythinktech.com/ss/rrd";
        u = "https://cn-api.anythinktech.com/v2/open/area";
        v = "https://cn-api.anythinktech.com/v2/open/m_adapter";
        w = "https://cn-api.anythinktech.com/v2/open/dna";
    }

    private static String f() {
        if (ATSDK.isCnSDK()) {
            return "cn-api.anythinktech.com";
        }
        c.a();
        return c.e();
    }
}
