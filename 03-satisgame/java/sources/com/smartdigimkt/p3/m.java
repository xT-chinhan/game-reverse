package com.smartdigimkt.p3;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ n c;
    public final ArrayList b = new ArrayList();
    public final ArrayList a = new ArrayList();

    public m(n nVar) {
        this.c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (Map.Entry entry : this.c.e.entrySet()) {
            View view = (View) entry.getKey();
            int i = ((k) entry.getValue()).a;
            int i2 = ((k) entry.getValue()).b;
            Integer num = ((k) entry.getValue()).e;
            View view2 = ((k) entry.getValue()).d;
            if (this.c.f.a(view2, view, i, num)) {
                this.a.add(view);
                try {
                    view.getViewTreeObserver().removeOnPreDrawListener(this.c.d);
                } catch (Throwable unused) {
                }
            } else if (!this.c.f.a(view2, view, i2, null)) {
                this.b.add(view);
            }
        }
        h hVar = this.c.g;
        if (hVar != null) {
            for (View view3 : this.a) {
                a aVar = (a) hVar.a.b.get(view3);
                if (aVar == null) {
                    i iVar = hVar.a;
                    iVar.b.remove(view3);
                    iVar.c.remove(view3);
                    iVar.a.e.remove(view3);
                } else {
                    aVar.b();
                    aVar.a = true;
                }
            }
        }
        this.a.clear();
        this.b.clear();
        this.c.j = false;
    }
}
