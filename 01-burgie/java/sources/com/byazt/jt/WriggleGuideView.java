package com.byazt.jt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.Constants;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, Constants.OAIDErrorCode.OAID_CLIENT_FETCH_INTERRUPTED})
public class WriggleGuideView extends View {
    public boolean aj;
    public Paint c;
    public boolean fw;
    public Bitmap hn;
    public int hw;
    public int pr;
    public int uc;
    public pr vk;
    public Bitmap x;
    public boolean zo;

    public interface pr {
    }

    private void pr(final int i, final int i2) {
        g.pr(getContext(), "tt_wriggle_union", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jt.WriggleGuideView.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), WriggleGuideView.this.c);
                }
                WriggleGuideView.this.hn = bitmapCreateBitmap;
                WriggleGuideView.this.pr();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    private void hw(final int i, final int i2) {
        g.pr(getContext(), "tt_wriggle_union_white", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jt.WriggleGuideView.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
                }
                WriggleGuideView.this.x = bitmapCreateBitmap;
                WriggleGuideView.this.pr();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        if (this.hn == null || this.x == null || this.aj) {
            return;
        }
        this.aj = true;
        post(new Runnable() { // from class: com.byazt.jt.WriggleGuideView.3
            @Override // java.lang.Runnable
            public void run() {
                WriggleGuideView.this.invalidate();
            }
        });
    }

    private Bitmap hn(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.uc, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fw) {
            this.pr = getWidth();
            int height = getHeight();
            this.hw = height;
            pr(this.pr, height);
            hw(this.pr, this.hw);
            this.fw = false;
        }
        Bitmap bitmap = this.hn;
        if (bitmap == null || this.x == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.c);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.x, 0.0f, 0.0f, this.c);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(hn(this.pr, this.hw), 0.0f, 0.0f, this.c);
        this.c.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.zo) {
            this.uc += 5;
            invalidate();
            if (this.uc >= this.pr) {
                this.zo = false;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.vk != null) {
            this.vk = null;
        }
    }
}
