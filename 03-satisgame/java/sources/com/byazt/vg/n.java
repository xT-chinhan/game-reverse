package com.byazt.vg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1067, 19})
public class n {
    public List<s> n = new ArrayList();

    public List<s> n() {
        return this.n;
    }

    public void n(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (s sVar : this.n) {
            if (!set.contains(sVar.d())) {
                arrayList.add(sVar);
            }
        }
        this.n = arrayList;
    }

    public void n(List<s> list) {
        this.n = list;
    }
}
