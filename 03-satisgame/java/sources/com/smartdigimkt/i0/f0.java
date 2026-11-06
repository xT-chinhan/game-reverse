package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final f0 b = new f0(0);
    public final int a;

    public f0(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f0.class == obj.getClass() && this.a == ((f0) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }
}
