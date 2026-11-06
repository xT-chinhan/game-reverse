package com.smartdigimkt.z;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.Window;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ long b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ Runnable e;

    public m(WeakReference weakReference, long j, float f, float f2, Runnable runnable) {
        this.a = weakReference;
        this.b = j;
        this.c = f;
        this.d = f2;
        this.e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity = (Activity) this.a.get();
        if (activity != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(this.b, SystemClock.uptimeMillis(), 1, this.c, this.d, 0);
            if (motionEventObtain != null) {
                Window window = activity.getWindow();
                if (window == null || window.getCallback() == null) {
                    activity.dispatchTouchEvent(motionEventObtain);
                } else {
                    window.getCallback().dispatchTouchEvent(motionEventObtain);
                }
            }
            motionEventObtain.recycle();
        }
        com.smartdigimkt.q3.f.a().a(200L, this.e);
    }
}
