package com.byazt.mj;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1996, 13})
public class hw implements hn {
    public List<x> pr = new CopyOnWriteArrayList();

    @Override // com.byazt.mj.hn
    public void pr(x xVar) {
        this.pr.add(xVar);
    }

    @Override // com.byazt.mj.hn
    public void pr(String str) {
        if (this.pr.isEmpty()) {
            return;
        }
        Iterator<x> it = this.pr.iterator();
        while (it.hasNext()) {
            it.next().pr(str);
        }
    }
}
