package com.bytedance.adsdk.ugeno.ms;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ka {
    private float ah;
    private float c;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f379ms;
    private float xr;

    public c(View view) {
        this.f379ms = view;
    }

    public void ms(float f) {
        View view = this.f379ms;
        if (view == null) {
            return;
        }
        this.xr = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float ms() {
        return this.xr;
    }

    public void xr(float f) {
        View view = this.f379ms;
        if (view == null) {
            return;
        }
        this.ah = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRipple() {
        return this.ah;
    }

    public void ah(float f) {
        View view = this.f379ms;
        if (view == null) {
            return;
        }
        this.d = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getShine() {
        return this.d;
    }

    public void d(float f) {
        this.ka = f;
        this.f379ms.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getStretch() {
        return this.ka;
    }

    public void ka(float f) {
        this.c = f;
        this.f379ms.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRubIn() {
        return this.c;
    }

    public void ms(int i) {
        View view = this.f379ms;
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
