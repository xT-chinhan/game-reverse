package com.byazt.jl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1568, 37})
public class pr {
    public List<hn> pr = new ArrayList();

    public List<hn> pr() {
        return this.pr;
    }

    public void pr(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (hn hnVar : this.pr) {
            if (!set.contains(hnVar.k())) {
                arrayList.add(hnVar);
            }
        }
        this.pr = arrayList;
    }

    public void pr(List<hn> list) {
        this.pr = list;
    }
}
