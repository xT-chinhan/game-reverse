package com.bytedance.sdk.component.x.xr.ms;

import android.content.Context;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.xr.ms.ms.xr.ab;
import com.bytedance.sdk.component.x.xr.ms.ms.xr.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ka {
    private com.bytedance.sdk.component.x.xr.d.xr.ms ab;
    private com.bytedance.sdk.component.x.xr.ms.ms.xr.ka ah;
    private x c;
    private com.bytedance.sdk.component.x.xr.d.xr.ms ch;
    private ab d;
    private com.bytedance.sdk.component.x.xr.d.xr.ms hi;
    private com.bytedance.sdk.component.x.xr.ms.ms.xr.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.x.xr.ms.ms.xr.d f1561ms;
    private com.bytedance.sdk.component.x.xr.d.xr.ms ny;
    private com.bytedance.sdk.component.x.xr.d.xr.ms sl;
    private List<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> u = new ArrayList();
    private com.bytedance.sdk.component.x.xr.d.xr.ms x;
    private com.bytedance.sdk.component.x.xr.ms.ms.xr.c xr;
    private com.bytedance.sdk.component.x.ms.ka zb;

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, String str) {
        return null;
    }

    public d(com.bytedance.sdk.component.x.ms.ka kaVar) {
        this.zb = kaVar;
        Context context = kaVar.getContext();
        if (com.bytedance.sdk.component.x.xr.xr.ms.ms(kaVar)) {
            this.ab = this.zb.ab();
            com.bytedance.sdk.component.x.xr.ms.ms.xr.d dVar = new com.bytedance.sdk.component.x.xr.ms.ms.xr.d(context, this.ab, this.zb);
            this.f1561ms = dVar;
            this.u.add(dVar);
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.ka(kaVar)) {
            if (this.zb.ms() != null) {
                this.ny = this.zb.ms();
            } else {
                this.ny = this.zb.x();
            }
            com.bytedance.sdk.component.x.xr.ms.ms.xr.ka kaVar2 = new com.bytedance.sdk.component.x.xr.ms.ms.xr.ka(context, this.ny, this.zb);
            this.ah = kaVar2;
            this.u.add(kaVar2);
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.xr(kaVar)) {
            this.x = this.zb.x();
            com.bytedance.sdk.component.x.xr.ms.ms.xr.c cVar = new com.bytedance.sdk.component.x.xr.ms.ms.xr.c(context, this.x, this.zb);
            this.xr = cVar;
            this.u.add(cVar);
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.ah(kaVar)) {
            this.ch = this.zb.x();
            ab abVar = new ab(context, this.ch, this.zb);
            this.d = abVar;
            this.u.add(abVar);
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.d(kaVar)) {
            this.hi = this.zb.ny();
            com.bytedance.sdk.component.x.xr.ms.ms.xr.ms msVar = new com.bytedance.sdk.component.x.xr.ms.ms.xr.ms(context, this.hi, this.zb);
            this.ka = msVar;
            this.u.add(msVar);
        }
        if (com.bytedance.sdk.component.x.xr.xr.ms.c(kaVar)) {
            this.sl = this.zb.c();
            x xVar = new x(context, this.sl, this.zb);
            this.c = xVar;
            this.u.add(xVar);
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        try {
            xrVar.xr(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> it = this.u.iterator();
            while (it.hasNext()) {
                it.next().xr(xrVar);
            }
        } catch (Throwable th) {
            sl.ms(th);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ms(), 1, this.zb);
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public xr ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list, int i2) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> it = this.u.iterator();
        xr xrVarMs = null;
        while (it.hasNext()) {
            xrVarMs = it.next().ms(i, list);
            if (xrVarMs.ms()) {
                break;
            }
        }
        return xrVarMs;
    }

    public List<com.bytedance.sdk.component.x.ms.xr> ms(com.bytedance.sdk.component.x.ms.xr xrVar, int i, int i2, boolean z) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> it = this.u.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.x.ms.xr> listMs = it.next().ms(i2, i, xrVar, z);
            if (listMs != null && listMs.size() != 0) {
                return listMs;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> it = this.u.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.x.ms.xr> listMs = it.next().ms(i, xrVar, z, list, "db");
            if (listMs != null && listMs.size() != 0) {
                return listMs;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public boolean ms(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        Iterator<com.bytedance.sdk.component.x.xr.ms.ms.xr.xr> it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next().ms(i, str, xrVar)) {
                return true;
            }
        }
        return false;
    }
}
