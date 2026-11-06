package com.smartdigimkt.y1;

import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;
    public final /* synthetic */ e0 c;

    public c0(e0 e0Var, int i, BaseG2CV2View baseG2CV2View) {
        this.c = e0Var;
        this.a = i;
        this.b = baseG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        Object obj;
        b bVar2;
        Object obj2;
        if (this.a != 11) {
            RelativeLayout relativeLayout = this.c.d;
            if (relativeLayout != null && ((relativeLayout.getMeasuredHeight() < 100 || this.c.d.getMeasuredWidth() < 200) && (bVar2 = this.c.h) != null)) {
                n nVar = (n) bVar2;
                Map map = nVar.a.j;
                if (map != null && (obj2 = map.get("native_ad_event_listener")) != null && (obj2 instanceof com.smartdigimkt.j1.u)) {
                    ((com.smartdigimkt.j1.u) obj2).a(2);
                }
                o oVar = nVar.a;
                e0 e0Var = oVar.h;
                if (e0Var != null) {
                    e0Var.a();
                }
                oVar.a();
                ConcurrentLinkedQueue concurrentLinkedQueue = oVar.g;
                if (concurrentLinkedQueue != null) {
                    concurrentLinkedQueue.clear();
                    return;
                }
                return;
            }
        } else {
            RelativeLayout relativeLayout2 = this.c.d;
            if (relativeLayout2 != null && ((relativeLayout2.getMeasuredHeight() < com.smartdigimkt.r4.k.a(this.c.d.getContext(), 180.0f) || this.c.d.getMeasuredWidth() < com.smartdigimkt.r4.k.a(this.c.d.getContext(), 50.0f)) && (bVar = this.c.h) != null)) {
                n nVar2 = (n) bVar;
                Map map2 = nVar2.a.j;
                if (map2 != null && (obj = map2.get("native_ad_event_listener")) != null && (obj instanceof com.smartdigimkt.j1.u)) {
                    ((com.smartdigimkt.j1.u) obj).a(2);
                }
                o oVar2 = nVar2.a;
                e0 e0Var2 = oVar2.h;
                if (e0Var2 != null) {
                    e0Var2.a();
                }
                oVar2.a();
                ConcurrentLinkedQueue concurrentLinkedQueue2 = oVar2.g;
                if (concurrentLinkedQueue2 != null) {
                    concurrentLinkedQueue2.clear();
                    return;
                }
                return;
            }
        }
        this.b.setVisibility(0);
    }
}
