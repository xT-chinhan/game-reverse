package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 1121})
public class ls implements s, Function {
    public volatile s hw;
    public volatile Function pr;

    public ls(s sVar) {
        this.hw = sVar;
    }

    public ls(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006e  */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object objHw;
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    objHw = sparseArray.get(1);
                    Object obj2 = sparseArray.get(2);
                    if (objHw != null) {
                        objHw = com.byazt.zs.uc.hw((String) objHw);
                    }
                    return pr((pr) objHw, (String) obj2);
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                objHw = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (objHw != null) {
                    objHw = com.byazt.zs.uc.hw((String) objHw);
                }
                return pr((pr) objHw, (String) obj3);
            case 2:
                Object objHw2 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                if (objHw2 != null) {
                    objHw2 = com.byazt.zs.uc.hw((String) objHw2);
                }
                return hw((pr) objHw2, (String) obj4);
            case 3:
                Object objHw3 = sparseArray.get(1);
                Object obj5 = sparseArray.get(2);
                if (objHw3 != null) {
                    objHw3 = com.byazt.zs.uc.hw((String) objHw3);
                }
                return hn((pr) objHw3, (String) obj5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // com.byazt.vkw.s
    public com.byazt.zq.fw hn(pr prVar, String str) {
        if (this.hw != null) {
            return this.hw.hn(prVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, prVar != null ? prVar.pr() : null);
        sparseArray.put(2, str);
        ?? Apply = this.pr.apply(sparseArray);
        ?? zoVar = Apply;
        if (Apply != 0) {
            zoVar = new com.byazt.zq.zo((Function) Apply);
        }
        return (com.byazt.zq.fw) zoVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.vkw.s
    public com.byazt.zq.hn hw(pr prVar, String str) {
        if (this.hw != null) {
            return this.hw.hw(prVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, prVar != null ? prVar.pr() : null);
        sparseArray.put(2, str);
        ?? Apply = this.pr.apply(sparseArray);
        ?? xVar = Apply;
        if (Apply != 0) {
            xVar = new com.byazt.zq.x((Function) Apply);
        }
        return (com.byazt.zq.hn) xVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.vkw.s
    public com.byazt.zq.c pr(pr prVar, String str) {
        if (this.hw != null) {
            return this.hw.pr(prVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, prVar != null ? prVar.pr() : null);
        sparseArray.put(2, str);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ucVar = Apply;
        if (Apply != 0) {
            ucVar = new com.byazt.zq.uc((Function) Apply);
        }
        return (com.byazt.zq.c) ucVar;
    }
}
