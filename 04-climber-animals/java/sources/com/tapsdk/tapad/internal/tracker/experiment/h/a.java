package com.tapsdk.tapad.internal.tracker.experiment.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a implements c {
    public static final String i = "sdk_ads_filling";
    public static final String j = "category";
    public static final String k = "space_id";
    public static final String l = "ad_scene";
    public static final String m = "request_id";
    public static final String n = "request_uuid";
    public static final String o = "msg";
    public static final String p = "code";
    public static final String q = "is_sdk_debug";
    public static final String r = "sample_ratio";
    private String b;
    private String c;
    private String d;
    private String e;
    private String g;
    private long a = Long.MAX_VALUE;
    private int f = Integer.MAX_VALUE;
    private int h = Integer.MAX_VALUE;

    public a a(int i2) {
        this.h = i2;
        return this;
    }

    public a a(long j2) {
        this.a = j2;
        return this;
    }

    public a a(Integer num) {
        this.f = num.intValue();
        return this;
    }

    public a a(String str) {
        this.b = str;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        map.put("category", i);
        long j2 = this.a;
        if (2147483647L != j2) {
            map.put("space_id", String.valueOf(j2));
        }
        String str = this.b;
        if (str != null && str.length() > 0) {
            map.put(l, this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            map.put("request_id", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            map.put("request_uuid", this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            map.put("msg", this.e);
        }
        int i2 = this.f;
        if (Integer.MAX_VALUE != i2) {
            map.put("code", String.valueOf(i2));
        }
        if (!TextUtils.isEmpty(this.g)) {
            map.put("is_sdk_debug", this.g);
        }
        int i3 = this.h;
        if (i3 >= 0 && i3 <= 100) {
            map.put("sample_ratio", String.valueOf(i3));
        }
        return map;
    }

    public a b(String str) {
        this.g = str;
        return this;
    }

    public a c(String str) {
        this.e = str;
        return this;
    }

    public a d(String str) {
        this.c = str;
        return this;
    }

    public a e(String str) {
        this.d = str;
        return this;
    }
}
