package com.anythink.core.e;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private int a = 1;
    private int b = 0;
    private int c = 3;
    private int d = 1;
    private double e = 2.0d;
    private int f = 3;
    private int[] g;
    private String h;

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final double e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    protected static g a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            g gVar = new g();
            gVar.a = jSONObject.optInt("limit_sw", 1);
            gVar.b = jSONObject.optInt("latest_day", 0);
            gVar.c = jSONObject.optInt("max_n", 3);
            gVar.d = jSONObject.optInt("min_m", 1);
            gVar.e = jSONObject.optDouble("premium_rate", 2.0d);
            gVar.f = jSONObject.optInt("premium_level", 3);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("not_filter_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                gVar.h = jSONArrayOptJSONArray.toString();
                gVar.g = new int[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    gVar.g[i] = jSONArrayOptJSONArray.optInt(i);
                }
            }
            return gVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final int[] g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String toString() {
        return "DynamicWaterfallStrategy{limitSegmentSwitch=" + this.a + ", latestDay=" + this.b + ", maxCollectCount=" + this.c + ", minCollectCount=" + this.d + ", premiumRate=" + this.e + ", premiumLevel=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
