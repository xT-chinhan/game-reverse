package com.tapsdk.tapad.internal.tracker.experiment.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c {
    public static final String l = "sdk_download";
    public static final String m = "category";
    public static final String n = "media_id";
    public static final String o = "space_id";
    public static final String p = "code";
    public static final String q = "msg";
    public static final String r = "request_id";
    public static final String s = "request_uuid";
    public static final String t = "track_id";
    public static final String u = "from_method";
    public static final String v = "download_urls";
    public static final String w = "is_sdk_debug";
    public static final String x = "sample_ratio";
    private String b;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int a = Integer.MAX_VALUE;
    private long c = Long.MAX_VALUE;
    private long d = Long.MAX_VALUE;
    private int k = Integer.MAX_VALUE;

    public b a(int i) {
        this.a = i;
        return this;
    }

    public b a(long j) {
        this.c = j;
        return this;
    }

    public b a(String str) {
        this.i = str;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        map.put("category", l);
        long j = this.c;
        if (Long.MAX_VALUE != j) {
            map.put(n, String.valueOf(j));
        }
        long j2 = this.d;
        if (Long.MAX_VALUE != j2) {
            map.put("space_id", String.valueOf(j2));
        }
        int i = this.a;
        if (Integer.MAX_VALUE != i) {
            map.put("code", String.valueOf(i));
        }
        if (!TextUtils.isEmpty(this.b)) {
            map.put("msg", this.b);
        }
        if (!TextUtils.isEmpty(this.e)) {
            map.put("request_id", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            map.put("request_uuid", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            map.put("track_id", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            map.put(u, this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            map.put(v, this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            map.put("is_sdk_debug", this.j);
        }
        int i2 = this.k;
        if (i2 >= 0 && i2 <= 100) {
            map.put("sample_ratio", String.valueOf(i2));
        }
        return map;
    }

    public b b(int i) {
        this.k = i;
        return this;
    }

    public b b(long j) {
        this.d = j;
        return this;
    }

    public b b(String str) {
        this.h = str;
        return this;
    }

    public b c(String str) {
        this.j = str;
        return this;
    }

    public b d(String str) {
        this.b = str;
        return this;
    }

    public b e(String str) {
        this.e = str;
        return this;
    }

    public b f(String str) {
        this.f = str;
        return this;
    }

    public b g(String str) {
        this.g = str;
        return this;
    }
}
