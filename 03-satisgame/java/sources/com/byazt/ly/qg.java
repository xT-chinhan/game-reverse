package com.byazt.ly;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.ej.k;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.tj;
import com.byazt.iz.fs;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.xk.FullRewardExpressView;
import com.byazt.za.NativeExpressView;
import com.byazt.za.bb;
import com.byazt.za.w;
import com.byazt.za.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 26})
public class qg {
    public ViewGroup cp;
    public boolean cy;
    public boolean d;
    public w fs;
    public FullRewardExpressView hd;
    public final boolean k;
    public final TTBaseVideoActivity n;
    public long oa;
    public boolean q;
    public final pk qg;
    public com.byazt.ys.n rv;
    public final String s;
    public ITTInnerDownloadAdapter tj;
    public int w;
    public x x;
    public final AtomicBoolean sz = new AtomicBoolean(false);
    public boolean l = false;

    public qg(final TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, String str, boolean z, boolean z2) {
        this.tj = null;
        this.n = tTBaseVideoActivity;
        this.qg = pkVar;
        this.s = str;
        this.k = z;
        this.cy = z2;
        x xVar = new x(tTBaseVideoActivity, pkVar, str, com.byazt.vgx.w.q(str)) { // from class: com.byazt.ly.qg.1
            @Override // com.byazt.za.x, com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, tj tjVar) {
                super.n(view, tjVar);
                tTBaseVideoActivity.n(2);
            }
        };
        this.x = xVar;
        ((com.byazt.fq.n) xVar.n(com.byazt.fq.n.class)).n(tTBaseVideoActivity.n(pkVar));
        w wVar = new w(tTBaseVideoActivity, pkVar, str, com.byazt.vgx.w.q(str)) { // from class: com.byazt.ly.qg.2
            @Override // com.byazt.za.w, com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, tj tjVar) {
                super.n(view, tjVar);
                com.byazt.dj.qg qgVar = (com.byazt.dj.qg) this.fs.n(com.byazt.dj.qg.class);
                if (qgVar == null || !qgVar.qg(view)) {
                    return;
                }
                tTBaseVideoActivity.n(2);
            }
        };
        this.fs = wVar;
        ((com.byazt.fq.n) wVar.n(com.byazt.fq.n.class)).n(tTBaseVideoActivity.n(pkVar));
        com.byazt.ys.n nVar = new com.byazt.ys.n(tTBaseVideoActivity, pkVar, str, 7);
        this.rv = nVar;
        tTBaseVideoActivity.n((com.byazt.fq.s) nVar.n(com.byazt.fq.s.class));
        ((com.byazt.fq.n) this.rv.n(com.byazt.fq.n.class)).n(tTBaseVideoActivity.n(pkVar));
        if (pkVar.rv() == 4) {
            this.tj = fs.n(tTBaseVideoActivity, pkVar, str);
            final String strQ = n().q();
            this.tj.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.ly.qg.3
                @Override // com.byazt.pmn.AppDownloadListener
                public void onIdle() {
                    com.byazt.ll.n.n(strQ);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadActive(long j, long j2, String str2, String str3) {
                    com.byazt.ll.n.n(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadPaused(long j, long j2, String str2, String str3) {
                    com.byazt.ll.n.qg(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFailed(long j, long j2, String str2, String str3) {
                    com.byazt.ll.n.s(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFinished(long j, String str2, String str3) {
                    com.byazt.ll.n.qg(strQ);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onInstalled(String str2, String str3) {
                    com.byazt.ll.n.s(strQ);
                }
            });
        }
    }

    public pk n() {
        return this.qg;
    }

    public String qg() {
        return this.s;
    }

    public com.byazt.ys.n s() {
        return this.rv;
    }

    public int q() {
        if (!pe.tj(this.qg)) {
            return 1;
        }
        if (this.d) {
            int iQg = pe.qg(this.qg) - this.w;
            this.w = pe.qg(this.qg);
            return iQg;
        }
        if (this.w >= pe.qg(this.qg)) {
            return 0;
        }
        this.w++;
        return 1;
    }

    public void n(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.cp = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || n() == null) {
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onResume();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.tj.setActivity((Activity) fullRewardExpressView.getContext(), false);
            }
        }
        this.x.n(fullRewardExpressView);
        ((com.byazt.zct.n) this.x.n(com.byazt.zct.n.class)).n(this.tj);
        fullRewardExpressView.setClickListener(this.x);
        this.fs.n(fullRewardExpressView);
        ((com.byazt.zct.n) this.fs.n(com.byazt.zct.n.class)).n(this.tj);
        fullRewardExpressView.setClickCreativeListener(this.fs);
        this.rv.n(viewGroup);
        ((com.byazt.zct.n) this.rv.n(com.byazt.zct.n.class)).n(this.tj);
        ImageView imageView = new ImageView(this.n);
        com.byazt.imu.s.n(this.qg.jo().get(0)).n(imageView);
        this.cp.addView(imageView);
    }

    public com.byazt.zx.n.InterfaceC0421n l() {
        return new com.byazt.zx.n.InterfaceC0421n() { // from class: com.byazt.ly.qg.4
            @Override // com.byazt.zx.n.InterfaceC0421n
            public void s() {
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n() {
                qg.this.d = true;
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n(int i, String str) {
                qg.this.x();
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void qg() {
                qg.this.x();
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n(long j, long j2) {
                com.byazt.okk.s.n((View) qg.this.cp, 8);
                qg.this.oa = j;
            }
        };
    }

    public void n(boolean z) {
        this.q = z;
    }

    public boolean w() {
        return this.q;
    }

    public void x() {
        com.byazt.okk.s.n((View) this.cp, 0);
        this.n.sz();
    }

    public void fs() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onDestroy();
        }
        FullRewardExpressView fullRewardExpressView = this.hd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.oa();
        }
        pk pkVar = this.qg;
        com.byazt.cd.s.qg(pkVar != null ? pkVar.v() : 0);
    }

    public void n(NativeExpressView nativeExpressView) {
        if (this.sz.getAndSet(true)) {
            return;
        }
        Map<String, Object> mapN = this.n.n(this.qg);
        bb.n(mapN, this.qg, nativeExpressView);
        com.byazt.hm.n.n(this.qg, this.s, mapN, this.n.wo());
        com.byazt.hnb.qg.n().q();
        pk pkVar = this.qg;
        com.byazt.cd.s.n(pkVar != null ? pkVar.v() : 0);
    }

    public void rv() {
        if (this.k) {
            this.n.n(this.qg, this.rv);
        }
    }

    public com.byazt.zsl.l tj() {
        com.byazt.zsl.l lVarN = ta.n(1, this.qg);
        lVarN.qg(this.qg.q());
        lVarN.qg(100);
        lVarN.s(100);
        lVarN.s(this.qg.F_());
        lVarN.qg(this.q);
        return lVarN;
    }

    public long cp() {
        return this.oa;
    }

    public void qg(boolean z) {
        this.qg.cd(z);
    }

    public void d() {
        if (this.cy) {
            return;
        }
        this.cy = true;
        pk pkVar = this.qg;
        com.byazt.zq.qg qgVarN = com.byazt.vgx.q.n(7, pkVar == null ? null : pkVar.mk());
        if (ta.k(this.qg) != null) {
            com.byazt.zsl.l lVarN = ta.n(1, this.qg);
            lVarN.n("material_meta", this.qg);
            lVarN.n("ad_slot", Integer.valueOf(qgVarN != null ? qgVarN.a() : 0));
            com.byazt.gks.s.n(lVarN, new com.byazt.ej.tj.n() { // from class: com.byazt.ly.qg.5
                @Override // com.byazt.ej.tj.n
                public void n(k kVar, int i) {
                }

                @Override // com.byazt.ej.tj.n
                public void qg(k kVar, int i) {
                    kVar.ou();
                    kVar.x();
                }

                @Override // com.byazt.ej.tj.n
                public void n(k kVar, int i, String str) {
                    kVar.ou();
                    kVar.x();
                }
            });
        }
    }

    public void n(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.n, n(), com.byazt.vgx.q.n(7, String.valueOf(com.byazt.vgx.w.cy(n())), f, f2, n()), qg(), false, null);
        this.hd = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().n(true);
        this.hd.setExpressInteractionListener(new com.byazt.za.n() { // from class: com.byazt.ly.qg.6
            @Override // com.byazt.za.n
            public void n(View view, float f3, float f4) {
                qg.this.l = true;
            }
        });
        this.hd.cy();
    }

    public FullRewardExpressView qg(float f, float f2) {
        if (this.hd == null) {
            n(f, f2);
        }
        return this.hd;
    }
}
