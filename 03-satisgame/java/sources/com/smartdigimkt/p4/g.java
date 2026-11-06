package com.smartdigimkt.p4;

import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public double A;
    public int[] B;
    public int C;
    public int D;
    public int E;
    public double F;
    public int G;
    public double H;
    public long I;
    public int J;
    public double K;
    public c L;
    public com.smartdigimkt.d3.c a;
    public int b;
    public String c;
    public String d;
    public Map e;
    public f f;
    public boolean g;
    public int h;
    public String i;
    public int j;
    public int k;
    public String l;
    public double m;
    public int n;
    public String o;
    public String p;
    public int q;
    public String r;
    public String s;
    public int t;
    public int u;
    public int v = 2;
    public int w;
    public int x;
    public String y;
    public double z;

    public g(int i) {
        SDMAdConst.CURRENCY currency = SDMAdConst.CURRENCY.RMB;
        this.C = 1;
        this.D = 1;
        this.w = i;
    }

    public final g a() {
        c cVar;
        g gVar = new g(this.w);
        gVar.b = this.b;
        gVar.c = this.c;
        gVar.d = this.d;
        gVar.e = this.e;
        gVar.f = this.f;
        gVar.g = this.g;
        gVar.h = this.h;
        gVar.i = this.i;
        gVar.j = this.j;
        gVar.k = this.k;
        gVar.l = this.l;
        gVar.m = this.m;
        gVar.n = this.n;
        gVar.o = this.o;
        gVar.q = this.q;
        gVar.r = this.r;
        gVar.s = this.s;
        gVar.t = this.t;
        gVar.u = this.u;
        gVar.w = this.w;
        gVar.x = this.x;
        gVar.y = this.y;
        gVar.z = this.z;
        gVar.A = this.A;
        int[] iArr = this.B;
        gVar.B = iArr != null ? (int[]) iArr.clone() : null;
        gVar.C = this.C;
        gVar.D = this.D;
        gVar.E = this.E;
        gVar.F = this.F;
        gVar.G = this.G;
        gVar.H = this.H;
        gVar.I = this.I;
        gVar.J = this.J;
        gVar.K = this.K;
        c cVar2 = this.L;
        if (cVar2 != null) {
            cVar = new c();
            cVar.a = cVar2.a;
            cVar.b = cVar2.b;
            cVar.c = cVar2.c;
            cVar.d = cVar2.d;
            cVar.e = cVar2.e;
            cVar.f = cVar2.f;
        } else {
            cVar = null;
        }
        gVar.L = cVar;
        gVar.a = null;
        gVar.p = null;
        gVar.v = 2;
        return gVar;
    }

    public final String toString() {
        return super.toString();
    }

    public final void a(com.smartdigimkt.d3.c cVar, int i, int i2) {
        this.q = i;
        this.m = cVar.c;
        this.A = cVar.d;
        this.K = cVar.l;
        this.o = cVar.e;
        this.a = cVar;
        if (i2 == 1) {
            this.p = "";
        } else {
            this.p = cVar.f;
        }
        c cVar2 = this.L;
        if (cVar2 != null) {
            String str = cVar.I;
            int i3 = cVar.J;
            String str2 = cVar.K;
            cVar2.b = str;
            cVar2.f = str2;
            cVar2.d = i3;
        }
    }
}
