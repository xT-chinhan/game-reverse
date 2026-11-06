package com.byazt.za;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.mr.EmptyView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m extends qg implements wo.n {
    public static final String TAG = "TTBannerExpressAd";
    public com.byazt.wg.qg cp;
    public com.byazt.tk.t d;
    public AppDownloadListener fs;
    public NativeExpressView h;
    public w hu;
    public pk l;
    public x m;
    public int oa;
    public final Context q;
    public WeakReference<BannerExpressBackupView> rv;
    public q s;
    public com.byazt.lr.n sz;
    public boolean t;
    public ITTInnerDownloadAdapter tj;
    public com.byazt.zq.qg w;
    public volatile View wm;
    public n x;
    public String k = com.byazt.wg.qg.AD_TAG_BANNER;
    public final Queue<Long> cy = new LinkedList();
    public Double hd = null;
    public boolean cd = false;
    public boolean um = false;
    public AtomicBoolean a = new AtomicBoolean(false);
    public AtomicBoolean py = new AtomicBoolean(false);
    public AtomicBoolean ou = new AtomicBoolean(false);

    @Override // com.byazt.fvm.sz
    public void n(JSONObject jSONObject) {
    }

    @Override // com.byazt.fvm.sz
    public void x() {
    }

    public m(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        this.t = false;
        this.q = context;
        this.l = pkVar;
        this.w = qgVar;
        boolean z = true;
        com.byazt.de.qg.n(pkVar, qgVar, 1, tj());
        boolean z2 = pkVar == null || pkVar.y();
        if (!(pkVar == null || pkVar.rf()) && !z2) {
            z = false;
        }
        this.t = z;
        n(context, pkVar, qgVar);
        n(this.s.getCurView(), this.l, false);
    }

    public void n(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        if (context == null) {
            return;
        }
        this.s = new q(context, pkVar, qgVar);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public View n() {
        com.byazt.eo.q.n().n(this.l).n(1);
        return this.s;
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
        this.l.pt().qg(this.k);
        return new com.byazt.oj.n(this.l.pt());
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.fx.qg qgVar) {
        n nVarN = n.n(this, qgVar);
        this.x = nVarN;
        this.s.setExpressInteractionListener(nVarN);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.fx.n nVar) {
        n nVarN = n.n((com.byazt.fvm.sz) this, nVar);
        this.x = nVarN;
        this.s.setExpressInteractionListener(nVarN);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.mi.s sVar) {
        this.fs = AppDownloadListener.Converter.convert(sVar);
        if (this.n != null) {
            this.n.n(this.fs);
        }
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
        com.byazt.wg.qg qgVar = this.cp;
        if (qgVar != null) {
            qgVar.n(this.s);
        }
        this.s.l();
        com.byazt.eo.q.n().n(this.l).n(1);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void l() {
        super.l();
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.s != null) {
                    m.this.s.q();
                }
            }
        });
        com.byazt.tk.t tVar = this.d;
        if (tVar != null) {
            tVar.removeCallbacksAndMessages(null);
            this.d = null;
        }
        pk pkVar = this.l;
        com.byazt.cd.s.qg(pkVar != null ? pkVar.v() : 0);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(Activity activity, final com.byazt.lr.n nVar) {
        if (nVar == null || activity == null) {
            return;
        }
        com.byazt.lr.n nVar2 = new com.byazt.lr.n(null) { // from class: com.byazt.za.m.2
            @Override // com.byazt.lr.n
            public void qg() {
                nVar.qg();
            }

            @Override // com.byazt.lr.n
            public void n(int i, String str, boolean z) {
                com.byazt.de.qg.s(m.this.tj(), 1);
                nVar.n(i, str, z);
            }

            @Override // com.byazt.lr.n
            public void n() {
                nVar.n();
            }
        };
        this.sz = nVar2;
        qg(activity, nVar2);
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
        q qVar = this.s;
        if (qVar == null || qVar.getCurView() == null) {
            return;
        }
        this.s.getCurView().setOuterDislike(dialog);
    }

    @Override // com.byazt.za.qg
    public pk cp() {
        return this.l;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public com.byazt.fvm.x n(Activity activity) {
        if (this.cp == null) {
            qg(activity, (com.byazt.lr.n) null);
        }
        return this.cp;
    }

    private void qg(Activity activity, com.byazt.lr.n nVar) {
        if (this.cp == null) {
            com.byazt.wg.qg qgVar = new com.byazt.wg.qg(activity, this.l.pt(), this.k, false, com.byazt.imu.s.n());
            this.cp = qgVar;
            com.byazt.yo.s.n(activity, this.l, qgVar);
        }
        com.byazt.wg.qg qgVar2 = this.cp;
        if (qgVar2 != null) {
            qgVar2.n(this.s);
        }
        this.cp.n(nVar);
        q qVar = this.s;
        if (qVar == null || qVar.getCurView() == null) {
            return;
        }
        this.s.getCurView().setDislike(this.cp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        if (this.l.rv() == 4) {
            com.byazt.ag.qg.n(new com.byazt.qit.x("banner_express_register_download") { // from class: com.byazt.za.m.3
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.l.rv() == 4) {
                        m mVar = m.this;
                        mVar.tj = com.byazt.iz.fs.n(mVar.q, m.this.l, m.this.k);
                        m.this.tj.onResume();
                        if (m.this.q instanceof Activity) {
                            m.this.tj.setActivity((Activity) m.this.q, false);
                        }
                        if (m.this.m != null) {
                            ((com.byazt.zct.n) m.this.m.n(com.byazt.zct.n.class)).n(m.this.tj);
                        }
                        if (m.this.hu != null) {
                            ((com.byazt.zct.n) m.this.hu.n(com.byazt.zct.n.class)).n(m.this.tj);
                        }
                        m mVar2 = m.this;
                        mVar2.n(mVar2.tj, m.this.h);
                        m.this.tj.init();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.byazt.tk.t tVar;
        if (this.wm == null || !this.wm.isShown() || (tVar = this.d) == null) {
            return;
        }
        tVar.removeCallbacksAndMessages(null);
        this.d.sendEmptyMessageDelayed(112201, this.oa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        com.byazt.tk.t tVar = this.d;
        if (tVar != null) {
            tVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(pk pkVar) {
        if (this.s.getNextView() == null || !this.s.qg()) {
            return;
        }
        n(this.s.getNextView(), pkVar.pt());
        this.ou.set(false);
        n(this.s.getNextView(), pkVar, true);
    }

    private void n(NativeExpressView nativeExpressView, com.byazt.oj.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        if (this.sz != null) {
            this.cp.n(qgVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.cp);
            }
        }
        if (this.qg != null) {
            n(qgVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.qg);
            }
        }
    }

    public void n(final NativeExpressView nativeExpressView, final pk pkVar, boolean z) {
        if (nativeExpressView == null || pkVar == null) {
            return;
        }
        this.h = nativeExpressView;
        pk pkVar2 = this.l;
        if (pkVar2 != null) {
            com.byazt.cd.s.qg(pkVar2.v());
        }
        this.l = pkVar;
        nativeExpressView.setBackupListener(new com.byazt.udb.s() { // from class: com.byazt.za.m.4
            @Override // com.byazt.udb.s
            public boolean n(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).um();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    bannerExpressBackupView.n(m.this.l, (NativeExpressView) viewGroup, m.this.tj);
                    bannerExpressBackupView.setDislikeInner(m.this.cp);
                    bannerExpressBackupView.setDislikeOuter(m.this.qg);
                    if (m.this.l != null) {
                        m.this.n(pkVar.pt());
                    }
                    m.this.rv = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        EmptyView emptyViewN = n(nativeExpressView);
        if (emptyViewN == null) {
            EmptyView emptyView = new EmptyView(this.q, nativeExpressView, pkVar != null ? pkVar.yq() : 1000);
            emptyView.setAdType(1);
            emptyView.n(this.l, this.k);
            nativeExpressView.addView(emptyView);
            emptyViewN = emptyView;
        }
        this.wm = emptyViewN;
        emptyViewN.setCallback(new EmptyView.n() { // from class: com.byazt.za.m.5
            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z2) {
                String unused = m.this.k;
                if (m.this.tj != null) {
                    if (z2) {
                        m.this.tj.onResume();
                    } else {
                        m.this.tj.onPause();
                    }
                }
                if (z2) {
                    m.this.k();
                } else {
                    m.this.cy();
                }
                m.this.n(z2, pkVar);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                m.this.sz();
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                if (m.this.tj != null) {
                    m.this.tj.onDestroy();
                }
                m.this.qg(pkVar);
                m.this.a.set(false);
                m.this.py.set(false);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n(View view, Map<String, Object> map) {
                if (m.this.cy != null) {
                    m.this.cy.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                }
                Map mapN = m.this.n(nativeExpressView, pkVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapN.put("show_send_type", map.get("show_send_type"));
                }
                mapN.put("is_repeat", Boolean.valueOf(m.this.ou.get()));
                m.this.a.set(true);
                if (!m.this.py.get()) {
                    m.this.py.set(true);
                    com.byazt.hm.n.n(pkVar, m.this.k, (Map<String, Object>) mapN, m.this.hd);
                    com.byazt.hnb.qg.n().q();
                    pk pkVar3 = pkVar;
                    com.byazt.cd.s.n(pkVar3 != null ? pkVar3.v() : 0);
                }
                boolean zIt = com.byazt.nf.rv.qg().it();
                boolean andSet = m.this.ou.getAndSet(true);
                if (m.this.x != null && (!andSet || zIt)) {
                    m.this.x.qg(view, pkVar.rv());
                    if (pkVar.ur() && pkVar.sz() != null) {
                        com.byazt.rl.n.n().n(m.this.q, pkVar.sz().qg());
                    }
                }
                if (!andSet) {
                    if (view == null) {
                        view = nativeExpressView;
                    }
                    com.byazt.uq.qg.n(pkVar, m.this.k, view, pkVar.wn());
                }
                m.this.k();
                if (m.this.s == null || m.this.s.getCurView() == null) {
                    return;
                }
                m.this.s.getCurView().hd();
                m.this.s.getCurView().k();
            }
        });
        x xVar = new x(this.q, pkVar, this.k, 2);
        this.m = xVar;
        final com.byazt.fq.s sVar = (com.byazt.fq.s) xVar.n(com.byazt.fq.s.class);
        final EmptyView emptyView2 = emptyViewN;
        sVar.n(new com.byazt.fq.s.n() { // from class: com.byazt.za.m.6
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar.n(emptyView2);
                sVar.n(m.this.n(nativeExpressView, pkVar));
                sVar.n(m.this.k);
                sVar.n(m.this.hd);
                return m.this.a.get();
            }
        });
        this.m.n(nativeExpressView);
        ((com.byazt.zct.n) this.m.n(com.byazt.zct.n.class)).n(this);
        nativeExpressView.setClickListener(this.m);
        w wVar = new w(this.q, pkVar, this.k, 2);
        this.hu = wVar;
        final com.byazt.fq.s sVar2 = (com.byazt.fq.s) wVar.n(com.byazt.fq.s.class);
        sVar2.n(new com.byazt.fq.s.n() { // from class: com.byazt.za.m.7
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar2.n(emptyView2);
                sVar2.n(m.this.n(nativeExpressView, pkVar));
                sVar2.n(m.this.k);
                sVar2.n(m.this.hd);
                return m.this.a.get();
            }
        });
        this.hu.n(nativeExpressView);
        ((com.byazt.zct.n) this.hu.n(com.byazt.zct.n.class)).n(this);
        nativeExpressView.setClickCreativeListener(this.hu);
        if (!this.t) {
            emptyViewN.setNeedCheckingShow(true);
        }
        if (z) {
            sz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> n(NativeExpressView nativeExpressView, pk pkVar) {
        HashMap map = new HashMap();
        bb.n(map, this.l, nativeExpressView);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter, NativeExpressView nativeExpressView) {
        if (iTTInnerDownloadAdapter == null || nativeExpressView == null) {
            return;
        }
        pk pkVar = this.l;
        this.n = new qg.n(this.fs, pkVar != null ? pkVar.q() : "");
        iTTInnerDownloadAdapter.addAppDownloadListener(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(pk pkVar) {
        Queue<Long> queue = this.cy;
        if (queue == null || queue.size() <= 0 || pkVar == null) {
            return;
        }
        try {
            long jLongValue = this.cy.poll().longValue();
            if (jLongValue > 0) {
                String string = new StringBuilder().append(SystemClock.elapsedRealtime() - jLongValue).toString();
                com.byazt.hm.qg qgVar = new com.byazt.hm.qg(this.l, this.k);
                qgVar.n(1.0f);
                com.byazt.hm.n.n(string, pkVar, this.k, 15, qgVar.qg());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, pk pkVar) {
        Queue<Long> queue = this.cy;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            if (queue.size() > 0) {
                String string = new StringBuilder().append(SystemClock.elapsedRealtime() - this.cy.poll().longValue()).toString();
                com.byazt.hm.qg qgVar = new com.byazt.hm.qg(this.l, this.k);
                qgVar.n(1.0f);
                com.byazt.hm.n.n(string, pkVar, this.k, 13, qgVar.qg());
            }
        } catch (Exception unused) {
        }
    }

    private EmptyView n(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
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

    /* JADX WARN: Code duplicated, block: B:6:0x001e A[PHI: r0
      0x001e: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:5:0x001c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(int i) {
        if (i <= 0) {
            return;
        }
        this.k = com.byazt.wg.qg.AD_TAG_EXPRESS_BANNER;
        n(this.s.getCurView(), this.l, false);
        this.s.setDuration(1000);
        int i2 = 30000;
        if (i < 30000) {
            i = i2;
        } else {
            i2 = 120000;
            if (i > 120000) {
                i = i2;
            }
        }
        this.oa = i;
        this.d = new com.byazt.tk.t(Looper.getMainLooper(), this);
    }

    private void hd() {
        y yVar = new y();
        yVar.x = 2;
        final String string = UUID.randomUUID().toString();
        yVar.um = string;
        com.byazt.uq.qg.n(this.w, true, string);
        com.byazt.nf.rv.n().n(this.w, yVar, 1, new com.byazt.yy.n(new com.byazt.mw.n.qg() { // from class: com.byazt.za.m.8
            @Override // com.byazt.mw.n.qg
            public void n(int i, String str, com.byazt.gct.qg qgVar) {
                m.this.k();
            }

            @Override // com.byazt.mw.n.qg
            public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(nVar.qg());
                if (copyOnWriteArrayList.isEmpty()) {
                    m.this.k();
                    return;
                }
                com.byazt.uq.qg.n(copyOnWriteArrayList, string);
                pk pkVar = (pk) copyOnWriteArrayList.get(0);
                pkVar.n(string);
                com.byazt.uq.qg.n(pkVar, m.this.k);
                m.this.s.n(pkVar, m.this.w);
                m.this.n(pkVar);
                m.this.s.s();
            }
        }));
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 112201 && this.wm != null && this.wm.isShown()) {
            hd();
        }
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void n(Double d) {
        if (this.cd) {
            return;
        }
        com.byazt.vgx.l.n(this.l, d);
        this.cd = true;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.um) {
            return;
        }
        com.byazt.vgx.l.n(this.l, d, str, str2);
        this.um = true;
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.fs
    public void qg(Double d) {
        this.hd = d;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.qg.s(tj(), 3);
    }
}
