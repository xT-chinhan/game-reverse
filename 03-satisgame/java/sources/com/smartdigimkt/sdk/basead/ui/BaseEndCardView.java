package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.n1.p0;
import com.smartdigimkt.o3.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseEndCardView extends RelativeLayout {
    public final c a;
    public final a b;
    public final e c;
    public boolean d;
    public p0 mListener;

    public BaseEndCardView(Context context, c cVar, a aVar) {
        super(context);
        super.setWillNotDraw(false);
        this.a = cVar;
        this.b = aVar;
        this.c = aVar.s;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (this.d) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.draw(canvas);
                int width = getWidth();
                int height = getHeight();
                int width2 = getWidth();
                int height2 = getHeight();
                int i = width2 / 2;
                float f = height2;
                int i2 = (int) (1.0f * f);
                RectF rectF = new RectF();
                rectF.left = i - i2;
                rectF.top = height2 - (i2 * 2);
                rectF.right = i + i2;
                rectF.bottom = f;
                d.a(canvas, width, height, rectF);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.draw(canvas);
    }

    public Drawable getBgDrawable() {
        return null;
    }

    public void setNeedArc(boolean z) {
        this.d = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
