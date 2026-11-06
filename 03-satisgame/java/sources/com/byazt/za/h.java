package com.byazt.za;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import com.byazt.mr.EmptyView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 878})
public class h extends qg {
    public static final String TAG = "TTNativeExpressAd";
    public x cd;
    public ITTInnerDownloadAdapter cp;
    public n fs;
    public boolean h;
    public EmptyView hu;
    public pk l;
    public final com.byazt.tx.qg ou;
    public final FrameLayout py;
    public final Context q;
    public AppDownloadListener rv;
    public NativeExpressView s;
    public final com.byazt.hm.qg t;
    public com.byazt.wg.qg tj;
    public w um;
    public int ur;
    public com.byazt.tx.n wm;
    public WeakReference<sz> x;
    public String w = com.byazt.wg.qg.AD_TAG_FEED;
    public Double d = null;
    public boolean oa = false;
    public boolean sz = false;
    public AtomicBoolean k = new AtomicBoolean(false);
    public AtomicBoolean cy = new AtomicBoolean(false);
    public AtomicBoolean hd = new AtomicBoolean(false);
    public volatile boolean a = false;
    public final ViewGroup m = new FrameLayout(com.byazt.nf.rv.getContext());
    public final n bb = new n() { // from class: com.byazt.za.h.1
        @Override // com.byazt.za.n
        public void n(View view, int i) {
            if (h.this.fs != null) {
                h.this.fs.n(h.this.m, i);
            }
        }

        @Override // com.byazt.za.n
        public void qg(View view, int i) {
            boolean zIt = com.byazt.nf.rv.qg().it();
            if (h.this.fs != null && (!h.this.hd.getAndSet(true) || zIt)) {
                h.this.fs.qg(h.this.m, i);
                com.byazt.gct.hd hdVarSz = h.this.l.sz();
                if (h.this.l.ur() && hdVarSz != null) {
                    com.byazt.rl.n.n().n(h.this.q, hdVarSz.qg());
                }
            }
            if (h.this.ou == null || h.this.ou.qg() == null) {
                return;
            }
            h.this.ou.qg().q();
        }

        @Override // com.byazt.za.n
        public void n(View view, String str, int i) {
            if (h.this.fs != null) {
                h.this.fs.n(h.this.m, str, i);
            }
        }

        @Override // com.byazt.za.n
        public void n(View view, float f, float f2) {
            if (h.this.s != null && h.this.ou != null) {
                h.this.s.setEasyPlayableSender(h.this.ou.qg());
                h.this.ou.n(h.this.s.getEasyPlayableLayout(), h.this.s.getVideoContainer());
            }
            h.this.sz();
            h.this.m.removeAllViews();
            h.this.m.addView(view);
            h.this.m.addView(h.this.py, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (h.this.fs != null) {
                h.this.fs.n(h.this.m, f, f2);
            }
        }
    };

    public h(Context context, final pk pkVar, com.byazt.zq.qg qgVar, int i) {
        this.h = false;
        this.ur = 5;
        this.ur = i;
        this.q = context;
        this.l = pkVar;
        this.h = (pkVar == null || pkVar.rf()) || (pkVar == null || pkVar.y());
        com.byazt.de.qg.n(pkVar, qgVar, i, tj());
        n(context, pkVar, qgVar);
        this.py = new FrameLayout(context);
        this.t = new com.byazt.hm.qg(this.l, this.w);
        this.ou = new com.byazt.tx.qg(pkVar, new com.byazt.rg.n() { // from class: com.byazt.za.h.2
            @Override // com.byazt.rg.n
            public void n(ViewGroup viewGroup) {
            }

            @Override // com.byazt.za.d
            public void n(pk pkVar2) {
            }

            @Override // com.byazt.za.d
            public void s(int i2) {
            }

            @Override // com.byazt.za.d
            public void n(int i2) {
                if (h.this.s != null) {
                    h.this.s.n(i2);
                }
            }

            @Override // com.byazt.za.d
            public long n() {
                if (h.this.s != null) {
                    return h.this.s.n();
                }
                return 0L;
            }

            @Override // com.byazt.za.d
            public int qg() {
                if (h.this.s != null) {
                    return h.this.s.qg();
                }
                return 0;
            }

            @Override // com.byazt.za.d
            public int s() {
                if (h.this.s != null) {
                    return h.this.s.s();
                }
                return 0;
            }

            @Override // com.byazt.za.d
            public void q() {
                if (h.this.s != null) {
                    h.this.s.q();
                }
            }

            @Override // com.byazt.za.d
            public void qg(int i2) {
                if (h.this.s != null) {
                    h.this.s.qg(i2);
                }
            }

            @Override // com.byazt.za.d
            public void l() {
                if (h.this.s != null) {
                    h.this.s.l();
                }
            }

            @Override // com.byazt.za.d
            public void n(int i2, String str) {
                if (h.this.s != null) {
                    h.this.s.n(i2, str);
                }
            }

            @Override // com.byazt.za.d
            public void setPauseFromExpressView(boolean z) {
                if (h.this.s != null) {
                    h.this.s.setPauseFromExpressView(z);
                }
            }

            @Override // com.byazt.za.d
            public void n(float f) {
                if (h.this.s != null) {
                    h.this.s.n(f);
                }
            }

            @Override // com.byazt.za.d
            public void n(int i2, int i3) {
                if (h.this.s != null) {
                    h.this.s.n(i2, i3);
                }
            }

            @Override // com.byazt.rg.n
            public void n(View view) {
                h.this.bb.n(view, pkVar.rv());
                pk pkVar2 = pkVar;
                com.byazt.rg.s.n(pkVar2, (com.byazt.gct.oa) com.byazt.gct.h.rv(pkVar2), true, (JSONObject) null);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i2, com.byazt.twc.s sVar, g gVar) {
                if (h.this.s != null) {
                    h.this.s.n(view, i2, sVar, -1);
                }
                com.byazt.rg.s.n(pkVar, (com.byazt.gct.oa) gVar, false, (JSONObject) null, sVar instanceof com.byazt.gct.wm ? ((com.byazt.gct.wm) sVar).n().optBoolean("isLottieInternalClick", false) : false);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i2, com.byazt.twc.s sVar, int i3) {
                if (h.this.s != null) {
                    h.this.s.n(view, i2, sVar, i3);
                }
            }
        });
    }

    public void n(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, pkVar, qgVar, this.w);
        this.s = nativeExpressView;
        this.m.addView(nativeExpressView);
        n(this.s, this.l);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public View n() {
        com.byazt.eo.q.n().n(this.l);
        return this.m;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public int qg() {
        pk pkVar = this.l;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.ge();
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public com.byazt.fvm.q w() {
        pk pkVar = this.l;
        if (pkVar == null || pkVar.pt() == null) {
            return null;
        }
        this.l.pt().qg(this.w);
        return new com.byazt.oj.n(this.l.pt());
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.fx.qg qgVar) {
        this.fs = n.n(this, qgVar);
        this.s.setExpressInteractionListener(this.bb);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.fx.n nVar) {
        this.fs = n.n((com.byazt.fvm.sz) this, nVar);
        this.s.setExpressInteractionListener(this.bb);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.mi.s sVar) {
        this.rv = AppDownloadListener.Converter.convert(sVar);
        if (this.n != null) {
            this.n.n(this.rv);
        }
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public Map<String, Object> fs() {
        pk pkVar = this.l;
        if (pkVar != null) {
            return pkVar.wl();
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.nq.l rv() {
        return new com.byazt.fp.s();
    }

    @Override // com.byazt.fvm.sz
    public String tj() {
        pk pkVar = this.l;
        if (pkVar != null) {
            return pkVar.h();
        }
        return null;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public int s() {
        pk pkVar = this.l;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.rv();
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void q() {
        com.byazt.wg.qg qgVar = this.tj;
        if (qgVar != null) {
            qgVar.n(this.s);
        }
        this.s.cy();
        com.byazt.eo.q.n().n(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        pk pkVar = this.l;
        if (pkVar == null || pkVar.tk() == null) {
            return;
        }
        com.byazt.tx.n nVar = this.wm;
        if (nVar != null) {
            nVar.qg();
        }
        com.byazt.tx.n nVar2 = new com.byazt.tx.n(this.l);
        this.wm = nVar2;
        if (nVar2.n()) {
            NativeExpressView nativeExpressView = this.s;
            ViewGroup gameContainer = nativeExpressView != null ? nativeExpressView.getGameContainer() : null;
            if (gameContainer instanceof FrameLayout) {
                this.wm.n((FrameLayout) gameContainer, (View) gameContainer);
            }
        }
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void l() {
        super.l();
        com.byazt.de.qg.s(tj(), 2);
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.oa();
        }
        this.t.n(com.byazt.okk.q.qg(this.s), 16);
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.cp;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onDestroy();
        }
        com.byazt.tx.qg qgVar = this.ou;
        if (qgVar != null) {
            qgVar.s();
        }
        com.byazt.tx.n nVar = this.wm;
        if (nVar != null) {
            nVar.qg();
        }
        pk pkVar = this.l;
        com.byazt.cd.s.qg(pkVar != null ? pkVar.v() : 0);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(Activity activity, final com.byazt.lr.n nVar) {
        if (nVar == null || activity == null) {
            return;
        }
        qg(activity, new com.byazt.lr.n(null) { // from class: com.byazt.za.h.3
            @Override // com.byazt.lr.n
            public void qg() {
                nVar.qg();
            }

            @Override // com.byazt.lr.n
            public void n(int i, String str, boolean z) {
                com.byazt.de.qg.s(h.this.tj(), 1);
                nVar.n(i, str, z);
            }

            @Override // com.byazt.lr.n
            public void n() {
                nVar.n();
            }
        });
    }

    @Override // com.byazt.fvm.sz
    public void n(String str) {
        com.byazt.hm.n.qg(this.l, str);
    }

    @Override // com.byazt.za.qg
    public void n(Dialog dialog) {
        if (dialog == null) {
            com.byazt.tk.k.n("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.byazt.za.qg
    public pk cp() {
        return this.l;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public com.byazt.fvm.x n(Activity activity) {
        if (this.tj == null) {
            qg(activity, null);
        }
        return this.tj;
    }

    @Override // com.byazt.fvm.sz
    public void n(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.n(jSONObject);
        }
    }

    @Override // com.byazt.fvm.sz
    public void x() {
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.ou();
        }
    }

    private void qg(Activity activity, com.byazt.lr.n nVar) {
        if (this.tj == null) {
            com.byazt.wg.qg qgVar = new com.byazt.wg.qg(activity, this.l.pt(), this.w, false, com.byazt.imu.s.n());
            this.tj = qgVar;
            com.byazt.yo.s.n(activity, this.l, qgVar);
        }
        com.byazt.wg.qg qgVar2 = this.tj;
        if (qgVar2 != null) {
            qgVar2.n(this.s);
        }
        this.tj.n(nVar);
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.tj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.a) {
            if (this.cp != null) {
                x xVar = this.cd;
                if (xVar != null) {
                    ((com.byazt.zct.n) xVar.n(com.byazt.zct.n.class)).n(this.cp);
                }
                w wVar = this.um;
                if (wVar != null) {
                    ((com.byazt.zct.n) wVar.n(com.byazt.zct.n.class)).n(this.cp);
                }
                try {
                    n(this.cp, this.s);
                    this.cp.init();
                    this.cp.addAppDownloadListener(this.n);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.a = true;
        if (this.l.rv() == 4) {
            com.byazt.ag.qg.n(new com.byazt.qit.x("native_register_download") { // from class: com.byazt.za.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h hVar = h.this;
                    hVar.cp = com.byazt.iz.fs.n(hVar.q, h.this.l, h.this.w);
                    if (h.this.cd != null) {
                        ((com.byazt.zct.n) h.this.cd.n(com.byazt.zct.n.class)).n(h.this.cp);
                    }
                    if (h.this.um != null) {
                        ((com.byazt.zct.n) h.this.um.n(com.byazt.zct.n.class)).n(h.this.cp);
                    }
                    if (h.this.q instanceof Activity) {
                        h.this.cp.setActivity((Activity) h.this.q, false);
                    }
                    h hVar2 = h.this;
                    hVar2.n(hVar2.cp, h.this.s);
                    h.this.cp.init();
                    h.this.cp.addAppDownloadListener(h.this.n);
                }
            });
        }
    }

    public void n(final NativeExpressView nativeExpressView, final pk pkVar) {
        this.l = pkVar;
        nativeExpressView.setBackupListener(new com.byazt.udb.s() { // from class: com.byazt.za.h.5
            @Override // com.byazt.udb.s
            public boolean n(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).um();
                    sz szVar = new sz(viewGroup.getContext());
                    com.byazt.lu.qg.n(Integer.valueOf(pkVar.hashCode()), h.this);
                    szVar.n(h.this.l, (NativeExpressView) viewGroup, h.this.cp);
                    szVar.setDislikeInner(h.this.tj);
                    szVar.setDislikeOuter(h.this.qg);
                    if (h.this.l != null) {
                        h hVar = h.this;
                        hVar.n(hVar.l.pt());
                    }
                    h.this.x = new WeakReference<>(szVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        EmptyView emptyViewN = n(nativeExpressView);
        this.hu = emptyViewN;
        if (emptyViewN == null) {
            EmptyView emptyView = new EmptyView(this.q, nativeExpressView, pkVar != null ? pkVar.yq() : 1000);
            this.hu = emptyView;
            emptyView.setAdType(this.ur);
            this.hu.n(this.l, this.w);
            nativeExpressView.addView(this.hu);
        }
        this.hu.setCallback(new EmptyView.n() { // from class: com.byazt.za.h.6
            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z) {
                Activity activity;
                WeakReference<Activity> weakReferenceN;
                Activity activity2;
                if (h.this.cp != null) {
                    if (z) {
                        h.this.cp.onResume();
                    } else {
                        h.this.cp.onPause();
                    }
                }
                if (h.this.ou != null && h.this.ou.qg() != null) {
                    h.this.ou.qg().qg(z);
                }
                if (h.this.wm != null) {
                    h.this.wm.n(z);
                }
                h.this.t.n(com.byazt.okk.q.qg(nativeExpressView), z ? 12 : 13);
                if (com.byazt.vgx.w.q(h.this.l)) {
                    if (z) {
                        if (!com.byazt.vgx.w.q(h.this.l) || (weakReferenceN = com.byazt.vyf.s.cy().s().n()) == null || (activity2 = weakReferenceN.get()) == null) {
                            return;
                        }
                        com.byazt.fr.s.n().n(activity2.getWindow(), h.this.l, com.byazt.vgx.w.bb(h.this.l));
                        return;
                    }
                    WeakReference<Activity> weakReferenceN2 = com.byazt.vyf.s.cy().s().n();
                    if (weakReferenceN2 == null || (activity = weakReferenceN2.get()) == null) {
                        return;
                    }
                    com.byazt.fr.s.n().qg((Context) activity, h.this.l, true);
                }
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                WeakReference<Activity> weakReferenceN;
                Activity activity;
                h.this.k();
                h.this.t.n(com.byazt.okk.q.qg(nativeExpressView), 14);
                if (!com.byazt.vgx.w.q(h.this.l) || (weakReferenceN = com.byazt.vyf.s.cy().s().n()) == null || (activity = weakReferenceN.get()) == null) {
                    return;
                }
                com.byazt.fr.s.n().n(activity.getWindow(), h.this.l, com.byazt.vgx.w.bb(h.this.l));
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                WeakReference<Activity> weakReferenceN;
                Activity activity;
                if (h.this.cp != null) {
                    h.this.cp.onDestroy();
                }
                h.this.t.n(com.byazt.okk.q.qg(nativeExpressView), 15);
                h.this.k.set(false);
                h.this.cy.set(false);
                if (!com.byazt.vgx.w.q(h.this.l) || (weakReferenceN = com.byazt.vyf.s.cy().s().n()) == null || (activity = weakReferenceN.get()) == null) {
                    return;
                }
                com.byazt.fr.s.n().qg(activity.getWindow(), h.this.l, true);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n(View view, Map<String, Object> map) {
                h.this.k();
                h.this.t.n(com.byazt.okk.q.qg(view), 11);
                Map mapCy = h.this.cy();
                mapCy.put("is_repeat", Boolean.valueOf(h.this.hd.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapCy.put("show_send_type", map.get("show_send_type"));
                }
                mapCy.put("is_repeat", Boolean.valueOf(h.this.hd.get()));
                h.this.k.set(true);
                if (!h.this.cy.get()) {
                    h.this.cy.set(true);
                    com.byazt.hm.n.n(pkVar, h.this.w, (Map<String, Object>) mapCy, h.this.d);
                    com.byazt.hnb.qg.n().q();
                    pk pkVar2 = pkVar;
                    com.byazt.cd.s.n(pkVar2 != null ? pkVar2.v() : 0);
                }
                boolean z = (h.this.fs == null || h.this.hd.get()) ? false : true;
                h.this.bb.qg(view, pkVar.rv());
                if (z) {
                    if (view == null) {
                        view = h.this.m;
                    }
                    pk pkVar3 = pkVar;
                    String str = h.this.w;
                    pk pkVar4 = pkVar;
                    com.byazt.uq.qg.n(pkVar3, str, view, pkVar4 != null && pkVar4.wn());
                }
                if (h.this.s != null) {
                    h.this.s.hd();
                    h.this.s.k();
                }
            }
        });
        Context context = this.q;
        String str = this.w;
        x xVar = new x(context, pkVar, str, com.byazt.vgx.w.q(str));
        this.cd = xVar;
        n((com.byazt.fq.s) xVar.n(com.byazt.fq.s.class));
        this.cd.n(nativeExpressView);
        ((com.byazt.zct.n) this.cd.n(com.byazt.zct.n.class)).n(this);
        this.s.setClickListener(this.cd);
        Context context2 = this.q;
        String str2 = this.w;
        w wVar = new w(context2, pkVar, str2, com.byazt.vgx.w.q(str2));
        this.um = wVar;
        n((com.byazt.fq.s) wVar.n(com.byazt.fq.s.class));
        this.um.n(nativeExpressView);
        ((com.byazt.zct.n) this.um.n(com.byazt.zct.n.class)).n(this);
        this.s.setClickCreativeListener(this.um);
        if (this.h) {
            return;
        }
        this.hu.setNeedCheckingShow(true);
    }

    public void n(final com.byazt.fq.s sVar) {
        sVar.n(new com.byazt.fq.s.n() { // from class: com.byazt.za.h.7
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar.n(h.this.hu);
                sVar.n(h.this.cy());
                sVar.n(h.this.w);
                sVar.n(h.this.d);
                return h.this.k.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> cy() {
        HashMap map = new HashMap();
        bb.n(map, this.l, this.s);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter, NativeExpressView nativeExpressView) {
        if (iTTInnerDownloadAdapter == null || nativeExpressView == null) {
            return;
        }
        pk pkVar = this.l;
        this.n = new qg.n(this.rv, pkVar != null ? pkVar.q() : "");
        iTTInnerDownloadAdapter.addAppDownloadListener(this.n);
    }

    private EmptyView n(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void n(Double d) {
        if (this.oa) {
            return;
        }
        com.byazt.vgx.l.n(this.l, d);
        this.oa = true;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.sz) {
            return;
        }
        com.byazt.vgx.l.n(this.l, d, str, str2);
        this.sz = true;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void qg(Double d) {
        this.d = d;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.qg.s(tj(), 3);
    }
}
