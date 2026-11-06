package com.smartdigimkt.sdk.basead.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;

/* JADX INFO: loaded from: classes3.dex */
public class RoundImageView extends RecycleImageView {
    public int a;
    public boolean b;

    public RoundImageView(Context context) {
        super(context);
        this.a = k.a(getContext(), 5.0f);
    }

    @Override // com.smartdigimkt.sdk.core.common.res.image.RecycleImageView, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        try {
            if (this.b) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.dispatchDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                d.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.smartdigimkt.sdk.core.common.res.image.RecycleImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (this.b) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.onDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                d.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.onDraw(canvas);
    }

    public void setNeedRadiu(boolean z) {
        this.b = z;
    }

    public void setRadiusInDip(int i) {
        this.a = k.a(getContext(), i);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = k.a(getContext(), 5.0f);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = k.a(getContext(), 5.0f);
    }
}
