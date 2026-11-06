package com.byazt.jt;

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
import com.byazt.ca.ho;
import com.byazt.js.c;
import com.byazt.xlm.fw;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1120})
public class GifView extends ImageView {
    public float aj;
    public boolean c;
    public float fw;
    public boolean g;
    public int hn;
    public long hw;
    public volatile boolean k;
    public boolean m;
    public Movie pr;
    public boolean uc;
    public int vk;
    public int w;
    public AnimatedImageDrawable x;
    public float zo;

    interface pr {
        void pr(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.c = Build.VERSION.SDK_INT >= 28;
        this.uc = false;
        this.m = true;
        this.g = true;
        pr();
    }

    public void pr() {
        if (!this.c) {
            setLayerType(1, null);
        }
    }

    public void pr(byte[] bArr, boolean z) {
        this.k = z;
        if (bArr == null) {
            return;
        }
        if (!this.c) {
            this.pr = pr(bArr);
        } else {
            pr(bArr, new pr() { // from class: com.byazt.jt.GifView.1
                @Override // com.byazt.jt.GifView.pr
                public void pr(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.byazt.jt.GifView.1.1
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
            this.x = animatedImageDrawable;
            if (!this.k) {
                animatedImageDrawable.start();
            }
            if (!this.g) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        hn();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.g = z;
        if (!z) {
            try {
                if (Build.VERSION.SDK_INT >= 28 && (animatedImageDrawable = this.x) != null) {
                    animatedImageDrawable.setRepeatCount(0);
                }
            } catch (Exception e) {
                ho.pr("GifView", "setRepeatConfig error", e);
            }
        }
    }

    private Movie pr(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            return null;
        }
    }

    private void pr(final byte[] bArr, final pr prVar) {
        if (bArr == null) {
            return;
        }
        c.pr(new fw("createGifApi28WithByteArrayBySafely") { // from class: com.byazt.jt.GifView.2
            @Override // java.lang.Runnable
            public void run() {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    GifView gifView = GifView.this;
                    prVar2.pr(gifView.pr(gifView.hw(bArr)));
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source hw(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            try {
                File filePr = pr(getContext(), com.byazt.bg.pr.pr().hn().vk() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
                fileOutputStream = new FileOutputStream(filePr);
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    if (Build.VERSION.SDK_INT >= 28) {
                        ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(filePr);
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                        }
                        return sourceCreateSource;
                    }
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ho.pr("GifView", "GifView  getSourceByFile fail : ", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        return null;
    }

    public static File pr(Context context, String str, String str2) {
        int iAj = com.byazt.bg.pr.pr().hn().aj();
        boolean zVk = com.byazt.bg.pr.pr().hn().vk();
        if (iAj == 1) {
            ho.hw("splashLoadAd", "视频存储使用内部存储");
            return com.byazt.ca.fw.hw(context, zVk, str, str2);
        }
        ho.hw("splashLoadAd", "视频存储使用外存储");
        return com.byazt.ca.fw.pr(context, zVk, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable pr(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable th) {
            return null;
        }
    }

    public void hw() {
        if (this.pr != null && this.k) {
            this.k = false;
            if (!this.c) {
                this.hw = SystemClock.uptimeMillis() - ((long) this.hn);
                invalidate();
                return;
            }
            AnimatedImageDrawable animatedImageDrawable = this.x;
            if (animatedImageDrawable != null && !animatedImageDrawable.isRunning()) {
                this.x.start();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        float f;
        float f2;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (!this.c && (movie = this.pr) != null) {
            int iWidth = movie.width();
            int iHeight = this.pr.height();
            if (View.MeasureSpec.getMode(i) != 0 && iWidth > (size2 = View.MeasureSpec.getSize(i))) {
                f = iWidth / size2;
            } else {
                f = 1.0f;
            }
            if (View.MeasureSpec.getMode(i2) != 0 && iHeight > (size = View.MeasureSpec.getSize(i2))) {
                f2 = iHeight / size;
            } else {
                f2 = 1.0f;
            }
            float fMax = 1.0f / Math.max(f, f2);
            this.aj = fMax;
            int i3 = (int) (iWidth * fMax);
            this.vk = i3;
            int i4 = (int) (iHeight * fMax);
            this.w = i4;
            setMeasuredDimension(i3, i4);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.pr != null && !this.c) {
            this.fw = (getWidth() - this.vk) / 2.0f;
            this.zo = (getHeight() - this.w) / 2.0f;
        }
        this.m = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.pr != null && !this.c) {
            try {
                if (!this.k) {
                    x();
                    pr(canvas);
                    hn();
                    return;
                }
                pr(canvas);
                return;
            } catch (Throwable th) {
                ho.pr("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void hn() {
        if (this.pr != null && !this.c && this.m) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void x() {
        if (this.pr == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.hw == 0) {
            this.hw = jUptimeMillis;
        }
        int iDuration = this.pr.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.g && Math.abs(iDuration - this.hn) < 60) {
            this.hn = iDuration;
            this.k = true;
        } else {
            this.hn = (int) ((jUptimeMillis - this.hw) % ((long) iDuration));
        }
    }

    private void pr(Canvas canvas) {
        Movie movie = this.pr;
        if (movie == null) {
            return;
        }
        movie.setTime(this.hn);
        float f = this.aj;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.pr.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.pr;
            float f2 = this.fw;
            float f3 = this.aj;
            movie2.draw(canvas, f2 / f3, this.zo / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.pr != null) {
            this.m = i == 1;
            hn();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.pr != null) {
            this.m = i == 0;
            hn();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.pr != null) {
            this.m = i == 0;
            hn();
        }
    }
}
