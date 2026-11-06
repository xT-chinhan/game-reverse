package com.mcto.sspsdk.internal;

import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class vk {
    public final /* synthetic */ wk a;

    public vk(wk wkVar) {
        this.a = wkVar;
    }

    public final void a() {
        bl blVarA = this.a.b.a.a();
        if (blVarA == null) {
            this.a.a.a.a();
            return;
        }
        zk zkVar = this.a.b.a;
        String str = blVarA.b;
        synchronized (zkVar) {
            TreeSet treeSet = (TreeSet) zkVar.a.get(str);
            if (treeSet != null) {
                Iterator it = treeSet.iterator();
                while (it.hasNext()) {
                    if (((bl) it.next()).equals(blVarA)) {
                        it.remove();
                    }
                }
            }
        }
        lk lkVar = this.a.a.a;
        lkVar.d = blVarA;
        lkVar.a();
    }
}
