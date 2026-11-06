package com.anythink.basead.ui.a.a;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.anythink.basead.ui.a.b {
    protected View a;
    protected ValueAnimator b;
    protected int c;
    protected int d;

    @Override // com.anythink.basead.ui.a.b
    public void a(Canvas canvas) {
    }

    protected ValueAnimator e() {
        return null;
    }

    public a(View view) {
        this.a = view;
    }

    @Override // com.anythink.basead.ui.a.b
    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // com.anythink.basead.ui.a.b
    public synchronized void a() {
        if (this.a == null) {
            return;
        }
        d();
        ValueAnimator valueAnimatorE = e();
        this.b = valueAnimatorE;
        if (valueAnimatorE != null) {
            this.a.post(new Runnable() { // from class: com.anythink.basead.ui.a.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.b == null || a.this.b.isStarted()) {
                        return;
                    }
                    a.this.f();
                    try {
                        a.this.b.start();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.a.b
    public void b() {
        if (this.b != null) {
            try {
                this.b.pause();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.anythink.basead.ui.a.b
    public void c() {
        if (this.b != null) {
            try {
                this.b.resume();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.anythink.basead.ui.a.b
    public void d() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            try {
                valueAnimator.cancel();
                this.b = null;
            } catch (Throwable th) {
                Object[] objArr = new Object[1];
                th.getMessage();
            }
        }
    }

    protected void f() {
        View view = this.a;
        if (view == null) {
            return;
        }
        if (this.c == 0 || this.d == 0) {
            this.c = view.getWidth();
            this.d = this.a.getHeight();
        }
    }
}
