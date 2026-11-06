package com.bytedance.adsdk.ugeno.ah.xr;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f343ms = "GesThrough_";
    private List<MotionEvent> xr = new ArrayList();
    private Set<String> ah = Collections.synchronizedSet(new HashSet());

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        if (ahVar == null || motionEvent == null || this.xr == null) {
            return;
        }
        this.f343ms = "GesThrough_" + ahVar.of();
        int[] iArr = new int[2];
        ahVar.ny().getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.xr.clear();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.xr.add(motionEventObtain);
    }

    public boolean ms(MotionEvent motionEvent) {
        if (motionEvent == null || this.ah == null) {
            return false;
        }
        return this.ah.contains(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (this.xr.isEmpty() || this.ah == null || ahVar == null || ahVar.ny() == null || ahVar.ny().getRootView() == null) {
            return;
        }
        final View rootView = ahVar.ny().getRootView();
        this.xr.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.ah.xr.ms.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : ms.this.xr) {
                    if (motionEvent != null) {
                        ms.this.ah.add(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                ms.this.xr.clear();
            }
        }, 300L);
    }
}
