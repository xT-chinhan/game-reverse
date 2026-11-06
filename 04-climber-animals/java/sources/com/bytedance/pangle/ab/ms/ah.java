package com.bytedance.pangle.ab.ms;

/* JADX INFO: loaded from: classes2.dex */
class ah {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int[] f611ms = new int[32];
    private int xr;

    public final void ms() {
        this.xr = 0;
        this.ah = 0;
    }

    public final int xr() {
        int i = this.xr;
        if (i == 0) {
            return 0;
        }
        return this.f611ms[i - 1];
    }

    public final void ms(int i, int i2) {
        if (this.ah == 0) {
            ka();
        }
        ab();
        int i3 = this.xr;
        int i4 = i3 - 1;
        int[] iArr = this.f611ms;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.xr = i3 + 2;
    }

    public final void ah() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.xr;
        if (i3 == 0 || (i2 = (iArr = this.f611ms)[(i = i3 - 1)]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.xr = i3 - 2;
    }

    public final int d() {
        return this.ah;
    }

    public final void ka() {
        ab();
        int i = this.xr;
        int[] iArr = this.f611ms;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.xr = i + 2;
        this.ah++;
    }

    public final void c() {
        int i = this.xr;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.f611ms[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.xr = i - (i3 + 2);
                this.ah--;
            }
        }
    }

    private void ab() {
        int[] iArr = this.f611ms;
        int length = iArr.length;
        int i = this.xr;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f611ms = iArr2;
        }
    }
}
