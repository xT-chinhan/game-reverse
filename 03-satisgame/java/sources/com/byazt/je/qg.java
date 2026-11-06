package com.byazt.je;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 88, 26})
public abstract class qg implements ou {
    public boolean n = false;

    @Override // com.byazt.je.ou
    public void n(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.n = true;
    }

    @Override // com.byazt.je.ou
    public boolean n() {
        return this.n;
    }
}
