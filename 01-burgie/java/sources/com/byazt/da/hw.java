package com.byazt.da;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1572, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

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
                    return pr();
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return Boolean.valueOf(pr((String) sparseArray.get(1)));
            case 3:
                return hw((String) sparseArray.get(1));
            case 4:
                return hw();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.byazt.da.pr
    public hn hw(String str) {
        ?? xVar;
        if (this.hw != null) {
            return this.hw.hw(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            xVar = Apply;
            xVar = new x((Function) Apply);
        }
        xVar = Apply;
        return (hn) xVar;
    }

    @Override // com.byazt.da.pr
    public Set hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (Set) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.pr
    public Map pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.pr
    public boolean pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
