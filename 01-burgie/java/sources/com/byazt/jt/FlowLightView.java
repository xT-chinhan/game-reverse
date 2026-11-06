package com.byazt.jt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1622})
public class FlowLightView extends View {
    public Bitmap aj;
    public int c;
    public int fw;
    public final List<pr> g;
    public int hn;
    public Rect hw;
    public PorterDuff.Mode k;
    public LinearGradient m;
    public Rect pr;
    public int uc;
    public Paint vk;
    public Xfermode w;
    public int x;
    public int[] zo;

    public FlowLightView(Context context) {
        super(context);
        this.k = PorterDuff.Mode.DST_IN;
        this.g = new ArrayList();
        pr();
    }

    private void pr() {
        this.hn = Color.parseColor("#00ffffff");
        this.x = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.c = color;
        this.uc = 10;
        this.fw = 40;
        this.zo = new int[]{this.hn, this.x, color};
        setLayerType(1, null);
        this.vk = new Paint(1);
        g.pr(getContext(), "tt_splash_unlock_image_arrow", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jt.FlowLightView.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                FlowLightView.this.aj = bitmap;
                FlowLightView.this.post(new Runnable() { // from class: com.byazt.jt.FlowLightView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FlowLightView.this.invalidate();
                    }
                });
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.w = new PorterDuffXfermode(this.k);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.aj;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, this.pr, this.hw, this.vk);
        canvas.save();
        Iterator<pr> it = this.g.iterator();
        while (it.hasNext()) {
            pr next = it.next();
            this.m = new LinearGradient(next.hw, 0.0f, next.hw + this.fw, this.uc, this.zo, (float[]) null, Shader.TileMode.CLAMP);
            this.vk.setColor(-1);
            this.vk.setShader(this.m);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.vk);
            this.vk.setShader(null);
            next.pr();
            if (next.hw > getWidth()) {
                it.remove();
            }
        }
        this.vk.setXfermode(this.w);
        canvas.drawBitmap(this.aj, this.pr, this.hw, this.vk);
        this.vk.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aj == null) {
            return;
        }
        this.pr = new Rect(0, 0, this.aj.getWidth(), this.aj.getHeight());
        this.hw = new Rect(0, 0, getWidth(), getHeight());
    }

    public void pr(int i) {
        this.g.add(new pr(i));
        postInvalidate();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 86, 87})
    public static class pr {
        public int hw = 0;
        public final int pr;

        public pr(int i) {
            this.pr = i;
        }

        public void pr() {
            this.hw += this.pr;
        }
    }
}
