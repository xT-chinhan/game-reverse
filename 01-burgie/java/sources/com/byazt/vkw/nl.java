package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 574})
public class nl implements gz, Function {
    public volatile gz hw;
    public volatile Function pr;

    public nl(gz gzVar) {
        this.hw = gzVar;
    }

    public nl(Function function) {
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
            case 1:
                return pr();
            case 2:
                Object ntVar = sparseArray.get(1);
                if (ntVar != null) {
                    ntVar = new com.byazt.hcx.nt((Function) ntVar);
                }
                pr((com.byazt.hcx.ho) ntVar);
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.gz
    public com.byazt.hcx.aj pr() {
        ?? kVar;
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            kVar = Apply;
            kVar = new com.byazt.hcx.k((Function) Apply);
        }
        kVar = Apply;
        return (com.byazt.hcx.aj) kVar;
    }

    @Override // com.byazt.vkw.gz
    public void pr(com.byazt.hcx.ho hoVar) {
        if (this.hw != null) {
            this.hw.pr(hoVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (hoVar != null) {
            hoVar = new com.byazt.hcx.nt(hoVar);
        }
        sparseArray.put(1, hoVar);
        this.pr.apply(sparseArray);
    }
}
