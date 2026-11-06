package com.byazt.vt;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1387, 26})
public class qg implements s {
    public List<q> n = new CopyOnWriteArrayList();

    @Override // com.byazt.vt.s
    public void n(q qVar) {
        this.n.add(qVar);
    }

    @Override // com.byazt.vt.s
    public void n(String str) {
        if (this.n.isEmpty()) {
            return;
        }
        Iterator<q> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().n(str);
        }
    }
}
