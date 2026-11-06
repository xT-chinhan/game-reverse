package com.smartdigimkt.sdk.basead.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.smartdigimkt.o3.d;

/* JADX INFO: loaded from: classes3.dex */
public class RoundFrameLayout extends FrameLayout {
    public int a;

    public RoundFrameLayout(Context context) {
        super(context);
        this.a = dip2px(getContext(), 10.0f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        d.a(canvas, getWidth(), getHeight(), this.a);
        canvas.restoreToCount(iSaveLayer);
    }

    public void setRadius(int i) {
        this.a = dip2px(getContext(), i);
        postInvalidate();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = dip2px(getContext(), 10.0f);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = dip2px(getContext(), 10.0f);
    }
}
