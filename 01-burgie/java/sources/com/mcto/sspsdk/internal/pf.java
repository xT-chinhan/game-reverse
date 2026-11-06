package com.mcto.sspsdk.internal;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mcto.sspsdk.component.webview.QyWebViewPanel;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class pf extends FrameLayout {
    public boolean a;
    public final HashSet b;
    public dd c;
    public final float[] d;
    public final float[] e;
    public final float[] f;

    public pf(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.a = false;
        this.d = new float[2];
        this.e = new float[2];
        this.f = new float[2];
        this.b = new HashSet();
    }

    public final boolean a(boolean z) {
        dd ddVar = this.c;
        if (ddVar == null) {
            return false;
        }
        int measuredHeight = ddVar.a.getMeasuredHeight();
        if (z) {
            int[] iArr = ddVar.a.l;
            if (measuredHeight == iArr[1]) {
                return false;
            }
            if (measuredHeight == iArr[0]) {
                return true;
            }
        } else {
            gd gdVar = ddVar.a;
            int[] iArr2 = gdVar.l;
            if (measuredHeight == iArr2[1]) {
                QyWebViewPanel qyWebViewPanel = gdVar.k;
                return qyWebViewPanel != null && qyWebViewPanel.d().getScrollY() <= 0;
            }
            if (measuredHeight == iArr2[0]) {
                return false;
            }
        }
        int[] iArr3 = ddVar.a.l;
        return measuredHeight < iArr3[1] && measuredHeight > iArr3[0];
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.clear();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float[] fArr = this.e;
            float[] fArr2 = this.d;
            float rawX = (int) motionEvent.getRawX();
            fArr2[0] = rawX;
            fArr[0] = rawX;
            float[] fArr3 = this.e;
            float[] fArr4 = this.d;
            float rawY = (int) motionEvent.getRawY();
            fArr4[1] = rawY;
            fArr3[1] = rawY;
            return false;
        }
        if (action != 1) {
            if (action == 2) {
                float rawX2 = motionEvent.getRawX() - this.d[0];
                float rawY2 = motionEvent.getRawY();
                float[] fArr5 = this.d;
                float[] fArr6 = {rawX2, rawY2 - fArr5[1]};
                fArr5[0] = motionEvent.getRawX();
                this.d[1] = motionEvent.getRawY();
                if ((Math.abs(fArr6[0]) > 1.0f || Math.abs(fArr6[1]) > 1.0f) && this.a) {
                    if (a(fArr6[1] < 0.0f)) {
                        return true;
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f[0] = (int) motionEvent.getRawX();
        this.f[1] = (int) motionEvent.getRawY();
        float[] fArr7 = this.f;
        float f = fArr7[0];
        float[] fArr8 = this.e;
        if (f == fArr8[0] && fArr7[1] == fArr8[1]) {
            for (ed edVar : this.b) {
                long[] jArr = edVar.a.n;
                jArr[0] = 1;
                jArr[1] = System.currentTimeMillis();
                gd gdVar = edVar.a;
                if (gdVar.j.S0 == 2) {
                    gdVar.f();
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            float rawX = motionEvent.getRawX() - this.d[0];
            float rawY = motionEvent.getRawY();
            float[] fArr = this.d;
            float[] fArr2 = {rawX, rawY - fArr[1]};
            fArr[0] = motionEvent.getRawX();
            this.d[1] = motionEvent.getRawY();
            if (this.a) {
                if (a(fArr2[1] < 0.0f)) {
                    for (ed edVar : this.b) {
                        float f = fArr2[1];
                        int measuredHeight = edVar.a.getMeasuredHeight() - ((int) f);
                        gd gdVar = edVar.a;
                        int[] iArr = gdVar.l;
                        int i = iArr[0];
                        if (measuredHeight < i) {
                            f -= i - measuredHeight;
                        } else {
                            int i2 = iArr[1];
                            if (measuredHeight > i2) {
                                f -= i2 - measuredHeight;
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = gdVar.getLayoutParams();
                        layoutParams.height = edVar.a.getMeasuredHeight() - ((int) f);
                        edVar.a.setLayoutParams(layoutParams);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
