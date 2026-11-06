package com.byazt.rq;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.anythink.core.common.l.b;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.qp.q;
import com.byazt.tk.t;
import com.byazt.vf.s;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, b.d, 26})
public class qg implements x, wo.n {
    public static volatile boolean n = false;
    public int a;
    public boolean ln;
    public volatile Handler m;
    public SurfaceHolder ou;
    public SurfaceTexture py;
    public TTVideoEngine qg;
    public long tj;
    public int um;
    public boolean s = false;
    public boolean q = false;
    public boolean l = false;
    public boolean w = false;
    public boolean x = false;
    public boolean fs = false;
    public boolean rv = false;
    public long cp = 0;
    public long d = 0;
    public long oa = 0;
    public int sz = 0;
    public int k = 0;
    public boolean cy = false;
    public AtomicBoolean hd = new AtomicBoolean(false);
    public AtomicBoolean cd = new AtomicBoolean(false);
    public final List<WeakReference<x.n>> wm = Collections.synchronizedList(new ArrayList());
    public volatile boolean hu = false;
    public volatile int h = 200;
    public long t = 0;
    public Runnable ur = new Runnable() { // from class: com.byazt.rq.qg.1
        @Override // java.lang.Runnable
        public void run() {
            long jPy = qg.this.py();
            if (qg.this.a() > 0) {
                if (qg.this.t != jPy) {
                    if (com.byazt.iza.qg.q()) {
                        Object[] objArr = new Object[4];
                        Long.valueOf(qg.this.t);
                        Long.valueOf(jPy);
                    }
                    qg qgVar = qg.this;
                    qgVar.n(jPy, qgVar.a());
                }
                qg.this.t = jPy;
            }
            if (!qg.this.w) {
                if (qg.this.m != null) {
                    qg.this.m.postDelayed(this, qg.this.h);
                }
            } else {
                qg qgVar2 = qg.this;
                qgVar2.n(qgVar2.a(), qg.this.a());
            }
        }
    };
    public final ArrayList<Runnable> bb = new ArrayList<>();

    @Override // com.byazt.ej.x
    public String h() {
        return "";
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, long j2) {
        x.n nVar;
        for (WeakReference<x.n> weakReference : this.wm) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this, j, j2);
            }
        }
    }

    public qg(Context context, String str) {
        n(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void n(Context context, String str, Looper looper) {
        this.qg = n.n(context);
        if (looper != null) {
            this.m = new t(looper, this);
            this.hu = true;
        } else if (this.m == null) {
            this.m = ((wo) q.n("thread_service")).n(this, "csj_".concat(String.valueOf(str)));
        }
        ln();
    }

    @Override // com.byazt.ej.x
    public void n(final SurfaceHolder surfaceHolder) {
        n(true);
        this.ou = surfaceHolder;
        qg(new Runnable() { // from class: com.byazt.rq.qg.4
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.m != null) {
                    qg.this.m.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void n(final SurfaceTexture surfaceTexture) {
        n(true);
        this.py = surfaceTexture;
        qg(new Runnable() { // from class: com.byazt.rq.qg.5
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.m != null) {
                    qg.this.m.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return this.w;
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return this.x;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        return this.fs;
    }

    @Override // com.byazt.ej.x
    public void n(k kVar) {
        this.qg.setDirectUrlUseDataLoader(kVar.ou(), kVar.wm(), (String) null, kVar.l());
        this.s = true;
        this.k = 0;
        Object[] objArr = new Object[10];
        kVar.ou();
        Boolean.valueOf(kVar.a());
        Integer.valueOf(kVar.x());
        kVar.l();
        kVar.wm();
    }

    @Override // com.byazt.ej.x
    public void qg() {
        TTVideoEngine tTVideoEngine = this.qg;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.k = 0;
        this.d = 0L;
        this.oa = 0L;
        this.w = false;
        n(true, 0L, zIsMute);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        if (this.m != null) {
            this.m.postDelayed(this.ur, this.h);
        }
        this.tj = System.currentTimeMillis();
        this.qg.setStartTime((int) j);
        this.qg.setIsMute(z2);
        if (this.cd.get() && this.s) {
            rv();
        } else {
            Object[] objArr = new Object[2];
            n(new Runnable() { // from class: com.byazt.rq.qg.6
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.rv();
                }
            });
        }
        this.hd.set(true);
        if (!this.cd.get() || this.m == null) {
            return;
        }
        this.m.post(new Runnable() { // from class: com.byazt.rq.qg.7
            @Override // java.lang.Runnable
            public void run() {
                qg.this.ur();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        x.n nVar;
        this.fs = true;
        this.q = true;
        for (WeakReference<x.n> weakReference : this.wm) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.qg(this);
            }
        }
        if (this.m != null) {
            this.m.sendEmptyMessage(100);
        }
    }

    private synchronized void n(Runnable runnable) {
        this.bb.add(runnable);
    }

    private void t() {
        if (this.ln) {
            return;
        }
        this.ln = true;
        Iterator it = new ArrayList(this.bb).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.bb.clear();
        this.ln = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        ArrayList<Runnable> arrayList = this.bb;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        t();
    }

    @Override // com.byazt.ej.x
    public void s() {
        Handler handler = this.m;
        if (handler != null) {
            handler.postDelayed(this.ur, this.h);
            handler.post(new Runnable() { // from class: com.byazt.rq.qg.8
                @Override // java.lang.Runnable
                public void run() {
                    x.n nVar;
                    try {
                        if (qg.this.qg != null) {
                            qg.this.qg.play();
                            for (WeakReference weakReference : qg.this.wm) {
                                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                                    nVar.w(qg.this);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public void x() {
        if (this.m != null) {
            this.m.sendEmptyMessage(105);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        x.n nVar;
        x.n nVar2;
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.qg;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                if (this.qg != null) {
                    this.qg.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.cd.set(true);
                    if (this.hd.get()) {
                        ur();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine2 = this.qg;
                        if (tTVideoEngine2 != null) {
                            tTVideoEngine2.play();
                        }
                        break;
                    case 101:
                        if (this.qg != null && this.m != null) {
                            this.qg.pause();
                            for (WeakReference<x.n> weakReference : this.wm) {
                                if (weakReference != null && (nVar = weakReference.get()) != null) {
                                    nVar.l(this);
                                }
                            }
                            this.m.removeCallbacks(this.ur);
                        }
                        break;
                    case 102:
                        lh();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine3 = this.qg;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.release();
                        }
                        this.l = true;
                        for (WeakReference<x.n> weakReference2 : this.wm) {
                            if (weakReference2 != null && (nVar2 = weakReference2.get()) != null) {
                                nVar2.q(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.qg != null) {
                this.qg.setSurface(new Surface((SurfaceTexture) message.obj));
                this.cd.set(true);
                if (this.hd.get()) {
                    ur();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void qg(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.l) {
            runnable.run();
        } else {
            n(runnable);
        }
    }

    @Override // com.byazt.ej.x
    public void l() {
        qg(new Runnable() { // from class: com.byazt.rq.qg.9
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.m != null) {
                    qg.this.m.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void q() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeMessages(100);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.ej.x
    public void n(long j) {
        if (this.q) {
            this.qg.seekTo((int) j, new SeekCompletionListener() { // from class: com.byazt.rq.qg.10
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    x.n nVar;
                    for (WeakReference weakReference : qg.this.wm) {
                        if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                            nVar.n(qg.this, z);
                        }
                    }
                    Object[] objArr = new Object[3];
                    Boolean.valueOf(z);
                }
            });
        } else {
            Object[] objArr = new Object[2];
        }
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return this.cy;
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
        this.rv = z;
    }

    @Override // com.byazt.ej.x
    public long a() {
        return this.qg.getDuration();
    }

    @Override // com.byazt.ej.x
    public long py() {
        try {
            return this.qg.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.byazt.nl.qg.n(th.getMessage());
            return 0L;
        }
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        this.qg.setLooping(z);
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return this.qg.isLooping();
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        if (nVar == null) {
            return;
        }
        for (WeakReference<x.n> weakReference : this.wm) {
            if (weakReference != null && weakReference.get() == nVar) {
                return;
            }
        }
        this.wm.add(new WeakReference<>(nVar));
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        if (nVar == null) {
            return;
        }
        Iterator<WeakReference<x.n>> it = this.wm.iterator();
        while (it.hasNext()) {
            WeakReference<x.n> next = it.next();
            if (next != null && next.get() == nVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        this.h = i;
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.h;
    }

    private void bb() {
        ArrayList<Runnable> arrayList = this.bb;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.bb.clear();
    }

    @Override // com.byazt.ej.x
    public void w() {
        bb();
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.sendEmptyMessage(103);
            if (handler.getLooper() != null) {
                handler.post(new Runnable() { // from class: com.byazt.rq.qg.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!qg.this.hu) {
                                ((wo) q.n("thread_service")).n(qg.this.m);
                            }
                            qg.this.m = null;
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        this.qg.setIsMute(z);
    }

    @Override // com.byazt.ej.x
    public int hd() {
        return this.um;
    }

    @Override // com.byazt.ej.x
    public int cd() {
        return this.a;
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        return this.qg.getPlaybackState() == 1;
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return this.qg.getPlaybackState() == 2;
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return this.l;
    }

    @Override // com.byazt.ej.x
    public long cy() {
        if (this.k == 0) {
            return 0L;
        }
        if (this.d == 0 && this.oa != 0) {
            this.d = System.currentTimeMillis() - this.oa;
        }
        return this.d;
    }

    @Override // com.byazt.ej.x
    public int um() {
        return this.k;
    }

    private void ln() {
        this.qg.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.byazt.rq.qg.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                x.n nVar;
                Object[] objArr = new Object[4];
                Integer.valueOf(i);
                Integer.valueOf(i2);
                qg.this.um = i;
                qg.this.a = i2;
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n((x) qg.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                x.n nVar;
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.qg(qg.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                x.n nVar;
                qg.this.x = true;
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.s(qg.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                x.n nVar;
                qg.this.cp = System.currentTimeMillis() - qg.this.tj;
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        qg qgVar = qg.this;
                        nVar.n(qgVar, qgVar.cp);
                    }
                }
                qg.this.cy = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                x.n nVar;
                qg.this.w = true;
                if (qg.this.m != null) {
                    qg.this.m.removeCallbacks(qg.this.ur);
                }
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n(qg.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                x.n nVar;
                com.byazt.zsl.qg qgVar = new com.byazt.zsl.qg(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n(qg.this, qgVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                x.n nVar;
                qg.this.sz = i;
                qg.this.k++;
                qg.this.oa = System.currentTimeMillis();
                Object[] objArr = new Object[6];
                Integer.valueOf(i);
                Integer.valueOf(i2);
                Integer.valueOf(i3);
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n(qg.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                x.n nVar;
                if (qg.this.sz == i) {
                    qg.this.d += System.currentTimeMillis() - qg.this.oa;
                }
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
                for (WeakReference weakReference : qg.this.wm) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n((x) qg.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                Object[] objArr = new Object[4];
                Long.valueOf(j);
            }
        });
    }

    private void lh() {
        this.s = false;
        this.q = false;
        this.w = false;
        this.x = false;
        this.fs = false;
    }

    public static boolean n() {
        return n;
    }

    public static void n(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), com.byazt.iza.qg.getContext()).release();
            n.n(context, str, i, strArr, jArr, new VideoEventEngineUploader() { // from class: com.byazt.rq.qg.3
                @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                public void onEvent(String str2, JSONObject jSONObject) {
                    ((s) q.n("embed_applog")).n(str2, jSONObject);
                }
            });
            n.n(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        n = z2;
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return this.ou;
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return this.py;
    }
}
