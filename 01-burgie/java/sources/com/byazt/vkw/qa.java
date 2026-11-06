package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 101})
public class qa implements lb, Function {
    public volatile lb hw;
    public volatile Function pr;

    public qa(lb lbVar) {
        this.hw = lbVar;
    }

    public qa(Function function) {
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
                    return pr((String) sparseArray.get(1));
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr((String) sparseArray.get(1));
            case 2:
                return pr((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            case 3:
                return pr(((Integer) sparseArray.get(1)).intValue());
            case 4:
                pr();
                return null;
            case 5:
                hw();
                return null;
        }
    }

    @Override // com.byazt.vkw.lb
    public void hw() {
        if (this.hw != null) {
            this.hw.hw();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.vkw.lb
    public com.byazt.cr.c pr(String str) {
        ?? ucVar;
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            ucVar = Apply;
            ucVar = new com.byazt.cr.uc((Function) Apply);
        }
        ucVar = Apply;
        return (com.byazt.cr.c) ucVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.vkw.lb
    public com.byazt.cr.c pr(String str, int i) {
        ?? ucVar;
        if (this.hw != null) {
            return this.hw.pr(str, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            ucVar = Apply;
            ucVar = new com.byazt.cr.uc((Function) Apply);
        }
        ucVar = Apply;
        return (com.byazt.cr.c) ucVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vkw.lb
    public com.byazt.cr.hn pr(int i) {
        ?? xVar;
        if (this.hw != null) {
            return this.hw.pr(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            xVar = Apply;
            xVar = new com.byazt.cr.x((Function) Apply);
        }
        xVar = Apply;
        return (com.byazt.cr.hn) xVar;
    }

    @Override // com.byazt.vkw.lb
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.pr.apply(sparseArray);
    }
}
