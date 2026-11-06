package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.u.al;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseEndCardView extends RelativeLayout {
    protected String a;
    protected w b;
    protected x c;
    protected y d;
    private boolean e;
    public a mListener;

    public interface a {
        void a();

        void b();
    }

    public interface b extends a {
        void c();
    }

    protected abstract void a();

    protected Drawable b() {
        return null;
    }

    public BaseEndCardView(Context context, w wVar, x xVar) {
        super(context);
        this.a = getClass().getSimpleName();
        super.setWillNotDraw(false);
        this.b = wVar;
        this.c = xVar;
        this.d = xVar.t;
    }

    public void setNeedArc(boolean z) {
        this.e = z;
        postInvalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (this.e) {
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
                al.a(canvas, width, height, rectF);
                canvas.restoreToCount(iSaveLayer);
                return;
            }
        } catch (Exception unused) {
        }
        super.draw(canvas);
    }

    private static RectF a(int i, int i2) {
        int i3 = i / 2;
        float f = i2;
        int i4 = (int) (1.0f * f);
        RectF rectF = new RectF();
        rectF.left = i3 - i4;
        rectF.top = i2 - (i4 * 2);
        rectF.right = i3 + i4;
        rectF.bottom = f;
        return rectF;
    }
}
