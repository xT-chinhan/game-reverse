package com.byazt.tiu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.byazt.ca.ho;
import com.byazt.fe.fw;
import com.byazt.fe.uc;
import com.byazt.vkw.qi;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 61})
public abstract class aj<R extends com.byazt.fe.uc, W extends com.byazt.fe.fw> {
    public static final String fw = aj.class.getSimpleName();
    public static final Rect g = new Rect();
    public boolean a;
    public final Handler aj;
    public ByteBuffer c;
    public volatile hw cz;
    public int hn;
    public final Runnable ho;
    public final Set<pr> k;
    public W lb;
    public final AtomicBoolean m;
    public final Set<Bitmap> nt;
    public R qa;
    public volatile Rect uc;
    public int vk;
    public Map<Bitmap, Canvas> x;
    public final Object yb;
    public final com.byazt.eu.hw zo;
    public List<zo<R, W>> pr = new ArrayList();
    public int hw = -1;
    public Integer w = null;

    private enum hw {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    public interface pr {
        void hw();

        void hw(ByteBuffer byteBuffer);

        void pr();
    }

    public abstract R hn(com.byazt.fe.uc ucVar);

    public abstract void hn();

    public abstract int hw();

    public abstract Rect hw(R r) throws IOException;

    public abstract void pr(zo<R, W> zoVar);

    public abstract W x();

    public Bitmap pr(int i, int i2) {
        synchronized (this.yb) {
            Iterator<Bitmap> it = this.nt.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i3 = i * i2 * 4;
                Bitmap next = it.next();
                if (Build.VERSION.SDK_INT >= 19) {
                    if (next != null && next.getAllocationByteCount() >= i3) {
                        it.remove();
                        if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                            next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                } else if (next != null && next.getByteCount() >= i3) {
                    if (next.getWidth() == i && next.getHeight() == i2) {
                        it.remove();
                        next.eraseColor(0);
                    }
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
            } catch (OutOfMemoryError e2) {
            }
            return bitmapCreateBitmap;
        }
    }

    public void pr(Bitmap bitmap) {
        synchronized (this.yb) {
            if (bitmap != null) {
                this.nt.add(bitmap);
            }
        }
    }

    public aj(com.byazt.eu.hw hwVar, pr prVar) {
        HashSet hashSet = new HashSet();
        this.k = hashSet;
        this.m = new AtomicBoolean(true);
        this.ho = new Runnable() { // from class: com.byazt.tiu.aj.1
            @Override // java.lang.Runnable
            public void run() {
                if (!aj.this.m.get()) {
                    if (aj.this.yb()) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        aj.this.aj.postDelayed(this, Math.max(0L, aj.this.lb() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                        Iterator it = aj.this.k.iterator();
                        while (it.hasNext()) {
                            ((pr) it.next()).hw(aj.this.c);
                        }
                        return;
                    }
                    aj.this.aj();
                }
            }
        };
        this.hn = 1;
        this.nt = new HashSet();
        this.yb = new Object();
        this.x = new WeakHashMap();
        this.lb = (W) x();
        this.qa = null;
        this.a = false;
        this.cz = hw.IDLE;
        this.zo = hwVar;
        if (prVar != null) {
            hashSet.add(prVar);
        }
        this.aj = ((qi) com.byazt.zs.uc.pr("thread_service")).x();
    }

    public void pr(final pr prVar) {
        this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.2
            @Override // java.lang.Runnable
            public void run() {
                aj.this.k.add(prVar);
            }
        });
    }

    public void hw(final pr prVar) {
        this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.3
            @Override // java.lang.Runnable
            public void run() {
                aj.this.k.remove(prVar);
            }
        });
    }

    public void c() {
        this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.4
            @Override // java.lang.Runnable
            public void run() {
                if (aj.this.k.size() == 0) {
                    aj.this.aj();
                }
            }
        });
    }

    public Rect uc() {
        if (this.uc == null) {
            if (this.cz == hw.FINISHING) {
                ho.hw(fw, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (aj.this.uc == null) {
                                if (aj.this.qa != null) {
                                    aj.this.qa.d_();
                                } else {
                                    aj ajVar = aj.this;
                                    ajVar.qa = ajVar.hn(ajVar.zo.hw());
                                }
                                aj ajVar2 = aj.this;
                                ajVar2.pr(ajVar2.hw(ajVar2.qa));
                            }
                        } catch (Exception e) {
                            aj.this.uc = aj.g;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.uc == null ? g : this.uc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Rect rect) {
        this.uc = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.hn;
        this.c = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.lb == null) {
            this.lb = (W) x();
        }
    }

    public int fw() {
        return this.pr.size();
    }

    public void zo() {
        if (this.uc == g) {
            return;
        }
        if (this.cz == hw.RUNNING || this.cz == hw.INITIALIZING) {
            ho();
            return;
        }
        if (this.cz == hw.FINISHING) {
            ho.hw(fw, ho() + " Processing,wait for finish at " + this.cz);
        }
        this.cz = hw.INITIALIZING;
        if (Looper.myLooper() == this.aj.getLooper()) {
            pr();
        } else {
            this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.6
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.pr();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        this.m.compareAndSet(true, false);
        System.currentTimeMillis();
        try {
            if (this.pr.size() == 0) {
                try {
                    R r = this.qa;
                    if (r == null) {
                        this.qa = (R) hn(this.zo.hw());
                    } else {
                        r.d_();
                    }
                    pr(hw(this.qa));
                } catch (Throwable th) {
                }
            }
            ho();
            System.currentTimeMillis();
            this.cz = hw.RUNNING;
            if (nt() == 0 || !this.a) {
                this.hw = -1;
                this.ho.run();
                Iterator<pr> it = this.k.iterator();
                while (it.hasNext()) {
                    it.next().pr();
                }
                return;
            }
            ho();
        } catch (Throwable th2) {
            ho();
            System.currentTimeMillis();
            this.cz = hw.RUNNING;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.aj.removeCallbacks(this.ho);
        this.pr.clear();
        synchronized (this.yb) {
            for (Bitmap bitmap : this.nt) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.nt.clear();
        }
        if (this.c != null) {
            this.c = null;
        }
        this.x.clear();
        try {
            if (this.qa != null) {
                this.qa = null;
            }
        } catch (IOException e) {
        }
        hn();
        this.cz = hw.IDLE;
        Iterator<pr> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().hw();
        }
    }

    public void aj() {
        if (this.uc == g) {
            return;
        }
        if (this.cz == hw.FINISHING || this.cz == hw.IDLE) {
            ho();
            return;
        }
        if (this.cz == hw.INITIALIZING) {
            ho.hw(fw, ho() + "Processing,wait for finish at " + this.cz);
        }
        this.cz = hw.FINISHING;
        if (Looper.myLooper() == this.aj.getLooper()) {
            g();
        } else {
            this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.7
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.g();
                }
            });
        }
    }

    private String ho() {
        return "";
    }

    public boolean vk() {
        return this.cz == hw.RUNNING || this.cz == hw.INITIALIZING;
    }

    public void w() {
        this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.8
            @Override // java.lang.Runnable
            public void run() {
                aj.this.vk = 0;
                aj.this.hw = -1;
                aj.this.a = false;
            }
        });
    }

    public int k() {
        return this.hn;
    }

    public boolean hw(int i, int i2) {
        final int iHn = hn(i, i2);
        if (iHn == this.hn) {
            return false;
        }
        final boolean zVk = vk();
        this.aj.removeCallbacks(this.ho);
        this.aj.post(new Runnable() { // from class: com.byazt.tiu.aj.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                aj.this.g();
                try {
                    aj.this.hn = iHn;
                    aj ajVar = aj.this;
                    ajVar.pr(ajVar.hw(ajVar.hn(ajVar.zo.hw())));
                    if (zVk) {
                        aj.this.pr();
                    }
                } catch (IOException e) {
                }
            }
        });
        return true;
    }

    public int hn(int i, int i2) {
        int i3 = 1;
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int iMin = Math.min(uc().width() / i, uc().height() / i2);
        while (true) {
            int i4 = i3 * 2;
            if (i4 <= iMin) {
                i3 = i4;
            } else {
                return i3;
            }
        }
    }

    private int nt() {
        Integer num = this.w;
        return num != null ? num.intValue() : hw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yb() {
        if (!vk() || this.pr.size() == 0) {
            return false;
        }
        if (nt() <= 0 || this.vk < nt() - 1) {
            return true;
        }
        if (this.vk == nt() - 1 && this.hw < fw() - 1) {
            return true;
        }
        this.a = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long lb() {
        int i = this.hw + 1;
        this.hw = i;
        if (i >= fw()) {
            this.hw = 0;
            this.vk++;
        }
        zo<R, W> zoVarPr = pr(this.hw);
        if (zoVarPr == null) {
            return 0L;
        }
        pr(zoVarPr);
        return zoVarPr.k;
    }

    public zo<R, W> pr(int i) {
        if (i < 0 || i >= this.pr.size()) {
            return null;
        }
        return this.pr.get(i);
    }
}
