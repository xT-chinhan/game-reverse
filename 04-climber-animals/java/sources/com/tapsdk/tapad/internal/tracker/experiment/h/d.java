package com.tapsdk.tapad.internal.tracker.experiment.h;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d implements c {
    public static final String g = "sdk_installer";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final String m = "category";
    public static final String n = "track_id";
    public static final String o = "space_id";
    public static final String p = "code";
    public static final String q = "msg";
    public static final String r = "is_sdk_debug";
    public static final String s = "sample_ratio";
    private String c;
    private String d;
    private String f;
    private long a = Long.MAX_VALUE;
    private int b = Integer.MAX_VALUE;
    private int e = Integer.MAX_VALUE;

    public d a(int i2) {
        this.b = i2;
        return this;
    }

    public d a(Long l2) {
        this.a = l2.longValue();
        return this;
    }

    public d a(String str) {
        this.d = str;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        map.put("category", g);
        long j2 = this.a;
        if (2147483647L != j2) {
            map.put("space_id", String.valueOf(j2));
        }
        String str = this.f;
        if (str != null && str.length() > 0) {
            map.put("track_id", this.f);
        }
        int i2 = this.b;
        if (Integer.MAX_VALUE != i2) {
            map.put("code", String.valueOf(i2));
        }
        String str2 = this.c;
        if (str2 != null && str2.length() > 0) {
            map.put("msg", this.c);
        }
        String str3 = this.d;
        if (str3 != null && str3.length() > 0) {
            map.put("is_sdk_debug", this.d);
        }
        String str4 = this.f;
        if (str4 != null && str4.length() > 0) {
            map.put("track_id", this.f);
        }
        int i3 = this.e;
        if (i3 >= 0 && i3 <= 100) {
            map.put("sample_ratio", String.valueOf(i3));
        }
        return map;
    }

    public d b(int i2) {
        this.e = i2;
        return this;
    }

    public d b(String str) {
        this.c = str;
        return this;
    }

    public d c(String str) {
        this.f = str;
        return this;
    }
}
