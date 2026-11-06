package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 110})
public class z implements rc, Function {
    public volatile rc hw;
    public volatile Function pr;

    public z(rc rcVar) {
        this.hw = rcVar;
    }

    public z(Function function) {
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
                    return pr(((Integer) sparseArray.get(1)).intValue());
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr(((Integer) sparseArray.get(1)).intValue());
            case 2:
                pr(((Integer) sparseArray.get(1)).intValue(), sparseArray.get(2));
                return null;
            case 3:
                Object obj2 = sparseArray.get(1);
                Object hwVar = sparseArray.get(2);
                if (hwVar != null) {
                    hwVar = new com.byazt.cr.hw((Function) hwVar);
                }
                return pr(((Integer) obj2).intValue(), (com.byazt.cr.pr) hwVar);
            case 4:
                Object obj3 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                Object hwVar2 = sparseArray.get(3);
                if (hwVar2 != null) {
                    hwVar2 = new com.byazt.cr.hw((Function) hwVar2);
                }
                pr(((Integer) obj3).intValue(), obj4, (com.byazt.cr.pr) hwVar2);
                return null;
        }
    }

    @Override // com.byazt.vkw.rc
    public Object pr(int i) {
        if (this.hw != null) {
            return this.hw.pr(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.rc
    public Object pr(int i, com.byazt.cr.pr prVar) {
        if (this.hw != null) {
            return this.hw.pr(i, prVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        if (prVar != null) {
            prVar = new com.byazt.cr.hw(prVar);
        }
        sparseArray.put(2, prVar);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.rc
    public void pr(int i, Object obj) {
        if (this.hw != null) {
            this.hw.pr(i, obj);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.rc
    public void pr(int i, Object obj, com.byazt.cr.pr prVar) {
        if (this.hw != null) {
            this.hw.pr(i, obj, prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        if (prVar != null) {
            prVar = new com.byazt.cr.hw(prVar);
        }
        sparseArray.put(3, prVar);
        this.pr.apply(sparseArray);
    }
}
