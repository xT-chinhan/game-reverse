package com.smartdigimkt.e1;

import android.view.InflateException;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ j b;

    public i(j jVar, ViewGroup viewGroup) {
        this.b = jVar;
        this.a = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, Object> map = this.b.h;
        if (map == null) {
            map = new HashMap<>(2);
        }
        j jVar = this.b;
        com.smartdigimkt.g1.c cVar = jVar.i;
        ViewGroup viewGroup = this.a;
        boolean z = jVar.p;
        cVar.getClass();
        try {
            cVar.a(viewGroup);
            cVar.d.setAdExtraInfoMap(map);
            cVar.d.setDontCountDown(z);
            viewGroup.addView(cVar.d, -1, -1);
        } catch (InflateException e) {
            cVar.d = null;
            cVar.a = null;
            if (cVar.b.a != null) {
                cVar.b.a.c();
            }
            com.smartdigimkt.j1.a aVar = cVar.c;
            if (aVar != null) {
                aVar.onShowFailed(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Splash view inflation failed: " + e));
            }
        }
    }
}
