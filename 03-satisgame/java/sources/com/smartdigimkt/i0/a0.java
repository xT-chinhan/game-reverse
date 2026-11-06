package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final a0 e = new a0(1.0f, 1.0f, false);
    public final float a;
    public final float b;
    public final boolean c;
    public final int d;

    public a0(float f, float f2, boolean z) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        this.a = f;
        this.b = f2;
        this.c = z;
        this.d = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.a == a0Var.a && this.b == a0Var.b && this.c == a0Var.c;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + ((Float.floatToRawIntBits(this.a) + 527) * 31)) * 31) + (this.c ? 1 : 0);
    }
}
