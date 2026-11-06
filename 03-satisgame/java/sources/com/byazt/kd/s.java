package com.byazt.kd;

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
import com.byazt.iy.rv;
import com.byazt.tk.k;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 810, 8})
public abstract class s<Decoder extends rv<?, ?>> extends Drawable implements rv.n, qg {
    public static final String n = "s";
    public final Set<WeakReference<Drawable.Callback>> cp;
    public boolean d;
    public final Handler fs;
    public final Matrix l;
    public final DrawFilter q;
    public final Paint qg;
    public final Runnable rv;
    public final Decoder s;
    public boolean tj;
    public final Set<Object> w;
    public Bitmap x;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public abstract Decoder qg(com.byazt.zv.qg qgVar, rv.n nVar);

    public s(com.byazt.zv.qg qgVar) {
        Paint paint = new Paint();
        this.qg = paint;
        this.q = new PaintFlagsDrawFilter(0, 3);
        this.l = new Matrix();
        this.w = new HashSet();
        this.fs = new Handler(Looper.getMainLooper()) { // from class: com.byazt.kd.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(s.this.w).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(s.this.w).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.rv = new Runnable() { // from class: com.byazt.kd.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.invalidateSelf();
            }
        };
        this.tj = true;
        this.cp = new HashSet();
        this.d = false;
        paint.setAntiAlias(true);
        this.s = (Decoder) qg(qgVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.s.tj()) {
            this.s.rv();
        }
        this.s.cp();
        s();
    }

    private void s() {
        this.s.n(this);
        if (this.tj) {
            this.s.fs();
        } else {
            if (this.s.tj()) {
                return;
            }
            this.s.fs();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        q();
    }

    private void q() {
        this.s.qg(this);
        if (this.tj) {
            this.s.rv();
        } else {
            this.s.l();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.s.tj();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.x;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.q);
        canvas.drawBitmap(this.x, this.l, this.qg);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zQg = this.s.qg(getBounds().width(), getBounds().height());
        this.l.setScale(((getBounds().width() * 1.0f) * this.s.d()) / this.s.w().width(), ((getBounds().height() * 1.0f) * this.s.d()) / this.s.w().height());
        if (zQg) {
            this.x = Bitmap.createBitmap(this.s.w().width() / this.s.d(), this.s.w().height() / this.s.d(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.qg.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.qg.setColorFilter(colorFilter);
    }

    @Override // com.byazt.iy.rv.n
    public void n() {
        Message.obtain(this.fs, 1).sendToTarget();
    }

    @Override // com.byazt.iy.rv.n
    public void qg(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.x;
            if (bitmap == null || bitmap.isRecycled()) {
                this.x = Bitmap.createBitmap(this.s.w().width() / this.s.d(), this.s.w().height() / this.s.d(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.x.getByteCount()) {
                k.qg(n, "onRender:Buffer not large enough for pixels");
            } else {
                this.x.copyPixelsFromBuffer(byteBuffer);
                this.fs.post(this.rv);
            }
        }
    }

    @Override // com.byazt.iy.rv.n
    public void qg() {
        Message.obtain(this.fs, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        l();
        if (this.tj) {
            if (z) {
                if (!isRunning()) {
                    s();
                }
            } else if (isRunning()) {
                q();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.d) {
            return -1;
        }
        try {
            return this.s.w().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.d) {
            return -1;
        }
        try {
            return this.s.w().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.cp)) {
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
            this.cp.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.cp.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.cp).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }
}
