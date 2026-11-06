package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable {
    public final int a;
    public int b;

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.a - ((b) obj).a;
    }
}
