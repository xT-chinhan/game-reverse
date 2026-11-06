package com.bytedance.pangle.util.xr.xr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<ah> f707ms = new ArrayList();

    public List<ah> ms() {
        return this.f707ms;
    }

    public void ms(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (ah ahVar : this.f707ms) {
            if (!set.contains(ahVar.sl())) {
                arrayList.add(ahVar);
            }
        }
        this.f707ms = arrayList;
    }

    public void ms(List<ah> list) {
        this.f707ms = list;
    }
}
