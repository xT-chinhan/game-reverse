package com.byazt.hw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.fp.l;
import com.byazt.gct.dn;
import com.byazt.gct.el;
import com.byazt.gct.fl;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.hi.SplashClickBarBtn;
import com.byazt.hi.TsView;
import com.byazt.hi.tj;
import com.byazt.jr.q;
import com.byazt.mr.EmptyView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.se.fs;
import com.byazt.se.rv;
import com.byazt.se.w;
import com.byazt.se.x;
import com.byazt.tk.k;
import com.byazt.tk.sz;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 203, 19})
public class n extends com.byazt.fvm.qg implements wo.n, TsView.n {
    public boolean b;
    public boolean bb;
    public fs cd;
    public com.byazt.zq.qg ci;
    public boolean cx;
    public com.byazt.tx.qg df;
    public String dg;
    public com.byazt.cne.qg e;
    public com.byazt.se.s el;
    public com.byazt.cne.n fs;
    public w hd;
    public com.byazt.hm.qg he;
    public q<rv, x> hf;
    public x hu;
    public tj ic;
    public com.byazt.mz.n kc;
    public volatile com.byazt.ys.n l;
    public com.byazt.ia.q lh;
    public TsView n;
    public Context oj;
    public boolean ou;
    public float pk;
    public boolean py;
    public SoftReference<com.byazt.mi.s> q;
    public pk qg;
    public volatile ITTInnerDownloadAdapter s;
    public float u;
    public com.byazt.qdx.qg ur;
    public View.OnTouchListener w;
    public qg x;
    public Activity yw;
    public AtomicBoolean rv = new AtomicBoolean(false);
    public final Map<String, Object> tj = new HashMap();
    public Double wo = null;
    public boolean sh = false;
    public boolean y = false;
    public boolean cp = false;
    public int d = 3;
    public int oa = -1;
    public final t rf = new t(Looper.getMainLooper(), this);
    public boolean sz = false;
    public boolean k = false;
    public long cy = 0;
    public Map<String, Object> um = new HashMap();
    public AtomicBoolean a = new AtomicBoolean(false);
    public boolean wm = true;
    public boolean m = false;
    public com.byazt.hi.n dh = new com.byazt.hi.n();
    public boolean ri = false;
    public long nf = 0;
    public long pe = 5;
    public AtomicBoolean h = new AtomicBoolean(false);
    public AtomicBoolean t = new AtomicBoolean(false);
    public AtomicBoolean ln = new AtomicBoolean(false);
    public boolean lq = true;
    public AtomicBoolean v = new AtomicBoolean(false);
    public int j = -1;
    public int an = -1;
    public final AtomicBoolean ae = new AtomicBoolean(false);
    public final AtomicBoolean z = new AtomicBoolean(false);
    public final AtomicInteger f = new AtomicInteger(0);
    public com.byazt.pi.qg fi = null;
    public boolean dn = false;
    public int vb = 0;

    public interface qg {
        void z_();
    }

    public void cy() {
    }

    @Override // com.byazt.fvm.qg
    public void n(ViewGroup viewGroup) {
    }

    @Override // com.byazt.fvm.qg
    public View s() {
        return null;
    }

    public void n(com.byazt.se.s sVar, q<rv, x> qVar, com.byazt.mz.n nVar) {
        if (sVar == null || qVar == null) {
            return;
        }
        this.el = sVar;
        this.kc = nVar;
        this.v.set(sVar.rv());
        this.hf = qVar;
        x xVar = new x();
        this.hu = xVar;
        xVar.qg(sVar.rv());
        this.hu.n(sVar.qg());
        this.hu.n(this);
        this.oj = sVar.getContext();
        this.dg = sVar.w();
        this.hd = sVar.q();
        boolean z = true;
        n(sVar.l(), true);
        this.ci = sVar.x();
        w wVar = this.hd;
        this.qg = wVar == null ? null : wVar.qg();
        this.he = new com.byazt.hm.qg(this.qg, this.dg);
        pk pkVar = this.qg;
        boolean z2 = pkVar == null || pkVar.y();
        pk pkVar2 = this.qg;
        if (!(pkVar2 == null || pkVar2.rf()) && !z2) {
            z = false;
        }
        this.dn = z;
    }

    public synchronized void n(fs fsVar, boolean z) {
        if (this.cd == null || !z) {
            this.cd = fsVar;
            if (fsVar != null) {
                qg(fsVar.l());
                this.ur = fsVar.q();
            }
        }
    }

    public void qg(boolean z) {
        try {
            this.bb = z;
            hd();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.fvm.qg
    public PluginValueSet n() {
        return com.byazt.qvu.n.n(super.n()).n(1, com.byazt.nf.tj.l).qg();
    }

    public void n(q<rv, x> qVar) {
        if (this.hd == null) {
            this.hu.qg(3);
            this.hu.n("render splash ad model is null");
            qVar.n(this.hu);
            return;
        }
        if (this.cd == null) {
            this.hu.qg(3);
            this.hu.n("render splash material is null");
            qVar.n(this.hu);
            return;
        }
        if (this.qg == null) {
            return;
        }
        try {
            this.cp = false;
            TsView tsView = new TsView(this.oj, this.dg, this.qg);
            this.n = tsView;
            tsView.setAttachedToWindowListener(this);
            hd();
            this.n.setCountDownViewPosition(this.qg);
            if (this.qg.eq() == 0) {
                TsView tsView2 = this.n;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.n;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.qg.hx() <= 0) {
                qg(3);
            } else {
                int iHx = this.qg.hx();
                this.d = iHx;
                qg(iHx);
            }
            n(this.qg);
            cd();
        } catch (ArrayIndexOutOfBoundsException e) {
            k.qg("sbr", e.getMessage());
        }
    }

    private void hd() {
        if (!this.bb || this.n == null) {
            return;
        }
        pk pkVar = this.qg;
        if ((pkVar == null || pkVar.dd() == null || this.qg.dd().qg() != 0) ? false : true) {
            this.n.setVideoViewVisibility(8);
        } else {
            this.n.setVideoViewVisibility(0);
            this.n.setVoiceViewListener(new View.OnClickListener() { // from class: com.byazt.hw.n.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    sz.n(n.this.oj, n.this.lq ? "tt_splash_unmute" : "tt_splash_mute", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.hw.n.1.1
                        @Override // com.byazt.qyj.n
                        public void n(Bitmap bitmap) {
                            n.this.n.setVoiceViewImageDrawable(new BitmapDrawable(n.this.oj.getResources(), bitmap));
                        }
                    }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                    n nVar = n.this;
                    nVar.lq = !nVar.lq;
                    if (n.this.lh != null) {
                        n.this.lh.qg(n.this.lq);
                    }
                }
            });
        }
    }

    private void qg(int i) {
        TsView tsView = this.n;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    private void n(pk pkVar) {
        TsView tsView;
        if (pkVar == null || (tsView = this.n) == null) {
            return;
        }
        tsView.n(pkVar);
    }

    public void s(boolean z) {
        com.byazt.mz.n nVar = this.kc;
        if (nVar != null) {
            nVar.n(this.hf, this.qg, this.ci, z);
        }
    }

    private void cd() {
        EmptyView emptyView = new EmptyView(this.oj, this.n, this.qg.yq());
        emptyView.n(this.qg, this.dg);
        emptyView.setAdType(3);
        this.n.addView(emptyView);
        emptyView.setCallback(new EmptyView.n() { // from class: com.byazt.hw.n.3
            public volatile boolean qg = false;

            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z) {
                if (n.this.s != null) {
                    if (z) {
                        n.this.s.onResume();
                    } else {
                        n.this.s.onPause();
                    }
                }
                if (n.this.df != null && n.this.df.qg() != null) {
                    n.this.df.qg().qg(z);
                }
                n.this.s(z ? 12 : 13);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                s();
                n.this.s(14);
            }

            private void s() {
                boolean z = true;
                if (this.qg) {
                    if (n.this.s != null) {
                        try {
                            n.this.s.init();
                            n nVar = n.this;
                            if (nf.n(nVar.qg) == 1) {
                                z = false;
                            }
                            nVar.w(z);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                this.qg = true;
                if (n.this.qg.rv() == 4) {
                    com.byazt.ag.qg.n(new com.byazt.qit.x("splash_register_download") { // from class: com.byazt.hw.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.l(nf.n(n.this.qg) != 1);
                        }
                    });
                }
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                n.this.s(15);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n(View view, Map<String, Object> map) {
                boolean andSet;
                com.byazt.de.qg.n(n.this.qg(), n.this.a.get());
                s();
                n.this.s(11);
                n.this.cy = System.currentTimeMillis();
                if (n.this.x != null) {
                    n.this.x.z_();
                }
                if (n.this.qg != null && n.this.hd != null) {
                    n.this.qg.d(n.this.hd.l());
                    n.this.um.put("cache_type", Integer.valueOf(com.byazt.nf.rv.qg().x(com.byazt.vgx.w.cy(n.this.qg))));
                    n.this.um.put("splash_show_time_type", Integer.valueOf(n.this.an));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    n.this.um.put("show_send_type", map.get("show_send_type"));
                }
                n.this.um.put("is_repeat", Boolean.valueOf(n.this.a.get()));
                n.this.ae.set(true);
                boolean z = false;
                if (!n.this.z.get()) {
                    n.this.z.set(true);
                    com.byazt.hm.n.n(n.this.qg, n.this.dg, n.this.um, n.this.wo);
                    com.byazt.hnb.qg.n().q();
                    com.byazt.cd.s.n(n.this.qg != null ? n.this.qg.v() : 0);
                }
                n.this.py();
                if (!n.this.dn) {
                    n.this.a();
                }
                n nVar = n.this;
                nVar.q(nVar.rv.get());
                boolean zIt = com.byazt.nf.rv.qg().it();
                if (n.this.fs != null && (!(andSet = n.this.a.getAndSet(true)) || zIt)) {
                    n.this.fs.n(n.this);
                    if (n.this.qg != null && n.this.qg.ur() && n.this.qg.sz() != null) {
                        com.byazt.rl.n.n().n(n.this.oj, n.this.qg.sz().qg());
                    }
                    if (!andSet) {
                        if (view == null) {
                            view = n.this.n;
                        }
                        if (view != null) {
                            pk pkVar = n.this.qg;
                            String str = n.this.dg;
                            if (n.this.qg != null && n.this.qg.wn()) {
                                z = true;
                            }
                            com.byazt.uq.qg.n(pkVar, str, view, z);
                        }
                    }
                }
                n.this.um();
                n.this.ln.set(true);
                if (n.this.n != null) {
                    n.this.n.setIsShowSuccess(true);
                }
                n.this.s(true);
            }
        });
        if (!this.dn) {
            emptyView.setNeedCheckingShow(true);
        }
        this.tj.put("splash_show_type", Integer.valueOf(this.oa));
        this.l = new com.byazt.ys.n(this.oj, this.qg, this.dg, 4) { // from class: com.byazt.hw.n.4
            @Override // com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, com.byazt.gct.tj tjVar) {
                if ((view instanceof SplashClickBarBtn) && n.this.cp) {
                    return;
                }
                super.n(view, tjVar);
            }
        };
        ((com.byazt.zct.n) this.l.n(com.byazt.zct.n.class)).n(this);
        ((com.byazt.fq.n) this.l.n(com.byazt.fq.n.class)).n(this.tj);
        n((com.byazt.fq.s) this.l.n(com.byazt.fq.s.class), emptyView);
        this.l.qg(this.n.getDislikeView());
        com.byazt.zct.n.InterfaceC0409n interfaceC0409n = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.hw.n.5
            @Override // com.byazt.zct.n.InterfaceC0409n
            public void n(View view, int i) {
                com.byazt.de.qg.s(n.this.qg());
                com.byazt.hm.n.qg(n.this.cy, n.this.qg);
                if (n.this.fs != null) {
                    n.this.fs.qg(n.this);
                }
                n.this.d();
                n.this.cy();
            }
        };
        ((com.byazt.zct.n) this.l.n(com.byazt.zct.n.class)).n(interfaceC0409n);
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), interfaceC0409n, com.byazt.zct.n.InterfaceC0409n.class);
        }
        this.n.setSkipListener(new View.OnClickListener() { // from class: com.byazt.hw.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.cp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        this.he.n(1.0f, i);
    }

    public void cp() {
        com.byazt.de.qg.s(qg(), 1);
        if (!this.k) {
            this.k = true;
            this.cp = true;
            if (!TextUtils.isEmpty(this.qg.F_())) {
                com.byazt.hm.n.n(this.cy > 0 ? System.currentTimeMillis() - this.cy : 0L, this.qg);
            }
            wm();
            com.byazt.hm.n.qg(this.cy, this.qg);
            s(false);
            k();
        }
        com.byazt.cne.n nVar = this.fs;
        if (nVar != null) {
            nVar.n(this, 1);
        }
    }

    public void n(final com.byazt.fq.s sVar, final EmptyView emptyView) {
        sVar.n(new com.byazt.fq.s.n() { // from class: com.byazt.hw.n.7
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar.n(emptyView);
                sVar.n(n.this.um);
                sVar.n(n.this.dg);
                sVar.n(n.this.wo);
                return n.this.ae.get();
            }
        });
    }

    public void d() {
        this.rf.postDelayed(new Runnable() { // from class: com.byazt.hw.n.8
            @Override // java.lang.Runnable
            public void run() {
                n.this.sz = true;
                if (!com.byazt.wif.w.n) {
                    if (n.this.ic != null) {
                        n.this.ic.qg();
                    }
                } else {
                    com.byazt.wif.w.n = false;
                    if (n.this.s instanceof com.byazt.oh.n) {
                        ((com.byazt.oh.n) n.this.s).n().n(new com.byazt.pma.n() { // from class: com.byazt.hw.n.8.1
                            @Override // com.byazt.pma.n
                            public void n() {
                            }

                            @Override // com.byazt.pma.n
                            public void qg() {
                            }

                            @Override // com.byazt.pma.n
                            public void s() {
                                if (n.this.ic != null) {
                                    n.this.ic.qg();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        com.byazt.vyf.s.cy().s().s(new C0196n(this.qg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TsView tsView = this.n;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i = 0; i < this.n.getChildCount(); i++) {
                View childAt = this.n.getChildAt(i);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.n.removeView(childAt);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py() {
        TsView tsView = this.n;
        if (tsView != null) {
            tsView.n(this.qg.of(), this.l);
            if (nf.n(this.qg) == 1) {
                oa();
            }
        }
    }

    public void oa() {
        el elVarBr;
        pk pkVar = this.qg;
        if (pkVar == null || (elVarBr = pkVar.br()) == null || elVarBr.rv() != 5) {
            return;
        }
        final int iK = elVarBr.k();
        final el.n nVarSz = elVarBr.sz();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.byazt.hw.n.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int iQ = com.byazt.okk.s.q(n.this.oj, view.getWidth());
                int iQ2 = com.byazt.okk.s.q(n.this.oj, view.getHeight());
                int iQ3 = com.byazt.okk.s.q(n.this.oj, motionEvent.getX());
                int iQ4 = com.byazt.okk.s.q(n.this.oj, motionEvent.getY());
                boolean z = iQ3 >= nVarSz.n() && iQ4 >= nVarSz.s() && iQ - iQ3 >= nVarSz.qg() && iQ2 - iQ4 >= nVarSz.q();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            n.this.pk = motionEvent.getY();
                        }
                    } else {
                        if (!z) {
                            return false;
                        }
                        n.this.pk = motionEvent.getY();
                        int iQ5 = com.byazt.okk.s.q(n.this.oj, Math.abs(n.this.pk - n.this.u));
                        if (n.this.pk - n.this.u < 0.0f && iQ5 > iK && n.this.l != null && n.this.n != null) {
                            n.this.l.onClick(n.this.n);
                        }
                    }
                } else {
                    if (!z) {
                        return false;
                    }
                    n.this.u = motionEvent.getY();
                }
                return true;
            }
        };
        this.w = onTouchListener;
        TsView tsView = this.n;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    public void q(boolean z) {
        if (z || this.n == null) {
            return;
        }
        if (this.f.get() == 2 && fl.n(this.qg)) {
            com.byazt.pi.qg qgVar = this.fi;
            if (qgVar != null) {
                qgVar.q();
                return;
            }
            return;
        }
        com.byazt.pi.q countDownView = this.n.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.byazt.pi.n() { // from class: com.byazt.hw.n.10
                @Override // com.byazt.pi.n
                public void n() {
                    n.this.sz();
                }
            });
            countDownView.n(false);
            countDownView.n();
        }
    }

    public void sz() {
        wm();
        com.byazt.hm.n.qg(this.cy, this.qg);
        com.byazt.de.qg.s(qg(), 1);
        com.byazt.cne.n nVar = this.fs;
        if (nVar != null && !this.cp) {
            this.cp = true;
            nVar.n(this, 2);
            s(false);
        }
        k();
    }

    public void k() {
        com.byazt.vyf.s.cy().tj(true);
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS == null) {
            return;
        }
        nVarS.s((com.byazt.ot.n.qg) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        TsView tsView;
        Context context;
        this.s = com.byazt.iz.fs.n(this.oj, this.qg, this.dg);
        w(z);
        n(this.s);
        if (this.s != null) {
            this.s.init();
        }
        if (this.s == null || (tsView = this.n) == null || tsView.getParent() == null) {
            return;
        }
        try {
            context = ((View) this.n.getParent()).getContext();
        } catch (Exception unused) {
            context = null;
        }
        if (context instanceof Activity) {
            this.s.setActivity((Activity) context, false);
        }
    }

    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        if (this.l != null) {
            ((com.byazt.zct.n) this.l.n(com.byazt.zct.n.class)).n(this.s);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 203, 829})
    private static final class s implements AppDownloadListener {
        public final WeakReference<n> n;
        public final boolean qg;
        public final String s;

        private s(n nVar, boolean z, String str) {
            this.n = new WeakReference<>(nVar);
            this.qg = z;
            this.s = str;
        }

        private com.byazt.mi.s n() {
            n nVar = this.n.get();
            if (nVar == null || nVar.q == null) {
                return null;
            }
            return nVar.q.get();
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onIdle() {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.n();
            }
            if (this.qg) {
                com.byazt.ll.qg.n.n(this.s, 1, 0);
            }
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.n(j, j2, str, str2);
            }
            if (!this.qg || j <= 0) {
                return;
            }
            com.byazt.ll.qg.n.n(this.s, 3, (int) ((j2 * 100) / j));
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.qg(j, j2, str, str2);
            }
            if (!this.qg || j <= 0) {
                return;
            }
            com.byazt.ll.qg.n.n(this.s, 2, (int) ((j2 * 100) / j));
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.s(j, j2, str, str2);
            }
            if (!this.qg || j <= 0) {
                return;
            }
            com.byazt.ll.qg.n.n(this.s, 4, (int) ((j2 * 100) / j));
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.n(j, str, str2);
            }
            if (this.qg) {
                com.byazt.ll.qg.n.n(this.s, 5, 100);
            }
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onInstalled(String str, String str2) {
            com.byazt.mi.s sVarN = n();
            if (sVarN != null) {
                sVarN.n(str, str2);
            }
            if (this.qg) {
                com.byazt.ll.qg.n.n(this.s, 6, 100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        pk pkVar = this.qg;
        this.s.addAppDownloadListener(new s(z, pkVar != null ? pkVar.q() : ""));
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        if (i == 1) {
            long j = this.nf + 1;
            this.nf = j;
            if (j >= this.pe) {
                this.rf.sendEmptyMessage(2);
                return;
            } else {
                this.rf.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (!this.cx && dn.n(this.qg)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.byazt.hm.n.qg(this.qg, "splash_ad", "splash_card_close", jSONObject);
            } catch (JSONException unused) {
            }
        }
        m();
    }

    @Override // com.byazt.hi.TsView.n
    public void rv() {
        AtomicBoolean atomicBoolean = this.ln;
        if (atomicBoolean != null && atomicBoolean.get()) {
            k.n("开屏view重复展示");
            TsView tsView = this.n;
            if (tsView != null && tsView.getCountDownView() != null && this.n.getCountDownView().getView() != null) {
                this.n.getCountDownView().getView().setVisibility(0);
            }
            q(this.rv.get());
        }
        this.vb = 1;
    }

    @Override // com.byazt.hi.TsView.n
    public void tj() {
        if (this.s != null) {
            this.s.onDestroy();
        }
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.n(pkVar.py());
            com.byazt.ikv.qg.n(this.qg.ih());
        }
        pk pkVar2 = this.qg;
        com.byazt.cd.s.qg(pkVar2 != null ? pkVar2.v() : 0);
        com.byazt.pi.qg qgVar = this.fi;
        if (qgVar != null) {
            qgVar.n();
        }
        com.byazt.hi.x.n(1, this.qg, this.dg, this.vb);
    }

    @Override // com.byazt.hi.TsView.n
    public void n(boolean z) {
        com.byazt.pi.qg qgVar = this.fi;
        if (qgVar != null) {
            qgVar.n(z);
        }
        this.vb++;
    }

    /* JADX INFO: renamed from: com.byazt.hw.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 203, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0196n implements com.byazt.ot.n.qg {
        public pk n;

        @Override // com.byazt.ot.n.qg
        public void q() {
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
        }

        public C0196n(pk pkVar) {
            this.n = pkVar;
        }

        @Override // com.byazt.ot.n.qg
        public void n() {
            com.byazt.hm.n.qg(this.n, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
            com.byazt.hm.n.qg(this.n, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }
    }

    @Override // com.byazt.fvm.qg
    public View q() {
        tj tjVar;
        if (this.ou && (tjVar = this.ic) != null) {
            return tjVar.n();
        }
        return null;
    }

    @Override // com.byazt.fvm.qg
    public int l() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.rv();
    }

    @Override // com.byazt.fvm.qg
    public void n(com.byazt.mi.s sVar) {
        if (sVar == null) {
            return;
        }
        this.q = new SoftReference<>(sVar);
    }

    @Override // com.byazt.fvm.qg
    public void n(com.byazt.cne.n nVar) {
        this.fs = nVar;
    }

    @Override // com.byazt.fvm.qg
    public void x() {
        if (!this.rv.getAndSet(true)) {
            com.byazt.hi.x.n(2, this.qg, this.dg, 0);
        }
        TsView tsView = this.n;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.byazt.fvm.qg
    public void n(com.byazt.cne.qg qgVar) {
        this.e = qgVar;
        com.byazt.hi.n nVar = this.dh;
        if (nVar != null) {
            nVar.n(qgVar);
        }
    }

    @Override // com.byazt.fvm.qg
    public void n(ViewGroup viewGroup, Activity activity) {
        this.yw = activity;
        qg(viewGroup);
    }

    @Override // com.byazt.fvm.qg
    public com.byazt.nq.x fs() {
        return new l();
    }

    @Override // com.byazt.fvm.qg
    public Map<String, Object> w() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return null;
        }
        v vVar = pkVar.jo().get(0);
        if (vVar == null) {
            return this.qg.wl();
        }
        if (!vVar.w()) {
            return this.qg.wl();
        }
        String strN = vVar.n();
        Map<String, Object> mapWl = this.qg.wl();
        mapWl.put(SDMAdConst.NETWORK_CUSTOM_KEY.IMAGE_URL, strN);
        return mapWl;
    }

    private void qg(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.ou || (tsView = this.n) == null || this.qg == null || this.ic == null || this.b) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.b = true;
        ViewGroup viewGroupN = this.ic.n();
        if (viewGroupN == null) {
            return;
        }
        com.byazt.ia.q qVar = this.lh;
        if (qVar != null) {
            qVar.w();
        }
        if (viewGroupN.getParent() != null) {
            ((ViewGroup) viewGroupN.getParent()).removeView(viewGroupN);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(viewGroupN);
            com.byazt.okk.s.fs(this.n);
            this.n.removeAllViews();
            this.n = null;
        }
        viewGroupN.setOnClickListener(null);
        viewGroupN.setOnTouchListener(null);
        if (this.m) {
            com.byazt.ia.q qVar2 = this.lh;
            if (qVar2 != null) {
                qVar2.tj();
            }
            this.lh = null;
        }
        this.ic.n(this.lh, new tj.n() { // from class: com.byazt.hw.n.2
            @Override // com.byazt.hi.tj.n
            public void n(long j) {
                n.this.rf.removeMessages(1);
                if (j < 0) {
                    n.this.rf.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        n.this.rf.sendEmptyMessage(2);
                        return;
                    }
                    n.this.pe = j;
                    n.this.nf = 0L;
                    n.this.rf.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.byazt.hi.tj.n
            public void n() {
                n.this.rf.removeMessages(1);
            }

            @Override // com.byazt.hi.tj.n
            public void qg() {
                n.this.cx = true;
                n.this.m();
            }

            @Override // com.byazt.hi.tj.n
            public Context getActivity() {
                return n.this.yw;
            }
        });
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
        if (this.sh) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d);
        this.sh = true;
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.y) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d, str, str2);
        this.y = true;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
        this.wo = d;
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.n(pkVar.py(), qgVar, com.byazt.mi.qg.class);
        }
    }

    private boolean ou() {
        return (!dn.n(this.qg) || this.sz || this.k || this.py) ? false : true;
    }

    private void wm() {
        boolean z = false;
        this.cx = false;
        tj tjVar = new tj();
        this.ic = tjVar;
        tjVar.n(this.oj, this.qg);
        if (!this.dh.s() && ou()) {
            z = true;
        }
        if (z) {
            SoftReference<com.byazt.mi.s> softReference = this.q;
            if (softReference == null) {
                this.ic.n(this.dg, this.oa, this.dh, null);
            } else {
                this.ic.n(this.dg, this.oa, this.dh, softReference.get());
            }
            this.ou = true;
            this.ic.n(2);
            com.byazt.hi.n nVar = this.dh;
            if (nVar != null) {
                nVar.n(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.b) {
            this.wm = false;
            return;
        }
        if (this.ri) {
            return;
        }
        this.ri = true;
        com.byazt.hi.n nVar = this.dh;
        if (nVar != null) {
            nVar.n();
            this.dh = null;
        }
        com.byazt.ia.q qVar = this.lh;
        if (qVar != null) {
            qVar.tj();
        }
        this.fs = null;
        this.s = null;
        this.yw = null;
    }

    public void n(int i) {
        this.j = i;
    }

    @Override // com.byazt.fvm.qg
    public String qg() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return null;
        }
        return pkVar.h();
    }
}
