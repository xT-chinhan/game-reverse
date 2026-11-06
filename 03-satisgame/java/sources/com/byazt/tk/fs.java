package com.byazt.tk;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 101})
public class fs extends TouchDelegate {
    public int l;
    public View n;
    public boolean q;
    public Rect qg;
    public Rect s;

    public fs(Rect rect, View view) {
        super(rect, view);
        this.qg = rect;
        this.l = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.s = rect2;
        int i = this.l;
        rect2.inset(-i, -i);
        this.n = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z2 = this.q;
                zContains = z2 ? this.s.contains(x, y) : true;
                z = z2;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z3 = this.q;
                this.q = false;
                z = z3;
                zContains = true;
            }
        } else if (this.qg.contains(x, y)) {
            this.q = true;
            zContains = true;
        } else {
            this.q = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.n;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.l * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
