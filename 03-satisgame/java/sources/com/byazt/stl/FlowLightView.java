package com.byazt.stl;

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
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1773})
public class FlowLightView extends View {
    public Xfermode cp;
    public PorterDuff.Mode d;
    public int[] fs;
    public int l;
    public Rect n;
    public LinearGradient oa;
    public int q;
    public Rect qg;
    public Bitmap rv;
    public int s;
    public final List<n> sz;
    public Paint tj;
    public int w;
    public int x;

    public FlowLightView(Context context) {
        super(context);
        this.d = PorterDuff.Mode.DST_IN;
        this.sz = new ArrayList();
        n();
    }

    private void n() {
        this.s = Color.parseColor("#00ffffff");
        this.q = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.l = color;
        this.w = 10;
        this.x = 40;
        this.fs = new int[]{this.s, this.q, color};
        setLayerType(1, null);
        this.tj = new Paint(1);
        sz.n(getContext(), "tt_splash_unlock_image_arrow", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.stl.FlowLightView.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                FlowLightView.this.rv = bitmap;
                FlowLightView.this.post(new Runnable() { // from class: com.byazt.stl.FlowLightView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FlowLightView.this.invalidate();
                    }
                });
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.cp = new PorterDuffXfermode(this.d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.rv;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, this.n, this.qg, this.tj);
        canvas.save();
        Iterator<n> it = this.sz.iterator();
        while (it.hasNext()) {
            n next = it.next();
            this.oa = new LinearGradient(next.qg, 0.0f, next.qg + this.x, this.w, this.fs, (float[]) null, Shader.TileMode.CLAMP);
            this.tj.setColor(-1);
            this.tj.setShader(this.oa);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.tj);
            this.tj.setShader(null);
            next.n();
            if (next.qg > getWidth()) {
                it.remove();
            }
        }
        this.tj.setXfermode(this.cp);
        canvas.drawBitmap(this.rv, this.n, this.qg, this.tj);
        this.tj.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.rv == null) {
            return;
        }
        this.n = new Rect(0, 0, this.rv.getWidth(), this.rv.getHeight());
        this.qg = new Rect(0, 0, getWidth(), getHeight());
    }

    public void n(int i) {
        this.sz.add(new n(i));
        postInvalidate();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2345})
    public static class n {
        public final int n;
        public int qg = 0;

        public n(int i) {
            this.n = i;
        }

        public void n() {
            this.qg += this.n;
        }
    }
}
