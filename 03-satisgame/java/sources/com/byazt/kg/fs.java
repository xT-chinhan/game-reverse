package com.byazt.kg;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1238, 101})
public class fs implements x {
    public float l;
    public View n;
    public float q;
    public float qg;
    public float s;
    public float w;

    public fs(View view) {
        this.n = view;
    }

    public void n(float f) {
        View view = this.n;
        if (view == null) {
            return;
        }
        this.qg = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float n() {
        return this.qg;
    }

    public void qg(float f) {
        View view = this.n;
        if (view == null) {
            return;
        }
        this.s = f;
        view.postInvalidate();
    }

    @Override // com.byazt.kg.x
    public float getRipple() {
        return this.s;
    }

    public void s(float f) {
        View view = this.n;
        if (view == null) {
            return;
        }
        this.q = f;
        view.postInvalidate();
    }

    @Override // com.byazt.kg.x
    public float getShine() {
        return this.q;
    }

    public void q(float f) {
        this.l = f;
        this.n.postInvalidate();
    }

    @Override // com.byazt.kg.x
    public float getStretch() {
        return this.l;
    }

    public void l(float f) {
        this.w = f;
        this.n.postInvalidate();
    }

    @Override // com.byazt.kg.x
    public float getRubIn() {
        return this.w;
    }

    public void n(int i) {
        View view = this.n;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
