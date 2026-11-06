package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.nw;

/* JADX INFO: loaded from: classes2.dex */
public class u extends ab {
    private int ch;
    private int ny;
    private Path x;

    public u(com.bytedance.adsdk.lottie.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = null;
        this.ny = -1;
        this.ch = -1;
        if (this.ab != null) {
            float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
            this.ny = (int) (this.ab.ms() * fMs);
            this.ch = (int) (this.ab.xr() * fMs);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.ny, this.ch);
            Path path = new Path();
            this.x = path;
            float f = fMs * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ab, com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        nw nwVarMs = this.xr.ms();
        View viewMs = nwVarMs != null ? nwVarMs.ms("videoview:", null) : null;
        if (this.ny <= 0 || viewMs == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        ms(i);
        float fX = x();
        ms(viewMs, this.ny, this.ch);
        viewMs.setAlpha(fX);
        canvas.clipPath(this.x);
        viewMs.draw(canvas);
        canvas.restore();
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
