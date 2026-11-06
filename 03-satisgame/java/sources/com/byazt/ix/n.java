package com.byazt.ix;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.anythink.core.common.l.f;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.iza.qg;
import com.byazt.qp.q;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, 1439, 19})
public class n implements x, wo.n {
    public boolean ae;
    public boolean an;
    public volatile k bb;
    public SurfaceHolder h;
    public long hd;
    public JSONObject j;
    public int l;
    public ILivePlayer n;
    public int q;
    public final Context s;
    public SurfaceTexture t;
    public Handler w;
    public long wm;
    public volatile boolean x;
    public final List<WeakReference<x.n>> qg = Collections.synchronizedList(new ArrayList());
    public AtomicBoolean fs = new AtomicBoolean(false);
    public AtomicBoolean rv = new AtomicBoolean(false);
    public volatile boolean tj = false;
    public volatile boolean cp = false;
    public volatile boolean d = false;
    public volatile boolean oa = false;
    public volatile boolean sz = false;
    public volatile boolean k = false;
    public volatile boolean cy = true;
    public long cd = 0;
    public long um = 0;
    public final int a = 0;
    public int py = 0;
    public long ou = 0;
    public long m = 0;
    public volatile boolean hu = false;
    public volatile int ur = 200;
    public long ln = 0;
    public final ArrayList<Runnable> lh = new ArrayList<>();
    public final Runnable v = new Runnable() { // from class: com.byazt.ix.n.1
        @Override // java.lang.Runnable
        public void run() {
            x.n nVar;
            long jPy = n.this.py();
            n.this.m += (long) n.this.ur;
            if (n.this.a() > 0 && n.this.ln != jPy) {
                qg.q();
                n nVar2 = n.this;
                nVar2.n(jPy, nVar2.a());
            }
            n.this.ln = jPy;
            if (n.this.py() >= n.this.wm) {
                n.this.oa = true;
                n.this.w();
                for (WeakReference weakReference : n.this.qg) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n(n.this);
                    }
                }
            }
            if (!n.this.oa) {
                if (n.this.w != null) {
                    n.this.w.postDelayed(this, n.this.ur);
                }
            } else {
                n nVar3 = n.this;
                nVar3.n(nVar3.a(), n.this.a());
            }
        }
    };
    public final ILiveListener f = new ILiveListener() { // from class: com.byazt.ix.n.7
        public boolean qg = false;

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
            x.n nVar;
            if (liveError != null) {
                if (this.qg) {
                    return;
                }
                this.qg = true;
                com.byazt.zsl.qg qgVar = new com.byazt.zsl.qg(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : n.this.qg) {
                    if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                        nVar.n(n.this, qgVar);
                    }
                }
            }
            n.this.cy = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            x.n nVar;
            x.n nVar2;
            if (n.this.w == null) {
                return;
            }
            n.this.hu = true;
            n.this.w.removeCallbacks(n.this.v);
            if (n.this.wm > 0) {
                n.this.w.postDelayed(n.this.v, n.this.ur);
            }
            n.this.cy = false;
            if (z) {
                n.this.cd = System.currentTimeMillis() - n.this.hd;
                for (WeakReference weakReference : n.this.qg) {
                    if (weakReference != null && (nVar2 = (x.n) weakReference.get()) != null) {
                        n nVar3 = n.this;
                        nVar2.n(nVar3, nVar3.cd);
                    }
                }
                return;
            }
            for (WeakReference weakReference2 : n.this.qg) {
                if (weakReference2 != null && (nVar = (x.n) weakReference2.get()) != null) {
                    nVar.n((x) n.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            x.n nVar;
            if (n.this.w == null) {
                return;
            }
            n.hd(n.this);
            n.this.ou = System.currentTimeMillis();
            n.this.w.removeCallbacks(n.this.v);
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.n(n.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            x.n nVar;
            if (n.this.w == null) {
                return;
            }
            if (n.this.wm > 0) {
                n.this.w.postDelayed(n.this.v, n.this.ur);
            }
            n.this.um += System.currentTimeMillis() - n.this.ou;
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.n((x) n.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            x.n nVar;
            if (n.this.w == null) {
                return;
            }
            n.this.w.removeCallbacks(n.this.v);
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.n(n.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            x.n nVar;
            n.this.sz = true;
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.s(n.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            x.n nVar;
            n.this.q = i;
            n.this.l = i2;
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.n((x) n.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            x.n nVar;
            for (WeakReference weakReference : n.this.qg) {
                if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                    nVar.n(n.this, jSONObject, str);
                }
            }
        }
    };

    @Override // com.byazt.ej.x
    public String h() {
        return "";
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
    }

    @Override // com.byazt.ej.x
    public void n(long j) {
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return false;
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
    }

    public static /* synthetic */ int hd(n nVar) {
        int i = nVar.py;
        nVar.py = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, long j2) {
        x.n nVar;
        for (WeakReference<x.n> weakReference : this.qg) {
            if (weakReference != null && (nVar = weakReference.get()) != null) {
                nVar.n(this, j, j2);
            }
        }
    }

    public n(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.w = null;
        this.x = false;
        this.wm = 0L;
        this.s = context;
        this.j = jSONObject;
        this.wm = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.w = new t(looper, this);
            this.x = true;
        } else if (this.w == null) {
            this.w = ((wo) q.n("thread_service")).n(this, "tt-live-video-player");
        }
        q(z);
    }

    private void q(final boolean z) {
        Handler handler = this.w;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ix.n.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.byazt.ix.n.2.1
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
                        n nVar = n.this;
                        nVar.n = VideoLiveManager.newBuilder(nVar.s).setProjectKey("pangle_ad_live").setNetworkClient(new C0205n()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(n.this.f).build();
                        n.this.n.setIntOption(69, z ? 1 : 0);
                        n.this.n.setStringOption(72, com.byazt.qyu.qg.n(n.this.s, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.byazt.nl.qg.n("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public void n(k kVar) {
        if (kVar == null) {
            return;
        }
        this.bb = kVar;
        kVar.ou();
        Handler handler = this.w;
        if (handler != null) {
            handler.sendEmptyMessage(107);
        }
    }

    @Override // com.byazt.ej.x
    public void qg() {
        this.py = 0;
        this.um = 0L;
        this.ou = 0L;
        n(true, 0L, false);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, final long j, final boolean z2) {
        Handler handler;
        if (this.rv.get() && this.tj && this.n != null) {
            this.m = j;
            this.hd = System.currentTimeMillis();
            qg(z2);
            Handler handler2 = this.w;
            if (handler2 != null) {
                handler2.sendEmptyMessage(100);
            }
        } else {
            n(new Runnable() { // from class: com.byazt.ix.n.3
                @Override // java.lang.Runnable
                public void run() {
                    n.this.m = j;
                    n.this.hd = System.currentTimeMillis();
                    n.this.qg(z2);
                    if (n.this.w != null) {
                        n.this.w.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.fs.set(true);
        if (!this.rv.get() || (handler = this.w) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.byazt.ix.n.4
            @Override // java.lang.Runnable
            public void run() {
                n.this.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        ArrayList<Runnable> arrayList = this.lh;
        if (arrayList != null && !arrayList.isEmpty()) {
            rv();
        }
    }

    private synchronized void n(Runnable runnable) {
        this.lh.add(runnable);
    }

    private synchronized void rv() {
        if (this.an) {
            return;
        }
        this.an = true;
        Iterator it = new ArrayList(this.lh).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.lh.clear();
        this.an = false;
    }

    @Override // com.byazt.ej.x
    public void s() {
        Handler handler = this.w;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ix.n.5
                @Override // java.lang.Runnable
                public void run() {
                    x.n nVar;
                    if (n.this.n == null || n.this.tj()) {
                        return;
                    }
                    try {
                        n.this.n.play();
                        n nVar2 = n.this;
                        nVar2.qg(nVar2.ae);
                        for (WeakReference weakReference : n.this.qg) {
                            if (weakReference != null && (nVar = (x.n) weakReference.get()) != null) {
                                nVar.w(n.this);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    n.this.cy = false;
                }
            });
        }
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        this.ae = z;
        ILivePlayer iLivePlayer = this.n;
        if (iLivePlayer != null) {
            try {
                iLivePlayer.setMute(Boolean.valueOf(z));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.ej.x
    public void q() {
        py();
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.ej.x
    public void x() {
        py();
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.sendEmptyMessage(105);
        }
    }

    @Override // com.byazt.ej.x
    public void l() {
        ur();
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.sendEmptyMessage(102);
        }
    }

    @Override // com.byazt.ej.x
    public void w() {
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.sendEmptyMessage(103);
            t();
        }
    }

    private void t() {
        Handler handler = this.w;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.w.post(new Runnable() { // from class: com.byazt.ix.n.6
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.w == null || n.this.w.getLooper() == null) {
                    return;
                }
                try {
                    n.this.t = null;
                    n.this.h = null;
                    if (n.this.x) {
                        n.this.w.removeCallbacksAndMessages(null);
                    } else {
                        ((wo) q.n("thread_service")).n(n.this.w);
                    }
                    n.this.w = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return this.hu;
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
        this.d = z;
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceHolder surfaceHolder) {
        this.h = surfaceHolder;
        Handler handler = this.w;
        if (handler != null) {
            handler.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceTexture surfaceTexture) {
        this.t = surfaceTexture;
        Handler handler = this.w;
        if (handler != null) {
            handler.obtainMessage(111, surfaceTexture).sendToTarget();
        }
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return this.oa;
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return this.sz;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        return this.k;
    }

    @Override // com.byazt.ej.x
    public int hd() {
        return this.q;
    }

    @Override // com.byazt.ej.x
    public int cd() {
        return this.l;
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        ILivePlayer iLivePlayer = this.n;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return this.cy;
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return this.cp;
    }

    @Override // com.byazt.ej.x
    public long cy() {
        return this.um;
    }

    @Override // com.byazt.ej.x
    public int um() {
        return this.py;
    }

    @Override // com.byazt.ej.x
    public long a() {
        return this.wm;
    }

    @Override // com.byazt.ej.x
    public long py() {
        return this.m;
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        if (nVar == null) {
            return;
        }
        for (WeakReference<x.n> weakReference : this.qg) {
            if (weakReference != null && weakReference.get() == nVar) {
                return;
            }
        }
        this.qg.add(new WeakReference<>(nVar));
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        if (nVar == null) {
            return;
        }
        Iterator<WeakReference<x.n>> it = this.qg.iterator();
        while (it.hasNext()) {
            WeakReference<x.n> next = it.next();
            if (next != null && next.get() == nVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        this.ur = i;
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.ur;
    }

    private void ur() {
        this.tj = false;
        this.oa = false;
        this.sz = false;
        this.k = false;
        this.cy = true;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        x.n nVar;
        x.n nVar2;
        try {
            switch (message.what) {
                case 100:
                    for (WeakReference<x.n> weakReference : this.qg) {
                        if (weakReference != null && (nVar = weakReference.get()) != null) {
                            nVar.qg(this);
                        }
                    }
                    s();
                    this.k = true;
                    break;
                case 101:
                    ILivePlayer iLivePlayer = this.n;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<x.n> weakReference2 : this.qg) {
                                if (weakReference2 != null && (nVar2 = weakReference2.get()) != null) {
                                    nVar2.l(this);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        this.cy = true;
                    }
                    break;
                case 102:
                    ILivePlayer iLivePlayer2 = this.n;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable unused2) {
                        }
                        this.cy = true;
                    }
                    break;
                case 103:
                    ILivePlayer iLivePlayer3 = this.n;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable unused3) {
                        }
                        this.cp = true;
                        this.cy = true;
                    }
                    break;
                case 105:
                    ILivePlayer iLivePlayer4 = this.n;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable unused4) {
                        }
                        this.cy = true;
                    }
                    break;
                case 107:
                    if (this.n != null && this.bb != null) {
                        String strOu = this.bb.ou();
                        n(strOu);
                        this.n.setStreamInfo(strOu);
                        this.tj = true;
                        this.py = 0;
                        break;
                    }
                    break;
                case 110:
                    if (this.n != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        this.n.setSurfaceHolder(surfaceHolder);
                        this.n.setSurface(surfaceHolder.getSurface());
                        this.rv.set(true);
                        if (this.fs.get()) {
                            n();
                        }
                    }
                    break;
                case 111:
                    ILivePlayer iLivePlayer5 = this.n;
                    if (iLivePlayer5 != null) {
                        iLivePlayer5.setSurface(new Surface(this.t));
                        this.rv.set(true);
                        if (this.fs.get()) {
                            n();
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void n(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.j;
            if (jSONObject == null) {
                return;
            }
            int iOptInt = jSONObject.optInt("enable");
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(f.Z);
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject(f.R);
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || !strOptString.contains(jSONObjectOptJSONObject.optString("app_id"))) {
                    return;
                }
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
                this.n.setStringOption(43, str2);
            }
        } catch (Exception e) {
            Object[] objArr = new Object[2];
            e.getMessage();
        }
    }

    /* JADX INFO: renamed from: com.byazt.ix.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1439, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0205n implements INetworkClient {
        public final d n = qg.s().qg().n(10, TimeUnit.SECONDS).qg(10, TimeUnit.SECONDS).s(10, TimeUnit.SECONDS).n();

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strQg;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    cy cyVarQg = this.n.n(new sz.n().qg(str).qg(f.bU, str2).qg()).qg();
                    if (cyVarQg.l()) {
                        strQg = cyVarQg.x().qg();
                        try {
                            string = cyVarQg.fs().toString();
                            jSONObject = new JSONObject(strQg);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strQg;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strQg = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strQg).build();
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

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return this.t;
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return this.h;
    }
}
