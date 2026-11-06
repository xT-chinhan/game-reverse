package com.anythink.core.common.b;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private int a;
    private long b;
    private int c;
    private int[] d;
    private long e;
    private int f;
    private int g;
    private int h;
    private String i;

    public final int a() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    public final long b() {
        return this.b;
    }

    private void a(long j) {
        this.b = j;
    }

    public final int c() {
        return this.c;
    }

    private void b(int i) {
        this.c = i;
    }

    public final int[] d() {
        return this.d;
    }

    private void a(int[] iArr) {
        this.d = iArr;
    }

    public final long e() {
        return this.e;
    }

    private void b(long j) {
        this.e = j;
    }

    public final boolean f() {
        return this.f == 1;
    }

    private void c(int i) {
        this.f = i;
    }

    public final int g() {
        return this.g;
    }

    private void d(int i) {
        this.g = i;
    }

    public final int h() {
        return this.h;
    }

    private void e(int i) {
        this.h = i;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.i = jSONObject.toString();
        cVar.a = jSONObject.optInt("parallel_req_num", 0);
        cVar.b = jSONObject.optLong("banner_refresh_t", 0L);
        cVar.c = jSONObject.optInt("auto_req_sw", 2);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("firm_priority");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int[] iArr = new int[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                iArr[i] = jSONArrayOptJSONArray.optInt(i);
            }
            cVar.d = iArr;
        }
        cVar.e = jSONObject.optLong("bid_interval", 200L);
        cVar.f = jSONObject.optInt("req_wf_after_bid", 2);
        cVar.g = jSONObject.optInt("req_mode", 0);
        cVar.h = jSONObject.optInt("bid_fail_retry", 2);
        return cVar;
    }

    public final String i() {
        String str = this.i;
        return str != null ? str : "";
    }

    public final String toString() {
        return i();
    }
}
