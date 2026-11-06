package com.mcto.sspsdk.internal;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class b4 {
    public z3 a;
    public String b;
    public String c;
    public String d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public int j = 0;
    public String k;
    public View l;
    public final long m;

    public b4(a4 a4Var) {
        this.a = a4Var.b;
        this.b = a4Var.c;
        this.c = a4Var.d;
        this.d = a4Var.e;
        this.i = a4Var.f;
        this.e = a4Var.h;
        this.f = a4Var.i;
        this.g = a4Var.j;
        this.h = a4Var.k;
        this.l = a4Var.a;
        this.m = a4Var.g;
    }

    public final void a(float f, float f2, float f3, float f4) {
        if (f != -999.0f) {
            this.e = f;
        }
        if (f2 != -999.0f) {
            this.f = f2;
        }
        if (f3 != -999.0f) {
            this.g = f3;
        }
        if (f4 != -999.0f) {
            this.h = f4;
        }
    }

    public final String toString() {
        return "ClickBean{CA=" + this.a + ", CP='" + this.c + "', CVL='" + this.d + "', CPP='" + this.e + "_" + this.f + ";" + this.g + "_" + this.h + "', CDS='" + this.j + "'}";
    }

    public final void a(int i) {
        this.j = i;
        if (i == 5) {
            this.i = 1;
        } else if (i != 0) {
            this.i = 2;
        }
    }
}
