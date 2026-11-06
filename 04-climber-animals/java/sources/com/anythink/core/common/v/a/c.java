package com.anythink.core.common.v.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int a = 1;
    public static final int b = 2;
    private final f c;
    private final Map<View, b> d;
    private final Map<View, d<b>> e;
    private final f.b f;
    private f.d g;

    public c(int i) {
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        f.b bVar = new f.b(i);
        f fVar = new f(i);
        new Handler(Looper.getMainLooper());
        this(weakHashMap, weakHashMap2, bVar, fVar);
    }

    public c(int i, int i2) {
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        f.b bVar = new f.b(i);
        f fVar = new f(i2, i);
        new Handler(Looper.getMainLooper());
        this(weakHashMap, weakHashMap2, bVar, fVar);
    }

    private c(Map<View, b> map, Map<View, d<b>> map2, f.b bVar, f fVar) {
        this.d = map;
        this.e = map2;
        this.f = bVar;
        this.c = fVar;
        f.d dVar = new f.d() { // from class: com.anythink.core.common.v.a.c.1
            @Override // com.anythink.core.common.v.a.f.d
            public final void a(List<View> list) {
                for (View view : list) {
                    b bVar2 = (b) c.this.d.get(view);
                    if (bVar2 == null) {
                        c.this.a(view);
                    } else {
                        bVar2.recordImpression(view);
                        bVar2.setImpressionRecorded();
                    }
                }
            }
        };
        this.g = dVar;
        fVar.a(dVar);
    }

    public final void a(View view, b bVar) {
        if (this.d.get(view) == bVar) {
            return;
        }
        a(view);
        if (bVar.isImpressionRecorded()) {
            return;
        }
        this.d.put(view, bVar);
        f fVar = this.c;
        int impressionMinPercentageViewed = bVar.getImpressionMinPercentageViewed();
        fVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bVar.getImpressionMinVisiblePx());
    }

    public final void a(View view) {
        this.d.remove(view);
        b(view);
        this.c.a(view);
    }

    public final void a() {
        this.d.clear();
        this.e.clear();
        this.c.a();
    }

    public final void b() {
        a();
        this.c.b();
        this.g = null;
    }

    private void b(View view) {
        this.e.remove(view);
    }

    @Deprecated
    private f.d c() {
        return this.g;
    }
}
