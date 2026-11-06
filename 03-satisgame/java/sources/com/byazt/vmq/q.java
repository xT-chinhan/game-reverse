package com.byazt.vmq;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.zsl.l;
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
@com.byazt.cp.n(n = {0, 1, 1122, 5})
public class q implements s.l, s.n, s.q, s.qg, s.InterfaceC0374s, s.w, s.x, x, wo.n {
    public static final AtomicInteger n = new AtomicInteger(0);
    public static final AtomicInteger qg = new AtomicInteger(0);
    public static final SparseIntArray t = new SparseIntArray();
    public volatile Handler cy;
    public boolean d;
    public volatile boolean dg;
    public ArrayList<Runnable> hu;
    public SurfaceHolder l;
    public boolean m;
    public boolean oa;
    public SurfaceTexture q;
    public boolean ur;
    public oa v;
    public int x;
    public final AtomicBoolean s = new AtomicBoolean(false);
    public int w = 0;
    public boolean fs = false;
    public volatile s rv = null;
    public final boolean tj = false;
    public boolean cp = false;
    public volatile int sz = 201;
    public long k = -1;
    public volatile boolean hd = false;
    public boolean cd = false;
    public long um = 0;
    public long a = Long.MIN_VALUE;
    public long py = 0;
    public long ou = 0;
    public long wm = 0;
    public int h = 0;
    public final List<WeakReference<x.n>> bb = new CopyOnWriteArrayList();
    public k ln = null;
    public boolean lh = false;
    public volatile int j = 200;
    public AtomicBoolean an = new AtomicBoolean(false);
    public AtomicBoolean ae = new AtomicBoolean(false);
    public AtomicBoolean f = new AtomicBoolean(false);
    public Surface fi = null;
    public final Runnable df = new Runnable() { // from class: com.byazt.vmq.q.1
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.rv == null) {
                return;
            }
            long jPy = q.this.py();
            if (jPy > 0 && q.this.tj() && q.this.a != Long.MIN_VALUE) {
                try {
                    if (q.this.a == jPy) {
                        if (!q.this.cd && q.this.py >= 400) {
                            q.this.n(701, 800);
                            q.this.cd = true;
                        }
                        q.this.py += (long) q.this.j;
                    } else {
                        if (q.this.cd) {
                            q.this.um += q.this.py;
                            q.this.n(702, 800);
                            Object[] objArr = new Object[4];
                            Long.valueOf(q.this.um);
                            Integer.valueOf(q.this.w);
                        }
                        q.this.py = 0L;
                        q.this.cd = false;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (q.this.a() > 0) {
                if (q.this.a != jPy) {
                    if (com.byazt.iza.qg.q()) {
                        Object[] objArr2 = new Object[4];
                        Long.valueOf(q.this.a);
                        Long.valueOf(jPy);
                    }
                    q qVar = q.this;
                    qVar.n(jPy, qVar.a());
                }
                q.this.a = jPy;
            }
            if (!q.this.k() && !q.this.oa()) {
                if (q.this.cy != null) {
                    q.this.cy.postDelayed(this, q.this.j);
                }
            } else {
                q qVar2 = q.this;
                qVar2.n(qVar2.a(), q.this.a());
            }
        }
    };
    public final n oj = new n();
    public long u = 0;
    public long pk = 0;
    public boolean wo = true;

    @Override // com.byazt.ej.x
    public String h() {
        return "";
    }

    public static int n() {
        int i = qg.get();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    private void n(String str) {
        oa oaVar = this.v;
        if (oaVar != null) {
            oaVar.qg(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, long j2) {
        x.n nVar;
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this, j, j2);
            }
        }
    }

    public q(String str, oa oaVar) {
        this.v = oaVar;
        qg.incrementAndGet();
        n("mda_" + str + "_" + n.addAndGet(1), (Looper) null);
        n("0501");
    }

    private void n(String str, Looper looper) {
        this.h = 0;
        if (looper != null) {
            this.hd = true;
            this.cy = new t(looper, this);
        } else if (this.cy == null) {
            this.cy = com.byazt.txb.qg.n().n(this, "csj_" + str);
        }
        ur();
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
        oa oaVar2 = this.v;
        if (oaVar2 != null) {
            oaVar2.n(this.a, this.ln);
        }
        this.a = Long.MIN_VALUE;
        this.fs = false;
        this.v = oaVar;
        n("0501");
        qg(new Runnable() { // from class: com.byazt.vmq.q.12
            @Override // java.lang.Runnable
            public void run() {
                Handler handler = q.this.cy;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.byazt.vmq.q.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s sVar = q.this.rv;
                            if (sVar == null) {
                                return;
                            }
                            sVar.n((s.l) q.this);
                            sVar.n((s.qg) q.this);
                            sVar.n((s.InterfaceC0374s) q.this);
                            sVar.n((s.n) q.this);
                            sVar.n((s.w) q.this);
                            sVar.n((s.q) q.this);
                            sVar.n((s.x) q.this);
                        }
                    });
                }
            }
        });
    }

    private void t() {
        this.um = 0L;
        this.w = 0;
        this.py = 0L;
        this.cd = false;
        this.a = Long.MIN_VALUE;
    }

    @Override // com.byazt.ej.x
    public void n(final boolean z) {
        if (oa()) {
            return;
        }
        this.ur = z;
        if (this.rv != null) {
            this.rv.n(z);
        } else if (this.cy != null) {
            this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.13
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.rv != null) {
                        q.this.rv.n(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        if (this.cy != null) {
            this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.14
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.rv == null) {
                        try {
                            q.this.rv = new qg();
                        } catch (Throwable th) {
                            com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (q.this.rv == null) {
                            return;
                        }
                        s unused = q.this.rv;
                        q.this.rv.n((s.l) q.this);
                        q.this.rv.n((s.qg) q.this);
                        q.this.rv.n((s.InterfaceC0374s) q.this);
                        q.this.rv.n((s.n) q.this);
                        q.this.rv.n((s.w) q.this);
                        q.this.rv.n((s.q) q.this);
                        q.this.rv.n((s.x) q.this);
                        try {
                            q.this.rv.s(false);
                        } catch (Throwable unused2) {
                        }
                        q.this.cp = false;
                    }
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public void qg() {
        if (oa() || this.rv == null) {
            return;
        }
        if (this.sz != 206) {
            t();
            this.dg = false;
            this.oj.n(true);
            qg(0L);
            if (this.cy != null) {
                this.cy.removeCallbacks(this.df);
                this.cy.postDelayed(this.df, this.j);
            }
        }
        this.an.set(true);
        if ((this.ae.get() || this.f.get()) && this.cy != null) {
            this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.15
                @Override // java.lang.Runnable
                public void run() {
                    q.this.f();
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        if (oa()) {
            return;
        }
        ur();
        this.lh = z2;
        this.dg = false;
        qg(z2);
        if (z) {
            this.k = j;
            bb();
        } else {
            qg(j);
        }
        if (this.cy != null) {
            this.cy.removeCallbacks(this.df);
            this.cy.postDelayed(this.df, this.j);
        }
        this.an.set(true);
        if ((this.ae.get() || this.f.get()) && this.cy != null) {
            this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.16
                @Override // java.lang.Runnable
                public void run() {
                    q.this.f();
                }
            });
        }
    }

    private void qg(long j) {
        this.oj.n(j);
        if (this.ur) {
            qg(this.oj);
        } else if (qg(this.ln)) {
            qg(this.oj);
        } else {
            n(this.oj);
        }
    }

    private boolean qg(k kVar) {
        return kVar != null && kVar.fs();
    }

    @Override // com.byazt.ej.x
    public void s() {
        if (oa() || this.cy == null) {
            return;
        }
        this.an.set(true);
        this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.17
            @Override // java.lang.Runnable
            public void run() {
                x.n nVar;
                if (!q.this.d() || q.this.rv == null) {
                    return;
                }
                try {
                    q.this.rv.l();
                    for (WeakReference weakReference : q.this.bb) {
                        if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                            nVar.w(q.this);
                        }
                    }
                    q.this.sz = 206;
                } catch (Throwable th) {
                    Object[] objArr = new Object[2];
                    th.getMessage();
                }
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 1122, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    class n implements Runnable {
        public long qg;
        public boolean s;

        public n() {
        }

        public void n(boolean z) {
            this.s = z;
        }

        public void n(long j) {
            this.qg = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.rv != null) {
                try {
                    if (!this.s) {
                        long jRv = q.this.rv.rv();
                        q.this.k = Math.max(this.qg, jRv);
                    }
                    long unused = q.this.k;
                } catch (Throwable unused2) {
                }
            }
            if (q.this.cy != null) {
                q.this.cy.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    @Override // com.byazt.ej.x
    public void q() {
        if (oa() || this.cy == null) {
            return;
        }
        this.cy.removeMessages(100);
        this.dg = true;
        if (!this.wo) {
            if (this.m || qg(this.ln)) {
                if (this.cy != null) {
                    this.cy.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            n(new Runnable() { // from class: com.byazt.vmq.q.18
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.cy != null) {
                        q.this.cy.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.fs || qg(this.ln)) {
            if (this.cy != null) {
                this.cy.sendEmptyMessage(101);
                return;
            }
            return;
        }
        n(new Runnable() { // from class: com.byazt.vmq.q.19
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.cy != null) {
                    q.this.cy.sendEmptyMessage(101);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void l() {
        if (oa()) {
            return;
        }
        qg(new Runnable() { // from class: com.byazt.vmq.q.2
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.cy != null) {
                    q.this.cy.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void w() {
        if (oa()) {
            return;
        }
        this.oa = true;
        if (this.s.compareAndSet(false, true)) {
            qg.decrementAndGet();
        }
        fi();
        if (this.cy != null) {
            try {
                this.cy.removeCallbacksAndMessages(null);
                if (this.rv != null) {
                    this.cy.sendEmptyMessage(103);
                }
                lh();
            } catch (Throwable unused) {
                lh();
            }
        }
    }

    private void bb() {
        qg(new Runnable() { // from class: com.byazt.vmq.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.cy != null) {
                    q.this.cy.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void x() {
        if (oa()) {
            return;
        }
        qg(new Runnable() { // from class: com.byazt.vmq.q.4
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.cy != null) {
                    q.this.cy.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void n(final long j) {
        if (oa()) {
            return;
        }
        if (this.sz == 207 || this.sz == 206 || this.sz == 209) {
            qg(new Runnable() { // from class: com.byazt.vmq.q.5
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.cy != null) {
                        q.this.cy.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return this.fs;
    }

    @Override // com.byazt.ej.x
    public void n(final SurfaceTexture surfaceTexture) {
        if (oa()) {
            return;
        }
        this.q = surfaceTexture;
        n(true);
        qg(new Runnable() { // from class: com.byazt.vmq.q.6
            @Override // java.lang.Runnable
            public void run() {
                q.this.ur();
                if (q.this.cy != null) {
                    q.this.cy.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void n(final SurfaceHolder surfaceHolder) {
        if (oa()) {
            return;
        }
        this.l = surfaceHolder;
        n(true);
        qg(new Runnable() { // from class: com.byazt.vmq.q.7
            @Override // java.lang.Runnable
            public void run() {
                q.this.ur();
                if (q.this.cy != null) {
                    q.this.cy.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public int rv() {
        if (oa()) {
            return 203;
        }
        return this.sz;
    }

    @Override // com.byazt.ej.x
    public void n(final k kVar) {
        if (oa()) {
            return;
        }
        this.ln = kVar;
        if (kVar != null) {
            this.wo = !kVar.fs();
        }
        qg(new Runnable() { // from class: com.byazt.vmq.q.8
            @Override // java.lang.Runnable
            public void run() {
                q.this.ur();
                if (q.this.cy != null) {
                    q.this.cy.obtainMessage(107, kVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        return (this.sz == 206 || (this.cy != null && this.cy.hasMessages(100))) && !this.dg;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        return sz() || tj() || d();
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return ((this.sz != 207 && !this.dg) || this.cy == null || this.cy.hasMessages(100)) ? false : true;
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return this.oa;
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return this.sz == 205;
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return this.sz == 209;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:116:0x0218  */
    /* JADX WARN: Code duplicated, block: B:55:0x0120  */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i;
        int i2;
        x.n nVar;
        x.n nVar2;
        x.n nVar3;
        x.n nVar4;
        int i3 = this.sz;
        int i4 = message.what;
        if (this.rv != null) {
            i = message.what;
            try {
                try {
                    switch (i) {
                        case 100:
                            i = 0;
                            if (this.sz == 205 || this.sz == 207 || this.sz == 209) {
                                n("0505");
                                this.rv.l();
                                this.wm = SystemClock.elapsedRealtime();
                                this.sz = 206;
                                if (this.k > 0) {
                                    this.rv.n(this.k, this.x);
                                    this.k = -1L;
                                }
                                if (this.ln != null) {
                                    qg(this.lh);
                                }
                                for (WeakReference<x.n> weakReference : this.bb) {
                                    if (weakReference != null && (nVar3 = weakReference.get()) != null) {
                                        nVar3.qg(this);
                                    }
                                }
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 101:
                            if (this.cd) {
                                this.um += this.py;
                            }
                            this.cd = false;
                            this.py = 0L;
                            this.a = Long.MIN_VALUE;
                            if (this.sz == 206 || this.sz == 207 || this.sz == 209) {
                                this.rv.x();
                                n("0507");
                                this.sz = 207;
                                i = 0;
                                this.dg = false;
                                for (WeakReference<x.n> weakReference2 : this.bb) {
                                    if (weakReference2 != null && (nVar4 = weakReference2.get()) != null) {
                                        nVar4.l(this);
                                    }
                                }
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 102:
                            this.rv.d();
                            this.sz = 201;
                            i = 0;
                            i2 = i;
                            break;
                        case 103:
                            try {
                                ln();
                            } catch (Throwable th) {
                                com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                            }
                            for (WeakReference<x.n> weakReference3 : this.bb) {
                                if (weakReference3 != null && (nVar2 = weakReference3.get()) != null) {
                                    nVar2.q(this);
                                }
                            }
                            this.sz = 203;
                            i = 0;
                            i2 = i;
                            break;
                        case 104:
                            if (this.sz == 202 || this.sz == 208) {
                                try {
                                    this.rv.fs();
                                } catch (Throwable th2) {
                                    com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                                }
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 105:
                            if (this.sz == 205 || this.sz == 206 || this.sz == 208 || this.sz == 207 || this.sz == 209) {
                                this.rv.w();
                                n("0508");
                                this.sz = 208;
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 106:
                            if (this.sz == 206 || this.sz == 207 || this.sz == 209) {
                                this.rv.n(((Long) message.obj).longValue(), this.x);
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 107:
                            t();
                            if (this.sz == 201 || this.sz == 203) {
                                l lVar = (l) message.obj;
                                if (TextUtils.isEmpty(lVar.l())) {
                                    lVar.n(com.byazt.iza.qg.n());
                                }
                                File file = new File(lVar.l(), lVar.wm());
                                if (file.exists()) {
                                    file.getAbsolutePath();
                                    if (com.byazt.iza.qg.qg()) {
                                        qg(file.getAbsolutePath());
                                    } else {
                                        this.rv.n(file.getAbsolutePath());
                                    }
                                } else {
                                    lVar.ou();
                                    this.rv.n(lVar, this.v);
                                }
                                n("0503");
                                this.sz = 202;
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 108:
                        case 109:
                        default:
                            i = 0;
                            i2 = i;
                            break;
                        case 110:
                            this.rv.n((SurfaceHolder) message.obj);
                            n("0502");
                            this.rv.qg(true);
                            this.ae.set(true);
                            if (this.an.get()) {
                                f();
                            }
                            i = 0;
                            i2 = i;
                            break;
                        case 111:
                            this.fi = new Surface((SurfaceTexture) message.obj);
                            this.rv.n(this.fi);
                            n("0502");
                            this.rv.qg(true);
                            this.f.set(true);
                            if (this.an.get()) {
                                f();
                            }
                            i = 0;
                            i2 = i;
                            break;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        } else {
            i = 0;
            i2 = i;
        }
        if (i2 != 0) {
            this.sz = 200;
            if (this.cp) {
                return;
            }
            com.byazt.zsl.qg qgVar = new com.byazt.zsl.qg(308, i4);
            qgVar.n(i3 + "," + i4);
            n("0510");
            oa oaVar = this.v;
            if (oaVar != null) {
                oaVar.n(308, i4, "state error");
            }
            for (WeakReference<x.n> weakReference4 : this.bb) {
                if (weakReference4 != null && (nVar = weakReference4.get()) != null) {
                    nVar.n(this, qgVar);
                }
            }
            this.cp = true;
        }
    }

    private void qg(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.rv.n(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void ln() {
        if (this.rv == null) {
            return;
        }
        try {
            this.rv.d();
        } catch (Throwable unused) {
        }
        this.rv.n((s.qg) null);
        this.rv.n((s.x) null);
        this.rv.n((s.n) null);
        this.rv.n((s.q) null);
        this.rv.n((s.InterfaceC0374s) null);
        this.rv.n((s.l) null);
        this.rv.n((s.w) null);
        try {
            this.rv.cp();
            oa oaVar = this.v;
            if (oaVar != null) {
                oaVar.n(this.a, this.ln);
            }
        } catch (Throwable unused2) {
        }
    }

    private void lh() {
        Handler handler = this.cy;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.byazt.vmq.q.9
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.cy == null || q.this.cy.getLooper() == null) {
                    return;
                }
                try {
                    if (q.this.hd) {
                        q.this.cy.removeCallbacksAndMessages(null);
                    } else {
                        com.byazt.txb.qg.n().n(q.this.cy);
                    }
                    q.this.cy = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.vmq.s.n
    public void n(s sVar, int i) {
        x.n nVar;
        if (this.rv != sVar) {
            return;
        }
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.qg(this, i);
            }
        }
    }

    private void v() {
        SparseIntArray sparseIntArray = t;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.h));
        if (numValueOf == null) {
            sparseIntArray.put(this.h, 1);
        } else {
            sparseIntArray.put(this.h, numValueOf.intValue() + 1);
        }
    }

    @Override // com.byazt.vmq.s.qg
    public void n(s sVar) {
        x.n nVar;
        this.sz = 209;
        t.delete(this.h);
        if (this.cy != null) {
            this.cy.removeCallbacks(this.df);
        }
        n("0509");
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this);
            }
        }
    }

    @Override // com.byazt.vmq.s.InterfaceC0374s
    public boolean n(s sVar, int i, int i2) {
        x.n nVar;
        com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "what=" + i + " extra=" + i2);
        v();
        this.sz = 200;
        if (this.cy != null) {
            this.cy.removeCallbacks(this.df);
        }
        if (!this.an.get()) {
            return true;
        }
        this.an.set(false);
        com.byazt.zsl.qg qgVar = new com.byazt.zsl.qg(i, i2);
        n("0510");
        oa oaVar = this.v;
        if (oaVar != null) {
            oaVar.n(i, i2, "");
        }
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this, qgVar);
            }
        }
        return true;
    }

    @Override // com.byazt.vmq.s.q
    public boolean qg(s sVar, int i, int i2) {
        x.n nVar;
        com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.rv != sVar) {
            return false;
        }
        if (i2 == -1004) {
            com.byazt.zsl.qg qgVar = new com.byazt.zsl.qg(i, i2);
            n("0510");
            oa oaVar = this.v;
            if (oaVar != null) {
                oaVar.n(i, i2, "");
            }
            for (WeakReference<x.n> weakReference : this.bb) {
                if (weakReference != null && (nVar = weakReference.get()) != null) {
                    nVar.n(this, qgVar);
                }
            }
        }
        n(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        x.n nVar;
        x.n nVar2;
        if (i == 701) {
            this.u = SystemClock.elapsedRealtime();
            this.w++;
            for (WeakReference<x.n> weakReference : this.bb) {
                if (weakReference != null && (nVar2 = weakReference.get()) != null) {
                    nVar2.n(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            Object[] objArr = new Object[2];
            Integer.valueOf(this.w);
            return;
        }
        if (i == 702) {
            if (this.u > 0) {
                this.pk += SystemClock.elapsedRealtime() - this.u;
                this.u = 0L;
            }
            for (WeakReference<x.n> weakReference2 : this.bb) {
                if (weakReference2 != null && (nVar = weakReference2.get()) != null) {
                    nVar.n((x) this, Integer.MAX_VALUE);
                }
            }
            Object[] objArr2 = new Object[4];
            Integer.valueOf(this.w);
            Long.valueOf(this.pk);
            return;
        }
        if (this.wo && i == 3) {
            f();
            j();
            qg(this.lh);
        }
    }

    @Override // com.byazt.vmq.s.l
    public void qg(s sVar) {
        x.n nVar;
        if (oa()) {
            return;
        }
        this.sz = 205;
        try {
            k kVar = this.ln;
            if (kVar != null) {
                float fPy = kVar.py();
                if (fPy > 0.0f) {
                    com.byazt.iza.n nVar2 = new com.byazt.iza.n();
                    nVar2.n(fPy);
                    this.rv.n(nVar2);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.cy != null) {
            if (this.dg) {
                an();
            } else {
                com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.cy.sendMessage(this.cy.obtainMessage(100, -1, -1));
            }
        }
        t.delete(this.h);
        com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", "onPrepared:" + this.wo + " " + this.m);
        if (!this.wo && !this.m) {
            j();
            this.m = true;
        }
        n("0504");
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.s(this);
            }
        }
    }

    private void j() {
        x.n nVar;
        n("0506");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.wm;
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this, jElapsedRealtime);
            }
        }
        this.fs = true;
    }

    private void an() {
        if (this.cy != null) {
            this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        q.this.rv.x();
                        q.this.sz = 207;
                        q.this.dg = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.vmq.s.w
    public void s(s sVar) {
        x.n nVar;
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n((x) this, true);
            }
        }
    }

    private void n(Runnable runnable) {
        try {
            if (this.hu == null) {
                this.hu = new ArrayList<>();
            }
            this.hu.add(runnable);
        } catch (Throwable th) {
            com.byazt.nl.qg.n("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void ae() {
        if (this.d) {
            return;
        }
        this.d = true;
        Iterator it = new ArrayList(this.hu).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.hu.clear();
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList<Runnable> arrayList = this.hu;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ae();
    }

    private void fi() {
        ArrayList<Runnable> arrayList = this.hu;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.hu.clear();
    }

    private void qg(Runnable runnable) {
        if (runnable == null || oa()) {
            return;
        }
        if (!this.oa) {
            runnable.run();
        } else {
            n(runnable);
        }
    }

    @Override // com.byazt.ej.x
    public void qg(final boolean z) {
        if (oa() || this.cy == null) {
            return;
        }
        this.cy.post(new Runnable() { // from class: com.byazt.vmq.q.11
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.oa() || q.this.rv == null) {
                    return;
                }
                try {
                    q.this.lh = z;
                    q.this.rv.q(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public long cy() {
        if (this.cd) {
            long j = this.py;
            if (j > 0) {
                return this.um + j;
            }
        }
        return this.um;
    }

    @Override // com.byazt.ej.x
    public int hd() {
        if (this.rv == null || oa()) {
            return 0;
        }
        return this.rv.oa();
    }

    @Override // com.byazt.ej.x
    public int cd() {
        if (this.rv == null || oa()) {
            return 0;
        }
        return this.rv.sz();
    }

    @Override // com.byazt.ej.x
    public int um() {
        return this.w;
    }

    @Override // com.byazt.vmq.s.x
    public void n(s sVar, int i, int i2, int i3, int i4) {
        x.n nVar;
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n((x) this, i, i2);
            }
        }
    }

    @Override // com.byazt.ej.x
    public long a() {
        long j = this.ou;
        if (j != 0) {
            return j;
        }
        if (this.sz == 206 || this.sz == 207) {
            try {
                this.ou = this.rv.tj();
            } catch (Throwable unused) {
            }
        }
        return this.ou;
    }

    @Override // com.byazt.ej.x
    public long py() {
        if (oa()) {
            return 0L;
        }
        if (this.sz == 206 || this.sz == 207) {
            try {
                return this.rv.rv();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        if (oa()) {
            return;
        }
        this.rv.l(z);
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return (oa() || this.rv == null || !this.rv.k()) ? false : true;
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        if (nVar == null) {
            return;
        }
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && weakReference.get() == nVar) {
                return;
            }
        }
        this.bb.add(new WeakReference<>(nVar));
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        if (nVar == null) {
            return;
        }
        for (WeakReference<x.n> weakReference : this.bb) {
            if (weakReference != null && weakReference.get() == nVar) {
                this.bb.remove(weakReference);
            }
        }
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        if (oa()) {
            return;
        }
        this.j = i;
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.j;
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return this.l;
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return this.q;
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
        this.x = i;
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
        try {
            com.byazt.iza.n nVar = new com.byazt.iza.n();
            nVar.n(f);
            this.rv.n(nVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
