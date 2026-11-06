package com.smartdigimkt.x0;

import com.smartdigimkt.i0.s;
import com.smartdigimkt.v0.i0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public final i0 a;
    public final int[] b;
    public final s[] c;
    public int d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.a && Arrays.equals(this.b, hVar.b);
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.b) + (System.identityHashCode(this.a) * 31);
        }
        return this.d;
    }

    public h(i0 i0Var, int i) {
        int[] iArr = {i};
        i0Var.getClass();
        this.a = i0Var;
        s[] sVarArr = {i0Var.b[i]};
        this.c = sVarArr;
        int i2 = iArr[0];
        Arrays.sort(sVarArr, new a());
        int[] iArr2 = new int[1];
        this.b = iArr2;
        s sVar = sVarArr[0];
        int i3 = 0;
        while (true) {
            s[] sVarArr2 = i0Var.b;
            if (i3 >= sVarArr2.length) {
                i3 = -1;
                break;
            } else if (sVar == sVarArr2[i3]) {
                break;
            } else {
                i3++;
            }
        }
        iArr2[0] = i3;
    }
}
