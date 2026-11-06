package com.smartdigimkt.b2;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.sdk.basead.ui.FullScreenATView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ p a;

    public l(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.e eVar;
        p pVar = this.a;
        BaseIncentiveTaskView baseIncentiveTaskViewA = pVar.a();
        pVar.j = baseIncentiveTaskViewA;
        if (baseIncentiveTaskViewA != null) {
            pVar.l = System.currentTimeMillis();
            pVar.j.initSetting(pVar.b, pVar.c.s, pVar.k, new n(pVar));
            ViewGroup viewGroup = pVar.d;
            if (viewGroup == null) {
                viewGroup = pVar.f;
            }
            if (viewGroup != null) {
                viewGroup.addView(pVar.j, new RelativeLayout.LayoutParams(-1, -1));
                pVar.j.bringToFront();
                e eVar2 = pVar.h;
                if (eVar2 instanceof y2) {
                    y2 y2Var = (y2) eVar2;
                    com.smartdigimkt.u1.d dVar = y2Var.a.n;
                    if (dVar != null) {
                        dVar.s = false;
                        dVar.b();
                    }
                    com.smartdigimkt.a3.a aVar = pVar.c;
                    if (aVar == null || (eVar = aVar.s) == null || !com.smartdigimkt.b3.h.a(eVar.R1)) {
                        return;
                    }
                    FullScreenATView fullScreenATView = y2Var.a;
                    String str = FullScreenATView.TAG;
                    fullScreenATView.U();
                }
            }
        }
    }
}
