package com.anythink.core.common.b;

import com.anythink.core.common.d.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final int A = 150;
    public static final long B = 60;
    public static final int C = 1;
    public static final int D = 1;
    public static final int E = 5;
    public static final int F = 3;
    public static final int a = 1;
    public static final int b = 4;
    public static final int c = 1;
    public static final int d = 4;
    public static final int e = 2;
    public static final int f = 4;
    public static final int g = 100;
    public static final long h = 60;
    public static final int i = 4;
    public static final int j = 2;
    public static final int k = 4;
    public static final int l = 100;
    public static final long m = 60;
    public static final int n = 4;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 1;
    public static final int r = 4;
    public static final int s = 2;
    public static final int t = 15;
    public static final int u = 3;
    public static final int v = 6;
    public static final int w = 150;
    public static final long x = 60;
    public static final int y = 3;
    public static final int z = 6;
    private g G;
    private g H;
    private g I;
    private g J;
    private g K;
    private g L;

    public final g a() {
        return this.G;
    }

    private void a(g gVar) {
        this.G = gVar;
    }

    public final g b() {
        return this.H;
    }

    private void b(g gVar) {
        this.H = gVar;
    }

    public final g c() {
        return this.I;
    }

    private void c(g gVar) {
        this.I = gVar;
    }

    public final g d() {
        return this.J;
    }

    private void d(g gVar) {
        this.J = gVar;
    }

    public final g e() {
        return this.K;
    }

    private void e(g gVar) {
        this.K = gVar;
    }

    public final g f() {
        return this.L;
    }

    private void f(g gVar) {
        this.L = gVar;
    }

    public static h a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.G = g.a(jSONObject.optJSONObject("core"));
        hVar.H = g.a(jSONObject.optJSONObject("mediation"));
        hVar.I = g.a(jSONObject.optJSONObject("network"));
        hVar.J = g.a(jSONObject.optJSONObject("io"));
        hVar.K = g.a(jSONObject.optJSONObject("tracking"));
        hVar.L = g.a(jSONObject.optJSONObject("scheduler"));
        return hVar;
    }

    public static h g() {
        h hVar = new h();
        s.b();
        hVar.G = g.a(2, 0, 0, 0, 5);
        hVar.H = g.a(15, 0, 0, 0, 5);
        hVar.I = g.a(3, 6, 150, 60, 5);
        hVar.J = g.a(3, 6, 150, 60, 5);
        hVar.K = g.a(1, 0, 0, 0, 3);
        hVar.L = g.a(1, 0, 0, 0, 5);
        return hVar;
    }
}
