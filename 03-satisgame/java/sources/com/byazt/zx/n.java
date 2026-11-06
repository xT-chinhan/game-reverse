package com.byazt.zx;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.gct.cd;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ho.BaseConstants;
import com.byazt.iag.s;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.un.LayoutVideoPlayLayoutForLive;
import com.byazt.vgx.w;
import com.byazt.vmq.q;
import com.byazt.vzj.UpieVideoView;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.android.metrics.LiveMetrics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1363, 19})
public abstract class n extends com.byazt.du.n {
    public com.byazt.ys.n an;
    public long b;
    public ViewGroup bb;
    public s.n dg;
    public int e;
    public long hf;
    public int kc;
    public int pe;
    public InterfaceC0421n pk;
    public final String ri;
    public WeakReference<s.qg> sh;
    public long ur;
    public final int y;
    public int yw;
    public long ln = 0;
    public boolean lh = false;
    public boolean v = false;
    public Map<String, Object> j = null;
    public final AtomicInteger f = new AtomicInteger(0);
    public final AtomicInteger fi = new AtomicInteger(0);
    public long df = 0;
    public long oj = 0;
    public final Runnable u = new Runnable() { // from class: com.byazt.zx.n.1
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dg != null) {
                n.this.dg.n();
            }
            if (n.this.pk != null) {
                n.this.pk.qg();
            }
        }
    };
    public boolean wo = false;
    public boolean rf = false;
    public boolean dh = true;
    public boolean nf = false;
    public boolean cx = false;
    public boolean lq = false;
    public boolean ic = false;
    public boolean ci = false;
    public x.n ae = new x.n() { // from class: com.byazt.zx.n.2
        @Override // com.byazt.ej.x.n
        public void qg(x xVar) {
        }

        @Override // com.byazt.ej.x.n
        public void qg(x xVar, int i) {
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar) {
            com.byazt.de.s.w(n.this.ci());
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.w(false);
                }
            });
            n.this.n(4);
            n.this.qg(4);
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, long j) {
            if (!n.this.cx) {
                n.this.cx = true;
                com.byazt.de.s.qg(n.this.ci(), 1);
            }
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.l != null) {
                        n.this.l(0);
                        n.this.l.qg();
                        n.this.n.removeCallbacks(n.this.u);
                        n.this.rf = false;
                    }
                }
            });
            n.this.n(j, false);
            n.this.b = System.currentTimeMillis();
            n.this.nf();
            if (n.this.pk != null) {
                n.this.pk.s();
            }
        }

        @Override // com.byazt.ej.x.n
        public void s(x xVar) {
            if (!n.this.lq) {
                n.this.lq = true;
                com.byazt.de.s.s(n.this.ci());
            }
            if (com.byazt.gks.n.n(n.this.w)) {
                n.this.w.s(xVar.h());
            }
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.3
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n.removeCallbacks(n.this.u);
                    if (n.this.l != null) {
                        n.this.l(0);
                        n.this.l.qg();
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(final x xVar, final com.byazt.ej.s sVar) {
            if (sVar == null) {
                return;
            }
            com.byazt.de.s.s(n.this.ci(), 1);
            sVar.n();
            sVar.s();
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.4
                @Override // java.lang.Runnable
                public void run() {
                    x xVar2;
                    x xVar3;
                    int iRv;
                    int iN = sVar.n();
                    if (iN != 308 || (xVar2 = n.this.q) == null || xVar2 == (xVar3 = xVar) || !(xVar3 instanceof q) || ((iRv = ((q) xVar3).rv()) != 200 && iRv != 203)) {
                        n.this.n(iN, sVar.qg(), sVar.s(), (JSONArray) null);
                        n.this.n.removeCallbacks(n.this.u);
                        if (n.this.l != null) {
                            n.this.l(0);
                            n.this.l.qg();
                        }
                        if (n.this.dg != null) {
                            n.this.dg.qg(n.this.oj, com.byazt.udy.n.n(n.this.x, n.this.ur));
                        }
                        if (n.this.pk != null) {
                            n.this.pk.n(iN, sVar.s());
                            return;
                        }
                        return;
                    }
                    k.qg("BaseVideoController", "ignore errorCode:" + iN + " state:" + iRv);
                }
            });
            n.this.n(sVar.n(), sVar.s());
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, boolean z) {
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.5
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n.removeCallbacks(n.this.u);
                    if (n.this.l != null) {
                        n.this.l(0);
                        n.this.l.qg();
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void q(x xVar) {
            com.byazt.de.s.s(n.this.ci(), 2);
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, int i, int i2) {
            n.this.pe = i;
            n.this.e = i2;
            n.this.pe();
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, int i, int i2, int i3) {
            com.byazt.de.s.q(n.this.ci());
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.l != null) {
                        n.this.l(8);
                        n.this.l.wm();
                        n.this.y();
                        n.this.rf = true;
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, int i) {
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.l != null) {
                        n.this.l(0);
                        n.this.l.qg();
                        n.this.n.removeCallbacks(n.this.u);
                        n.this.rf = false;
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(final x xVar, final long j, final long j2) {
            if (n.this.ic && n.this.ci) {
                n.this.ic = false;
                n.this.ci = false;
                com.byazt.de.s.qg(n.this.ci(), 2);
            }
            if (Math.abs(j - n.this.x) < 50) {
                return;
            }
            Object[] objArr = new Object[4];
            Long.valueOf(j);
            Long.valueOf(j2);
            n.this.n.post(new Runnable() { // from class: com.byazt.zx.n.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.wm != null) {
                        n.this.wm.n(j, j2);
                    }
                    n.this.qg(j, j2);
                    n.this.n(j, j2);
                    if (n.this.w.sn() <= 0 || j2 <= ((long) n.this.w.sn()) * 1000 || j < ((long) n.this.w.sn()) * 1000 || n.this.sz) {
                        return;
                    }
                    n.this.sz = true;
                    xVar.x();
                    n.this.w(false);
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(x xVar, JSONObject jSONObject, String str) {
            if (com.byazt.vyf.s.cy().pk()) {
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
            com.byazt.hm.n.n((Context) n.this.rv.get(), n.this.w, n.this.ri, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.ej.x.n
        public void l(x xVar) {
            n.this.ic = true;
            com.byazt.de.s.l(n.this.ci());
        }

        @Override // com.byazt.ej.x.n
        public void w(x xVar) {
            n.this.ci = true;
        }
    };

    /* JADX INFO: renamed from: com.byazt.zx.n$n, reason: collision with other inner class name */
    public interface InterfaceC0421n {
        void n();

        void n(int i, String str);

        void n(long j, long j2);

        void qg();

        void s();
    }

    @Override // com.byazt.iag.n
    public void l(com.byazt.iag.qg qgVar, View view) {
    }

    @Override // com.byazt.du.n
    public boolean lh() {
        return true;
    }

    public abstract int m();

    @Override // com.byazt.iag.s
    public void n(s.q qVar) {
    }

    @Override // com.byazt.iag.s
    public boolean py() {
        return false;
    }

    @Override // com.byazt.iag.s
    public void q(boolean z) {
    }

    public n(Context context, ViewGroup viewGroup, pk pkVar, com.byazt.ys.n nVar) {
        this.kc = 1;
        this.kc = hd.s(context);
        this.bb = viewGroup;
        this.rv = new WeakReference<>(context);
        this.w = pkVar;
        this.an = nVar;
        n(context);
        this.y = w.cy(this.w);
        this.ri = w.qg(this.w);
    }

    private void n(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(com.byazt.iag.qg.n.class);
        enumSetNoneOf.add(com.byazt.iag.qg.n.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.iag.qg.n.hideBackBtn);
        this.l = new com.byazt.ia.w(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.w, this, this.an);
        this.l.n((com.byazt.iag.n) this);
    }

    public void n(long j, boolean z) {
        if (this.py.n(2)) {
            return;
        }
        this.ln = j;
        tj(z);
        this.v = true;
    }

    @Override // com.byazt.iag.s
    public boolean n(l lVar) {
        if (lVar == null) {
            n("model is null");
            return false;
        }
        if (this.q != null && this.q.d()) {
            this.q.s();
            return true;
        }
        this.ou = lVar;
        lVar.ou();
        if (TextUtils.isEmpty(lVar.ou())) {
            k.qg("BaseVideoController", "No video info");
            n("url is null");
            return false;
        }
        this.lh = (lVar.ou().startsWith("http") || com.byazt.gks.n.n(this.w)) ? false : true;
        this.hd = lVar.k();
        if (lVar.sz() > 0) {
            this.x = lVar.sz();
            this.fs = this.fs > this.x ? this.fs : this.x;
        }
        if (this.l != null) {
            this.l.n();
            l(8);
            this.l.cp();
            this.l.s(lVar.tj(), lVar.cp());
            this.l.s(this.bb);
        }
        try {
            if (this.q == null) {
                if (!hu()) {
                    n("create video error");
                    return false;
                }
                this.q.n(this.ae);
            }
            bb();
            this.oj = 0L;
            s(lVar);
            return true;
        } catch (Throwable th) {
            n(th.getMessage());
            k.qg("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    private boolean hu() {
        int i;
        x qVar;
        this.h = null;
        pk pkVar = this.w;
        if (com.byazt.aci.n.qg(pkVar)) {
            com.byazt.hlq.qg qgVarLq = lq();
            if (qgVarLq != null) {
                int iD = w.d(this.w);
                this.hu = ln();
                this.q = new com.byazt.vzj.qg(qgVarLq, com.byazt.aci.n.tj(pkVar), new q(String.valueOf(iD), this.hu), ta.cd(pkVar), n(pkVar));
                i = 1;
            } else {
                if (this.ae != null) {
                    this.ae.n((x) null, new com.byazt.zsl.qg(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.l == null)));
                }
                k.qg("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.byazt.aci.n.s(pkVar)) {
            com.byazt.hlq.qg qgVarLq2 = lq();
            if (qgVarLq2 != null) {
                int iD2 = w.d(this.w);
                this.hu = ln();
                ArrayList arrayList = new ArrayList();
                Map<com.byazt.ej.k, oa> mapN = com.byazt.aci.n.n(pkVar, this.ou, this.hu, arrayList);
                if (mapN == null || mapN.size() <= 1 || arrayList.size() <= 1) {
                    if (tj.l() && this.ou.m() == 1) {
                        qVar = com.byazt.gks.qg.n().n(rv.getContext(), String.valueOf(iD2));
                    } else {
                        qVar = new q(String.valueOf(iD2), this.hu);
                    }
                } else {
                    this.h = new com.byazt.vzj.n(new q(String.valueOf(iD2), null), mapN, arrayList);
                    qVar = this.h;
                }
                this.q = new com.byazt.vzj.s(qVar, com.byazt.aci.n.tj(pkVar), n(pkVar), qgVarLq2);
                i = 2;
            } else {
                if (this.ae != null) {
                    this.ae.n((x) null, new com.byazt.zsl.qg(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.l == null)));
                }
                k.qg("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iD3 = w.d(this.w);
            if (com.byazt.gks.n.n(this.w)) {
                this.q = com.byazt.gks.qg.n().n(rv.getContext(), lh(), (long) ta.x(this.w), rv.qg().qn(), null);
                i = 3;
            } else if (tj.l() && this.ou.m() == 1) {
                this.q = com.byazt.gks.qg.n().n(rv.getContext(), String.valueOf(iD3));
                i = 4;
            } else {
                this.hu = ln();
                this.q = new q(String.valueOf(iD3), this.hu);
                i = 5;
            }
        }
        if (pkVar != null) {
            com.byazt.de.s.n(pkVar, String.valueOf(w.cy(this.w)), w.d(this.w), i, this.w.h());
        }
        return true;
    }

    public void wo() {
        if (this.w != null) {
            com.byazt.hm.n.n(this.w, w.qg(this.w), "auto_replay", new com.byazt.rs.n() { // from class: com.byazt.zx.n.3
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    com.byazt.ej.l lVarV;
                    JSONObject jSONObject2 = new JSONObject();
                    if (com.byazt.ql.s.n(n.this.w)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (n.this.ou != null && (lVarV = n.this.ou.v()) != null && lVarV.x() > 0.0d) {
                        jSONObject2.put("start", lVarV.x());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    @Override // com.byazt.iag.s
    public void qg() {
        if (this.q != null) {
            if (!l()) {
                this.f.getAndAdd(1);
                wo();
            }
            this.fi.getAndAdd(1);
            this.py.n();
            u();
            n(0L, true);
            s(false);
            this.yw = 2;
            this.cx = false;
            this.q.qg();
        }
    }

    public int sh() {
        if (com.byazt.ql.s.n(this.w)) {
            return this.fi.get();
        }
        return this.f.get();
    }

    @Override // com.byazt.iag.s
    public boolean s() {
        return this.f.get() > 0;
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public boolean q() {
        if (com.byazt.ql.s.n(this.w)) {
            return ((double) this.fi.get()) <= ((double) ta.hd(this.w).x());
        }
        return super.q();
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public boolean l() {
        if (com.byazt.ql.s.n(this.w)) {
            return ((double) this.fi.get()) < ((double) ta.hd(this.w).x());
        }
        return super.q();
    }

    @Override // com.byazt.iag.s
    public boolean ou() {
        return this.rf;
    }

    @Override // com.byazt.iag.s
    public void l(boolean z) {
        this.dh = z;
    }

    @Override // com.byazt.iag.s
    public int k() {
        return com.byazt.udy.n.n(this.fs, this.ur);
    }

    @Override // com.byazt.iag.s
    public void qg(Map<String, Object> map) {
        this.j = map;
    }

    private void s(l lVar) throws Exception {
        if (lVar == null) {
            n("model is null");
            return;
        }
        this.ou = lVar;
        if (this.q != null) {
            if (this.w != null) {
                lVar.q(String.valueOf(w.cy(this.w)));
            }
            lVar.q(1);
            com.byazt.de.s.qg(ci());
            this.q.n(lVar);
        }
        this.df = System.currentTimeMillis();
        if (!TextUtils.isEmpty(lVar.ou())) {
            this.l.l(8);
            this.l.l(0);
            n(new Runnable() { // from class: com.byazt.zx.n.4
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.q == null) {
                        n.this.n("play video error proxy empty");
                        return;
                    }
                    if (n.this.py.q(1)) {
                        n.this.n("multi play_start");
                        return;
                    }
                    n.this.py.n();
                    n.this.u();
                    n.this.df = System.currentTimeMillis();
                    n.this.l.q(0);
                    n.this.yw = 1;
                    n.this.cx = false;
                    n.this.lq = false;
                    com.byazt.de.s.n(n.this.ci(), n.this.yw);
                    n.this.q.n(true, n.this.x, n.this.hd);
                }
            });
            return;
        }
        n("url is null");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    public void y() {
        int iGe;
        int iM = m();
        if (iM == 2 || iM == 1) {
            iGe = rv.qg().ge() * 1000;
        } else {
            iGe = 5;
            if (iM == 5) {
                iGe = rv.qg().ge() * 1000;
            } else if (iM == 3) {
                iGe = rv.qg().fs(String.valueOf(this.y));
            }
        }
        this.n.removeCallbacks(this.u);
        this.n.postDelayed(this.u, iGe);
    }

    @Override // com.byazt.iag.s
    public void n(s.qg qgVar) {
        this.sh = new WeakReference<>(qgVar);
    }

    public void w(boolean z) {
        if (v() && this.l != null) {
            this.n.removeCallbacks(this.u);
            l(0);
            this.l.qg();
            this.oj = System.currentTimeMillis() - this.df;
            this.l.l(true);
            if (w.rv(this.w)) {
                this.l.n(this.w, this.rv, true);
            } else {
                this.l.h();
            }
            e();
            s.n nVar = this.dg;
            if (nVar != null) {
                nVar.n(this.oj, com.byazt.udy.n.n(this.x, this.ur));
            }
            yw();
            this.um = true;
        }
    }

    private void e() {
        if (!this.py.n(64) || s() || q()) {
            this.py.s(64);
            long j = this.ur;
            qg(j, j);
            long j2 = this.ur;
            this.x = j2;
            this.fs = j2;
            oj();
        }
    }

    private void yw() {
        InterfaceC0421n interfaceC0421n = this.pk;
        if (interfaceC0421n != null) {
            interfaceC0421n.n();
        }
    }

    @Override // com.byazt.iag.s
    public void n(s.n nVar) {
        this.dg = nVar;
    }

    @Override // com.byazt.iag.s
    public void w() {
        if (this.q != null) {
            this.q.q();
        }
        if (!this.py.n(64) || s() || q()) {
            if (this.py.n(2) || com.byazt.ql.s.n(this.w)) {
                s((Map<String, Object>) null);
            }
        }
    }

    @Override // com.byazt.iag.s
    public void n(Map<String, Object> map) {
        if (this.q != null) {
            this.q.q();
        }
        if (!this.py.n(64) || s() || q()) {
            if (this.py.n(2) || com.byazt.ql.s.n(this.w)) {
                s(map);
            }
        }
    }

    @Override // com.byazt.iag.s
    public void x() {
        if (this.q != null) {
            this.q.q();
        }
    }

    @Override // com.byazt.iag.s
    public void fs() {
        if (this.l != null) {
            this.l.n();
            this.l.a();
            this.l.m();
        }
        Object[] objArr = new Object[2];
        Boolean.valueOf(this.tj);
        if (this.q != null) {
            if (this.q.d()) {
                if (this.tj || ((this.ou != null && this.ou.fs()) || com.byazt.aci.n.qg(this.w))) {
                    ae();
                } else {
                    qg(this.t);
                }
                Object[] objArr2 = new Object[2];
                Boolean.valueOf(this.tj);
            } else {
                this.yw = 1;
                this.cx = false;
                this.q.n(false, this.x, this.hd);
            }
        }
        if (!this.py.n(64) || s() || q()) {
            if (this.py.n(2) || com.byazt.ql.s.n(this.w)) {
                dg();
            }
        }
    }

    public void rf() {
        if (!this.py.n(64) || s() || q()) {
            if (this.py.n(2) || com.byazt.ql.s.n(this.w)) {
                dg();
            }
        }
    }

    @Override // com.byazt.iag.s
    public void n(long j) {
        this.x = Math.max(j, hd().py());
        this.fs = Math.max(this.fs, cp());
        if (this.l != null) {
            this.l.n();
        }
        if (this.q != null) {
            this.yw = 1;
            this.cx = false;
            this.q.n(false, this.x, this.hd);
            this.q.n(this.x);
        }
    }

    @Override // com.byazt.iag.s
    public void rv() {
        if (this.q != null) {
            this.q.w();
            this.q = null;
            this.h = null;
        }
        if (this.l != null) {
            this.l.oa();
        }
        this.n.removeCallbacks(this.u);
        this.n.removeCallbacksAndMessages(null);
        this.dg = null;
        this.pk = null;
    }

    @Override // com.byazt.iag.s
    public void n(boolean z, int i) {
        qg(i);
        rv();
    }

    @Override // com.byazt.iag.s
    public void tj() {
        qg(-1);
        rv();
    }

    public boolean y_() {
        return this.w == null || this.w.sl() == 100.0f;
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public void wm() {
        super.wm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (lq() != null && this.q != null && (viewGroup = this.bb) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.bb.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objLq = lq();
                if (objLq instanceof TextureView) {
                    ((TextureView) objLq).setLayoutParams(layoutParams);
                } else if (objLq instanceof UpieVideoView) {
                    ((UpieVideoView) objLq).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            k.n("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean cx() throws Throwable {
        return this.rv == null || this.rv.get() == null || lq() == null || this.q == null || this.w == null || nf.x(this.w) != null || nf.fs(this.w) != null || this.w.ox() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i, int i2) {
        try {
            if (this.rv != null && this.rv.get() != null && lq() != null && this.q != null && this.w != null) {
                int[] iArrS = com.byazt.okk.s.s(rv.getContext());
                boolean z = this.w.ys() == 1;
                float f = iArrS[0];
                float f2 = iArrS[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        n(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        n(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.bb != null) {
                    Object objLq = lq();
                    if (objLq instanceof TextureView) {
                        ((TextureView) objLq).setLayoutParams(layoutParams);
                    } else if (objLq instanceof UpieVideoView) {
                        ((UpieVideoView) objLq).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            k.n("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, int i2) {
        try {
            if (cx()) {
                return;
            }
            int[] iArrS = com.byazt.okk.s.s(rv.getContext());
            boolean z = false;
            boolean z2 = this.w.ys() == 1;
            float f = iArrS[0];
            float f2 = iArrS[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    n(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                n(f, f2, f3, f4, false);
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
            Object objLq = lq();
            if ((objLq instanceof TextureView) || (objLq instanceof UpieVideoView)) {
                if (objLq instanceof TextureView) {
                    ((TextureView) objLq).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objLq).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.bb.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.bb.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            k.n("changeVideoSize", "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, int i2) {
        try {
            if (this.rv != null && this.rv.get() != null && lq() != null && this.q != null && this.w != null) {
                boolean z = this.w.ys() == 1;
                int[] iArrS = com.byazt.okk.s.s(rv.getContext());
                n(iArrS[0], iArrS[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void n(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = ta.q(this.w);
                f4 = ta.s(this.w);
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
            Object objLq = lq();
            if (objLq instanceof TextureView) {
                ((TextureView) objLq).setLayoutParams(layoutParams);
            } else if (objLq instanceof UpieVideoView) {
                ((UpieVideoView) objLq).setLayoutParams(layoutParams);
            }
            this.nf = true;
        }
    }

    public boolean dh() {
        return this.nf;
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, View view) {
        if (this.q == null || !v()) {
            return;
        }
        if (this.q.tj()) {
            w();
            this.l.qg(true, false);
            this.l.tj();
        } else {
            if (!this.q.d()) {
                if (this.l != null) {
                    this.l.s(this.bb);
                }
                n(this.x);
                if (this.l != null) {
                    this.l.qg(false, false);
                    return;
                }
                return;
            }
            fs();
            if (this.l != null) {
                this.l.qg(false, false);
            }
        }
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, int i) {
        if (this.q == null) {
            return;
        }
        qg(this.hf, w(i));
    }

    @Override // com.byazt.iag.n
    public void qg(com.byazt.iag.qg qgVar, int i) {
        if (this.l != null) {
            this.l.tj();
        }
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, int i, boolean z) {
        if (v()) {
            long j = this.ur;
            long j2 = (long) (((((long) i) * j) * 1.0f) / 100.0f);
            if (j > 0) {
                this.hf = (int) j2;
            } else {
                this.hf = 0L;
            }
            if (this.l != null) {
                this.l.n(this.hf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j, long j2) {
        this.x = j;
        this.ur = j2;
        this.l.n(j, j2);
        int iN = com.byazt.udy.n.n(j, j2);
        if (s() || q()) {
            this.l.qg(100);
        } else {
            this.l.qg(iN);
        }
        try {
            s.n nVar = this.dg;
            if (nVar != null) {
                nVar.n(j, j2);
            }
            InterfaceC0421n interfaceC0421n = this.pk;
            if (interfaceC0421n != null) {
                interfaceC0421n.n(j, j2);
            }
        } catch (Throwable th) {
            k.n("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.iag.n
    public void qg(com.byazt.iag.qg qgVar, View view) {
        qg(qgVar, view, false, false);
    }

    public void qg(com.byazt.iag.qg qgVar, View view, boolean z, boolean z2) {
        if (v()) {
            rv(!this.a);
            if (this.rv.get() instanceof Activity) {
                if (this.a) {
                    q(z ? 8 : 0);
                    if (this.l != null) {
                        this.l.n(this.bb);
                        this.l.s(false);
                    }
                } else {
                    q(1);
                    if (this.l != null) {
                        this.l.qg(this.bb);
                        this.l.s(false);
                    }
                }
                WeakReference<s.qg> weakReference = this.sh;
                s.qg qgVar2 = weakReference != null ? weakReference.get() : null;
                if (qgVar2 != null) {
                    qgVar2.n(this.a);
                }
            }
        }
    }

    public void q(int i) {
        if (v()) {
            boolean z = i == 0 || i == 8;
            Context context = this.rv.get();
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

    @Override // com.byazt.iag.n
    public void s(com.byazt.iag.qg qgVar, View view) {
        if (this.l != null) {
            this.l.oa();
        }
        n(1);
        n(true, 3);
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, View view, boolean z, boolean z2) {
        if (this.d) {
            w();
        }
        if (z && !this.d && !b()) {
            this.l.qg(!ri(), false);
            this.l.n(z2, true, false);
        }
        if (this.q != null && this.q.tj()) {
            this.l.tj();
            this.l.rv();
        } else {
            this.l.tj();
        }
    }

    @Override // com.byazt.iag.n
    public void q(com.byazt.iag.qg qgVar, View view) {
        if (this.a) {
            rv(false);
            if (this.l != null) {
                this.l.qg(this.bb);
            }
            q(1);
            return;
        }
        n(1);
        n(true, 3);
    }

    private com.byazt.hlq.qg lq() {
        if (this.rv == null || this.rv.get() == null || this.l == null) {
            return null;
        }
        return this.l.hd();
    }

    public boolean b() {
        return this.q.k();
    }

    @Override // com.byazt.iag.n
    public void n() {
        if (this.l != null) {
            this.l.rv();
            this.l.n();
        }
        if (this.l != null) {
            this.l.m();
        }
        n(-1L);
    }

    public boolean ri() {
        return this.q != null && this.q.tj();
    }

    private void qg(long j, boolean z) {
        if (this.q == null) {
            return;
        }
        if (z) {
            ic();
        }
        this.q.n(j);
    }

    private boolean w(int i) {
        return this.l.s(i);
    }

    private void ic() {
        if (this.l != null) {
            this.l.q(0);
            this.l.n(false, false);
            this.l.s(false);
            this.l.rv();
            l(8);
            this.l.cp();
        }
    }

    /* JADX INFO: renamed from: com.byazt.zx.n$6, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1363, 76})
    static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.mr.k.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.mr.k.n.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.mr.k.n.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.mr.k.n.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.byazt.ia.qg
    public void n(com.byazt.mr.k.n nVar, String str) {
        int i = AnonymousClass6.n[nVar.ordinal()];
        if (i == 1) {
            w();
            return;
        }
        if (i == 2) {
            n(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            fs();
            this.k = false;
            this.wo = true;
        }
    }

    @Override // com.byazt.iag.s
    public void n(int i) {
        if (com.byazt.gks.n.n(this.w)) {
            int iM = m();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(oa()));
                jSONObject.putOpt("buffer_time", Long.valueOf(d()));
            } catch (Exception unused) {
            }
            if (!this.py.n(512)) {
                this.py.s(512);
                if (iM == 1) {
                    com.byazt.hm.n.n(this.w, "rewarded_video", jCurrentTimeMillis, jSONObject, com.byazt.gw.s.n(this.l));
                } else if (iM == 2) {
                    com.byazt.hm.n.n(this.w, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.byazt.gw.s.n(this.l));
                }
            }
            if (com.byazt.gks.n.n(this.w)) {
                if (com.byazt.wq.qg.n().n(this.w)) {
                    com.byazt.wq.qg.n().n(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.w, jCurrentTimeMillis);
                } else {
                    com.byazt.gks.n.n(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.w, jCurrentTimeMillis);
                }
            }
        }
    }

    public void l(int i) {
        Object obj;
        if (this.rv == null || !com.byazt.gks.n.n(this.w) || this.rv.get() == null || (obj = (Context) this.rv.get()) == null || !(obj instanceof com.byazt.rv.n)) {
            return;
        }
        ((com.byazt.rv.n) obj).n(i == 0);
    }

    public void nf() {
        if (com.byazt.gks.n.n(this.w)) {
            int iM = m();
            boolean zN = this.py.n(1024);
            long jLongValue = this.py.qg(1).longValue();
            if (zN) {
                return;
            }
            this.py.s(1024);
            if (iM == 1) {
                com.byazt.hm.n.n(this.w, "rewarded_video", System.currentTimeMillis() - jLongValue, com.byazt.gw.s.n(this.l));
            } else if (iM == 2) {
                com.byazt.hm.n.n(this.w, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.byazt.gw.s.n(this.l));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (com.byazt.gks.n.n(this.w)) {
            int iM = m();
            if (iM == 1) {
                com.byazt.hm.n.n(this.w, "rewarded_video", i, str, com.byazt.gw.s.n(this.l));
            } else if (iM == 2) {
                com.byazt.hm.n.n(this.w, "fullscreen_interstitial_ad", i, str, com.byazt.gw.s.n(this.l));
            }
        }
    }

    public void pe() {
        this.n.post(new Runnable() { // from class: com.byazt.zx.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (!cd.q(n.this.w) && n.this.y_()) {
                    if (com.byazt.gks.n.n(n.this.w) && n.this.w.ys() == 2 && n.this.y_()) {
                        return;
                    }
                    if (n.this.y_()) {
                        if (n.this.w == null || n.this.w.qh() != 0) {
                            if (n.this.w != null && n.this.w.qh() == 2) {
                                n nVar = n.this;
                                nVar.qg(nVar.pe, n.this.e);
                                return;
                            } else {
                                n nVar2 = n.this;
                                nVar2.s(nVar2.pe, n.this.e);
                                return;
                            }
                        }
                        n nVar3 = n.this;
                        nVar3.q(nVar3.pe, n.this.e);
                        return;
                    }
                    n nVar4 = n.this;
                    nVar4.n(nVar4.pe, n.this.e);
                    return;
                }
                n nVar5 = n.this;
                nVar5.n(nVar5.pe, n.this.e);
            }
        });
    }

    @Override // com.byazt.iag.s
    public int oa() {
        if (this.q == null) {
            return 0;
        }
        return this.q.um();
    }

    @Override // com.byazt.iag.s
    public void qg(l lVar) {
        this.ou = lVar;
    }

    @Override // com.byazt.du.n
    public Map<String, Object> pk() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.j;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : w.n(this.ln, this.w, hd()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    public void n(InterfaceC0421n interfaceC0421n) {
        this.pk = interfaceC0421n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ci() {
        if (this.w == null) {
            return null;
        }
        return this.w.h();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.s.s(ci(), 3);
    }
}
