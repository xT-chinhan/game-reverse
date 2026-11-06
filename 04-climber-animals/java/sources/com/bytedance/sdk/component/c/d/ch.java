package com.bytedance.sdk.component.c.d;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.c.qv;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        Bitmap bitmapXr;
        int iZb = ahVar.zb();
        if (iZb != 2 && iZb != 1) {
            bitmapXr = null;
        } else if (ahVar.b() || ahVar.nw().c()) {
            bitmapXr = xr(ahVar);
        } else {
            bitmapXr = ah(ahVar);
        }
        if (bitmapXr == null) {
            if (ahVar.nw().ab()) {
                ahVar.ms(new sl());
                return;
            } else {
                ahVar.ms(new c());
                return;
            }
        }
        ahVar.ms(new zb(bitmapXr, null, null, false));
    }

    private Bitmap xr(com.bytedance.sdk.component.c.ah.ah ahVar) {
        Collection<qv> collectionMs = ahVar.t().ms();
        Bitmap bitmapMs = null;
        if (collectionMs == null) {
            return null;
        }
        Iterator<qv> it = collectionMs.iterator();
        while (it.hasNext() && (bitmapMs = it.next().ms(ahVar.ab())) == null) {
        }
        return bitmapMs;
    }

    private Bitmap ah(com.bytedance.sdk.component.c.ah.ah ahVar) {
        return ahVar.t().ms(ahVar.nw()).ms(ahVar.ab());
    }
}
