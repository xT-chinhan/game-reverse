package com.bytedance.sdk.component.c.d;

import com.bytedance.sdk.component.c.ao;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class zb<T> extends ms {
    private boolean ah;
    private byte[] d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private T f1189ms;
    private com.bytedance.sdk.component.c.c xr;

    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "success";
    }

    public zb(T t, byte[] bArr, com.bytedance.sdk.component.c.c cVar, boolean z) {
        this.f1189ms = t;
        this.xr = cVar;
        this.ah = z;
        this.d = bArr;
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        String strI = ahVar.i();
        Map<String, List<com.bytedance.sdk.component.c.ah.ah>> mapAb = ahVar.t().ab();
        List<com.bytedance.sdk.component.c.ah.ah> list = mapAb.get(strI);
        if (list == null) {
            xr(ahVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.c.ah.ah> it = list.iterator();
            while (it.hasNext()) {
                xr(it.next());
            }
            list.clear();
            mapAb.remove(strI);
        }
    }

    private Map<String, String> xr() {
        com.bytedance.sdk.component.c.c cVar = this.xr;
        if (cVar != null) {
            return cVar.ka();
        }
        return null;
    }

    private void xr(com.bytedance.sdk.component.c.ah.ah ahVar) {
        ao aoVarHi = ahVar.hi();
        int iZb = ahVar.zb();
        if (aoVarHi != null) {
            T t = this.f1189ms;
            if (iZb == 3) {
                com.bytedance.sdk.component.c.xr xrVarNw = ahVar.nw();
                if (this.d == null && xrVarNw.ab()) {
                    this.d = ahVar.t().xr(xrVarNw).ms(ahVar.c());
                }
                T t2 = (T) this.d;
                if (t2 == null) {
                    t2 = this.f1189ms;
                }
                t = (T) t2;
                if (!(t instanceof byte[])) {
                    aoVarHi.ms(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (iZb == 2 && (t instanceof byte[])) {
                try {
                    t = (T) ahVar.t().ms(ahVar).ms((byte[]) t);
                } catch (Throwable th) {
                    aoVarHi.ms(2000, "decode failed", th);
                    return;
                }
            }
            aoVarHi.ms(new com.bytedance.sdk.component.c.ah.d().ms(ahVar, t, xr(), this.ah));
        }
    }
}
