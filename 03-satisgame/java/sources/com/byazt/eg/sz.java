package com.byazt.eg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.byazt.pp.ou;
import com.byazt.pp.py;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 110})
public class sz extends x {
    public int cp;
    public int d;
    public Path fs;
    public int rv;
    public int tj;

    public sz(com.byazt.pp.fs fsVar, fs fsVar2, Context context) {
        super(fsVar, fsVar2);
        this.fs = null;
        this.rv = -1;
        this.tj = -1;
        this.cp = -1;
        this.d = -1;
        if (this.x != null) {
            float fN = com.byazt.nu.tj.n();
            this.rv = (int) (this.x.n() * fN);
            this.tj = (int) (this.x.qg() * fN);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.rv, this.tj);
            Path path = new Path();
            this.fs = path;
            float f = fN * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.byazt.eg.x, com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        py pyVarHu;
        ou ouVarN = this.qg.n();
        View viewN = ouVarN != null ? ouVarN.n("videoview:", null) : null;
        if (this.rv <= 0 || viewN == null) {
            return;
        }
        if (this.cp <= 0 && (pyVarHu = this.qg.hu()) != null) {
            String strN = pyVarHu.n("${video.cover_width}");
            String strN2 = pyVarHu.n("${video.cover_height}");
            try {
                this.cp = Integer.parseInt(strN);
                int i2 = Integer.parseInt(strN2);
                this.d = i2;
                if (this.cp <= 0 || i2 <= 0) {
                    this.cp = this.rv;
                    this.d = this.tj;
                }
            } catch (NumberFormatException unused) {
                this.cp = this.rv;
                this.d = this.tj;
            }
        }
        canvas.save();
        canvas.concat(matrix);
        n(i);
        float fFs = fs();
        int i3 = this.rv;
        int i4 = this.tj;
        int i5 = this.cp;
        int i6 = this.d;
        if ((i5 >= i6 && i3 >= i4) || (i5 <= i6 && i3 <= i4)) {
            canvas.clipPath(this.fs);
        } else {
            float fMin = Math.min(i3 / i5, i4 / i6);
            int iRound = Math.round(this.cp * fMin);
            int iRound2 = Math.round(this.d * fMin);
            canvas.translate(Math.round((this.rv - iRound) / 2.0f), Math.round((this.tj - iRound2) / 2.0f));
            i4 = iRound2;
            i3 = iRound;
        }
        n(viewN, i3, i4);
        viewN.setAlpha(fFs);
        viewN.draw(canvas);
        canvas.restore();
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
