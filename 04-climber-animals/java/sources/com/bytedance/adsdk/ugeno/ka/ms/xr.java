package com.bytedance.adsdk.ugeno.ka.ms;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<d> f374ms = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.ka.ms.ah
    public void ms(d dVar) {
        this.f374ms.add(dVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ms.ah
    public void ms(String str) {
        if (this.f374ms.isEmpty()) {
            return;
        }
        Iterator<d> it = this.f374ms.iterator();
        while (it.hasNext()) {
            it.next().ms(str);
        }
    }
}
