package com.tapsdk.tapad.internal.m;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tapsdk.tapad.internal.feed.views.FeedAdVideoView;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class d<T> {
    private static final long j = 300;
    private static final long k = 300;
    private f b;
    private volatile boolean c;
    private final Handler e;
    private final C0624d f;
    private final d<T>.e g;
    private final ViewTreeObserver h;
    private final ViewTreeObserver.OnPreDrawListener i;
    private final Map<View, c<T>> a = new WeakHashMap();
    private long d = -1;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.c();
            return true;
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static class c<T> {
        public View a;
        public FeedAdVideoView b;
        int c;
        public final T d;
        public b e;

        public c(T t) {
            this.d = t;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a == this.a && cVar.d.equals(this.d);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.d);
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.m.d$d, reason: collision with other inner class name */
    static class C0624d {
        private final Rect a = new Rect();
        private final b b = new b(0, 0, 0);

        C0624d() {
        }

        com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, b> a(View view, int i) {
            if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.hasWindowFocus()) {
                return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.FALSE, this.b);
            }
            if (!view.getGlobalVisibleRect(this.a)) {
                return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.FALSE, this.b);
            }
            long jHeight = ((long) this.a.height()) * ((long) this.a.width());
            long height = ((long) view.getHeight()) * ((long) view.getWidth());
            if (!(height > 0 && 100 * jHeight >= ((long) i) * height)) {
                return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.FALSE, this.b);
            }
            int i2 = (int) ((jHeight * 1.0f) / height);
            Boolean bool = Boolean.TRUE;
            Rect rect = this.a;
            return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(bool, new b(i2, rect.left, rect.top));
        }
    }

    class e implements Runnable {
        private final Set<c<?>> a = new HashSet();
        private final Set<c<?>> b = new HashSet();

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Set<c<?>> set;
            for (Map.Entry entry : d.this.a.entrySet()) {
                View view = (View) entry.getKey();
                c<?> cVar = (c) entry.getValue();
                com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, b> aVarA = d.this.f.a(view, cVar.c);
                if (aVarA.a.booleanValue()) {
                    cVar.e = aVarA.b;
                    set = this.a;
                } else {
                    set = this.b;
                }
                set.add(cVar);
            }
            if (d.this.b != null) {
                d.this.b.a(this.a, this.b);
            }
            this.a.clear();
            this.b.clear();
            d.this.c = false;
        }
    }

    public interface f {
        void a(Set<c<?>> set, Set<c<?>> set2);
    }

    public d(Activity activity) {
        ViewTreeObserver viewTreeObserver = activity.getWindow().getDecorView().getViewTreeObserver();
        this.h = viewTreeObserver;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new C0624d();
        this.g = new e();
        if (!viewTreeObserver.isAlive()) {
            this.i = null;
            Log.d("d", "Visibility tracker root view is not alive");
        } else {
            a aVar = new a();
            this.i = aVar;
            viewTreeObserver.addOnPreDrawListener(aVar);
        }
    }

    public void a() {
        ViewTreeObserver viewTreeObserver;
        if (this.i != null && (viewTreeObserver = this.h) != null && viewTreeObserver.isAlive()) {
            this.h.removeOnPreDrawListener(this.i);
        }
        this.e.removeCallbacksAndMessages(null);
    }

    public void a(View view) {
        this.a.remove(view);
    }

    public void a(View view, T t, int i) {
        c<T> cVar = new c<>(t);
        a(view);
        cVar.a = view;
        cVar.c = i;
        this.a.put(view, cVar);
        c();
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    public void b() {
        this.b = null;
    }

    public void c() {
        if (this.c || this.a.size() == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.d;
        if (j2 == -1 || jCurrentTimeMillis - j2 > 300) {
            this.c = true;
            this.e.postDelayed(this.g, 300L);
            this.d = jCurrentTimeMillis;
        }
    }
}
