package com.bytedance.sdk.component.sl.xr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.ah;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bykv.vk.openvk.component.video.api.ms, le.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile boolean f1336ms = false;
    private SurfaceHolder b;
    private long ch;
    private boolean g;
    private volatile le i;
    private SurfaceTexture nw;
    private int t;
    private TTVideoEngine xr;
    private int y;
    private boolean ah = false;
    private boolean d = false;
    private boolean ka = false;
    private boolean c = false;
    private boolean ab = false;
    private boolean x = false;
    private boolean ny = false;
    private long hi = 0;
    private long sl = 0;
    private long zb = 0;
    private int u = 0;
    private int ub = 0;
    private boolean ao = false;
    private AtomicBoolean h = new AtomicBoolean(false);
    private AtomicBoolean qv = new AtomicBoolean(false);
    private final List<WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms>> re = Collections.synchronizedList(new ArrayList());
    private volatile boolean w = false;
    private volatile int yu = 200;
    private long op = 0;
    private Runnable le = new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.1
        @Override // java.lang.Runnable
        public void run() {
            long jY = xr.this.y();
            if (xr.this.qv() > 0) {
                if (xr.this.op != jY) {
                    if (ah.d()) {
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(xr.this.op), "  curPosition=", Long.valueOf(jY));
                    }
                    xr xrVar = xr.this;
                    xrVar.ms(jY, xrVar.qv());
                }
                xr.this.op = jY;
            }
            if (!xr.this.c) {
                if (xr.this.i != null) {
                    xr.this.i.postDelayed(this, xr.this.yu);
                }
            } else {
                xr xrVar2 = xr.this;
                xrVar2.ms(xrVar2.qv(), xr.this.qv());
            }
        }
    };
    private final ArrayList<Runnable> cv = new ArrayList<>();

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j, long j2) {
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.re) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this, j, j2);
            }
        }
    }

    public xr(Context context, String str) {
        ms(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void ms(Context context, String str, Looper looper) {
        this.xr = ms.ms(context);
        if (looper != null) {
            this.i = new le(looper, this);
            this.w = true;
        } else if (this.i == null) {
            this.i = com.bytedance.sdk.component.ch.xr.ms.ms().ms(this, "csj_".concat(String.valueOf(str)));
        }
        w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        xr(true);
        this.b = surfaceHolder;
        xr(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.3
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.i != null) {
                    xr.this.i.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final SurfaceTexture surfaceTexture) {
        xr(true);
        this.nw = surfaceTexture;
        xr(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.4
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.i != null) {
                    xr.this.i.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ny() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ch() {
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(d dVar) {
        this.xr.setDirectUrlUseDataLoader(dVar.ao(), dVar.h(), (String) null, dVar.ka());
        this.ah = true;
        this.ub = 0;
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", dVar.ao(), " isH265=", Boolean.valueOf(dVar.u()), " presize=", Integer.valueOf(dVar.c()), " path=", dVar.ka(), " fileName =", dVar.h());
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms() {
        TTVideoEngine tTVideoEngine = this.xr;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.ub = 0;
        this.sl = 0L;
        this.zb = 0L;
        this.c = false;
        ms(true, 0L, zIsMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z, long j, boolean z2) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j + " first:" + z + " quiet:" + z2);
        if (this.i != null) {
            this.i.postDelayed(this.le, this.yu);
        }
        this.ch = System.currentTimeMillis();
        this.xr.setStartTime((int) j);
        this.xr.setIsMute(z2);
        if (this.qv.get() && this.ah) {
            nw();
        } else {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            ms(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.5
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.nw();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "start:end");
        this.h.set(true);
        if (!this.qv.get() || this.i == null) {
            return;
        }
        this.i.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.6
            @Override // java.lang.Runnable
            public void run() {
                xr.this.re();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
        this.x = true;
        this.d = true;
        if (this.i != null) {
            this.i.sendEmptyMessage(100);
        }
    }

    private synchronized void ms(Runnable runnable) {
        this.cv.add(runnable);
    }

    private void b() {
        if (this.g) {
            return;
        }
        this.g = true;
        Iterator it = new ArrayList(this.cv).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.cv.clear();
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        ArrayList<Runnable> arrayList = this.cv;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        b();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "play: ");
        le leVar = this.i;
        if (leVar != null) {
            leVar.postDelayed(this.le, this.yu);
            leVar.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (xr.this.xr != null) {
                            xr.this.xr.play();
                            for (WeakReference weakReference : xr.this.re) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void d() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.i != null) {
            this.i.sendEmptyMessage(105);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.xr;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                if (this.xr != null) {
                    this.xr.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.qv.set(true);
                    if (this.h.get()) {
                        re();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine2 = this.xr;
                        if (tTVideoEngine2 != null) {
                            tTVideoEngine2.play();
                        }
                        break;
                    case 101:
                        if (this.xr != null && this.i != null) {
                            this.xr.pause();
                            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.re) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.i.removeCallbacks(this.le);
                        }
                        break;
                    case 102:
                        yu();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine3 = this.xr;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.release();
                        }
                        this.ka = true;
                        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference2 : this.re) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().ah(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.xr != null) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.xr.setSurface(new Surface(surfaceTexture));
                this.qv.set(true);
                if (this.h.get()) {
                    re();
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private void xr(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.ka) {
            runnable.run();
        } else {
            ms(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "pause: ");
        le leVar = this.i;
        if (leVar != null) {
            leVar.removeMessages(100);
            leVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(long j) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (this.d) {
            this.xr.seekTo((int) j, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.sl.xr.xr.8
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    for (WeakReference weakReference : xr.this.re) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(xr.this, z);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z));
                }
            });
        } else {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean c() {
        return this.ao;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(boolean z) {
        this.ny = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long qv() {
        return this.xr.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long y() {
        try {
            return this.xr.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.xr(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah(boolean z) {
        this.xr.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms) {
        if (interfaceC0179ms == null) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.re) {
            if (weakReference != null && weakReference.get() == interfaceC0179ms) {
                return;
            }
        }
        this.re.add(new WeakReference<>(interfaceC0179ms));
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(int i) {
        this.yu = i;
    }

    private void i() {
        ArrayList<Runnable> arrayList = this.cv;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.cv.clear();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ka() {
        i();
        le leVar = this.i;
        if (leVar != null) {
            leVar.removeCallbacksAndMessages(null);
            leVar.sendEmptyMessage(103);
            if (leVar.getLooper() != null) {
                leVar.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.xr.xr.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!xr.this.w) {
                                com.bytedance.sdk.component.ch.xr.ms.ms().ms(xr.this.i);
                            }
                            xr.this.i = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.xr.setIsMute(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int hi() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int sl() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean zb() {
        return this.xr.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean u() {
        return this.xr.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ub() {
        return this.ka;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long ao() {
        if (this.ub == 0) {
            return 0L;
        }
        if (this.sl == 0 && this.zb != 0) {
            this.sl = System.currentTimeMillis() - this.zb;
        }
        return this.sl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int h() {
        return this.ub;
    }

    private void w() {
        this.xr.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.sl.xr.xr.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2));
                xr.this.y = i;
                xr.this.t = i2;
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms((com.bykv.vk.openvk.component.video.api.ms) xr.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i));
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).xr(xr.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onPrepared: ");
                xr.this.ab = true;
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).xr(xr.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                xr.this.hi = System.currentTimeMillis() - xr.this.ch;
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms = (com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get();
                        xr xrVar = xr.this;
                        interfaceC0179ms.ms(xrVar, xrVar.hi);
                    }
                }
                xr.this.ao = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onCompletion: ");
                xr.this.c = true;
                if (xr.this.i != null) {
                    xr.this.i.removeCallbacks(xr.this.le);
                }
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(xr.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.ah.xr xrVar = new com.bykv.vk.openvk.component.video.api.ah.xr(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(xr.this, xrVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                xr.this.u = i;
                xr.this.ub++;
                xr.this.zb = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3));
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(xr.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                if (xr.this.u == i) {
                    xr.this.sl += System.currentTimeMillis() - xr.this.zb;
                }
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i));
                for (WeakReference weakReference : xr.this.re) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms((com.bykv.vk.openvk.component.video.api.ms) xr.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }
        });
    }

    private void yu() {
        this.ah = false;
        this.d = false;
        this.c = false;
        this.ab = false;
        this.x = false;
    }

    public static boolean t() {
        return f1336ms;
    }

    public static void ms(Context context, String str, int i, String[] strArr, long[] jArr, boolean z, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), ah.getContext()).release();
            ms.ms(context, str, i, strArr, jArr, videoEventEngineUploader);
            ms.ms(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        f1336ms = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceHolder ab() {
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceTexture x() {
        return this.nw;
    }
}
