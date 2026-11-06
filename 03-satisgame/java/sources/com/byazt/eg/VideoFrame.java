package com.byazt.eg;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 2035})
public class VideoFrame extends View {
    public int fs;
    public ScriptIntrinsicBlur l;
    public final TextureView n;
    public RenderScript q;
    public final Matrix qg;
    public final com.byazt.pp.rv.n.C0302n s;
    public long w;
    public Bitmap x;

    public VideoFrame(Context context, TextureView textureView, com.byazt.pp.rv.n.C0302n c0302n) {
        super(context);
        this.w = -1L;
        this.x = null;
        this.fs = 0;
        this.n = textureView;
        this.qg = new Matrix();
        this.s = c0302n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.w >= 40) {
            this.w = jElapsedRealtime;
            TextureView textureView = this.n;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.n.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.fs = (int) (this.n.getHeight() / width);
                }
                int i = this.fs;
                if (i > 0 && (bitmap2 = this.n.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.x;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.x.recycle();
                    }
                    this.x = n(bitmap2, this.s.n);
                    bitmap2.recycle();
                }
            }
        }
        if (this.fs <= 0 || (bitmap = this.x) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.qg.reset();
        this.qg.setScale(getWidth() / 160.0f, getHeight() / this.fs);
        canvas.concat(this.qg);
        canvas.drawBitmap(this.x, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.q;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.l;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.q = renderScriptCreate;
        this.l = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.x;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.x.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.l;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.l = null;
        }
        RenderScript renderScript = this.q;
        if (renderScript != null) {
            renderScript.destroy();
            this.q = null;
        }
    }

    public Bitmap n(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.q;
            if (renderScript != null && this.l != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.q, allocationCreateFromBitmap.getType());
                this.l.setRadius(f);
                this.l.setInput(allocationCreateFromBitmap);
                this.l.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable unused) {
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused2) {
            bitmapCreateBitmap = null;
        }
    }
}
