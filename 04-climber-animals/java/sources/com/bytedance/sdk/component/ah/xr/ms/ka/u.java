package com.bytedance.sdk.component.ah.xr.ms.ka;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1100ms;
    private final int[] xr = new int[10];

    void ms() {
        this.f1100ms = 0;
        Arrays.fill(this.xr, 0);
    }

    u ms(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.xr;
            if (i < iArr.length) {
                this.f1100ms = (1 << i) | this.f1100ms;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean ms(int i) {
        return ((1 << i) & this.f1100ms) != 0;
    }

    int xr(int i) {
        return this.xr[i];
    }

    int xr() {
        return Integer.bitCount(this.f1100ms);
    }

    int ah() {
        if ((this.f1100ms & 2) != 0) {
            return this.xr[1];
        }
        return -1;
    }

    int ah(int i) {
        return (this.f1100ms & 16) != 0 ? this.xr[4] : i;
    }

    int d(int i) {
        return (this.f1100ms & 32) != 0 ? this.xr[5] : i;
    }

    int d() {
        return (this.f1100ms & 128) != 0 ? this.xr[7] : SupportMenu.USER_MASK;
    }

    void ms(u uVar) {
        for (int i = 0; i < 10; i++) {
            if (uVar.ms(i)) {
                ms(i, uVar.xr(i));
            }
        }
    }
}
