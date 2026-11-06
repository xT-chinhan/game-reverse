package com.smartdigimkt.p1;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueAnimator valueAnimator = this.a.b;
        if (valueAnimator == null || valueAnimator.isStarted()) {
            return;
        }
        this.a.c();
        try {
            this.a.b.start();
        } catch (Throwable unused) {
        }
    }
}
