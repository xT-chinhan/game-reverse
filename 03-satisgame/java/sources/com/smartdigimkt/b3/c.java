package com.smartdigimkt.b3;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements Serializable {
    public String A;
    public String B;
    public boolean C;
    public int D = -1;
    public int E;
    public int F;
    public int G;
    public int H;
    public long I;
    public int J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public e w;
    public String x;
    public String y;
    public int z;

    public abstract String a();

    public String a(e eVar) {
        return this.f;
    }

    public abstract ArrayList a(e eVar, boolean z);

    public abstract ArrayList b(e eVar);

    public final synchronized void b(int i) {
        this.E = i;
    }

    public final synchronized int c() {
        return this.E;
    }

    public final int d() {
        e eVar = this.w;
        return (eVar == null || eVar.v1 != 1 || TextUtils.isEmpty(eVar.t1) || (this.w.a == 1 && TextUtils.isEmpty(this.i))) ? 1 : 3;
    }

    public abstract int e();

    public final synchronized boolean f() {
        return this.E > 0 && this.F > 0;
    }

    public final boolean g() {
        return (TextUtils.isEmpty(this.s) || TextUtils.isEmpty(this.r) || TextUtils.isEmpty(this.t) || TextUtils.isEmpty(this.u)) ? false : true;
    }

    public final boolean h() {
        return !TextUtils.isEmpty(this.i);
    }

    public final boolean i() {
        return this.o == 4;
    }

    public final boolean a(String str) {
        return TextUtils.equals(this.i, str) && !TextUtils.isEmpty(str);
    }

    public final synchronized int b() {
        return this.F;
    }

    public final synchronized void a(int i) {
        this.F = i;
    }
}
