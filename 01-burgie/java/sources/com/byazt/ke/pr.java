package com.byazt.ke;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.ca.iu;
import com.byazt.ihe.fw;
import com.byazt.ihe.m;
import com.byazt.mg.PluginConstants;
import com.byazt.n.hn;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.vkw.qi;
import com.byazt.y.hw;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.mar.sdk.MARCode;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 839, 37})
public class pr implements qi.pr, fw {
    public SurfaceHolder b;
    public int c;
    public boolean e;
    public long fo;
    public volatile boolean fw;
    public volatile m gz;
    public final Context hn;
    public SurfaceTexture iu;
    public JSONObject n;
    public ILivePlayer pr;
    public boolean s;
    public Handler uc;
    public int x;
    public long yb;
    public final List<WeakReference<fw.pr>> hw = Collections.synchronizedList(new ArrayList());
    public AtomicBoolean zo = new AtomicBoolean(false);
    public AtomicBoolean aj = new AtomicBoolean(false);
    public volatile boolean vk = false;
    public volatile boolean w = false;
    public volatile boolean k = false;
    public volatile boolean m = false;
    public volatile boolean g = false;
    public volatile boolean ho = false;
    public volatile boolean nt = true;
    public long lb = 0;
    public long qa = 0;
    public final int a = 0;
    public int cz = 0;
    public long ny = 0;
    public long rc = 0;
    public volatile boolean z = false;
    public volatile int ve = 200;
    public long nl = 0;
    public final ArrayList<Runnable> y = new ArrayList<>();
    public final Runnable ww = new Runnable() { // from class: com.byazt.ke.pr.1
        @Override // java.lang.Runnable
        public void run() {
            fw.pr prVar;
            long jCz = pr.this.cz();
            pr.this.rc += (long) pr.this.ve;
            if (pr.this.a() > 0 && pr.this.nl != jCz) {
                hw.x();
                pr prVar2 = pr.this;
                prVar2.pr(jCz, prVar2.a());
            }
            pr.this.nl = jCz;
            if (pr.this.cz() >= pr.this.fo) {
                pr.this.m = true;
                pr.this.uc();
                for (WeakReference weakReference : pr.this.hw) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(pr.this);
                    }
                }
            }
            if (!pr.this.m) {
                if (pr.this.uc != null) {
                    pr.this.uc.postDelayed(this, pr.this.ve);
                }
            } else {
                pr prVar3 = pr.this;
                prVar3.pr(prVar3.a(), pr.this.a());
            }
        }
    };
    public final ILiveListener ls = new ILiveListener() { // from class: com.byazt.ke.pr.7
        public boolean hw = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            fw.pr prVar;
            if (liveError != null) {
                if (this.hw) {
                    return;
                }
                this.hw = true;
                hn hnVar = new hn(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : pr.this.hw) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(pr.this, hnVar);
                    }
                }
            }
            pr.this.nt = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            fw.pr prVar;
            fw.pr prVar2;
            if (pr.this.uc != null) {
                pr.this.z = true;
                pr.this.uc.removeCallbacks(pr.this.ww);
                if (pr.this.fo > 0) {
                    pr.this.uc.postDelayed(pr.this.ww, pr.this.ve);
                }
                pr.this.nt = false;
                if (z) {
                    pr.this.lb = System.currentTimeMillis() - pr.this.yb;
                    for (WeakReference weakReference : pr.this.hw) {
                        if (weakReference != null && (prVar2 = (fw.pr) weakReference.get()) != null) {
                            pr prVar3 = pr.this;
                            prVar2.pr(prVar3, prVar3.lb);
                        }
                    }
                    return;
                }
                for (WeakReference weakReference2 : pr.this.hw) {
                    if (weakReference2 != null && (prVar = (fw.pr) weakReference2.get()) != null) {
                        prVar.pr((fw) pr.this, -1);
                    }
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            fw.pr prVar;
            if (pr.this.uc == null) {
                return;
            }
            pr.yb(pr.this);
            pr.this.ny = System.currentTimeMillis();
            pr.this.uc.removeCallbacks(pr.this.ww);
            for (WeakReference weakReference : pr.this.hw) {
                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                    prVar.pr(pr.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            fw.pr prVar;
            if (pr.this.uc == null) {
                return;
            }
            if (pr.this.fo > 0) {
                pr.this.uc.postDelayed(pr.this.ww, pr.this.ve);
            }
            pr.this.qa += System.currentTimeMillis() - pr.this.ny;
            for (WeakReference weakReference : pr.this.hw) {
                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                    prVar.pr((fw) pr.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            fw.pr prVar;
            if (pr.this.uc != null) {
                pr.this.uc.removeCallbacks(pr.this.ww);
                for (WeakReference weakReference : pr.this.hw) {
                    if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                        prVar.pr(pr.this, -1, -1, -1);
                    }
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            fw.pr prVar;
            pr.this.g = true;
            for (WeakReference weakReference : pr.this.hw) {
                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                    prVar.hn(pr.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            fw.pr prVar;
            pr.this.x = i;
            pr.this.c = i2;
            for (WeakReference weakReference : pr.this.hw) {
                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                    prVar.pr((fw) pr.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            fw.pr prVar;
            for (WeakReference weakReference : pr.this.hw) {
                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                    prVar.pr(pr.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }
    };

    public static /* synthetic */ int yb(pr prVar) {
        int i = prVar.cz;
        prVar.cz = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j, long j2) {
        fw.pr prVar;
        for (WeakReference<fw.pr> weakReference : this.hw) {
            if (weakReference != null && (prVar = weakReference.get()) != null) {
                prVar.pr(this, j, j2);
            }
        }
    }

    public pr(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.uc = null;
        this.fw = false;
        this.fo = 0L;
        this.hn = context;
        this.n = jSONObject;
        this.fo = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.uc = new iu(looper, this);
            this.fw = true;
        } else if (this.uc == null) {
            this.uc = ((qi) uc.pr("thread_service")).pr(this, "tt-live-video-player");
        }
        x(z);
    }

    private void x(final boolean z) {
        Handler handler = this.uc;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ke.pr.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.byazt.ke.pr.2.1
                            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                            /* JADX WARN: Code duplicated, block: B:11:0x001d  */
                            /* JADX WARN: Code duplicated, block: B:20:0x003a  */
                            /* JADX WARN: Code duplicated, block: B:21:0x003d  */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            public <T> T getSettingsValueForKey(String str, T t) {
                                Object objValueOf;
                                switch (str) {
                                    case "live_enable_close_play_retry":
                                        if (t.getClass() == Integer.class) {
                                            objValueOf = Integer.valueOf("1");
                                        }
                                        if (t.getClass() == Boolean.class) {
                                            return (T) objValueOf;
                                        }
                                        return (T) Boolean.TRUE;
                                    case "live_sdk_cancel_sdk_dns_fail_retry":
                                        objValueOf = t;
                                        if (t.getClass() == Boolean.class) {
                                            return (T) objValueOf;
                                        }
                                        return (T) Boolean.TRUE;
                                    default:
                                        return t;
                                }
                            }
                        };
                        pr prVar = pr.this;
                        int i = 0;
                        prVar.pr = VideoLiveManager.newBuilder(prVar.hn).setProjectKey("pangle_ad_live").setNetworkClient(new C0114pr()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(pr.this.ls).build();
                        ILivePlayer iLivePlayer = pr.this.pr;
                        if (z) {
                            i = 1;
                        }
                        iLivePlayer.setIntOption(69, i);
                        pr.this.pr.setStringOption(72, com.byazt.mg.hw.pr(pr.this.hn, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.byazt.o.hw.pr("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(m mVar) {
        if (mVar == null) {
            return;
        }
        this.gz = mVar;
        mVar.ny();
        Handler handler = this.uc;
        if (handler != null) {
            handler.sendEmptyMessage(107);
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        this.cz = 0;
        this.qa = 0L;
        this.ny = 0L;
        pr(true, 0L, false);
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, final long j, final boolean z2) {
        Handler handler;
        if (this.aj.get() && this.vk && this.pr != null) {
            this.rc = j;
            this.yb = System.currentTimeMillis();
            hw(z2);
            Handler handler2 = this.uc;
            if (handler2 != null) {
                handler2.sendEmptyMessage(100);
            }
        } else {
            pr(new Runnable() { // from class: com.byazt.ke.pr.3
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.rc = j;
                    pr.this.yb = System.currentTimeMillis();
                    pr.this.hw(z2);
                    if (pr.this.uc != null) {
                        pr.this.uc.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.zo.set(true);
        if (this.aj.get() && (handler = this.uc) != null) {
            handler.post(new Runnable() { // from class: com.byazt.ke.pr.4
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.pr();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr() {
        ArrayList<Runnable> arrayList = this.y;
        if (arrayList != null && !arrayList.isEmpty()) {
            aj();
        }
    }

    private synchronized void pr(Runnable runnable) {
        this.y.add(runnable);
    }

    private synchronized void aj() {
        if (this.e) {
            return;
        }
        this.e = true;
        Iterator it = new ArrayList(this.y).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.y.clear();
        this.e = false;
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        Handler handler = this.uc;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ke.pr.5
                @Override // java.lang.Runnable
                public void run() {
                    fw.pr prVar;
                    if (pr.this.pr != null && !pr.this.vk()) {
                        try {
                            pr.this.pr.play();
                            pr prVar2 = pr.this;
                            prVar2.hw(prVar2.s);
                            for (WeakReference weakReference : pr.this.hw) {
                                if (weakReference != null && (prVar = (fw.pr) weakReference.get()) != null) {
                                    prVar.uc(pr.this);
                                }
                            }
                        } catch (Throwable th) {
                        }
                        pr.this.nt = false;
                    }
                }
            });
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw(boolean z) {
        this.s = z;
        ILivePlayer iLivePlayer = this.pr;
        if (iLivePlayer != null) {
            try {
                iLivePlayer.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        cz();
        Handler handler = this.uc;
        if (handler != null) {
            handler.removeCallbacks(this.ww);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        cz();
        Handler handler = this.uc;
        if (handler != null) {
            handler.removeCallbacks(this.ww);
            handler.sendEmptyMessage(105);
        }
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        ve();
        Handler handler = this.uc;
        if (handler != null) {
            handler.removeCallbacks(this.ww);
            handler.sendEmptyMessage(102);
        }
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        Handler handler = this.uc;
        if (handler != null) {
            handler.removeCallbacks(this.ww);
            handler.sendEmptyMessage(103);
            iu();
        }
    }

    private void iu() {
        Handler handler = this.uc;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.uc.post(new Runnable() { // from class: com.byazt.ke.pr.6
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.uc != null && pr.this.uc.getLooper() != null) {
                    try {
                        pr.this.iu = null;
                        pr.this.b = null;
                        if (pr.this.fw) {
                            pr.this.uc.removeCallbacksAndMessages(null);
                        } else {
                            ((qi) uc.pr("thread_service")).pr(pr.this.uc);
                        }
                        pr.this.uc = null;
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void pr(long j) {
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        return this.z;
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z) {
        this.k = z;
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceHolder surfaceHolder) {
        this.b = surfaceHolder;
        Handler handler = this.uc;
        if (handler != null) {
            handler.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceTexture surfaceTexture) {
        this.iu = surfaceTexture;
        Handler handler = this.uc;
        if (handler != null) {
            handler.obtainMessage(111, surfaceTexture).sendToTarget();
        }
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        return this.m;
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        return this.g;
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        return this.ho;
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        return this.x;
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        return this.c;
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        ILivePlayer iLivePlayer = this.pr;
        if (iLivePlayer != null) {
            try {
                return iLivePlayer.isPlaying();
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        return this.nt;
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        return this.w;
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        return this.qa;
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        return this.cz;
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        return this.fo;
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        return this.rc;
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        return false;
    }

    @Override // com.byazt.ihe.fw
    public void pr(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        for (WeakReference<fw.pr> weakReference : this.hw) {
            if (weakReference != null && weakReference.get() == prVar) {
                return;
            }
        }
        this.hw.add(new WeakReference<>(prVar));
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        Iterator<WeakReference<fw.pr>> it = this.hw.iterator();
        while (it.hasNext()) {
            WeakReference<fw.pr> next = it.next();
            if (next != null && next.get() == prVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        this.ve = i;
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        return this.ve;
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
    }

    private void ve() {
        this.vk = false;
        this.m = false;
        this.g = false;
        this.ho = false;
        this.nt = true;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        fw.pr prVar;
        fw.pr prVar2;
        try {
            switch (message.what) {
                case 100:
                    for (WeakReference<fw.pr> weakReference : this.hw) {
                        if (weakReference != null && (prVar = weakReference.get()) != null) {
                            prVar.hw(this);
                        }
                    }
                    hn();
                    this.ho = true;
                    break;
                case 101:
                    ILivePlayer iLivePlayer = this.pr;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<fw.pr> weakReference2 : this.hw) {
                                if (weakReference2 != null && (prVar2 = weakReference2.get()) != null) {
                                    prVar2.c(this);
                                }
                            }
                        } catch (Throwable th) {
                        }
                        this.nt = true;
                    }
                    break;
                case 102:
                    ILivePlayer iLivePlayer2 = this.pr;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable th2) {
                        }
                        this.nt = true;
                    }
                    break;
                case 103:
                    ILivePlayer iLivePlayer3 = this.pr;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable th3) {
                        }
                        this.w = true;
                        this.nt = true;
                    }
                    break;
                case 105:
                    ILivePlayer iLivePlayer4 = this.pr;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable th4) {
                        }
                        this.nt = true;
                    }
                    break;
                case 107:
                    if (this.pr != null && this.gz != null) {
                        String strNy = this.gz.ny();
                        pr(strNy);
                        this.pr.setStreamInfo(strNy);
                        this.vk = true;
                        this.cz = 0;
                        break;
                    }
                    break;
                case 110:
                    if (this.pr != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        this.pr.setSurfaceHolder(surfaceHolder);
                        this.pr.setSurface(surfaceHolder.getSurface());
                        this.aj.set(true);
                        if (this.zo.get()) {
                            pr();
                        }
                    }
                    break;
                case 111:
                    ILivePlayer iLivePlayer5 = this.pr;
                    if (iLivePlayer5 != null) {
                        iLivePlayer5.setSurface(new Surface(this.iu));
                        this.aj.set(true);
                        if (this.zo.get()) {
                            pr();
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void pr(String str) {
        String str2 = LiveConfigKey.UHD;
        try {
            JSONObject jSONObject = this.n;
            if (jSONObject == null) {
                return;
            }
            int iOptInt = jSONObject.optInt("enable");
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("common");
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null && strOptString.contains(jSONObjectOptJSONObject.optString(PluginConstants.KEY_APP_ID))) {
                    if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) == null) {
                        if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                            str2 = LiveConfigKey.STANDARD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        } else {
                            str2 = LiveConfigKey.LOW;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        this.pr.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            Object[] objArr = {"updateStream: catch exception:", e.getMessage()};
        }
    }

    /* JADX INFO: renamed from: com.byazt.ke.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 839, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0114pr implements INetworkClient {
        public final k pr = hw.hn().hw().pr(10, TimeUnit.SECONDS).hw(10, TimeUnit.SECONDS).hn(10, TimeUnit.SECONDS).pr();

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strHw;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    nt ntVarHw = this.pr.pr(new g.pr().pr(str).hw("host", str2).hw()).hw();
                    if (!ntVarHw.x()) {
                        strHw = null;
                    } else {
                        strHw = ntVarHw.uc().hw();
                        try {
                            string = ntVarHw.fw().toString();
                            jSONObject = new JSONObject(strHw);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strHw;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strHw).build();
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

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        return this.iu;
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        return this.b;
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        return "";
    }
}
