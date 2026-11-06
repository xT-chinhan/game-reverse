package com.byazt.stl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2226})
public class WriggleGuideView extends View {
    public boolean fs;
    public Paint l;
    public int n;
    public Bitmap q;
    public int qg;
    public boolean rv;
    public Bitmap s;
    public n tj;
    public int w;
    public boolean x;

    public interface n {
    }

    private void n(final int i, final int i2) {
        sz.n(getContext(), "tt_wriggle_union", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.stl.WriggleGuideView.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), WriggleGuideView.this.l);
                }
                WriggleGuideView.this.s = bitmapCreateBitmap;
                WriggleGuideView.this.n();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    private void qg(final int i, final int i2) {
        sz.n(getContext(), "tt_wriggle_union_white", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.stl.WriggleGuideView.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
                }
                WriggleGuideView.this.q = bitmapCreateBitmap;
                WriggleGuideView.this.n();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.s == null || this.q == null || this.rv) {
            return;
        }
        this.rv = true;
        post(new Runnable() { // from class: com.byazt.stl.WriggleGuideView.3
            @Override // java.lang.Runnable
            public void run() {
                WriggleGuideView.this.invalidate();
            }
        });
    }

    private Bitmap s(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.w, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x) {
            this.n = getWidth();
            int height = getHeight();
            this.qg = height;
            n(this.n, height);
            qg(this.n, this.qg);
            this.x = false;
        }
        Bitmap bitmap = this.s;
        if (bitmap == null || this.q == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.l);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.q, 0.0f, 0.0f, this.l);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(s(this.n, this.qg), 0.0f, 0.0f, this.l);
        this.l.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.fs) {
            this.w += 5;
            invalidate();
            if (this.w >= this.n) {
                this.fs = false;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tj != null) {
            this.tj = null;
        }
    }
}
