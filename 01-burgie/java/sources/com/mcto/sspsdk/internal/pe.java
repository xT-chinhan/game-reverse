package com.mcto.sspsdk.internal;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class pe implements View.OnTouchListener {
    public float a;
    public float b;
    public final /* synthetic */ ve c;

    public pe(ve veVar) {
        this.c = veVar;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0079  */
    /* JADX WARN: Code duplicated, block: B:19:0x007f  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            float length = PointF.length(motionEvent.getX() - this.a, motionEvent.getY() - this.b);
            xc xcVar = this.c.l;
            if (xcVar != null && xcVar.getVisibility() == 0) {
                ve veVar = this.c;
                if (length >= hk.a(veVar.b, veVar.f.r)) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ve veVar2 = this.c;
                    if (jCurrentTimeMillis - veVar2.L >= 100) {
                        veVar2.L = jCurrentTimeMillis;
                        a4 a4Var = new a4();
                        a4Var.a = view;
                        a4Var.b = z3.SLIDE;
                        a4Var.e = gj.a(view);
                        this.c.b(new b4(a4Var));
                    }
                } else if (length <= 1.0f) {
                    this.c.onClick(view);
                }
            } else if (length <= 1.0f) {
                this.c.onClick(view);
            }
        }
        return true;
    }
}
