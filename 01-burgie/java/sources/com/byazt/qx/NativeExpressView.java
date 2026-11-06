package com.byazt.qx;

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
import com.byazt.fj.SSWebView;
import com.byazt.hg.ie;
import com.byazt.hg.mw;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.byazt.hg.y;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.oc.UpieImageView;
import com.byazt.sd.nl;
import com.byazt.sd.ww;
import com.byazt.wt.er;
import com.byazt.wt.ls;
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
@com.byazt.vzx.pr(pr = {0, 1, 49, 2038})
public class NativeExpressView extends FrameLayout implements com.byazt.imd.x, com.byazt.mq.ho, com.byazt.mq.zo, com.byazt.mo.pr, nt, w, com.byazt.fy.hw {
    public static int qa = 500;
    public boolean a;
    public SparseArray<com.byazt.az.x.pr> aa;
    public of aj;
    public String b;
    public long bh;
    public com.byazt.mq.nt bm;
    public pr c;
    public float cr;
    public FrameLayout cz;
    public boolean d;
    public FrameLayout e;
    public final AtomicBoolean er;
    public List<com.byazt.mq.vk> f;
    public com.byazt.az.pr fo;
    public String fw;
    public FrameLayout g;
    public yb gu;
    public com.byazt.ko.pr gz;
    public com.byazt.pfl.hw hn;
    public boolean ho;
    public ThemeStatusBroadcastReceiver hs;
    public int hw;
    public final Runnable i;
    public com.byazt.gu.fw ie;
    public final Runnable ii;
    public float iu;
    public float iy;
    public float j;
    public com.byazt.mq.hw jn;
    public com.byazt.ck.hn jw;
    public com.byazt.w.hn.x k;
    public com.byazt.mq.uc l;
    public boolean lb;
    public final com.byazt.pj.hw ls;
    public com.byazt.gu.uc lv;
    public com.byazt.w.hn.InterfaceC0220hn m;
    public com.byazt.mq.x<? extends View> mw;
    public FrameLayout n;
    public boolean nl;
    public boolean nt;
    public b nw;
    public boolean ny;
    public com.byazt.mq.vk.pr o;
    public volatile com.byazt.mq.g od;
    public final ViewTreeObserver.OnScrollChangedListener of;
    public View pj;
    public ny pq;
    public boolean pr;
    public FrameLayout qi;
    public Runnable qn;
    public float qo;
    public final Runnable r;
    public com.byazt.az.hw rc;
    public FrameLayout s;
    public com.byazt.mq.m sv;
    public final Context uc;
    public final AtomicBoolean v;
    public float ve;
    public com.byazt.mq.aj vj;
    public String vk;
    public ExpressVideoView w;
    public boolean wt;
    public com.byazt.bk.pr ww;
    public Dialog x;
    public mw y;
    public com.byazt.mq.hn yb;
    public final AtomicBoolean z;
    public com.byazt.qe.hw zo;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.er.get() && this.ls.pr()) {
            this.ls.pr(ww.hw(this), i);
        }
    }

    public NativeExpressView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str) {
        super(context);
        this.pr = true;
        this.hw = 0;
        this.fw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.z = new AtomicBoolean(false);
        this.b = null;
        this.nt = false;
        this.lb = false;
        this.a = false;
        this.nl = false;
        this.er = new AtomicBoolean(false);
        this.ny = false;
        this.v = new AtomicBoolean(false);
        this.of = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.qx.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.c(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ii);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ii, 500L);
            }
        };
        this.ii = new Runnable() { // from class: com.byazt.qx.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ww.hw(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.uc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.uc(8);
                }
            }
        };
        this.i = new Runnable() { // from class: com.byazt.qx.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(0);
            }
        };
        this.r = new Runnable() { // from class: com.byazt.qx.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(8);
            }
        };
        this.aa = new SparseArray<>();
        this.iy = -1.0f;
        this.cr = -1.0f;
        this.j = -1.0f;
        this.qo = -1.0f;
        this.bh = 0L;
        this.fw = str;
        this.uc = context;
        this.aj = ofVar;
        this.ls = new com.byazt.pj.hw(ofVar, str);
        this.zo = hwVar;
        w();
    }

    public NativeExpressView(boolean z, Context context, of ofVar, com.byazt.qe.hw hwVar, String str, boolean z2) {
        super(context);
        this.pr = true;
        this.hw = 0;
        this.fw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.z = new AtomicBoolean(false);
        this.b = null;
        this.nt = false;
        this.lb = false;
        this.a = false;
        this.nl = false;
        this.er = new AtomicBoolean(false);
        this.ny = false;
        this.v = new AtomicBoolean(false);
        this.of = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.qx.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.c(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ii);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ii, 500L);
            }
        };
        this.ii = new Runnable() { // from class: com.byazt.qx.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ww.hw(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.uc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.uc(8);
                }
            }
        };
        this.i = new Runnable() { // from class: com.byazt.qx.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(0);
            }
        };
        this.r = new Runnable() { // from class: com.byazt.qx.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(8);
            }
        };
        this.aa = new SparseArray<>();
        this.iy = -1.0f;
        this.cr = -1.0f;
        this.j = -1.0f;
        this.qo = -1.0f;
        this.bh = 0L;
        this.fw = str;
        this.uc = context;
        this.aj = ofVar;
        this.ls = new com.byazt.pj.hw(ofVar, str);
        this.zo = hwVar;
        this.nt = z;
        this.a = z2;
        w();
    }

    public NativeExpressView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str, boolean z) {
        super(context);
        this.pr = true;
        this.hw = 0;
        this.fw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.z = new AtomicBoolean(false);
        this.b = null;
        this.nt = false;
        this.lb = false;
        this.a = false;
        this.nl = false;
        this.er = new AtomicBoolean(false);
        this.ny = false;
        this.v = new AtomicBoolean(false);
        this.of = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.qx.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.c(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ii);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ii, 500L);
            }
        };
        this.ii = new Runnable() { // from class: com.byazt.qx.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ww.hw(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.uc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.uc(8);
                }
            }
        };
        this.i = new Runnable() { // from class: com.byazt.qx.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(0);
            }
        };
        this.r = new Runnable() { // from class: com.byazt.qx.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(8);
            }
        };
        this.aa = new SparseArray<>();
        this.iy = -1.0f;
        this.cr = -1.0f;
        this.j = -1.0f;
        this.qo = -1.0f;
        this.bh = 0L;
        this.fw = str;
        this.uc = context;
        this.aj = ofVar;
        this.ls = new com.byazt.pj.hw(ofVar, str);
        this.zo = hwVar;
        this.a = z;
        if (hwVar.a() == 9) {
            this.nt = hwVar.ho() == 2;
        }
        w();
    }

    public NativeExpressView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str, boolean z, String str2) {
        super(context);
        this.pr = true;
        this.hw = 0;
        this.fw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.z = new AtomicBoolean(false);
        this.b = null;
        this.nt = false;
        this.lb = false;
        this.a = false;
        this.nl = false;
        this.er = new AtomicBoolean(false);
        this.ny = false;
        this.v = new AtomicBoolean(false);
        this.of = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.qx.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.c(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ii);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ii, 500L);
            }
        };
        this.ii = new Runnable() { // from class: com.byazt.qx.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ww.hw(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.uc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.uc(8);
                }
            }
        };
        this.i = new Runnable() { // from class: com.byazt.qx.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(0);
            }
        };
        this.r = new Runnable() { // from class: com.byazt.qx.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.uc(8);
            }
        };
        this.aa = new SparseArray<>();
        this.iy = -1.0f;
        this.cr = -1.0f;
        this.j = -1.0f;
        this.qo = -1.0f;
        this.bh = 0L;
        this.fw = str;
        this.uc = context;
        this.aj = ofVar;
        this.ls = new com.byazt.pj.hw(ofVar, str);
        this.vk = str2;
        this.zo = hwVar;
        this.a = z;
        if (hwVar.a() == 9) {
            this.nt = hwVar.ho() == 2;
        }
        w();
    }

    public void w() {
        this.cz = new FrameLayout(this.uc);
        this.e = new FrameLayout(this.uc);
        this.s = new FrameLayout(this.uc);
        addView(this.cz);
        addView(this.e);
        addView(this.s);
        this.f = new ArrayList();
        com.byazt.qe.hw hwVar = this.zo;
        if (hwVar != null) {
            this.iu = hwVar.zo();
            this.ve = this.zo.aj();
            fo();
            this.b = this.zo.x();
        }
        if (!g()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            m();
        }
        z();
        gz();
        com.byazt.mq.nt ntVar = this.bm;
        if (ntVar != null) {
            this.nw = (b) ntVar.pr();
        }
        if (b()) {
            this.gu = new yb(this);
        }
    }

    public com.byazt.pj.hw getAdShowTime() {
        return this.ls;
    }

    private void m() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.hs = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.pr(this);
    }

    private boolean g() {
        return ve() && ie.pr(this.aj) == 1;
    }

    private void fo() {
        com.byazt.qe.hw hwVar;
        if (TextUtils.equals(this.fw, "splash_ad") && (hwVar = this.zo) != null && this.ve == hwVar.fw() && this.iu == this.zo.uc()) {
            this.ve = er.x(this.uc, this.ve);
            int iC = er.c(this.uc);
            float f = this.iu;
            float f2 = iC;
            if (f < f2) {
                this.iu = er.x(this.uc, f2);
            } else {
                this.iu = er.x(this.uc, f);
            }
        }
    }

    public SSWebView getWebView() {
        b bVar = this.nw;
        if (bVar == null) {
            return null;
        }
        return bVar.pr();
    }

    private void rc() {
        try {
            if (this.hs == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            ls.pr(this.uc, this.hs, intentFilter, ls.iu(), null, 4);
        } catch (Throwable th) {
        }
    }

    private void z() {
        com.byazt.mq.m.pr prVar;
        List<y> listDe;
        y yVar;
        boolean zAj = ie.aj(this.aj);
        JSONObject jSONObjectPr = null;
        if (!g()) {
            boolean z = ie.hn(this.aj) == 9 || ie.hn(this.aj) == 0;
            if (zAj) {
                jSONObjectPr = com.byazt.hc.hw.pr(this.aj, com.byazt.hc.hw.pr(this.iu, this.ve, this.nt), com.byazt.hc.hw.pr(this.aj), false, this.vk, z);
            } else if (ie.w(this.aj)) {
                if (ie.fw(this.aj) != null && !TextUtils.isEmpty(ie.fw(this.aj).aj())) {
                    jSONObjectPr = com.byazt.ea.w.pr(ie.fw(this.aj).aj(), ie.fw(this.aj).vk(), (com.byazt.ea.hn) null);
                }
            } else {
                jSONObjectPr = com.byazt.hc.hw.pr(this.iu, this.ve, this.nt, this.aj, z);
            }
            if (ie.fw(this.aj) != null) {
                com.byazt.sd.x.pr().pr(ie.fw(this.aj).hw());
            }
            if (ie.zo(this.aj) != null) {
                com.byazt.sd.x.pr().pr(ie.zo(this.aj).pr());
            }
        }
        this.gz = hw(jSONObjectPr);
        if (g()) {
            this.vj = new a();
        } else {
            this.vj = new vk(this.gz, this.fw, this.aj, this.b);
        }
        boolean zIu = iu();
        if (ie.w(this.aj) || ie.m(this.aj) || com.byazt.kl.pr.hw(this.aj) || b()) {
            com.byazt.gu.hw.pr prVar2 = new com.byazt.gu.hw.pr();
            prVar2.c(com.byazt.ea.w.pr(this.aj, (View) this, false));
            prVar2.pr((com.byazt.ch.ny) this.vj);
            prVar2.pr(this.iu);
            prVar2.hw(this.ve);
            prVar2.c(b());
            prVar2.w(1);
            prVar = prVar2;
        } else {
            prVar = new com.byazt.mq.m.pr();
        }
        prVar.hn(zAj);
        if (TextUtils.equals(this.fw, "splash_ad")) {
            prVar.uc(com.byazt.zp.w.c());
        }
        if (ie.hn(this.aj) == 3 && com.byazt.ja.pr.x(this.aj) && (listDe = this.aj.de()) != null && !listDe.isEmpty() && (yVar = listDe.get(0)) != null) {
            prVar.aj(yVar.pr());
            prVar.pr(new UpieImageView(this.uc, com.byazt.ja.pr.vk(this.aj), com.byazt.vr.pr.pr(this.aj), com.byazt.ja.pr.w(this.aj)));
        }
        this.sv = prVar.pr(this.fw).hw(this.aj.x()).hn(ls.a(this.aj)).x(this.aj.B_()).pr(jSONObjectPr).pr(this.vj).pr(com.byazt.sd.a.hw().pr(this.fw, ie.hn(this.aj))).hw(zIu).hw(this.aj.sr()).hn(this.aj.aj()).c(com.byazt.hc.hw.x(this.aj)).pr(com.byazt.hc.hw.c(this.aj)).x(getRenderThread()).c(this.aj.tm()).uc(this.aj.fu()).fw(this.aj.qz()).hw(this.aj.gv()).hn(this.aj.dj()).x(this.aj.yd()).aj(this.aj.kl()).zo(this.aj.gg()).fw(this.aj.jr()).zo("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").pr(com.byazt.sd.zo.nt().x()).vk(this.aj.nl()).x(com.byazt.sd.a.hw().xd()).pr();
    }

    private int getRenderThread() {
        if (ve() && com.byazt.sd.a.hw().zo(ls.m(this.aj)) == 4) {
            return 1;
        }
        if ((com.byazt.mp.c.pr().k() & 2) == 2) {
            return 1;
        }
        return ie.c(this.aj);
    }

    private boolean b() {
        return this.zo != null && com.byazt.sd.iu.x >= 5900 && this.zo.b();
    }

    private boolean iu() {
        if (TextUtils.equals(this.fw, "rewarded_video") || TextUtils.equals(this.fw, "fullscreen_interstitial_ad")) {
            return this.aj.zz();
        }
        return true;
    }

    private com.byazt.ko.pr hw(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.pj.zo zoVar = new com.byazt.pj.zo(this.fw, this.aj, jSONObject2, jSONObject);
        zoVar.pr(jSONObject2, "webview_source", (Object) 1);
        return zoVar;
    }

    private boolean ve() {
        return TextUtils.equals(this.fw, "splash_ad") || TextUtils.equals(this.fw, "cache_splash_ad");
    }

    private void gz() {
        this.hw = ie.hn(this.aj);
        if (ve() && ie.pr(this.aj) == 1) {
            this.hw = 1000;
        }
        com.byazt.df.pr prVar = new com.byazt.df.pr(this.aj, new WeakReference(this));
        switch (this.hw) {
            case 3:
                com.byazt.mq.hw hwVar = new com.byazt.mq.hw(this.uc, this.sv, this.hs, this.a, new com.byazt.uko.fw(), this, prVar);
                this.jn = hwVar;
                this.f.add(hwVar);
                this.jn.pr(com.byazt.sd.a.hw().jb());
                break;
            case 7:
                com.byazt.gu.c cVar = new com.byazt.gu.c(this.uc, this.aj, (com.byazt.gu.hw) this.sv, this);
                this.nl = cVar.vk();
                com.byazt.gu.uc ucVar = new com.byazt.gu.uc(this.uc, cVar, this, this.sv, this);
                this.lv = ucVar;
                this.f.add(ucVar);
                break;
            case 10:
                com.byazt.gu.fw fwVar = new com.byazt.gu.fw(this.uc, this.aj, (com.byazt.gu.hw) this.sv, this);
                this.ie = fwVar;
                this.nl = fwVar.vk();
                this.lv = new com.byazt.gu.uc(this.uc, this.ie, this, this.sv, this);
                if (ie.pr(ls.k(this.aj))) {
                    this.ie.pr(new com.byazt.ch.zo() { // from class: com.byazt.qx.NativeExpressView.9
                        @Override // com.byazt.ch.zo
                        public void pr(com.byazt.ch.aj.pr prVar2) {
                            try {
                                x.pr(prVar2.c(), NativeExpressView.this.sv.c());
                            } catch (Exception e) {
                            }
                        }

                        @Override // com.byazt.ch.zo
                        public void hw(com.byazt.ch.aj.pr prVar2) {
                        }
                    });
                }
                this.f.add(this.lv);
                break;
            case 1000:
                break;
            default:
                b bVar = new b(this.uc, this.sv, this.hs, this.gz, this.aj, this.vj, this);
                this.nw = bVar;
                com.byazt.mq.nt ntVar = new com.byazt.mq.nt(this.uc, this.sv, bVar, this);
                this.bm = ntVar;
                this.f.add(ntVar);
                break;
        }
        int iX = ie.x(this.aj);
        if (iX > 0 && b() && TextUtils.equals(this.fw, com.byazt.pfl.hw.AD_TAG_FEED)) {
            this.f.add(new com.byazt.gu.uc(this.uc, new com.byazt.kl.hn(this.uc, this.aj, (com.byazt.gu.hw) this.sv, this), this, this.sv, this));
        } else {
            boolean z = iX == 1;
            this.pr = z;
            if (z || this.hw == 1000) {
                com.byazt.mq.uc ucVar2 = new com.byazt.mq.uc(this.uc, this.sv, new qa(this, this.hs, this.sv));
                this.l = ucVar2;
                this.f.add(ucVar2);
            } else if (com.byazt.kl.pr.hw(this.aj)) {
                this.f.add(new com.byazt.gu.uc(this.uc, new com.byazt.kl.hn(this.uc, this.aj, (com.byazt.gu.hw) this.sv, this), this, this.sv, this));
            }
        }
        this.o = new com.byazt.mq.k(this.f, this.vj);
    }

    public void setVideoAdListener(com.byazt.w.hn.x xVar) {
        this.k = xVar;
    }

    public void setVideoAdInteractionListener(com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn) {
        this.m = interfaceC0220hn;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof qa) && (backupView = (BackupView) xVar.uc()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.x = dialog;
        of ofVar = this.aj;
        if (ofVar != null) {
            com.byazt.sd.cz.hw(ofVar.le(), dialog, Dialog.class);
        }
    }

    public void setDislike(com.byazt.pfl.hw hwVar) {
        BackupView backupView;
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof qa) && (backupView = (BackupView) xVar.uc()) != null) {
            backupView.setDislikeInner(hwVar);
        }
        this.hn = hwVar;
        of ofVar = this.aj;
        if (ofVar != null) {
            com.byazt.sd.cz.hw(ofVar.le(), hwVar, com.byazt.pfl.hw.class);
        }
    }

    public void setExpressInteractionListener(pr prVar) {
        this.c = prVar;
    }

    public void setClickCreativeListener(com.byazt.az.pr prVar) {
        this.fo = prVar;
    }

    public com.byazt.az.pr getClickCreativeListener() {
        return this.fo;
    }

    public com.byazt.az.hw getClickListener() {
        return this.rc;
    }

    public void setClickListener(com.byazt.az.hw hwVar) {
        this.rc = hwVar;
    }

    public void setBackupListener(com.byazt.mq.hn hnVar) {
        this.yb = hnVar;
        com.byazt.mq.uc ucVar = this.l;
        if (ucVar != null) {
            ucVar.pr(hnVar);
        }
    }

    public void ho() {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar instanceof g) {
            ((g) xVar).fw();
        } else if (xVar instanceof com.byazt.gu.c) {
            ((com.byazt.gu.c) xVar).g();
        }
        nl();
    }

    private void nl() {
        if (!g()) {
            rc();
        }
    }

    public void uc(int i) {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof g)) {
            ((g) xVar).hw(i);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.r);
        removeCallbacks(this.i);
        if (i == 0) {
            postDelayed(this.i, 50L);
        } else {
            postDelayed(this.r, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c(z ? 53 : 54);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        b bVar = this.nw;
        if (bVar != null) {
            bVar.hn(z);
        }
    }

    public void hn(boolean z) {
        b bVar = this.nw;
        if (bVar != null) {
            bVar.x(z);
        }
    }

    public void fw(int i) {
        this.sv.pr(i);
    }

    public void nt() {
        if (com.byazt.sd.a.hw().mj() && this.wt) {
            if (this.c != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.c.pr(this, com.byazt.sd.fw.pr(-16), -16);
                    return;
                } else {
                    com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.qx.NativeExpressView.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativeExpressView.this.c != null) {
                                NativeExpressView.this.c.pr(NativeExpressView.this, com.byazt.sd.fw.pr(-16), -16);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (com.byazt.sd.a.hw().jb() && com.byazt.zp.zo.pr()) {
            com.byazt.ca.aj.hn().post(new Runnable() { // from class: com.byazt.qx.NativeExpressView.11
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.y();
                }
            });
        } else {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.byazt.ko.pr prVar = this.gz;
        if (prVar instanceof com.byazt.pj.zo) {
            ((com.byazt.pj.zo) prVar).hw(this.sv.zo());
        }
        this.gz.pr();
        this.o.pr(this);
        this.o.pr();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        yb ybVar;
        if (b() && (ybVar = this.gu) != null) {
            return ybVar.pr(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        yb ybVar;
        if (b() && (ybVar = this.gu) != null) {
            return ybVar.hw(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        com.byazt.az.pr prVar = this.fo;
        if (prVar != null) {
            prVar.hn(motionEvent.getDeviceId());
            this.fo.hw(motionEvent.getSource());
            this.fo.x(motionEvent.getToolType(0));
        }
        com.byazt.az.hw hwVar = this.rc;
        if (hwVar != null) {
            hwVar.hn(motionEvent.getDeviceId());
            this.rc.hw(motionEvent.getSource());
            this.rc.x(motionEvent.getToolType(0));
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.iy = motionEvent.getRawX();
                this.cr = motionEvent.getRawY();
                this.bh = System.currentTimeMillis();
                i = 0;
                break;
            case 1:
                i = 3;
                break;
            case 2:
                this.j += Math.abs(motionEvent.getX() - this.iy);
                this.qo += Math.abs(motionEvent.getY() - this.cr);
                this.iy = motionEvent.getX();
                this.cr = motionEvent.getY();
                if (System.currentTimeMillis() - this.bh > 200 && (this.j > 8.0f || this.qo > 8.0f)) {
                    i = 1;
                } else {
                    i = 2;
                }
                break;
            case 3:
                i = 4;
                break;
            default:
                i = -1;
                break;
        }
        SparseArray<com.byazt.az.x.pr> sparseArray = this.aa;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.byazt.az.x.pr(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void pr(View view, int i, com.byazt.dj.hn hnVar, mw mwVar) {
        this.y = mwVar;
        pr(view, i, hnVar, -1);
        this.y = null;
    }

    @Override // com.byazt.fy.hw
    public void pr(String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0076  */
    @Override // com.byazt.fy.hw
    public boolean pr(String str, com.byazt.ik.hn hnVar, com.byazt.fy.hn hnVar2) {
        switch (str) {
            case "clickEvent":
            case "convert":
                pr(hnVar, hnVar2, 2);
                return true;
            case "dislike":
                aj();
                return true;
            case "skip":
                uc();
                return true;
            case "close":
                fw();
                return true;
            case "muteVideo":
                pr(!this.a);
                return true;
            case "pauseVideo":
                pr(2);
                return true;
            case "resumeVideo":
                pr(3);
                return true;
            case "videoControl":
                pr(hnVar, hnVar2, 4);
                return true;
            case "interactiveFinish":
                pr(hnVar2);
                return true;
            default:
                return false;
        }
    }

    private void pr(com.byazt.ik.hn hnVar, com.byazt.fy.hn hnVar2, int i) {
        CharSequence text;
        com.byazt.hg.vk vkVar = (com.byazt.hg.vk) hnVar2.pr("ugen_click_event_params", com.byazt.hg.vk.class);
        com.byazt.hg.fo.pr prVarPr = new com.byazt.hg.fo.pr().x(vkVar.lb()).hn(vkVar.qa()).hw(vkVar.a()).pr(vkVar.cz()).pr(hnVar.ww()).hw(vkVar.nt()).pr(vkVar.yb()).pr(hnVar2.pr("is_slide_trigger_by_cancel", false) ? (byte) 7 : com.byazt.gu.fw.hw(hnVar2.pr("v3_trigger_name")));
        JSONObject jSONObject = new JSONObject();
        int iPr = hnVar2.pr("convert_action_type", 0);
        if (iPr > 0) {
            try {
                jSONObject.put("convertActionType", iPr);
            } catch (Throwable th) {
            }
        }
        View viewAj = hnVar.aj();
        try {
            if ((viewAj instanceof TextView) && (text = ((TextView) viewAj).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException e) {
        }
        prVarPr.pr(jSONObject);
        pr(viewAj, i, prVarPr.pr(), -1);
    }

    public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        com.byazt.hg.vk vkVar;
        View view2;
        com.byazt.az.pr prVar;
        com.byazt.az.hw hwVar;
        if (i == -1 || hnVar == null) {
            return;
        }
        com.byazt.hg.fo foVar = (com.byazt.hg.fo) hnVar;
        com.byazt.az.pr prVar2 = this.fo;
        if (prVar2 != null) {
            prVar2.c(getDynamicShowType());
        }
        com.byazt.az.hw hwVar2 = this.rc;
        if (hwVar2 != null) {
            hwVar2.c(getDynamicShowType());
        }
        com.byazt.yx.pr prVar3 = null;
        if (i == 1 && (hwVar = this.rc) != null) {
            com.byazt.hg.vk vkVarHw = hwVar.hw();
            com.byazt.yx.pr prVar4 = (com.byazt.yx.pr) this.rc.pr(com.byazt.yx.pr.class);
            prVar4.pr(prVar4.c());
            vkVar = vkVarHw;
            prVar3 = prVar4;
        } else {
            vkVar = null;
        }
        if (i == 2 && (prVar = this.fo) != null) {
            vkVar = prVar.hw();
            prVar3 = (com.byazt.yx.pr) this.fo.pr(com.byazt.yx.pr.class);
            prVar3.pr(prVar3.c());
        }
        try {
            Object obj = foVar.pr().get("click_extra_map");
            if (prVar3 != null && (obj instanceof Map)) {
                prVar3.pr((Map<String, Object>) obj);
            }
        } catch (JSONException e) {
        }
        if (vkVar == null) {
            vkVar = new com.byazt.hg.vk();
        }
        if (this.y != null) {
            vkVar.hw(this);
        }
        vkVar.pr(foVar.pr);
        vkVar.hw(foVar.hw);
        vkVar.hn(foVar.hn);
        vkVar.x(foVar.x);
        vkVar.hw(foVar.ho);
        vkVar.fw(foVar.qa);
        vkVar.pr(com.byazt.hg.cz.pr(this.aj, foVar.lb));
        vkVar.hw(foVar.lb);
        vkVar.pr(foVar.nt);
        vkVar.hw(getShowDLFactorsEventParams());
        SparseArray<com.byazt.az.x.pr> sparseArray = foVar.yb;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.aa;
        }
        vkVar.pr(sparseArray);
        JSONObject jSONObjectPr = foVar.pr();
        vkVar.x(jSONObjectPr.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectPr.optString("uchain_event_name");
        vkVar.hn(strOptString);
        vkVar.pr(this.ny);
        int iOptInt = jSONObjectPr.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.byazt.az.pr prVar5 = this.fo;
                if (prVar5 != null) {
                    prVar5.hn();
                }
            } else {
                com.byazt.az.hw hwVar3 = this.rc;
                if (hwVar3 != null) {
                    hwVar3.hn();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.byazt.az.pr prVar6 = this.fo;
                if (prVar6 != null) {
                    prVar6.x();
                }
            } else {
                com.byazt.az.hw hwVar4 = this.rc;
                if (hwVar4 != null) {
                    hwVar4.x();
                }
            }
        }
        if (view != null) {
            view2 = view;
        } else {
            view2 = this;
        }
        String str = foVar.w;
        int iAj = 0;
        of ofVar = this.aj;
        if (ofVar != null) {
            iAj = ofVar.aj();
        }
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.g;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                pr(view2, foVar, vkVar, 0, str, iAj, i2);
                break;
            case 2:
                pr(view2, foVar, vkVar, str, iAj, i2);
                break;
            case 3:
                aj();
                break;
            case 4:
                FrameLayout frameLayout2 = this.g;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                ls.z(this.aj);
                if (com.byazt.pfl.hw.AD_TAG_FEED.equals(this.fw) && ww() && !this.ho && ls.z(this.aj)) {
                    pr(view2, foVar, vkVar, str, iAj, i2);
                } else {
                    pr(view2, foVar, vkVar, 0, str, iAj, i2);
                }
                break;
            case 5:
                pr(!this.a);
                break;
            case 6:
                uc();
                break;
            case 7:
                if (!ls.pr(strOptString, this.aj, this.uc)) {
                    com.byazt.wt.c.pr(this.uc, this.aj);
                }
                break;
            case 8:
                fw();
                break;
            case 9:
                hw(this.aj, this.uc, this.fw);
                break;
            case 10:
                pr(this.aj, this.uc, this.fw);
                break;
            case 12:
                hn(this.aj, this.uc, this.fw);
                break;
            case 13:
                String strOptString2 = jSONObjectPr.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectPr.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.x(this.uc, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void pr(View view, com.byazt.hg.fo foVar, com.byazt.hg.vk vkVar, String str, int i, int i2) {
        if (of.uc(this.aj)) {
            return;
        }
        com.byazt.az.pr prVar = this.fo;
        if (prVar != null) {
            prVar.pr(foVar);
            hw(((com.byazt.dl.pr) this.rc.pr(com.byazt.dl.pr.class)).pr(), i2);
            com.byazt.yx.pr prVar2 = (com.byazt.yx.pr) this.fo.pr(com.byazt.yx.pr.class);
            pr(prVar2);
            prVar2.hw(str);
            this.fo.pr(vkVar);
            Map<String, Object> mapPr = com.byazt.lxw.pr.pr().pr(this.aj.hashCode() + this.aj.ny());
            mapPr.put("convert_tag", foVar.lb);
            mapPr.put("dpa_convert", com.byazt.hg.cz.x(this.aj.m(), foVar.lb));
            pr(foVar, mapPr);
            this.fo.pr(view, vkVar);
        }
        zo(i);
    }

    public void pr(com.byazt.hg.fo foVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(foVar.pr().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception e) {
        }
    }

    private void pr(com.byazt.yx.pr prVar) {
        mw mwVar = this.y;
        if (mwVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(mwVar.hw()));
            map.put("express_slide_direction", Integer.valueOf(mwVar.x()));
            map.put("express_slide_threshold", Double.valueOf(mwVar.hn()));
            prVar.pr(map);
        }
    }

    private void pr(View view, com.byazt.hg.fo foVar, com.byazt.hg.vk vkVar, int i, String str, int i2, int i3) {
        if (of.uc(this.aj)) {
            return;
        }
        com.byazt.az.hw hwVar = this.rc;
        if (hwVar != null) {
            hwVar.pr(foVar);
            hw(((com.byazt.dl.pr) this.rc.pr(com.byazt.dl.pr.class)).pr(), i3);
            com.byazt.yx.pr prVar = (com.byazt.yx.pr) this.rc.pr(com.byazt.yx.pr.class);
            pr(prVar);
            prVar.hw(str);
            this.rc.pr(vkVar);
            Map<String, Object> mapPr = com.byazt.lxw.pr.pr().pr(this.aj.hashCode() + this.aj.ny());
            mapPr.put("convert_tag", foVar.lb);
            mapPr.put("dpa_convert", com.byazt.hg.cz.x(this.aj.m(), foVar.lb));
            pr(foVar, mapPr);
            this.rc.pr(view, vkVar);
        }
        zo(i2);
    }

    public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        View view2;
        if (i == -1 || hnVar == null) {
            return;
        }
        com.byazt.hg.fo foVar = (com.byazt.hg.fo) hnVar;
        com.byazt.hg.vk vkVar = new com.byazt.hg.vk();
        vkVar.pr(foVar.yb);
        vkVar.pr(foVar.pr);
        vkVar.hw(foVar.hw);
        vkVar.hn(foVar.hn);
        vkVar.x(foVar.x);
        vkVar.hw(foVar.ho);
        JSONObject jSONObjectPr = foVar.pr();
        int iOptInt = jSONObjectPr.optInt("convertActionType", Integer.MIN_VALUE);
        vkVar.x(jSONObjectPr.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.fo.hn();
            } else {
                this.rc.hn();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.fo.x();
            } else {
                this.rc.x();
            }
        }
        if (view != null) {
            view2 = view;
        } else {
            view2 = this;
        }
        com.byazt.az.pr prVar = this.fo;
        if (prVar != null) {
            prVar.c(getDynamicShowType());
        }
        com.byazt.az.hw hwVar = this.rc;
        if (hwVar != null) {
            hwVar.c(getDynamicShowType());
        }
        int iAj = 0;
        of ofVar = this.aj;
        if (ofVar != null) {
            iAj = ofVar.aj();
        }
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.g;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                pr(view2, i2, foVar, vkVar, iAj);
                break;
            case 2:
                hw(view2, i2, foVar, vkVar, iAj);
                break;
            case 3:
                aj();
                break;
            case 4:
                FrameLayout frameLayout2 = this.g;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                ls.z(this.aj);
                if (com.byazt.pfl.hw.AD_TAG_FEED.equals(this.fw) && ww() && !this.ho && ls.z(this.aj)) {
                    hw(view2, i2, foVar, vkVar, iAj);
                } else {
                    pr(view2, i2, foVar, vkVar, iAj);
                }
                break;
            case 5:
                pr(!this.a);
                break;
            case 6:
                uc();
                break;
            case 8:
                fw();
                break;
        }
    }

    private void pr(View view, int i, com.byazt.hg.fo foVar, com.byazt.hg.vk vkVar, int i2) {
        if (of.uc(this.aj)) {
            return;
        }
        com.byazt.az.hw hwVar = this.rc;
        if (hwVar != null) {
            pr(((com.byazt.dl.pr) hwVar.pr(com.byazt.dl.pr.class)).pr(), i);
            this.rc.pr(foVar);
            this.rc.pr(vkVar);
            this.rc.pr(view, vkVar);
        }
        zo(i2);
    }

    private void hw(View view, int i, com.byazt.hg.fo foVar, com.byazt.hg.vk vkVar, int i2) {
        if (of.uc(this.aj)) {
            return;
        }
        com.byazt.az.pr prVar = this.fo;
        if (prVar != null) {
            pr(((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(), i);
            this.fo.pr(foVar);
            this.fo.pr(vkVar);
            this.fo.pr(view, vkVar);
        }
        zo(i2);
    }

    private void pr(com.byazt.nv.hn hnVar, int i) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ri.pr) {
            com.byazt.wr.hn hnVarFw = ((com.byazt.ri.pr) hnVar).fw();
            hnVarFw.hw(true);
            hnVarFw.pr(i);
        }
        hnVar.x(this.v.get());
    }

    private void hw(com.byazt.nv.hn hnVar, int i) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVar).fw().hw(i);
        }
        hnVar.x(this.v.get());
    }

    private boolean ww() {
        of ofVar = this.aj;
        return ofVar != null && ofVar.fe() == 1 && of.hn(this.aj);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.ca.ho.hw("webviewpool", "onAttachedToWindow+++");
        c(51);
        getViewTreeObserver().addOnScrollChangedListener(this.of);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.byazt.ca.ho.hw("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c(55);
    }

    public void yb() {
        b bVar = this.nw;
        if (bVar != null && bVar.uc() != null) {
            this.nw.x();
        }
    }

    public void lb() {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar instanceof com.byazt.gu.c) {
            ((com.byazt.gu.c) xVar).ho();
        } else if (xVar instanceof b) {
            ((b) xVar).ho();
        }
    }

    public void k() {
        x(true);
    }

    public void x(boolean z) {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            com.byazt.mq.x<? extends View> xVar = this.mw;
            if (xVar instanceof com.byazt.gu.c) {
                xVar.pr(z);
            }
            if (this.aj != null) {
                try {
                    com.byazt.at.x.pr().pr(this.aj.cz());
                } catch (Throwable th) {
                }
            }
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.byazt.mq.vk> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().hw(z);
            }
            this.hn = null;
            this.x = null;
            this.zo = null;
            this.aj = null;
            this.fo = null;
            this.yb = null;
            this.rc = null;
            this.k = null;
            this.m = null;
            this.c = null;
            Context context = this.uc;
            if (context != null && (themeStatusBroadcastReceiver = this.hs) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.w;
            if (expressVideoView != null) {
                expressVideoView.a();
            }
            View view = this.pj;
            if (view != null) {
                view.removeCallbacks(this.qn);
            }
            this.ls.pr(56);
        } catch (Throwable th2) {
            com.byazt.ca.ho.pr("NativeExpressView", "detach error", th2);
        }
    }

    public void qa() {
        try {
            FrameLayout frameLayout = this.g;
            if (frameLayout != null && frameLayout.getParent() != null) {
                removeView(this.g);
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.byazt.ko.pr prVar = this.gz;
            if (prVar != null) {
                prVar.hw(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.of);
        } catch (Exception e) {
        }
        com.byazt.ca.ho.hw("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.byazt.ca.ho.hw("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // com.byazt.mq.ho
    public void pr(final com.byazt.mq.x<? extends View> xVar, final com.byazt.mq.g gVar) {
        this.wt = true;
        this.er.set(true);
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.qx.NativeExpressView.12
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.hw(xVar, gVar);
            }
        });
    }

    private float hn(of ofVar) {
        return (com.byazt.ri.c.c(ofVar) && com.byazt.jx.pr.x(ofVar)) ? 56.0f : 0.0f;
    }

    private void pr(of ofVar, com.byazt.hg.x xVar) {
        FrameLayout frameLayout = this.qi;
        if (frameLayout != null && frameLayout.getParent() != null) {
            removeView(this.qi);
        }
        int iK = ls.k(ofVar);
        FrameLayout frameLayoutPr = com.byazt.ri.c.pr(getContext(), ofVar, xVar, iK);
        this.qi = frameLayoutPr;
        frameLayoutPr.setBackgroundColor(Color.parseColor("#161823"));
        float fHn = hn(ofVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, er.hn(getContext(), fHn));
        float f = this.ve;
        float f2 = (f - fHn) / f;
        layoutParams.gravity = iK == 8 ? 48 : 80;
        int iHn = er.hn(getContext(), this.ve);
        this.qi.setVisibility(4);
        removeView(this.cz);
        removeView(this.e);
        FrameLayout frameLayout2 = this.n;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            removeView(this.n);
        } else {
            this.n = new FrameLayout(this.uc);
        }
        this.n.addView(this.cz);
        this.n.addView(this.e);
        addView(this.n, 0);
        this.n.setBackgroundColor(0);
        this.n.setPivotX(0.0f);
        if (this.e.getHeight() != 0) {
            iHn = this.e.getHeight();
        }
        this.n.setPivotY(iK == 8 ? iHn : 0.0f);
        this.n.setScaleY(f2);
        addView(this.qi, layoutParams);
    }

    private boolean x(of ofVar) {
        if (ofVar == null) {
            return true;
        }
        if (ls.k(ofVar) != 8) {
            return this.ve == 0.0f;
        }
        if (ofVar.oq() == 0.0f || ofVar.oq() == 100.0f) {
            return ((float) (this.e.getHeight() == 0 ? er.hn(getContext(), this.ve) : this.e.getHeight())) <= 0.0f;
        }
        return true;
    }

    private void c(of ofVar) {
        try {
            if (com.byazt.ri.c.uc(ofVar) && !x(ofVar)) {
                if (!com.byazt.jx.pr.x(ofVar)) {
                    hw(false);
                    return;
                } else {
                    uc(ofVar);
                    return;
                }
            }
            hw(false);
        } catch (Exception e) {
            com.byazt.xk.hw.pr().pr("express_dl", e);
            hw(false);
        }
    }

    private void uc(final of ofVar) {
        if (ofVar == null) {
            hw(false);
            return;
        }
        if (com.byazt.ri.c.pr(ofVar) == 0) {
            hw(ofVar, (com.byazt.hg.x) null);
            return;
        }
        com.byazt.hg.x xVarPr = com.byazt.jx.pr.pr(ofVar);
        if (xVarPr != null) {
            if (xVarPr.fw()) {
                hw(ofVar, xVarPr);
                return;
            } else {
                hw(false);
                return;
            }
        }
        final com.byazt.hg.c cVarHo = ofVar.ho();
        if (cVarHo == null) {
            hw(false);
        } else {
            com.byazt.zp.zo.pr(new com.byazt.xlm.fw("pl_dlf") { // from class: com.byazt.qx.NativeExpressView.13
                @Override // java.lang.Runnable
                public void run() {
                    final com.byazt.hg.x xVarPr2 = com.byazt.sd.a.pr().pr(NativeExpressView.this.aj, cVarHo.hw());
                    com.byazt.zp.zo.pr((Runnable) new com.byazt.xlm.fw("pl_udlf") { // from class: com.byazt.qx.NativeExpressView.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.hg.x xVar = xVarPr2;
                            if (xVar == null || !xVar.fw()) {
                                NativeExpressView.this.hw(false);
                                return;
                            }
                            try {
                                NativeExpressView.this.hw(ofVar, xVarPr2);
                            } catch (Exception e) {
                                com.byazt.xk.hw.pr().pr("express_dl", e);
                                NativeExpressView.this.hw(false);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(of ofVar, com.byazt.hg.x xVar) {
        pr(ofVar, xVar);
        hw(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final boolean z) {
        nl nlVarP_;
        this.v.set(z);
        FrameLayout frameLayout = this.qi;
        if (frameLayout != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.byazt.qx.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeExpressView.this.qi != null) {
                        NativeExpressView.this.qi.setVisibility(z ? 0 : 8);
                    }
                }
            }, 10L);
        }
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof b) && (nlVarP_ = ((b) xVar).P_()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z);
                nlVarP_.hw("isShow7Factors", jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void hw(com.byazt.mq.x<? extends View> xVar, com.byazt.mq.g gVar) {
        int iHn;
        try {
            this.mw = xVar;
            this.od = gVar;
            if (xVar.hw() != 1) {
                View viewUc = xVar.uc();
                this.pj = viewUc;
                if (viewUc.getParent() != null) {
                    ((ViewGroup) this.pj.getParent()).removeView(this.pj);
                }
                this.e.addView(this.pj);
                if (gVar.hw() == 10) {
                    if (gVar.c() == 0.0d) {
                        int iPr = (int) ie.pr(this.aj, gVar.x());
                        if (iPr <= 0) {
                            iHn = er.uc(getContext());
                        } else {
                            iHn = er.hn(getContext(), iPr);
                        }
                        this.pj.setLayoutParams(new FrameLayout.LayoutParams(-1, iHn));
                    }
                    if (this.aj.sl() == 1) {
                        Runnable runnable = new Runnable() { // from class: com.byazt.qx.NativeExpressView.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (NativeExpressView.this.pj != null) {
                                        View childAt = ((ViewGroup) NativeExpressView.this.pj).getChildAt(0);
                                        View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                                        if (childAt2.getMeasuredHeight() < childAt.getMeasuredHeight()) {
                                            NativeExpressView.this.pj.setLayoutParams(new FrameLayout.LayoutParams(-1, childAt2.getHeight()));
                                            NativeExpressView.this.e.requestLayout();
                                        }
                                    }
                                } catch (Exception e) {
                                }
                            }
                        };
                        this.qn = runnable;
                        this.pj.post(runnable);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.pj.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                c(this.aj);
                if (this.pq != null && (xVar instanceof com.byazt.gu.c) && !(xVar instanceof com.byazt.gu.fw)) {
                    this.pq.pr(((com.byazt.gu.c) xVar).aj());
                    this.pq.pr(this);
                }
            }
            com.byazt.mq.aj ajVar = this.vj;
            if (ajVar instanceof vk) {
                ((vk) ajVar).g();
            }
            if (this.gz != null && xVar.hw() != 0) {
                this.gz.pr(xVar.hw(), gVar.w(), gVar.vk());
            }
            com.byazt.mq.x<? extends View> xVar2 = this.mw;
            if ((xVar2 instanceof ho) && ((ho) xVar2).P_() != null) {
                ((ho) this.mw).P_().pr((w) this);
            }
            if (gVar.hw() == 10 && (gVar instanceof com.byazt.gu.hn)) {
                this.ww = ((com.byazt.gu.hn) gVar).lb();
            }
            pr prVar = this.c;
            if (prVar != null) {
                prVar.pr(this, (float) gVar.x(), (float) gVar.c());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void pr(MotionEvent motionEvent) {
        View view = this.pj;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    public void a() {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if ((xVar instanceof com.byazt.gu.c) && !(xVar instanceof com.byazt.gu.fw)) {
            ((com.byazt.gu.c) xVar).x();
        }
    }

    @Override // com.byazt.mq.ho
    public void a_(final int i) {
        this.wt = true;
        if (!this.pr) {
            this.vj.w();
        }
        this.vj.k();
        com.byazt.mq.aj ajVar = this.vj;
        if (ajVar instanceof vk) {
            ((vk) ajVar).g();
        }
        if (this.c != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.c.pr(this, com.byazt.sd.fw.pr(i), i);
            } else {
                com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.qx.NativeExpressView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.c != null) {
                            NativeExpressView.this.c.pr(NativeExpressView.this, com.byazt.sd.fw.pr(i), i);
                        }
                    }
                });
            }
        }
    }

    public boolean cz() {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        return xVar != null && xVar.hw() == 1;
    }

    public int getDynamicShowType() {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null) {
            return xVar.hw();
        }
        return 0;
    }

    public byte getShowDLFactorsEventParams() {
        if (!com.byazt.ri.c.uc(this.aj)) {
            return (byte) -1;
        }
        boolean zX = com.byazt.jx.pr.x(this.aj);
        boolean z = this.v.get();
        if (zX) {
            if (z) {
                return (byte) 3;
            }
            if (!cz()) {
                return (byte) 1;
            }
        } else if (z) {
            return (byte) 2;
        }
        return (byte) 0;
    }

    public int getRenderEngineCacheType() {
        fw fwVarG;
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if ((xVar instanceof b) && (fwVarG = ((b) xVar).g()) != null) {
            return fwVarG.pr();
        }
        return 0;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.iu).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.ve).intValue();
    }

    public nl getJsObject() {
        b bVar = this.nw;
        if (bVar != null) {
            return bVar.P_();
        }
        return null;
    }

    public com.byazt.gu.fw getUGenV3Render() {
        return this.ie;
    }

    public pr getExpressInteractionListener() {
        return this.c;
    }

    @Override // com.byazt.imd.x
    public void pr(CharSequence charSequence, int i, int i2, boolean z) {
        pr(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    @Override // com.byazt.imd.x
    public void setSoundMute(boolean z) {
        this.a = z;
        com.byazt.mq.hw hwVar = this.jn;
        if (hwVar != null && hwVar.pr() != null) {
            this.jn.pr().setSoundMute(z);
        }
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && xVar.hw() == 7) {
            com.byazt.mq.x<? extends View> xVar2 = this.mw;
            if (xVar2 instanceof com.byazt.gu.c) {
                ((com.byazt.imd.x) xVar2).setSoundMute(z);
            }
        }
    }

    public void setTimeUpdate(int i) {
    }

    public void pr(int i, int i2, boolean z) {
        int iX;
        if (TextUtils.equals(this.fw, "fullscreen_interstitial_ad")) {
            if (ve.pr(this.aj) && ve.hw(this.aj) > 0) {
                iX = 0;
            } else {
                iX = com.byazt.sd.a.hw().c(Integer.parseInt(this.b));
            }
        } else if (TextUtils.equals(this.fw, "rewarded_video")) {
            iX = com.byazt.sd.a.hw().x(Integer.parseInt(this.b));
        } else {
            return;
        }
        int i3 = (i2 >= iX || z) ? 1 : 0;
        int i4 = i2 <= iX ? iX - i2 : 0;
        com.byazt.mq.hw hwVar = this.jn;
        if (hwVar != null && hwVar.pr() != null) {
            this.jn.pr().pr(String.valueOf(i), i3, i4, z);
        }
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null) {
            if (xVar.hw() == 7 || this.mw.hw() == 10) {
                com.byazt.mq.x<? extends View> xVar2 = this.mw;
                if (xVar2 instanceof com.byazt.gu.c) {
                    ((com.byazt.imd.x) xVar2).pr(String.valueOf(i), i3, i4, z);
                }
            }
        }
    }

    private void pr(of ofVar, Context context, String str) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wt.c.hn(ofVar, context, str);
    }

    private void hw(of ofVar, Context context, String str) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wt.c.hw(ofVar, context, str);
    }

    private void hn(of ofVar, Context context, String str) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wt.c.pr(context, ofVar, str);
    }

    private void pr(com.byazt.fy.hn hnVar) {
        hw(com.byazt.gm.fo.pr(this.aj, hnVar.pr("reduce_duration", 0)));
    }

    public void pr(boolean z) {
        if (this.mw.hw() == 7) {
            com.byazt.mq.x<? extends View> xVar = this.mw;
            if (xVar instanceof com.byazt.gu.c) {
                ((com.byazt.imd.x) xVar).setSoundMute(z);
            }
        }
    }

    public void uc() {
        com.byazt.ck.hn hnVar = this.jw;
        if (hnVar != null) {
            hnVar.pr();
        }
    }

    public void fw() {
        if (!b() || !TextUtils.equals(this.fw, com.byazt.pfl.hw.AD_TAG_FEED)) {
            if (!b()) {
                aj();
            }
        } else {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.byazt.dw.hw hwVar = new com.byazt.dw.hw(this.aj.to(), com.byazt.pw.x.pr());
            hwVar.hw(com.byazt.pfl.hw.AD_TAG_DISLIKE);
            com.byazt.rc.pr.pr().pr(this.uc, hwVar, "close_success");
        }
    }

    public void pr(int i) {
    }

    public long pr() {
        return 0L;
    }

    public int hw() {
        return 0;
    }

    public int hn() {
        return 0;
    }

    public void aj() {
        Dialog dialog = this.x;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.pfl.hw hwVar = this.hn;
        if (hwVar != null) {
            hwVar.pr();
        } else {
            TTDelegateActivity.pr(getContext(), this.aj);
        }
    }

    public void zo() {
    }

    public void vk() {
    }

    public void x(int i) {
    }

    public void pr(float f, float f2, float f3, float f4, int i) {
    }

    public void x() {
    }

    public void hw(int i) {
    }

    public void c() {
    }

    public void pr(int i, String str) {
    }

    public void setPauseFromExpressView(boolean z) {
    }

    public void pr(float f) {
    }

    public void pr(int i, int i2) {
    }

    public void hn(int i) {
    }

    public void pr(of ofVar) {
    }

    public ViewGroup getVideoContainer() {
        return this.g;
    }

    public com.byazt.w.hn getVideoController() {
        return null;
    }

    @Override // com.byazt.mo.pr
    public void b_(int i) {
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof g)) {
            ((g) xVar).b_(i);
        }
    }

    public void hw(int i, String str) {
        nl nlVarP_;
        com.byazt.mq.x<? extends View> xVar = this.mw;
        if (xVar != null && (xVar instanceof b) && (nlVarP_ = ((b) xVar).P_()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
                jSONObject.put("flag", str);
                nlVarP_.hw("onVideoPaused", jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void pr(JSONObject jSONObject) {
        boolean zRc = com.byazt.sd.a.hw().rc();
        this.d = zRc;
        if (zRc && ls.c(this.aj)) {
            this.pq = new ny(this.aj, jSONObject, this);
        }
    }

    public void ny() {
        ny nyVar = this.pq;
        if (nyVar != null) {
            nyVar.x();
        }
    }

    public void setEasyPlayableSender(com.byazt.uq.fw fwVar) {
        ExpressVideoView expressVideoView = this.w;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(fwVar);
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.s;
    }

    public void setDynamicSkipListener(com.byazt.ck.hn hnVar) {
        this.jw = hnVar;
    }

    public void hw(int i, int i2) {
        com.byazt.bk.pr prVar = this.ww;
        if (prVar != null) {
            prVar.pr(i, i2);
        }
    }

    @Override // com.byazt.qx.nt
    public void hw(of ofVar) {
        if (ofVar != null) {
            c(ofVar);
        }
    }

    public void pr(com.byazt.cy.pr prVar) {
        com.byazt.gu.fw fwVar = this.ie;
        if (fwVar != null) {
            fwVar.pr(prVar);
        }
        b bVar = this.nw;
        if (bVar != null) {
            bVar.pr(prVar);
        }
    }

    private void zo(final int i) {
        if (com.byazt.sd.a.hw().xh()) {
            if (this.c != null) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.qx.NativeExpressView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.c != null) {
                            NativeExpressView.this.c.pr(NativeExpressView.this, i);
                        }
                    }
                }, 100L);
            }
        } else {
            pr prVar = this.c;
            if (prVar != null) {
                prVar.pr(this, i);
            }
        }
    }
}
