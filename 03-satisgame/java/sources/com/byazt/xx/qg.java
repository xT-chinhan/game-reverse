package com.byazt.xx;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 719, 26})
public class qg {
    public final List<com.byazt.dg.qg.C0152qg> n;
    public int qg = 0;

    public qg(List<com.byazt.dg.qg.C0152qg> list) {
        this.n = list;
    }

    public com.byazt.dg.qg.C0152qg n() {
        if (this.n.isEmpty()) {
            return null;
        }
        return this.n.get(this.qg);
    }

    public void qg() {
        this.qg = 0;
    }

    public boolean n(int i) {
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if (this.n.get(i2).n == i) {
                this.qg = i2;
                return true;
            }
        }
        return false;
    }
}
