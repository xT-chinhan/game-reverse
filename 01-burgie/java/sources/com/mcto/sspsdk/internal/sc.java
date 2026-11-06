package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sc extends ConstraintLayout {
    protected boolean a;

    public sc(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.a = false;
    }

    private void c() {
        boolean z;
        if (!isAttachedToWindow() || getVisibility() != 0 || getWindowVisibility() != 0 || !hasWindowFocus()) {
            z = false;
            break;
        }
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof View)) {
                z = true;
                break;
            } else {
                if (((View) parent).getVisibility() != 0) {
                    z = false;
                    break;
                }
                parent = parent.getParent();
            }
        }
        if (z != this.a) {
            this.a = z;
            if (z) {
                b();
            } else {
                a();
            }
        }
    }

    protected abstract void a();

    protected abstract void b();

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this) {
            c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        c();
    }

    public sc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public sc(Context context) {
        super(context, null, 0);
        this.a = false;
    }
}
