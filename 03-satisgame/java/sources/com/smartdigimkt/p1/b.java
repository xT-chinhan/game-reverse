package com.smartdigimkt.p1;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.smartdigimkt.o1.b {
    public final View a;
    public ValueAnimator b;
    public int c;
    public int d;

    public b(View view) {
        this.a = view;
    }

    @Override // com.smartdigimkt.o1.b
    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // com.smartdigimkt.o1.b
    public void a(Canvas canvas) {
    }

    public abstract ValueAnimator b();

    public void c() {
        View view = this.a;
        if (view == null) {
            return;
        }
        if (this.c == 0 || this.d == 0) {
            this.c = view.getWidth();
            this.d = this.a.getHeight();
        }
    }

    @Override // com.smartdigimkt.o1.b
    public void pause() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            try {
                valueAnimator.pause();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.smartdigimkt.o1.b
    public synchronized void start() {
        if (this.a == null) {
            return;
        }
        stop();
        ValueAnimator valueAnimatorB = b();
        this.b = valueAnimatorB;
        if (valueAnimatorB != null) {
            this.a.post(new a(this));
        }
    }

    @Override // com.smartdigimkt.o1.b
    public void stop() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            try {
                valueAnimator.cancel();
                this.b = null;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // com.smartdigimkt.o1.b
    public void a() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            try {
                valueAnimator.resume();
            } catch (Throwable unused) {
            }
        }
    }
}
