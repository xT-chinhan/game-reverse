package com.anythink.core.e;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private List<Integer> b;
    private int a = 0;
    private int c = 1500;
    private int d = 1;
    private float e = 1.0f;
    private int f = 1;

    private int f() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    public final List<Integer> a() {
        return this.b;
    }

    private void a(List<Integer> list) {
        this.b = list;
    }

    public final int b() {
        return this.c;
    }

    private void b(int i) {
        this.c = i;
    }

    public final int c() {
        return this.d;
    }

    private void c(int i) {
        this.d = i;
    }

    public final float d() {
        return this.e;
    }

    private void a(float f) {
        this.e = f;
    }

    public final int e() {
        return this.f;
    }

    private void d(int i) {
        this.f = i;
    }

    public static f a(JSONObject jSONObject) {
        try {
            f fVar = new f();
            fVar.a = jSONObject.optInt("dfp_exec_mode", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("nw_firm_id");
            fVar.b = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    fVar.b.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            fVar.c = jSONObject.optInt("bid_wait_window", 1500);
            fVar.d = jSONObject.optInt("bid_wait_min_count", 1);
            float fOptDouble = (float) jSONObject.optDouble("dfp_rate", 1.0d);
            if (fOptDouble <= 0.0f) {
                fOptDouble = 1.0f;
            }
            fVar.e = fOptDouble;
            fVar.f = jSONObject.optInt("dfp_fail_fallback", 1);
            if (fVar.a != 1 || fVar.b.isEmpty()) {
                return null;
            }
            return fVar;
        } catch (Throwable unused) {
        }
    }
}
