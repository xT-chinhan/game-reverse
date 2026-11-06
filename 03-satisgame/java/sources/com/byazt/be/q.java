package com.byazt.be;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.fvm.oa;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ia.NativeDrawVideoTsView;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.lz.LazeLayout;
import com.byazt.nf.rv;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.shr.um;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.byazt.whi.l;
import com.byazt.wq.EcMallWebView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 668, 5})
public class q extends com.byazt.hn.qg implements com.byazt.iag.s.q, com.byazt.iag.s.InterfaceC0200s, com.byazt.kb.n, com.byazt.cs.n.InterfaceC0149n, LazeLayout.n<NativeVideoTsView>, com.byazt.lz.n<NativeVideoTsView> {
    public com.byazt.dc.n cd;
    public volatile WeakReference<NativeVideoTsView> cp;
    public pk cy;
    public WeakReference<EcMallWebView> d;
    public com.byazt.slh.n fs;
    public CreativeContainer hd;
    public volatile boolean k;
    public com.byazt.wn.n l;
    public com.byazt.cs.n n;
    public com.byazt.wn.qg oa;
    public int[] q;
    public com.byazt.zq.qg qg;
    public boolean rv;
    public int s;
    public volatile int sz;
    public LazeLayout tj;
    public l w;
    public int x;

    public q(Context context, pk pkVar, int i, com.byazt.zq.qg qgVar) {
        super(new l(context, pkVar, i, qgVar, true));
        this.q = null;
        this.rv = false;
        this.tj = null;
        this.cp = null;
        this.d = null;
        this.cd = new com.byazt.dc.n(null) { // from class: com.byazt.be.q.4
            @Override // com.byazt.dc.n
            public void n(oa oaVar) {
            }

            @Override // com.byazt.dc.n
            public void n(View view, oa oaVar) {
                if (q.this.cp == null || q.this.cp.get() == null) {
                    return;
                }
                ((NativeVideoTsView) q.this.cp.get()).cp();
            }

            @Override // com.byazt.dc.n
            public void qg(View view, oa oaVar) {
                if (q.this.cp == null || q.this.cp.get() == null) {
                    return;
                }
                ((NativeVideoTsView) q.this.cp.get()).cp();
            }
        };
        l lVar = (l) v();
        this.w = lVar;
        lVar.t().n(this);
        this.s = i;
        this.qg = qgVar;
        this.n = new com.byazt.cs.n();
        this.cy = pkVar;
        int iCy = w.cy(pkVar);
        this.x = iCy;
        n(iCy);
        this.w.n(this.cd);
        if (context == null || !CreativeContainer.qg(pkVar)) {
            return;
        }
        this.hd = new CreativeContainer(context, pkVar, this.w.qg());
    }

    public NativeVideoTsView bb() {
        if (this.cp != null) {
            return this.cp.get();
        }
        return null;
    }

    public int ln() {
        return this.s;
    }

    public int lh() {
        return this.x;
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public boolean ur() {
        return this.rv;
    }

    public NativeVideoTsView n(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.w.getContext(), this.w.ur());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.w.getContext(), this.w.ur(), false, false, w.qg(this.s), false, false);
        }
        this.cp = new WeakReference<>(nativeVideoTsView);
        this.w.n(this.cp);
        this.w.s();
        return nativeVideoTsView;
    }

    private View j() {
        EcMallWebView ecMallWebView;
        WeakReference<EcMallWebView> weakReference = this.d;
        if (weakReference != null && (ecMallWebView = weakReference.get()) != null) {
            return ecMallWebView;
        }
        EcMallWebView ecMallWebView2 = new EcMallWebView(this.w.getContext(), this.w.ur(), this.s == 9 ? 6 : 1);
        ecMallWebView2.setMaterialMeta(com.byazt.cd.s.n(this.cy));
        this.d = new WeakReference<>(ecMallWebView2);
        return ecMallWebView2;
    }

    @Override // com.byazt.hn.qg, com.byazt.fvm.oa
    public View py() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewQg = null;
        if (this.w.ur() == null || this.w.getContext() == null) {
            return null;
        }
        if (pk.qg(this.w.ur())) {
            com.byazt.eji.s.n().n(this.w.ur(), 3, "valid invoke");
        }
        if (com.byazt.hoz.q.n(this.w.ur())) {
            return j();
        }
        Context context = this.w.getContext();
        if (pk.s(this.cy)) {
            if (com.byazt.ag.qg.n() && rv.qg().pt().qg) {
                if (this.cp != null && (nativeVideoTsView = this.cp.get()) != null) {
                    nativeVideoTsView.setNativeRenderAd(true);
                    return qg(nativeVideoTsView);
                }
                this.tj = new LazeLayout(context, this, this);
            } else {
                try {
                    nativeVideoTsViewQg = qg(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewQg != null) {
                    n(nativeVideoTsViewQg);
                }
                return qg(nativeVideoTsViewQg);
            }
        } else if (this.hd != null) {
            l lVar = this.w;
            if (lVar != null && lVar.t() != null) {
                this.w.t().n(this.hd);
            }
            return this.hd;
        }
        com.byazt.eo.q.n().n(this.w.ur()).n(this.s).qg(this.x);
        return this.tj;
    }

    private View qg(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView == null) {
            return null;
        }
        CreativeContainer creativeContainer = this.hd;
        if (creativeContainer == null) {
            return nativeVideoTsView;
        }
        com.byazt.okk.s.fs(creativeContainer);
        this.hd.setSizeView(nativeVideoTsView);
        return this.hd;
    }

    @Override // com.byazt.lz.n
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView qg(Context context) {
        NativeVideoTsView nativeVideoTsViewN = n(false);
        nativeVideoTsViewN.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewN.setAdCreativeClickListener(new NativeVideoTsView.n() { // from class: com.byazt.be.q.1
            @Override // com.byazt.ia.NativeVideoTsView.n
            public void n(View view, int i) {
                if (q.this.w.t() != null) {
                    q.this.w.t().n(view, i);
                }
            }
        });
        com.byazt.vyf.s.cy().n(-1L);
        nativeVideoTsViewN.setControllerStatusCallBack(new NativeVideoTsView.q() { // from class: com.byazt.be.q.2
            @Override // com.byazt.ia.NativeVideoTsView.q
            public void n(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                if (q.this.n != null) {
                    q.this.n.n = z;
                    q.this.n.l = j;
                    q.this.n.w = j2;
                    q.this.n.x = j3;
                    q.this.n.q = z2;
                    q.this.n.fs = z3;
                }
            }
        });
        nativeVideoTsViewN.setVideoAdLoadListener(this);
        nativeVideoTsViewN.setVideoAdInteractionListener(this);
        if (5 == this.s) {
            nativeVideoTsViewN.setIsAutoPlay(this.w.ln() ? this.qg.l() : this.w.bb());
        } else {
            nativeVideoTsViewN.setIsAutoPlay(this.w.bb());
        }
        nativeVideoTsViewN.setIsQuiet(this.cy.kj() == 1);
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = this.w.t().n();
        if (iTTInnerDownloadAdapterN != null) {
            iTTInnerDownloadAdapterN.setVideoDataListener(this);
        }
        return nativeVideoTsViewN;
    }

    @Override // com.byazt.lz.LazeLayout.n
    public void n(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.n(0L, true, false);
        }
    }

    private void n(int i) {
        int iL = rv.qg().l(i);
        if (3 == iL) {
            this.w.qg(false);
            this.w.n(false);
            return;
        }
        if (1 == iL && hd.q(this.w.getContext())) {
            this.w.qg(false);
        } else if (2 == iL) {
            if (!hd.l(this.w.getContext()) && !hd.q(this.w.getContext()) && !hd.w(this.w.getContext())) {
                return;
            } else {
                this.w.qg(false);
            }
        } else if (4 == iL) {
            this.w.qg(true);
            return;
        } else {
            if (5 != iL) {
                return;
            }
            if (!hd.q(this.w.getContext()) && !hd.w(this.w.getContext())) {
                return;
            }
        }
        this.w.n(true);
    }

    @Override // com.byazt.fvm.tj
    public void n(com.byazt.wn.n nVar) {
        this.l = nVar;
    }

    @Override // com.byazt.fvm.tj
    public double n() {
        if (com.byazt.ql.s.n(this.w.ur())) {
            return 0.0d;
        }
        return ta.x(this.w.ur());
    }

    @Override // com.byazt.fvm.tj
    public int s() {
        l lVar = this.w;
        if (lVar != null) {
            pk pkVarUr = lVar.ur();
            int iHd = this.w.hd();
            if (CreativeContainer.s(pkVarUr) && (iHd == 5 || iHd == 15 || iHd == 2001 || iHd == 2002)) {
                return pkVarUr.jo().get(0).qg();
            }
        }
        try {
            if (this.q == null) {
                this.q = an();
            }
            int[] iArr = this.q;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return 1280;
        } catch (Throwable th) {
            k.n("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    private int[] an() {
        if (this.w.ur() == null) {
            return null;
        }
        if (this.w.ur().ge() == 166 && oj.n(this.w.ur())) {
            return new int[]{oj.d(this.w.ur()), oj.oa(this.w.ur())};
        }
        if (this.w.ur().io() == 1 && this.w.ur().kz() == 1 && ta.cy(this.w.ur()) != null) {
            return ta.cy(this.w.ur()).tj();
        }
        if (ta.k(this.w.ur()) != null) {
            return ta.k(this.w.ur()).tj();
        }
        return null;
    }

    @Override // com.byazt.fvm.tj
    public int q() {
        l lVar = this.w;
        if (lVar != null) {
            pk pkVarUr = lVar.ur();
            int iHd = this.w.hd();
            if (CreativeContainer.s(pkVarUr) && (iHd == 5 || iHd == 15 || iHd == 2001 || iHd == 2002)) {
                return pkVarUr.jo().get(0).s();
            }
        }
        try {
            if (this.q == null) {
                this.q = an();
            }
            int[] iArr = this.q;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            k.n("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.byazt.fvm.tj
    public void n(com.byazt.wn.qg qgVar) {
        this.oa = qgVar;
    }

    @Override // com.byazt.fvm.tj
    public com.byazt.slh.n qg() {
        if (pk.qg(this.cy)) {
            com.byazt.eji.s.n().n(this.cy, 1, "invalid invoke");
            return null;
        }
        if (!pk.n(this.w.ur())) {
            return null;
        }
        if (this.fs == null) {
            this.fs = new com.byazt.slh.n() { // from class: com.byazt.be.q.3
                public long qg = 0;

                @Override // com.byazt.slh.n
                public String n() {
                    if (pk.qg(q.this.cy)) {
                        com.byazt.eji.s.n().n(q.this.cy, 2, "invalid invoke url");
                        return null;
                    }
                    if (q.this.w.ur() == null || q.this.w.ur().r() != 1 || ta.k(q.this.w.ur()) == null) {
                        return null;
                    }
                    if (!q.this.rv) {
                        q.this.rv = true;
                    }
                    return ta.n(q.this.w.ur());
                }

                @Override // com.byazt.slh.n
                public void qg() {
                    this.qg = SystemClock.elapsedRealtime();
                    um.n nVar = new um.n();
                    nVar.qg(true);
                    nVar.n(true);
                    com.byazt.gw.s.n(q.this, nVar);
                }

                @Override // com.byazt.slh.n
                public void n(long j) {
                    if (this.qg == 0) {
                        this.qg = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.qg) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    um.n nVar = new um.n();
                    nVar.n(j);
                    nVar.s(((long) q.this.n()) * 1000);
                    nVar.qg(j2);
                    nVar.n(true);
                    com.byazt.gw.s.n(q.this, nVar, -1);
                }

                @Override // com.byazt.slh.n
                public void qg(long j) {
                    if (this.qg == 0) {
                        this.qg = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.qg) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    um.n nVar = new um.n();
                    nVar.n(j);
                    nVar.s(((long) q.this.n()) * 1000);
                    nVar.qg(j2);
                    nVar.n(true);
                    com.byazt.gw.s.qg(q.this, nVar);
                }

                @Override // com.byazt.slh.n
                public void s() {
                    if (this.qg == 0) {
                        this.qg = SystemClock.elapsedRealtime();
                    }
                    long jN = ((long) q.this.n()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.qg) - jN;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    um.n nVar = new um.n();
                    nVar.n(jN);
                    nVar.s(jN);
                    nVar.qg(j);
                    nVar.w(0);
                    nVar.n(true);
                    com.byazt.gw.s.q(q.this, nVar);
                }

                @Override // com.byazt.slh.n
                public void s(long j) {
                    if (this.qg == 0) {
                        this.qg = SystemClock.elapsedRealtime();
                    }
                    long jN = ((long) q.this.n()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.qg) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    um.n nVar = new um.n();
                    nVar.n(j);
                    nVar.s(jN);
                    nVar.qg(j2);
                    nVar.l(0);
                    nVar.w(0);
                    nVar.n(true);
                    com.byazt.gw.s.n(q.this, nVar, null, -1);
                }

                @Override // com.byazt.slh.n
                public void q() {
                    com.byazt.hm.n.n(q.this.w.ur(), w.qg(q.this.w.ur()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (ta.k(q.this.w.ur()) != null) {
                        com.byazt.zsl.l lVarN = ta.n(4, q.this.w.ur());
                        lVarN.n("material_meta", q.this.w.ur());
                        com.byazt.zq.qg qgVarXd = q.this.w.ur().xd();
                        lVarN.n("ad_slot", Integer.valueOf(qgVarXd != null ? qgVarXd.a() : 0));
                        lVarN.l(-1);
                        com.byazt.gw.s.n(q.this.w.ur(), (com.byazt.kb.n) q.this, lVarN, true, com.byazt.gw.s.n());
                    }
                }

                @Override // com.byazt.slh.n
                public void n(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", q.this.w.ur().q());
                    map.put("error_code", Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.byazt.zsl.s sVarK = ta.k(q.this.w.ur());
                    if (sVarK != null) {
                        map.put("video_size", Long.valueOf(sVarK.l()));
                        map.put("video_resolution", sVarK.rv());
                    }
                    com.byazt.hm.n.s(q.this.w.ur(), w.qg(q.this.w.ur()), "play_start_error", map);
                }

                @Override // com.byazt.slh.n
                public void n(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.qg == 0) {
                        this.qg = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.qg;
                    long jN = ((long) q.this.n()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    um.n nVar = new um.n();
                    nVar.qg(j3);
                    nVar.s(jN);
                    nVar.n(j);
                    nVar.n(i);
                    nVar.qg(i2);
                    nVar.n(true);
                    com.byazt.gw.s.n((com.byazt.kb.n) q.this, nVar, "customer error", i3, false);
                }
            };
        }
        return this.fs;
    }

    @Override // com.byazt.iag.s.q
    public void w_() {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.n(this);
        }
    }

    @Override // com.byazt.iag.s.q
    public void a_(int i, int i2) {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.n(i, i2);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void s_() {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.qg(this);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void t_() {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.s(this);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void u_() {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.q(this);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void n(long j, long j2) {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.n(j, j2);
        }
        qg(j, j2);
    }

    private boolean ae() {
        if (this.w.ur() == null || this.oa == null) {
            return false;
        }
        int iLa = this.w.ur().la();
        return iLa == 1 || iLa == 2;
    }

    private void qg(long j, long j2) {
        long j3;
        int i;
        if (ae() && !this.k) {
            int iLa = this.w.ur().la();
            if (iLa == 1) {
                j3 = 15000;
            } else {
                j3 = iLa == 2 ? 30000L : 0L;
            }
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.sz) {
                return;
            }
            this.sz = i;
            if (this.sz == 0) {
                this.k = true;
            }
            this.oa.n(this.sz);
        }
    }

    public JSONObject n(Map<String, Object> map) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null) {
                    if (key.contains(MediaFormat.KEY_VIDEO) || key.contains("video_url") || key.contains("videoUrl")) {
                        jSONObject.put(key, value);
                    }
                }
            }
        }
        return jSONObject;
    }

    @Override // com.byazt.hn.qg, com.byazt.fvm.oa
    public Map<String, Object> ou() {
        JSONObject jSONObjectN;
        Map<String, Object> mapOu = this.w.ou();
        com.byazt.sf.s sVarN = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou());
        if (sVarN != null && sVarN.n("media_ext_video", 0.009999999776482582d)) {
            Exception e = null;
            try {
                jSONObjectN = n(mapOu);
                try {
                    pk pkVarUr = this.w.ur();
                    if (jSONObjectN != null && jSONObjectN.length() > 0) {
                        jSONObjectN.put("rit", w.n(pkVarUr, ""));
                        jSONObjectN.put("req_id", pkVarUr.ou());
                        jSONObjectN.put("cid", pkVarUr.q());
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                jSONObjectN = null;
                e = e3;
            }
            if (jSONObjectN != null && jSONObjectN.length() > 0) {
                com.byazt.eji.s.n().n("media_ext_video", jSONObjectN, e);
            }
        }
        pk pkVarUr2 = this.w.ur();
        if (pkVarUr2 == null) {
            return mapOu;
        }
        if (mapOu == null) {
            mapOu = new HashMap<>();
        }
        mapOu.put("reward_task_type", Integer.valueOf(pkVarUr2.ev()));
        mapOu.put("reward_task_threshold", Integer.valueOf(pkVarUr2.gu() != null ? pkVarUr2.gu().qg() : -1));
        if (pkVarUr2.ge() != 166) {
            return mapOu;
        }
        if (com.byazt.gks.n.n(pkVarUr2)) {
            int iQ = oj.q(pkVarUr2);
            int iL = oj.l(pkVarUr2);
            if (mapOu == null) {
                mapOu = new HashMap<>();
            }
            mapOu.put("live_author_follower_count", Integer.valueOf(iQ));
            mapOu.put("live_watch_count", Integer.valueOf(iL));
        }
        return mapOu;
    }

    @Override // com.byazt.fvm.oa
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.dc.n nVar, com.byazt.he.q qVar) {
        View viewPy;
        try {
            n(viewGroup, (List<View>) null, list, list2, list3, (View) null, nVar);
            if (qVar != null) {
                View viewFindViewById = viewGroup.findViewById(qVar.d());
                if (viewFindViewById != null && w() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(w());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = com.byazt.okk.s.s(viewGroup.getContext(), 38.0f);
                        layoutParams.height = com.byazt.okk.s.s(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(w());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(qVar.x());
                if (frameLayout == null || (viewPy = py()) == null) {
                    return;
                }
                com.byazt.okk.s.fs(viewPy);
                frameLayout.removeAllViews();
                frameLayout.addView(viewPy, -1, -1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.qg qgVar) {
        l lVar = this.w;
        if (lVar != null) {
            lVar.n(qgVar);
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.q qVar) {
        l lVar = this.w;
        if (lVar != null) {
            lVar.n(qVar);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void v_() {
        com.byazt.wn.n nVar = this.l;
        if (nVar != null) {
            nVar.l(this);
        }
        if (!ae() || this.k) {
            return;
        }
        this.oa.n(0);
        this.k = true;
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public com.byazt.cs.n t() {
        return this.n;
    }

    @Override // com.byazt.hn.qg, com.byazt.fvm.oa
    public void m() {
        NativeVideoTsView nativeVideoTsView;
        if (this.cp != null && (nativeVideoTsView = this.cp.get()) != null) {
            nativeVideoTsView.ou();
        }
        WeakReference<EcMallWebView> weakReference = this.d;
        if (weakReference != null) {
            EcMallWebView ecMallWebView = weakReference.get();
            if (ecMallWebView != null) {
                ecMallWebView.destroy();
            }
            this.d = null;
        }
        LazeLayout lazeLayout = this.tj;
        if (lazeLayout != null) {
            lazeLayout.n();
        }
        CreativeContainer creativeContainer = this.hd;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
        super.m();
    }

    @Override // com.byazt.fvm.oa
    public String hu() {
        pk pkVar = this.cy;
        if (pkVar != null) {
            return pkVar.h();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.nq.l h() {
        return new com.byazt.fp.s();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.qg.s(hu(), 3);
    }
}
