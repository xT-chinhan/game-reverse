package com.byazt.cg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 1876})
public class VideoFrame extends View {
    public ScriptIntrinsicBlur c;
    public Bitmap fw;
    public final com.byazt.dx.aj.pr.C0046pr hn;
    public final Matrix hw;
    public final TextureView pr;
    public long uc;
    public RenderScript x;
    public int zo;

    public VideoFrame(Context context, TextureView textureView, com.byazt.dx.aj.pr.C0046pr c0046pr) {
        super(context);
        this.uc = -1L;
        this.fw = null;
        this.zo = 0;
        this.pr = textureView;
        this.hw = new Matrix();
        this.hn = c0046pr;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.uc >= 40) {
            this.uc = jElapsedRealtime;
            TextureView textureView = this.pr;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.pr.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.zo = (int) (this.pr.getHeight() / width);
                }
                int i = this.zo;
                if (i > 0 && (bitmap2 = this.pr.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.fw;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.fw.recycle();
                    }
                    this.fw = pr(bitmap2, this.hn.pr);
                    bitmap2.recycle();
                }
            }
        }
        if (this.zo > 0 && (bitmap = this.fw) != null && !bitmap.isRecycled()) {
            canvas.save();
            this.hw.reset();
            this.hw.setScale(getWidth() / 160.0f, getHeight() / this.zo);
            canvas.concat(this.hw);
            canvas.drawBitmap(this.fw, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.x;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.x = renderScriptCreate;
        this.c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.fw;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.fw.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.c = null;
        }
        RenderScript renderScript = this.x;
        if (renderScript != null) {
            renderScript.destroy();
            this.x = null;
        }
    }

    public Bitmap pr(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.x;
            if (renderScript != null && this.c != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.x, allocationCreateFromBitmap.getType());
                this.c.setRadius(f);
                this.c.setInput(allocationCreateFromBitmap);
                this.c.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            bitmapCreateBitmap = null;
        }
    }
}
