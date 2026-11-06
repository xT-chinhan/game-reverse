package com.byazt.za;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.gct.kc;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.kfh.SSWebView;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 2037})
public class NativeExpressView extends FrameLayout implements com.byazt.tq.q, com.byazt.udb.fs, com.byazt.udb.k, com.byazt.hne.n, d, hd, com.byazt.li.qg {
    public static int um = 500;
    public boolean a;
    public FrameLayout ae;
    public FrameLayout an;
    public com.byazt.udb.tj.n b;
    public com.byazt.vgn.q bb;
    public boolean cd;
    public com.byazt.udb.oa ci;
    public ExpressVideoView cp;
    public volatile com.byazt.udb.sz cx;
    public boolean cy;
    public com.byazt.iag.s.q d;
    public final AtomicBoolean df;
    public Runnable dg;
    public com.byazt.gn.fs dh;
    public com.byazt.pi.s dn;
    public float dw;
    public com.byazt.udb.w e;
    public SparseArray<com.byazt.ys.l.n> el;
    public final com.byazt.hm.qg f;
    public final AtomicBoolean fi;
    public float fl;
    public com.byazt.zq.qg fs;
    public String h;
    public View ha;
    public com.byazt.udb.s hd;
    public boolean he;
    public cd hf;
    public final AtomicBoolean hu;
    public float i;
    public com.byazt.udb.q<? extends View> ic;
    public FrameLayout j;
    public boolean k;
    public boolean kc;
    public n l;
    public kc lh;
    public boolean ln;
    public com.byazt.udb.rv lq;
    public com.byazt.ys.qg m;
    public boolean n;
    public com.byazt.udb.cy nf;
    public com.byazt.iag.s.InterfaceC0200s oa;
    public FrameLayout oj;
    public boolean ou;
    public com.byazt.udb.qg pe;
    public final Runnable pk;
    public FrameLayout py;
    public Dialog q;
    public int qg;
    public bb rf;
    public List<com.byazt.udb.tj> ri;
    public pk rv;
    public com.byazt.wg.qg s;
    public final Runnable sh;
    public long su;
    public FrameLayout sz;
    public float t;
    public String tj;
    public final ViewTreeObserver.OnScrollChangedListener u;
    public float ur;
    public com.byazt.ve.n v;
    public float vb;
    public final Context w;
    public com.byazt.ys.n wm;
    public final Runnable wo;
    public String x;
    public ThemeStatusBroadcastReceiver y;
    public com.byazt.gn.x yw;
    public wm z;

    public void fs() {
    }

    public com.byazt.iag.s getVideoController() {
        return null;
    }

    public void l() {
    }

    public long n() {
        return 0L;
    }

    public void n(float f) {
    }

    public void n(float f, float f2, float f3, float f4, int i) {
    }

    public void n(int i) {
    }

    public void n(int i, int i2) {
    }

    public void n(int i, String str) {
    }

    public void n(pk pkVar) {
    }

    @Override // com.byazt.li.qg
    public void n(String str) {
    }

    public void q() {
    }

    public void q(int i) {
    }

    public int qg() {
        return 0;
    }

    public void qg(int i) {
    }

    public int s() {
        return 0;
    }

    public void s(int i) {
    }

    public void setPauseFromExpressView(boolean z) {
    }

    public void setTimeUpdate(int i) {
    }

    public void tj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        if (this.fi.get() && this.f.n()) {
            this.f.n(com.byazt.okk.q.qg(this), i);
        }
    }

    public NativeExpressView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str) {
        super(context);
        this.n = true;
        this.qg = 0;
        this.x = com.byazt.wg.qg.AD_TAG_FEED;
        this.hu = new AtomicBoolean(false);
        this.h = null;
        this.cy = false;
        this.cd = false;
        this.a = false;
        this.ln = false;
        this.fi = new AtomicBoolean(false);
        this.ou = false;
        this.df = new AtomicBoolean(false);
        this.u = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.za.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.l(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.pk);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.pk, 500L);
            }
        };
        this.pk = new Runnable() { // from class: com.byazt.za.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.okk.q.qg(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.w(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.w(8);
                }
            }
        };
        this.wo = new Runnable() { // from class: com.byazt.za.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(0);
            }
        };
        this.sh = new Runnable() { // from class: com.byazt.za.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(8);
            }
        };
        this.el = new SparseArray<>();
        this.vb = -1.0f;
        this.fl = -1.0f;
        this.i = -1.0f;
        this.dw = -1.0f;
        this.su = 0L;
        this.x = str;
        this.w = context;
        this.rv = pkVar;
        this.f = new com.byazt.hm.qg(this.rv, this.x);
        this.fs = qgVar;
        sz();
    }

    public NativeExpressView(boolean z, Context context, pk pkVar, com.byazt.zq.qg qgVar, String str, boolean z2) {
        super(context);
        this.n = true;
        this.qg = 0;
        this.x = com.byazt.wg.qg.AD_TAG_FEED;
        this.hu = new AtomicBoolean(false);
        this.h = null;
        this.cy = false;
        this.cd = false;
        this.a = false;
        this.ln = false;
        this.fi = new AtomicBoolean(false);
        this.ou = false;
        this.df = new AtomicBoolean(false);
        this.u = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.za.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.l(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.pk);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.pk, 500L);
            }
        };
        this.pk = new Runnable() { // from class: com.byazt.za.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.okk.q.qg(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.w(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.w(8);
                }
            }
        };
        this.wo = new Runnable() { // from class: com.byazt.za.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(0);
            }
        };
        this.sh = new Runnable() { // from class: com.byazt.za.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(8);
            }
        };
        this.el = new SparseArray<>();
        this.vb = -1.0f;
        this.fl = -1.0f;
        this.i = -1.0f;
        this.dw = -1.0f;
        this.su = 0L;
        this.x = str;
        this.w = context;
        this.rv = pkVar;
        this.f = new com.byazt.hm.qg(this.rv, this.x);
        this.fs = qgVar;
        this.cy = z;
        this.a = z2;
        sz();
    }

    public NativeExpressView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str, boolean z) {
        super(context);
        this.n = true;
        this.qg = 0;
        this.x = com.byazt.wg.qg.AD_TAG_FEED;
        this.hu = new AtomicBoolean(false);
        this.h = null;
        this.cy = false;
        this.cd = false;
        this.a = false;
        this.ln = false;
        this.fi = new AtomicBoolean(false);
        this.ou = false;
        this.df = new AtomicBoolean(false);
        this.u = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.za.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.l(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.pk);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.pk, 500L);
            }
        };
        this.pk = new Runnable() { // from class: com.byazt.za.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.okk.q.qg(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.w(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.w(8);
                }
            }
        };
        this.wo = new Runnable() { // from class: com.byazt.za.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(0);
            }
        };
        this.sh = new Runnable() { // from class: com.byazt.za.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(8);
            }
        };
        this.el = new SparseArray<>();
        this.vb = -1.0f;
        this.fl = -1.0f;
        this.i = -1.0f;
        this.dw = -1.0f;
        this.su = 0L;
        this.x = str;
        this.w = context;
        this.rv = pkVar;
        this.f = new com.byazt.hm.qg(this.rv, this.x);
        this.fs = qgVar;
        this.a = z;
        if (qgVar.a() == 9) {
            this.cy = qgVar.k() == 2;
        }
        sz();
    }

    public NativeExpressView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str, boolean z, String str2) {
        super(context);
        this.n = true;
        this.qg = 0;
        this.x = com.byazt.wg.qg.AD_TAG_FEED;
        this.hu = new AtomicBoolean(false);
        this.h = null;
        this.cy = false;
        this.cd = false;
        this.a = false;
        this.ln = false;
        this.fi = new AtomicBoolean(false);
        this.ou = false;
        this.df = new AtomicBoolean(false);
        this.u = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.za.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.l(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.pk);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.pk, 500L);
            }
        };
        this.pk = new Runnable() { // from class: com.byazt.za.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.okk.q.qg(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.w(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.w(8);
                }
            }
        };
        this.wo = new Runnable() { // from class: com.byazt.za.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(0);
            }
        };
        this.sh = new Runnable() { // from class: com.byazt.za.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.w(8);
            }
        };
        this.el = new SparseArray<>();
        this.vb = -1.0f;
        this.fl = -1.0f;
        this.i = -1.0f;
        this.dw = -1.0f;
        this.su = 0L;
        this.x = str;
        this.w = context;
        this.rv = pkVar;
        this.f = new com.byazt.hm.qg(this.rv, this.x);
        this.tj = str2;
        this.fs = qgVar;
        this.a = z;
        if (qgVar.a() == 9) {
            this.cy = qgVar.k() == 2;
        }
        sz();
    }

    public void sz() {
        this.py = new FrameLayout(this.w);
        this.an = new FrameLayout(this.w);
        this.ae = new FrameLayout(this.w);
        addView(this.py);
        addView(this.an);
        addView(this.ae);
        this.ri = new ArrayList();
        com.byazt.zq.qg qgVar = this.fs;
        if (qgVar != null) {
            this.t = qgVar.fs();
            this.ur = this.fs.rv();
            wm();
            this.h = this.fs.q();
        }
        if (!d()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            cp();
        }
        hu();
        bb();
        com.byazt.udb.cy cyVar = this.nf;
        if (cyVar != null) {
            this.rf = (bb) cyVar.n();
        }
        if (h()) {
            this.hf = new cd(this);
        }
    }

    public com.byazt.hm.qg getAdShowTime() {
        return this.f;
    }

    private void cp() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.y = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.n(this);
    }

    private boolean d() {
        return ur() && nf.n(this.rv) == 1;
    }

    private void wm() {
        com.byazt.zq.qg qgVar;
        if (TextUtils.equals(this.x, "splash_ad") && (qgVar = this.fs) != null && this.ur == qgVar.x() && this.t == this.fs.w()) {
            this.ur = com.byazt.okk.s.q(this.w, this.ur);
            int iL = com.byazt.okk.s.l(this.w);
            float f = this.t;
            float f2 = iL;
            if (f < f2) {
                this.t = com.byazt.okk.s.q(this.w, f2);
            } else {
                this.t = com.byazt.okk.s.q(this.w, f);
            }
        }
    }

    public SSWebView getWebView() {
        bb bbVar = this.rf;
        if (bbVar == null) {
            return null;
        }
        return bbVar.n();
    }

    private void m() {
        try {
            if (this.y == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            com.byazt.vgx.w.n(this.w, this.y, intentFilter, com.byazt.vgx.w.t(), null, 4);
        } catch (Throwable unused) {
        }
    }

    private void hu() {
        com.byazt.udb.oa.n nVar;
        List<v> listJo;
        v vVar;
        boolean zRv = nf.rv(this.rv);
        JSONObject jSONObjectN = null;
        if (!d()) {
            boolean z = nf.s(this.rv) == 9 || nf.s(this.rv) == 0;
            if (zRv) {
                jSONObjectN = com.byazt.ns.qg.n(this.rv, com.byazt.ns.qg.n(this.t, this.ur, this.cy), com.byazt.ns.qg.n(this.rv), false, this.tj, z);
            } else if (nf.cp(this.rv)) {
                if (nf.x(this.rv) != null && !TextUtils.isEmpty(nf.x(this.rv).rv())) {
                    jSONObjectN = com.byazt.ep.cp.n(nf.x(this.rv).rv(), nf.x(this.rv).tj(), (com.byazt.ep.s) null);
                }
            } else {
                jSONObjectN = com.byazt.ns.qg.n(this.t, this.ur, this.cy, this.rv, z);
            }
            if (nf.x(this.rv) != null) {
                com.byazt.vyf.qg.n().n(nf.x(this.rv).qg());
            }
            if (nf.fs(this.rv) != null) {
                com.byazt.vyf.qg.n().n(nf.fs(this.rv).n());
            }
        }
        this.bb = qg(jSONObjectN);
        if (d()) {
            this.lq = new py();
        } else {
            this.lq = new cp(this.bb, this.x, this.rv, this.h);
        }
        boolean zT = t();
        if (nf.cp(this.rv) || nf.oa(this.rv) || com.byazt.xfl.n.qg(this.rv) || h()) {
            com.byazt.gn.s.n nVar2 = new com.byazt.gn.s.n();
            nVar2.l(com.byazt.ep.cp.n(this.rv, (View) this, false));
            nVar2.n((com.byazt.vh.ou) this.lq);
            nVar2.n(this.t);
            nVar2.qg(this.ur);
            nVar2.l(h());
            nVar2.cp(1);
            nVar = nVar2;
        } else {
            nVar = new com.byazt.udb.oa.n();
        }
        nVar.s(zRv);
        if (TextUtils.equals(this.x, "splash_ad")) {
            nVar.w(com.byazt.ql.qg.l());
        }
        if (nf.s(this.rv) == 3 && com.byazt.aci.n.q(this.rv) && (listJo = this.rv.jo()) != null && !listJo.isEmpty() && (vVar = listJo.get(0)) != null) {
            nVar.rv(vVar.n());
            nVar.n(new UpieImageView(this.w, com.byazt.aci.n.tj(this.rv), com.byazt.du.n.n(this.rv), com.byazt.aci.n.d(this.rv)));
        }
        this.ci = nVar.n(this.x).qg(this.rv.q()).s(com.byazt.vgx.w.wm(this.rv)).q(this.rv.F_()).n(jSONObjectN).n(this.lq).n(com.byazt.nf.rv.qg().n(this.x, nf.s(this.rv))).qg(zT).qg(this.rv.qh()).s(this.rv.rv()).l(com.byazt.ns.qg.q(this.rv)).n(com.byazt.ns.qg.l(this.rv)).q(getRenderThread()).l(this.rv.mp()).w(this.rv.im()).x(this.rv.eu()).qg(this.rv.kv()).s(this.rv.rk()).q(this.rv.bs()).rv(this.rv.on()).fs(this.rv.qd()).x(this.rv.fw()).fs("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").n(com.byazt.vyf.s.cy().q()).tj(this.rv.v()).q(com.byazt.nf.rv.qg().kn()).n();
    }

    private int getRenderThread() {
        if (ur() && com.byazt.nf.rv.qg().x(com.byazt.vgx.w.cy(this.rv)) == 4) {
            return 1;
        }
        if ((com.byazt.ed.q.n().d() & 2) == 2) {
            return 1;
        }
        return nf.l(this.rv);
    }

    private boolean h() {
        return this.fs != null && com.byazt.nf.tj.l >= 5900 && this.fs.h();
    }

    private boolean t() {
        if (TextUtils.equals(this.x, "rewarded_video") || TextUtils.equals(this.x, "fullscreen_interstitial_ad")) {
            return this.rv.yv();
        }
        return true;
    }

    private com.byazt.vgn.q qg(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.vgn.w wVar = new com.byazt.vgn.w(this.x, this.rv, jSONObject2, jSONObject);
        wVar.n(jSONObject2, "webview_source", (Object) 1);
        return wVar;
    }

    private boolean ur() {
        return TextUtils.equals(this.x, "splash_ad") || TextUtils.equals(this.x, "cache_splash_ad");
    }

    private void bb() {
        this.qg = nf.s(this.rv);
        if (ur() && nf.n(this.rv) == 1) {
            this.qg = 1000;
        }
        com.byazt.ys.s sVar = new com.byazt.ys.s(this.rv, new WeakReference(this));
        int i = this.qg;
        if (i == 3) {
            com.byazt.udb.qg qgVar = new com.byazt.udb.qg(this.w, this.ci, this.y, this.a, new com.byazt.hkc.x(), this, sVar);
            this.pe = qgVar;
            this.ri.add(qgVar);
            this.pe.n(com.byazt.nf.rv.qg().em());
        } else if (i == 7) {
            com.byazt.gn.w wVar = new com.byazt.gn.w(this.w, this.rv, (com.byazt.gn.s) this.ci, this);
            this.ln = wVar.cp();
            com.byazt.gn.x xVar = new com.byazt.gn.x(this.w, wVar, this, this.ci, this);
            this.yw = xVar;
            this.ri.add(xVar);
        } else if (i == 10) {
            com.byazt.gn.fs fsVar = new com.byazt.gn.fs(this.w, this.rv, (com.byazt.gn.s) this.ci, this);
            this.dh = fsVar;
            this.ln = fsVar.cp();
            this.yw = new com.byazt.gn.x(this.w, this.dh, this, this.ci, this);
            if (nf.n(com.byazt.vgx.w.d(this.rv))) {
                this.dh.n(new com.byazt.vh.fs() { // from class: com.byazt.za.NativeExpressView.9
                    @Override // com.byazt.vh.fs
                    public void qg(com.byazt.vh.rv.n nVar) {
                    }

                    @Override // com.byazt.vh.fs
                    public void n(com.byazt.vh.rv.n nVar) {
                        try {
                            l.n(nVar.w(), NativeExpressView.this.ci.l());
                        } catch (Exception unused) {
                        }
                    }
                });
            }
            this.ri.add(this.yw);
        } else if (i != 1000) {
            this.rf = new bb(this.w, this.ci, this.y, this.bb, this.rv, this.lq, this);
            com.byazt.udb.cy cyVar = new com.byazt.udb.cy(this.w, this.ci, this.rf, this);
            this.nf = cyVar;
            this.ri.add(cyVar);
        }
        int iQ = nf.q(this.rv);
        if (iQ > 0 && h() && TextUtils.equals(this.x, com.byazt.wg.qg.AD_TAG_FEED)) {
            this.ri.add(new com.byazt.gn.x(this.w, new com.byazt.xfl.s(this.w, this.rv, (com.byazt.gn.s) this.ci, this), this, this.ci, this));
        } else {
            boolean z = iQ == 1;
            this.n = z;
            if (z || this.qg == 1000) {
                com.byazt.udb.w wVar2 = new com.byazt.udb.w(this.w, this.ci, new a(this, this.y, this.ci));
                this.e = wVar2;
                this.ri.add(wVar2);
            } else if (com.byazt.xfl.n.qg(this.rv)) {
                this.ri.add(new com.byazt.gn.x(this.w, new com.byazt.xfl.s(this.w, this.rv, (com.byazt.gn.s) this.ci, this), this, this.ci, this));
            }
        }
        this.b = new com.byazt.udb.d(this.ri, this.lq);
    }

    public void setVideoAdListener(com.byazt.iag.s.q qVar) {
        this.d = qVar;
    }

    public void setVideoAdInteractionListener(com.byazt.iag.s.InterfaceC0200s interfaceC0200s) {
        this.oa = interfaceC0200s;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar != null && (qVar instanceof a) && (backupView = (BackupView) qVar.w()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.q = dialog;
        pk pkVar = this.rv;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), dialog, Dialog.class);
        }
    }

    public void setDislike(com.byazt.wg.qg qgVar) {
        BackupView backupView;
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar != null && (qVar instanceof a) && (backupView = (BackupView) qVar.w()) != null) {
            backupView.setDislikeInner(qgVar);
        }
        this.s = qgVar;
        pk pkVar = this.rv;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), qgVar, com.byazt.wg.qg.class);
        }
    }

    public void setExpressInteractionListener(n nVar) {
        this.l = nVar;
    }

    public void setClickCreativeListener(com.byazt.ys.n nVar) {
        this.wm = nVar;
    }

    public com.byazt.ys.n getClickCreativeListener() {
        return this.wm;
    }

    public com.byazt.ys.qg getClickListener() {
        return this.m;
    }

    public void setClickListener(com.byazt.ys.qg qgVar) {
        this.m = qgVar;
    }

    public void setBackupListener(com.byazt.udb.s sVar) {
        this.hd = sVar;
        com.byazt.udb.w wVar = this.e;
        if (wVar != null) {
            wVar.n(sVar);
        }
    }

    public void k() {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar instanceof k) {
            ((k) qVar).x();
        } else if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).um();
        }
        ln();
    }

    private void ln() {
        if (d()) {
            return;
        }
        m();
    }

    public void w(int i) {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar != null && (qVar instanceof k)) {
            ((k) qVar).qg(i);
        }
        fs(i);
    }

    private void fs(int i) {
        com.byazt.ivn.w wVarQg;
        if ((this.ic instanceof com.byazt.gn.w) && this.rv != null && (wVarQg = com.byazt.nf.rv.qg()) != null && wVarQg.du()) {
            ((com.byazt.gn.w) this.ic).s(i == 0);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.sh);
        removeCallbacks(this.wo);
        if (i == 0) {
            postDelayed(this.wo, 50L);
        } else {
            postDelayed(this.sh, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l(z ? 53 : 54);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        bb bbVar = this.rf;
        if (bbVar != null) {
            bbVar.s(z);
        }
    }

    public void qg(boolean z) {
        bb bbVar = this.rf;
        if (bbVar != null) {
            bbVar.q(z);
        }
    }

    public void x(int i) {
        this.ci.n(i);
    }

    public void cy() {
        if (com.byazt.nf.rv.qg().uc() && this.he) {
            if (this.l != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.l.n(this, com.byazt.bxg.n.n(-16), -16);
                    return;
                } else {
                    com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.za.NativeExpressView.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativeExpressView.this.l != null) {
                                NativeExpressView.this.l.n(NativeExpressView.this, com.byazt.bxg.n.n(-16), -16);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (com.byazt.nf.rv.qg().em() && com.byazt.ag.qg.n()) {
            com.byazt.tk.rv.s().post(new Runnable() { // from class: com.byazt.za.NativeExpressView.11
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.lh();
                }
            });
        } else {
            lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        com.byazt.vgn.q qVar = this.bb;
        if (qVar instanceof com.byazt.vgn.w) {
            ((com.byazt.vgn.w) qVar).qg(this.ci.fs());
        }
        this.bb.q();
        this.b.n(this);
        this.b.n();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cd cdVar;
        if (h() && (cdVar = this.hf) != null) {
            return cdVar.n(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        cd cdVar;
        if (h() && (cdVar = this.hf) != null) {
            return cdVar.qg(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        SparseArray<com.byazt.ys.l.n> sparseArray;
        com.byazt.ys.n nVar = this.wm;
        int i2 = 0;
        if (nVar != null) {
            nVar.s(motionEvent.getDeviceId());
            this.wm.qg(motionEvent.getSource());
            this.wm.q(motionEvent.getToolType(0));
        }
        com.byazt.ys.qg qgVar = this.m;
        if (qgVar != null) {
            qgVar.s(motionEvent.getDeviceId());
            this.m.qg(motionEvent.getSource());
            this.m.q(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.vb = motionEvent.getRawX();
            this.fl = motionEvent.getRawY();
            this.su = System.currentTimeMillis();
        } else {
            i2 = 3;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    i2 = actionMasked != 3 ? -1 : 4;
                } else {
                    this.i += Math.abs(motionEvent.getX() - this.vb);
                    this.dw += Math.abs(motionEvent.getY() - this.fl);
                    this.vb = motionEvent.getX();
                    this.fl = motionEvent.getY();
                    i = (System.currentTimeMillis() - this.su <= 200 || (this.i <= 8.0f && this.dw <= 8.0f)) ? 2 : 1;
                }
            }
            sparseArray = this.el;
            if (sparseArray != null) {
                sparseArray.put(motionEvent.getActionMasked(), new com.byazt.ys.l.n(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        i = i2;
        sparseArray = this.el;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.byazt.ys.l.n(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void n(View view, int i, com.byazt.twc.s sVar, kc kcVar) {
        this.lh = kcVar;
        n(view, i, sVar, -1);
        this.lh = null;
    }

    @Override // com.byazt.li.qg
    public boolean n(String str, com.byazt.ih.s sVar, com.byazt.li.s sVar2) {
        str.hashCode();
        switch (str) {
            case "clickEvent":
            case "convert":
                n(sVar, sVar2, 2);
                return true;
            case "resumeVideo":
                n(3);
                return true;
            case "pauseVideo":
                n(2);
                return true;
            case "skip":
                w();
                return true;
            case "close":
                x();
                return true;
            case "videoControl":
                n(sVar, sVar2, 4);
                return true;
            case "muteVideo":
                n(!this.a);
                return true;
            case "interactiveFinish":
                n(sVar2);
                return true;
            case "dislike":
                rv();
                return true;
            default:
                return false;
        }
    }

    private void n(com.byazt.ih.s sVar, com.byazt.li.s sVar2, int i) {
        CharSequence text;
        com.byazt.gct.tj tjVar = (com.byazt.gct.tj) sVar2.n("ugen_click_event_params", com.byazt.gct.tj.class);
        com.byazt.gct.wm.n nVarN = new com.byazt.gct.wm.n().q(tjVar.cd()).s(tjVar.um()).qg(tjVar.a()).n(tjVar.py()).n(sVar.v()).qg(tjVar.cy()).n(tjVar.hd()).n(sVar2.n("is_slide_trigger_by_cancel", false) ? (byte) 7 : com.byazt.gn.fs.qg(sVar2.n("v3_trigger_name")));
        JSONObject jSONObject = new JSONObject();
        int iN = sVar2.n("convert_action_type", 0);
        if (iN > 0) {
            try {
                jSONObject.put("convertActionType", iN);
            } catch (Throwable unused) {
            }
        }
        View viewRv = sVar.rv();
        try {
            if ((viewRv instanceof TextView) && (text = ((TextView) viewRv).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        nVarN.n(jSONObject);
        n(viewRv, i, nVarN.n(), -1);
    }

    public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
        com.byazt.gct.tj tjVar;
        com.byazt.fq.n nVar;
        com.byazt.ys.n nVar2;
        com.byazt.ys.qg qgVar;
        if (i == -1 || sVar == null) {
            return;
        }
        com.byazt.gct.wm wmVar = (com.byazt.gct.wm) sVar;
        com.byazt.ys.n nVar3 = this.wm;
        if (nVar3 != null) {
            nVar3.l(getDynamicShowType());
        }
        com.byazt.ys.qg qgVar2 = this.m;
        if (qgVar2 != null) {
            qgVar2.l(getDynamicShowType());
        }
        if (i != 1 || (qgVar = this.m) == null) {
            tjVar = null;
            nVar = null;
        } else {
            tjVar = qgVar.qg();
            nVar = (com.byazt.fq.n) this.m.n(com.byazt.fq.n.class);
            nVar.n(nVar.l());
        }
        if (i == 2 && (nVar2 = this.wm) != null) {
            tjVar = nVar2.qg();
            nVar = (com.byazt.fq.n) this.wm.n(com.byazt.fq.n.class);
            nVar.n(nVar.l());
        }
        try {
            Object obj = wmVar.n().get("click_extra_map");
            if (nVar != null && (obj instanceof Map)) {
                nVar.n((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (tjVar == null) {
            tjVar = new com.byazt.gct.tj();
        }
        if (this.lh != null) {
            tjVar.qg(this);
        }
        tjVar.n(wmVar.n);
        tjVar.qg(wmVar.qg);
        tjVar.s(wmVar.s);
        tjVar.q(wmVar.q);
        tjVar.qg(wmVar.k);
        tjVar.x(wmVar.um);
        tjVar.n(com.byazt.gct.py.n(this.rv, wmVar.cd));
        tjVar.qg(wmVar.cd);
        tjVar.n(wmVar.cy);
        tjVar.qg(getShowDLFactorsEventParams());
        SparseArray<com.byazt.ys.l.n> sparseArray = wmVar.hd;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.el;
        }
        tjVar.n(sparseArray);
        JSONObject jSONObjectN = wmVar.n();
        tjVar.q(jSONObjectN.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectN.optString("uchain_event_name");
        tjVar.s(strOptString);
        tjVar.n(this.ou);
        int iOptInt = jSONObjectN.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.byazt.ys.n nVar4 = this.wm;
                if (nVar4 != null) {
                    nVar4.s();
                }
            } else {
                com.byazt.ys.qg qgVar3 = this.m;
                if (qgVar3 != null) {
                    qgVar3.s();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.byazt.ys.n nVar5 = this.wm;
                if (nVar5 != null) {
                    nVar5.q();
                }
            } else {
                com.byazt.ys.qg qgVar4 = this.m;
                if (qgVar4 != null) {
                    qgVar4.q();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = wmVar.cp;
        pk pkVar = this.rv;
        int iRv = pkVar != null ? pkVar.rv() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.sz;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                n(view2, wmVar, tjVar, 0, str, iRv, i2);
                break;
            case 2:
                n(view2, wmVar, tjVar, str, iRv, i2);
                break;
            case 3:
                rv();
                break;
            case 4:
                FrameLayout frameLayout2 = this.sz;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.byazt.vgx.w.ur(this.rv);
                if (com.byazt.wg.qg.AD_TAG_FEED.equals(this.x) && v() && !this.k && com.byazt.vgx.w.ur(this.rv)) {
                    n(view2, wmVar, tjVar, str, iRv, i2);
                } else {
                    n(view2, wmVar, tjVar, 0, str, iRv, i2);
                }
                break;
            case 5:
                n(!this.a);
                break;
            case 6:
                w();
                break;
            case 7:
                if (!com.byazt.vgx.w.n(strOptString, this.rv, this.w)) {
                    com.byazt.okk.n.n(this.w, this.rv);
                }
                break;
            case 8:
                x();
                break;
            case 9:
                qg(this.rv, this.w, this.x);
                break;
            case 10:
                n(this.rv, this.w, this.x);
                break;
            case 12:
                s(this.rv, this.w, this.x);
                break;
            case 13:
                String strOptString2 = jSONObjectN.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectN.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.q(this.w, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void n(View view, com.byazt.gct.wm wmVar, com.byazt.gct.tj tjVar, String str, int i, int i2) {
        if (pk.w(this.rv)) {
            return;
        }
        com.byazt.ys.n nVar = this.wm;
        if (nVar != null) {
            nVar.n(wmVar);
            qg(((com.byazt.zct.n) this.m.n(com.byazt.zct.n.class)).n(), i2);
            com.byazt.fq.n nVar2 = (com.byazt.fq.n) this.wm.n(com.byazt.fq.n.class);
            n(nVar2);
            nVar2.qg(str);
            this.wm.n(tjVar);
            Map<String, Object> mapN = com.byazt.wu.n.n().n(this.rv.hashCode() + this.rv.ou());
            mapN.put("convert_tag", wmVar.cd);
            mapN.put("dpa_convert", com.byazt.gct.py.q(this.rv.oa(), wmVar.cd));
            n(wmVar, mapN);
            this.wm.n(view, tjVar);
        }
        rv(i);
    }

    public void n(com.byazt.gct.wm wmVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(wmVar.n().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void n(com.byazt.fq.n nVar) {
        kc kcVar = this.lh;
        if (kcVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(kcVar.qg()));
            map.put("express_slide_direction", Integer.valueOf(kcVar.q()));
            map.put("express_slide_threshold", Double.valueOf(kcVar.s()));
            nVar.n(map);
        }
    }

    private void n(View view, com.byazt.gct.wm wmVar, com.byazt.gct.tj tjVar, int i, String str, int i2, int i3) {
        if (pk.w(this.rv)) {
            return;
        }
        com.byazt.ys.qg qgVar = this.m;
        if (qgVar != null) {
            qgVar.n(wmVar);
            qg(((com.byazt.zct.n) this.m.n(com.byazt.zct.n.class)).n(), i3);
            com.byazt.fq.n nVar = (com.byazt.fq.n) this.m.n(com.byazt.fq.n.class);
            n(nVar);
            nVar.qg(str);
            this.m.n(tjVar);
            Map<String, Object> mapN = com.byazt.wu.n.n().n(this.rv.hashCode() + this.rv.ou());
            mapN.put("convert_tag", wmVar.cd);
            mapN.put("dpa_convert", com.byazt.gct.py.q(this.rv.oa(), wmVar.cd));
            n(wmVar, mapN);
            this.m.n(view, tjVar);
        }
        rv(i2);
    }

    public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
        if (i == -1 || sVar == null) {
            return;
        }
        com.byazt.gct.wm wmVar = (com.byazt.gct.wm) sVar;
        com.byazt.gct.tj tjVar = new com.byazt.gct.tj();
        tjVar.n(wmVar.hd);
        tjVar.n(wmVar.n);
        tjVar.qg(wmVar.qg);
        tjVar.s(wmVar.s);
        tjVar.q(wmVar.q);
        tjVar.qg(wmVar.k);
        JSONObject jSONObjectN = wmVar.n();
        int iOptInt = jSONObjectN.optInt("convertActionType", Integer.MIN_VALUE);
        tjVar.q(jSONObjectN.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.wm.s();
            } else {
                this.m.s();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.wm.q();
            } else {
                this.m.q();
            }
        }
        View view2 = view == null ? this : view;
        com.byazt.ys.n nVar = this.wm;
        if (nVar != null) {
            nVar.l(getDynamicShowType());
        }
        com.byazt.ys.qg qgVar = this.m;
        if (qgVar != null) {
            qgVar.l(getDynamicShowType());
        }
        pk pkVar = this.rv;
        int iRv = pkVar != null ? pkVar.rv() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.sz;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                n(view2, i2, wmVar, tjVar, iRv);
                break;
            case 2:
                qg(view2, i2, wmVar, tjVar, iRv);
                break;
            case 3:
                rv();
                break;
            case 4:
                FrameLayout frameLayout2 = this.sz;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.byazt.vgx.w.ur(this.rv);
                if (com.byazt.wg.qg.AD_TAG_FEED.equals(this.x) && v() && !this.k && com.byazt.vgx.w.ur(this.rv)) {
                    qg(view2, i2, wmVar, tjVar, iRv);
                } else {
                    n(view2, i2, wmVar, tjVar, iRv);
                }
                break;
            case 5:
                n(!this.a);
                break;
            case 6:
                w();
                break;
            case 8:
                x();
                break;
        }
    }

    private void n(View view, int i, com.byazt.gct.wm wmVar, com.byazt.gct.tj tjVar, int i2) {
        if (pk.w(this.rv)) {
            return;
        }
        com.byazt.ys.qg qgVar = this.m;
        if (qgVar != null) {
            n(((com.byazt.zct.n) qgVar.n(com.byazt.zct.n.class)).n(), i);
            this.m.n(wmVar);
            this.m.n(tjVar);
            this.m.n(view, tjVar);
        }
        rv(i2);
    }

    private void qg(View view, int i, com.byazt.gct.wm wmVar, com.byazt.gct.tj tjVar, int i2) {
        if (pk.w(this.rv)) {
            return;
        }
        com.byazt.ys.n nVar = this.wm;
        if (nVar != null) {
            n(((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(), i);
            this.wm.n(wmVar);
            this.wm.n(tjVar);
            this.wm.n(view, tjVar);
        }
        rv(i2);
    }

    private void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter, int i) {
        if (iTTInnerDownloadAdapter == null) {
            return;
        }
        if (iTTInnerDownloadAdapter instanceof com.byazt.oh.n) {
            com.byazt.wif.s sVarN = ((com.byazt.oh.n) iTTInnerDownloadAdapter).n();
            sVarN.qg(true);
            sVarN.n(i);
        }
        iTTInnerDownloadAdapter.setShowDLFactorsCard(this.df.get());
    }

    private void qg(ITTInnerDownloadAdapter iTTInnerDownloadAdapter, int i) {
        if (iTTInnerDownloadAdapter == null) {
            return;
        }
        if (iTTInnerDownloadAdapter instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapter).n().qg(i);
        }
        iTTInnerDownloadAdapter.setShowDLFactorsCard(this.df.get());
    }

    private boolean v() {
        pk pkVar = this.rv;
        return pkVar != null && pkVar.il() == 1 && pk.s(this.rv);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.tk.k.qg("webviewpool", "onAttachedToWindow+++");
        l(51);
        getViewTreeObserver().addOnScrollChangedListener(this.u);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.byazt.tk.k.qg("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        l(55);
    }

    public void hd() {
        bb bbVar = this.rf;
        if (bbVar == null || bbVar.w() == null) {
            return;
        }
        this.rf.q();
    }

    public void cd() {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).a();
        } else if (qVar instanceof bb) {
            ((bb) qVar).k();
        }
    }

    public void oa() {
        s(true);
    }

    public void s(boolean z) {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            com.byazt.udb.q<? extends View> qVar = this.ic;
            if (qVar instanceof com.byazt.gn.w) {
                qVar.n(z);
            }
            if (this.rv != null) {
                try {
                    com.byazt.sx.q.n().n(this.rv.py());
                } catch (Throwable unused) {
                }
            }
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.byazt.udb.tj> it = this.ri.iterator();
            while (it.hasNext()) {
                it.next().qg(z);
            }
            this.s = null;
            this.q = null;
            this.fs = null;
            this.rv = null;
            this.wm = null;
            this.hd = null;
            this.m = null;
            this.d = null;
            this.oa = null;
            this.l = null;
            Context context = this.w;
            if (context != null && (themeStatusBroadcastReceiver = this.y) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.cp;
            if (expressVideoView != null) {
                expressVideoView.ou();
            }
            View view = this.ha;
            if (view != null) {
                view.removeCallbacks(this.dg);
            }
            this.f.n(56);
        } catch (Throwable th) {
            com.byazt.tk.k.n("NativeExpressView", "detach error", th);
        }
    }

    public void um() {
        try {
            FrameLayout frameLayout = this.sz;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.sz);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.byazt.vgn.q qVar = this.bb;
            if (qVar != null) {
                qVar.qg(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.u);
        } catch (Exception unused) {
        }
        com.byazt.tk.k.qg("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.byazt.tk.k.qg("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // com.byazt.udb.k
    public void n(final com.byazt.udb.q<? extends View> qVar, final com.byazt.udb.sz szVar) {
        this.he = true;
        this.fi.set(true);
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.NativeExpressView.12
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.qg(qVar, szVar);
            }
        });
    }

    private float s(pk pkVar) {
        return (com.byazt.oh.l.l(pkVar) && com.byazt.iz.n.q(pkVar)) ? 56.0f : 0.0f;
    }

    private void n(pk pkVar, com.byazt.gct.q qVar) {
        FrameLayout frameLayout = this.oj;
        if (frameLayout != null && frameLayout.getParent() != null) {
            removeView(this.oj);
        }
        int iD = com.byazt.vgx.w.d(pkVar);
        FrameLayout frameLayoutN = com.byazt.oh.l.n(getContext(), pkVar, qVar, iD);
        this.oj = frameLayoutN;
        frameLayoutN.setBackgroundColor(Color.parseColor("#161823"));
        float fS = s(pkVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.byazt.okk.s.s(getContext(), fS));
        float f = this.ur;
        float f2 = (f - fS) / f;
        layoutParams.gravity = iD == 8 ? 48 : 80;
        int iS = com.byazt.okk.s.s(getContext(), this.ur);
        this.oj.setVisibility(4);
        removeView(this.py);
        removeView(this.an);
        FrameLayout frameLayout2 = this.j;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            removeView(this.j);
        } else {
            this.j = new FrameLayout(this.w);
        }
        this.j.addView(this.py);
        this.j.addView(this.an);
        addView(this.j, 0);
        this.j.setBackgroundColor(0);
        this.j.setPivotX(0.0f);
        if (this.an.getHeight() != 0) {
            iS = this.an.getHeight();
        }
        this.j.setPivotY(iD == 8 ? iS : 0.0f);
        this.j.setScaleY(f2);
        addView(this.oj, layoutParams);
    }

    private boolean q(pk pkVar) {
        if (pkVar == null) {
            return true;
        }
        if (com.byazt.vgx.w.d(pkVar) != 8) {
            return this.ur == 0.0f;
        }
        if (pkVar.sl() == 0.0f || pkVar.sl() == 100.0f) {
            return ((float) (this.an.getHeight() == 0 ? com.byazt.okk.s.s(getContext(), this.ur) : this.an.getHeight())) <= 0.0f;
        }
        return true;
    }

    private void l(pk pkVar) {
        try {
            if (com.byazt.oh.l.w(pkVar) && !q(pkVar)) {
                if (!com.byazt.iz.n.q(pkVar)) {
                    q(false);
                    return;
                } else {
                    w(pkVar);
                    return;
                }
            }
            q(false);
        } catch (Exception e) {
            com.byazt.eji.s.n().n("express_dl", e);
            q(false);
        }
    }

    private void w(final pk pkVar) {
        if (pkVar == null) {
            q(false);
            return;
        }
        if (com.byazt.oh.l.n(pkVar) == 0) {
            qg(pkVar, (com.byazt.gct.q) null);
            return;
        }
        com.byazt.gct.q qVarN = com.byazt.iz.n.n(pkVar);
        if (qVarN != null) {
            if (qVarN.x()) {
                qg(pkVar, qVarN);
                return;
            } else {
                q(false);
                return;
            }
        }
        final com.byazt.gct.l lVarK = pkVar.k();
        if (lVarK == null) {
            q(false);
        } else {
            com.byazt.ag.qg.n(new com.byazt.qit.x("pl_dlf") { // from class: com.byazt.za.NativeExpressView.13
                @Override // java.lang.Runnable
                public void run() {
                    final com.byazt.gct.q qVarN2 = com.byazt.nf.rv.n().n(NativeExpressView.this.rv, lVarK.qg());
                    com.byazt.ag.qg.n((Runnable) new com.byazt.qit.x("pl_udlf") { // from class: com.byazt.za.NativeExpressView.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.gct.q qVar = qVarN2;
                            if (qVar == null || !qVar.x()) {
                                NativeExpressView.this.q(false);
                                return;
                            }
                            try {
                                NativeExpressView.this.qg(pkVar, qVarN2);
                            } catch (Exception e) {
                                com.byazt.eji.s.n().n("express_dl", e);
                                NativeExpressView.this.q(false);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(pk pkVar, com.byazt.gct.q qVar) {
        n(pkVar, qVar);
        q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z) {
        com.byazt.gcl.s sVarX_;
        this.df.set(z);
        FrameLayout frameLayout = this.oj;
        if (frameLayout != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.byazt.za.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeExpressView.this.oj != null) {
                        NativeExpressView.this.oj.setVisibility(z ? 0 : 8);
                    }
                }
            }, 10L);
        }
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar == null || !(qVar instanceof bb) || (sVarX_ = ((bb) qVar).x_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
            sVarX_.qg("isShow7Factors", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void qg(com.byazt.udb.q<? extends View> qVar, com.byazt.udb.sz szVar) {
        int iS;
        try {
            this.ic = qVar;
            this.cx = szVar;
            if (qVar.qg() != 1) {
                View viewW = qVar.w();
                this.ha = viewW;
                if (viewW.getParent() != null) {
                    ((ViewGroup) this.ha.getParent()).removeView(this.ha);
                }
                this.an.addView(this.ha);
                if (szVar.qg() == 10) {
                    if (szVar.l() == 0.0d) {
                        int iN = (int) nf.n(this.rv, szVar.q());
                        if (iN <= 0) {
                            iS = com.byazt.okk.s.w(getContext());
                        } else {
                            iS = com.byazt.okk.s.s(getContext(), iN);
                        }
                        this.ha.setLayoutParams(new FrameLayout.LayoutParams(-1, iS));
                    }
                    if (this.rv.vu() == 1) {
                        Runnable runnable = new Runnable() { // from class: com.byazt.za.NativeExpressView.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (NativeExpressView.this.ha != null) {
                                        View childAt = ((ViewGroup) NativeExpressView.this.ha).getChildAt(0);
                                        View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                                        if (childAt2.getMeasuredHeight() < childAt.getMeasuredHeight()) {
                                            NativeExpressView.this.ha.setLayoutParams(new FrameLayout.LayoutParams(-1, childAt2.getHeight()));
                                            NativeExpressView.this.an.requestLayout();
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        };
                        this.dg = runnable;
                        this.ha.post(runnable);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.ha.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                l(this.rv);
                if (this.z != null && (qVar instanceof com.byazt.gn.w) && !(qVar instanceof com.byazt.gn.fs)) {
                    this.z.n(((com.byazt.gn.w) qVar).tj());
                    this.z.n(this);
                }
            }
            com.byazt.udb.rv rvVar = this.lq;
            if (rvVar instanceof cp) {
                ((cp) rvVar).sz();
            }
            if (this.bb != null && qVar.qg() != 0) {
                this.bb.n(qVar.qg(), szVar.cp(), szVar.tj());
            }
            com.byazt.udb.q<? extends View> qVar2 = this.ic;
            if ((qVar2 instanceof cy) && ((cy) qVar2).x_() != null) {
                ((cy) this.ic).x_().n((d) this);
            }
            if (szVar.qg() == 10 && (szVar instanceof com.byazt.gn.q)) {
                this.v = ((com.byazt.gn.q) szVar).um();
            }
            n nVar = this.l;
            if (nVar != null) {
                nVar.n(this, (float) szVar.q(), (float) szVar.l());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void n(MotionEvent motionEvent) {
        View view = this.ha;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    public void a() {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (!(qVar instanceof com.byazt.gn.w) || (qVar instanceof com.byazt.gn.fs)) {
            return;
        }
        ((com.byazt.gn.w) qVar).q();
    }

    @Override // com.byazt.udb.k
    public void a_(final int i) {
        this.he = true;
        if (!this.n) {
            this.lq.cp();
        }
        this.lq.d();
        com.byazt.udb.rv rvVar = this.lq;
        if (rvVar instanceof cp) {
            ((cp) rvVar).sz();
        }
        if (this.l != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.l.n(this, com.byazt.bxg.n.n(i), i);
            } else {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.za.NativeExpressView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.l != null) {
                            NativeExpressView.this.l.n(NativeExpressView.this, com.byazt.bxg.n.n(i), i);
                        }
                    }
                });
            }
        }
    }

    public boolean py() {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        return qVar != null && qVar.qg() == 1;
    }

    public int getDynamicShowType() {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar != null) {
            return qVar.qg();
        }
        return 0;
    }

    public byte getShowDLFactorsEventParams() {
        if (!com.byazt.oh.l.w(this.rv)) {
            return (byte) -1;
        }
        boolean zQ = com.byazt.iz.n.q(this.rv);
        boolean z = this.df.get();
        if (zQ) {
            if (z) {
                return (byte) 3;
            }
            if (!py()) {
                return (byte) 1;
            }
        } else if (z) {
            return (byte) 2;
        }
        return (byte) 0;
    }

    public int getRenderEngineCacheType() {
        fs fsVarSz;
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (!(qVar instanceof bb) || (fsVarSz = ((bb) qVar).sz()) == null) {
            return 0;
        }
        return fsVarSz.n();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.t).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.ur).intValue();
    }

    public com.byazt.gcl.s getJsObject() {
        bb bbVar = this.rf;
        if (bbVar != null) {
            return bbVar.x_();
        }
        return null;
    }

    public com.byazt.gn.fs getUGenV3Render() {
        return this.dh;
    }

    public n getExpressInteractionListener() {
        return this.l;
    }

    @Override // com.byazt.tq.q
    public void n(CharSequence charSequence, int i, int i2, boolean z) {
        n(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    @Override // com.byazt.tq.q
    public void setSoundMute(boolean z) {
        this.a = z;
        com.byazt.udb.qg qgVar = this.pe;
        if (qgVar != null && qgVar.n() != null) {
            this.pe.n().setSoundMute(z);
        }
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar == null || qVar.qg() != 7) {
            return;
        }
        com.byazt.udb.q<? extends View> qVar2 = this.ic;
        if (qVar2 instanceof com.byazt.gn.w) {
            ((com.byazt.tq.q) qVar2).setSoundMute(z);
        }
    }

    public void n(int i, int i2, boolean z) {
        int iS;
        if (TextUtils.equals(this.x, "fullscreen_interstitial_ad")) {
            iS = (!com.byazt.gct.ur.n(this.rv) || com.byazt.gct.ur.qg(this.rv) <= 0) ? com.byazt.nf.rv.qg().q(Integer.parseInt(this.h)) : 0;
        } else if (!TextUtils.equals(this.x, "rewarded_video")) {
            return;
        } else {
            iS = com.byazt.nf.rv.qg().s(Integer.parseInt(this.h));
        }
        int i3 = (i2 >= iS || z) ? 1 : 0;
        int i4 = i2 <= iS ? iS - i2 : 0;
        com.byazt.udb.qg qgVar = this.pe;
        if (qgVar != null && qgVar.n() != null) {
            this.pe.n().n(String.valueOf(i), i3, i4, z);
        }
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar != null) {
            if (qVar.qg() == 7 || this.ic.qg() == 10) {
                com.byazt.udb.q<? extends View> qVar2 = this.ic;
                if (qVar2 instanceof com.byazt.gn.w) {
                    ((com.byazt.tq.q) qVar2).n(String.valueOf(i), i3, i4, z);
                }
            }
        }
    }

    private void n(pk pkVar, Context context, String str) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.okk.n.s(pkVar, context, str);
    }

    private void qg(pk pkVar, Context context, String str) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.okk.n.qg(pkVar, context, str);
    }

    private void s(pk pkVar, Context context, String str) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.okk.n.n(context, pkVar, str);
    }

    private void n(com.byazt.li.s sVar) {
        qg(com.byazt.vs.m.n(this.rv, sVar.n("reduce_duration", 0)));
    }

    public void n(boolean z) {
        if (this.ic.qg() == 7) {
            com.byazt.udb.q<? extends View> qVar = this.ic;
            if (qVar instanceof com.byazt.gn.w) {
                ((com.byazt.tq.q) qVar).setSoundMute(z);
            }
        }
    }

    public void w() {
        com.byazt.pi.s sVar = this.dn;
        if (sVar != null) {
            sVar.n();
        }
    }

    public void x() {
        if (h() && TextUtils.equals(this.x, com.byazt.wg.qg.AD_TAG_FEED)) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.byazt.oj.qg qgVar = new com.byazt.oj.qg(this.rv.pv(), com.byazt.yo.q.n());
            qgVar.qg(com.byazt.wg.qg.AD_TAG_DISLIKE);
            com.byazt.nnl.n.n().n(this.w, qgVar, "close_success");
            return;
        }
        if (h()) {
            return;
        }
        rv();
    }

    public void rv() {
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.wg.qg qgVar = this.s;
        if (qgVar != null) {
            qgVar.n();
        } else {
            TTDelegateActivity.n(getContext(), this.rv);
        }
    }

    public ViewGroup getVideoContainer() {
        return this.sz;
    }

    public ViewGroup getGameContainer() {
        if (this.cx instanceof com.byazt.gn.q) {
            return ((com.byazt.gn.q) this.cx).cd();
        }
        return null;
    }

    @Override // com.byazt.hne.n
    public void b_(int i) {
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar == null || !(qVar instanceof k)) {
            return;
        }
        ((k) qVar).b_(i);
    }

    public void qg(int i, String str) {
        com.byazt.gcl.s sVarX_;
        com.byazt.udb.q<? extends View> qVar = this.ic;
        if (qVar == null || !(qVar instanceof bb) || (sVarX_ = ((bb) qVar).x_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            sVarX_.qg("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void n(JSONObject jSONObject) {
        boolean zM = com.byazt.nf.rv.qg().m();
        this.kc = zM;
        if (zM && com.byazt.vgx.w.l(this.rv)) {
            this.z = new wm(this.rv, jSONObject, this);
        }
    }

    public void ou() {
        wm wmVar = this.z;
        if (wmVar != null) {
            wmVar.q();
        }
    }

    public void setEasyPlayableSender(com.byazt.rg.l lVar) {
        ExpressVideoView expressVideoView = this.cp;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(lVar);
    }

    public ExpressVideoView getExpressVideoView() {
        return this.cp;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.ae;
    }

    public void setDynamicSkipListener(com.byazt.pi.s sVar) {
        this.dn = sVar;
    }

    public void qg(int i, int i2) {
        com.byazt.ve.n nVar = this.v;
        if (nVar != null) {
            nVar.n(i, i2);
        }
    }

    @Override // com.byazt.za.hd
    public void qg(pk pkVar) {
        if (pkVar != null) {
            l(pkVar);
        }
    }

    public void n(com.byazt.mkl.n nVar) {
        com.byazt.gn.fs fsVar = this.dh;
        if (fsVar != null) {
            fsVar.n(nVar);
        }
        bb bbVar = this.rf;
        if (bbVar != null) {
            bbVar.n(nVar);
        }
    }

    private void rv(final int i) {
        if (com.byazt.nf.rv.qg().nm()) {
            if (this.l != null) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.NativeExpressView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.l != null) {
                            NativeExpressView.this.l.n(NativeExpressView.this, i);
                        }
                    }
                }, 100L);
            }
        } else {
            n nVar = this.l;
            if (nVar != null) {
                nVar.n(this, i);
            }
        }
    }
}
