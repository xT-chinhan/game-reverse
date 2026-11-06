package com.smartdigimkt.b2;

import com.smartdigimkt.n1.y4;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Comparable {
    public final int a;
    public final y4 b;

    public x(int i, y4 y4Var) {
        this.a = i;
        this.b = y4Var;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        if (obj instanceof x) {
            return this.a - ((x) obj).a;
        }
        return 0;
    }
}
