package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends TouchDelegate {
    private Rect ah;
    private boolean d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f1349ms;
    private Rect xr;

    public ab(Rect rect, View view) {
        super(rect, view);
        this.xr = rect;
        this.ka = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.ah = rect2;
        int i = this.ka;
        rect2.inset(-i, -i);
        this.f1349ms = view;
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
                boolean z2 = this.d;
                zContains = z2 ? this.ah.contains(x, y) : true;
                z = z2;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z3 = this.d;
                this.d = false;
                z = z3;
                zContains = true;
            }
        } else if (this.xr.contains(x, y)) {
            this.d = true;
            zContains = true;
        } else {
            this.d = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.f1349ms;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.ka * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
