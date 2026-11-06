package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.d.ka;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class GifView extends ImageView {
    private boolean ab;
    private long ah;
    private boolean c;
    private float ch;
    private int d;
    private int hi;
    private AnimatedImageDrawable ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f936ms;
    private float ny;
    private int sl;
    private boolean u;
    private boolean ub;
    private float x;
    private Movie xr;
    private volatile boolean zb;

    interface ms {
        void ms(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.c = Build.VERSION.SDK_INT >= 28;
        this.ab = false;
        this.u = true;
        this.ub = true;
        ms();
    }

    void ms() {
        if (this.c) {
            return;
        }
        setLayerType(1, null);
    }

    public void ms(int i, boolean z) {
        this.zb = z;
        this.f936ms = i;
        if (i == -1) {
            return;
        }
        if (!this.c) {
            this.xr = ms(i);
        } else {
            ms(i, new ms() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.ms
                public void ms(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void ms(byte[] bArr, boolean z) {
        this.zb = z;
        if (bArr == null) {
            return;
        }
        if (!this.c) {
            this.xr = ms(bArr);
        } else {
            ms(bArr, new ms() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.ms
                public void ms(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.ka = animatedImageDrawable;
            if (!this.zb) {
                animatedImageDrawable.start();
            }
            if (!this.ub) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        ah();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.ub = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.ka) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            sl.ah("GifView", "setRepeatConfig error", e);
        }
    }

    private Movie ms(int i) {
        try {
            return Movie.decodeStream(t.ms(getContext()).openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie ms(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void ms(final int i, final ms msVar) {
        if (i == -1) {
            return;
        }
        ka.ms(new ny("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    GifView gifView = GifView.this;
                    msVar2.ms(gifView.ms(gifView.xr(i)));
                }
            }
        }, 5);
    }

    private void ms(final byte[] bArr, final ms msVar) {
        if (bArr == null) {
            return;
        }
        ka.ms(new ny("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    GifView gifView = GifView.this;
                    msVar2.ms(gifView.ms(gifView.xr(bArr)));
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source xr(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File fileMs = ms(getContext(), com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileMs);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileMs);
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return sourceCreateSource;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    sl.ah("GifView", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        return null;
    }

    public static File ms(Context context, String str, String str2) {
        int iHi = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().hi();
        boolean zSl = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl();
        if (iHi == 1) {
            sl.d("splashLoadAd", "视频存储使用内部存储");
            return c.xr(context, zSl, str, str2);
        }
        sl.d("splashLoadAd", "视频存储使用外存储");
        return c.ms(context, zSl, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source xr(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.createSource(t.ms(getContext()), i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable ms(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void xr() {
        if (this.xr == null || !this.zb) {
            return;
        }
        this.zb = false;
        if (!this.c) {
            this.ah = SystemClock.uptimeMillis() - ((long) this.d);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.ka;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.ka.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.c || (movie = this.xr) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.xr.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.ch = fMax;
        int i3 = (int) (iWidth * fMax);
        this.hi = i3;
        int i4 = (int) (iHeight * fMax);
        this.sl = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.xr != null && !this.c) {
            this.x = (getWidth() - this.hi) / 2.0f;
            this.ny = (getHeight() - this.sl) / 2.0f;
        }
        this.u = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.xr != null && !this.c) {
            try {
                if (!this.zb) {
                    d();
                    ms(canvas);
                    ah();
                    return;
                }
                ms(canvas);
                return;
            } catch (Throwable th) {
                sl.ah("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void ah() {
        if (this.xr == null || this.c || !this.u) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void d() {
        if (this.xr == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.ah == 0) {
            this.ah = jUptimeMillis;
        }
        int iDuration = this.xr.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.ub && Math.abs(iDuration - this.d) < 60) {
            this.d = iDuration;
            this.zb = true;
        } else {
            this.d = (int) ((jUptimeMillis - this.ah) % ((long) iDuration));
        }
    }

    private void ms(Canvas canvas) {
        Movie movie = this.xr;
        if (movie == null) {
            return;
        }
        movie.setTime(this.d);
        float f = this.ch;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.xr.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.xr;
            float f2 = this.x;
            float f3 = this.ch;
            movie2.draw(canvas, f2 / f3, this.ny / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.xr != null) {
            this.u = i == 1;
            ah();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.xr != null) {
            this.u = i == 0;
            ah();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.xr != null) {
            this.u = i == 0;
            ah();
        }
    }
}
