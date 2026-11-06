package com.byazt.wye;

import android.text.TextUtils;
import com.byazt.nzn.g;
import com.byazt.nzn.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1008, 20})
public final class hn extends k {
    public x k;

    public hn(k.pr prVar) {
        super(prVar);
        this.k = new x();
    }

    @Override // com.byazt.nzn.k
    public com.byazt.nzn.x pr() {
        return this.k;
    }

    @Override // com.byazt.nzn.k
    public com.byazt.nzn.hw pr(g gVar) {
        gVar.pr(this);
        if (gVar == null || gVar.hw() == null || TextUtils.isEmpty(gVar.hw().toString())) {
            return null;
        }
        return new pr(gVar, this.k);
    }
}
