package com.byazt.ms;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.ca.iu;
import com.byazt.ihe.fw;
import com.byazt.ihe.m;
import com.byazt.n.hn;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
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
@com.byazt.vzx.pr(pr = {0, 1, 835, 13})
public class hw implements qi.pr, fw {
    public static volatile boolean pr = false;
    public int a;
    public SurfaceTexture cz;
    public TTVideoEngine hw;
    public boolean nl;
    public SurfaceHolder ny;
    public int qa;
    public volatile Handler rc;
    public long vk;
    public boolean hn = false;
    public boolean x = false;
    public boolean c = false;
    public boolean uc = false;
    public boolean fw = false;
    public boolean zo = false;
    public boolean aj = false;
    public long w = 0;
    public long k = 0;
    public long m = 0;
    public int g = 0;
    public int ho = 0;
    public boolean nt = false;
    public AtomicBoolean yb = new AtomicBoolean(false);
    public AtomicBoolean lb = new AtomicBoolean(false);
    public final List<WeakReference<fw.pr>> fo = Collections.synchronizedList(new ArrayList());
    public volatile boolean z = false;
    public volatile int b = 200;
    public long iu = 0;
    public Runnable ve = new Runnable() { // from class: com.byazt.ms.hw.1
        @Override // java.lang.Runnable
        public void run() {
            long jCz = hw.this.cz();
            if (hw.this.a() > 0) {
                if (hw.this.iu != jCz) {
                    if (com.byazt.y.hw.x()) {
                        Object[] objArr = {"run: lastCur = ", Long.valueOf(hw.this.iu), "  curPosition=", Long.valueOf(jCz)};
                    }
                    hw hwVar = hw.this;
                    hwVar.pr(jCz, hwVar.a());
                }
                hw.this.iu = jCz;
            }
            if (!hw.this.uc) {
                if (hw.this.rc != null) {
                    hw.this.rc.postDelayed(this, hw.this.b);
                }
            } else {
                hw hwVar2 = hw.this;
                hwVar2.pr(hwVar2.a(), hw.this.a());
            }
        }
    };
    public final ArrayList<Runnable> gz = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j, long j2) {
        fw.pr prVar;
        for (WeakReference<fw.pr> weakReference : this.fo) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this, j, j2);
            }
        }
    }

    public hw(Context context, String str) {
        pr(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void pr(Context context, String str, Looper looper) {
        this.hw = pr.pr(context);
        if (looper != null) {
            this.rc = new iu(looper, this);
            this.z = true;
        } else if (this.rc == null) {
            this.rc = ((qi) uc.pr("thread_service")).pr(this, "csj_".concat(String.valueOf(str)));
        }
        nl();
    }

    @Override // com.byazt.ihe.fw
    public void pr(final SurfaceHolder surfaceHolder) {
        pr(true);
        this.ny = surfaceHolder;
        hw(new Runnable() { // from class: com.byazt.ms.hw.4
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.rc != null) {
                    hw.this.rc.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void pr(final SurfaceTexture surfaceTexture) {
        pr(true);
        this.cz = surfaceTexture;
        hw(new Runnable() { // from class: com.byazt.ms.hw.5
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.rc != null) {
                    hw.this.rc.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        return this.uc;
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        return this.fw;
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        return this.zo;
    }

    @Override // com.byazt.ihe.fw
    public void pr(m mVar) {
        this.hw.setDirectUrlUseDataLoader(mVar.ny(), mVar.fo(), (String) null, mVar.c());
        this.hn = true;
        this.ho = 0;
        Object[] objArr = {"TTVideoPlayer setDirectUrlUseDataLoader:  url =", mVar.ny(), " isH265=", Boolean.valueOf(mVar.a()), " presize=", Integer.valueOf(mVar.fw()), " path=", mVar.c(), " fileName =", mVar.fo()};
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        boolean zIsMute;
        TTVideoEngine tTVideoEngine = this.hw;
        if (tTVideoEngine == null) {
            zIsMute = false;
        } else {
            zIsMute = tTVideoEngine.isMute();
        }
        this.ho = 0;
        this.k = 0L;
        this.m = 0L;
        this.uc = false;
        pr(true, 0L, zIsMute);
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, long j, boolean z2) {
        if (this.rc != null) {
            this.rc.postDelayed(this.ve, this.b);
        }
        this.vk = System.currentTimeMillis();
        this.hw.setStartTime((int) j);
        this.hw.setIsMute(z2);
        if (this.lb.get() && this.hn) {
            aj();
        } else {
            Object[] objArr = {"seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek"};
            pr(new Runnable() { // from class: com.byazt.ms.hw.6
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.aj();
                }
            });
        }
        this.yb.set(true);
        if (this.lb.get() && this.rc != null) {
            this.rc.post(new Runnable() { // from class: com.byazt.ms.hw.7
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.ve();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        fw.pr prVar;
        this.zo = true;
        this.x = true;
        for (WeakReference<fw.pr> weakReference : this.fo) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.hw(this);
            }
        }
        if (this.rc != null) {
            this.rc.sendEmptyMessage(100);
        }
    }

    private synchronized void pr(Runnable runnable) {
        this.gz.add(runnable);
    }

    private void iu() {
        if (this.nl) {
            return;
        }
        this.nl = true;
        Iterator it = new ArrayList(this.gz).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.gz.clear();
        this.nl = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        ArrayList<Runnable> arrayList = this.gz;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        iu();
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        Handler handler = this.rc;
        if (handler != null) {
            handler.postDelayed(this.ve, this.b);
            handler.post(new Runnable() { // from class: com.byazt.ms.hw.8
                @Override // java.lang.Runnable
                public void run() {
                    fw.pr prVar;
                    try {
                        if (hw.this.hw != null) {
                            hw.this.hw.play();
                            for (WeakReference weakReference : hw.this.fo) {
                                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                                    prVar.uc(hw.this);
                                }
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        if (this.rc != null) {
            this.rc.sendEmptyMessage(105);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        fw.pr prVar;
        fw.pr prVar2;
        try {
            switch (message.what) {
                case 100:
                    TTVideoEngine tTVideoEngine = this.hw;
                    if (tTVideoEngine != null) {
                        tTVideoEngine.play();
                    }
                    break;
                case 101:
                    if (this.hw != null && this.rc != null) {
                        this.hw.pause();
                        for (WeakReference<fw.pr> weakReference : this.fo) {
                            if (weakReference != null && (prVar = weakReference.get()) != null) {
                                prVar.c(this);
                            }
                        }
                        this.rc.removeCallbacks(this.ve);
                    }
                    break;
                case 102:
                    y();
                    break;
                case 103:
                    TTVideoEngine tTVideoEngine2 = this.hw;
                    if (tTVideoEngine2 != null) {
                        tTVideoEngine2.release();
                    }
                    this.c = true;
                    for (WeakReference<fw.pr> weakReference2 : this.fo) {
                        if (weakReference2 != null && (prVar2 = weakReference2.get()) != null) {
                            prVar2.x(this);
                        }
                    }
                    break;
                case 105:
                    TTVideoEngine tTVideoEngine3 = this.hw;
                    if (tTVideoEngine3 != null) {
                        tTVideoEngine3.stop();
                    }
                    break;
                case 110:
                    if (this.hw != null) {
                        this.hw.setSurfaceHolder((SurfaceHolder) message.obj);
                        this.lb.set(true);
                        if (this.yb.get()) {
                            ve();
                        }
                    }
                    break;
                case 111:
                    if (this.hw != null) {
                        this.hw.setSurface(new Surface((SurfaceTexture) message.obj));
                        this.lb.set(true);
                        if (this.yb.get()) {
                            ve();
                        }
                    }
                    break;
            }
        } catch (Exception e) {
        }
    }

    private void hw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.c) {
            runnable.run();
        } else {
            pr(runnable);
        }
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        hw(new Runnable() { // from class: com.byazt.ms.hw.9
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.rc != null) {
                    hw.this.rc.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        Handler handler = this.rc;
        if (handler != null) {
            handler.removeMessages(100);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(long j) {
        if (this.x) {
            this.hw.seekTo((int) j, new SeekCompletionListener() { // from class: com.byazt.ms.hw.10
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    fw.pr prVar;
                    for (WeakReference weakReference : hw.this.fo) {
                        if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                            prVar.pr(hw.this, z);
                        }
                    }
                    Object[] objArr = {"seekTo: ", " isSuccess =", Boolean.valueOf(z)};
                }
            });
        } else {
            Object[] objArr = {"seekTo: ", "Can not exec seek, please exec setDataSource before seek"};
        }
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        return this.nt;
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z) {
        this.aj = z;
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        return this.hw.getDuration();
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        try {
            return this.hw.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.byazt.o.hw.pr(th.getMessage());
            return 0L;
        }
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
        this.hw.setLooping(z);
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        return this.hw.isLooping();
    }

    @Override // com.byazt.ihe.fw
    public void pr(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        for (WeakReference<fw.pr> weakReference : this.fo) {
            if (weakReference != null && weakReference.get() == prVar) {
                return;
            }
        }
        this.fo.add(new WeakReference<>(prVar));
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        Iterator<WeakReference<fw.pr>> it = this.fo.iterator();
        while (it.hasNext()) {
            WeakReference<fw.pr> next = it.next();
            if (next != null && next.get() == prVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        this.b = i;
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        return this.b;
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
    }

    private void gz() {
        ArrayList<Runnable> arrayList = this.gz;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.gz.clear();
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        gz();
        Handler handler = this.rc;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.sendEmptyMessage(103);
            if (handler.getLooper() != null) {
                handler.post(new Runnable() { // from class: com.byazt.ms.hw.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!hw.this.z) {
                                ((qi) uc.pr("thread_service")).pr(hw.this.rc);
                            }
                            hw.this.rc = null;
                        } catch (Throwable th) {
                        }
                    }
                });
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw(boolean z) {
        this.hw.setIsMute(z);
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        return this.qa;
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        return this.a;
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        return this.hw.getPlaybackState() == 1;
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        return this.hw.getPlaybackState() == 2;
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        return this.c;
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        if (this.ho == 0) {
            return 0L;
        }
        if (this.k == 0 && this.m != 0) {
            this.k = System.currentTimeMillis() - this.m;
        }
        return this.k;
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        return this.ho;
    }

    private void nl() {
        this.hw.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.byazt.ms.hw.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                Object[] objArr = {"onPlaybackStateChanged: playbackState =", Integer.valueOf(i)};
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                Object[] objArr = {"onLoadStateChanged: loadState =", Integer.valueOf(i)};
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                fw.pr prVar;
                Object[] objArr = {"onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2)};
                hw.this.qa = i;
                hw.this.a = i2;
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr((fw) hw.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                fw.pr prVar;
                Object[] objArr = {"onBufferingUpdate: percent =", Integer.valueOf(i)};
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.hw(hw.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                fw.pr prVar;
                hw.this.fw = true;
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.hn(hw.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                fw.pr prVar;
                hw.this.w = System.currentTimeMillis() - hw.this.vk;
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        hw hwVar = hw.this;
                        prVar.pr(hwVar, hwVar.w);
                    }
                }
                hw.this.nt = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                fw.pr prVar;
                hw.this.uc = true;
                if (hw.this.rc != null) {
                    hw.this.rc.removeCallbacks(hw.this.ve);
                }
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(hw.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                fw.pr prVar;
                hn hnVar = new hn(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(hw.this, hnVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                fw.pr prVar;
                hw.this.g = i;
                hw.this.ho++;
                hw.this.m = System.currentTimeMillis();
                Object[] objArr = {"onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3)};
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(hw.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                fw.pr prVar;
                if (hw.this.g == i) {
                    hw.this.k += System.currentTimeMillis() - hw.this.m;
                }
                Object[] objArr = {"onBufferEnd: code =", Integer.valueOf(i)};
                for (WeakReference weakReference : hw.this.fo) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr((fw) hw.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                Object[] objArr = {"onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i)};
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                Object[] objArr = {"onRetry: playType = ", Integer.valueOf(i)};
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                Object[] objArr = {"onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j)};
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
            }
        });
    }

    private void y() {
        this.hn = false;
        this.x = false;
        this.uc = false;
        this.fw = false;
        this.zo = false;
    }

    public static boolean pr() {
        return pr;
    }

    public static void pr(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), com.byazt.y.hw.getContext()).release();
            pr.pr(context, str, i, strArr, jArr, new VideoEventEngineUploader() { // from class: com.byazt.ms.hw.3
                @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                public void onEvent(String str2, JSONObject jSONObject) {
                    ((com.byazt.vkw.hn) uc.pr("embed_applog")).pr(str2, jSONObject);
                }
            });
            pr.pr(z);
            z2 = true;
        } catch (Throwable th) {
            z2 = false;
        }
        pr = z2;
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        return this.ny;
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        return this.cz;
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        return "";
    }
}
