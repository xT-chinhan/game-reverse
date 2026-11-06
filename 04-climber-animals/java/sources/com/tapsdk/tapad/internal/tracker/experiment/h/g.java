package com.tapsdk.tapad.internal.tracker.experiment.h;

import com.tapsdk.tapad.e.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g implements c {
    public static final String h = "internal_web_view_exception";
    private static final String i = "is_sdk_debug";
    private static final String j = "category";
    private static final String k = "method_signature";
    private static final String l = "type";
    private static final String m = "code";
    private static final String n = "url";
    private static final String o = "description";
    public static final String p = "track_id";
    private static final String q = "oaid";
    public static final String r = "sample_ratio";
    private String a = "";
    private int b = Integer.MIN_VALUE;
    private String c = "";
    private String d = "";
    private String e = "";
    private int f = Integer.MAX_VALUE;
    private String g;

    public g a(int i2) {
        this.b = i2;
        return this;
    }

    public g a(String str) {
        this.d = str;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        map.put("category", "internal_web_view_exception");
        map.put("type", "error");
        String str = this.a;
        if (str != null && str.length() != 0) {
            map.put(k, this.a);
        }
        if (this.b != Integer.MIN_VALUE) {
            map.put("code", "" + this.b);
        }
        String str2 = this.c;
        if (str2 != null && str2.length() != 0) {
            map.put("url", this.c);
        }
        String str3 = this.d;
        if (str3 != null && str3.length() > 0) {
            map.put("description", this.d);
        }
        String str4 = this.e;
        if (str4 != null && str4.length() > 0) {
            map.put("track_id", this.e);
        }
        String str5 = this.g;
        if (str5 != null && str5.length() > 0) {
            map.put("is_sdk_debug", "1");
        }
        int i2 = this.f;
        if (i2 >= 0 && i2 <= 100) {
            map.put("sample_ratio", String.valueOf(i2));
        }
        String strA = h.b().a();
        if (strA != null && strA.length() > 0) {
            map.put("oaid", strA);
        }
        return map;
    }

    public g b(int i2) {
        this.f = i2;
        return this;
    }

    public g b(String str) {
        this.g = str;
        return this;
    }

    public g c(String str) {
        this.a = str;
        return this;
    }

    public g d(String str) {
        this.e = str;
        return this;
    }

    public g e(String str) {
        this.c = str;
        return this;
    }
}
