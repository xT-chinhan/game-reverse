package com.anythink.network.baidu.impression;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
final class b {
    static final int a = 50;
    private static int d = 1000;
    final ViewTreeObserver.OnPreDrawListener b;
    WeakReference<ViewTreeObserver> c;
    private final ArrayList<View> e;
    private long f;
    private final Map<View, a> g;
    private final C0122b h;
    private d i;
    private final c j;
    private final Handler k;
    private boolean l;

    interface d {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.l = false;
        return false;
    }

    static class a {
        int a;
        int b;
        long c;
        View d;
        Integer e;

        a() {
        }
    }

    public b(Context context) {
        this(context, new WeakHashMap(10), new C0122b(), new Handler(Looper.getMainLooper()));
    }

    public b(Context context, int i) {
        this(context, new WeakHashMap(10), new C0122b(), new Handler(Looper.getMainLooper()));
        d = i;
    }

    private b(Context context, Map<View, a> map, C0122b c0122b, Handler handler) {
        this.f = 0L;
        this.g = map;
        this.h = c0122b;
        this.k = handler;
        this.j = new c();
        this.e = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.network.baidu.impression.b.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                b.this.c();
                return true;
            }
        };
        this.c = new WeakReference<>(null);
        a(context, null);
    }

    private void a(Context context, View view) {
        View topmostView;
        ViewTreeObserver viewTreeObserver = this.c.get();
        if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (topmostView = BDViews.getTopmostView(context, view)) != null) {
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                this.c = new WeakReference<>(viewTreeObserver2);
                viewTreeObserver2.addOnPreDrawListener(this.b);
            }
        }
    }

    final void a(d dVar) {
        this.i = dVar;
    }

    private void a(View view, View view2, int i, Integer num) {
        a(view, view2, i, i, num);
    }

    final void a(View view, View view2, int i, int i2, Integer num) {
        try {
            a(view2.getContext(), view2);
            a aVar = this.g.get(view2);
            if (aVar == null) {
                aVar = new a();
                this.g.put(view2, aVar);
                c();
            }
            int iMin = Math.min(i2, i);
            aVar.d = view;
            aVar.a = i;
            aVar.b = iMin;
            aVar.c = this.f;
            aVar.e = num;
            long j = this.f + 1;
            this.f = j;
            if (j % 50 == 0) {
                a(j - 50);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(long j) {
        for (Map.Entry<View, a> entry : this.g.entrySet()) {
            if (entry.getValue().c < j) {
                this.e.add(entry.getKey());
            }
        }
        Iterator<View> it = this.e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.e.clear();
    }

    final void a(View view) {
        this.g.remove(view);
    }

    final void a() {
        this.g.clear();
        this.k.removeMessages(0);
        this.l = false;
    }

    final void b() {
        a();
        ViewTreeObserver viewTreeObserver = this.c.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.b);
        }
        this.c.clear();
        this.i = null;
    }

    final void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.postDelayed(this.j, d);
    }

    class c implements Runnable {
        private final ArrayList<View> c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(b.this);
            for (Map.Entry entry : b.this.g.entrySet()) {
                View view = (View) entry.getKey();
                int i = ((a) entry.getValue()).a;
                int i2 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).e;
                View view2 = ((a) entry.getValue()).d;
                if (!b.this.h.a(view2, view, i, num)) {
                    if (!b.this.h.a(view2, view, i2, null)) {
                        this.c.add(view);
                    }
                } else {
                    this.b.add(view);
                }
            }
            if (b.this.i != null) {
                b.this.i.onVisibilityChanged(this.b, this.c);
            }
            this.b.clear();
            this.c.clear();
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.impression.b$b, reason: collision with other inner class name */
    static class C0122b {
        private final Rect a = new Rect();

        C0122b() {
        }

        private static boolean a(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        final boolean a(View view, View view2, int i, Integer num) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWindowVisibility() != 0 || !view2.getGlobalVisibleRect(this.a)) {
                return false;
            }
            long jHeight = ((long) this.a.height()) * ((long) this.a.width());
            long height = ((long) view2.getHeight()) * ((long) view2.getWidth());
            if (height <= 0) {
                return false;
            }
            if (num == null || num.intValue() <= 0) {
                return jHeight * 100 >= ((long) i) * height;
            }
            return jHeight >= ((long) num.intValue());
        }
    }

    private void a(View view, int i, Integer num) {
        a(view, view, i, i, num);
    }
}
