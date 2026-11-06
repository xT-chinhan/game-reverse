package com.byazt.hcx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 74})
public class nt implements ho, Function {
    public volatile ho hw;
    public volatile Function pr;

    public nt(ho hoVar) {
        this.hw = hoVar;
    }

    public nt(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object kVar = sparseArray.get(1);
                if (kVar != null) {
                    kVar = new k((Function) kVar);
                }
                aj ajVarPr = this.hw.pr((aj) kVar);
                return ajVarPr != null ? new k(ajVarPr) : ajVarPr;
            case 2:
                Object gVar = sparseArray.get(1);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                m mVarPr = this.hw.pr((m) gVar);
                return mVarPr != null ? new g(mVarPr) : mVarPr;
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.hcx.ho
    public aj pr(aj ajVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (ajVar != null) {
            ajVar = new k(ajVar);
        }
        sparseArray.put(1, ajVar);
        ?? Apply = this.pr.apply(sparseArray);
        ?? kVar = Apply;
        if (Apply != 0) {
            kVar = new k((Function) Apply);
        }
        return (aj) kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.hcx.ho
    public m pr(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        ?? Apply = this.pr.apply(sparseArray);
        ?? gVar = Apply;
        if (Apply != 0) {
            gVar = new g((Function) Apply);
        }
        return (m) gVar;
    }
}
