package com.smartdigimkt.p3;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final n a;
    public final Map b;
    public final Map c;

    public i(int i, int i2) {
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        new l(i);
        n nVar = new n(i2, i);
        new Handler(Looper.getMainLooper());
        this.b = weakHashMap;
        this.c = weakHashMap2;
        this.a = nVar;
        nVar.g = new h(this);
    }

    public final void a(View view, a aVar) {
        if (this.b.get(view) == aVar) {
            return;
        }
        this.b.remove(view);
        this.c.remove(view);
        this.a.e.remove(view);
        if (aVar.a) {
            return;
        }
        this.b.put(view, aVar);
        n nVar = this.a;
        int iA = aVar.a();
        nVar.getClass();
        try {
            Context context = view.getContext();
            View viewFindViewById = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
            View rootView = view.getRootView();
            if (rootView == null) {
                rootView = null;
            } else {
                View viewFindViewById2 = rootView.findViewById(R.id.content);
                if (viewFindViewById2 != null) {
                    rootView = viewFindViewById2;
                }
            }
            if (viewFindViewById == null) {
                viewFindViewById = rootView;
            }
            if (viewFindViewById != null && viewFindViewById.getViewTreeObserver().isAlive()) {
                k kVar = (k) nVar.e.get(view);
                if (kVar == null) {
                    kVar = new k();
                    nVar.e.put(view, kVar);
                    if (!nVar.j) {
                        nVar.j = true;
                        nVar.i.postDelayed(nVar.h, nVar.a);
                    }
                }
                int iMin = Math.min(iA, iA);
                kVar.d = view;
                kVar.a = iA;
                kVar.b = iMin;
                kVar.c = nVar.c;
                kVar.e = null;
                view.getViewTreeObserver().addOnPreDrawListener(nVar.d);
                long j = nVar.c;
                long j2 = 1 + j;
                nVar.c = j2;
                if (j2 % 50 == 0) {
                    nVar.a(j - 49);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.b.clear();
        this.c.clear();
        n nVar = this.a;
        nVar.e.clear();
        nVar.i.removeMessages(0);
        nVar.j = false;
        n nVar2 = this.a;
        nVar2.e.clear();
        nVar2.i.removeMessages(0);
        nVar2.j = false;
        nVar2.i.removeCallbacks(nVar2.h);
        nVar2.j = false;
        nVar2.g = null;
    }
}
