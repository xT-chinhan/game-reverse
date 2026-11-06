package com.byazt.uy;

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
@com.byazt.cp.n(n = {0, 1, 819, 19})
public class n {
    public String n = "GesThrough_";
    public List<MotionEvent> qg = new ArrayList();
    public Set<String> s = Collections.synchronizedSet(new HashSet());

    public void n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        if (sVar == null || motionEvent == null || this.qg == null) {
            return;
        }
        n(sVar.rv(), sVar.v(), motionEvent);
    }

    public void n(View view, String str, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || this.qg == null) {
            return;
        }
        this.n = "GesThrough_".concat(String.valueOf(str));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            n();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.qg.add(motionEventObtain);
    }

    public boolean n(MotionEvent motionEvent) {
        if (motionEvent == null || this.s == null) {
            return false;
        }
        return this.s.contains(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void n(com.byazt.ih.s sVar) {
        if (this.qg.isEmpty() || this.s == null || sVar == null || sVar.rv() == null || sVar.rv().getRootView() == null) {
            return;
        }
        n(sVar.rv());
    }

    public void n(View view) {
        if (this.qg.isEmpty() || this.s == null || view == null || view.getRootView() == null) {
            return;
        }
        final View rootView = view.getRootView();
        this.qg.size();
        final ArrayList arrayList = new ArrayList(this.qg);
        n();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.uy.n.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : arrayList) {
                    if (motionEvent != null) {
                        n.this.s.add(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
            }
        }, 300L);
    }

    public void n() {
        List<MotionEvent> list = this.qg;
        if (list != null) {
            list.clear();
        }
    }
}
