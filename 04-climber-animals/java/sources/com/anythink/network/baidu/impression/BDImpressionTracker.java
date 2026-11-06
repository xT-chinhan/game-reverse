package com.anythink.network.baidu.impression;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BDImpressionTracker {
    private static final int a = 100;
    private final b b;
    private final Map<View, BDImpressionInterface> c;
    private final Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> d;
    private final Handler e;
    private final a f;
    private final b.C0122b g;
    private b.d h;

    public BDImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0122b(), new b(context), new Handler(Looper.getMainLooper()));
    }

    public BDImpressionTracker(Context context, int i) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0122b(), new b(context, i), new Handler(Looper.getMainLooper()));
    }

    private BDImpressionTracker(Map<View, BDImpressionInterface> map, Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> map2, b.C0122b c0122b, b bVar, Handler handler) {
        this.c = map;
        this.d = map2;
        this.g = c0122b;
        this.b = bVar;
        b.d dVar = new b.d() { // from class: com.anythink.network.baidu.impression.BDImpressionTracker.1
            @Override // com.anythink.network.baidu.impression.b.d
            public final void onVisibilityChanged(List<View> list, List<View> list2) {
                for (View view : list) {
                    BDImpressionInterface bDImpressionInterface = (BDImpressionInterface) BDImpressionTracker.this.c.get(view);
                    if (bDImpressionInterface != null) {
                        com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) BDImpressionTracker.this.d.get(view);
                        if (aVar == null || !bDImpressionInterface.equals(aVar.a)) {
                            BDImpressionTracker.this.d.put(view, new com.anythink.network.baidu.impression.a(bDImpressionInterface));
                        }
                    } else {
                        BDImpressionTracker.this.removeView(view);
                    }
                }
                Iterator<View> it = list2.iterator();
                while (it.hasNext()) {
                    BDImpressionTracker.this.d.remove(it.next());
                }
                BDImpressionTracker.this.a();
            }
        };
        this.h = dVar;
        bVar.a(dVar);
        this.e = handler;
        this.f = new a();
    }

    public void addView(View view, BDImpressionInterface bDImpressionInterface) {
        if (this.c.get(view) == bDImpressionInterface) {
            return;
        }
        removeView(view);
        if (bDImpressionInterface.isImpressionRecorded()) {
            return;
        }
        this.c.put(view, bDImpressionInterface);
        b bVar = this.b;
        int impressionMinPercentageViewed = bDImpressionInterface.getImpressionMinPercentageViewed();
        bVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bDImpressionInterface.getImpressionMinVisiblePx());
    }

    public void removeView(View view) {
        this.c.remove(view);
        this.d.remove(view);
        this.b.a(view);
    }

    public void clear() {
        this.c.clear();
        this.d.clear();
        this.b.a();
        this.e.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.b.b();
        this.h = null;
    }

    final void a() {
        if (this.e.hasMessages(0)) {
            return;
        }
        this.e.postDelayed(this.f, 100L);
    }

    private void a(View view) {
        this.d.remove(view);
    }

    class a implements Runnable {
        private final ArrayList<View> b = new ArrayList<>();

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : BDImpressionTracker.this.d.entrySet()) {
                View view = (View) entry.getKey();
                com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) entry.getValue();
                b.C0122b unused = BDImpressionTracker.this.g;
                if (SystemClock.uptimeMillis() - aVar.b >= ((long) ((BDImpressionInterface) aVar.a).getImpressionMinTimeViewed())) {
                    ((BDImpressionInterface) aVar.a).recordImpression(view);
                    ((BDImpressionInterface) aVar.a).setImpressionRecorded();
                    this.b.add(view);
                }
            }
            Iterator<View> it = this.b.iterator();
            while (it.hasNext()) {
                BDImpressionTracker.this.removeView(it.next());
            }
            this.b.clear();
            if (BDImpressionTracker.this.d.isEmpty()) {
                return;
            }
            BDImpressionTracker.this.a();
        }
    }

    @Deprecated
    private b.d b() {
        return this.h;
    }
}
