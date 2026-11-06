package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 166})
public class iu implements b, Function {
    public volatile b hw;
    public volatile Function pr;

    public iu(b bVar) {
        this.hw = bVar;
    }

    public iu(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    return Integer.valueOf(pr(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue()));
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
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
        }
    }

    @Override // com.byazt.vkw.b
    public boolean hw(int i, int i2, boolean z) {
        if (this.hw != null) {
            return this.hw.hw(i, i2, z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, Boolean.valueOf(z));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.b
    public int pr(int i, int i2) {
        if (this.hw != null) {
            return this.hw.pr(i, i2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.b
    public void pr(int i) {
        if (this.hw != null) {
            this.hw.pr(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.b
    public void pr(int i, int i2, boolean z) {
        if (this.hw != null) {
            this.hw.pr(i, i2, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }
}
