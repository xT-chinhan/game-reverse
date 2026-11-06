package com.bytedance.adsdk.ms.ms.ms;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.ms.ms.xr.ab;
import com.bytedance.adsdk.ms.ms.xr.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ny<R extends com.bytedance.adsdk.ms.ms.xr.c, W extends com.bytedance.adsdk.ms.ms.xr.ab> {
    private static final String ab = "ny";
    private static final Rect u = new Rect();
    protected int ah;
    private final Set<Bitmap> ao;
    protected volatile Rect c;
    private int ch;
    protected Map<Bitmap, Canvas> d;
    private final Object h;
    protected ByteBuffer ka;
    private volatile xr nw;
    private final Handler ny;
    private W qv;
    private final Set<ms> sl;
    private boolean t;
    private final Runnable ub;
    private final com.bytedance.adsdk.ms.ms.ah.xr x;
    private R y;
    private final AtomicBoolean zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected List<x<R, W>> f309ms = new ArrayList();
    protected int xr = -1;
    private Integer hi = null;

    public interface ms {
        void ms();

        void xr();

        void xr(ByteBuffer byteBuffer);
    }

    private enum xr {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String ub() {
        return "";
    }

    protected abstract R ah(com.bytedance.adsdk.ms.ms.xr.c cVar);

    protected abstract void ah();

    protected abstract W d();

    protected abstract void ms(x<R, W> xVar);

    protected abstract int xr();

    protected abstract Rect xr(R r) throws IOException;

    protected Bitmap ms(int i, int i2) {
        synchronized (this.h) {
            Iterator<Bitmap> it = this.ao.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i3 = i * i2 * 4;
                Bitmap next = it.next();
                if (next != null && next.getAllocationByteCount() >= i3) {
                    it.remove();
                    if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                        next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmapCreateBitmap = next;
            }
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            } catch (OutOfMemoryError e2) {
                com.bytedance.sdk.component.utils.sl.ms(e2);
            }
            return bitmapCreateBitmap;
        }
    }

    protected void ms(Bitmap bitmap) {
        synchronized (this.h) {
            if (bitmap != null) {
                this.ao.add(bitmap);
            }
        }
    }

    public ny(com.bytedance.adsdk.ms.ms.ah.xr xrVar, ms msVar) {
        HashSet hashSet = new HashSet();
        this.sl = hashSet;
        this.zb = new AtomicBoolean(true);
        this.ub = new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.1
            @Override // java.lang.Runnable
            public void run() {
                if (ny.this.zb.get()) {
                    return;
                }
                if (ny.this.h()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ny.this.ny.postDelayed(this, Math.max(0L, ny.this.qv() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    Iterator it = ny.this.sl.iterator();
                    while (it.hasNext()) {
                        ((ms) it.next()).xr(ny.this.ka);
                    }
                    return;
                }
                ny.this.ny();
            }
        };
        this.ah = 1;
        this.ao = new HashSet();
        this.h = new Object();
        this.d = new WeakHashMap();
        this.qv = (W) d();
        this.y = null;
        this.t = false;
        this.nw = xr.IDLE;
        this.x = xrVar;
        if (msVar != null) {
            hashSet.add(msVar);
        }
        this.ny = com.bytedance.sdk.component.ch.xr.ms.ms().xr();
    }

    public void ms(final ms msVar) {
        this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.2
            @Override // java.lang.Runnable
            public void run() {
                ny.this.sl.add(msVar);
            }
        });
    }

    public void xr(final ms msVar) {
        this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.3
            @Override // java.lang.Runnable
            public void run() {
                ny.this.sl.remove(msVar);
            }
        });
    }

    public void ka() {
        this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.4
            @Override // java.lang.Runnable
            public void run() {
                if (ny.this.sl.size() == 0) {
                    ny.this.ny();
                }
            }
        });
    }

    public Rect c() {
        if (this.c == null) {
            if (this.nw == xr.FINISHING) {
                com.bytedance.sdk.component.utils.sl.d(ab, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (ny.this.c == null) {
                                if (ny.this.y != null) {
                                    ny.this.y.d_();
                                } else {
                                    ny nyVar = ny.this;
                                    nyVar.y = nyVar.ah(nyVar.x.xr());
                                }
                                ny nyVar2 = ny.this;
                                nyVar2.ms(nyVar2.xr(nyVar2.y));
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.sl.ms(e);
                            ny.this.c = ny.u;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.c == null ? u : this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Rect rect) {
        this.c = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.ah;
        this.ka = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.qv == null) {
            this.qv = (W) d();
        }
    }

    public int ab() {
        return this.f309ms.size();
    }

    public void x() {
        if (this.c == u) {
            return;
        }
        if (this.nw == xr.RUNNING || this.nw == xr.INITIALIZING) {
            com.bytedance.sdk.component.utils.sl.ms(ab, ub() + " Already started");
            return;
        }
        if (this.nw == xr.FINISHING) {
            com.bytedance.sdk.component.utils.sl.d(ab, ub() + " Processing,wait for finish at " + this.nw);
        }
        this.nw = xr.INITIALIZING;
        if (Looper.myLooper() == this.ny.getLooper()) {
            ms();
        } else {
            this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.6
                @Override // java.lang.Runnable
                public void run() {
                    ny.this.ms();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        this.zb.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f309ms.size() == 0) {
                try {
                    R r = this.y;
                    if (r == null) {
                        this.y = (R) ah(this.x.xr());
                    } else {
                        r.d_();
                    }
                    ms(xr(this.y));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
            String str = ab;
            com.bytedance.sdk.component.utils.sl.ms(str, ub() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.nw = xr.RUNNING;
            if (ao() == 0 || !this.t) {
                this.xr = -1;
                this.ub.run();
                Iterator<ms> it = this.sl.iterator();
                while (it.hasNext()) {
                    it.next().ms();
                }
                return;
            }
            com.bytedance.sdk.component.utils.sl.ms(str, ub() + " No need to started");
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sl.ms(ab, ub() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.nw = xr.RUNNING;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.ny.removeCallbacks(this.ub);
        this.f309ms.clear();
        synchronized (this.h) {
            for (Bitmap bitmap : this.ao) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.ao.clear();
        }
        if (this.ka != null) {
            this.ka = null;
        }
        this.d.clear();
        try {
            if (this.y != null) {
                this.y = null;
            }
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        ah();
        this.nw = xr.IDLE;
        Iterator<ms> it = this.sl.iterator();
        while (it.hasNext()) {
            it.next().xr();
        }
    }

    public void ny() {
        if (this.c == u) {
            return;
        }
        if (this.nw == xr.FINISHING || this.nw == xr.IDLE) {
            com.bytedance.sdk.component.utils.sl.ms(ab, ub() + "No need to stop");
            return;
        }
        if (this.nw == xr.INITIALIZING) {
            com.bytedance.sdk.component.utils.sl.d(ab, ub() + "Processing,wait for finish at " + this.nw);
        }
        this.nw = xr.FINISHING;
        if (Looper.myLooper() == this.ny.getLooper()) {
            u();
        } else {
            this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.7
                @Override // java.lang.Runnable
                public void run() {
                    ny.this.u();
                }
            });
        }
    }

    public boolean ch() {
        return this.nw == xr.RUNNING || this.nw == xr.INITIALIZING;
    }

    public void hi() {
        this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.8
            @Override // java.lang.Runnable
            public void run() {
                ny.this.ch = 0;
                ny.this.xr = -1;
                ny.this.t = false;
            }
        });
    }

    public int sl() {
        return this.ah;
    }

    public boolean xr(int i, int i2) {
        final int iAh = ah(i, i2);
        if (iAh == this.ah) {
            return false;
        }
        final boolean zCh = ch();
        this.ny.removeCallbacks(this.ub);
        this.ny.post(new Runnable() { // from class: com.bytedance.adsdk.ms.ms.ms.ny.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ny.this.u();
                try {
                    ny.this.ah = iAh;
                    ny nyVar = ny.this;
                    nyVar.ms(nyVar.xr(nyVar.ah(nyVar.x.xr())));
                    if (zCh) {
                        ny.this.ms();
                    }
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
        return true;
    }

    protected int ah(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(c().width() / i, c().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int ao() {
        Integer num = this.hi;
        return num != null ? num.intValue() : xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!ch() || this.f309ms.size() == 0) {
            return false;
        }
        if (ao() <= 0 || this.ch < ao() - 1) {
            return true;
        }
        if (this.ch == ao() - 1 && this.xr < ab() - 1) {
            return true;
        }
        this.t = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long qv() {
        int i = this.xr + 1;
        this.xr = i;
        if (i >= ab()) {
            this.xr = 0;
            this.ch++;
        }
        x<R, W> xVarMs = ms(this.xr);
        if (xVarMs == null) {
            return 0L;
        }
        ms(xVarMs);
        return xVarMs.sl;
    }

    public x<R, W> ms(int i) {
        if (i < 0 || i >= this.f309ms.size()) {
            return null;
        }
        return this.f309ms.get(i);
    }
}
