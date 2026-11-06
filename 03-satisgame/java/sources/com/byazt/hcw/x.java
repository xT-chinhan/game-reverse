package com.byazt.hcw;

import com.byazt.pq.wm;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 21})
public class x extends com.byazt.tbt.q {
    public wm n;

    public x(wm wmVar) {
        this.n = wmVar;
    }

    @Override // com.byazt.tbt.q
    public void n(int i) {
        this.n.um().n(i);
    }

    @Override // com.byazt.tbt.q
    public void qg(int i) {
        if (i <= 0) {
            this.n.um().qg(1);
        } else {
            this.n.um().qg(i);
        }
    }

    @Override // com.byazt.tbt.q
    public void s(int i) {
        if (i >= 0) {
            this.n.um().s(i);
        }
    }

    @Override // com.byazt.tbt.q
    public List<com.byazt.tbt.qg> s() {
        ArrayList arrayList = new ArrayList();
        List<com.byazt.pq.l> listQg = this.n.um().qg();
        for (int i = 0; i < listQg.size(); i++) {
            arrayList.add(new q(listQg.get(i)));
        }
        return arrayList;
    }

    @Override // com.byazt.tbt.q
    public List<com.byazt.tbt.qg> q() {
        ArrayList arrayList = new ArrayList();
        List<com.byazt.pq.l> listS = this.n.um().s();
        for (int i = 0; i < listS.size(); i++) {
            arrayList.add(new q(listS.get(i)));
        }
        return arrayList;
    }
}
