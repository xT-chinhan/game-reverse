package com.byazt.ld;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 166})
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
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object gzVar;
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    gzVar = sparseArray.get(1);
                    if (gzVar != null) {
                        gzVar = new gz((Function) gzVar);
                    }
                    return pr((ve) gzVar);
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                gzVar = sparseArray.get(1);
                if (gzVar != null) {
                    gzVar = new gz((Function) gzVar);
                }
                return pr((ve) gzVar);
            case 2:
                Object gzVar2 = sparseArray.get(1);
                if (gzVar2 != null) {
                    gzVar2 = new gz((Function) gzVar2);
                }
                hw((ve) gzVar2);
                return null;
            case 3:
                Object gzVar3 = sparseArray.get(1);
                if (gzVar3 != null) {
                    gzVar3 = new gz((Function) gzVar3);
                }
                hn((ve) gzVar3);
                return null;
            case 4:
                pr();
                return null;
        }
    }

    @Override // com.byazt.ld.b
    public void hn(ve veVar) {
        if (this.hw != null) {
            this.hw.hn(veVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (veVar != null) {
            veVar = new gz(veVar);
        }
        sparseArray.put(1, veVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.b
    public void hw(ve veVar) {
        if (this.hw != null) {
            this.hw.hw(veVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (veVar != null) {
            veVar = new gz(veVar);
        }
        sparseArray.put(1, veVar);
        this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.ld.b
    public g pr(ve veVar) {
        if (this.hw != null) {
            return this.hw.pr(veVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (veVar != null) {
            veVar = new gz(veVar);
        }
        sparseArray.put(1, veVar);
        ?? Apply = this.pr.apply(sparseArray);
        ?? hoVar = Apply;
        if (Apply != 0) {
            hoVar = new ho((Function) Apply);
        }
        return (g) hoVar;
    }

    @Override // com.byazt.ld.b
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
