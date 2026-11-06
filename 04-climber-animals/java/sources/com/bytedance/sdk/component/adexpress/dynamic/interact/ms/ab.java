package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements View.OnTouchListener {
    private static int ah = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f854ms;
    private float xr;
    private RectF c = new RectF();
    private long ab = 0;
    private final int x = 200;
    private final int ny = 3;
    private SoftReference<View> ch = new SoftReference<>(null);

    public ab(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar, int i, final ViewGroup viewGroup) {
        this.ka = ah;
        this.d = xVar;
        if (i > 0) {
            this.ka = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    ab.this.ch = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    private RectF ms(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new RectF(i, iArr[1], i + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = ms(this.ch.get());
            this.f854ms = motionEvent.getRawX();
            this.xr = motionEvent.getRawY();
            this.ab = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.c;
            if (rectF != null && !rectF.contains(this.f854ms, this.xr)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.f854ms);
            float fAbs2 = Math.abs(rawY - this.xr);
            int iXr = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(rawX - this.f854ms));
            int i = ah;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.ab < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (xVar = this.d) != null) {
                    xVar.ms();
                }
            } else if (rawX > this.f854ms && iXr > this.ka && (xVar2 = this.d) != null) {
                xVar2.ms();
            }
        }
        return true;
    }
}
