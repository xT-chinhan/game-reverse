package com.anythink.core.common.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class RoundImageView extends RecycleImageView {
    int a;
    boolean b;

    public RoundImageView(Context context) {
        super(context);
        this.a = q.a(getContext(), 5.0f);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = q.a(getContext(), 5.0f);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = q.a(getContext(), 5.0f);
    }

    public void setNeedRadiu(boolean z) {
        this.b = z;
    }

    public void setRadiusInDip(int i) {
        this.a = q.a(getContext(), i);
    }

    @Override // com.anythink.core.common.res.image.RecycleImageView, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            if (this.b) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.dispatchDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                am.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.anythink.core.common.res.image.RecycleImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (this.b) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.onDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                am.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.onDraw(canvas);
    }
}
