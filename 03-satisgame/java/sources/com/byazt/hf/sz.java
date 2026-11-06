package com.byazt.hf;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 110})
public final class sz {
    public int n;
    public final int[] qg = new int[10];

    public void n() {
        this.n = 0;
        Arrays.fill(this.qg, 0);
    }

    public sz n(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.qg;
            if (i < iArr.length) {
                this.n = (1 << i) | this.n;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public boolean n(int i) {
        return ((1 << i) & this.n) != 0;
    }

    public int qg(int i) {
        return this.qg[i];
    }

    public int qg() {
        return Integer.bitCount(this.n);
    }

    public int s() {
        if ((this.n & 2) != 0) {
            return this.qg[1];
        }
        return -1;
    }

    public int s(int i) {
        return (this.n & 16) != 0 ? this.qg[4] : i;
    }

    public int q(int i) {
        return (this.n & 32) != 0 ? this.qg[5] : i;
    }

    public int q() {
        return (this.n & 128) != 0 ? this.qg[7] : SupportMenu.USER_MASK;
    }

    public void n(sz szVar) {
        for (int i = 0; i < 10; i++) {
            if (szVar.n(i)) {
                n(i, szVar.qg(i));
            }
        }
    }
}
