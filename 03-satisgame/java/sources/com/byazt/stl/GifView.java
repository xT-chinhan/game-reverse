package com.byazt.stl;

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
import com.byazt.cq.l;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1203})
public class GifView extends ImageView {
    public int cp;
    public volatile boolean d;
    public float fs;
    public boolean l;
    public Movie n;
    public boolean oa;
    public AnimatedImageDrawable q;
    public long qg;
    public float rv;
    public int s;
    public boolean sz;
    public int tj;
    public boolean w;
    public float x;

    interface n {
        void n(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.l = Build.VERSION.SDK_INT >= 28;
        this.w = false;
        this.oa = true;
        this.sz = true;
        n();
    }

    public void n() {
        if (this.l) {
            return;
        }
        setLayerType(1, null);
    }

    public void n(byte[] bArr, boolean z) {
        this.d = z;
        if (bArr == null) {
            return;
        }
        if (!this.l) {
            this.n = n(bArr);
        } else {
            n(bArr, new n() { // from class: com.byazt.stl.GifView.1
                @Override // com.byazt.stl.GifView.n
                public void n(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.byazt.stl.GifView.1.1
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
            this.q = animatedImageDrawable;
            if (!this.d) {
                animatedImageDrawable.start();
            }
            if (!this.sz) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        s();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.sz = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.q) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            k.n("GifView", "setRepeatConfig error", e);
        }
    }

    private Movie n(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void n(final byte[] bArr, final n nVar) {
        if (bArr == null) {
            return;
        }
        l.n(new x("createGifApi28WithByteArrayBySafely") { // from class: com.byazt.stl.GifView.2
            @Override // java.lang.Runnable
            public void run() {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    GifView gifView = GifView.this;
                    nVar2.n(gifView.n(gifView.qg(bArr)));
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source qg(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File fileN = n(getContext(), com.byazt.gkj.n.n().s().tj() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileN);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileN);
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return sourceCreateSource;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    k.n("GifView", "GifView  getSourceByFile fail : ", th);
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

    public static File n(Context context, String str, String str2) {
        int iRv = com.byazt.gkj.n.n().s().rv();
        boolean zTj = com.byazt.gkj.n.n().s().tj();
        if (iRv == 1) {
            k.qg("splashLoadAd", "视频存储使用内部存储");
            return com.byazt.tk.x.qg(context, zTj, str, str2);
        }
        k.qg("splashLoadAd", "视频存储使用外存储");
        return com.byazt.tk.x.n(context, zTj, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable n(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void qg() {
        if (this.n == null || !this.d) {
            return;
        }
        this.d = false;
        if (!this.l) {
            this.qg = SystemClock.uptimeMillis() - ((long) this.s);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.q;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.q.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.l || (movie = this.n) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.n.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.rv = fMax;
        int i3 = (int) (iWidth * fMax);
        this.tj = i3;
        int i4 = (int) (iHeight * fMax);
        this.cp = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.n != null && !this.l) {
            this.x = (getWidth() - this.tj) / 2.0f;
            this.fs = (getHeight() - this.cp) / 2.0f;
        }
        this.oa = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.n != null && !this.l) {
            try {
                if (!this.d) {
                    q();
                    n(canvas);
                    s();
                    return;
                }
                n(canvas);
                return;
            } catch (Throwable th) {
                k.n("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void s() {
        if (this.n == null || this.l || !this.oa) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void q() {
        if (this.n == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.qg == 0) {
            this.qg = jUptimeMillis;
        }
        int iDuration = this.n.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.sz && Math.abs(iDuration - this.s) < 60) {
            this.s = iDuration;
            this.d = true;
        } else {
            this.s = (int) ((jUptimeMillis - this.qg) % ((long) iDuration));
        }
    }

    private void n(Canvas canvas) {
        Movie movie = this.n;
        if (movie == null) {
            return;
        }
        movie.setTime(this.s);
        float f = this.rv;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.n.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.n;
            float f2 = this.x;
            float f3 = this.rv;
            movie2.draw(canvas, f2 / f3, this.fs / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.n != null) {
            this.oa = i == 1;
            s();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.n != null) {
            this.oa = i == 0;
            s();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.n != null) {
            this.oa = i == 0;
            s();
        }
    }
}
