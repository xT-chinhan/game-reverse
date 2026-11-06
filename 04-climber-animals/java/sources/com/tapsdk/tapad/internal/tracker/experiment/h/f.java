package com.tapsdk.tapad.internal.tracker.experiment.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f implements c {
    public static final String A = "exception";
    public static final String B = "oaid";
    public static final String C = "tap_client_id";
    public static final String D = "tap_open_id";
    public static final String E = "granted_installed_list_permission";
    public static final String F = "fetched_installed_list";
    public static final String G = "media_enable_get_installed_list";
    public static final String H = "param_media_location_permission";
    public static final String I = "param_media_phone_state_permission";
    public static final String J = "param_media_android_id_permission";
    public static final String K = "param_media_shake_permission";
    public static final String L = "param_media_write_external_permission";
    public static final String t = "url";
    public static final String u = "method";
    public static final String v = "host";
    public static final String w = "request_size";
    public static final String x = "response_size";
    public static final String y = "duration";
    public static final String z = "status_code";
    private String a;
    private String b;
    private String c;
    private String h;
    private String i;
    private String j;
    private String k;
    private long d = Long.MIN_VALUE;
    private long e = Long.MIN_VALUE;
    private long f = Long.MIN_VALUE;
    private int g = Integer.MIN_VALUE;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;

    public f a(int i) {
        this.g = i;
        return this;
    }

    public f a(long j) {
        this.f = j;
        return this;
    }

    public f a(String str) {
        this.h = str;
        return this;
    }

    public f a(boolean z2) {
        this.m = z2 ? 1 : 0;
        return this;
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.h.c
    public Map<String, String> a() throws Exception {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.a)) {
            map.put("url", this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            map.put("method", this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            map.put("host", String.valueOf(this.c));
        }
        long j = this.d;
        if (j != Long.MIN_VALUE) {
            map.put(w, String.valueOf(j));
        }
        long j2 = this.e;
        if (j2 != Long.MIN_VALUE) {
            map.put(x, String.valueOf(j2));
        }
        long j3 = this.f;
        if (j3 != Long.MIN_VALUE) {
            map.put("duration", String.valueOf(j3));
        }
        int i = this.g;
        if (i != Integer.MIN_VALUE) {
            map.put(z, String.valueOf(i));
        }
        if (!TextUtils.isEmpty(this.h)) {
            String str = this.h;
            map.put("exception", str.substring(0, Math.min(1000, str.length())));
        }
        if (!TextUtils.isEmpty(this.i)) {
            map.put("oaid", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            map.put(C, this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            map.put(D, this.k);
        }
        map.put(E, this.l + "");
        map.put(F, this.m + "");
        map.put(G, this.n + "");
        map.put(H, this.o + "");
        map.put(I, this.p + "");
        map.put(L, this.q + "");
        map.put(J, this.r + "");
        map.put(K, this.s + "");
        return map;
    }

    public f b(long j) {
        this.d = j;
        return this;
    }

    public f b(String str) {
        this.c = str;
        return this;
    }

    public f b(boolean z2) {
        this.l = z2 ? 1 : 0;
        return this;
    }

    public f c(long j) {
        this.e = j;
        return this;
    }

    public f c(String str) {
        this.b = str;
        return this;
    }

    public f c(boolean z2) {
        this.r = z2 ? 1 : 0;
        return this;
    }

    public f d(String str) {
        this.i = str;
        return this;
    }

    public f d(boolean z2) {
        this.n = z2 ? 1 : 0;
        return this;
    }

    public f e(String str) {
        this.j = str;
        return this;
    }

    public f e(boolean z2) {
        this.o = z2 ? 1 : 0;
        return this;
    }

    public f f(String str) {
        this.k = str;
        return this;
    }

    public f f(boolean z2) {
        this.p = z2 ? 1 : 0;
        return this;
    }

    public f g(String str) {
        this.a = str;
        return this;
    }

    public f g(boolean z2) {
        this.s = z2 ? 1 : 0;
        return this;
    }

    public f h(boolean z2) {
        this.q = z2 ? 1 : 0;
        return this;
    }
}
