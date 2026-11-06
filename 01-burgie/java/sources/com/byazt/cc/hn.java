package com.byazt.cc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, 20})
public class hn {
    public int hn;
    public int hw;
    public int[] pr = new int[32];

    public final void pr() {
        this.hw = 0;
        this.hn = 0;
    }

    public final int hw() {
        int i = this.hw;
        if (i == 0) {
            return 0;
        }
        return this.pr[i - 1];
    }

    public final void pr(int i, int i2) {
        if (this.hn == 0) {
            c();
        }
        fw();
        int i3 = this.hw;
        int i4 = i3 - 1;
        int[] iArr = this.pr;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.hw = i3 + 2;
    }

    public final void hn() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.hw;
        if (i3 != 0 && (i2 = (iArr = this.pr)[(i = i3 - 1)]) != 0) {
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.hw = i3 - 2;
        }
    }

    public final int x() {
        return this.hn;
    }

    public final void c() {
        fw();
        int i = this.hw;
        int[] iArr = this.pr;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.hw = i + 2;
        this.hn++;
    }

    public final void uc() {
        int i = this.hw;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.pr[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.hw = i - (i3 + 2);
                this.hn--;
            }
        }
    }

    private void fw() {
        int[] iArr = this.pr;
        int length = iArr.length;
        int i = this.hw;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.pr = iArr2;
        }
    }
}
