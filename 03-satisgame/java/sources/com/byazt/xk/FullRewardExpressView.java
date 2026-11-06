package com.byazt.xk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.bpa.FullSwiperItemView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gn.w;
import com.byazt.nf.rv;
import com.byazt.udb.q;
import com.byazt.udb.s;
import com.byazt.udb.sz;
import com.byazt.za.FullRewardExpressBackupView;
import com.byazt.za.NativeExpressView;
import com.byazt.za.bb;
import com.byazt.za.cy;
import com.byazt.za.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 92, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL})
public class FullRewardExpressView extends NativeExpressView implements d {
    public com.byazt.ve.n bb;
    public View h;
    public n hu;
    public sz l;
    public com.byazt.mkl.n ln;
    public HashSet<String> m;
    public d n;
    public q q;
    public FullRewardExpressBackupView qg;
    public com.byazt.zx.n s;
    public com.byazt.du.n.InterfaceC0157n t;
    public FullSwiperItemView.n ur;
    public ImageView wm;

    public interface n {
        void n(int i);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void setPauseFromExpressView(boolean z) {
    }

    public FullRewardExpressView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str, boolean z, String str2) {
        super(context, pkVar, qgVar, str, z, str2);
        this.m = new HashSet<>();
    }

    @Override // com.byazt.za.NativeExpressView
    public void sz() {
        this.cy = true;
        this.sz = new FrameLayout(this.w);
        super.sz();
        wm();
        if (getJsObject() != null) {
            getJsObject().d(this.a);
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.h = view;
    }

    public void setInteractListener(FullSwiperItemView.n nVar) {
        this.ur = nVar;
    }

    private void wm() {
        setBackupListener(new s() { // from class: com.byazt.xk.FullRewardExpressView.1
            @Override // com.byazt.udb.s
            public boolean n(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).um();
                    FullRewardExpressView.this.qg = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.qg.n(FullRewardExpressView.this.rv, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    public void setExpressVideoListenerProxy(d dVar) {
        this.n = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    @Override // com.byazt.za.NativeExpressView
    public void qg(q<? extends View> qVar, sz szVar) {
        boolean z;
        FrameLayout frameLayoutHd;
        View view;
        this.q = qVar;
        com.byazt.mkl.n nVar = this.ln;
        if (nVar != null) {
            n(nVar);
            this.ln = null;
        }
        if (qVar instanceof cy) {
            cy cyVar = (cy) qVar;
            if (cyVar.x_() != null) {
                cyVar.x_().n((d) this);
            }
            if (cyVar.x_() != null) {
                cyVar.x_().s(this.tj);
            }
        }
        if (qVar instanceof com.byazt.gn.qg) {
            ((com.byazt.gn.qg) qVar).n(this);
        }
        if (szVar != null && szVar.s()) {
            this.l = szVar;
            if (szVar.qg() == 2) {
                View viewN = szVar.n();
                if (viewN instanceof ViewGroup) {
                    ((ViewGroup) viewN).addView(getVideoContainer());
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!z) {
                n((ViewGroup) this.sz, true);
            }
            if (szVar.qg() == 10 && (szVar instanceof com.byazt.gn.q)) {
                com.byazt.ve.n nVarUm = ((com.byazt.gn.q) szVar).um();
                this.bb = nVarUm;
                if (nVarUm != null && (this.w instanceof TTBaseVideoActivity)) {
                    final TTBaseVideoActivity tTBaseVideoActivity = (TTBaseVideoActivity) this.w;
                    this.bb.n(new com.byazt.ve.n.InterfaceC0369n() { // from class: com.byazt.xk.FullRewardExpressView.2
                        @Override // com.byazt.ve.n.InterfaceC0369n
                        public boolean n() {
                            return tTBaseVideoActivity.pe();
                        }
                    });
                }
            }
            if (szVar.qg() == 10 && (szVar instanceof com.byazt.gn.q) && (frameLayoutHd = ((com.byazt.gn.q) szVar).hd()) != null && (view = this.h) != null) {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.h.getParent()).removeView(this.h);
                }
                frameLayoutHd.addView(this.h);
            }
        }
        super.qg(qVar, szVar);
        w(getVisibility());
    }

    public void n(final ViewGroup viewGroup, final boolean z) {
        if (this.l == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.xk.FullRewardExpressView.3
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.qg(viewGroup, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    public void qg(ViewGroup viewGroup, boolean z) {
        sz szVar = this.l;
        if (szVar == null) {
            return;
        }
        double dW = szVar.w();
        double dX = this.l.x();
        double dFs = this.l.fs();
        double dRv = this.l.rv();
        int iS = com.byazt.okk.s.s(this.w, (float) dW);
        int iS2 = com.byazt.okk.s.s(this.w, (float) dX);
        int iS3 = com.byazt.okk.s.s(this.w, (float) dFs);
        int iS4 = com.byazt.okk.s.s(this.w, (float) dRv);
        float fS = this.l.d() > 0.0f ? com.byazt.okk.s.s(this.w, this.l.d()) : 0.0f;
        float fS2 = this.l.oa() > 0.0f ? com.byazt.okk.s.s(this.w, this.l.oa()) : 0.0f;
        float fS3 = this.l.sz() > 0.0f ? com.byazt.okk.s.s(this.w, this.l.sz()) : 0.0f;
        float fS4 = this.l.k() > 0.0f ? com.byazt.okk.s.s(this.w, this.l.k()) : 0.0f;
        if (fS2 < fS) {
            fS = fS2;
        }
        if (fS3 >= fS) {
            fS3 = fS;
        }
        if (fS4 >= fS3) {
            fS4 = fS3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iS3, iS4);
        }
        layoutParams.width = iS3;
        layoutParams.height = iS4;
        layoutParams.topMargin = iS2;
        layoutParams.leftMargin = iS;
        viewGroup.setLayoutParams(layoutParams);
        com.byazt.okk.s.qg(viewGroup, fS4);
        if (z) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.q.qg() == 7 || this.q.qg() == 10) {
                sz szVar2 = this.l;
                if (szVar2 instanceof com.byazt.gn.q) {
                    FrameLayout frameLayoutCy = ((com.byazt.gn.q) szVar2).cy();
                    if (frameLayoutCy != null) {
                        frameLayoutCy.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else {
                    this.py.addView(viewGroup);
                }
            } else {
                this.py.addView(viewGroup);
            }
            n nVar = this.hu;
            if (nVar == null || iS4 == 0) {
                return;
            }
            nVar.n(iS4);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(boolean z) {
        super.n(z);
        this.a = z;
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(z);
        }
        q qVar = this.q;
        if (qVar == null || !(qVar instanceof com.byazt.iv.n)) {
            return;
        }
        ((com.byazt.iv.n) qVar).qg(z);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void w() {
        super.w();
        d dVar = this.n;
        if (dVar != null) {
            dVar.w();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void x() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.x();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(i);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public long n() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.n();
        }
        return 0L;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public int qg() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.qg();
        }
        return 0;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public int s() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.s();
        }
        return 0;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void fs() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.fs();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void rv() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.rv();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void tj() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.tj();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void q(int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.q(i);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(float f, float f2, float f3, float f4, int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(f, f2, f3, f4, i);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void qg(int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.qg(i);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void q() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.q();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void l() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(pk pkVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(pkVar);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(final int i, final String str) {
        this.t = new com.byazt.du.n.InterfaceC0157n() { // from class: com.byazt.xk.FullRewardExpressView.4
            @Override // com.byazt.du.n.InterfaceC0157n
            public void n(long j, long j2) {
                int iAbs = (int) Math.abs(((long) i) - j);
                int i2 = FullRewardExpressView.this.s instanceof com.byazt.ly.q ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || iAbs > i2 || i3 > j2 || iAbs >= i2 || FullRewardExpressView.this.m.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.byazt.xk.FullRewardExpressView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.s.w();
                            FullRewardExpressView.this.qg(i, str);
                            if (cx.hd(FullRewardExpressView.this.rv) || pe.n(FullRewardExpressView.this.rv)) {
                                FullRewardExpressView.this.n.n(2);
                            }
                            if (FullRewardExpressView.this.n != null) {
                                FullRewardExpressView.this.n.setPauseFromExpressView(true);
                            }
                        }
                    }, iAbs);
                } else {
                    FullRewardExpressView.this.s.w();
                    FullRewardExpressView.this.qg(i, str);
                    if (cx.hd(FullRewardExpressView.this.rv) || pe.n(FullRewardExpressView.this.rv)) {
                        FullRewardExpressView.this.n.n(2);
                    }
                    if (FullRewardExpressView.this.n != null) {
                        FullRewardExpressView.this.n.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.m.add(str);
            }
        };
        com.byazt.zx.n nVar = this.s;
        if (nVar != null) {
            nVar.s(50);
            this.s.n(this.t);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(float f) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(f);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(int i, int i2) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(i, i2);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void s(int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.s(i);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.udb.fs
    public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
        FullSwiperItemView.n nVar = this.ur;
        if (nVar != null) {
            nVar.n();
        }
        if (i != -1 && sVar != null && i == 3) {
            rv();
            return;
        }
        if (i == 5) {
            n(!this.a);
        } else if (i == 4) {
            m();
        } else {
            super.n(view, i, sVar, i2);
        }
    }

    private void m() {
        com.byazt.zx.n nVar;
        if ((this.q instanceof com.byazt.iv.n) && (nVar = this.s) != null) {
            if (nVar.ri()) {
                this.s.w();
                q(true);
            } else {
                this.s.fs();
                q(false);
            }
        }
    }

    @Override // com.byazt.za.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l(z);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.udb.fs
    public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
        FullSwiperItemView.n nVar = this.ur;
        if (nVar != null) {
            nVar.n();
        }
        if (i != -1 && sVar != null && i == 3) {
            rv();
        } else {
            super.qg(view, i, sVar, i2);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (py()) {
            return this.qg.getVideoContainer();
        }
        return this.sz;
    }

    public void setVideoController(com.byazt.iag.s sVar) {
        if (sVar instanceof com.byazt.zx.n) {
            com.byazt.zx.n nVar = (com.byazt.zx.n) sVar;
            this.s = nVar;
            nVar.s(50);
            this.s.n(this.t);
        }
    }

    @Override // com.byazt.za.NativeExpressView
    public com.byazt.iag.s getVideoController() {
        return this.s;
    }

    public void q(boolean z) {
        if (this.wm == null) {
            this.wm = new ImageView(getContext());
            if (com.byazt.vyf.s.cy().dg() != null) {
                this.wm.setImageBitmap(com.byazt.vyf.s.cy().dg());
            } else {
                com.byazt.tk.sz.n(rv.getContext(), "tt_new_play_video", this.wm, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.wm.setScaleType(ImageView.ScaleType.FIT_XY);
            int iS = com.byazt.okk.s.s(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iS, iS);
            layoutParams.gravity = 17;
            this.sz.addView(this.wm, layoutParams);
        }
        if (z) {
            this.wm.setVisibility(0);
        } else {
            this.wm.setVisibility(8);
        }
    }

    private void l(boolean z) {
        com.byazt.zx.n nVar;
        if ((this.q instanceof com.byazt.iv.n) && z) {
            ImageView imageView = this.wm;
            if (imageView != null && imageView.getVisibility() == 0 && (nVar = this.s) != null) {
                nVar.w();
            } else {
                n(this.a);
            }
        }
    }

    public void setOnVideoSizeChangeListener(n nVar) {
        this.hu = nVar;
    }

    @Override // com.byazt.za.NativeExpressView
    public void oa() {
        super.oa();
        this.m.clear();
    }

    public boolean cp() {
        sz szVar = this.l;
        if (szVar == null) {
            return true;
        }
        if (szVar instanceof com.byazt.gn.q) {
            return ((com.byazt.gn.q) szVar).cy() != null;
        }
        return (szVar.fs() == 0.0d || this.l.rv() == 0.0d) ? false : true;
    }

    @Override // com.byazt.za.NativeExpressView
    public void n(com.byazt.mkl.n nVar) {
        q qVar = this.q;
        if (qVar == null) {
            this.ln = nVar;
        } else if (qVar instanceof w) {
            ((w) qVar).n(nVar);
        } else if (qVar instanceof bb) {
            ((bb) qVar).n(nVar);
        }
    }

    public void qg(final String str) {
        if (this.q instanceof w) {
            n(new Runnable() { // from class: com.byazt.xk.FullRewardExpressView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (FullRewardExpressView.this.q instanceof w) {
                        w wVar = (w) FullRewardExpressView.this.q;
                        if ("started".equals(str)) {
                            wVar.cd();
                            return;
                        }
                        if ("paused".equals(str)) {
                            wVar.cy();
                        } else if ("playing".equals(str)) {
                            wVar.hd();
                        } else if ("finished".equals(str)) {
                            wVar.k();
                        }
                    }
                }
            });
        }
    }

    public void n(final long j, final long j2) {
        if (this.q instanceof w) {
            n(new Runnable() { // from class: com.byazt.xk.FullRewardExpressView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (FullRewardExpressView.this.q instanceof w) {
                        ((w) FullRewardExpressView.this.q).n(j, j2);
                    }
                }
            });
        }
    }

    public void n(final int i, final long j) {
        if (this.q instanceof w) {
            n(new Runnable() { // from class: com.byazt.xk.FullRewardExpressView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (FullRewardExpressView.this.q instanceof w) {
                        ((w) FullRewardExpressView.this.q).n(i, j);
                    }
                }
            });
        }
    }

    private void n(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            com.byazt.tk.rv.qg().post(runnable);
        }
    }

    public sz getRenderResult() {
        return this.l;
    }

    public void n(int i, int i2, int i3, int i4) {
        com.byazt.ve.n nVar = this.bb;
        if (nVar != null) {
            nVar.n(i, i2, i3, i4);
        }
    }

    public void d() {
        com.byazt.ve.n nVar = this.bb;
        if (nVar != null) {
            nVar.n();
        }
    }
}
