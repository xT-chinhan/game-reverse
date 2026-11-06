package com.bytedance.adsdk.lottie.model.layer;

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

/* JADX INFO: loaded from: classes2.dex */
public class VideoFrame extends View {
    private Bitmap ab;
    private final com.bytedance.adsdk.lottie.ny.ms.C0190ms ah;
    private long c;
    private RenderScript d;
    private ScriptIntrinsicBlur ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TextureView f182ms;
    private int x;
    private final Matrix xr;

    public VideoFrame(Context context, TextureView textureView, com.bytedance.adsdk.lottie.ny.ms.C0190ms c0190ms) {
        super(context);
        this.c = -1L;
        this.ab = null;
        this.x = 0;
        this.f182ms = textureView;
        this.xr = new Matrix();
        this.ah = c0190ms;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.c >= 40) {
            this.c = jElapsedRealtime;
            TextureView textureView = this.f182ms;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.f182ms.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.x = (int) (this.f182ms.getHeight() / width);
                }
                int i = this.x;
                if (i > 0 && (bitmap2 = this.f182ms.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.ab;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.ab.recycle();
                    }
                    this.ab = ms(bitmap2, this.ah.f267ms);
                    bitmap2.recycle();
                }
            }
        }
        if (this.x <= 0 || (bitmap = this.ab) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.xr.reset();
        this.xr.setScale(getWidth() / 160.0f, getHeight() / this.x);
        canvas.concat(this.xr);
        canvas.drawBitmap(this.ab, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.d;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.ka;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.d = renderScriptCreate;
        this.ka = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.ab;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.ab.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.ka;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.ka = null;
        }
        RenderScript renderScript = this.d;
        if (renderScript != null) {
            renderScript.destroy();
            this.d = null;
        }
    }

    public Bitmap ms(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.d;
            if (renderScript != null && this.ka != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.d, allocationCreateFromBitmap.getType());
                this.ka.setRadius(f);
                this.ka.setInput(allocationCreateFromBitmap);
                this.ka.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.sl.ms(th);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmapCreateBitmap = null;
        }
    }
}
