package com.tapsdk.tapad.internal.animation.k;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Serializable {
    public static final a e = new a(1.0d, 0.0d, 0.0d, 0.0d);
    public static final a f = new a(0.0d, 0.0d, 0.0d, 0.0d);
    public double a;
    public double b;
    public double c;
    public double d;

    public a(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = d4;
    }

    public a(double d, double[] dArr) throws Exception {
        if (dArr.length != 3) {
            throw new Exception("");
        }
        this.a = d;
        this.b = dArr[0];
        this.c = dArr[1];
        this.d = dArr[2];
    }

    public static a a(a aVar, a aVar2) {
        double d = aVar.a;
        double d2 = aVar.b;
        double d3 = aVar.c;
        double d4 = aVar.d;
        double d5 = aVar2.a;
        double d6 = aVar2.b;
        double d7 = aVar2.c;
        double d8 = aVar2.d;
        return new a((((d * d5) - (d2 * d6)) - (d3 * d7)) - (d4 * d8), (((d * d6) + (d2 * d5)) + (d3 * d8)) - (d4 * d7), ((d * d7) - (d2 * d8)) + (d3 * d5) + (d4 * d6), (((d * d8) + (d2 * d7)) - (d3 * d6)) + (d4 * d5));
    }

    public a a(a aVar) {
        return a(this, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Double.compare(aVar.a, this.a) == 0 && Double.compare(aVar.b, this.b) == 0 && Double.compare(aVar.c, this.c) == 0 && Double.compare(aVar.d, this.d) == 0;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d));
    }
}
