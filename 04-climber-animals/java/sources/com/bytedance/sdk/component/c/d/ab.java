package com.bytedance.sdk.component.c.d;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        List<com.bytedance.sdk.component.c.ah.ah> linkedList;
        String strI = ahVar.i();
        Map<String, List<com.bytedance.sdk.component.c.ah.ah>> mapAb = ahVar.t().ab();
        synchronized (mapAb) {
            linkedList = mapAb.get(strI);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(ahVar);
            mapAb.put(strI, linkedList);
            if (linkedList.size() <= 1) {
                ahVar.ms(new d());
            }
        }
    }
}
