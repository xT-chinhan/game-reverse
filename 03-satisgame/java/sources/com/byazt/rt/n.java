package com.byazt.rt;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.byazt.xx.l;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 949, 19})
public class n implements s {
    public final float q;
    public final Paint n = new Paint(3);
    public final Matrix qg = new Matrix();
    public final Paint s = n();

    public n(float f) {
        this.q = f;
    }

    private static Paint n() {
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        return paint;
    }

    @Override // com.byazt.rt.s
    public void n(Canvas canvas, List<l> list, double d, double d2) {
        for (int i = 0; i < list.size(); i++) {
            l lVar = list.get(i);
            if (lVar.oa && lVar.d != null) {
                this.qg.reset();
                float f = (float) (lVar.l * ((double) this.q));
                float f2 = (float) (lVar.w * ((double) this.q));
                float width = (float) (((lVar.x * ((double) this.q)) / ((double) lVar.d.getWidth())) * lVar.tj);
                float height = (float) (((lVar.fs * ((double) this.q)) / ((double) lVar.d.getHeight())) * lVar.tj);
                this.qg.postScale(width, height);
                this.qg.postTranslate(f - ((lVar.d.getWidth() * width) / 2.0f), f2 - ((lVar.d.getHeight() * height) / 2.0f));
                this.n.setAlpha((int) (lVar.rv * 255.0d));
                canvas.drawBitmap(lVar.d, this.qg, this.n);
            }
        }
    }

    @Override // com.byazt.rt.s
    public void n(Canvas canvas, String str, double d, double d2, double d3, int i, float f) {
        if (str == null) {
            return;
        }
        this.s.setColor(i);
        this.s.setAlpha((int) (Math.max(0.0d, Math.min(1.0d, d3)) * 255.0d));
        this.s.setTextSize(f * this.q);
        float f2 = this.q;
        canvas.drawText(str, (float) (d * ((double) f2)), (float) (d2 * ((double) f2)), this.s);
    }
}
