package com.tapsdk.tapad.internal.tracker;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, View.OnAttachStateChangeListener, com.tapsdk.tapad.internal.tracker.a {
    private final WeakReference<View> a;
    private ExposureTrackerObject b;
    private ExecutorService e;
    private final InterfaceC0634b f;
    private boolean g;
    boolean c = false;
    boolean d = false;
    private int h = 0;
    private int i = 0;

    public class a implements Runnable {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.a);
                if (b.this.c) {
                    Rect rect = new Rect();
                    if (b.this.d) {
                        return;
                    }
                    b.this.b(rect);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.tracker.b$b, reason: collision with other inner class name */
    public interface InterfaceC0634b {
        void a();
    }

    public b(View view, InterfaceC0634b interfaceC0634b) {
        this.g = false;
        this.a = new WeakReference<>(view);
        this.f = interfaceC0634b;
        if (view == null) {
            return;
        }
        view.addOnAttachStateChangeListener(this);
        this.g = view.isAttachedToWindow();
        f();
    }

    private synchronized void a(long j) {
        try {
            if (!this.d && this.g && this.c && this.a.get() != null) {
                this.e.execute(new a(j));
            }
        } catch (Exception unused) {
        }
    }

    private synchronized boolean a(Rect rect) {
        int i;
        View view = this.a.get();
        if (view == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap();
        if (this.b.h) {
            int iA = p.a(view.getContext());
            int i2 = iA != 0 ? (this.h * 100) / iA : 100;
            if (i2 < this.b.o) {
                map.put("screen_area_percent", String.valueOf(i2));
                this.b.a(map);
                return false;
            }
        }
        if (this.b.i) {
            int width = view.getWidth() * view.getHeight();
            int i3 = width != 0 ? (this.h * 100) / width : 100;
            if (i3 < this.b.p) {
                map.put("ad_area_percent", String.valueOf(i3));
                this.b.a(map);
                return false;
            }
        }
        ExposureTrackerObject exposureTrackerObject = this.b;
        if (exposureTrackerObject.j && (i = this.i) < exposureTrackerObject.q) {
            map.put("ad_width_pixel", String.valueOf(i));
            this.b.a(map);
            return false;
        }
        ExposureTrackerObject exposureTrackerObject2 = this.b;
        long j = -1;
        if (exposureTrackerObject2.k) {
            long j2 = exposureTrackerObject2.v;
            long j3 = jCurrentTimeMillis - j2;
            if (j2 == 0 || j3 < exposureTrackerObject2.r) {
                if (this.b.v != 0) {
                    j = j3;
                }
                map.put("image_display_milliseconds", String.valueOf(j));
                this.b.a(map);
                return false;
            }
        }
        ExposureTrackerObject exposureTrackerObject3 = this.b;
        if (exposureTrackerObject3.m) {
            long j4 = exposureTrackerObject3.w;
            long j5 = jCurrentTimeMillis - j4;
            if (j4 == 0 || j5 < exposureTrackerObject3.t) {
                if (this.b.w != 0) {
                    j = j5;
                }
                map.put("video_play_milliseconds", String.valueOf(j));
                this.b.a(map);
                return false;
            }
        }
        ExposureTrackerObject exposureTrackerObject4 = this.b;
        if (exposureTrackerObject4.l) {
            long j6 = jCurrentTimeMillis - exposureTrackerObject4.u;
            long j7 = exposureTrackerObject4.s;
            if (j6 < j7) {
                a(j7);
                map.put("ad_display_milliseconds", String.valueOf(j6));
                this.b.a(map);
                return false;
            }
        }
        if (!this.d) {
            TapADLogger.i("exposure v2: valid exposure");
            this.b.c(this.a.get());
        }
        this.d = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Rect rect) {
        View view = this.a.get();
        if (view == null) {
            return;
        }
        if (this.g) {
            if (view.getGlobalVisibleRect(rect)) {
                Rect rect2 = new Rect();
                if (!p.a(view.getContext(), rect2) || rect.intersect(rect2)) {
                    this.h = rect.width() * rect.height();
                    this.i = rect.width();
                    if (a(rect)) {
                        InterfaceC0634b interfaceC0634b = this.f;
                        if (interfaceC0634b != null) {
                            interfaceC0634b.a();
                        }
                        e();
                    } else {
                        a(this.b.y);
                    }
                }
            }
        }
    }

    private void c() {
        boolean z = this.c;
        if (z && this.d) {
            return;
        }
        if (!z) {
            this.c = true;
            this.b.b(this.a.get());
            this.b.a();
            TapADLogger.i("exposure v2: origin exposure");
        }
        if (!this.c || this.d) {
            return;
        }
        a(this.b.y);
    }

    private synchronized void f() {
        ExposureTrackerObject exposureTrackerObject = this.b;
        if (exposureTrackerObject != null && exposureTrackerObject.a) {
            if (this.g) {
                View view = this.a.get();
                if (view == null) {
                    return;
                }
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                view.getViewTreeObserver().addOnScrollChangedListener(this);
                ExecutorService executorService = this.e;
                if (executorService == null || executorService.isShutdown()) {
                    this.e = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new ThreadPoolExecutor.DiscardPolicy());
                }
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.tracker.a
    public void a() {
        ExposureTrackerObject exposureTrackerObject = this.b;
        if (exposureTrackerObject != null && exposureTrackerObject.a && exposureTrackerObject.c()) {
            ExposureTrackerObject exposureTrackerObject2 = this.b;
            if (exposureTrackerObject2.t == 0) {
                a(exposureTrackerObject2.y);
            }
            a(this.b.t);
        }
    }

    @Override // com.tapsdk.tapad.internal.tracker.a
    public void a(ExposureTrackerObject exposureTrackerObject) {
        this.b = exposureTrackerObject;
        if (exposureTrackerObject == null) {
            return;
        }
        f();
    }

    @Override // com.tapsdk.tapad.internal.tracker.a
    public void b() {
        ExposureTrackerObject exposureTrackerObject = this.b;
        if (exposureTrackerObject != null && exposureTrackerObject.a && exposureTrackerObject.b()) {
            ExposureTrackerObject exposureTrackerObject2 = this.b;
            if (exposureTrackerObject2.r == 0) {
                a(exposureTrackerObject2.y);
            }
            a(this.b.r);
        }
    }

    public void d() {
        e();
    }

    public synchronized void e() {
        ExecutorService executorService = this.e;
        if (executorService != null && !executorService.isShutdown()) {
            this.e.shutdownNow();
        }
        View view = this.a.get();
        if (view != null) {
            view.removeOnAttachStateChangeListener(this);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            view.getViewTreeObserver().removeOnScrollChangedListener(this);
        }
        ExposureTrackerObject exposureTrackerObject = this.b;
        if (exposureTrackerObject != null) {
            exposureTrackerObject.d();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.g = true;
        f();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        e();
    }
}
