package com.bytedance.adsdk.ms.ms;

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
import com.bytedance.adsdk.ms.ms.ms.ny;
import com.bytedance.sdk.component.utils.sl;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah<Decoder extends ny<?, ?>> extends Drawable implements ny.ms, xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f299ms = "ah";
    private Bitmap ab;
    private final Decoder ah;
    private final Set<Object> c;
    private boolean ch;
    private final DrawFilter d;
    private final Set<WeakReference<Drawable.Callback>> hi;
    private final Matrix ka;
    private final Runnable ny;
    private boolean sl;
    private final Handler x;
    private final Paint xr;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    protected abstract Decoder xr(com.bytedance.adsdk.ms.ms.ah.xr xrVar, ny.ms msVar);

    public ah(com.bytedance.adsdk.ms.ms.ah.xr xrVar) {
        Paint paint = new Paint();
        this.xr = paint;
        this.d = new PaintFlagsDrawFilter(0, 3);
        this.ka = new Matrix();
        this.c = new HashSet();
        this.x = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.ms.ms.ah.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(ah.this.c).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(ah.this.c).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.ny = new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ah.2
            @Override // java.lang.Runnable
            public void run() {
                ah.this.invalidateSelf();
            }
        };
        this.ch = true;
        this.hi = new HashSet();
        this.sl = false;
        paint.setAntiAlias(true);
        this.ah = (Decoder) xr(xrVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.ah.ch()) {
            this.ah.ny();
        }
        this.ah.hi();
        ah();
    }

    private void ah() {
        this.ah.ms(this);
        if (this.ch) {
            this.ah.x();
        } else {
            if (this.ah.ch()) {
                return;
            }
            this.ah.x();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d();
    }

    private void d() {
        this.ah.xr(this);
        if (this.ch) {
            this.ah.ny();
        } else {
            this.ah.ka();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.ah.ch();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.ab;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.d);
        canvas.drawBitmap(this.ab, this.ka, this.xr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zXr = this.ah.xr(getBounds().width(), getBounds().height());
        this.ka.setScale(((getBounds().width() * 1.0f) * this.ah.sl()) / this.ah.c().width(), ((getBounds().height() * 1.0f) * this.ah.sl()) / this.ah.c().height());
        if (zXr) {
            this.ab = Bitmap.createBitmap(this.ah.c().width() / this.ah.sl(), this.ah.c().height() / this.ah.sl(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.xr.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.xr.setColorFilter(colorFilter);
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny.ms
    public void ms() {
        Message.obtain(this.x, 1).sendToTarget();
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny.ms
    public void xr(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.ab;
            if (bitmap == null || bitmap.isRecycled()) {
                this.ab = Bitmap.createBitmap(this.ah.c().width() / this.ah.sl(), this.ah.c().height() / this.ah.sl(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.ab.getByteCount()) {
                sl.d(f299ms, "onRender:Buffer not large enough for pixels");
            } else {
                this.ab.copyPixelsFromBuffer(byteBuffer);
                this.x.post(this.ny);
            }
        }
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny.ms
    public void xr() {
        Message.obtain(this.x, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        ka();
        if (this.ch) {
            if (z) {
                if (!isRunning()) {
                    ah();
                }
            } else if (isRunning()) {
                d();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.sl) {
            return -1;
        }
        try {
            return this.ah.c().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.sl) {
            return -1;
        }
        try {
            return this.ah.c().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void ka() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.hi)) {
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
            this.hi.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.hi.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.hi).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }
}
