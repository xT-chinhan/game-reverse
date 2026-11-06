package com.byazt.iy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.byazt.gq.w;
import com.byazt.gq.x;
import com.byazt.tk.k;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, 1124, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public abstract class rv<R extends com.byazt.gq.w, W extends com.byazt.gq.x> {
    public static final Rect sz = new Rect();
    public static final String x = "rv";
    public boolean a;
    public W cd;
    public final Set<Bitmap> cy;
    public final Set<n> d;
    public final com.byazt.zv.qg fs;
    public final Object hd;
    public final Runnable k;
    public ByteBuffer l;
    public final AtomicBoolean oa;
    public volatile qg py;
    public Map<Bitmap, Canvas> q;
    public final Handler rv;
    public int s;
    public int tj;
    public R um;
    public volatile Rect w;
    public List<fs<R, W>> n = new ArrayList();
    public int qg = -1;
    public Integer cp = null;

    public interface n {
        void n();

        void qg();

        void qg(ByteBuffer byteBuffer);
    }

    private enum qg {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String k() {
        return "";
    }

    public abstract void n(fs<R, W> fsVar);

    public abstract W q();

    public abstract int qg();

    public abstract Rect qg(R r) throws IOException;

    public abstract R s(com.byazt.gq.w wVar);

    public abstract void s();

    public Bitmap n(int i, int i2) {
        synchronized (this.hd) {
            Iterator<Bitmap> it = this.cy.iterator();
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
            } catch (Exception | OutOfMemoryError unused) {
            }
            return bitmapCreateBitmap;
        }
    }

    public void n(Bitmap bitmap) {
        synchronized (this.hd) {
            if (bitmap != null) {
                this.cy.add(bitmap);
            }
        }
    }

    public rv(com.byazt.zv.qg qgVar, n nVar) {
        HashSet hashSet = new HashSet();
        this.d = hashSet;
        this.oa = new AtomicBoolean(true);
        this.k = new Runnable() { // from class: com.byazt.iy.rv.1
            @Override // java.lang.Runnable
            public void run() {
                if (rv.this.oa.get()) {
                    return;
                }
                if (rv.this.hd()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    rv.this.rv.postDelayed(this, Math.max(0L, rv.this.cd() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    Iterator it = rv.this.d.iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).qg(rv.this.l);
                    }
                    return;
                }
                rv.this.rv();
            }
        };
        this.s = 1;
        this.cy = new HashSet();
        this.hd = new Object();
        this.q = new WeakHashMap();
        this.cd = (W) q();
        this.um = null;
        this.a = false;
        this.py = qg.IDLE;
        this.fs = qgVar;
        if (nVar != null) {
            hashSet.add(nVar);
        }
        this.rv = ((wo) com.byazt.qp.q.n("thread_service")).q();
    }

    public void n(final n nVar) {
        this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.2
            @Override // java.lang.Runnable
            public void run() {
                rv.this.d.add(nVar);
            }
        });
    }

    public void qg(final n nVar) {
        this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.3
            @Override // java.lang.Runnable
            public void run() {
                rv.this.d.remove(nVar);
            }
        });
    }

    public void l() {
        this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.4
            @Override // java.lang.Runnable
            public void run() {
                if (rv.this.d.size() == 0) {
                    rv.this.rv();
                }
            }
        });
    }

    public Rect w() {
        if (this.w == null) {
            if (this.py == qg.FINISHING) {
                k.qg(x, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (rv.this.w == null) {
                                if (rv.this.um != null) {
                                    rv.this.um.d_();
                                } else {
                                    rv rvVar = rv.this;
                                    rvVar.um = rvVar.s(rvVar.fs.qg());
                                }
                                rv rvVar2 = rv.this;
                                rvVar2.n(rvVar2.qg(rvVar2.um));
                            }
                        } catch (Exception unused) {
                            rv.this.w = rv.sz;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.w == null ? sz : this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Rect rect) {
        this.w = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.s;
        this.l = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.cd == null) {
            this.cd = (W) q();
        }
    }

    public int x() {
        return this.n.size();
    }

    public void fs() {
        if (this.w == sz) {
            return;
        }
        if (this.py == qg.RUNNING || this.py == qg.INITIALIZING) {
            k();
            return;
        }
        if (this.py == qg.FINISHING) {
            k.qg(x, k() + " Processing,wait for finish at " + this.py);
        }
        this.py = qg.INITIALIZING;
        if (Looper.myLooper() == this.rv.getLooper()) {
            n();
        } else {
            this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.6
                @Override // java.lang.Runnable
                public void run() {
                    rv.this.n();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.oa.compareAndSet(true, false);
        System.currentTimeMillis();
        try {
            if (this.n.size() == 0) {
                try {
                    R r = this.um;
                    if (r == null) {
                        this.um = (R) s(this.fs.qg());
                    } else {
                        r.d_();
                    }
                    n(qg(this.um));
                } catch (Throwable unused) {
                }
            }
            k();
            System.currentTimeMillis();
            this.py = qg.RUNNING;
            if (cy() == 0 || !this.a) {
                this.qg = -1;
                this.k.run();
                Iterator<n> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().n();
                }
                return;
            }
            k();
        } catch (Throwable th) {
            k();
            System.currentTimeMillis();
            this.py = qg.RUNNING;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        this.rv.removeCallbacks(this.k);
        this.n.clear();
        synchronized (this.hd) {
            for (Bitmap bitmap : this.cy) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.cy.clear();
        }
        if (this.l != null) {
            this.l = null;
        }
        this.q.clear();
        try {
            if (this.um != null) {
                this.um = null;
            }
        } catch (IOException unused) {
        }
        s();
        this.py = qg.IDLE;
        Iterator<n> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().qg();
        }
    }

    public void rv() {
        if (this.w == sz) {
            return;
        }
        if (this.py == qg.FINISHING || this.py == qg.IDLE) {
            k();
            return;
        }
        if (this.py == qg.INITIALIZING) {
            k.qg(x, k() + "Processing,wait for finish at " + this.py);
        }
        this.py = qg.FINISHING;
        if (Looper.myLooper() == this.rv.getLooper()) {
            sz();
        } else {
            this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.7
                @Override // java.lang.Runnable
                public void run() {
                    rv.this.sz();
                }
            });
        }
    }

    public boolean tj() {
        return this.py == qg.RUNNING || this.py == qg.INITIALIZING;
    }

    public void cp() {
        this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.8
            @Override // java.lang.Runnable
            public void run() {
                rv.this.tj = 0;
                rv.this.qg = -1;
                rv.this.a = false;
            }
        });
    }

    public int d() {
        return this.s;
    }

    public boolean qg(int i, int i2) {
        final int iS = s(i, i2);
        if (iS == this.s) {
            return false;
        }
        final boolean zTj = tj();
        this.rv.removeCallbacks(this.k);
        this.rv.post(new Runnable() { // from class: com.byazt.iy.rv.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                rv.this.sz();
                try {
                    rv.this.s = iS;
                    rv rvVar = rv.this;
                    rvVar.n(rvVar.qg(rvVar.s(rvVar.fs.qg())));
                    if (zTj) {
                        rv.this.n();
                    }
                } catch (IOException unused) {
                }
            }
        });
        return true;
    }

    public int s(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(w().width() / i, w().height() / i2);
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

    private int cy() {
        Integer num = this.cp;
        return num != null ? num.intValue() : qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hd() {
        if (!tj() || this.n.size() == 0) {
            return false;
        }
        if (cy() <= 0 || this.tj < cy() - 1) {
            return true;
        }
        if (this.tj == cy() - 1 && this.qg < x() - 1) {
            return true;
        }
        this.a = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cd() {
        int i = this.qg + 1;
        this.qg = i;
        if (i >= x()) {
            this.qg = 0;
            this.tj++;
        }
        fs<R, W> fsVarN = n(this.qg);
        if (fsVarN == null) {
            return 0L;
        }
        n(fsVarN);
        return fsVarN.d;
    }

    public fs<R, W> n(int i) {
        if (i < 0 || i >= this.n.size()) {
            return null;
        }
        return this.n.get(i);
    }
}
