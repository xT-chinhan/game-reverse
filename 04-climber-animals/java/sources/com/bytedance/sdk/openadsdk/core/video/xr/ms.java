package com.bytedance.sdk.openadsdk.core.video.xr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bykv.vk.openvk.component.video.ms.d.d;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.ub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends com.bytedance.sdk.openadsdk.core.video.ms.ms {
    private int am;
    private ah.ms az;
    private final int eg;
    private long il;
    private WeakReference<ah.xr> k;
    private InterfaceC0325ms lm;
    protected com.bytedance.sdk.openadsdk.core.xr.ms of;
    private final String qf;
    private int sa;
    private int ti;
    private long tz;
    public long w;
    protected ViewGroup yu;
    protected long op = 0;
    protected boolean le = false;
    protected boolean cv = false;
    protected Map<String, Object> g = null;
    private final AtomicInteger pc = new AtomicInteger(0);
    private final AtomicInteger jw = new AtomicInteger(0);
    private long f = 0;
    private long ul = 0;
    private final Runnable m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.1
        @Override // java.lang.Runnable
        public void run() {
            if (ms.this.az != null) {
                ms.this.az.ms();
            }
            if (ms.this.lm != null) {
                ms.this.lm.xr();
            }
        }
    };
    private boolean e = false;
    private boolean fm = false;
    private boolean xn = true;
    private boolean l = false;
    com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms p = new com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2
        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.c(false);
                }
            });
            ms.this.ms(4);
            ms.this.ah(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.ka != null) {
                        ms.this.c(0);
                        ms.this.ka.xr();
                        ms.this.f3587ms.removeCallbacks(ms.this.m);
                        ms.this.fm = false;
                    }
                }
            });
            ms.this.ms(j, false);
            ms.this.il = System.currentTimeMillis();
            ms.this.s();
            if (ms.this.lm != null) {
                ms.this.lm.ah();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void xr(com.bykv.vk.openvk.component.video.api.ms msVar) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.3
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.f3587ms.removeCallbacks(ms.this.m);
                    if (ms.this.ka != null) {
                        ms.this.c(0);
                        ms.this.ka.xr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(final com.bykv.vk.openvk.component.video.api.ms msVar, final com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
            if (xrVar == null) {
                return;
            }
            sl.ms("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + xrVar.ms() + " msg:" + xrVar.ah());
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.ms msVar2;
                    com.bykv.vk.openvk.component.video.api.ms msVar3;
                    int iT;
                    int iMs = xrVar.ms();
                    if (iMs != 308 || (msVar2 = ms.this.d) == null || msVar2 == (msVar3 = msVar) || !(msVar3 instanceof d) || ((iT = ((d) msVar3).t()) != 200 && iT != 203)) {
                        ms.this.ms(iMs, xrVar.xr(), xrVar.ah(), (JSONArray) null);
                        ms.this.f3587ms.removeCallbacks(ms.this.m);
                        if (ms.this.ka != null) {
                            ms.this.c(0);
                            ms.this.ka.xr();
                        }
                        if (ms.this.az != null) {
                            ms.this.az.xr(ms.this.ul, com.bykv.vk.openvk.component.video.ms.ka.ms.ms(ms.this.ab, ms.this.w));
                        }
                        if (ms.this.lm != null) {
                            ms.this.lm.ms(iMs, xrVar.ah());
                            return;
                        }
                        return;
                    }
                    sl.d("BaseVideoController", "ignore errorCode:" + iMs + " state:" + iT);
                }
            });
            ms.this.ms(xrVar.ms(), xrVar.ah());
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, boolean z) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.5
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.f3587ms.removeCallbacks(ms.this.m);
                    if (ms.this.ka != null) {
                        ms.this.c(0);
                        ms.this.ka.xr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ah(com.bykv.vk.openvk.component.video.api.ms msVar) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onRelease: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            ms.this.am = i;
            ms.this.sa = i2;
            ms.this.v();
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2, int i3) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.ka != null) {
                        ms.this.c(8);
                        ms.this.ka.re();
                        ms.this.xn();
                        ms.this.fm = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.ka != null) {
                        ms.this.c(0);
                        ms.this.ka.xr();
                        ms.this.f3587ms.removeCallbacks(ms.this.m);
                        ms.this.fm = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void xr(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
            sl.ms("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(final com.bykv.vk.openvk.component.video.api.ms msVar, final long j, final long j2) {
            if (Math.abs(j - ms.this.ab) < 50) {
                return;
            }
            sl.ms("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j), "; duration=", Long.valueOf(j2));
            ms.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.re != null) {
                        ms.this.re.ms(j, j2);
                    }
                    ms.this.xr(j, j2);
                    if (ms.this.c.tf() != 2 || j2 <= 60000 || j < 60000 || ms.this.u) {
                        return;
                    }
                    ms.this.u = true;
                    msVar.d();
                    ms.this.c(false);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, JSONObject jSONObject, String str) {
            if (ch.ub().fm()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms((Context) ms.this.ny.get(), ms.this.c, ms.this.qf, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private final w.ms s = new w.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.3
        @Override // com.bytedance.sdk.component.utils.w.ms
        public void ms(Context context, Intent intent, boolean z, int i) {
            ms.this.ms(context, i);
        }
    };
    private boolean v = false;
    private long qk = 0;
    private AtomicBoolean vm = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.xr.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0325ms {
        void ah();

        void ms();

        void ms(int i, String str);

        void ms(long j, long j2);

        void xr();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void d(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ka(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(ah.d dVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean nw() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms
    public boolean op() {
        return true;
    }

    protected abstract int re();

    protected ms(Context context, ViewGroup viewGroup, lm lmVar, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.ti = 1;
        this.ti = u.ah(context);
        this.yu = viewGroup;
        this.ny = new WeakReference<>(context);
        this.c = lmVar;
        this.of = msVar;
        ms(context);
        this.eg = f.ny(this.c);
        this.qf = f.xr(this.c);
    }

    private void ms(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(com.bykv.vk.openvk.component.video.api.d.xr.ms.class);
        enumSetNoneOf.add(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn);
        enumSetNoneOf.add(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideBackBtn);
        this.ka = new c(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.c, this, this.of);
        this.ka.ms((com.bykv.vk.openvk.component.video.api.d.ms) this);
    }

    public void ms(long j, boolean z) {
        if (this.nw.ms(2)) {
            return;
        }
        this.op = j;
        ch(z);
        this.cv = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (dVar == null) {
            ms("model is null");
            return false;
        }
        if (this.d != null && this.d.u()) {
            this.d.xr();
            return true;
        }
        this.b = dVar;
        dVar.ao();
        if (TextUtils.isEmpty(dVar.ao())) {
            sl.d("BaseVideoController", "No video info");
            ms("url is null");
            return false;
        }
        this.le = (dVar.ao().startsWith("http") || com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) ? false : true;
        this.h = dVar.hi();
        if (dVar.ch() > 0) {
            this.ab = dVar.ch();
            this.x = this.x > this.ab ? this.x : this.ab;
        }
        if (this.ka != null) {
            this.ka.ms();
            c(8);
            this.ka.ab();
            this.ka.ah(dVar.x(), dVar.ny());
            this.ka.ah(this.yu);
        }
        try {
            if (this.d == null) {
                if (!i()) {
                    ms("create video error");
                    return false;
                }
                this.d.ms(this.p);
            }
            yu();
            this.ul = 0L;
            d(dVar);
            return true;
        } catch (Throwable th) {
            ms(th.getMessage());
            sl.d("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    private boolean i() {
        com.bykv.vk.openvk.component.video.api.ms dVar;
        lm lmVar = this.c;
        if (com.bytedance.sdk.openadsdk.ka.ms.xr(lmVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xr xrVarVm = vm();
            if (xrVarVm != null) {
                this.d = new com.bytedance.sdk.openadsdk.upie.video.lottie.ms(xrVarVm, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVar), new d(String.valueOf(f.x(this.c))), qr.h(lmVar));
            } else {
                if (this.p != null) {
                    this.p.ms((com.bykv.vk.openvk.component.video.api.ms) null, new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.ka == null)));
                }
                sl.d("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.bytedance.sdk.openadsdk.ka.ms.ah(lmVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xr xrVarVm2 = vm();
            if (xrVarVm2 != null) {
                int iX = f.x(this.c);
                if (g.d() && this.b.qv() == 1) {
                    dVar = new com.bytedance.sdk.component.sl.xr.xr(re.getContext(), String.valueOf(iX));
                } else {
                    dVar = new d(String.valueOf(iX));
                }
                this.d = new com.bytedance.sdk.openadsdk.upie.video.lottie.xr(dVar, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVar), xrVarVm2);
            } else {
                if (this.p != null) {
                    this.p.ms((com.bykv.vk.openvk.component.video.api.ms) null, new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.ka == null)));
                }
                sl.d("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iX2 = f.x(this.c);
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
                this.d = new com.bytedance.sdk.component.sl.ms.ms(re.getContext(), op(), (long) qr.c(this.c), re.xr().vl(), null);
            } else if (g.d() && this.b.qv() == 1) {
                this.d = new com.bytedance.sdk.component.sl.xr.xr(re.getContext(), String.valueOf(iX2));
            } else {
                this.d = new d(String.valueOf(iX2));
            }
        }
        return true;
    }

    public long ka(long j) {
        long jU = u();
        long jP = (j - p()) + (jU * ((long) fm()));
        long j2 = this.qk;
        if (jP < j2) {
            return j2;
        }
        this.qk = jP;
        return jP;
    }

    public long k() {
        return this.qk;
    }

    public void eg() {
        if (this.c != null) {
            new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().xr("auto_replay").ms(f.xr(this.c)).ka(this.c.df()).d(this.c.lx()).ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.4
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject) throws JSONException {
                    com.bykv.vk.openvk.component.video.api.ah.ah ahVarW;
                    JSONObject jSONObject2 = new JSONObject();
                    if (com.bytedance.sdk.openadsdk.op.ch.ms(ms.this.c)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (ms.this.b != null && (ahVarW = ms.this.b.w()) != null && ahVarW.ab() > 0.0d) {
                        jSONObject2.put("start", ahVarW.ab());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr() {
        if (this.d != null) {
            if (!ka()) {
                this.pc.getAndAdd(1);
                eg();
            }
            this.jw.getAndAdd(1);
            if (!of()) {
                this.nw.ms();
                lm();
                ms(0L, true);
            }
            ah(false);
            this.d.ms();
        }
    }

    public int fm() {
        if (com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
            return this.jw.get();
        }
        return this.pc.get();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ah() {
        return this.pc.get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public boolean d() {
        if (com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
            return ((double) this.jw.get()) <= ((double) qr.ao(this.c).ab());
        }
        return super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ka() {
        if (com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
            return ((double) this.jw.get()) < ((double) qr.ao(this.c).ab());
        }
        return super.d();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean b() {
        return this.fm;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ka(boolean z) {
        this.xn = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public int ub() {
        return com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.x, this.w);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(Map<String, Object> map) {
        this.g = map;
    }

    private void d(com.bykv.vk.openvk.component.video.api.ah.d dVar) throws Exception {
        if (dVar == null) {
            ms("model is null");
            return;
        }
        this.b = dVar;
        final long jAh = ah(dVar);
        if (this.d != null) {
            if (this.c != null) {
                dVar.d(String.valueOf(f.ny(this.c)));
            }
            dVar.d(1);
            this.d.ms(dVar);
            this.d.ms(g());
        }
        this.f = System.currentTimeMillis();
        if (!TextUtils.isEmpty(dVar.ao())) {
            this.ka.ka(8);
            this.ka.ka(0);
            ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.nw.d(1)) {
                        ms.this.ms("multi play_start");
                        return;
                    }
                    ms.this.nw.ms();
                    if (!ms.this.of() || !ms.this.tz()) {
                        ms.this.lm();
                    }
                    ms.this.f = System.currentTimeMillis();
                    ms.this.ka.d(0);
                    if (ms.this.d == null || ms.this.ab != 0) {
                        if (ms.this.d != null) {
                            ms.this.d.ms(true, ms.this.ab, ms.this.h);
                            return;
                        }
                        return;
                    }
                    ms.this.d.ms(true, jAh, ms.this.h);
                }
            });
            return;
        }
        ms("url is null");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    protected void xn() {
        int iUc;
        int iRe = re();
        if (iRe == 2 || iRe == 1) {
            iUc = re.xr().uc() * 1000;
        } else {
            iUc = 5;
            if (iRe == 5) {
                iUc = re.xr().uc() * 1000;
            } else if (iRe == 3) {
                iUc = re.xr().ny(String.valueOf(this.eg));
            }
        }
        this.f3587ms.removeCallbacks(this.m);
        this.f3587ms.postDelayed(this.m, iUc);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(ah.xr xrVar) {
        this.k = new WeakReference<>(xrVar);
    }

    protected void c(boolean z) {
        if (le() && this.ka != null) {
            this.f3587ms.removeCallbacks(this.m);
            c(0);
            this.ka.xr();
            this.ul = System.currentTimeMillis() - this.f;
            this.ka.ka(true);
            if (f.c(this.c)) {
                this.ka.ms2(this.c, this.ny, true);
            } else {
                this.ka.yu();
            }
            ab(z);
            if (!z) {
                this.vm.set(true);
            }
            ah.ms msVar = this.az;
            if (msVar != null) {
                msVar.ms(this.ul, com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.ab, this.w));
            }
            hi(z);
            this.y = true;
        }
    }

    private void ab(boolean z) {
        if (!this.nw.ms(64) || ah() || d()) {
            this.nw.ah(64);
            if (!of() || this.c == null) {
                long j = this.w;
                xr(j, j);
                long j2 = this.w;
                this.ab = j2;
                this.x = j2;
                az();
                return;
            }
            if (z) {
                az();
                if (this.c.qw() != 8) {
                    this.nw.ms();
                    lm();
                    ms(0L, true);
                    return;
                }
                return;
            }
            long j3 = this.w;
            xr(j3, j3);
            long j4 = this.w;
            this.ab = j4;
            this.x = j4;
        }
    }

    private void hi(boolean z) {
        if (this.lm != null) {
            if (!of() || z) {
                this.lm.ms();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(ah.ms msVar) {
        this.az = msVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void c() {
        if (this.d != null) {
            this.d.ah();
        }
        if (!this.nw.ms(64) || ah() || d()) {
            if (this.nw.ms(2) || com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
                ah((Map<String, Object>) null);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(Map<String, Object> map) {
        if (this.d != null) {
            this.d.ah();
        }
        if (!this.nw.ms(64) || ah() || d()) {
            if (this.nw.ms(2) || com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
                ah(map);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ab() {
        if (this.d != null) {
            this.d.ah();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void x() {
        if (this.ka != null) {
            this.ka.ms();
            this.ka.t();
            this.ka.i();
        }
        sl.ms("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.ch));
        if (this.d != null) {
            if (this.d.u()) {
                if (this.ch || ((this.b != null && this.b.ab()) || com.bytedance.sdk.openadsdk.ka.ms.xr(this.c))) {
                    jw();
                } else {
                    xr(this.i);
                }
                sl.ms("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.ch));
            } else {
                this.d.ms(false, this.ab, this.h);
            }
        }
        if (!this.nw.ms(64) || ah() || d()) {
            if (this.nw.ms(2) || com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
                m();
            }
        }
    }

    public void il() {
        if (!this.nw.ms(64) || ah() || d()) {
            if (this.nw.ms(2) || com.bytedance.sdk.openadsdk.op.ch.ms(this.c)) {
                m();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(long j) {
        this.ab = Math.max(j, h().y());
        this.x = Math.max(this.x, hi());
        if (this.ka != null) {
            this.ka.ms();
        }
        if (this.d != null) {
            this.d.ms(false, this.ab, this.h);
            this.d.ms(this.ab);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ny() {
        if (this.d != null) {
            this.d.ka();
            this.d = null;
        }
        if (this.ka != null) {
            this.ka.ny();
        }
        this.f3587ms.removeCallbacks(this.m);
        this.f3587ms.removeCallbacksAndMessages(null);
        this.az = null;
        this.lm = null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(boolean z, int i) {
        ah(i);
        ny();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ch() {
        ah(-1);
        ny();
    }

    protected boolean u_() {
        return this.c == null || this.c.ld() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (vm() != null && this.d != null && (viewGroup = this.yu) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.yu.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objVm = vm();
                if (objVm instanceof TextureView) {
                    ((TextureView) objVm).setLayoutParams(layoutParams);
                } else if (objVm instanceof UpieVideoView) {
                    ((UpieVideoView) objVm).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            sl.ah("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean qk() throws Throwable {
        return this.ny == null || this.ny.get() == null || vm() == null || this.d == null || this.c == null || this.c.si() != null || this.c.pl() != null || this.c.vm() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i, int i2) {
        try {
            if (this.ny != null && this.ny.get() != null && vm() != null && this.d != null && this.c != null) {
                int[] iArrXr = ul.xr(re.getContext());
                boolean z = this.c.od() == 1;
                float f = iArrXr[0];
                float f2 = iArrXr[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        ms(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        ms(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.yu != null) {
                    Object objVm = vm();
                    if (objVm instanceof TextureView) {
                        ((TextureView) objVm).setLayoutParams(layoutParams);
                    } else if (objVm instanceof UpieVideoView) {
                        ((UpieVideoView) objVm).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            sl.ah("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, int i2) {
        try {
            sl.ms("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.c.rt());
            if (qk()) {
                return;
            }
            sl.ms("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] iArrXr = ul.xr(re.getContext());
            boolean z = false;
            boolean z2 = this.c.od() == 1;
            float f = iArrXr[0];
            float f2 = iArrXr[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    ms(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                ms(f, f2, f3, f4, false);
                return;
            }
            float f5 = f3 / f4;
            float f6 = f / f2;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f3 = (9.0f * f2) / 16.0f;
                    z = true;
                    f4 = f2;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f4 = (9.0f * f) / 16.0f;
                z = true;
                f3 = f;
            }
            sl.ms("changeVideoSize", "适配后宽高：videoHeight=" + f4 + ",videoWidth=" + f3);
            if (z) {
                f = f3;
                f2 = f4;
            } else {
                sl.ms("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f2 + "，videoWidth=" + f);
            }
            int i3 = (int) f;
            int i4 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(13);
            Object objVm = vm();
            if ((objVm instanceof TextureView) || (objVm instanceof UpieVideoView)) {
                if (objVm instanceof TextureView) {
                    ((TextureView) objVm).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objVm).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.yu.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.yu.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            sl.ah("changeVideoSize", "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2) {
        try {
            if (this.ny != null && this.ny.get() != null && vm() != null && this.d != null && this.c != null) {
                boolean z = this.c.od() == 1;
                int[] iArrXr = ul.xr(re.getContext());
                ms(iArrXr[0], iArrXr[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void ms(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = qr.d(this.c);
                f4 = qr.ah(this.c);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            Object objVm = vm();
            if (objVm instanceof TextureView) {
                ((TextureView) objVm).setLayoutParams(layoutParams);
            } else if (objVm instanceof UpieVideoView) {
                ((UpieVideoView) objVm).setLayoutParams(layoutParams);
            }
            this.l = true;
        }
    }

    public boolean qf() {
        return this.l;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.d == null || !le()) {
            return;
        }
        if (this.d.zb()) {
            c();
            this.ka.xr(true, false);
            this.ka.c();
        } else {
            if (!this.d.u()) {
                if (this.ka != null) {
                    this.ka.ah(this.yu);
                }
                ms(this.ab);
                if (this.ka != null) {
                    this.ka.xr(false, false);
                    return;
                }
                return;
            }
            x();
            if (this.ka != null) {
                this.ka.xr(false, false);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i) {
        if (this.d == null) {
            return;
        }
        xr(this.tz, ab(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i) {
        if (this.ka != null) {
            this.ka.c();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i, boolean z) {
        if (le()) {
            long j = this.w;
            long j2 = (long) (((((long) i) * j) * 1.0f) / 100.0f);
            if (j > 0) {
                this.tz = (int) j2;
            } else {
                this.tz = 0L;
            }
            if (this.ka != null) {
                this.ka.ms(this.tz);
            }
        }
    }

    public boolean l() {
        return this.vm.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(long j, long j2) {
        this.ab = j;
        this.w = j2;
        this.ka.ms(j, j2);
        int iMs = com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j, j2);
        if (ah() || d()) {
            this.ka.xr(100);
        } else {
            this.ka.xr(iMs);
        }
        ah(j, j2);
        try {
            ah.ms msVar = this.az;
            if (msVar != null) {
                msVar.ms(j, j2);
            }
            InterfaceC0325ms interfaceC0325ms = this.lm;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms(j, j2);
            }
        } catch (Throwable th) {
            sl.ah("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    private void ah(long j, long j2) {
        if (of()) {
            final int iQw = this.c.qw();
            if (xr(iQw)) {
                long jP = p();
                if (ti() && j >= jP - 200 && this.vm.get() && Math.abs(j - j2) > 200) {
                    this.vm.set(false);
                    this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.6
                        @Override // java.lang.Runnable
                        public void run() {
                            ms.this.c(true);
                            if (iQw == 8) {
                                ms.this.h().d();
                            }
                        }
                    });
                }
            }
        }
        ka(j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        xr(xrVar, view, false, false);
    }

    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view, boolean z, boolean z2) {
        if (le()) {
            ny(!this.t);
            if (this.ny.get() instanceof Activity) {
                if (this.t) {
                    ka(z ? 8 : 0);
                    if (this.ka != null) {
                        this.ka.ms(this.yu);
                        this.ka.ah(false);
                    }
                } else {
                    ka(1);
                    if (this.ka != null) {
                        this.ka.xr(this.yu);
                        this.ka.ah(false);
                    }
                }
                WeakReference<ah.xr> weakReference = this.k;
                ah.xr xrVar2 = weakReference != null ? weakReference.get() : null;
                if (xrVar2 != null) {
                    xrVar2.ms(this.t);
                }
            }
        }
    }

    public void ka(int i) {
        if (le()) {
            boolean z = i == 0 || i == 8;
            Context context = this.ny.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ah(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.ka != null) {
            this.ka.ny();
        }
        ms(1);
        ms(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view, boolean z, boolean z2) {
        if (this.sl) {
            c();
        }
        if (z && !this.sl && !am()) {
            this.ka.xr(!sa(), false);
            this.ka.ms(z2, true, false);
        }
        if (this.d != null && this.d.zb()) {
            this.ka.c();
            this.ka.ka();
        } else {
            this.ka.c();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void d(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.t) {
            ny(false);
            if (this.ka != null) {
                this.ka.xr(this.yu);
            }
            ka(1);
            return;
        }
        ms(1);
        ms(true, 3);
    }

    private com.bykv.vk.openvk.component.video.api.renderview.xr vm() {
        if (this.ny == null || this.ny.get() == null || this.ka == null) {
            return null;
        }
        return this.ka.h();
    }

    public boolean am() {
        return this.d.ny();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms() {
        if (this.ka != null) {
            this.ka.ka();
            this.ka.ms();
        }
        if (this.ka != null) {
            this.ka.i();
        }
        ms(-1L);
    }

    public boolean sa() {
        return this.d != null && this.d.zb();
    }

    private void xr(long j, boolean z) {
        if (this.d == null) {
            return;
        }
        if (z) {
            zf();
        }
        this.d.ms(j);
    }

    private boolean ab(int i) {
        return this.ka.ah(i);
    }

    public boolean tz() {
        boolean zAh = ah();
        if (!zAh || fm() >= 2) {
            return zAh;
        }
        return this.qk >= u() - 400;
    }

    public boolean ti() {
        if (of()) {
            return tz();
        }
        return ah();
    }

    private void zf() {
        if (this.ka != null) {
            this.ka.d(0);
            this.ka.ms(false, false);
            this.ka.ah(false);
            this.ka.ka();
            c(8);
            this.ka.ab();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.xr.ms$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f3674ms;

        static {
            int[] iArr = new int[ub.ms.values().length];
            f3674ms = iArr;
            try {
                iArr[ub.ms.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3674ms[ub.ms.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3674ms[ub.ms.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xr
    public void ms(ub.ms msVar, String str) {
        int i = AnonymousClass9.f3674ms[msVar.ordinal()];
        if (i == 1) {
            c();
            return;
        }
        if (i == 2) {
            ms(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            x();
            this.ub = false;
            this.e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i) {
        int iAh = u.ah(re.getContext());
        if (iAh != 4 && iAh != 0) {
            c();
            this.ub = true;
            this.e = false;
            if (this.ka != null && this.c != null) {
                return this.ka.ms(i, qr.u(this.c), true);
            }
        } else if (iAh == 4) {
            this.ub = false;
            if (this.ka != null) {
                this.ka.t();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Context context, int i) {
        if (le() && this.ti != i) {
            if (!this.e) {
                x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.7
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.x(2);
                    }
                });
            }
            this.ti = i;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
            int iRe = re();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.il;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(zb()));
                jSONObject.putOpt("buffer_time", Long.valueOf(sl()));
            } catch (Exception e) {
                sl.ms(e);
            }
            if (!this.nw.ms(512)) {
                this.nw.ah(512);
                if (iRe == 1) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "rewarded_video", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
                } else if (iRe == 2) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
                if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.c)) {
                    com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.c, jCurrentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.c, jCurrentTimeMillis);
                }
            }
        }
    }

    protected void c(int i) {
        Object obj;
        if (this.ny == null || !com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c) || this.ny.get() == null || (obj = (Context) this.ny.get()) == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.x.xr)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.x.xr) obj).ms(i == 0);
    }

    protected void s() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
            int iRe = re();
            boolean zMs = this.nw.ms(1024);
            long jLongValue = this.nw.xr(1).longValue();
            if (zMs) {
                return;
            }
            this.nw.ah(1024);
            if (iRe == 1) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "rewarded_video", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            } else if (iRe == 2) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
            int iRe = re();
            if (iRe == 1) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "rewarded_video", i, str, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            } else if (iRe == 2) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "fullscreen_interstitial_ad", i, str, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            }
        }
    }

    public void v() {
        this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xr.ms.8
            @Override // java.lang.Runnable
            public void run() {
                if (!t.d(ms.this.c) && ms.this.u_()) {
                    if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(ms.this.c) && ms.this.c.od() == 2 && ms.this.u_()) {
                        return;
                    }
                    if (ms.this.u_()) {
                        if (ms.this.c == null || ms.this.c.v() != 0) {
                            if (ms.this.c != null && ms.this.c.v() == 2) {
                                ms msVar = ms.this;
                                msVar.xr(msVar.am, ms.this.sa);
                                return;
                            } else {
                                ms msVar2 = ms.this;
                                msVar2.ah(msVar2.am, ms.this.sa);
                                return;
                            }
                        }
                        ms msVar3 = ms.this;
                        msVar3.d(msVar3.am, ms.this.sa);
                        return;
                    }
                    ms msVar4 = ms.this;
                    msVar4.ms(msVar4.am, ms.this.sa);
                    return;
                }
                ms msVar5 = ms.this;
                msVar5.ms(msVar5.am, ms.this.sa);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public int zb() {
        if (this.d == null) {
            return 0;
        }
        return this.d.h();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        this.b = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms
    protected Map<String, Object> e() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.g;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : f.ms(this.op, this.c, h()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    public void ms(InterfaceC0325ms interfaceC0325ms) {
        this.lm = interfaceC0325ms;
    }
}
