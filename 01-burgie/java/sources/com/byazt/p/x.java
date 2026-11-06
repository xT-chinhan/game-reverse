package com.byazt.p;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.ca.iu;
import com.byazt.ihe.fw;
import com.byazt.ihe.m;
import com.byazt.n.uc;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 581, 121})
public class x implements hn.c, hn.fw, hn.InterfaceC0160hn, hn.hw, hn.pr, hn.uc, hn.x, qi.pr, fw {
    public SurfaceHolder c;
    public int fw;
    public boolean k;
    public boolean m;
    public volatile Handler nt;
    public volatile boolean qn;
    public boolean rc;
    public boolean ve;
    public com.byazt.n.hw ww;
    public SurfaceTexture x;
    public ArrayList<Runnable> z;
    public static final AtomicInteger pr = new AtomicInteger(0);
    public static final AtomicInteger hw = new AtomicInteger(0);
    public static final SparseIntArray iu = new SparseIntArray();
    public final AtomicBoolean hn = new AtomicBoolean(false);
    public int uc = 0;
    public boolean zo = false;
    public volatile hn aj = null;
    public final boolean vk = false;
    public boolean w = false;
    public volatile int g = 201;
    public long ho = -1;
    public volatile boolean yb = false;
    public boolean lb = false;
    public long qa = 0;
    public long a = Long.MIN_VALUE;
    public long cz = 0;
    public long ny = 0;
    public long fo = 0;
    public int b = 0;
    public final List<WeakReference<fw.pr>> gz = new CopyOnWriteArrayList();
    public m nl = null;
    public boolean y = false;
    public volatile int n = 200;
    public AtomicBoolean e = new AtomicBoolean(false);
    public AtomicBoolean s = new AtomicBoolean(false);
    public AtomicBoolean ls = new AtomicBoolean(false);
    public Surface er = null;
    public final Runnable v = new Runnable() { // from class: com.byazt.p.x.1
        @Override // java.lang.Runnable
        public void run() {
            if (x.this.aj == null) {
                return;
            }
            long jCz = x.this.cz();
            if (jCz > 0 && Build.VERSION.SDK_INT >= 23 && x.this.vk() && x.this.a != Long.MIN_VALUE) {
                try {
                    if (x.this.a == jCz) {
                        if (!x.this.lb && x.this.cz >= 400) {
                            x.this.hw(701, 800);
                            x.this.lb = true;
                        }
                        x.this.cz += (long) x.this.n;
                    } else {
                        if (x.this.lb) {
                            x.this.qa += x.this.cz;
                            x.this.hw(702, 800);
                            Object[] objArr = {"handleMsg:  bufferingDuration =", Long.valueOf(x.this.qa), "  bufferCount =", Integer.valueOf(x.this.uc)};
                        }
                        x.this.cz = 0L;
                        x.this.lb = false;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (x.this.a() > 0) {
                if (x.this.a != jCz) {
                    if (com.byazt.y.hw.x()) {
                        Object[] objArr2 = {"run: lastCur = ", Long.valueOf(x.this.a), "  curPosition = ", Long.valueOf(jCz)};
                    }
                    x xVar = x.this;
                    xVar.pr(jCz, xVar.a());
                }
                x.this.a = jCz;
            }
            if (!x.this.ho()) {
                if (x.this.nt != null) {
                    x.this.nt.postDelayed(this, x.this.n);
                }
            } else {
                x xVar2 = x.this;
                xVar2.pr(xVar2.a(), x.this.a());
            }
        }
    };
    public final pr qi = new pr();
    public long of = 0;
    public long ii = 0;
    public boolean i = true;

    public static int pr() {
        int i = hw.get();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    private void pr(String str) {
        com.byazt.n.hw hwVar = this.ww;
        if (hwVar != null) {
            hwVar.pr(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j, long j2) {
        fw.pr prVar;
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this, j, j2);
            }
        }
    }

    public x(String str, com.byazt.n.hw hwVar) {
        this.ww = hwVar;
        hw.incrementAndGet();
        pr("mda_" + str + "_" + pr.addAndGet(1), (Looper) null);
        pr("0501");
    }

    private void pr(String str, Looper looper) {
        this.b = 0;
        if (looper != null) {
            this.yb = true;
            this.nt = new iu(looper, this);
        } else if (this.nt == null) {
            this.nt = com.byazt.wy.pr.pr().pr(this, "csj_" + str);
        }
        ve();
    }

    private void iu() {
        this.qa = 0L;
        this.uc = 0;
        this.cz = 0L;
        this.lb = false;
        this.a = Long.MIN_VALUE;
    }

    @Override // com.byazt.ihe.fw
    public void pr(final boolean z) {
        if (m()) {
            return;
        }
        this.ve = z;
        if (this.aj != null) {
            this.aj.pr(z);
        } else if (this.nt != null) {
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.11
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.aj != null) {
                        x.this.aj.pr(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        if (this.nt != null) {
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.12
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.aj == null) {
                        try {
                            x.this.aj = new hw();
                        } catch (Throwable th) {
                            com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (x.this.aj != null) {
                            hn unused = x.this.aj;
                            x.this.aj.pr((hn.c) x.this);
                            x.this.aj.pr((hn.hw) x.this);
                            x.this.aj.pr((hn.InterfaceC0160hn) x.this);
                            x.this.aj.pr((hn.pr) x.this);
                            x.this.aj.pr((hn.uc) x.this);
                            x.this.aj.pr((hn.x) x.this);
                            x.this.aj.pr((hn.fw) x.this);
                            try {
                                x.this.aj.hn(false);
                            } catch (Throwable th2) {
                            }
                            x.this.w = false;
                        }
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        if (m() || this.aj == null) {
            return;
        }
        if (this.g != 206) {
            iu();
            this.qn = false;
            this.qi.pr(true);
            hw(0L);
            if (this.nt != null) {
                this.nt.removeCallbacks(this.v);
                this.nt.postDelayed(this.v, this.n);
            }
        }
        this.e.set(true);
        if ((this.s.get() || this.ls.get()) && this.nt != null) {
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.13
                @Override // java.lang.Runnable
                public void run() {
                    x.this.ls();
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, long j, boolean z2) {
        if (m()) {
            return;
        }
        ve();
        this.y = z2;
        this.qn = false;
        hw(z2);
        if (z) {
            this.ho = j;
            gz();
        } else {
            hw(j);
        }
        if (this.nt != null) {
            this.nt.removeCallbacks(this.v);
            this.nt.postDelayed(this.v, this.n);
        }
        this.e.set(true);
        if ((this.s.get() || this.ls.get()) && this.nt != null) {
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.14
                @Override // java.lang.Runnable
                public void run() {
                    x.this.ls();
                }
            });
        }
    }

    private void hw(long j) {
        this.qi.pr(j);
        if (this.ve) {
            hw(this.qi);
        } else if (hw(this.nl)) {
            hw(this.qi);
        } else {
            pr(this.qi);
        }
    }

    private boolean hw(m mVar) {
        return mVar != null && mVar.zo();
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        if (!m() && this.nt != null) {
            this.e.set(true);
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.15
                @Override // java.lang.Runnable
                public void run() {
                    fw.pr prVar;
                    if (x.this.k() && x.this.aj != null) {
                        try {
                            x.this.aj.c();
                            for (WeakReference weakReference : x.this.gz) {
                                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                                    prVar.uc(x.this);
                                }
                            }
                            x.this.g = 206;
                        } catch (Throwable th) {
                            Object[] objArr = {"play: catch exception ", th.getMessage()};
                        }
                    }
                }
            });
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 581, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    class pr implements Runnable {
        public boolean hn;
        public long hw;

        public pr() {
        }

        public void pr(boolean z) {
            this.hn = z;
        }

        public void pr(long j) {
            this.hw = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.aj != null) {
                try {
                    if (!this.hn) {
                        long jAj = x.this.aj.aj();
                        x.this.ho = Math.max(this.hw, jAj);
                    }
                    long unused = x.this.ho;
                } catch (Throwable th) {
                }
            }
            if (x.this.nt != null) {
                x.this.nt.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        if (!m() && this.nt != null) {
            this.nt.removeMessages(100);
            this.qn = true;
            if (!this.i) {
                if (this.rc || hw(this.nl)) {
                    if (this.nt != null) {
                        this.nt.sendEmptyMessage(101);
                        return;
                    }
                    return;
                }
                pr(new Runnable() { // from class: com.byazt.p.x.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (x.this.nt != null) {
                            x.this.nt.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            }
            if (this.zo || hw(this.nl)) {
                if (this.nt != null) {
                    this.nt.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            pr(new Runnable() { // from class: com.byazt.p.x.17
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.nt != null) {
                        x.this.nt.sendEmptyMessage(101);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        if (m()) {
            return;
        }
        hw(new Runnable() { // from class: com.byazt.p.x.18
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.nt != null) {
                    x.this.nt.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        if (m()) {
            return;
        }
        this.m = true;
        if (this.hn.compareAndSet(false, true)) {
            hw.decrementAndGet();
        }
        er();
        if (this.nt != null) {
            try {
                this.nt.removeCallbacksAndMessages(null);
                if (this.aj != null) {
                    this.nt.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
            }
            y();
        }
    }

    private void gz() {
        hw(new Runnable() { // from class: com.byazt.p.x.2
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.nt != null) {
                    x.this.nt.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        if (m()) {
            return;
        }
        hw(new Runnable() { // from class: com.byazt.p.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.nt != null) {
                    x.this.nt.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void pr(final long j) {
        if (m()) {
            return;
        }
        if (this.g == 207 || this.g == 206 || this.g == 209) {
            hw(new Runnable() { // from class: com.byazt.p.x.4
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.nt != null) {
                        x.this.nt.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        return this.zo;
    }

    @Override // com.byazt.ihe.fw
    public void pr(final SurfaceTexture surfaceTexture) {
        if (m()) {
            return;
        }
        this.x = surfaceTexture;
        pr(true);
        hw(new Runnable() { // from class: com.byazt.p.x.5
            @Override // java.lang.Runnable
            public void run() {
                x.this.ve();
                if (x.this.nt != null) {
                    x.this.nt.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void pr(final SurfaceHolder surfaceHolder) {
        if (m()) {
            return;
        }
        this.c = surfaceHolder;
        pr(true);
        hw(new Runnable() { // from class: com.byazt.p.x.6
            @Override // java.lang.Runnable
            public void run() {
                x.this.ve();
                if (x.this.nt != null) {
                    x.this.nt.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public int aj() {
        if (m()) {
            return 203;
        }
        return this.g;
    }

    @Override // com.byazt.ihe.fw
    public void pr(final m mVar) {
        if (m()) {
            return;
        }
        this.nl = mVar;
        if (mVar != null) {
            this.i = !mVar.zo();
        }
        hw(new Runnable() { // from class: com.byazt.p.x.7
            @Override // java.lang.Runnable
            public void run() {
                x.this.ve();
                if (x.this.nt != null) {
                    x.this.nt.obtainMessage(107, mVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        return (this.g == 206 || (this.nt != null && this.nt.hasMessages(100))) && !this.qn;
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        return g() || vk() || k();
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        return ((this.g != 207 && !this.qn) || this.nt == null || this.nt.hasMessages(100)) ? false : true;
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        return this.m;
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        return this.g == 205;
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        return this.g == 209;
    }

    /* JADX WARN: Code duplicated, block: B:151:0x0256  */
    /* JADX WARN: Code duplicated, block: B:153:0x025e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0288  */
    /* JADX WARN: Code duplicated, block: B:159:0x0299  */
    /* JADX WARN: Code duplicated, block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:? A[RETURN, SYNTHETIC] */
    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        boolean z;
        boolean z2;
        com.byazt.n.hw hwVar;
        fw.pr prVar;
        fw.pr prVar2;
        fw.pr prVar3;
        fw.pr prVar4;
        int i = this.g;
        int i2 = message.what;
        if (this.aj == null) {
            z = false;
        } else {
            switch (message.what) {
                case 100:
                    z = false;
                    if (this.g == 205 || this.g == 207 || this.g == 209) {
                        try {
                            pr("0505");
                            this.aj.c();
                            this.fo = SystemClock.elapsedRealtime();
                            this.g = 206;
                            if (this.ho > 0) {
                                this.aj.pr(this.ho, this.fw);
                                this.ho = -1L;
                            }
                            if (this.nl != null) {
                                hw(this.y);
                            }
                            for (WeakReference<fw.pr> weakReference : this.gz) {
                                if (weakReference != null && (prVar3 = weakReference.get()) != null) {
                                    prVar3.hw(this);
                                }
                                break;
                            }
                        } catch (Throwable th) {
                        }
                    } else {
                        z2 = true;
                    }
                    break;
                case 101:
                    if (this.lb) {
                        this.qa += this.cz;
                    }
                    this.lb = false;
                    this.cz = 0L;
                    this.a = Long.MIN_VALUE;
                    if (this.g == 206 || this.g == 207 || this.g == 209) {
                        try {
                            this.aj.fw();
                            pr("0507");
                            this.g = 207;
                            z = false;
                            try {
                                this.qn = false;
                                for (WeakReference<fw.pr> weakReference2 : this.gz) {
                                    if (weakReference2 != null && (prVar4 = weakReference2.get()) != null) {
                                        prVar4.c(this);
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                        } catch (Throwable th3) {
                            z = false;
                        }
                    } else {
                        z2 = true;
                    }
                    break;
                case 102:
                    try {
                        this.aj.k();
                        this.g = 201;
                        z = false;
                    } catch (Throwable th4) {
                        z = false;
                    }
                    break;
                case 103:
                    try {
                        nl();
                    } catch (Throwable th5) {
                        com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th5);
                    }
                    for (WeakReference<fw.pr> weakReference3 : this.gz) {
                        if (weakReference3 != null && (prVar2 = weakReference3.get()) != null) {
                            prVar2.x(this);
                        }
                    }
                    this.g = 203;
                    z = false;
                    break;
                case 104:
                    if (this.g == 202 || this.g == 208) {
                        try {
                            this.aj.zo();
                        } catch (Throwable th6) {
                            com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th6);
                        }
                        z = false;
                    } else {
                        z2 = true;
                    }
                    break;
                case 105:
                    if (this.g == 205 || this.g == 206 || this.g == 208 || this.g == 207 || this.g == 209) {
                        try {
                            this.aj.uc();
                            pr("0508");
                            this.g = 208;
                            break;
                        } catch (Throwable th7) {
                        }
                        z = false;
                    } else {
                        z2 = true;
                    }
                    break;
                case 106:
                    if (this.g == 206 || this.g == 207 || this.g == 209) {
                        try {
                            this.aj.pr(((Long) message.obj).longValue(), this.fw);
                            break;
                        } catch (Throwable th8) {
                        }
                        z = false;
                    } else {
                        z2 = true;
                    }
                    break;
                case 107:
                    iu();
                    if (this.g == 201 || this.g == 203) {
                        try {
                            uc ucVar = (uc) message.obj;
                            if (TextUtils.isEmpty(ucVar.c())) {
                                ucVar.pr(com.byazt.y.hw.pr());
                            }
                            File file = new File(ucVar.c(), ucVar.fo());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (com.byazt.y.hw.hw()) {
                                    hw(file.getAbsolutePath());
                                } else {
                                    this.aj.pr(file.getAbsolutePath());
                                }
                            } else {
                                ucVar.ny();
                                this.aj.pr(ucVar, this.ww);
                            }
                            pr("0503");
                            this.g = 202;
                            break;
                        } catch (Throwable th9) {
                        }
                        z = false;
                    } else {
                        z2 = true;
                    }
                    break;
                case 108:
                case 109:
                default:
                    z = false;
                    break;
                case 110:
                    try {
                        this.aj.pr((SurfaceHolder) message.obj);
                        pr("0502");
                        this.aj.hw(true);
                        this.s.set(true);
                        if (this.e.get()) {
                            ls();
                        }
                        z = false;
                    } catch (Throwable th10) {
                        z = false;
                    }
                    break;
                case 111:
                    try {
                        this.er = new Surface((SurfaceTexture) message.obj);
                        this.aj.pr(this.er);
                        pr("0502");
                        this.aj.hw(true);
                        this.ls.set(true);
                        if (this.e.get()) {
                            ls();
                        }
                        z = false;
                    } catch (Throwable th11) {
                        z = false;
                    }
                    break;
            }
            if (z2) {
                this.g = 200;
                if (!this.w) {
                    com.byazt.n.hn hnVar = new com.byazt.n.hn(308, i2);
                    hnVar.pr(i + "," + i2);
                    pr("0510");
                    hwVar = this.ww;
                    if (hwVar != null) {
                        hwVar.pr(308, i2, "state error");
                    }
                    for (WeakReference<fw.pr> weakReference4 : this.gz) {
                        if (weakReference4 == null && (prVar = weakReference4.get()) != null) {
                            prVar.pr(this, hnVar);
                        }
                    }
                    this.w = true;
                }
            }
        }
        z2 = z;
        if (z2) {
            this.g = 200;
            if (!this.w) {
                com.byazt.n.hn hnVar2 = new com.byazt.n.hn(308, i2);
                hnVar2.pr(i + "," + i2);
                pr("0510");
                hwVar = this.ww;
                if (hwVar != null) {
                    hwVar.pr(308, i2, "state error");
                }
                while (r2.hasNext()) {
                    if (weakReference4 == null) {
                    }
                }
                this.w = true;
            }
        }
    }

    private void hw(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.aj.pr(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void nl() {
        if (this.aj == null) {
            return;
        }
        try {
            this.aj.k();
        } catch (Throwable th) {
        }
        this.aj.pr((hn.hw) null);
        this.aj.pr((hn.fw) null);
        this.aj.pr((hn.pr) null);
        this.aj.pr((hn.x) null);
        this.aj.pr((hn.InterfaceC0160hn) null);
        this.aj.pr((hn.c) null);
        this.aj.pr((hn.uc) null);
        try {
            this.aj.w();
            com.byazt.n.hw hwVar = this.ww;
            if (hwVar != null) {
                hwVar.pr(this.a, this.nl);
            }
        } catch (Throwable th2) {
        }
    }

    private void y() {
        Handler handler = this.nt;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.byazt.p.x.8
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.nt != null && x.this.nt.getLooper() != null) {
                    try {
                        if (x.this.yb) {
                            x.this.nt.removeCallbacksAndMessages(null);
                        } else {
                            com.byazt.wy.pr.pr().pr(x.this.nt);
                        }
                        x.this.nt = null;
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    @Override // com.byazt.p.hn.pr
    public void pr(hn hnVar, int i) {
        fw.pr prVar;
        if (this.aj != hnVar) {
            return;
        }
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.hw(this, i);
            }
        }
    }

    private void ww() {
        SparseIntArray sparseIntArray = iu;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.b));
        if (numValueOf == null) {
            sparseIntArray.put(this.b, 1);
        } else {
            sparseIntArray.put(this.b, numValueOf.intValue() + 1);
        }
    }

    @Override // com.byazt.p.hn.hw
    public void pr(hn hnVar) {
        fw.pr prVar;
        this.g = 209;
        iu.delete(this.b);
        if (this.nt != null) {
            this.nt.removeCallbacks(this.v);
        }
        pr("0509");
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this);
            }
        }
    }

    @Override // com.byazt.p.hn.InterfaceC0160hn
    public boolean pr(hn hnVar, int i, int i2) {
        fw.pr prVar;
        com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "what=" + i + " extra=" + i2);
        ww();
        this.g = 200;
        if (this.nt != null) {
            this.nt.removeCallbacks(this.v);
        }
        if (pr(i, i2)) {
            y();
        }
        if (!this.e.get()) {
            return true;
        }
        this.e.set(false);
        com.byazt.n.hn hnVar2 = new com.byazt.n.hn(i, i2);
        pr("0510");
        com.byazt.n.hw hwVar = this.ww;
        if (hwVar != null) {
            hwVar.pr(i, i2, "");
        }
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this, hnVar2);
            }
        }
        return true;
    }

    private boolean pr(int i, int i2) {
        boolean z;
        switch (i) {
            case -1010:
            case -1007:
            case -1004:
            case -110:
            case 100:
            case 200:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        switch (i2) {
            case 1:
            case 700:
            case 800:
                return true;
            default:
                return z;
        }
    }

    @Override // com.byazt.p.hn.x
    public boolean hw(hn hnVar, int i, int i2) {
        fw.pr prVar;
        com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.aj != hnVar) {
            return false;
        }
        if (i2 == -1004) {
            com.byazt.n.hn hnVar2 = new com.byazt.n.hn(i, i2);
            pr("0510");
            com.byazt.n.hw hwVar = this.ww;
            if (hwVar != null) {
                hwVar.pr(i, i2, "");
            }
            for (WeakReference<fw.pr> weakReference : this.gz) {
                if (weakReference != null && (prVar = weakReference.get()) != null) {
                    prVar.pr(this, hnVar2);
                }
            }
        }
        hw(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i, int i2) {
        fw.pr prVar;
        fw.pr prVar2;
        if (i == 701) {
            this.of = SystemClock.elapsedRealtime();
            this.uc++;
            for (WeakReference<fw.pr> weakReference : this.gz) {
                if (weakReference != null && (prVar2 = weakReference.get()) != null) {
                    prVar2.pr(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            Object[] objArr = {"bufferCount = ", Integer.valueOf(this.uc)};
            return;
        }
        if (i != 702) {
            if (this.i && i == 3) {
                ls();
                n();
                hw(this.y);
                return;
            }
            return;
        }
        if (this.of > 0) {
            this.ii += SystemClock.elapsedRealtime() - this.of;
            this.of = 0L;
        }
        for (WeakReference<fw.pr> weakReference2 : this.gz) {
            if (weakReference2 != null && (prVar = weakReference2.get()) != null) {
                prVar.pr((fw) this, Integer.MAX_VALUE);
            }
        }
        Object[] objArr2 = {"bufferCount = ", Integer.valueOf(this.uc), " mBufferTotalTime = ", Long.valueOf(this.ii)};
    }

    @Override // com.byazt.p.hn.c
    public void hw(hn hnVar) {
        fw.pr prVar;
        if (m()) {
            return;
        }
        this.g = 205;
        try {
            m mVar = this.nl;
            if (mVar != null) {
                float fCz = mVar.cz();
                if (fCz > 0.0f) {
                    com.byazt.y.pr prVar2 = new com.byazt.y.pr();
                    prVar2.pr(fCz);
                    this.aj.pr(prVar2);
                }
            }
        } catch (Throwable th) {
        }
        if (this.nt != null) {
            if (this.qn) {
                e();
            } else {
                com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.nt.sendMessage(this.nt.obtainMessage(100, -1, -1));
            }
        }
        iu.delete(this.b);
        com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", "onPrepared:" + this.i + " " + this.rc);
        if (!this.i && !this.rc) {
            n();
            this.rc = true;
        }
        pr("0504");
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.hn(this);
            }
        }
    }

    private void n() {
        fw.pr prVar;
        pr("0506");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fo;
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this, jElapsedRealtime);
            }
        }
        this.zo = true;
    }

    private void e() {
        if (this.nt != null) {
            this.nt.post(new Runnable() { // from class: com.byazt.p.x.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        x.this.aj.fw();
                        x.this.g = 207;
                        x.this.qn = false;
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.p.hn.uc
    public void hn(hn hnVar) {
        fw.pr prVar;
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr((fw) this, true);
            }
        }
    }

    private void pr(Runnable runnable) {
        try {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            this.z.add(runnable);
        } catch (Throwable th) {
            com.byazt.o.hw.pr("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void s() {
        if (this.k) {
            return;
        }
        this.k = true;
        Iterator it = new ArrayList(this.z).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.z.clear();
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        ArrayList<Runnable> arrayList = this.z;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        s();
    }

    private void er() {
        ArrayList<Runnable> arrayList = this.z;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.z.clear();
    }

    private void hw(Runnable runnable) {
        if (runnable == null || m()) {
            return;
        }
        if (!this.m) {
            runnable.run();
        } else {
            pr(runnable);
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw(final boolean z) {
        if (m() || this.nt == null) {
            return;
        }
        this.nt.post(new Runnable() { // from class: com.byazt.p.x.10
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.m() || x.this.aj == null) {
                    return;
                }
                try {
                    x.this.y = z;
                    x.this.aj.x(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.lb) {
                long j = this.cz;
                if (j > 0) {
                    return this.qa + j;
                }
            }
            return this.qa;
        }
        return this.ii;
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        if (this.aj != null && !m()) {
            return this.aj.m();
        }
        return 0;
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        if (this.aj != null && !m()) {
            return this.aj.g();
        }
        return 0;
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        return this.uc;
    }

    @Override // com.byazt.p.hn.fw
    public void pr(hn hnVar, int i, int i2, int i3, int i4) {
        fw.pr prVar;
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr((fw) this, i, i2);
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        long j = this.ny;
        if (j != 0) {
            return j;
        }
        if (this.g == 206 || this.g == 207) {
            try {
                this.ny = this.aj.vk();
            } catch (Throwable th) {
            }
        }
        return this.ny;
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        if (m()) {
            return 0L;
        }
        if (this.g == 206 || this.g == 207) {
            try {
                return this.aj.aj();
            } catch (Throwable th) {
            }
        }
        return 0L;
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
        if (m()) {
            return;
        }
        this.aj.c(z);
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        return (m() || this.aj == null || !this.aj.ho()) ? false : true;
    }

    @Override // com.byazt.ihe.fw
    public void pr(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        for (WeakReference<fw.pr> weakReference : this.gz) {
            if (weakReference != null && weakReference.get() == prVar) {
                return;
            }
        }
        this.gz.add(new WeakReference<>(prVar));
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        Iterator<WeakReference<fw.pr>> it = this.gz.iterator();
        while (it.hasNext()) {
            WeakReference<fw.pr> next = it.next();
            if (next != null && next.get() == prVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        if (m()) {
            return;
        }
        this.n = i;
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        return this.n;
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        return this.c;
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        return this.x;
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
        this.fw = i;
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
        try {
            com.byazt.y.pr prVar = new com.byazt.y.pr();
            prVar.pr(f);
            this.aj.pr(prVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        return "";
    }
}
