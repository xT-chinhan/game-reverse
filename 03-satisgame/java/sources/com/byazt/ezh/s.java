package com.byazt.ezh;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 8})
public class s {
    public int[] n = new int[32];
    public int qg;
    public int s;

    public final void n() {
        this.qg = 0;
        this.s = 0;
    }

    public final int qg() {
        int i = this.qg;
        if (i == 0) {
            return 0;
        }
        return this.n[i - 1];
    }

    public final void n(int i, int i2) {
        if (this.s == 0) {
            l();
        }
        x();
        int i3 = this.qg;
        int i4 = i3 - 1;
        int[] iArr = this.n;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.qg = i3 + 2;
    }

    public final void s() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.qg;
        if (i3 == 0 || (i2 = (iArr = this.n)[(i = i3 - 1)]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.qg = i3 - 2;
    }

    public final int q() {
        return this.s;
    }

    public final void l() {
        x();
        int i = this.qg;
        int[] iArr = this.n;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.qg = i + 2;
        this.s++;
    }

    public final void w() {
        int i = this.qg;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.n[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.qg = i - (i3 + 2);
                this.s--;
            }
        }
    }

    private void x() {
        int[] iArr = this.n;
        int length = iArr.length;
        int i = this.qg;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.n = iArr2;
        }
    }
}
