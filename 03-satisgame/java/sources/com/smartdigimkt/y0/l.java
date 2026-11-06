package com.smartdigimkt.y0;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements b {
    public int b;
    public int c;
    public int d = 0;
    public a[] e = new a[100];
    public final a[] a = new a[1];

    public final synchronized void a(int i) {
        boolean z = i < this.b;
        this.b = i;
        if (z) {
            a();
        }
    }

    public final synchronized void a(a[] aVarArr) {
        int i = this.d;
        int length = aVarArr.length + i;
        a[] aVarArr2 = this.e;
        if (length >= aVarArr2.length) {
            this.e = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            byte[] bArr = aVar.a;
            if (bArr != null && bArr.length != 65536) {
                throw new IllegalArgumentException(com.smartdigimkt.c0.j.a(new StringBuilder("Unexpected allocation: ").append(System.identityHashCode(aVar.a)).append(", ").append(System.identityHashCode(null)).append(", "), aVar.a.length, ", 65536"));
            }
            a[] aVarArr3 = this.e;
            int i2 = this.d;
            this.d = i2 + 1;
            aVarArr3[i2] = aVar;
        }
        this.c -= aVarArr.length;
        notifyAll();
    }

    public final synchronized void a() {
        int i = this.b;
        int i2 = com.smartdigimkt.z0.u.a;
        int iMax = Math.max(0, ((i + SupportMenu.USER_MASK) / 65536) - this.c);
        int i3 = this.d;
        if (iMax >= i3) {
            return;
        }
        Arrays.fill(this.e, iMax, i3, (Object) null);
        this.d = iMax;
    }
}
