package com.byazt.bd;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 18})
public class l extends x<com.byazt.aw.q> {
    public final com.byazt.aw.q q;

    public l(List<com.byazt.yt.n<com.byazt.aw.q>> list) {
        super(list);
        com.byazt.aw.q qVar = list.get(0).n;
        int iS = qVar != null ? qVar.s() : 0;
        this.q = new com.byazt.aw.q(new float[iS], new int[iS]);
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public com.byazt.aw.q n(com.byazt.yt.n<com.byazt.aw.q> nVar, float f) {
        this.q.n(nVar.n, nVar.qg, f);
        return this.q;
    }
}
