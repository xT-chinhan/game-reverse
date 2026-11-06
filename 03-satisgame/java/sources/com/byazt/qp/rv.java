package com.byazt.qp;

import android.util.SparseArray;
import com.byazt.vf.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements t, Function {
    public static final int STATE_KEY_BOOST = 0;
    public volatile int[] n = new int[1];

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return Integer.valueOf(n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue()));
        }
        if (iIntValue == 2) {
            n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
            return null;
        }
        if (iIntValue != 3) {
            if (iIntValue != 4) {
                return null;
            }
            n(((Integer) sparseArray.get(1)).intValue());
            return null;
        }
        return Boolean.valueOf(qg(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue()));
    }

    @Override // com.byazt.vf.t
    public synchronized int n(int i, int i2) {
        if (i < this.n.length) {
            return this.n[i] & i2;
        }
        n(i + 1);
        return 0;
    }

    @Override // com.byazt.vf.t
    public synchronized void n(int i, int i2, boolean z) {
        if (i >= this.n.length) {
            n(i + 1);
        }
        if (z) {
            int[] iArr = this.n;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.n;
            iArr2[i] = (~i2) & iArr2[i];
        }
    }

    @Override // com.byazt.vf.t
    public synchronized boolean qg(int i, int i2, boolean z) {
        if (i >= this.n.length) {
            n(i + 1);
        }
        if (((this.n[i] & i2) == i2) == z) {
            return true;
        }
        if (z) {
            int[] iArr = this.n;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.n;
            iArr2[i] = (~i2) & iArr2[i];
        }
        return false;
    }

    @Override // com.byazt.vf.t
    public void n(int i) {
        if (i < this.n.length) {
            return;
        }
        int[] iArr = new int[i];
        System.arraycopy(this.n, 0, iArr, 0, this.n.length);
        this.n = iArr;
    }
}
