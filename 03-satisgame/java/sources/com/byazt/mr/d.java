package com.byazt.mr;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 113})
public class d extends Drawable {
    public Paint cp;
    public int fs;
    public LinearGradient l;
    public int n;
    public float[] q;
    public int qg;
    public int rv;
    public int[] s;
    public RectF tj;
    public int w;
    public int x;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public d(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.n = i;
        this.s = iArr;
        this.q = fArr;
        this.qg = i2;
        this.l = linearGradient;
        this.w = i3;
        this.x = i4;
        this.fs = i5;
        this.rv = i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tj == null) {
            Rect bounds = getBounds();
            this.tj = new RectF((bounds.left + this.x) - this.fs, (bounds.top + this.x) - this.rv, (bounds.right - this.x) - this.fs, (bounds.bottom - this.x) - this.rv);
        }
        if (this.cp == null) {
            n();
        }
        RectF rectF = this.tj;
        int i = this.w;
        canvas.drawRoundRect(rectF, i, i, this.cp);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.cp;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.cp;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    private void n() {
        int[] iArr;
        Paint paint = new Paint();
        this.cp = paint;
        paint.setAntiAlias(true);
        this.cp.setShadowLayer(this.x, this.fs, this.rv, this.qg);
        if (this.tj != null && (iArr = this.s) != null && iArr.length > 1) {
            float[] fArr = this.q;
            boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
            Paint paint2 = this.cp;
            LinearGradient linearGradient = this.l;
            if (linearGradient == null) {
                linearGradient = new LinearGradient(this.tj.left, 0.0f, this.tj.right, 0.0f, this.s, z ? this.q : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.cp.setColor(this.n);
    }

    public static void n(View view, n nVar) {
        if (view == null || nVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(nVar.n());
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 89})
    public static class n {
        public LinearGradient l;
        public float[] q;
        public int[] s;
        public int n = 2789591;
        public int qg = 2789591;
        public int w = 10;
        public int x = 16;
        public int fs = 0;
        public int rv = 0;

        public n n(int i) {
            this.n = i;
            return this;
        }

        public n qg(int i) {
            this.qg = i;
            return this;
        }

        public n n(int[] iArr) {
            this.s = iArr;
            return this;
        }

        public n s(int i) {
            this.w = i;
            return this;
        }

        public n q(int i) {
            this.fs = i;
            return this;
        }

        public n l(int i) {
            this.rv = i;
            return this;
        }

        public d n() {
            return new d(this.n, this.s, this.q, this.qg, this.l, this.w, this.x, this.fs, this.rv);
        }
    }
}
