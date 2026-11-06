package com.anythink.basead.exoplayer.h.b;

import android.util.Log;
import com.anythink.basead.exoplayer.e.m;
import com.anythink.basead.exoplayer.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d.b {
    private static final String a = "BaseMediaChunkOutput";
    private final int[] b;
    private final x[] c;

    public b(int[] iArr, x[] xVarArr) {
        this.b = iArr;
        this.c = xVarArr;
    }

    @Override // com.anythink.basead.exoplayer.h.b.d.b
    public final m a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                if (i == iArr[i2]) {
                    return this.c[i2];
                }
                i2++;
            } else {
                Log.e(a, "Unmatched track of type: ".concat(String.valueOf(i)));
                return new com.anythink.basead.exoplayer.e.d();
            }
        }
    }

    public final int[] a() {
        int[] iArr = new int[this.c.length];
        int i = 0;
        while (true) {
            x[] xVarArr = this.c;
            if (i >= xVarArr.length) {
                return iArr;
            }
            x xVar = xVarArr[i];
            if (xVar != null) {
                iArr[i] = xVar.b();
            }
            i++;
        }
    }

    public final void a(long j) {
        for (x xVar : this.c) {
            if (xVar != null) {
                xVar.a(j);
            }
        }
    }
}
