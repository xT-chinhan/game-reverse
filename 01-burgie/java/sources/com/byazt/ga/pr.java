package com.byazt.ga;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.fi.BaseConstants;
import com.byazt.gz.uc;
import com.byazt.hg.ie;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.ihe.c;
import com.byazt.ihe.fw;
import com.byazt.jf.LayoutVideoPlayLayoutForLive;
import com.byazt.p.x;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.te.UpieVideoView;
import com.byazt.w.hn;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.LiveMetrics;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, 37})
public abstract class pr extends com.byazt.vr.pr {
    public int bm;
    public int gu;
    public WeakReference<hn.hw> i;
    public long ie;
    public long iu;
    public int jn;
    public int l;
    public com.byazt.az.pr n;
    public final String o;
    public InterfaceC0074pr of;
    public hn.pr qi;
    public final int r;
    public long sv;
    public ViewGroup ve;
    public long gz = 0;
    public boolean nl = false;
    public boolean y = false;
    public Map<String, Object> ww = null;
    public final AtomicInteger s = new AtomicInteger(0);
    public final AtomicInteger ls = new AtomicInteger(0);
    public long er = 0;
    public long v = 0;
    public final Runnable qn = new Runnable() { // from class: com.byazt.ga.pr.1
        @Override // java.lang.Runnable
        public void run() {
            if (pr.this.qi != null) {
                pr.this.qi.pr();
            }
            if (pr.this.of != null) {
                pr.this.of.hw();
            }
        }
    };
    public boolean ii = false;
    public boolean hs = false;
    public boolean nw = true;
    public boolean f = false;
    public boolean lv = false;
    public boolean od = false;
    public boolean vj = false;
    public boolean mw = false;
    public fw.pr e = new fw.pr() { // from class: com.byazt.ga.pr.2
        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar) {
            com.byazt.qd.hn.uc(pr.this.l());
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.uc(false);
                }
            });
            pr.this.pr(4);
            pr.this.hw(4);
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, long j) {
            if (!pr.this.lv) {
                pr.this.lv = true;
                com.byazt.qd.hn.hw(pr.this.l(), 1);
            }
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.c != null) {
                        pr.this.c(0);
                        pr.this.c.hw();
                        pr.this.pr.removeCallbacks(pr.this.qn);
                        pr.this.hs = false;
                    }
                }
            });
            pr.this.pr(j, false);
            pr.this.ie = System.currentTimeMillis();
            pr.this.hs();
            if (pr.this.of != null) {
                pr.this.of.hn();
            }
        }

        @Override // com.byazt.ihe.fw.pr
        public void hn(fw fwVar) {
            if (!pr.this.od) {
                pr.this.od = true;
                com.byazt.qd.hn.hn(pr.this.l());
            }
            if (com.byazt.lpk.pr.pr(pr.this.uc)) {
                pr.this.uc.hn(fwVar.b());
            }
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.3
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.pr.removeCallbacks(pr.this.qn);
                    if (pr.this.c != null) {
                        pr.this.c(0);
                        pr.this.c.hw();
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(final fw fwVar, final com.byazt.ihe.hn hnVar) {
            if (hnVar != null) {
                com.byazt.qd.hn.hn(pr.this.l(), 1);
                hnVar.pr();
                hnVar.hn();
                pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        fw fwVar2;
                        fw fwVar3;
                        int iAj;
                        int iPr = hnVar.pr();
                        if (iPr != 308 || (fwVar2 = pr.this.x) == null || fwVar2 == (fwVar3 = fwVar) || !(fwVar3 instanceof x) || ((iAj = ((x) fwVar3).aj()) != 200 && iAj != 203)) {
                            pr.this.pr(iPr, hnVar.hw(), hnVar.hn(), (JSONArray) null);
                            pr.this.pr.removeCallbacks(pr.this.qn);
                            if (pr.this.c != null) {
                                pr.this.c(0);
                                pr.this.c.hw();
                            }
                            if (pr.this.qi != null) {
                                pr.this.qi.hw(pr.this.v, com.byazt.t.pr.pr(pr.this.fw, pr.this.iu));
                            }
                            if (pr.this.of != null) {
                                pr.this.of.pr(iPr, hnVar.hn());
                                return;
                            }
                            return;
                        }
                        ho.hw("BaseVideoController", "ignore errorCode:" + iPr + " state:" + iAj);
                    }
                });
                pr.this.pr(hnVar.pr(), hnVar.hn());
            }
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, boolean z) {
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.5
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.pr.removeCallbacks(pr.this.qn);
                    if (pr.this.c != null) {
                        pr.this.c(0);
                        pr.this.c.hw();
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void x(fw fwVar) {
            com.byazt.qd.hn.hn(pr.this.l(), 2);
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, int i, int i2) {
            pr.this.bm = i;
            pr.this.jn = i2;
            pr.this.nw();
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, int i, int i2, int i3) {
            com.byazt.qd.hn.x(pr.this.l());
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.c != null) {
                        pr.this.c(8);
                        pr.this.c.fo();
                        pr.this.qn();
                        pr.this.hs = true;
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, int i) {
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.c != null) {
                        pr.this.c(0);
                        pr.this.c.hw();
                        pr.this.pr.removeCallbacks(pr.this.qn);
                        pr.this.hs = false;
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void hw(fw fwVar, int i) {
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(final fw fwVar, final long j, final long j2) {
            if (pr.this.vj && pr.this.mw) {
                pr.this.vj = false;
                pr.this.mw = false;
                com.byazt.qd.hn.hw(pr.this.l(), 2);
            }
            if (Math.abs(j - pr.this.fw) < 50) {
                return;
            }
            Object[] objArr = {"IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j), "; duration=", Long.valueOf(j2)};
            pr.this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.fo != null) {
                        pr.this.fo.pr(j, j2);
                    }
                    pr.this.hw(j, j2);
                    pr.this.pr(j, j2);
                    if (pr.this.uc.io() > 0 && j2 > ((long) pr.this.uc.io()) * 1000 && j >= ((long) pr.this.uc.io()) * 1000 && !pr.this.g) {
                        pr.this.g = true;
                        fwVar.fw();
                        pr.this.uc(false);
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(fw fwVar, JSONObject jSONObject, String str) {
            if (zo.nt().of()) {
                jSONObject.optString(TrackAction.START);
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong(TrackAction.START);
            }
            com.byazt.pj.pr.pr((Context) pr.this.aj.get(), pr.this.uc, pr.this.o, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.ihe.fw.pr
        public void c(fw fwVar) {
            pr.this.vj = true;
            com.byazt.qd.hn.c(pr.this.l());
        }

        @Override // com.byazt.ihe.fw.pr
        public void uc(fw fwVar) {
            pr.this.mw = true;
        }

        @Override // com.byazt.ihe.fw.pr
        public void hw(fw fwVar) {
        }
    };
    public final com.byazt.apo.hn d = new com.byazt.apo.hn() { // from class: com.byazt.ga.pr.3
        @Override // com.byazt.apo.hn
        public void pr(Context context, Intent intent, boolean z, int i) {
            pr.this.pr(context, i);
        }
    };
    public boolean pq = false;

    /* JADX INFO: renamed from: com.byazt.ga.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0074pr {
        void hn();

        void hw();

        void pr();

        void pr(int i, String str);

        void pr(long j, long j2);
    }

    public abstract int fo();

    public pr(Context context, ViewGroup viewGroup, of ofVar, com.byazt.az.pr prVar) {
        this.gu = 1;
        this.gu = yb.hn(context);
        this.ve = viewGroup;
        this.aj = new WeakReference<>(context);
        this.uc = ofVar;
        this.n = prVar;
        pr(context);
        this.r = ls.m(this.uc);
        this.o = ls.hw(this.uc);
    }

    private void pr(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(com.byazt.w.hw.pr.class);
        enumSetNoneOf.add(com.byazt.w.hw.pr.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.w.hw.pr.hideBackBtn);
        this.c = new uc(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.uc, this, this.n);
        this.c.pr((com.byazt.w.pr) this);
    }

    public void pr(long j, boolean z) {
        if (!this.cz.pr(2)) {
            this.gz = j;
            vk(z);
            this.y = true;
        }
    }

    @Override // com.byazt.w.hn
    public boolean pr(com.byazt.n.uc ucVar) {
        if (ucVar == null) {
            hw("model is null");
            return false;
        }
        if (this.x != null && this.x.k()) {
            this.x.hn();
            return true;
        }
        this.ny = ucVar;
        ucVar.ny();
        if (TextUtils.isEmpty(ucVar.ny())) {
            ho.hw("BaseVideoController", "No video info");
            hw("url is null");
            return false;
        }
        this.nl = (ucVar.ny().startsWith("http") || com.byazt.lpk.pr.pr(this.uc)) ? false : true;
        this.yb = ucVar.ho();
        if (ucVar.g() > 0) {
            this.fw = ucVar.g();
            this.zo = this.zo > this.fw ? this.zo : this.fw;
        }
        if (this.c != null) {
            this.c.pr();
            c(8);
            this.c.fw();
            this.c.hn(ucVar.vk(), ucVar.w());
            this.c.hn(this.ve);
        }
        try {
            if (this.x == null) {
                if (!rc()) {
                    hw("create video error");
                    return false;
                }
                this.x.pr(this.e);
            }
            b();
            this.v = 0L;
            hn(ucVar);
            return true;
        } catch (Throwable th) {
            hw(th.getMessage());
            ho.hw("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    private boolean rc() {
        int i;
        fw xVar;
        of ofVar = this.uc;
        if (com.byazt.ja.pr.hw(ofVar)) {
            com.byazt.c.hw hwVarBm = bm();
            if (hwVarBm != null) {
                int iK = ls.k(this.uc);
                this.z = pr(an.aw);
                this.x = new com.byazt.te.pr(hwVarBm, com.byazt.ja.pr.vk(ofVar), new x(String.valueOf(iK), this.z), qv.lb(ofVar), pr("assist"));
                i = 1;
            } else {
                if (this.e != null) {
                    this.e.pr((fw) null, new com.byazt.n.hn(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.c == null)));
                }
                ho.hw("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.byazt.ja.pr.hn(ofVar)) {
            i = 2;
            com.byazt.c.hw hwVarBm2 = bm();
            if (hwVarBm2 != null) {
                int iK2 = ls.k(this.uc);
                if (!iu.x() || this.ny.rc() != 1) {
                    this.z = pr(an.aw);
                    xVar = new x(String.valueOf(iK2), this.z);
                } else {
                    xVar = com.byazt.it.hw.pr().pr(a.getContext(), String.valueOf(iK2));
                }
                this.x = new com.byazt.te.hw(xVar, com.byazt.ja.pr.vk(ofVar), pr("assist"), hwVarBm2);
            } else {
                if (this.e != null) {
                    this.e.pr((fw) null, new com.byazt.n.hn(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.c == null)));
                }
                ho.hw("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iK3 = ls.k(this.uc);
            if (com.byazt.lpk.pr.pr(this.uc)) {
                i = 3;
                this.x = com.byazt.it.hw.pr().pr(a.getContext(), iu(), (long) qv.fw(this.uc), a.hw().ks(), null);
            } else if (!iu.x() || this.ny.rc() != 1) {
                this.z = pr(an.aw);
                this.x = new x(String.valueOf(iK3), this.z);
                i = 5;
            } else {
                this.x = com.byazt.it.hw.pr().pr(a.getContext(), String.valueOf(iK3));
                i = 4;
            }
        }
        if (ofVar != null) {
            com.byazt.qd.hn.pr(ofVar, String.valueOf(ls.m(this.uc)), ls.k(this.uc), i, this.uc.z());
        }
        return true;
    }

    @Override // com.byazt.w.hn
    public boolean cz() {
        return false;
    }

    @Override // com.byazt.w.hn
    public void x(boolean z) {
    }

    public void v() {
        if (this.uc != null) {
            com.byazt.pj.pr.pr(this.uc, ls.hw(this.uc), "auto_replay", new com.byazt.ttf.pr() { // from class: com.byazt.ga.pr.4
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    c cVarWw;
                    JSONObject jSONObject2 = new JSONObject();
                    if (k.pr(pr.this.uc)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (pr.this.ny != null && (cVarWw = pr.this.ny.ww()) != null && cVarWw.fw() > 0.0d) {
                        jSONObject2.put(TrackAction.START, cVarWw.fw());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    @Override // com.byazt.w.hn
    public void hw() {
        if (this.x != null) {
            if (!c()) {
                this.s.getAndAdd(1);
                v();
            }
            this.ls.getAndAdd(1);
            this.cz.pr();
            ls();
            pr(0L, true);
            hn(false);
            this.l = 2;
            this.lv = false;
            this.x.hw();
        }
    }

    public int qi() {
        if (k.pr(this.uc)) {
            return this.ls.get();
        }
        return this.s.get();
    }

    @Override // com.byazt.w.hn
    public boolean hn() {
        return this.s.get() > 0;
    }

    @Override // com.byazt.vr.pr, com.byazt.w.hn
    public boolean x() {
        if (k.pr(this.uc)) {
            return ((double) this.ls.get()) <= ((double) qv.yb(this.uc).fw());
        }
        return super.x();
    }

    @Override // com.byazt.vr.pr, com.byazt.w.hn
    public boolean c() {
        if (k.pr(this.uc)) {
            return ((double) this.ls.get()) < ((double) qv.yb(this.uc).fw());
        }
        return super.x();
    }

    @Override // com.byazt.w.hn
    public boolean ny() {
        return this.hs;
    }

    @Override // com.byazt.w.hn
    public void c(boolean z) {
        this.nw = z;
    }

    @Override // com.byazt.w.hn
    public int ho() {
        return com.byazt.t.pr.pr(this.zo, this.iu);
    }

    @Override // com.byazt.w.hn
    public void hw(Map<String, Object> map) {
        this.ww = map;
    }

    private void hn(com.byazt.n.uc ucVar) throws Exception {
        if (ucVar == null) {
            hw("model is null");
            return;
        }
        this.ny = ucVar;
        if (this.x != null) {
            if (this.uc != null) {
                ucVar.x(String.valueOf(ls.m(this.uc)));
            }
            ucVar.x(1);
            com.byazt.qd.hn.hw(l());
            this.x.pr(ucVar);
        }
        this.er = System.currentTimeMillis();
        if (!TextUtils.isEmpty(ucVar.ny())) {
            this.c.c(8);
            this.c.c(0);
            pr(new Runnable() { // from class: com.byazt.ga.pr.5
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.x == null) {
                        pr.this.hw("play video error proxy empty");
                        return;
                    }
                    if (pr.this.cz.x(1)) {
                        pr.this.hw("multi play_start");
                        return;
                    }
                    pr.this.cz.pr();
                    pr.this.ls();
                    pr.this.er = System.currentTimeMillis();
                    pr.this.c.x(0);
                    pr.this.l = 1;
                    pr.this.lv = false;
                    pr.this.od = false;
                    com.byazt.qd.hn.pr(pr.this.l(), pr.this.l);
                    pr.this.x.pr(true, pr.this.fw, pr.this.yb);
                }
            });
            return;
        }
        hw("url is null");
    }

    public void qn() {
        int iFo = fo();
        int iMb = 5;
        if (iFo == 2 || iFo == 1 || iFo == 5) {
            iMb = a.hw().mb() * 1000;
        } else if (iFo == 3) {
            iMb = a.hw().zo(String.valueOf(this.r));
        }
        this.pr.removeCallbacks(this.qn);
        this.pr.postDelayed(this.qn, iMb);
    }

    @Override // com.byazt.w.hn
    public void pr(hn.hw hwVar) {
        this.i = new WeakReference<>(hwVar);
    }

    public void uc(boolean z) {
        if (!ve() || this.c == null) {
            return;
        }
        this.pr.removeCallbacks(this.qn);
        c(0);
        this.c.hw();
        this.v = System.currentTimeMillis() - this.er;
        this.c.c(true);
        if (ls.aj(this.uc)) {
            this.c.pr(this.uc, this.aj, true);
        } else {
            this.c.b();
        }
        ie();
        hn.pr prVar = this.qi;
        if (prVar != null) {
            prVar.pr(this.v, com.byazt.t.pr.pr(this.fw, this.iu));
        }
        o();
        this.qa = true;
    }

    private void ie() {
        if (!this.cz.pr(64) || hn() || x()) {
            this.cz.hn(64);
            long j = this.iu;
            hw(j, j);
            long j2 = this.iu;
            this.fw = j2;
            this.zo = j2;
            e();
        }
    }

    private void o() {
        InterfaceC0074pr interfaceC0074pr = this.of;
        if (interfaceC0074pr != null) {
            interfaceC0074pr.pr();
        }
    }

    @Override // com.byazt.w.hn
    public void pr(hn.pr prVar) {
        this.qi = prVar;
    }

    @Override // com.byazt.w.hn
    public void pr(hn.x xVar) {
    }

    @Override // com.byazt.w.hn
    public void uc() {
        if (this.x != null) {
            this.x.x();
        }
        if (!this.cz.pr(64) || hn() || x()) {
            if (this.cz.pr(2) || k.pr(this.uc)) {
                hn((Map<String, Object>) null);
            }
        }
    }

    @Override // com.byazt.w.hn
    public void pr(Map<String, Object> map) {
        if (this.x != null) {
            this.x.x();
        }
        if (!this.cz.pr(64) || hn() || x()) {
            if (this.cz.pr(2) || k.pr(this.uc)) {
                hn(map);
            }
        }
    }

    @Override // com.byazt.w.hn
    public void fw() {
        if (this.x != null) {
            this.x.x();
        }
    }

    @Override // com.byazt.w.hn
    public void zo() {
        if (this.c != null) {
            this.c.pr();
            this.c.a();
            this.c.rc();
        }
        Object[] objArr = {"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.vk)};
        if (this.x != null) {
            if (this.x.k()) {
                if (this.vk || ((this.ny != null && this.ny.zo()) || com.byazt.ja.pr.hw(this.uc))) {
                    y();
                } else {
                    hw(this.b);
                }
                Object[] objArr2 = {"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.vk)};
            } else {
                this.l = 1;
                this.lv = false;
                this.x.pr(false, this.fw, this.yb);
            }
        }
        if (!this.cz.pr(64) || hn() || x()) {
            if (this.cz.pr(2) || k.pr(this.uc)) {
                s();
            }
        }
    }

    public void of() {
        if (!this.cz.pr(64) || hn() || x()) {
            if (this.cz.pr(2) || k.pr(this.uc)) {
                s();
            }
        }
    }

    @Override // com.byazt.w.hn
    public void pr(long j) {
        this.fw = Math.max(j, yb().cz());
        this.zo = Math.max(this.zo, w());
        if (this.c != null) {
            this.c.pr();
        }
        if (this.x != null) {
            this.l = 1;
            this.lv = false;
            this.x.pr(false, this.fw, this.yb);
            this.x.pr(this.fw);
        }
    }

    @Override // com.byazt.w.hn
    public void aj() {
        if (this.x != null) {
            this.x.uc();
            this.x = null;
        }
        if (this.c != null) {
            this.c.aj();
        }
        this.pr.removeCallbacks(this.qn);
        this.pr.removeCallbacksAndMessages(null);
        this.qi = null;
        this.of = null;
    }

    @Override // com.byazt.w.hn
    public void pr(boolean z, int i) {
        hw(i);
        aj();
    }

    @Override // com.byazt.w.hn
    public void vk() {
        hw(-1);
        aj();
    }

    public boolean t_() {
        return this.uc == null || this.uc.oq() == 100.0f;
    }

    @Override // com.byazt.vr.pr
    public boolean iu() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (bm() != null && this.x != null && (viewGroup = this.ve) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.ve.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objBm = bm();
                if (objBm instanceof TextureView) {
                    ((TextureView) objBm).setLayoutParams(layoutParams);
                } else if (objBm instanceof UpieVideoView) {
                    ((UpieVideoView) objBm).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            ho.pr("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean f() throws Throwable {
        return this.aj == null || this.aj.get() == null || bm() == null || this.x == null || this.uc == null || ie.fw(this.uc) != null || ie.zo(this.uc) != null || this.uc.xb() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i, int i2) {
        try {
            if (this.aj != null && this.aj.get() != null && bm() != null && this.x != null && this.uc != null) {
                int[] iArrHn = er.hn(a.getContext());
                boolean z = this.uc.rf() == 1;
                float f = iArrHn[0];
                float f2 = iArrHn[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        pr(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        pr(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.ve != null) {
                    Object objBm = bm();
                    if (objBm instanceof TextureView) {
                        ((TextureView) objBm).setLayoutParams(layoutParams);
                    } else if (objBm instanceof UpieVideoView) {
                        ((UpieVideoView) objBm).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            ho.pr("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(int i, int i2) {
        try {
            if (f()) {
                return;
            }
            int[] iArrHn = er.hn(a.getContext());
            boolean z = false;
            boolean z2 = this.uc.rf() == 1;
            float f = iArrHn[0];
            float f2 = iArrHn[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    pr(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                pr(f, f2, f3, f4, false);
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
            if (z) {
                f = f3;
                f2 = f4;
            }
            int i3 = (int) f;
            int i4 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(13);
            Object objBm = bm();
            if ((objBm instanceof TextureView) || (objBm instanceof UpieVideoView)) {
                if (objBm instanceof TextureView) {
                    ((TextureView) objBm).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objBm).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.ve.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.ve.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            ho.pr("changeVideoSize", "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        try {
            if (this.aj != null && this.aj.get() != null && bm() != null && this.x != null && this.uc != null) {
                boolean z = this.uc.rf() == 1;
                int[] iArrHn = er.hn(a.getContext());
                pr(iArrHn[0], iArrHn[1], i, i2, z);
            }
        } catch (Throwable th) {
        }
    }

    private void pr(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = qv.x(this.uc);
                f4 = qv.hn(this.uc);
            } catch (Throwable th) {
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
            Object objBm = bm();
            if (objBm instanceof TextureView) {
                ((TextureView) objBm).setLayoutParams(layoutParams);
            } else if (objBm instanceof UpieVideoView) {
                ((UpieVideoView) objBm).setLayoutParams(layoutParams);
            }
            this.f = true;
        }
    }

    public boolean ii() {
        return this.f;
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, View view) {
        if (this.x == null || !ve()) {
            return;
        }
        if (this.x.vk()) {
            uc();
            this.c.hw(true, false);
            this.c.uc();
        } else {
            if (!this.x.k()) {
                if (this.c != null) {
                    this.c.hn(this.ve);
                }
                pr(this.fw);
                if (this.c != null) {
                    this.c.hw(false, false);
                    return;
                }
                return;
            }
            zo();
            if (this.c != null) {
                this.c.hw(false, false);
            }
        }
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, int i) {
        if (this.x == null) {
            return;
        }
        hw(this.sv, uc(i));
    }

    @Override // com.byazt.w.pr
    public void hw(com.byazt.w.hw hwVar, int i) {
        if (this.c != null) {
            this.c.uc();
        }
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, int i, boolean z) {
        if (!ve()) {
            return;
        }
        long j = this.iu;
        long j2 = (long) (((((long) i) * j) * 1.0f) / 100.0f);
        if (j > 0) {
            this.sv = (int) j2;
        } else {
            this.sv = 0L;
        }
        if (this.c != null) {
            this.c.pr(this.sv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j, long j2) {
        this.fw = j;
        this.iu = j2;
        this.c.pr(j, j2);
        int iPr = com.byazt.t.pr.pr(j, j2);
        if (hn() || x()) {
            this.c.hw(100);
        } else {
            this.c.hw(iPr);
        }
        try {
            hn.pr prVar = this.qi;
            if (prVar != null) {
                prVar.pr(j, j2);
            }
            InterfaceC0074pr interfaceC0074pr = this.of;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr(j, j2);
            }
        } catch (Throwable th) {
            ho.pr("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.w.pr
    public void hw(com.byazt.w.hw hwVar, View view) {
        hw(hwVar, view, false, false);
    }

    public void hw(com.byazt.w.hw hwVar, View view, boolean z, boolean z2) {
        if (!ve()) {
            return;
        }
        aj(!this.a);
        if (!(this.aj.get() instanceof Activity)) {
            return;
        }
        if (this.a) {
            x(z ? 8 : 0);
            if (this.c != null) {
                this.c.pr(this.ve);
                this.c.hn(false);
            }
        } else {
            x(1);
            if (this.c != null) {
                this.c.hw(this.ve);
                this.c.hn(false);
            }
        }
        WeakReference<hn.hw> weakReference = this.i;
        hn.hw hwVar2 = weakReference != null ? weakReference.get() : null;
        if (hwVar2 != null) {
            hwVar2.pr(this.a);
        }
    }

    public void x(int i) {
        if (!ve()) {
            return;
        }
        boolean z = i == 0 || i == 8;
        Context context = this.aj.get();
        if (!(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
        }
        if (!z) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    @Override // com.byazt.w.pr
    public void hn(com.byazt.w.hw hwVar, View view) {
        if (this.c != null) {
            this.c.aj();
        }
        pr(1);
        pr(true, 3);
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, View view, boolean z, boolean z2) {
        if (this.k) {
            uc();
        }
        if (z && !this.k && !i()) {
            this.c.hw(!r(), false);
            this.c.pr(z2, true, false);
        }
        if (this.x != null && this.x.vk()) {
            this.c.uc();
            this.c.c();
        } else {
            this.c.uc();
        }
    }

    @Override // com.byazt.w.pr
    public void x(com.byazt.w.hw hwVar, View view) {
        if (this.a) {
            aj(false);
            if (this.c != null) {
                this.c.hw(this.ve);
            }
            x(1);
            return;
        }
        pr(1);
        pr(true, 3);
    }

    @Override // com.byazt.w.pr
    public void c(com.byazt.w.hw hwVar, View view) {
    }

    private com.byazt.c.hw bm() {
        if (this.aj != null && this.aj.get() != null && this.c != null) {
            return this.c.yb();
        }
        return null;
    }

    public boolean i() {
        return this.x.ho();
    }

    @Override // com.byazt.w.pr
    public void pr() {
        if (this.c != null) {
            this.c.c();
            this.c.pr();
        }
        if (this.c != null) {
            this.c.rc();
        }
        pr(-1L);
    }

    public boolean r() {
        return this.x != null && this.x.vk();
    }

    private void hw(long j, boolean z) {
        if (this.x == null) {
            return;
        }
        if (z) {
            jn();
        }
        this.x.pr(j);
    }

    private boolean uc(int i) {
        return this.c.hn(i);
    }

    private void jn() {
        if (this.c != null) {
            this.c.x(0);
            this.c.pr(false, false);
            this.c.hn(false);
            this.c.c();
            c(8);
            this.c.fw();
        }
    }

    /* JADX INFO: renamed from: com.byazt.ga.pr$8, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200})
    static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.nc.ho.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.nc.ho.pr.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.nc.ho.pr.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.nc.ho.pr.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.byazt.gz.hw
    public void pr(com.byazt.nc.ho.pr prVar, String str) {
        switch (AnonymousClass8.pr[prVar.ordinal()]) {
            case 1:
                uc();
                break;
            case 2:
                pr(true, 3);
                break;
            case 3:
                zo();
                this.ho = false;
                this.ii = true;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fw(int i) {
        int iHn = yb.hn(a.getContext());
        if (iHn != 4 && iHn != 0) {
            uc();
            this.ho = true;
            this.ii = false;
            if (this.c != null && this.uc != null) {
                return this.c.pr(i, qv.ho(this.uc), true);
            }
        } else if (iHn == 4) {
            this.ho = false;
            if (this.c != null) {
                this.c.a();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Context context, int i) {
        if (!ve() || this.gu == i) {
            return;
        }
        if (!this.ii) {
            aj.hw().post(new Runnable() { // from class: com.byazt.ga.pr.6
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.fw(2);
                }
            });
        }
        this.gu = i;
    }

    @Override // com.byazt.w.hn
    public void pr(int i) {
        if (!com.byazt.lpk.pr.pr(this.uc)) {
            return;
        }
        int iFo = fo();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.ie;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("close_reason", Integer.valueOf(i));
            jSONObject.putOpt("buffer_count", Integer.valueOf(m()));
            jSONObject.putOpt("buffer_time", Long.valueOf(k()));
        } catch (Exception e) {
        }
        if (!this.cz.pr(512)) {
            this.cz.hn(512);
            if (iFo == 1) {
                com.byazt.pj.pr.pr(this.uc, "rewarded_video", jCurrentTimeMillis, jSONObject, com.byazt.ne.hn.pr(this.c));
            } else if (iFo == 2) {
                com.byazt.pj.pr.pr(this.uc, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.byazt.ne.hn.pr(this.c));
            }
        }
        if (com.byazt.lpk.pr.pr(this.uc)) {
            if (com.byazt.eg.hw.pr().pr(this.uc)) {
                com.byazt.eg.hw.pr().pr(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.uc, jCurrentTimeMillis);
            } else {
                com.byazt.lpk.pr.pr(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.uc, jCurrentTimeMillis);
            }
        }
    }

    public void c(int i) {
        Object obj;
        if (this.aj != null && com.byazt.lpk.pr.pr(this.uc) && this.aj.get() != null && (obj = (Context) this.aj.get()) != null && (obj instanceof com.byazt.hb.hw)) {
            ((com.byazt.hb.hw) obj).pr(i == 0);
        }
    }

    public void hs() {
        if (!com.byazt.lpk.pr.pr(this.uc)) {
            return;
        }
        int iFo = fo();
        boolean zPr = this.cz.pr(1024);
        long jLongValue = this.cz.hw(1).longValue();
        if (!zPr) {
            this.cz.hn(1024);
            if (iFo == 1) {
                com.byazt.pj.pr.pr(this.uc, "rewarded_video", System.currentTimeMillis() - jLongValue, com.byazt.ne.hn.pr(this.c));
            } else if (iFo == 2) {
                com.byazt.pj.pr.pr(this.uc, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.byazt.ne.hn.pr(this.c));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        if (!com.byazt.lpk.pr.pr(this.uc)) {
            return;
        }
        int iFo = fo();
        if (iFo == 1) {
            com.byazt.pj.pr.pr(this.uc, "rewarded_video", i, str, com.byazt.ne.hn.pr(this.c));
        } else if (iFo == 2) {
            com.byazt.pj.pr.pr(this.uc, "fullscreen_interstitial_ad", i, str, com.byazt.ne.hn.pr(this.c));
        }
    }

    public void nw() {
        this.pr.post(new Runnable() { // from class: com.byazt.ga.pr.7
            @Override // java.lang.Runnable
            public void run() {
                if (!lb.x(pr.this.uc) && pr.this.t_()) {
                    if (com.byazt.lpk.pr.pr(pr.this.uc) && pr.this.uc.rf() == 2 && pr.this.t_()) {
                        return;
                    }
                    if (pr.this.t_()) {
                        if (pr.this.uc == null || pr.this.uc.sr() != 0) {
                            if (pr.this.uc != null && pr.this.uc.sr() == 2) {
                                pr prVar = pr.this;
                                prVar.hw(prVar.bm, pr.this.jn);
                                return;
                            } else {
                                pr prVar2 = pr.this;
                                prVar2.hn(prVar2.bm, pr.this.jn);
                                return;
                            }
                        }
                        pr prVar3 = pr.this;
                        prVar3.x(prVar3.bm, pr.this.jn);
                        return;
                    }
                    pr prVar4 = pr.this;
                    prVar4.pr(prVar4.bm, pr.this.jn);
                    return;
                }
                pr prVar5 = pr.this;
                prVar5.pr(prVar5.bm, pr.this.jn);
            }
        });
    }

    @Override // com.byazt.w.hn
    public int m() {
        if (this.x == null) {
            return 0;
        }
        return this.x.qa();
    }

    @Override // com.byazt.w.hn
    public void hw(com.byazt.n.uc ucVar) {
        this.ny = ucVar;
    }

    @Override // com.byazt.vr.pr
    public Map<String, Object> er() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.ww;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : ls.pr(this.gz, this.uc, yb()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    public void pr(InterfaceC0074pr interfaceC0074pr) {
        this.of = interfaceC0074pr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        if (this.uc == null) {
            return null;
        }
        return this.uc.z();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hn.hn(l(), 3);
    }
}
