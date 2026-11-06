package com.mcto.sspsdk.internal;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class v3 {
    public final Handler a;
    public final View b;
    public final float c;
    public final AtomicBoolean d;
    public u3 e;
    public long f;
    public boolean g;
    public boolean h;
    public final t3 i;

    public v3(View view, float f, long j) {
        Looper looper;
        synchronized (s9.class) {
            if (s9.a == null) {
                HandlerThread handlerThread = new HandlerThread("ssp_emptyView");
                s9.a = handlerThread;
                handlerThread.start();
            }
            looper = s9.a.getLooper();
        }
        this.a = new Handler(looper);
        this.d = new AtomicBoolean(false);
        this.g = true;
        this.h = false;
        this.i = new t3(this);
        this.b = view;
        this.c = f;
        this.f = j;
    }

    public final void a(u3 u3Var) {
        if (this.d.compareAndSet(false, true)) {
            this.e = u3Var;
            long j = this.f;
            if (j < 0) {
                j = 300;
            }
            this.f = j;
            this.a.postDelayed(this.i, j);
        }
    }

    public final void a() {
        this.a.removeCallbacksAndMessages(null);
        this.h = false;
        kh.a.a(new s3(this, false));
        this.d.set(false);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    public static void a(v3 v3Var) {
        boolean z;
        View view = v3Var.b;
        if (view == null || v3Var.e == null) {
            v3Var.a();
            return;
        }
        View view2 = view;
        while (true) {
            if (view2 != null) {
                if (view2.getVisibility() == 0) {
                    Object parent = view2.getParent();
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                z = false;
                if (v3Var.g) {
                    v3Var.h = z;
                    v3Var.g = false;
                    kh.a.a(new s3(v3Var, z));
                } else if (v3Var.h != z) {
                    v3Var.h = z;
                    kh.a.a(new s3(v3Var, z));
                }
                v3Var.a.postDelayed(v3Var.i, v3Var.f);
                return;
            }
            if (view.getParent() != null && view.getAlpha() > 0.9f) {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                    z = false;
                } else {
                    double dHeight = rect.height() * rect.width();
                    double height = view.getHeight() * view.getWidth();
                    float f = v3Var.c;
                    if (dHeight >= height * (f > 0.0f ? Math.min(1.0f, f) : Math.min(1.0d, 0.5d))) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            } else {
                z = false;
            }
            if (v3Var.g) {
                v3Var.h = z;
                v3Var.g = false;
                kh.a.a(new s3(v3Var, z));
            } else if (v3Var.h != z) {
                v3Var.h = z;
                kh.a.a(new s3(v3Var, z));
            }
            v3Var.a.postDelayed(v3Var.i, v3Var.f);
            return;
        }
    }
}
