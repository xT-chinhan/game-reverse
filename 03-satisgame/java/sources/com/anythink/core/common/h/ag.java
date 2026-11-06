package com.anythink.core.common.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ag {
    HashMap<String, List<ad>> a = new HashMap<>(2);

    public final synchronized void a(String str, ad adVar) {
        List<ad> arrayList = this.a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(str, arrayList);
        }
        arrayList.add(adVar);
    }

    public final synchronized ad a(String str) {
        HashMap<String, List<ad>> map = this.a;
        ad adVar = null;
        if (map == null) {
            return null;
        }
        List<ad> list = map.get(str);
        if (list != null && list.size() != 0) {
            for (ad adVar2 : list) {
                if (adVar == null || adVar2.price > adVar.price) {
                    adVar = adVar2;
                }
            }
            if (adVar != null) {
                list.remove(adVar);
            }
            return adVar;
        }
        return null;
    }
}
