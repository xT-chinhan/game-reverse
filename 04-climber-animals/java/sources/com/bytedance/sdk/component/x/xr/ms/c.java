package com.bytedance.sdk.component.x.xr.ms;

import com.bytedance.sdk.component.x.xr.ms.xr.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<com.bytedance.sdk.component.x.xr.ms.xr.ms> f1560ms = new ArrayList();

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, String str) {
        return null;
    }

    public c(Queue<String> queue, com.bytedance.sdk.component.x.ms.ka kaVar) {
        com.bytedance.sdk.component.x.xr.d.xr.ms msVarX;
        if (com.bytedance.sdk.component.x.xr.xr.ms.ms(kaVar)) {
            this.f1560ms.add(new com.bytedance.sdk.component.x.xr.ms.xr.ah(kaVar.ab(), queue, kaVar));
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.ka(kaVar)) {
            if (kaVar.ms() != null) {
                msVarX = kaVar.ms();
            } else {
                msVarX = kaVar.x();
            }
            this.f1560ms.add(new com.bytedance.sdk.component.x.xr.ms.xr.d(msVarX, queue, kaVar));
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.xr(kaVar)) {
            this.f1560ms.add(new com.bytedance.sdk.component.x.xr.ms.xr.ka(kaVar.x(), queue, kaVar));
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.ah(kaVar)) {
            this.f1560ms.add(new com.bytedance.sdk.component.x.xr.ms.xr.c(kaVar.x(), queue, kaVar));
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.d(kaVar)) {
            this.f1560ms.add(new com.bytedance.sdk.component.x.xr.ms.xr.xr(kaVar.ny(), queue, kaVar));
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.c(kaVar)) {
            this.f1560ms.add(new ab(kaVar.c(), queue, kaVar));
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.xr.ms> it = this.f1560ms.iterator();
        while (it.hasNext()) {
            it.next().xr(xrVar);
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public xr ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list, int i2) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.xr.ms> it = this.f1560ms.iterator();
        xr xrVarMs = null;
        while (it.hasNext()) {
            xrVarMs = it.next().ms(i, list, i2);
            if (xrVarMs.ms()) {
                break;
            }
        }
        return xrVarMs;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.xr.ms> it = this.f1560ms.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.x.ms.xr> listMs = it.next().ms(i, xrVar, z, list, "get");
            if (listMs != null && listMs.size() != 0) {
                return listMs;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public boolean ms(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.xr.ms> it = this.f1560ms.iterator();
        while (it.hasNext()) {
            if (it.next().ms(i, str, xrVar)) {
                return true;
            }
        }
        return false;
    }
}
