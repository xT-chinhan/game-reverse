package com.anythink.core.common.h;

import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class cg {
    int a;
    private n b;
    private by c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private double i;
    private double j;
    private double k;
    private double l;
    private int m;
    private Double n = null;
    private String o = null;
    private Double p;
    private Double q;
    private int r;
    private boolean s;
    private double t;

    public final void a(Double d, String str) {
        this.n = d;
        this.o = str;
    }

    public final Double a() {
        return this.n;
    }

    public final String b() {
        return this.o;
    }

    public final void a(n nVar) {
        this.b = nVar;
    }

    public final Double c() {
        return this.p;
    }

    public final void a(Double d) {
        this.p = d;
    }

    public final void a(by byVar) {
        this.h = "0";
        if (byVar == null) {
            return;
        }
        this.c = byVar;
        int iY = byVar.y();
        if (iY == 2) {
            this.h = "2";
        } else if (iY == 6) {
            this.h = "3";
        } else {
            this.h = "1";
        }
        this.m = byVar.aO();
    }

    public final void a(Map<String, Object> map) {
        this.d = a(map, "offer_id");
        this.e = a(map, "dsp_id");
        if (map != null) {
            Object obj = map.get("ws_imp_switch");
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (num.intValue() != 0) {
                    this.a = num.intValue();
                }
            }
        }
    }

    private static String a(Map<String, Object> map, String str) {
        if (map == null) {
            return "";
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return obj.toString();
        }
        return obj != null ? obj.toString() : "";
    }

    public final int d() {
        return this.a;
    }

    public final String e() {
        return this.d;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final String i() {
        n nVar = this.b;
        return nVar != null ? nVar.p() : "";
    }

    public final String j() {
        return this.h;
    }

    private String D() {
        n nVar = this.b;
        return nVar != null ? nVar.aR() : "";
    }

    private String E() {
        n nVar = this.b;
        return nVar != null ? String.valueOf(nVar.aa()) : "";
    }

    private String F() {
        n nVar = this.b;
        return nVar != null ? String.valueOf(nVar.aO()) : "";
    }

    private String G() {
        n nVar = this.b;
        return nVar != null ? nVar.aQ() : "";
    }

    public final int k() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.Z();
        }
        return 0;
    }

    public final String l() {
        n nVar = this.b;
        return nVar != null ? nVar.N() : "";
    }

    private String H() {
        n nVar = this.b;
        return nVar != null ? nVar.aP() : "";
    }

    public final String m() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.aS();
        }
        return null;
    }

    public final JSONObject n() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.aF();
        }
        return null;
    }

    public final void a(double d) {
        this.i = d;
    }

    public final void b(double d) {
        this.j = d;
    }

    public final double o() {
        return this.i;
    }

    public final double p() {
        return this.j;
    }

    public final double q() {
        return this.t;
    }

    public final void c(double d) {
        this.t = d;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final double r() {
        return this.k;
    }

    public final void s() {
        this.k = 0.0d;
    }

    public final double t() {
        return this.l;
    }

    public final void d(double d) {
        this.l = d;
    }

    public final int u() {
        return this.m;
    }

    public final boolean v() {
        return this.m == 1;
    }

    public final Double w() {
        return this.q;
    }

    public final void b(Double d) {
        this.q = d;
    }

    public final int x() {
        return this.r;
    }

    public final void a(int i) {
        this.r = i;
    }

    public final n y() {
        return this.b;
    }

    public final by z() {
        return this.c;
    }

    public final int A() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.l();
        }
        return 0;
    }

    public final String B() {
        return this.s ? "1" : "0";
    }

    public final void a(boolean z) {
        this.s = z;
    }

    public final MgComparedResult C() {
        n nVar = this.b;
        MgPreLoadAdRequest preLoadInfo = (nVar == null || nVar.b() == null) ? null : nVar.b().getPreLoadInfo();
        if (preLoadInfo != null) {
            return preLoadInfo.getMgComparedResult();
        }
        return null;
    }
}
