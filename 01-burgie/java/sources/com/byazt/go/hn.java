package com.byazt.go;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.ca.ho;
import com.byazt.tiu.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 20})
public abstract class hn<Decoder extends aj<?, ?>> extends Drawable implements hw, aj.pr {
    public static final String pr = hn.class.getSimpleName();
    public final Runnable aj;
    public final Matrix c;
    public Bitmap fw;
    public final Decoder hn;
    public final Paint hw;
    public boolean k;
    public final Set<Object> uc;
    public boolean vk;
    public final Set<WeakReference<Drawable.Callback>> w;
    public final DrawFilter x;
    public final Handler zo;

    public abstract Decoder hw(com.byazt.eu.hw hwVar, aj.pr prVar);

    public hn(com.byazt.eu.hw hwVar) {
        Paint paint = new Paint();
        this.hw = paint;
        this.x = new PaintFlagsDrawFilter(0, 3);
        this.c = new Matrix();
        this.uc = new HashSet();
        this.zo = new Handler(Looper.getMainLooper()) { // from class: com.byazt.go.hn.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        Iterator it = new ArrayList(hn.this.uc).iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case 2:
                        Iterator it2 = new ArrayList(hn.this.uc).iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                        break;
                }
            }
        };
        this.aj = new Runnable() { // from class: com.byazt.go.hn.2
            @Override // java.lang.Runnable
            public void run() {
                hn.this.invalidateSelf();
            }
        };
        this.vk = true;
        this.w = new HashSet();
        this.k = false;
        paint.setAntiAlias(true);
        this.hn = (Decoder) hw(hwVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.hn.vk()) {
            this.hn.aj();
        }
        this.hn.w();
        hn();
    }

    private void hn() {
        this.hn.pr(this);
        if (this.vk) {
            this.hn.zo();
        } else if (!this.hn.vk()) {
            this.hn.zo();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        x();
    }

    private void x() {
        this.hn.hw(this);
        if (this.vk) {
            this.hn.aj();
        } else {
            this.hn.c();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.hn.vk();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.fw;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.x);
        canvas.drawBitmap(this.fw, this.c, this.hw);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zHw = this.hn.hw(getBounds().width(), getBounds().height());
        this.c.setScale(((getBounds().width() * 1.0f) * this.hn.k()) / this.hn.uc().width(), ((getBounds().height() * 1.0f) * this.hn.k()) / this.hn.uc().height());
        if (zHw) {
            this.fw = Bitmap.createBitmap(this.hn.uc().width() / this.hn.k(), this.hn.uc().height() / this.hn.k(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.hw.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.hw.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.byazt.tiu.aj.pr
    public void pr() {
        Message.obtain(this.zo, 1).sendToTarget();
    }

    @Override // com.byazt.tiu.aj.pr
    public void hw(ByteBuffer byteBuffer) {
        if (!isRunning()) {
            return;
        }
        Bitmap bitmap = this.fw;
        if (bitmap == null || bitmap.isRecycled()) {
            this.fw = Bitmap.createBitmap(this.hn.uc().width() / this.hn.k(), this.hn.uc().height() / this.hn.k(), Bitmap.Config.ARGB_4444);
        }
        byteBuffer.rewind();
        if (byteBuffer.remaining() < this.fw.getByteCount()) {
            ho.hw(pr, "onRender:Buffer not large enough for pixels");
        } else {
            this.fw.copyPixelsFromBuffer(byteBuffer);
            this.zo.post(this.aj);
        }
    }

    @Override // com.byazt.tiu.aj.pr
    public void hw() {
        Message.obtain(this.zo, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        c();
        if (this.vk) {
            if (z) {
                if (!isRunning()) {
                    hn();
                }
            } else if (isRunning()) {
                x();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.k) {
            return -1;
        }
        try {
            return this.hn.uc().width();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.k) {
            return -1;
        }
        try {
            return this.hn.uc().height();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.w)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.w.remove((WeakReference) it.next());
        }
        if (!z) {
            this.w.add(new WeakReference<>(callback));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.w).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }
}
