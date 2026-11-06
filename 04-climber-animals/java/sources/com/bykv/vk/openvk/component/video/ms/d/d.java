package com.bykv.vk.openvk.component.video.ms.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.utils.le;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bykv.vk.openvk.component.video.api.ms, ah.ab, ah.InterfaceC0180ah, ah.c, ah.d, ah.ka, ah.ms, ah.xr, le.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final AtomicInteger f30ms = new AtomicInteger(0);
    private static final SparseIntArray yu = new SparseIntArray();
    private SurfaceHolder ah;
    private boolean b;
    private boolean ch;
    private boolean hi;
    private int ka;
    private volatile boolean m;
    private boolean op;
    private ArrayList<Runnable> re;
    private volatile le u;
    private SurfaceTexture xr;
    private int d = 0;
    private boolean c = false;
    private volatile ah ab = null;
    private final boolean x = false;
    private boolean ny = false;
    private volatile int sl = 201;
    private long zb = -1;
    private volatile boolean ub = false;
    private boolean ao = false;
    private long h = 0;
    private long qv = Long.MIN_VALUE;
    private long y = 0;
    private long t = 0;
    private long nw = 0;
    private int i = 0;
    private String w = "0";
    private final List<WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms>> le = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.component.video.api.ah.d cv = null;
    private boolean g = false;
    private volatile int of = 200;
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean pc = new AtomicBoolean(false);
    private AtomicBoolean jw = new AtomicBoolean(false);
    private Surface f = null;
    private final Runnable ul = new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ab == null) {
                return;
            }
            long jY = d.this.y();
            if (jY > 0 && d.this.zb() && d.this.qv != Long.MIN_VALUE) {
                try {
                    if (d.this.qv == jY) {
                        if (!d.this.ao && d.this.y >= 400) {
                            d.this.xr(701, 800);
                            d.this.ao = true;
                        }
                        d.this.y += (long) d.this.of;
                    } else {
                        if (d.this.ao) {
                            d.this.h += d.this.y;
                            d.this.xr(702, 800);
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(d.this.h), "  bufferCount =", Integer.valueOf(d.this.d));
                        }
                        d.this.y = 0L;
                        d.this.ao = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (d.this.qv() > 0) {
                if (d.this.qv != jY) {
                    if (com.bykv.vk.openvk.component.video.api.ah.d()) {
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(d.this.qv), "  curPosition = ", Long.valueOf(jY));
                    }
                    d dVar = d.this;
                    dVar.ms(jY, dVar.qv());
                }
                d.this.qv = jY;
            }
            if (!d.this.ny()) {
                if (d.this.u != null) {
                    d.this.u.postDelayed(this, d.this.of);
                }
            } else {
                d dVar2 = d.this;
                dVar2.ms(dVar2.qv(), d.this.qv());
            }
        }
    };
    private final ms az = new ms();
    private long lm = 0;
    private long e = 0;
    private boolean k = false;

    private boolean ms(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j, long j2) {
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this, j, j2);
            }
        }
    }

    public d(String str) {
        ms("mda_" + str + "_" + f30ms.addAndGet(1), (Looper) null);
    }

    private void ms(String str, Looper looper) {
        this.i = 0;
        if (looper != null) {
            this.ub = true;
            this.u = new le(looper, this);
        } else if (this.u == null) {
            this.u = com.bytedance.sdk.component.ch.xr.ms.ms().ms(this, "csj_" + str);
        }
        this.k = true;
        re();
    }

    private void b() {
        this.h = 0L;
        this.d = 0;
        this.y = 0L;
        this.ao = false;
        this.qv = Long.MIN_VALUE;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(final boolean z) {
        if (ub()) {
            return;
        }
        this.op = z;
        if (this.ab != null) {
            this.ab.ms(z);
        } else if (this.u != null) {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.11
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ab != null) {
                        d.this.ab.ms(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        if (this.u != null) {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.12
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ab == null) {
                        try {
                            d.this.ab = new xr();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (d.this.ab == null) {
                            return;
                        }
                        ah unused = d.this.ab;
                        d.this.w = "0";
                        d.this.ab.ms((ah.ka) d.this);
                        d.this.ab.ms((ah.xr) d.this);
                        d.this.ab.ms((ah.InterfaceC0180ah) d.this);
                        d.this.ab.ms((ah.ms) d.this);
                        d.this.ab.ms((ah.c) d.this);
                        d.this.ab.ms((ah.d) d.this);
                        d.this.ab.ms((ah.ab) d.this);
                        try {
                            d.this.ab.ah(false);
                        } catch (Throwable unused2) {
                        }
                        d.this.ny = false;
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms() {
        if (ub() || this.ab == null) {
            return;
        }
        if (this.sl != 206) {
            b();
            this.m = false;
            this.az.ms(true);
            xr(0L);
            if (this.u != null) {
                this.u.removeCallbacks(this.ul);
                this.u.postDelayed(this.ul, this.of);
            }
        }
        this.p.set(true);
        if ((this.pc.get() || this.jw.get()) && this.u != null) {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.13
                @Override // java.lang.Runnable
                public void run() {
                    d.this.of();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z, long j, boolean z2) {
        if (ub()) {
            return;
        }
        re();
        this.g = z2;
        this.m = false;
        ms(z2);
        if (z) {
            this.zb = j;
            i();
        } else {
            xr(j);
        }
        if (this.u != null) {
            this.u.removeCallbacks(this.ul);
            this.u.postDelayed(this.ul, this.of);
        }
        this.p.set(true);
        if ((this.pc.get() || this.jw.get()) && this.u != null) {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.of();
                }
            });
        }
    }

    private void xr(long j) {
        this.az.ms(j);
        if (this.op) {
            xr(this.az);
        } else if (xr(this.cv)) {
            xr(this.az);
        } else {
            ms(this.az);
        }
    }

    private boolean xr(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        return dVar != null && dVar.ab();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr() {
        if (ub() || this.u == null) {
            return;
        }
        this.p.set(true);
        this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.15
            @Override // java.lang.Runnable
            public void run() {
                if (!d.this.u() || d.this.ab == null) {
                    return;
                }
                try {
                    d.this.ab.ka();
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : d.this.le) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    d.this.sl = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    class ms implements Runnable {
        private boolean ah;
        private long xr;

        ms() {
        }

        public void ms(boolean z) {
            this.ah = z;
        }

        public void ms(long j) {
            this.xr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ab != null) {
                try {
                    if (!this.ah) {
                        long jNy = d.this.ab.ny();
                        d.this.zb = Math.max(this.xr, jNy);
                    }
                    long unused = d.this.zb;
                } catch (Throwable unused2) {
                }
            }
            if (d.this.u != null) {
                d.this.u.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (ub() || this.u == null) {
            return;
        }
        this.u.removeMessages(100);
        this.m = true;
        if (!this.k) {
            if (this.b || xr(this.cv)) {
                if (this.u != null) {
                    this.u.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            ms(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.16
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.u != null) {
                        d.this.u.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.c || xr(this.cv)) {
            if (this.u != null) {
                this.u.sendEmptyMessage(101);
                return;
            }
            return;
        }
        ms(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.17
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.u != null) {
                    d.this.u.sendEmptyMessage(101);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ka() {
        if (ub()) {
            return;
        }
        this.hi = true;
        p();
        if (this.u != null) {
            try {
                this.u.removeCallbacksAndMessages(null);
                if (this.ab != null) {
                    this.u.sendEmptyMessage(103);
                }
                yu();
            } catch (Throwable unused) {
                yu();
            }
        }
    }

    private void i() {
        xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.u != null) {
                    d.this.u.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void d() {
        if (ub()) {
            return;
        }
        xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.u != null) {
                    d.this.u.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final long j) {
        if (ub()) {
            return;
        }
        if (this.sl == 207 || this.sl == 206 || this.sl == 209) {
            xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.u != null) {
                        d.this.u.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean c() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final SurfaceTexture surfaceTexture) {
        if (ub()) {
            return;
        }
        this.xr = surfaceTexture;
        xr(true);
        xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.re();
                if (d.this.u != null) {
                    d.this.u.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final SurfaceHolder surfaceHolder) {
        if (ub()) {
            return;
        }
        this.ah = surfaceHolder;
        xr(true);
        xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.re();
                if (d.this.u != null) {
                    d.this.u.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public int t() {
        if (ub()) {
            return 203;
        }
        return this.sl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (ub()) {
            return;
        }
        this.cv = dVar;
        if (dVar != null) {
            this.k = this.k && !dVar.ab();
        }
        xr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.re();
                if (d.this.u != null) {
                    d.this.u.obtainMessage(107, dVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean zb() {
        return (this.sl == 206 || (this.u != null && this.u.hasMessages(100))) && !this.m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ch() {
        return nw() || zb() || u();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean u() {
        return ((this.sl != 207 && !this.m) || this.u == null || this.u.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ub() {
        return this.hi;
    }

    public boolean nw() {
        return this.sl == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ny() {
        return this.sl == 209;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0112  */
    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = this.sl;
        int i2 = message.what;
        boolean z = false;
        if (this.ab != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.sl == 205 || this.sl == 207 || this.sl == 209) {
                            this.ab.ka();
                            this.nw = SystemClock.elapsedRealtime();
                            this.sl = 206;
                            if (this.zb > 0) {
                                this.ab.ms(this.zb, this.ka);
                                this.zb = -1L;
                            }
                            if (this.cv != null) {
                                ms(this.g);
                            }
                        } else {
                            z = true;
                        }
                        break;
                    case 101:
                        if (this.ao) {
                            this.h += this.y;
                        }
                        this.ao = false;
                        this.y = 0L;
                        this.qv = Long.MIN_VALUE;
                        if (this.sl == 206 || this.sl == 207 || this.sl == 209) {
                            this.ab.ab();
                            this.sl = 207;
                            this.m = false;
                            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } else {
                            z = true;
                        }
                        break;
                    case 102:
                        this.ab.sl();
                        this.sl = 201;
                        break;
                    case 103:
                        try {
                            w();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                        }
                        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference2 : this.le) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().ah(this);
                            }
                        }
                        this.sl = 203;
                        break;
                    case 104:
                        if (this.sl == 202 || this.sl == 208) {
                            try {
                                this.ab.x();
                            } catch (Throwable th2) {
                                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                            }
                        } else {
                            z = true;
                        }
                        break;
                    case 105:
                        if (this.sl == 205 || this.sl == 206 || this.sl == 208 || this.sl == 207 || this.sl == 209) {
                            this.ab.c();
                            this.sl = 208;
                        } else {
                            z = true;
                        }
                        break;
                    case 106:
                        if (this.sl == 206 || this.sl == 207 || this.sl == 209) {
                            this.ab.ms(((Long) message.obj).longValue(), this.ka);
                        } else {
                            z = true;
                        }
                        break;
                    case 107:
                        b();
                        if (this.sl == 201 || this.sl == 203) {
                            com.bykv.vk.openvk.component.video.api.ah.d dVar = (com.bykv.vk.openvk.component.video.api.ah.d) message.obj;
                            if (TextUtils.isEmpty(dVar.ka())) {
                                dVar.ms(com.bykv.vk.openvk.component.video.api.ah.ms());
                            }
                            File file = new File(dVar.ka(), dVar.h());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (com.bykv.vk.openvk.component.video.api.ah.xr()) {
                                    ms(file.getAbsolutePath());
                                } else {
                                    this.ab.ms(file.getAbsolutePath());
                                }
                            } else {
                                dVar.ao();
                                int i3 = dVar.xr;
                                this.ab.ms(dVar);
                                dVar.ao();
                            }
                            this.sl = 202;
                        } else {
                            z = true;
                        }
                        break;
                    case 110:
                        this.ab.ms((SurfaceHolder) message.obj);
                        this.ab.xr(true);
                        this.pc.set(true);
                        if (this.p.get()) {
                            of();
                        }
                        break;
                    case 111:
                        this.f = new Surface((SurfaceTexture) message.obj);
                        this.ab.ms(this.f);
                        this.ab.xr(true);
                        this.jw.set(true);
                        if (this.p.get()) {
                            of();
                        }
                        break;
                }
            } catch (Throwable unused) {
            }
        }
        if (z) {
            this.sl = 200;
            if (this.ny) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.ah.xr xrVar = new com.bykv.vk.openvk.component.video.api.ah.xr(308, i2);
            xrVar.ms(i + "," + i2);
            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference3 : this.le) {
                if (weakReference3 != null && weakReference3.get() != null) {
                    weakReference3.get().ms(this, xrVar);
                }
            }
            this.ny = true;
        }
    }

    private void ms(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.ab.ms(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void w() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.ab == null) {
            return;
        }
        try {
            this.ab.sl();
        } catch (Throwable unused) {
        }
        this.ab.ms((ah.xr) null);
        this.ab.ms((ah.ab) null);
        this.ab.ms((ah.ms) null);
        this.ab.ms((ah.d) null);
        this.ab.ms((ah.InterfaceC0180ah) null);
        this.ab.ms((ah.ka) null);
        this.ab.ms((ah.c) null);
        try {
            this.ab.hi();
        } catch (Throwable unused2) {
        }
    }

    private void yu() {
        le leVar = this.u;
        if (leVar == null || leVar.getLooper() == null) {
            return;
        }
        leVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.u == null || d.this.u.getLooper() == null) {
                    return;
                }
                try {
                    if (d.this.ub) {
                        d.this.u.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.ch.xr.ms.ms().ms(d.this.u);
                    }
                    d.this.u = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.ms
    public void ms(ah ahVar, int i) {
        if (this.ab != ahVar) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xr(this, i);
            }
        }
    }

    private void op() {
        SparseIntArray sparseIntArray = yu;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.i));
        if (numValueOf == null) {
            sparseIntArray.put(this.i, 1);
        } else {
            sparseIntArray.put(this.i, numValueOf.intValue() + 1);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.xr
    public void ms(ah ahVar) {
        this.sl = 209;
        yu.delete(this.i);
        if (this.u != null) {
            this.u.removeCallbacks(this.ul);
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.InterfaceC0180ah
    public boolean ms(ah ahVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "what=" + i + "extra=" + i2);
        op();
        this.sl = 200;
        if (this.u != null) {
            this.u.removeCallbacks(this.ul);
        }
        if (ms(i, i2)) {
            yu();
        }
        if (!this.p.get()) {
            return true;
        }
        this.p.set(false);
        com.bykv.vk.openvk.component.video.api.ah.xr xrVar = new com.bykv.vk.openvk.component.video.api.ah.xr(i, i2);
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this, xrVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.d
    public boolean xr(ah ahVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.ab != ahVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.component.video.api.ah.xr xrVar = new com.bykv.vk.openvk.component.video.api.ah.xr(i, i2);
            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().ms(this, xrVar);
                }
            }
        }
        xr(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i, int i2) {
        if (i == 701) {
            this.lm = SystemClock.elapsedRealtime();
            this.d++;
            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().ms(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.d));
            return;
        }
        if (i == 702) {
            if (this.lm > 0) {
                this.e += SystemClock.elapsedRealtime() - this.lm;
                this.lm = 0L;
            }
            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference2 : this.le) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().ms((com.bykv.vk.openvk.component.video.api.ms) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.d), " mBufferTotalTime = ", Long.valueOf(this.e));
            return;
        }
        if (this.k && i == 3) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.m);
            of();
            le();
            ms(this.g);
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.ka
    public void xr(ah ahVar) {
        if (ub()) {
            return;
        }
        this.sl = 205;
        try {
            com.bykv.vk.openvk.component.video.api.ah.d dVar = this.cv;
            if (dVar != null) {
                float fUb = dVar.ub();
                if (fUb > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.xr xrVar = new com.bykv.vk.openvk.component.video.api.xr();
                    xrVar.ms(fUb);
                    this.ab.ms(xrVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.u != null) {
            if (this.m) {
                cv();
            } else {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.u.sendMessage(this.u.obtainMessage(100, -1, -1));
            }
        }
        yu.delete(this.i);
        com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", "onPrepared:" + this.k + " " + this.b);
        if (!this.k && !this.b) {
            le();
            this.b = true;
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xr(this);
            }
        }
    }

    private void le() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.nw;
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this, jElapsedRealtime);
            }
        }
        this.c = true;
    }

    private void cv() {
        if (this.u != null) {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.ab.ab();
                        d.this.sl = 207;
                        d.this.m = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.c
    public void ah(ah ahVar) {
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms((com.bykv.vk.openvk.component.video.api.ms) this, true);
            }
        }
    }

    private void ms(Runnable runnable) {
        try {
            if (this.re == null) {
                this.re = new ArrayList<>();
            }
            this.re.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void g() {
        if (this.ch) {
            return;
        }
        this.ch = true;
        Iterator it = new ArrayList(this.re).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.re.clear();
        this.ch = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of() {
        ArrayList<Runnable> arrayList = this.re;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g();
    }

    private void p() {
        ArrayList<Runnable> arrayList = this.re;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.re.clear();
    }

    private void xr(Runnable runnable) {
        if (runnable == null || ub()) {
            return;
        }
        if (!this.hi) {
            runnable.run();
        } else {
            ms(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final boolean z) {
        if (ub()) {
            return;
        }
        if (this.u == null) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.u.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.d.d.10
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ub() || d.this.ab == null) {
                        return;
                    }
                    try {
                        d.this.g = z;
                        d.this.ab.d(z);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long ao() {
        if (this.ao) {
            long j = this.y;
            if (j > 0) {
                return this.h + j;
            }
        }
        return this.h;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int hi() {
        if (this.ab == null || ub()) {
            return 0;
        }
        return this.ab.zb();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int sl() {
        if (this.ab == null || ub()) {
            return 0;
        }
        return this.ab.u();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int h() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah.ab
    public void ms(ah ahVar, int i, int i2, int i3, int i4) {
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms((com.bykv.vk.openvk.component.video.api.ms) this, i, i2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long qv() {
        long j = this.t;
        if (j != 0) {
            return j;
        }
        if (this.sl == 206 || this.sl == 207) {
            try {
                this.t = this.ab.ch();
            } catch (Throwable unused) {
            }
        }
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long y() {
        if (ub()) {
            return 0L;
        }
        if (this.sl == 206 || this.sl == 207) {
            try {
                return this.ab.ny();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah(boolean z) {
        if (ub()) {
            return;
        }
        this.ab.ka(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms) {
        if (interfaceC0179ms == null) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.le) {
            if (weakReference != null && weakReference.get() == interfaceC0179ms) {
                return;
            }
        }
        this.le.add(new WeakReference<>(interfaceC0179ms));
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(int i) {
        if (ub()) {
            return;
        }
        this.of = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceHolder ab() {
        return this.ah;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceTexture x() {
        return this.xr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(int i) {
        this.ka = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(float f) {
        try {
            com.bykv.vk.openvk.component.video.api.xr xrVar = new com.bykv.vk.openvk.component.video.api.xr();
            xrVar.ms(f);
            this.ab.ms(xrVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
