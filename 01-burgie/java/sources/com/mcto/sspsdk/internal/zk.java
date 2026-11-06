package com.mcto.sspsdk.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zk {
    public final HashMap a = new HashMap();

    public final synchronized void a(String str, bl blVar) {
        TreeSet treeSet = (TreeSet) this.a.get(str);
        if (treeSet == null) {
            treeSet = new TreeSet(new yk());
            this.a.put(str, treeSet);
        }
        treeSet.add(blVar);
    }

    public final synchronized bl a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        TreeSet treeSet = (TreeSet) this.a.get("fullscreen");
        if (treeSet == null) {
            return null;
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            bl blVar = (bl) it.next();
            if (blVar.a.isValid() && blVar.k > jCurrentTimeMillis) {
                return blVar;
            }
            it.remove();
        }
        return null;
    }
}
