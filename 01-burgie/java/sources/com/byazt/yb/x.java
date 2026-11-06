package com.byazt.yb;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.bs.LazeLayout;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.eg.EcMallWebView;
import com.byazt.gz.NativeDrawVideoTsView;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.mr.m;
import com.byazt.n.uc;
import com.byazt.sd.a;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.k;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.uc.crashsdk.export.LogType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 121})
public class x extends com.byazt.xn.hw implements com.byazt.iw.pr, com.byazt.w.hn.InterfaceC0220hn, com.byazt.w.hn.x, com.byazt.mm.pr.InterfaceC0136pr, LazeLayout.pr<NativeVideoTsView>, com.byazt.bs.pr<NativeVideoTsView> {
    public boolean aj;
    public com.byazt.rt.pr c;
    public int fw;
    public volatile int g;
    public int hn;
    public volatile boolean ho;
    public com.byazt.qe.hw hw;
    public WeakReference<View> k;
    public com.byazt.ti.pr lb;
    public com.byazt.rt.hw m;
    public of nt;
    public com.byazt.mm.pr pr;
    public com.byazt.fq.hn uc;
    public LazeLayout vk;
    public volatile WeakReference<NativeVideoTsView> w;
    public int[] x;
    public CreativeContainer yb;
    public com.byazt.pu.pr zo;

    public x(Context context, of ofVar, int i, com.byazt.qe.hw hwVar) {
        super(new com.byazt.fq.hn(context, ofVar, i, hwVar, true));
        this.x = null;
        this.aj = false;
        this.vk = null;
        this.w = null;
        this.k = null;
        this.lb = new com.byazt.ti.pr(null) { // from class: com.byazt.yb.x.4
            @Override // com.byazt.ti.pr
            public void pr(View view, m mVar) {
                if (x.this.w != null && x.this.w.get() != null) {
                    ((NativeVideoTsView) x.this.w.get()).w();
                }
            }

            @Override // com.byazt.ti.pr
            public void hw(View view, m mVar) {
                if (x.this.w != null && x.this.w.get() != null) {
                    ((NativeVideoTsView) x.this.w.get()).w();
                }
            }

            @Override // com.byazt.ti.pr
            public void pr(m mVar) {
            }
        };
        com.byazt.fq.hn hnVar = (com.byazt.fq.hn) fo();
        this.uc = hnVar;
        hnVar.b().pr(this);
        this.hn = i;
        this.hw = hwVar;
        this.pr = new com.byazt.mm.pr();
        this.nt = ofVar;
        int iM = ls.m(ofVar);
        this.fw = iM;
        pr(iM);
        this.uc.pr(this.lb);
        if (context != null && CreativeContainer.hw(ofVar)) {
            this.yb = new CreativeContainer(context, ofVar, this.uc.uc());
        }
    }

    public NativeVideoTsView uc() {
        if (this.w != null) {
            return this.w.get();
        }
        return null;
    }

    public int fw() {
        return this.hn;
    }

    public int zo() {
        return this.fw;
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public boolean l_() {
        return this.aj;
    }

    public NativeVideoTsView pr(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.uc.getContext(), this.uc.iu());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.uc.getContext(), this.uc.iu(), false, false, ls.hw(this.hn), false, false);
        }
        this.w = new WeakReference<>(nativeVideoTsView);
        this.uc.pr(this.w);
        this.uc.fw();
        return nativeVideoTsView;
    }

    private View b() {
        View view;
        WeakReference<View> weakReference = this.k;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.uc.getContext(), this.uc.iu(), this.hn == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(e.pr(this.nt));
        this.k = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    @Override // com.byazt.xn.hw, com.byazt.mr.m
    public View pr() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewHw = null;
        if (this.uc.iu() == null || this.uc.getContext() == null) {
            return null;
        }
        com.byazt.ua.hw.pr(this.uc.iu().pr());
        if (of.hw(this.uc.iu())) {
            com.byazt.xk.hw.pr().pr(this.uc.iu(), 3, "valid invoke");
        }
        if (com.byazt.dz.x.pr(this.uc.iu())) {
            return b();
        }
        Context context = this.uc.getContext();
        if (of.hn(this.nt)) {
            if (zo.pr() && a.hw().ug().hw) {
                if (this.w != null && (nativeVideoTsView = this.w.get()) != null) {
                    nativeVideoTsView.setNativeRenderAd(true);
                    return hw(nativeVideoTsView);
                }
                this.vk = new LazeLayout(context, this, this);
            } else {
                try {
                    nativeVideoTsViewHw = hw(context);
                } catch (Throwable th) {
                }
                if (nativeVideoTsViewHw != null) {
                    pr(nativeVideoTsViewHw);
                }
                return hw(nativeVideoTsViewHw);
            }
        } else if (this.yb != null) {
            com.byazt.fq.hn hnVar = this.uc;
            if (hnVar != null && hnVar.b() != null) {
                this.uc.b().pr(this.yb);
            }
            return this.yb;
        }
        com.byazt.nz.x.pr().pr(this.uc.iu()).pr(this.hn).hw(this.fw);
        return this.vk;
    }

    private View hw(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView == null) {
            return null;
        }
        CreativeContainer creativeContainer = this.yb;
        if (creativeContainer == null) {
            return nativeVideoTsView;
        }
        er.zo(creativeContainer);
        this.yb.setSizeView(nativeVideoTsView);
        return this.yb;
    }

    @Override // com.byazt.bs.pr
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView hw(Context context) {
        NativeVideoTsView nativeVideoTsViewPr = pr(false);
        nativeVideoTsViewPr.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewPr.setAdCreativeClickListener(new NativeVideoTsView.pr() { // from class: com.byazt.yb.x.1
            @Override // com.byazt.gz.NativeVideoTsView.pr
            public void pr(View view, int i) {
                if (x.this.uc.b() != null) {
                    x.this.uc.b().pr(view, i);
                }
            }
        });
        com.byazt.sd.zo.nt().pr(-1L);
        nativeVideoTsViewPr.setControllerStatusCallBack(new NativeVideoTsView.x() { // from class: com.byazt.yb.x.2
            @Override // com.byazt.gz.NativeVideoTsView.x
            public void pr(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                if (x.this.pr != null) {
                    x.this.pr.pr = z;
                    x.this.pr.c = j;
                    x.this.pr.uc = j2;
                    x.this.pr.fw = j3;
                    x.this.pr.x = z2;
                    x.this.pr.zo = z3;
                }
            }
        });
        nativeVideoTsViewPr.setVideoAdLoadListener(this);
        nativeVideoTsViewPr.setVideoAdInteractionListener(this);
        if (5 == this.hn) {
            nativeVideoTsViewPr.setIsAutoPlay(this.uc.gz() ? this.hw.c() : this.uc.ve());
        } else {
            nativeVideoTsViewPr.setIsAutoPlay(this.uc.ve());
        }
        nativeVideoTsViewPr.setIsQuiet(this.nt.ax() == 1);
        com.byazt.nv.hn hnVarPr = this.uc.b().pr();
        if (hnVarPr != null) {
            hnVarPr.pr(this);
        }
        return nativeVideoTsViewPr;
    }

    @Override // com.byazt.bs.LazeLayout.pr
    public void pr(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.pr(0L, true, false);
        }
    }

    private void pr(int i) {
        int iUc = a.hw().uc(i);
        if (3 == iUc) {
            this.uc.hw(false);
            this.uc.pr(false);
            return;
        }
        if (1 == iUc && yb.x(this.uc.getContext())) {
            this.uc.hw(false);
        } else if (2 == iUc) {
            if (yb.c(this.uc.getContext()) || yb.x(this.uc.getContext()) || yb.uc(this.uc.getContext())) {
                this.uc.hw(false);
            } else {
                return;
            }
        } else if (4 == iUc) {
            this.uc.hw(true);
            return;
        } else if (5 == iUc) {
            if (!yb.x(this.uc.getContext()) && !yb.uc(this.uc.getContext())) {
                return;
            }
        } else {
            return;
        }
        this.uc.pr(true);
    }

    @Override // com.byazt.mr.vk
    public void pr(com.byazt.rt.pr prVar) {
        this.c = prVar;
    }

    @Override // com.byazt.mr.vk
    public double j_() {
        if (k.pr(this.uc.iu())) {
            return 0.0d;
        }
        return qv.fw(this.uc.iu());
    }

    @Override // com.byazt.mr.vk
    public int w() {
        com.byazt.fq.hn hnVar = this.uc;
        if (hnVar != null) {
            of ofVarIu = hnVar.iu();
            int iCz = this.uc.cz();
            if (CreativeContainer.hn(ofVarIu) && (iCz == 5 || iCz == 15 || iCz == 2001 || iCz == 2002)) {
                return ofVarIu.de().get(0).hw();
            }
        }
        try {
            if (this.x == null) {
                this.x = iu();
            }
            int[] iArr = this.x;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return LogType.UNEXP_ANR;
        } catch (Throwable th) {
            ho.pr("TTFeedAdImpl", "getAdViewWidth error", th);
            return LogType.UNEXP_ANR;
        }
    }

    private int[] iu() {
        if (this.uc.iu() != null) {
            if (this.uc.iu().jg() == 166 && v.pr(this.uc.iu())) {
                return new int[]{v.k(this.uc.iu()), v.m(this.uc.iu())};
            }
            if (this.uc.iu().sd() == 1 && this.uc.iu().id() == 1 && qv.nt(this.uc.iu()) != null) {
                return qv.nt(this.uc.iu()).vk();
            }
            if (qv.ho(this.uc.iu()) != null) {
                return qv.ho(this.uc.iu()).vk();
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.mr.vk
    public int k() {
        com.byazt.fq.hn hnVar = this.uc;
        if (hnVar != null) {
            of ofVarIu = hnVar.iu();
            int iCz = this.uc.cz();
            if (CreativeContainer.hn(ofVarIu) && (iCz == 5 || iCz == 15 || iCz == 2001 || iCz == 2002)) {
                return ofVarIu.de().get(0).hn();
            }
        }
        try {
            if (this.x == null) {
                this.x = iu();
            }
            int[] iArr = this.x;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            ho.pr("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.byazt.mr.vk
    public void pr(com.byazt.rt.hw hwVar) {
        this.m = hwVar;
    }

    @Override // com.byazt.mr.vk
    public com.byazt.pu.pr k_() {
        if (of.hw(this.nt)) {
            com.byazt.xk.hw.pr().pr(this.nt, 1, "invalid invoke");
            return null;
        }
        if (!of.pr(this.uc.iu())) {
            return null;
        }
        if (this.zo == null) {
            this.zo = new com.byazt.pu.pr() { // from class: com.byazt.yb.x.3
                public long hw = 0;

                @Override // com.byazt.pu.pr
                public String pr() {
                    if (of.hw(x.this.nt)) {
                        com.byazt.xk.hw.pr().pr(x.this.nt, 2, "invalid invoke url");
                        return null;
                    }
                    if (x.this.uc.iu() == null || x.this.uc.iu().pj() != 1 || qv.ho(x.this.uc.iu()) == null) {
                        return null;
                    }
                    if (!x.this.aj) {
                        x.this.aj = true;
                    }
                    return qv.pr(x.this.uc.iu());
                }

                @Override // com.byazt.pu.pr
                public void hw() {
                    this.hw = SystemClock.elapsedRealtime();
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.hw(true);
                    prVar.pr(true);
                    com.byazt.ne.hn.pr(x.this, prVar);
                }

                @Override // com.byazt.pu.pr
                public void pr(long j) {
                    if (this.hw == 0) {
                        this.hw = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.hw) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.pr(j);
                    prVar.hn(((long) x.this.j_()) * 1000);
                    prVar.hw(j2);
                    prVar.pr(true);
                    com.byazt.ne.hn.pr(x.this, prVar, -1);
                }

                @Override // com.byazt.pu.pr
                public void hw(long j) {
                    if (this.hw == 0) {
                        this.hw = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.hw) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.pr(j);
                    prVar.hn(((long) x.this.j_()) * 1000);
                    prVar.hw(j2);
                    prVar.pr(true);
                    com.byazt.ne.hn.hw(x.this, prVar);
                }

                @Override // com.byazt.pu.pr
                public void hn() {
                    if (this.hw == 0) {
                        this.hw = SystemClock.elapsedRealtime();
                    }
                    long jJ_ = ((long) x.this.j_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.hw) - jJ_;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.pr(jJ_);
                    prVar.hn(jJ_);
                    prVar.hw(j);
                    prVar.uc(0);
                    prVar.pr(true);
                    com.byazt.ne.hn.x(x.this, prVar);
                }

                @Override // com.byazt.pu.pr
                public void hn(long j) {
                    if (this.hw == 0) {
                        this.hw = SystemClock.elapsedRealtime();
                    }
                    long jJ_ = ((long) x.this.j_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.hw) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.pr(j);
                    prVar.hn(jJ_);
                    prVar.hw(j2);
                    prVar.c(0);
                    prVar.uc(0);
                    prVar.pr(true);
                    com.byazt.ne.hn.pr(x.this, prVar, null, -1);
                }

                @Override // com.byazt.pu.pr
                public void x() {
                    com.byazt.pj.pr.pr(x.this.uc.iu(), ls.hw(x.this.uc.iu()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (qv.ho(x.this.uc.iu()) != null) {
                        uc ucVarPr = qv.pr(4, x.this.uc.iu());
                        ucVarPr.pr("material_meta", x.this.uc.iu());
                        com.byazt.qe.hw hwVarP = x.this.uc.iu().p();
                        ucVarPr.pr("ad_slot", Integer.valueOf(hwVarP != null ? hwVarP.a() : 0));
                        ucVarPr.c(-1);
                        com.byazt.ne.hn.pr(x.this.uc.iu(), (com.byazt.iw.pr) x.this, ucVarPr, true, com.byazt.ne.hn.pr());
                    }
                }

                @Override // com.byazt.pu.pr
                public void pr(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", x.this.uc.iu().x());
                    map.put(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.byazt.n.x xVarHo = qv.ho(x.this.uc.iu());
                    if (xVarHo != null) {
                        map.put("video_size", Long.valueOf(xVarHo.c()));
                        map.put("video_resolution", xVarHo.aj());
                    }
                    com.byazt.pj.pr.hn(x.this.uc.iu(), ls.hw(x.this.uc.iu()), "play_start_error", map);
                }

                @Override // com.byazt.pu.pr
                public void pr(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.hw == 0) {
                        this.hw = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.hw;
                    long jJ_ = ((long) x.this.j_()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                    prVar.hw(j3);
                    prVar.hn(jJ_);
                    prVar.pr(j);
                    prVar.pr(i);
                    prVar.hw(i2);
                    prVar.pr(true);
                    com.byazt.ne.hn.pr((com.byazt.iw.pr) x.this, prVar, "customer error", i3, false);
                }
            };
        }
        return this.zo;
    }

    @Override // com.byazt.w.hn.x
    public void O_() {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.pr(this);
        }
    }

    @Override // com.byazt.w.hn.x
    public void a_(int i, int i2) {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.pr(i, i2);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void m_() {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.hw(this);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void n_() {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.hn(this);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void o_() {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.x(this);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void pr(long j, long j2) {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.pr(j, j2);
        }
        hw(j, j2);
    }

    private boolean ve() {
        if (this.uc.iu() == null || this.m == null) {
            return false;
        }
        int iKs = this.uc.iu().ks();
        return iKs == 1 || iKs == 2;
    }

    private void hw(long j, long j2) {
        int i;
        if (!ve() || this.ho) {
            return;
        }
        int iKs = this.uc.iu().ks();
        long j3 = 0;
        if (iKs == 1) {
            j3 = IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS;
        } else if (iKs == 2) {
            j3 = 30000;
        }
        if (j2 <= j3) {
            i = (int) ((j2 - j) / 1000);
        } else {
            i = (int) ((j3 - j) / 1000);
        }
        if (i < 0) {
            i = 0;
        }
        if (i == this.g) {
            return;
        }
        this.g = i;
        if (this.g == 0) {
            this.ho = true;
        }
        this.m.pr(this.g);
    }

    public JSONObject pr(Map<String, Object> map) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (key.contains("video") || key.contains("video_url") || key.contains("videoUrl")) {
                    jSONObject.put(key, value);
                }
            }
        }
        return jSONObject;
    }

    @Override // com.byazt.xn.hw, com.byazt.mr.m
    public Map<String, Object> g() {
        JSONObject jSONObjectPr;
        Map<String, Object> mapG = this.uc.g();
        com.byazt.fu.hn hnVarPr = com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny());
        if (hnVarPr != null && hnVarPr.pr("media_ext_video", 0.10000000149011612d)) {
            Exception e = null;
            try {
                jSONObjectPr = pr(mapG);
                try {
                    of ofVarIu = this.uc.iu();
                    if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                        jSONObjectPr.put("rit", ls.pr(ofVarIu, ""));
                        jSONObjectPr.put("req_id", ofVarIu.ny());
                        jSONObjectPr.put("cid", ofVarIu.x());
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                jSONObjectPr = null;
                e = e3;
            }
            if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                com.byazt.xk.hw.pr().pr("media_ext_video", jSONObjectPr, e);
            }
        }
        of ofVarIu2 = this.uc.iu();
        if (ofVarIu2 == null) {
            return mapG;
        }
        if (mapG == null) {
            mapG = new HashMap<>();
        }
        mapG.put("reward_task_type", Integer.valueOf(ofVarIu2.gb()));
        mapG.put("reward_task_threshold", Integer.valueOf(ofVarIu2.jo() != null ? ofVarIu2.jo().hw() : -1));
        if (ofVarIu2.jg() != 166) {
            return mapG;
        }
        if (com.byazt.lpk.pr.pr(ofVarIu2)) {
            int iX = v.x(ofVarIu2);
            int iC = v.c(ofVarIu2);
            if (mapG == null) {
                mapG = new HashMap<>();
            }
            mapG.put("live_author_follower_count", Integer.valueOf(iX));
            mapG.put("live_watch_count", Integer.valueOf(iC));
        }
        return mapG;
    }

    @Override // com.byazt.mr.m
    public void pr(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.ti.pr prVar, com.byazt.mt.pr prVar2) {
        View viewPr;
        try {
            pr(viewGroup, (List<View>) null, list, list2, list3, (View) null, prVar);
            if (prVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(prVar2.hw());
                if (viewFindViewById != null && aj() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(aj());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = er.hn(viewGroup.getContext(), 38.0f);
                        layoutParams.height = er.hn(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(aj());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(prVar2.pr());
                if (frameLayout == null || (viewPr = pr()) == null) {
                    return;
                }
                er.zo(viewPr);
                frameLayout.removeAllViews();
                frameLayout.addView(viewPr, -1, -1);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mr.m
    public void pr(com.byazt.ti.hw hwVar) {
        com.byazt.fq.hn hnVar = this.uc;
        if (hnVar != null) {
            hnVar.pr(hwVar);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void p_() {
        com.byazt.rt.pr prVar = this.c;
        if (prVar != null) {
            prVar.c(this);
        }
        if (ve() && !this.ho) {
            this.m.pr(0);
            this.ho = true;
        }
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public com.byazt.mm.pr q_() {
        return this.pr;
    }

    @Override // com.byazt.xn.hw, com.byazt.mr.m
    public void hn() {
        NativeVideoTsView nativeVideoTsView;
        if (this.w != null && (nativeVideoTsView = this.w.get()) != null) {
            nativeVideoTsView.a();
        }
        LazeLayout lazeLayout = this.vk;
        if (lazeLayout != null) {
            lazeLayout.pr();
        }
        CreativeContainer creativeContainer = this.yb;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
        super.hn();
    }

    @Override // com.byazt.mr.m
    public String x() {
        of ofVar = this.nt;
        if (ofVar != null) {
            return ofVar.z();
        }
        return null;
    }

    @Override // com.byazt.mr.m
    public com.byazt.wd.x hw() {
        return new com.byazt.vd.hn();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hw.hn(x(), 3);
    }
}
