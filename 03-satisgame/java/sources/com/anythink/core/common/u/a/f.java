package com.anythink.core.common.u.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static String c = "f";
    final int a;
    final ViewTreeObserver.OnPreDrawListener b;
    private int d;
    private final ArrayList<View> e;
    private long f;
    private final Map<View, a> g;
    private final b h;
    private d i;
    private final c j;
    private final Handler k;
    private boolean l;

    interface d {
        void a(List<View> list);
    }

    static /* synthetic */ boolean d(f fVar) {
        fVar.l = false;
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

    public f(int i) {
        this(new WeakHashMap(10), new b(i), new Handler(Looper.getMainLooper()));
    }

    public f() {
        this(new WeakHashMap(10), new b(1), new Handler(Looper.getMainLooper()));
        this.d = 50;
    }

    private f(Map<View, a> map, b bVar, Handler handler) {
        this.d = 100;
        this.a = 50;
        this.f = 0L;
        this.g = map;
        this.h = bVar;
        this.k = handler;
        this.j = new c();
        this.e = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.core.common.u.a.f.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                f.this.c();
                return true;
            }
        };
    }

    final void a(d dVar) {
        this.i = dVar;
    }

    private void a(View view, View view2, int i, Integer num) {
        a(view, view2, i, i, num);
    }

    final void a(View view, View view2, int i, int i2, Integer num) {
        try {
            if (a(view2.getContext(), view2)) {
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
                view2.getViewTreeObserver().addOnPreDrawListener(this.b);
                long j = this.f + 1;
                this.f = j;
                if (j % 50 == 0) {
                    a(j - 50);
                }
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
        this.i = null;
    }

    final void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.postDelayed(this.j, this.d);
    }

    class c implements Runnable {
        private final ArrayList<View> c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : f.this.g.entrySet()) {
                View view = (View) entry.getKey();
                int i = ((a) entry.getValue()).a;
                int i2 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).e;
                View view2 = ((a) entry.getValue()).d;
                if (!f.this.h.a(view2, view, i, num)) {
                    if (!f.this.h.a(view2, view, i2, null)) {
                        this.c.add(view);
                    }
                } else {
                    this.b.add(view);
                    try {
                        view.getViewTreeObserver().removeOnPreDrawListener(f.this.b);
                    } catch (Throwable unused) {
                    }
                }
            }
            if (f.this.i != null) {
                f.this.i.a(this.b);
            }
            this.b.clear();
            this.c.clear();
            f.d(f.this);
        }
    }

    public static class b {
        private static String a = "b";
        private final Rect b;
        private int c;

        b() {
            this.b = new Rect();
            this.c = 1;
        }

        public b(int i) {
            this.b = new Rect();
            this.c = i;
        }

        private static boolean a(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        public final boolean a(View view, View view2, int i, Integer num) {
            if (view2 != null && view != null) {
                try {
                    if (view.getParent() != null && view2.getWindowVisibility() == 0) {
                        if ((this.c == 1 && !view2.hasWindowFocus()) || !view2.getGlobalVisibleRect(this.b)) {
                            return false;
                        }
                        long jHeight = ((long) this.b.height()) * ((long) this.b.width());
                        long height = ((long) view2.getHeight()) * ((long) view2.getWidth());
                        if (height <= 0) {
                            return false;
                        }
                        if ((num == null || num.intValue() <= 0 || jHeight >= num.intValue()) && jHeight * 100 >= ((long) i) * height) {
                            return view2.isShown();
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    Log.e(a, "checkVisibilityPercent error: " + th.getMessage());
                    th.printStackTrace();
                }
            }
            return false;
        }

        private static int a(View view) {
            Rect rect = new Rect();
            try {
                view.getGlobalVisibleRect(rect);
                return (int) ((((((long) rect.height()) * ((long) rect.width())) * 1.0d) / (((long) view.getHeight()) * ((long) view.getWidth()))) * 100.0d);
            } catch (Throwable unused) {
                return 100;
            }
        }
    }

    private static boolean a(Context context, View view) {
        View rootView;
        View viewFindViewById = null;
        View viewFindViewById2 = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        if (view != null && (rootView = view.getRootView()) != null && (viewFindViewById = rootView.findViewById(R.id.content)) == null) {
            viewFindViewById = rootView;
        }
        if (viewFindViewById2 == null) {
            viewFindViewById2 = viewFindViewById;
        }
        return viewFindViewById2 != null && viewFindViewById2.getViewTreeObserver().isAlive();
    }

    private void a(View view, int i, Integer num) {
        a(view, view, i, i, num);
    }
}
