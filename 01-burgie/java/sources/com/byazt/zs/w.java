package com.byazt.zs;

import android.util.SparseArray;
import com.byazt.vkw.b;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 109})
public class w implements b, Function {
    public static final int STATE_KEY_BOOST = 0;
    public volatile int[] pr = new int[1];

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(pr(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue()));
            case 2:
                pr(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
                return null;
            case 3:
                return Boolean.valueOf(hw(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue()));
            case 4:
                pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.b
    public synchronized int pr(int i, int i2) {
        if (i < this.pr.length) {
            return this.pr[i] & i2;
        }
        pr(i + 1);
        return 0;
    }

    @Override // com.byazt.vkw.b
    public synchronized void pr(int i, int i2, boolean z) {
        if (i >= this.pr.length) {
            pr(i + 1);
        }
        if (z) {
            int[] iArr = this.pr;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.pr;
            iArr2[i] = (~i2) & iArr2[i];
        }
    }

    @Override // com.byazt.vkw.b
    public synchronized boolean hw(int i, int i2, boolean z) {
        if (i >= this.pr.length) {
            pr(i + 1);
        }
        if (((this.pr[i] & i2) == i2) == z) {
            return true;
        }
        if (z) {
            int[] iArr = this.pr;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.pr;
            iArr2[i] = (~i2) & iArr2[i];
        }
        return false;
    }

    @Override // com.byazt.vkw.b
    public void pr(int i) {
        if (i < this.pr.length) {
            return;
        }
        int[] iArr = new int[i];
        System.arraycopy(this.pr, 0, iArr, 0, this.pr.length);
        this.pr = iArr;
    }
}
