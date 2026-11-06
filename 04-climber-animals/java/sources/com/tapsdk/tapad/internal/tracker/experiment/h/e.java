package com.tapsdk.tapad.internal.tracker.experiment.h;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e implements c {
    public static final String A = "oaid";
    public static final String B = "call_start_time";
    public static final String C = "call_end_time";
    public static final String D = "init_time";
    public static final String n = "sdk_network_segment";
    public static final String o = "category";
    public static final String p = "url";
    public static final String q = "host";
    public static final String r = "method";
    public static final String s = "request_id";
    public static final String t = "space_id";
    public static final String u = "exception";
    public static final String v = "exception_stack";
    public static final String w = "network_segment_state_flags";
    public static final String x = "is_sdk_debug";
    public static final String y = "sample_ratio";
    public static final String z = "http_result";
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private long e = Long.MAX_VALUE;
    private String f = null;
    private String g = null;
    private int h = Integer.MAX_VALUE;
    private String i = null;
    private String j = null;
    private long k = Long.MAX_VALUE;
    private long l = Long.MAX_VALUE;
    private long m = Long.MAX_VALUE;

    private void a(Map<String, String> map) {
    }

    public e a(int i) {
        this.h = i;
        return this;
    }

    public e a(long j) {
        this.l = j;
        return this;
    }

    public e a(String str) {
        this.f = str;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        map.put("category", n);
        if (com.tapsdk.tapad.internal.network.c.a.c(this.a)) {
            map.put("url", this.a);
        }
        String str = this.b;
        if (str != null && str.length() > 0) {
            map.put("host", this.b);
        }
        String str2 = this.c;
        if (str2 != null && str2.length() > 0) {
            map.put("method", this.c);
        }
        String str3 = this.d;
        if (str3 != null && str3.length() > 0) {
            map.put("request_id", this.d);
        }
        long j = this.e;
        if (2147483647L != j) {
            map.put("space_id", String.valueOf(j));
        }
        String str4 = this.f;
        if (str4 != null && str4.length() >= 2 && this.f.startsWith("{") && this.f.endsWith("}")) {
            map.put("exception", this.f);
        }
        String str5 = this.i;
        if (str5 != null && str5.length() > 0) {
            map.put(v, this.i);
        }
        String str6 = this.g;
        if (str6 == null || str6.length() != 16) {
            return new HashMap();
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.g.length()) {
                z2 = true;
                break;
            }
            char cCharAt = this.g.charAt(i);
            if (cCharAt != '0' && cCharAt != '1' && cCharAt != '2') {
                break;
            }
            i++;
        }
        if (!z2) {
            return new HashMap();
        }
        map.put(w, this.g);
        String str7 = this.g;
        if ('1' == str7.charAt(str7.length() - 1)) {
            map.put(z, "1");
        } else {
            map.put(z, "0");
        }
        map.put("is_sdk_debug", "1");
        int i2 = this.h;
        if (i2 >= 0 && i2 <= 100) {
            map.put("sample_ratio", String.valueOf(i2));
        }
        String str8 = this.j;
        if (str8 != null && str8.length() > 0) {
            map.put("oaid", this.j);
        }
        long j2 = this.k;
        if (Long.MAX_VALUE != j2 && Long.MAX_VALUE != this.l) {
            map.put(B, String.valueOf(j2));
            map.put(C, String.valueOf(this.l));
        }
        long j3 = this.m;
        if (Long.MAX_VALUE != j3) {
            map.put("init_time", String.valueOf(j3));
        }
        a(map);
        return map;
    }

    public e b(long j) {
        this.k = j;
        return this;
    }

    public e b(String str) {
        this.i = str;
        return this;
    }

    public e c(long j) {
        this.m = j;
        return this;
    }

    public e c(String str) {
        this.b = str;
        return this;
    }

    public e d(long j) {
        this.e = j;
        return this;
    }

    public e d(String str) {
        this.c = str;
        return this;
    }

    public e e(String str) {
        this.g = str;
        return this;
    }

    public e f(String str) {
        this.j = str;
        return this;
    }

    public e g(String str) {
        this.d = str;
        return this;
    }

    public e h(String str) {
        this.a = str;
        return this;
    }
}
