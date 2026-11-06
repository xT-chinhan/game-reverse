package com.smartdigimkt.z;

import android.app.Activity;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.smartdigimkt.sdk.basead.ui.MCView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ WeakReference b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ WeakReference d;
    public final /* synthetic */ WeakReference e;
    public final /* synthetic */ n f;

    public l(n nVar, WeakReference weakReference, WeakReference weakReference2, Runnable runnable, WeakReference weakReference3, WeakReference weakReference4) {
        this.f = nVar;
        this.a = weakReference;
        this.b = weakReference2;
        this.c = runnable;
        this.d = weakReference3;
        this.e = weakReference4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect rect;
        MCView mCView = (MCView) this.a.get();
        Activity activity = (Activity) this.b.get();
        if (mCView == null || activity == null) {
            com.smartdigimkt.q3.f.a().a(this.c);
            return;
        }
        int[] iArr = new int[2];
        mCView.getLocationOnScreen(iArr);
        int width = mCView.getWidth();
        int height = mCView.getHeight();
        if (width <= 0 || height <= 0) {
            com.smartdigimkt.q3.f.a().a(200L, this.c);
            return;
        }
        View view = (View) this.d.get();
        View view2 = (View) this.e.get();
        Rect rectA = n.a(view);
        Rect rectA2 = n.a(view2);
        mCView.handleMC(true);
        n nVar = this.f;
        WeakReference weakReference = this.a;
        WeakReference weakReference2 = this.b;
        int i = iArr[0];
        int i2 = iArr[1];
        Runnable runnable = this.c;
        nVar.getClass();
        Activity activity2 = (Activity) weakReference2.get();
        if (activity2 == null) {
            MCView mCView2 = (MCView) weakReference.get();
            if (mCView2 != null) {
                mCView2.handleMC(false);
            }
            com.smartdigimkt.q3.f.a().a(200L, runnable);
            return;
        }
        if (rectA2 == null || rectA2.isEmpty()) {
            if (rectA == null || rectA.isEmpty()) {
                Rect rect2 = new Rect(i, i2, width + i, height + i2);
                int iWidth = rect2.width();
                float f = iWidth;
                float fHeight = rect2.height();
                rect = new Rect(Math.round(0.1f * f) + rect2.left, Math.round(0.6f * fHeight) + rect2.top, Math.round(f * 0.9f) + rect2.left, Math.round(fHeight * 0.9f) + rect2.top);
                rect2.toString();
            } else {
                int iWidth2 = rectA.width();
                float f2 = iWidth2;
                float fHeight2 = rectA.height();
                rect = new Rect(Math.round(0.1f * f2) + rectA.left, Math.round(0.6f * fHeight2) + rectA.top, Math.round(f2 * 0.9f) + rectA.left, Math.round(fHeight2 * 0.9f) + rectA.top);
                rectA.toString();
            }
            rectA2 = rect;
        } else {
            rectA2.toString();
        }
        float fNextFloat = rectA2.left + (nVar.a.nextFloat() * rectA2.width());
        float fNextFloat2 = rectA2.top + (nVar.a.nextFloat() * rectA2.height());
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fNextFloat, fNextFloat2, 0);
        if (motionEventObtain != null) {
            Window window = activity2.getWindow();
            if (window == null || window.getCallback() == null) {
                activity2.dispatchTouchEvent(motionEventObtain);
            } else {
                window.getCallback().dispatchTouchEvent(motionEventObtain);
            }
        }
        motionEventObtain.recycle();
        com.smartdigimkt.q3.f.a().a(((long) (nVar.a.nextFloat() * 100.0f)) + 50, new m(weakReference2, jUptimeMillis, fNextFloat, fNextFloat2, runnable));
    }
}
