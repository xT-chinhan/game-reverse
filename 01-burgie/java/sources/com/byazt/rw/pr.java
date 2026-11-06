package com.byazt.rw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ca.g;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.hg.gu;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.pq;
import com.byazt.hg.vk;
import com.byazt.hg.wt;
import com.byazt.hg.y;
import com.byazt.jm.SplashClickBarBtn;
import com.byazt.jm.TsView;
import com.byazt.nv.hn;
import com.byazt.sd.EmptyView;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.vd.c;
import com.byazt.vkw.qi;
import com.byazt.vx.x;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.gz;
import com.byazt.wt.ls;
import com.byazt.zn.aj;
import com.byazt.zn.fw;
import com.byazt.zn.uc;
import com.byazt.zn.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.mar.sdk.MARCode;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, 37})
public class pr extends com.byazt.mr.hw implements qi.pr, TsView.pr {
    public volatile com.byazt.az.pr c;
    public boolean cz;
    public hw fw;
    public com.byazt.ks.pr gu;
    public boolean gz;
    public volatile hn hn;
    public of hw;
    public boolean ie;
    public com.byazt.zz.hw jn;
    public com.byazt.pj.hw jw;
    public Activity l;
    public zo lb;
    public boolean lv;
    public com.byazt.qe.hw mw;
    public boolean ny;
    public float of;
    public TsView pr;
    public String qi;
    public float qn;
    public x<aj, fw> sv;
    public View.OnTouchListener uc;
    public Context v;
    public com.byazt.bd.hw ve;
    public com.byazt.jm.aj vj;
    public com.byazt.zn.hn wt;
    public SoftReference<com.byazt.rkl.hn> x;
    public com.byazt.gz.x y;
    public uc yb;
    public fw z;
    public com.byazt.zz.pr zo;
    public AtomicBoolean aj = new AtomicBoolean(false);
    public final Map<String, Object> vk = new HashMap();
    public Double ii = null;
    public boolean i = false;
    public boolean r = false;
    public boolean w = false;
    public int k = 3;
    public int m = -1;
    public final iu hs = new iu(Looper.getMainLooper(), this);
    public boolean g = false;
    public boolean ho = false;
    public long nt = 0;
    public Map<String, Object> qa = new HashMap();
    public AtomicBoolean a = new AtomicBoolean(false);
    public boolean fo = true;
    public boolean rc = false;
    public com.byazt.jm.pr nw = new com.byazt.jm.pr();
    public boolean o = false;
    public long f = 0;
    public long bm = 5;
    public AtomicBoolean b = new AtomicBoolean(false);
    public AtomicBoolean iu = new AtomicBoolean(false);
    public AtomicBoolean nl = new AtomicBoolean(false);
    public boolean od = true;
    public AtomicBoolean ww = new AtomicBoolean(false);
    public int n = -1;
    public int e = -1;
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final AtomicInteger ls = new AtomicInteger(0);
    public com.byazt.ck.hw er = null;
    public boolean pq = false;
    public int aa = 0;

    public interface hw {
        void u_();
    }

    public void pr(com.byazt.zn.hn hnVar, x<aj, fw> xVar, com.byazt.ks.pr prVar) {
        if (hnVar == null || xVar == null) {
            return;
        }
        this.wt = hnVar;
        this.gu = prVar;
        this.ww.set(hnVar.aj());
        this.sv = xVar;
        fw fwVar = new fw();
        this.z = fwVar;
        fwVar.hw(hnVar.aj());
        this.z.pr(hnVar.hw());
        this.z.pr(this);
        this.v = hnVar.getContext();
        this.qi = hnVar.uc();
        this.yb = hnVar.x();
        boolean z = true;
        pr(hnVar.c(), true);
        this.mw = hnVar.fw();
        uc ucVar = this.yb;
        of ofVarHw = ucVar == null ? null : ucVar.hw();
        this.hw = ofVarHw;
        this.jw = new com.byazt.pj.hw(ofVarHw, this.qi);
        boolean zKx = a.hw().kx();
        if (!a.hw().hv() && !zKx) {
            z = false;
        }
        this.pq = z;
    }

    public synchronized void pr(zo zoVar, boolean z) {
        if (this.lb == null || !z) {
            this.lb = zoVar;
            if (zoVar != null) {
                hw(zoVar.c());
                this.ve = zoVar.x();
            }
        }
    }

    public void hw(boolean z) {
        try {
            this.gz = z;
            pr();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mr.hw
    public PluginValueSet zo() {
        return com.byazt.ij.pr.pr(super.zo()).pr(1, com.byazt.sd.iu.x).hw();
    }

    public void pr(x<aj, fw> xVar) {
        if (this.yb == null) {
            this.z.hw(3);
            this.z.pr("render splash ad model is null");
            xVar.pr(this.z);
            return;
        }
        if (this.lb == null) {
            this.z.hw(3);
            this.z.pr("render splash material is null");
            xVar.pr(this.z);
            return;
        }
        if (this.hw == null) {
            return;
        }
        try {
            this.w = false;
            TsView tsView = new TsView(this.v, this.qi, this.hw);
            this.pr = tsView;
            tsView.setAttachedToWindowListener(this);
            pr();
            this.pr.setCountDownViewPosition(this.hw);
            if (this.hw.wz() == 0) {
                TsView tsView2 = this.pr;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.pr;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.hw.mb() <= 0) {
                hw(3);
            } else {
                int iMb = this.hw.mb();
                this.k = iMb;
                hw(iMb);
            }
            pr(this.hw);
            hw();
        } catch (ArrayIndexOutOfBoundsException e) {
            ho.hw("sbr", e.getMessage());
        }
    }

    private void pr() {
        if (!this.gz || this.pr == null) {
            return;
        }
        of ofVar = this.hw;
        boolean z = (ofVar == null || ofVar.zn() == null || this.hw.zn().hw() != 0) ? false : true;
        if (z) {
            this.pr.setVideoViewVisibility(8);
        } else {
            this.pr.setVideoViewVisibility(0);
            this.pr.setVoiceViewListener(new View.OnClickListener() { // from class: com.byazt.rw.pr.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.pr(pr.this.v, pr.this.od ? "tt_splash_unmute" : "tt_splash_mute", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.rw.pr.1.1
                        @Override // com.byazt.ezf.pr
                        public void pr(Bitmap bitmap) {
                            pr.this.pr.setVoiceViewImageDrawable(new BitmapDrawable(pr.this.v.getResources(), bitmap));
                        }
                    }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                    pr prVar = pr.this;
                    prVar.od = !prVar.od;
                    if (pr.this.y != null) {
                        pr.this.y.hw(pr.this.od);
                    }
                }
            });
        }
    }

    private void hw(int i) {
        TsView tsView = this.pr;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    private void pr(of ofVar) {
        TsView tsView;
        if (ofVar == null || (tsView = this.pr) == null) {
            return;
        }
        tsView.pr(ofVar);
    }

    public void hn(boolean z) {
        com.byazt.ks.pr prVar = this.gu;
        if (prVar != null) {
            prVar.pr(this.sv, this.hw, this.mw, z);
        }
    }

    private void hw() {
        EmptyView emptyView = new EmptyView(this.v, this.pr, this.hw.ov());
        emptyView.pr(this.hw, this.qi);
        emptyView.setAdType(3);
        this.pr.addView(emptyView);
        emptyView.setCallback(new EmptyView.pr() { // from class: com.byazt.rw.pr.4
            public volatile boolean hw = false;

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z) {
                if (pr.this.hn != null) {
                    if (z) {
                        pr.this.hn.hw();
                    } else {
                        hn hnVar = pr.this.hn;
                    }
                }
                pr.this.hn(z ? 12 : 13);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                hn();
                pr.this.hn(14);
            }

            private void hn() {
                boolean z = true;
                if (this.hw) {
                    if (pr.this.hn != null) {
                        try {
                            pr.this.hn.pr();
                            pr prVar = pr.this;
                            if (ie.pr(prVar.hw) == 1) {
                                z = false;
                            }
                            prVar.uc(z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                this.hw = true;
                if (pr.this.hw.aj() == 4) {
                    com.byazt.zp.zo.pr(new com.byazt.xlm.fw("splash_register_download") { // from class: com.byazt.rw.pr.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pr.this.c(ie.pr(pr.this.hw) != 1);
                        }
                    });
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                pr.this.hn(15);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(View view, Map<String, Object> map) {
                boolean andSet;
                com.byazt.qd.hw.pr(pr.this.fo(), pr.this.a.get());
                hn();
                pr.this.hn(11);
                pr.this.nt = System.currentTimeMillis();
                if (pr.this.fw != null) {
                    pr.this.fw.u_();
                }
                if (pr.this.hw != null && pr.this.yb != null) {
                    pr.this.hw.vk(pr.this.yb.c());
                    pr.this.qa.put("cache_type", Integer.valueOf(a.hw().zo(ls.m(pr.this.hw))));
                    pr.this.qa.put("splash_show_time_type", Integer.valueOf(pr.this.e));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    pr.this.qa.put("show_send_type", map.get("show_send_type"));
                }
                pr.this.qa.put("is_repeat", Boolean.valueOf(pr.this.a.get()));
                pr.this.s.set(true);
                boolean z = false;
                if (!pr.this.d.get()) {
                    pr.this.d.set(true);
                    com.byazt.pj.pr.pr(pr.this.hw, pr.this.qi, pr.this.qa, pr.this.ii);
                    com.byazt.na.pr.pr().x();
                    e.pr(pr.this.hw != null ? pr.this.hw.nl() : 0);
                }
                pr.this.c();
                if (!pr.this.pq) {
                    pr.this.x();
                }
                pr prVar = pr.this;
                prVar.x(prVar.aj.get());
                boolean zMo = a.hw().mo();
                if (pr.this.zo != null && (!(andSet = pr.this.a.getAndSet(true)) || zMo)) {
                    pr.this.zo.pr(pr.this);
                    if (pr.this.hw != null && pr.this.hw.b() && pr.this.hw.g() != null) {
                        com.byazt.yq.pr.pr().pr(pr.this.v, pr.this.hw.g().hw());
                    }
                    if (!andSet) {
                        if (view == null) {
                            view = pr.this.pr;
                        }
                        if (view != null) {
                            of ofVar = pr.this.hw;
                            String str = pr.this.qi;
                            if (pr.this.hw != null && pr.this.hw.ji()) {
                                z = true;
                            }
                            com.byazt.ua.hw.pr(ofVar, str, view, z);
                        }
                    }
                }
                pr.this.hn();
                pr.this.nl.set(true);
                if (pr.this.pr != null) {
                    pr.this.pr.setIsShowSuccess(true);
                }
                pr.this.hn(true);
            }
        });
        if (!this.pq) {
            emptyView.setNeedCheckingShow(true);
        }
        this.vk.put("splash_show_type", Integer.valueOf(this.m));
        this.c = new com.byazt.az.pr(this.v, this.hw, this.qi, 4) { // from class: com.byazt.rw.pr.5
            @Override // com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, vk vkVar) {
                if ((view instanceof SplashClickBarBtn) && pr.this.w) {
                    return;
                }
                super.pr(view, vkVar);
            }
        };
        ((com.byazt.dl.pr) this.c.pr(com.byazt.dl.pr.class)).pr(this);
        ((com.byazt.yx.pr) this.c.pr(com.byazt.yx.pr.class)).pr(this.vk);
        pr((com.byazt.yx.hn) this.c.pr(com.byazt.yx.hn.class), emptyView);
        this.c.hw(this.pr.getDislikeView());
        com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.rw.pr.6
            @Override // com.byazt.dl.pr.InterfaceC0041pr
            public void pr(View view, int i) {
                com.byazt.qd.hw.hn(pr.this.fo());
                com.byazt.pj.pr.hw(pr.this.nt, pr.this.hw);
                if (pr.this.zo != null) {
                    pr.this.zo.hw(pr.this);
                }
                pr.this.w();
                pr.this.ny();
            }
        };
        ((com.byazt.dl.pr) this.c.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr);
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.hw(ofVar.le(), interfaceC0041pr, com.byazt.dl.pr.InterfaceC0041pr.class);
        }
        this.pr.setSkipListener(new View.OnClickListener() { // from class: com.byazt.rw.pr.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pr.this.vk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(int i) {
        this.jw.pr(1.0f, i);
    }

    public void vk() {
        com.byazt.qd.hw.hn(fo(), 1);
        if (!this.ho) {
            this.ho = true;
            this.w = true;
            if (!TextUtils.isEmpty(this.hw.B_())) {
                com.byazt.pj.pr.pr(this.nt > 0 ? System.currentTimeMillis() - this.nt : 0L, this.hw);
            }
            ho();
            com.byazt.pj.pr.hw(this.nt, this.hw);
            hn(false);
            g();
        }
        com.byazt.zz.pr prVar = this.zo;
        if (prVar != null) {
            prVar.pr(this, 1);
        }
    }

    public void pr(final com.byazt.yx.hn hnVar, final EmptyView emptyView) {
        hnVar.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.rw.pr.8
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar.pr(emptyView);
                hnVar.pr(pr.this.qa);
                hnVar.pr(pr.this.qi);
                hnVar.pr(pr.this.ii);
                return pr.this.s.get();
            }
        });
    }

    public void w() {
        this.hs.postDelayed(new Runnable() { // from class: com.byazt.rw.pr.9
            @Override // java.lang.Runnable
            public void run() {
                pr.this.g = true;
                if (!com.byazt.wr.uc.pr) {
                    if (pr.this.vj != null) {
                        pr.this.vj.hw();
                    }
                } else {
                    com.byazt.wr.uc.pr = false;
                    if (pr.this.hn instanceof com.byazt.ri.pr) {
                        ((com.byazt.ri.pr) pr.this.hn).fw().pr(new com.byazt.rx.pr() { // from class: com.byazt.rw.pr.9.1
                            @Override // com.byazt.rx.pr
                            public void pr() {
                            }

                            @Override // com.byazt.rx.pr
                            public void hw() {
                            }

                            @Override // com.byazt.rx.pr
                            public void hn() {
                                if (pr.this.vj != null) {
                                    pr.this.vj.hw();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        com.byazt.sd.zo.nt().hn().hn(new C0180pr(this.hw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        TsView tsView = this.pr;
        if (tsView == null || tsView.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < this.pr.getChildCount(); i++) {
            View childAt = this.pr.getChildAt(i);
            if (childAt != null && (childAt instanceof EmptyView)) {
                this.pr.removeView(childAt);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        TsView tsView = this.pr;
        if (tsView != null) {
            tsView.pr(this.hw.lj(), this.c);
            if (ie.pr(this.hw) == 1) {
                k();
            }
        }
    }

    public void k() {
        pq pqVarJl;
        of ofVar = this.hw;
        if (ofVar == null || (pqVarJl = ofVar.jl()) == null || pqVarJl.aj() != 5) {
            return;
        }
        final int iHo = pqVarJl.ho();
        final pq.pr prVarG = pqVarJl.g();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.byazt.rw.pr.10
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int iX = er.x(pr.this.v, view.getWidth());
                int iX2 = er.x(pr.this.v, view.getHeight());
                int iX3 = er.x(pr.this.v, motionEvent.getX());
                int iX4 = er.x(pr.this.v, motionEvent.getY());
                boolean z = iX3 >= prVarG.pr() && iX4 >= prVarG.hn() && iX - iX3 >= prVarG.hw() && iX2 - iX4 >= prVarG.x();
                switch (motionEvent.getAction()) {
                    case 0:
                        if (!z) {
                            return false;
                        }
                        pr.this.qn = motionEvent.getY();
                        return true;
                    case 1:
                        if (!z) {
                            return false;
                        }
                        pr.this.of = motionEvent.getY();
                        int iX5 = er.x(pr.this.v, Math.abs(pr.this.of - pr.this.qn));
                        if (pr.this.of - pr.this.qn < 0.0f && iX5 > iHo && pr.this.c != null && pr.this.pr != null) {
                            pr.this.c.onClick(pr.this.pr);
                        }
                        return true;
                    case 2:
                        pr.this.of = motionEvent.getY();
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.uc = onTouchListener;
        TsView tsView = this.pr;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    public void x(boolean z) {
        if (z || this.pr == null) {
            return;
        }
        if (this.ls.get() == 2 && wt.pr(this.hw)) {
            com.byazt.ck.hw hwVar = this.er;
            if (hwVar != null) {
                hwVar.hw();
                return;
            }
            return;
        }
        com.byazt.ck.x countDownView = this.pr.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.byazt.ck.pr() { // from class: com.byazt.rw.pr.11
                @Override // com.byazt.ck.pr
                public void pr() {
                    pr.this.m();
                }
            });
            countDownView.pr(false);
            countDownView.pr();
        }
    }

    public void m() {
        ho();
        com.byazt.pj.pr.hw(this.nt, this.hw);
        com.byazt.qd.hw.hn(fo(), 1);
        com.byazt.zz.pr prVar = this.zo;
        if (prVar != null && !this.w) {
            this.w = true;
            prVar.pr(this, 2);
            hn(false);
        }
        g();
    }

    public void g() {
        com.byazt.sd.zo.nt().zo(true);
        com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        if (prVarHn == null) {
            return;
        }
        prVarHn.hn((com.byazt.wt.pr.hw) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        TsView tsView;
        this.hn = com.byazt.jx.zo.pr(this.v, this.hw, this.qi);
        uc(z);
        pr(this.hn);
        if (this.hn != null) {
            this.hn.pr();
        }
        if (this.hn == null || (tsView = this.pr) == null || tsView.getParent() == null) {
            return;
        }
        Context context = null;
        try {
            context = ((View) this.pr.getParent()).getContext();
        } catch (Exception e) {
        }
        if (context instanceof Activity) {
            this.hn.pr((Activity) context, false);
        }
    }

    public void pr(hn hnVar) {
        if (this.c != null) {
            ((com.byazt.dl.pr) this.c.pr(com.byazt.dl.pr.class)).pr(this.hn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(final boolean z) {
        final String strX = this.hw.x();
        this.hn.pr(new com.byazt.nv.pr() { // from class: com.byazt.rw.pr.2
            @Override // com.byazt.nv.pr
            public void pr() {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().pr();
                }
                if (z) {
                    com.byazt.dp.pr.pr(strX);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, long j2, String str, String str2) {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().pr(j, j2, str, str2);
                }
                if (z && j > 0) {
                    com.byazt.dp.pr.pr(strX, j, j2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hw(long j, long j2, String str, String str2) {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().hw(j, j2, str, str2);
                }
                if (z && j > 0) {
                    com.byazt.dp.pr.hw(strX, j, j2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hn(long j, long j2, String str, String str2) {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().hn(j, j2, str, str2);
                }
                if (z && j > 0) {
                    com.byazt.dp.pr.hn(strX, j, j2);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, String str, String str2) {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().pr(j, str, str2);
                }
                if (z) {
                    com.byazt.dp.pr.hw(strX);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(String str, String str2) {
                if (pr.this.x != null && pr.this.x.get() != null) {
                    pr.this.x.get().pr(str, str2);
                }
                if (z) {
                    com.byazt.dp.pr.hn(strX);
                }
            }
        });
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                long j = this.f + 1;
                this.f = j;
                if (j >= this.bm) {
                    this.hs.sendEmptyMessage(2);
                } else {
                    this.hs.sendEmptyMessageDelayed(1, 1000L);
                }
                break;
            case 2:
                if (!this.lv && gu.pr(this.hw)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 0);
                        com.byazt.pj.pr.hw(this.hw, "splash_ad", "splash_card_close", jSONObject);
                        break;
                    } catch (JSONException e) {
                    }
                }
                rc();
                break;
        }
    }

    @Override // com.byazt.jm.TsView.pr
    public void uc() {
        AtomicBoolean atomicBoolean = this.nl;
        if (atomicBoolean != null && atomicBoolean.get()) {
            ho.pr("开屏view重复展示");
            TsView tsView = this.pr;
            if (tsView != null && tsView.getCountDownView() != null && this.pr.getCountDownView().getView() != null) {
                this.pr.getCountDownView().getView().setVisibility(0);
            }
            x(this.aj.get());
        }
        this.aa = 1;
    }

    public void fw() {
        if (this.hn != null) {
            this.hn.hn();
        }
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.pr(ofVar.cz());
            cz.pr(this.hw.le());
        }
        of ofVar2 = this.hw;
        e.hw(ofVar2 != null ? ofVar2.nl() : 0);
        com.byazt.ck.hw hwVar = this.er;
        if (hwVar != null) {
            hwVar.pr();
        }
        com.byazt.jm.fw.pr(1, this.hw, this.qi, this.aa);
    }

    @Override // com.byazt.jm.TsView.pr
    public void pr(boolean z) {
        com.byazt.ck.hw hwVar = this.er;
        if (hwVar != null) {
            hwVar.pr(z);
        }
        this.aa++;
    }

    /* JADX INFO: renamed from: com.byazt.rw.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0180pr implements com.byazt.wt.pr.hw {
        public of pr;

        public C0180pr(of ofVar) {
            this.pr = ofVar;
        }

        @Override // com.byazt.wt.pr.hw
        public void pr() {
            com.byazt.pj.pr.hw(this.pr, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
            com.byazt.pj.pr.hw(this.pr, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }

        @Override // com.byazt.wt.pr.hw
        public void hn() {
        }

        @Override // com.byazt.wt.pr.hw
        public void x() {
        }
    }

    @Override // com.byazt.mr.hw
    public View nt() {
        return null;
    }

    @Override // com.byazt.mr.hw
    public View yb() {
        if (!this.ny || this.vj == null) {
            return null;
        }
        of ofVar = this.hw;
        if (ofVar != null) {
            com.byazt.ua.hw.pr(ofVar.pr());
        }
        return this.vj.pr();
    }

    @Override // com.byazt.mr.hw
    public int lb() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.aj();
    }

    @Override // com.byazt.mr.hw
    public void pr(com.byazt.rkl.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        this.x = new SoftReference<>(hnVar);
    }

    @Override // com.byazt.mr.hw
    public void pr(com.byazt.zz.pr prVar) {
        this.zo = prVar;
    }

    @Override // com.byazt.mr.hw
    public void qa() {
        if (!this.aj.getAndSet(true)) {
            com.byazt.jm.fw.pr(2, this.hw, this.qi, 0);
        }
        TsView tsView = this.pr;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.byazt.mr.hw
    public void pr(com.byazt.zz.hw hwVar) {
        this.jn = hwVar;
        com.byazt.jm.pr prVar = this.nw;
        if (prVar != null) {
            prVar.pr(hwVar);
        }
    }

    @Override // com.byazt.mr.hw
    public void pr(ViewGroup viewGroup) {
    }

    @Override // com.byazt.mr.hw
    public void pr(ViewGroup viewGroup, Activity activity) {
        this.l = activity;
        hw(viewGroup);
    }

    @Override // com.byazt.mr.hw
    public com.byazt.wd.uc a() {
        return new c();
    }

    @Override // com.byazt.mr.hw
    public Map<String, Object> cz() {
        of ofVar = this.hw;
        if (ofVar != null) {
            y yVar = ofVar.de().get(0);
            if (yVar == null) {
                return this.hw.zc();
            }
            if (!yVar.uc()) {
                return this.hw.zc();
            }
            String strPr = yVar.pr();
            Map<String, Object> mapZc = this.hw.zc();
            mapZc.put("image_url", strPr);
            return mapZc;
        }
        return null;
    }

    private void hw(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.ny || (tsView = this.pr) == null || this.hw == null || this.vj == null || this.ie) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.ie = true;
        ViewGroup viewGroupPr = this.vj.pr();
        if (viewGroupPr == null) {
            return;
        }
        com.byazt.gz.x xVar = this.y;
        if (xVar != null) {
            xVar.uc();
        }
        if (viewGroupPr.getParent() != null) {
            ((ViewGroup) viewGroupPr.getParent()).removeView(viewGroupPr);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(viewGroupPr);
            er.zo(this.pr);
            this.pr.removeAllViews();
            this.pr = null;
        }
        viewGroupPr.setOnClickListener(null);
        viewGroupPr.setOnTouchListener(null);
        if (this.rc || Build.VERSION.SDK_INT <= 19) {
            com.byazt.gz.x xVar2 = this.y;
            if (xVar2 != null) {
                xVar2.vk();
            }
            this.y = null;
        }
        this.vj.pr(this.y, new com.byazt.jm.aj.pr() { // from class: com.byazt.rw.pr.3
            @Override // com.byazt.jm.aj.pr
            public void pr(long j) {
                pr.this.hs.removeMessages(1);
                if (j < 0) {
                    pr.this.hs.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        pr.this.hs.sendEmptyMessage(2);
                        return;
                    }
                    pr.this.bm = j;
                    pr.this.f = 0L;
                    pr.this.hs.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.byazt.jm.aj.pr
            public void pr() {
                pr.this.hs.removeMessages(1);
            }

            @Override // com.byazt.jm.aj.pr
            public void hw() {
                pr.this.lv = true;
                pr.this.rc();
            }

            @Override // com.byazt.jm.aj.pr
            public Context getActivity() {
                return pr.this.l;
            }
        });
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d) {
        if (this.i) {
            return;
        }
        gz.pr(this.hw, d);
        this.i = true;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.r) {
            return;
        }
        gz.pr(this.hw, d, str, str2);
        this.r = true;
    }

    @Override // com.byazt.mr.zo
    public void hw(Double d) {
        this.ii = d;
    }

    @Override // com.byazt.mr.zo
    public void pr(com.byazt.rkl.hw hwVar) {
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.pr(ofVar.cz(), hwVar, com.byazt.rkl.hw.class);
        }
    }

    private boolean aj() {
        return (!gu.pr(this.hw) || this.g || this.ho || this.cz) ? false : true;
    }

    private void ho() {
        boolean z = false;
        this.lv = false;
        com.byazt.jm.aj ajVar = new com.byazt.jm.aj();
        this.vj = ajVar;
        ajVar.pr(this.v, this.hw);
        if (!this.nw.hn() && aj()) {
            z = true;
        }
        if (z) {
            SoftReference<com.byazt.rkl.hn> softReference = this.x;
            if (softReference == null) {
                this.vj.pr(this.qi, this.m, this.nw, null);
            } else {
                this.vj.pr(this.qi, this.m, this.nw, softReference.get());
            }
            this.ny = true;
            this.vj.pr(2);
            com.byazt.jm.pr prVar = this.nw;
            if (prVar != null) {
                prVar.pr(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc() {
        if (!this.ie) {
            this.fo = false;
            return;
        }
        if (this.o) {
            return;
        }
        this.o = true;
        com.byazt.jm.pr prVar = this.nw;
        if (prVar != null) {
            prVar.pr();
            this.nw = null;
        }
        com.byazt.gz.x xVar = this.y;
        if (xVar != null) {
            xVar.vk();
        }
        this.zo = null;
        this.hn = null;
        this.l = null;
    }

    public void pr(int i) {
        this.n = i;
    }

    public void ny() {
    }

    @Override // com.byazt.mr.hw
    public String fo() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return null;
        }
        return ofVar.z();
    }
}
