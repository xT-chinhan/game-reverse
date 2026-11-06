package com.smartdigimkt.p3;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.smartdigimkt.sdk.core.SDKContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable, View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener, ViewTreeObserver.OnWindowFocusChangeListener {
    public final com.smartdigimkt.a3.a b;
    public final com.smartdigimkt.b3.c c;
    public final com.smartdigimkt.f3.a d;
    public final g e;
    public volatile boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Rect f = new Rect();
    public final long g = SystemClock.uptimeMillis();
    public WeakReference h = new WeakReference(null);
    public WeakReference i = new WeakReference(null);
    public WeakReference j = new WeakReference(null);
    public final b t = new b(this);

    public e(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, com.smartdigimkt.f3.a aVar2, f fVar) {
        this.b = aVar;
        this.c = cVar;
        this.d = aVar2;
        this.e = new g(fVar, aVar.c);
    }

    public final void a(View view, d dVar) {
        if (this.k) {
            return;
        }
        if (this.h.get() == view && this.i.get() == dVar) {
            return;
        }
        View view2 = (View) this.h.get();
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
            viewTreeObserver.removeOnWindowFocusChangeListener(this);
        }
        this.j.clear();
        this.h = new WeakReference(view);
        this.i = new WeakReference(dVar);
        if (view != null) {
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
                if (viewTreeObserver2.isAlive()) {
                    viewTreeObserver2.addOnPreDrawListener(this);
                    viewTreeObserver2.addOnWindowFocusChangeListener(this);
                    this.j = new WeakReference(viewTreeObserver2);
                }
            }
        }
        this.a.removeCallbacks(this);
        this.a.post(this);
    }

    public final void b() {
        if (this.k) {
            return;
        }
        try {
            h();
            if (e()) {
                d();
                return;
            }
            d dVar = (d) this.i.get();
            if (dVar != null && this.s) {
                if (this.e.c == 0) {
                    a(dVar, false);
                }
                if (this.e.d != 0 || this.n) {
                    return;
                }
                this.n = true;
                this.q = true;
                try {
                    dVar.sendMediaImpression();
                } finally {
                    this.q = false;
                }
            }
        } catch (Exception unused) {
            g gVar = this.e;
            gVar.c |= 128;
            gVar.d |= 128;
        }
    }

    public final void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.post(new c(this));
            return;
        }
        if (!this.k) {
            h();
            if (e()) {
                d();
            }
        }
        synchronized (this) {
            g gVar = this.e;
            gVar.c |= 64;
            gVar.d |= 64;
            this.k = true;
            this.a.removeCallbacks(this);
            View view = (View) this.h.get();
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                viewTreeObserver.removeOnWindowFocusChangeListener(this);
            }
            this.j.clear();
        }
        this.i.clear();
        this.h.clear();
    }

    public final void d() {
        if (this.r) {
            return;
        }
        this.r = true;
        if (!this.e.f) {
            com.smartdigimkt.n3.k.b(4, this.b, this.c);
        }
        synchronized (this) {
            g gVar = this.e;
            gVar.c |= 16;
            gVar.d |= 16;
            this.k = true;
            this.a.removeCallbacks(this);
            View view = (View) this.h.get();
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                viewTreeObserver.removeOnWindowFocusChangeListener(this);
            }
            this.j.clear();
        }
        d dVar = (d) this.i.get();
        if (dVar != null) {
            dVar.onImpressionExpired();
        }
    }

    public final boolean e() {
        com.smartdigimkt.b3.c cVar = this.c;
        if (!(cVar instanceof com.smartdigimkt.e3.a)) {
            return (cVar instanceof com.smartdigimkt.b3.l) && ((com.smartdigimkt.b3.l) cVar).j();
        }
        com.smartdigimkt.b3.e eVar = this.b.s;
        if (!(eVar instanceof com.smartdigimkt.e3.b)) {
            return true;
        }
        com.smartdigimkt.e3.a aVar = (com.smartdigimkt.e3.a) cVar;
        com.smartdigimkt.e3.b bVar = (com.smartdigimkt.e3.b) eVar;
        aVar.getClass();
        return bVar == null || System.currentTimeMillis() - aVar.e0 > bVar.q;
    }

    public final void f() {
        try {
            com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(4, this.d, -1L);
        } catch (Exception unused) {
            this.e.d |= 128;
        }
    }

    public final void g() {
        b();
        this.a.removeCallbacks(this);
        if (!this.k && (!this.e.f || !this.e.g)) {
            if (!this.e.h || this.s) {
                this.a.postDelayed(this, 100L);
                return;
            }
            return;
        }
        View view = (View) this.h.get();
        if (view != null) {
            view.removeOnAttachStateChangeListener(this);
        }
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
            viewTreeObserver.removeOnWindowFocusChangeListener(this);
        }
        this.j.clear();
    }

    public final void h() {
        View view = (View) this.h.get();
        boolean z = view != null && view.getParent() != null && view.isAttachedToWindow() && view.isShown() && view.getWindowVisibility() == 0 && view.getWidth() > 0 && view.getHeight() > 0 && view.getGlobalVisibleRect(this.f);
        this.s = z;
        long jWidth = z ? ((long) this.f.width()) * ((long) this.f.height()) : 0L;
        long width = view != null ? ((long) view.getWidth()) * ((long) view.getHeight()) : 0L;
        boolean z2 = view != null && view.hasWindowFocus();
        g gVar = this.e;
        long j = gVar.e;
        gVar.a(SystemClock.uptimeMillis(), this.s, z2, jWidth, width);
    }

    public final synchronized void i() {
        if (!this.l && !this.k) {
            this.l = true;
            try {
                com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(13, this.d, -1L);
            } catch (Exception unused) {
            }
            this.a.postAtTime(this.t, this.g + 1000);
            this.a.post(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        g();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        if (this.k) {
            return;
        }
        View view2 = (View) this.h.get();
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
            viewTreeObserver.removeOnWindowFocusChangeListener(this);
        }
        this.j.clear();
        view.addOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.addOnPreDrawListener(this);
            viewTreeObserver2.addOnWindowFocusChangeListener(this);
            this.j = new WeakReference(viewTreeObserver2);
        }
        g();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        if (this.k || (this.e.f && this.e.g)) {
            View view2 = (View) this.h.get();
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
            }
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                viewTreeObserver.removeOnWindowFocusChangeListener(this);
            }
            this.j.clear();
            return;
        }
        this.s = false;
        this.e.a(SystemClock.uptimeMillis(), false, false, 0L, 0L);
        this.a.removeCallbacks(this);
        ViewTreeObserver viewTreeObserver2 = (ViewTreeObserver) this.j.get();
        if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
            viewTreeObserver2.removeOnPreDrawListener(this);
            viewTreeObserver2.removeOnWindowFocusChangeListener(this);
        }
        this.j.clear();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        g();
    }

    @Override // java.lang.Runnable
    public final void run() {
        g();
    }

    public final boolean a(boolean z) {
        if (e()) {
            d();
        }
        if (this.k) {
            return false;
        }
        if (z) {
            d dVar = (d) this.i.get();
            if (dVar != null) {
                a(dVar, true);
            }
            this.n = true;
            return true;
        }
        if (this.q) {
            return true;
        }
        b();
        return false;
    }

    public final void a(d dVar, boolean z) {
        if (!this.m && !this.k) {
            this.m = true;
            try {
                com.smartdigimkt.f3.a aVarA = this.d.a();
                if (aVarA != null) {
                    aVarA.a((View) this.h.get(), this.c, dVar.impressionMaterialType(), z);
                    com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(30, aVarA, -1L);
                }
            } catch (Exception unused) {
                this.e.c |= 128;
            }
        }
        if (this.o || this.k) {
            return;
        }
        this.o = true;
        try {
            dVar.sendUpstreamImpression();
            this.p = true;
        } catch (Exception unused2) {
            this.e.c |= 128;
        }
    }
}
