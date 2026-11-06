package com.mcto.sspsdk.internal;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class h3 implements View.OnTouchListener {
    public final /* synthetic */ n3 a;

    public h3(n3 n3Var) {
        this.a = n3Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a.s = motionEvent.getRawX();
            this.a.t = motionEvent.getRawY();
        }
        n3 n3Var = this.a;
        if (n3Var.d.G0 != 1 || n3Var.l.get()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            view.performClick();
        }
        return true;
    }
}
