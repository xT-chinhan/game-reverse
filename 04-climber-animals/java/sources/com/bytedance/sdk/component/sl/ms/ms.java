package com.bytedance.sdk.component.sl.ms;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.anythink.core.common.m.e;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.ah;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bykv.vk.openvk.component.video.api.ah.xr;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.u;
import com.umeng.analytics.pro.cl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bykv.vk.openvk.component.video.api.ms, le.ms {
    private volatile boolean ab;
    private final Context ah;
    private le c;
    private volatile d cv;
    private int d;
    private boolean f;
    private long h;
    private boolean jw;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ILivePlayer f1324ms;
    private SurfaceTexture op;
    private JSONObject pc;
    private long re;
    private SurfaceHolder yu;
    private final List<WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms>> xr = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean x = new AtomicBoolean(false);
    private AtomicBoolean ny = new AtomicBoolean(false);
    private volatile boolean ch = false;
    private volatile boolean hi = false;
    private volatile boolean sl = false;
    private volatile boolean zb = false;
    private volatile boolean u = false;
    private volatile boolean ub = false;
    private volatile boolean ao = true;
    private long qv = 0;
    private long y = 0;
    private final int t = 0;
    private int nw = 0;
    private long b = 0;
    private long i = 0;
    private volatile boolean w = false;
    private volatile int le = 200;
    private long g = 0;
    private final ArrayList<Runnable> of = new ArrayList<>();
    private final Runnable p = new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.1
        @Override // java.lang.Runnable
        public void run() {
            long jY = ms.this.y();
            ms.this.i += (long) ms.this.le;
            if (ms.this.qv() > 0 && ms.this.g != jY) {
                if (ah.d()) {
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "run: lastCur = " + ms.this.g + "  currentPosition=" + jY);
                }
                ms msVar = ms.this;
                msVar.ms(jY, msVar.qv());
            }
            ms.this.g = jY;
            if (ms.this.y() >= ms.this.re) {
                ms.this.zb = true;
                ms.this.ka();
                for (WeakReference weakReference : ms.this.xr) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(ms.this);
                    }
                }
            }
            if (!ms.this.zb) {
                if (ms.this.c != null) {
                    ms.this.c.postDelayed(this, ms.this.le);
                }
            } else {
                ms msVar2 = ms.this;
                msVar2.ms(msVar2.qv(), ms.this.qv());
            }
        }
    };
    private final ILiveListener ul = new ILiveListener() { // from class: com.bytedance.sdk.component.sl.ms.ms.7
        private boolean xr = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.xr) {
                    return;
                }
                this.xr = true;
                xr xrVar = new xr(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : ms.this.xr) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(ms.this, xrVar);
                    }
                }
            }
            ms.this.ao = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            if (ms.this.c == null) {
                return;
            }
            ms.this.w = true;
            ms.this.c.removeCallbacks(ms.this.p);
            if (ms.this.re > 0) {
                ms.this.c.postDelayed(ms.this.p, ms.this.le);
            }
            ms.this.ao = false;
            if (z) {
                ms.this.qv = System.currentTimeMillis() - ms.this.h;
                for (WeakReference weakReference : ms.this.xr) {
                    if (weakReference != null && weakReference.get() != null) {
                        com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms = (com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get();
                        ms msVar = ms.this;
                        interfaceC0179ms.ms(msVar, msVar.qv);
                    }
                }
                return;
            }
            com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z)));
            for (WeakReference weakReference2 : ms.this.xr) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference2.get()).ms((com.bykv.vk.openvk.component.video.api.ms) ms.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (ms.this.c == null) {
                return;
            }
            ms.h(ms.this);
            ms.this.b = System.currentTimeMillis();
            ms.this.c.removeCallbacks(ms.this.p);
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(ms.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (ms.this.c == null) {
                return;
            }
            if (ms.this.re > 0) {
                ms.this.c.postDelayed(ms.this.p, ms.this.le);
            }
            ms.this.y += System.currentTimeMillis() - ms.this.b;
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms((com.bykv.vk.openvk.component.video.api.ms) ms.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (ms.this.c == null) {
                return;
            }
            ms.this.c.removeCallbacks(ms.this.p);
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(ms.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "onPrepared.....");
            ms.this.u = true;
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).xr(ms.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            ms.this.d = i;
            ms.this.ka = i2;
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms((com.bykv.vk.openvk.component.video.api.ms) ms.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : ms.this.xr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) weakReference.get()).ms(ms.this, jSONObject, str);
                }
            }
        }
    };

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(int i) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(long j) {
    }

    static /* synthetic */ int h(ms msVar) {
        int i = msVar.nw;
        msVar.nw = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j, long j2) {
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.xr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ms(this, j, j2);
            }
        }
    }

    public ms(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.c = null;
        this.ab = false;
        this.re = 0L;
        this.ah = context;
        this.pc = jSONObject;
        this.re = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.c = new le(looper, this);
            this.ab = true;
        } else if (this.c == null) {
            this.c = com.bytedance.sdk.component.ch.xr.ms.ms().ms(this, "tt-live-video-player");
        }
        d(z);
    }

    private void d(final boolean z) {
        le leVar = this.c;
        if (leVar != null) {
            leVar.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.sl.ms.ms.2.1
                            /* JADX WARN: Code duplicated, block: B:13:0x002c  */
                            /* JADX WARN: Code duplicated, block: B:14:0x002f  */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            public <T> T getSettingsValueForKey(String str, T t) {
                                Object objValueOf;
                                str.hashCode();
                                if (str.equals("live_enable_close_play_retry")) {
                                    if (t.getClass() == Integer.class) {
                                        objValueOf = Integer.valueOf("1");
                                    }
                                    return t.getClass() == Boolean.class ? (T) Boolean.TRUE : (T) objValueOf;
                                }
                                if (!str.equals("live_sdk_cancel_sdk_dns_fail_retry")) {
                                    return t;
                                }
                                objValueOf = t;
                                if (t.getClass() == Boolean.class) {
                                }
                            }
                        };
                        ms msVar = ms.this;
                        msVar.f1324ms = VideoLiveManager.newBuilder(msVar.ah).setProjectKey("pangle_ad_live").setNetworkClient(new C0250ms()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(ms.this.ul).build();
                        ms.this.f1324ms.setIntOption(69, z ? 1 : 0);
                        ms.this.f1324ms.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.xr.ms(ms.this.ah, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.bykv.vk.openvk.component.video.api.c.ah.ah("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(d dVar) {
        if (dVar == null) {
            return;
        }
        this.cv = dVar;
        com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "setDataSource: model = " + dVar.ao());
        le leVar = this.c;
        if (leVar != null) {
            leVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms() {
        this.nw = 0;
        this.y = 0L;
        this.b = 0L;
        ms(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z, final long j, final boolean z2) {
        le leVar;
        if (this.ny.get() && this.ch && this.f1324ms != null) {
            this.i = j;
            this.h = System.currentTimeMillis();
            ms(z2);
            le leVar2 = this.c;
            if (leVar2 != null) {
                leVar2.sendEmptyMessage(100);
            }
            sl.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            ms(new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.3
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.i = j;
                    ms.this.h = System.currentTimeMillis();
                    ms.this.ms(z2);
                    if (ms.this.c != null) {
                        ms.this.c.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.x.set(true);
        if (!this.ny.get() || (leVar = this.c) == null) {
            return;
        }
        leVar.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.4
            @Override // java.lang.Runnable
            public void run() {
                ms.this.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        ArrayList<Runnable> arrayList = this.of;
        if (arrayList != null && !arrayList.isEmpty()) {
            nw();
        }
    }

    private synchronized void ms(Runnable runnable) {
        this.of.add(runnable);
    }

    private synchronized void nw() {
        if (this.jw) {
            return;
        }
        this.jw = true;
        Iterator it = new ArrayList(this.of).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.of.clear();
        this.jw = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr() {
        le leVar = this.c;
        if (leVar != null) {
            leVar.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.f1324ms == null || ms.this.zb()) {
                        return;
                    }
                    try {
                        ms.this.f1324ms.play();
                        ms msVar = ms.this;
                        msVar.ms(msVar.f);
                        for (WeakReference weakReference : ms.this.xr) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    ms.this.ao = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z) {
        this.f = z;
        if (this.f1324ms != null) {
            com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z)));
            try {
                this.f1324ms.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah() {
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + y());
        le leVar = this.c;
        if (leVar != null) {
            leVar.removeCallbacks(this.p);
            leVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void d() {
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + y());
        le leVar = this.c;
        if (leVar != null) {
            leVar.removeCallbacks(this.p);
            leVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ka() {
        le leVar = this.c;
        if (leVar != null) {
            leVar.removeCallbacks(this.p);
            leVar.sendEmptyMessage(103);
            b();
        }
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    private void b() {
        le leVar = this.c;
        if (leVar == null || leVar.getLooper() == null) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.bytedance.sdk.component.sl.ms.ms.6
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.c == null || ms.this.c.getLooper() == null) {
                    return;
                }
                try {
                    ms.this.op = null;
                    ms.this.yu = null;
                    if (ms.this.ab) {
                        ms.this.c.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.ch.xr.ms.ms().ms(ms.this.c);
                    }
                    ms.this.c = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean c() {
        return this.w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(boolean z) {
        this.sl = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceHolder surfaceHolder) {
        this.yu = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        le leVar = this.c;
        if (leVar != null) {
            leVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceTexture surfaceTexture) {
        this.op = surfaceTexture;
        le leVar = this.c;
        if (leVar != null) {
            leVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ny() {
        com.bykv.vk.openvk.component.video.api.c.ah.xr("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.zb);
        return this.zb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ch() {
        return this.ub;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int hi() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int sl() {
        return this.ka;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean zb() {
        ILivePlayer iLivePlayer = this.f1324ms;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean u() {
        return this.ao;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ub() {
        return this.hi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long ao() {
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int h() {
        return this.nw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long qv() {
        return this.re;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long y() {
        return this.i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah(boolean z) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms) {
        if (interfaceC0179ms == null) {
            return;
        }
        for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.xr) {
            if (weakReference != null && weakReference.get() == interfaceC0179ms) {
                return;
            }
        }
        this.xr.add(new WeakReference<>(interfaceC0179ms));
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(int i) {
        this.le = i;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        try {
            switch (message.what) {
                case 100:
                    xr();
                    this.ub = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.f1324ms;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> weakReference : this.xr) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.ao = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.f1324ms;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.ao = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.f1324ms;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable th3) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.hi = true;
                        this.ao = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.f1324ms;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable th4) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.ao = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.f1324ms == null || this.cv == null) {
                        return;
                    }
                    String strAo = this.cv.ao();
                    ms(strAo);
                    this.f1324ms.setStreamInfo(strAo);
                    this.ch = true;
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "set Datasource:" + this.ch);
                    this.nw = 0;
                    return;
                case 110:
                    if (this.f1324ms != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        this.f1324ms.setSurfaceHolder(surfaceHolder);
                        this.f1324ms.setSurface(surfaceHolder.getSurface());
                        this.ny.set(true);
                        if (this.x.get()) {
                            t();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer5 = this.f1324ms;
                    if (iLivePlayer5 != null) {
                        iLivePlayer5.setSurface(new Surface(this.op));
                        this.ny.set(true);
                        if (this.x.get()) {
                            t();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        e.getMessage();
    }

    private void ms(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.pc;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int iOptInt = jSONObject.optInt(cl.q);
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(e.Y);
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("app_id");
                    com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "api ".concat(String.valueOf(strOptString2)));
                    if (strOptString.contains(strOptString2)) {
                        if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                            str2 = LiveConfigKey.UHD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                            str2 = LiveConfigKey.STANDARD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.f1324ms.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("TTLiveVideoPlayer", "updateStream: catch exception:", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.sl.ms.ms$ms, reason: collision with other inner class name */
    public static class C0250ms implements INetworkClient {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.sdk.component.xr.ms.sl f1333ms = ah.ah().xr().ms(10, TimeUnit.SECONDS).xr(10, TimeUnit.SECONDS).ah(10, TimeUnit.SECONDS).ms();

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strXr;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    ao aoVarMs = this.f1333ms.ms(new u.ms().ms(str).xr("host", str2).xr()).ms();
                    if (aoVarMs.d()) {
                        strXr = aoVarMs.c().xr();
                        try {
                            string = aoVarMs.ab().toString();
                            jSONObject = new JSONObject(strXr);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strXr;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strXr = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strXr).build();
                } catch (JSONException e2) {
                    e = e2;
                    str3 = null;
                }
            } catch (IOException e3) {
                return INetworkClient.Result.newBuilder().setException(e3).build();
            } catch (Exception e4) {
                return INetworkClient.Result.newBuilder().setException(e4).build();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceTexture x() {
        return this.op;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceHolder ab() {
        return this.yu;
    }
}
