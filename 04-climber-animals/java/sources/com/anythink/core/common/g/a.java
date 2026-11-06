package com.anythink.core.common.g;

import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    protected static final String a = "cn-api.anythinktech.com";
    public static final String b = "https:///v2/open/ns";
    public static final String c = "https://cn-api.anythinktech.com/v2/open/app";
    public static final String d = "https://cn-api.anythinktech.com/v2/open/placement";
    public static final String e = "https://ssapi.anythinktech.com/sdk/realtime_waterfall";
    public static final String f = "https://cn-api.anythinktech.com/v2/open/pl_wf";
    public static final String g = "https://cn-da.anythinktech.com/v1/open/da";
    public static final String h = "https://cn-tk.anythinktech.com/v1/open/tk";
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n = "";
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s = "https:///gdpr/PrivacyPolicySetting.html";

    public static String a() {
        return "cn-api.anythinktech.com";
    }

    private static String b() {
        return j.g.a.b;
    }

    private static String c() {
        return j.g.a.c;
    }

    private static String d() {
        return j.g.a.d;
    }

    private static String f() {
        return j.g.a.e;
    }

    static {
        String strD;
        StringBuilder sb = new StringBuilder("https://");
        if (ATSDK.isCnSDK()) {
            strD = "cn-api.anythinktech.com";
        } else {
            c.a();
            strD = c.d();
        }
        i = sb.append(strD).append("/v2/open/eu").toString();
        j = "https://adx.anythinktech.com/bid";
        k = "https://adx.anythinktech.com/request";
        l = "https://adxcn-tk.anythinktech.com/v1";
        m = "https://adx.anythinktech.com/openapi/req";
        o = "https://cn-tk.anythinktech.com/ss/rrd";
        p = "https://cn-api.anythinktech.com/v2/open/area";
        q = "https://cn-api.anythinktech.com/v2/open/m_adapter";
        r = "https://cn-api.anythinktech.com/v2/open/dna";
    }

    private static String e() {
        if (ATSDK.isCnSDK()) {
            return "cn-api.anythinktech.com";
        }
        c.a();
        return c.d();
    }
}
