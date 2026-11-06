package com.byazt.ia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.byazt.fvm.oa;
import com.byazt.gct.cx;
import com.byazt.gct.nf;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.hlq.SSRenderTextureView;
import com.byazt.iz.fs;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lz.TTViewStub;
import com.byazt.mr.k;
import com.byazt.mr.sz;
import com.byazt.ndr.RoundImageView;
import com.byazt.nf.rv;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.hd;
import com.byazt.vf.wo;
import com.byazt.vzj.TTLottieVideoContainer;
import com.byazt.vzj.UpieVideoView;
import com.byazt.za.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 13})
public class w implements com.byazt.iag.qg<pk>, com.byazt.hlq.n, wo.n, k.qg, sz.n {
    public int a;
    public boolean ae;
    public com.byazt.vd.n an;
    public TextView b;
    public boolean bb;
    public int cd;
    public final int ci;
    public RoundImageView cp;
    public com.byazt.cs.n.InterfaceC0149n cx;
    public TTViewStub cy;
    public TextView d;
    public TextView df;
    public RelativeLayout dg;
    public RoundImageView dh;
    public boolean e;
    public View f;
    public TextView fi;
    public View fs;
    public Context h;
    public int hd;
    public final int hf;
    public pk hu;
    public final int ic;
    public com.byazt.ys.n j;
    public TTProgressBar k;
    public AtomicBoolean kc;
    public View l;
    public com.byazt.iag.s lh;
    public ITTInnerDownloadAdapter ln;
    public x lq;
    public EnumSet<com.byazt.iag.qg.n> m;
    public View n;
    public String nf;
    public TextView oa;
    public NativeVideoTsView.n oj;
    public volatile boolean ou;
    public int pe;
    public TextView pk;
    public boolean py;
    public View q;
    public com.byazt.hlq.qg qg;
    public RelativeLayout rf;
    public TextView ri;
    public ImageView rv;
    public ImageView s;
    public TTViewStub sh;
    public TextView sz;
    public k t;
    public View tj;
    public RoundImageView u;
    public int um;
    public qg ur;
    public com.byazt.ys.n v;
    public ImageView w;
    public int wm;
    public RelativeLayout wo;
    public TTViewStub x;
    public View y;
    public com.byazt.ys.n yw;

    public void n(long j) {
    }

    public void n(long j, long j2) {
    }

    public void n(Message message) {
    }

    public void n(View view, boolean z) {
    }

    public void n(ViewGroup viewGroup) {
    }

    public void n(String str) {
    }

    public void q() {
    }

    public void qg(ViewGroup viewGroup) {
    }

    public void qg(boolean z) {
    }

    public void rv() {
    }

    public void s(boolean z) {
    }

    public boolean s(int i) {
        return false;
    }

    public void tj() {
    }

    public boolean x() {
        return false;
    }

    @Override // com.byazt.iag.qg
    public /* bridge */ /* synthetic */ void n(pk pkVar, WeakReference weakReference, boolean z) {
        n(pkVar, (WeakReference<Context>) weakReference, z);
    }

    public w(Context context, View view, boolean z, EnumSet<com.byazt.iag.qg.n> enumSet, pk pkVar, com.byazt.iag.s sVar, boolean z2, com.byazt.ys.n nVar) {
        this.py = true;
        this.bb = true;
        this.ae = true;
        this.ic = 1;
        this.ci = 2;
        this.hf = 3;
        this.kc = new AtomicBoolean(false);
        if (this instanceof l) {
            return;
        }
        this.h = rv.getContext().getApplicationContext();
        q(z2);
        this.n = view;
        this.py = z;
        this.m = enumSet == null ? EnumSet.noneOf(com.byazt.iag.qg.n.class) : enumSet;
        this.lh = sVar;
        this.yw = nVar;
        this.hu = pkVar;
        bb();
        q(8);
        n(context, this.n, pkVar);
        fs();
        cy();
    }

    public w(Context context, View view, boolean z, EnumSet<com.byazt.iag.qg.n> enumSet, pk pkVar, com.byazt.iag.s sVar, com.byazt.ys.n nVar) {
        this(context, view, z, enumSet, pkVar, sVar, true, nVar);
    }

    private void bb() {
        this.pe = 1;
        String strQg = com.byazt.vgx.w.qg(this.hu);
        String str = "embeded_ad_landingpage";
        if (strQg == null) {
            strQg = this.bb ? com.byazt.wg.qg.AD_TAG_FEED : "embeded_ad_landingpage";
        }
        this.pe = com.byazt.vgx.w.q(strQg);
        if (!this.bb && strQg.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.bb || !strQg.equals(com.byazt.wg.qg.AD_TAG_FEED)) {
            str = strQg;
        }
        this.nf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        com.byazt.ag.qg.n(new com.byazt.qit.x("native_video_layout_download_listener") { // from class: com.byazt.ia.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.ln == null) {
                    w wVar = w.this;
                    wVar.ln = fs.n(wVar.h, w.this.hu, w.this.nf);
                }
                if (w.this.v != null) {
                    ((com.byazt.zct.n) w.this.v.n(com.byazt.zct.n.class)).n(w.this.ln);
                }
                if (w.this.j != null) {
                    ((com.byazt.zct.n) w.this.j.n(com.byazt.zct.n.class)).n(w.this.ln);
                }
                if (w.this.cx != null) {
                    w.this.ln.setVideoDataListener(w.this.cx);
                }
                if (w.this.ln != null) {
                    w.this.ln.init();
                }
            }
        });
    }

    public void cy() {
        View view;
        bb();
        if (com.byazt.gks.n.n(this.hu)) {
            com.byazt.ys.n nVar = this.yw;
            if (nVar != null) {
                this.v = nVar;
            } else {
                this.v = new com.byazt.ys.n(this.h, this.hu, this.nf, this.pe);
            }
            com.byazt.zct.n.InterfaceC0409n interfaceC0409n = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.ia.w.5
                @Override // com.byazt.zct.n.InterfaceC0409n
                public void n(View view2, int i) {
                    if (w.this.oj != null) {
                        w.this.oj.n(view2, i);
                    }
                }
            };
            ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).n(interfaceC0409n);
            pk pkVar = this.hu;
            if (pkVar != null) {
                com.byazt.ikv.qg.qg(pkVar.ih(), interfaceC0409n, com.byazt.zct.n.InterfaceC0409n.class);
            }
            if (this.yw == null && (view = this.n) != null) {
                view.setOnClickListener(this.v);
                this.n.setOnTouchListener(this.v);
            }
            if (com.byazt.okk.s.q(this.wo)) {
                this.wo.setOnClickListener(this.v);
                this.wo.setOnTouchListener(this.v);
                return;
            }
            return;
        }
        v();
        com.byazt.ys.n nVar2 = new com.byazt.ys.n(this.h, this.hu, this.nf, this.pe);
        this.v = nVar2;
        ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).qg(true);
        com.byazt.zct.n.InterfaceC0409n interfaceC0409n2 = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.ia.w.6
            @Override // com.byazt.zct.n.InterfaceC0409n
            public void n(View view2, int i) {
                if (w.this.oj != null) {
                    w.this.oj.n(view2, i);
                }
            }
        };
        ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).n(interfaceC0409n2);
        pk pkVar2 = this.hu;
        if (pkVar2 != null) {
            com.byazt.ikv.qg.qg(pkVar2.ih(), interfaceC0409n2, com.byazt.zct.n.InterfaceC0409n.class);
        }
        qg(this.v);
        if (this.bb) {
            ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).s(true);
        } else {
            ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).s(false);
            ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).n(true);
        }
        if (lh()) {
            com.byazt.ys.n nVar3 = new com.byazt.ys.n(this.h, this.hu, this.nf, this.pe);
            this.j = nVar3;
            qg(nVar3);
            this.lq = new x(this);
            ((com.byazt.zct.n) this.j.n(com.byazt.zct.n.class)).qg(true);
            com.byazt.zct.n.InterfaceC0409n interfaceC0409n3 = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.ia.w.7
                @Override // com.byazt.zct.n.InterfaceC0409n
                public void n(View view2, int i) {
                    if (w.this.oj != null) {
                        w.this.oj.n(view2, i);
                    }
                }
            };
            ((com.byazt.zct.n) this.j.n(com.byazt.zct.n.class)).n(interfaceC0409n3);
            pk pkVar3 = this.hu;
            if (pkVar3 != null) {
                com.byazt.ikv.qg.qg(pkVar3.ih(), interfaceC0409n3, com.byazt.zct.n.InterfaceC0409n.class);
            }
            if (this.bb) {
                ((com.byazt.zct.n) this.j.n(com.byazt.zct.n.class)).s(true);
            } else {
                ((com.byazt.zct.n) this.j.n(com.byazt.zct.n.class)).s(false);
            }
            n(this.j);
            View view2 = this.n;
            if (view2 != null) {
                view2.setOnClickListener(this.j);
                this.n.setOnTouchListener(this.j);
            }
        }
    }

    private void n(com.byazt.ys.n nVar) {
        pk pkVar;
        if (nVar == null || (pkVar = this.hu) == null || !com.byazt.gks.n.n(pkVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.byazt.fq.n) nVar.n(com.byazt.fq.n.class)).n(map);
    }

    private boolean lh() {
        pk pkVar = this.hu;
        return pkVar != null && nf.x(pkVar) == null && nf.fs(this.hu) == null && this.hu.il() == 1 && pk.s(this.hu);
    }

    public void n(NativeVideoTsView.n nVar) {
        this.oj = nVar;
    }

    public void n(oa oaVar) {
        n(oaVar, this.v);
        n(oaVar, this.j);
    }

    private void qg(com.byazt.ys.n nVar) {
        pk pkVar;
        if (nVar == null || (pkVar = this.hu) == null) {
            return;
        }
        com.byazt.fvm.sz szVarN = com.byazt.lu.qg.n(Integer.valueOf(pkVar.hashCode()));
        if (szVarN instanceof h) {
            ((h) szVarN).n((com.byazt.fq.s) nVar.n(com.byazt.fq.s.class));
        }
    }

    private void n(oa oaVar, com.byazt.ys.n nVar) {
        com.byazt.whi.q qVarT;
        if (nVar == null) {
            return;
        }
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(oaVar);
        com.byazt.fq.s sVar = (com.byazt.fq.s) nVar.n(com.byazt.fq.s.class);
        if ((oaVar instanceof com.byazt.whi.l) && (qVarT = ((com.byazt.whi.l) oaVar).t()) != null) {
            qVarT.n(sVar);
        }
    }

    private void v() {
        if (this.h == null || this.n == null) {
            return;
        }
        View view = new View(this.h) { // from class: com.byazt.ia.w.8
            public final AtomicBoolean qg = new AtomicBoolean(true);

            @Override // android.view.View
            public void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (w.this.ln != null) {
                    if (z) {
                        w.this.ln.onResume();
                    } else {
                        w.this.ln.onPause();
                    }
                }
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                w.this.kc.set(false);
                n();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                n();
            }

            private void n() {
                if (w.this.hu == null) {
                    return;
                }
                if (this.qg.getAndSet(false) && (com.byazt.gks.n.n(w.this.hu) || w.this.hu.rv() == 4)) {
                    w.this.ln();
                }
                com.byazt.ikv.qg.qg(w.this.hu.ih(), w.this.lq, x.class);
            }

            private void qg() {
                if (this.qg.getAndSet(true) || w.this.ln == null) {
                    return;
                }
                w.this.ln.onDestroy();
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                w.this.kc.set(true);
                qg();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                qg();
            }
        };
        View view2 = this.n;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public com.byazt.hlq.qg hd() {
        return this.qg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(Context context, View view, pk pkVar) {
        View sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.byazt.aci.n.qg(pkVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.h);
        } else if (com.byazt.aci.n.s(pkVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.byazt.aci.n.tj(pkVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.h);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (ae()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        com.byazt.okk.s.n(sSRenderTextureView, 8);
        this.qg = (com.byazt.hlq.qg) sSRenderTextureView;
        this.s = (ImageView) view.findViewById(2114387626);
        this.k = (TTProgressBar) view.findViewById(2114387653);
        this.q = view.findViewById(2114387900);
        this.l = view.findViewById(2114387631);
        this.w = (ImageView) view.findViewById(2114387651);
        this.x = (TTViewStub) view.findViewById(2114387744);
        this.sh = (TTViewStub) view.findViewById(2114387666);
        this.cy = (TTViewStub) view.findViewById(2114387828);
        if (com.byazt.gks.n.n(pkVar)) {
            qg(context, view);
        }
        System.currentTimeMillis();
    }

    private void qg(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (j()) {
            com.byazt.okk.s.n((View) relativeLayout, 0);
            com.byazt.okk.s.n((View) relativeLayout2, 8);
            this.dg = relativeLayout;
        } else {
            com.byazt.okk.s.n((View) relativeLayout2, 0);
            com.byazt.okk.s.n((View) relativeLayout, 8);
            this.dg = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.dg;
        if (relativeLayout3 == null) {
            return;
        }
        this.u = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.pk = (TextView) this.dg.findViewById(2114387742);
        this.wo = (RelativeLayout) this.dg.findViewById(2114387693);
    }

    private boolean j() {
        if (this.hu == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.nf) || "rewarded_video".equals(this.nf)) {
            int iYs = this.hu.ys();
            float fSl = this.hu.sl();
            if (iYs == 1 && fSl == 100.0f) {
                return true;
            }
        }
        return false;
    }

    public void n(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.sh) == null || tTViewStub.getParent() == null || this.y != null) {
            return;
        }
        this.y = this.sh.n();
        this.rf = (RelativeLayout) view.findViewById(2114387953);
        this.dh = (RoundImageView) view.findViewById(2114387958);
        this.b = (TextView) view.findViewById(2114387926);
        this.ri = (TextView) view.findViewById(2114387877);
    }

    public void cd() {
        if (this.hu == null) {
            return;
        }
        if (this.e) {
            com.byazt.okk.s.n((View) this.ri, 8);
        }
        if (com.byazt.gks.n.n(this.hu)) {
            String strRv = oj.rv(this.hu);
            String strS = oj.s(this.hu);
            String strFs = oj.fs(this.hu);
            com.byazt.okk.s.n(this.y, 0);
            com.byazt.okk.s.n((View) this.rf, 0);
            if (!TextUtils.isEmpty(strRv)) {
                com.byazt.imu.s.n(strRv).n(this.dh);
            }
            if (!TextUtils.isEmpty(strS)) {
                com.byazt.okk.s.n(this.b, strS);
            }
            if (this.rf == null) {
                return;
            }
            com.byazt.imu.s.n(strFs).s(2).n(new m<Bitmap>() { // from class: com.byazt.ia.w.9
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapN = com.byazt.cq.qg.n(w.this.h, cyVar.s(), 25);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(w.this.rf.getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ia.w.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (w.this.rf != null) {
                                w.this.rf.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void an() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pk pkVar = this.hu;
        if (pkVar != null && com.byazt.gks.n.n(pkVar)) {
            String strRv = oj.rv(this.hu);
            if (!TextUtils.isEmpty(strRv)) {
                com.byazt.imu.s.n(strRv).n(this.u);
            }
            String strS = oj.s(this.hu);
            String strFs = oj.fs(this.hu);
            if (!TextUtils.isEmpty(strS)) {
                com.byazt.okk.s.n(this.pk, strS);
            }
            if (this.dg == null) {
                return;
            }
            com.byazt.imu.s.n(strFs).s(2).n(new m<Bitmap>() { // from class: com.byazt.ia.w.10
                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapN = com.byazt.cq.qg.n(w.this.h, cyVar.s(), 25);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(w.this.dg.getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ia.w.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (w.this.dg != null) {
                                w.this.dg.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    com.byazt.hm.n.q(w.this.hu, w.this.nf, System.currentTimeMillis() - jCurrentTimeMillis);
                }

                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                    com.byazt.hm.n.n(w.this.hu, w.this.nf, i, str);
                }
            }, 4);
        }
    }

    public void n(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.x) == null || tTViewStub.getParent() == null || this.fs != null) {
            return;
        }
        this.fs = this.x.n();
        this.x.setVisibility(0);
        this.rv = (ImageView) view.findViewById(2114387804);
        this.tj = view.findViewById(2114387961);
        this.cp = (RoundImageView) view.findViewById(2114387664);
        this.d = (TextView) view.findViewById(2114387957);
        this.oa = (TextView) view.findViewById(2114387764);
        this.sz = (TextView) view.findViewById(2114387686);
    }

    private void qg(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.cy) == null || tTViewStub.getParent() == null || this.f != null) {
            return;
        }
        this.cy.n();
        this.f = view.findViewById(2114387674);
        this.fi = (TextView) view.findViewById(2114387868);
        this.df = (TextView) view.findViewById(2114387842);
    }

    public void um() {
        if (this.ur == null || this.t != null) {
            return;
        }
        System.currentTimeMillis();
        k kVar = new k();
        this.t = kVar;
        kVar.n(this.h, this.n);
        this.t.n(this.ur, this);
        System.currentTimeMillis();
    }

    public boolean n(int i, com.byazt.zsl.s sVar, boolean z) {
        k kVar = this.t;
        return kVar == null || kVar.n(i, sVar, z);
    }

    public void a() {
        k kVar = this.t;
        if (kVar != null) {
            kVar.n(false);
        }
    }

    public void n(com.byazt.iag.n nVar) {
        if (nVar instanceof qg) {
            this.ur = (qg) nVar;
            um();
        }
    }

    public boolean py() {
        if (this.ur != null) {
            return true;
        }
        com.byazt.tk.k.qg("NewLiveViewLayout", "callback is null");
        return false;
    }

    public void fs() {
        this.qg.n(this);
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.w.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (w.this.py()) {
                        if (w.this.sz == null || w.this.sz.getVisibility() != 0) {
                            w.this.ur.n(w.this, view);
                        }
                    }
                }
            });
        }
    }

    public void l(int i) {
        com.byazt.okk.s.n(this.n, 0);
        com.byazt.hlq.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.setVisibility(i);
        }
    }

    public void q(boolean z) {
        this.bb = z;
        if (z) {
            com.byazt.ys.n nVar = this.v;
            if (nVar != null) {
                ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).s(true);
            }
            com.byazt.ys.n nVar2 = this.j;
            if (nVar2 != null) {
                ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).s(true);
                return;
            }
            return;
        }
        com.byazt.ys.n nVar3 = this.v;
        if (nVar3 != null) {
            ((com.byazt.zct.n) nVar3.n(com.byazt.zct.n.class)).s(true);
            ((com.byazt.zct.n) this.v.n(com.byazt.zct.n.class)).n(true);
        }
        com.byazt.ys.n nVar4 = this.j;
        if (nVar4 != null) {
            ((com.byazt.zct.n) nVar4.n(com.byazt.zct.n.class)).s(true);
            ((com.byazt.zct.n) this.j.n(com.byazt.zct.n.class)).n(true);
        }
    }

    public void n(int i, int i2) {
        if (i == -1) {
            i = com.byazt.okk.s.l(this.h);
        }
        if (i <= 0) {
            return;
        }
        this.hd = i;
        if (sz() || x() || this.m.contains(com.byazt.iag.qg.n.fixedSize)) {
            this.cd = i2;
        } else {
            this.cd = x(i);
        }
        qg(this.hd, this.cd);
    }

    public void qg(boolean z, boolean z2) {
        ImageView imageView = this.s;
        if (imageView != null) {
            if (z) {
                com.byazt.tk.sz.n(this.h, "tt_new_play_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            } else {
                com.byazt.tk.sz.n(this.h, "tt_new_pause_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
    }

    public void qg(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.n;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.n.setLayoutParams(layoutParams);
    }

    private int x(int i) {
        if (this.um <= 0 || this.a <= 0) {
            return 0;
        }
        int iS = com.byazt.okk.s.s(this.h, 228.0f);
        int iS2 = com.byazt.okk.s.s(this.h, 160.0f);
        int i2 = (int) (this.a * ((i * 1.0f) / this.um));
        if (i2 > iS) {
            return iS;
        }
        return i2 < iS2 ? iS2 : i2;
    }

    public void s(int i, int i2) {
        this.um = i;
        this.a = i2;
    }

    public void qg(int i) {
        com.byazt.okk.s.n((View) this.k, 0);
        TTProgressBar tTProgressBar = this.k;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    public void s(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.n.getParent() == null) {
            viewGroup.addView(this.n);
        }
        q(0);
    }

    @Override // com.byazt.iag.qg
    public View s() {
        return this.n;
    }

    public void cp() {
        if (com.byazt.gks.n.n(this.hu)) {
            ou();
        } else {
            f();
        }
        ImageView imageView = this.s;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        com.byazt.okk.s.n((View) this.s, 8);
    }

    private boolean ae() {
        return TextUtils.equals(this.nf, "splash_ad") || TextUtils.equals(this.nf, "cache_splash_ad");
    }

    private void f() {
        if (ae()) {
            com.byazt.okk.s.n((View) this.s, 8);
            if (!rv.qg().on()) {
                com.byazt.okk.s.n(this.q, 8);
                com.byazt.okk.s.n(this.l, 8);
                com.byazt.okk.s.n((View) this.w, 8);
                return;
            }
        }
        com.byazt.okk.s.n(this.q, 0);
        com.byazt.okk.s.n((View) this.dg, 8);
        com.byazt.okk.s.w(this.q);
        if (ae() && rv.qg().on()) {
            com.byazt.okk.s.n(this.l, 8);
        } else {
            com.byazt.okk.s.w(this.l);
        }
        if (this.w == null || TextUtils.isEmpty(ta.qg(this.hu))) {
            return;
        }
        com.byazt.okk.s.w(this.w);
        com.byazt.imu.s.n(ta.qg(this.hu)).n(this.w);
        n(this.w, ta.qg(this.hu));
    }

    public void ou() {
        com.byazt.okk.s.n(this.q, 8);
        com.byazt.okk.s.n((View) this.dg, 0);
        an();
    }

    public void wm() {
        if (com.byazt.gks.n.n(this.hu)) {
            ou();
        } else {
            com.byazt.okk.s.n((View) this.dg, 8);
            com.byazt.okk.s.w(this.q);
            com.byazt.okk.s.w(this.l);
        }
        ImageView imageView = this.s;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        com.byazt.okk.s.n((View) this.s, 8);
    }

    @Override // com.byazt.iag.qg
    public void n() {
        n(false, this.py);
        hu();
    }

    public void m() {
        com.byazt.okk.s.n(this.n, 0);
        com.byazt.hlq.qg qgVar = this.qg;
        if (qgVar != null) {
            View view = qgVar.getView();
            com.byazt.okk.s.n(view, 8);
            com.byazt.okk.s.n(view, 0);
        }
    }

    public void hu() {
        com.byazt.okk.s.n(this.fs, 8);
        com.byazt.okk.s.n((View) this.rv, 8);
        com.byazt.okk.s.n(this.tj, 8);
        com.byazt.okk.s.n((View) this.cp, 8);
        com.byazt.okk.s.n((View) this.d, 8);
        com.byazt.okk.s.n((View) this.oa, 8);
        com.byazt.okk.s.n((View) this.sz, 8);
        com.byazt.okk.s.n(this.y, 8);
        com.byazt.okk.s.n((View) this.rf, 8);
    }

    private void fs(int i) {
        com.byazt.okk.s.n(this.tj, i);
        com.byazt.okk.s.n(this.f, i);
    }

    @Override // com.byazt.iag.qg
    public void n(boolean z) {
        this.ae = z;
    }

    public void w(int i) {
        pk pkVar;
        if (this.cp == null || (pkVar = this.hu) == null || pkVar.xu() == null || this.hu.xu().n() == null) {
            return;
        }
        if (i == 1) {
            int iS = com.byazt.okk.s.s(this.h, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iS, iS);
            layoutParams.addRule(14);
            this.cp.setLayoutParams(layoutParams);
            this.d.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = com.byazt.okk.s.s(this.h, 16.0f);
            layoutParams2.topMargin = com.byazt.okk.s.s(this.h, 8.0f);
            layoutParams2.leftMargin = com.byazt.okk.s.s(this.h, 16.0f);
            layoutParams2.rightMargin = com.byazt.okk.s.s(this.h, 16.0f);
            layoutParams2.addRule(3, this.cp.getId());
            layoutParams2.addRule(14);
            this.oa.setLayoutParams(layoutParams2);
            this.oa.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.byazt.okk.s.s(this.h, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.oa.getId());
            layoutParams3.leftMargin = com.byazt.okk.s.s(this.h, 20.0f);
            layoutParams3.rightMargin = com.byazt.okk.s.s(this.h, 20.0f);
            this.sz.setPadding(com.byazt.okk.s.s(this.h, 36.0f), com.byazt.okk.s.s(this.h, 7.0f), com.byazt.okk.s.s(this.h, 36.0f), com.byazt.okk.s.s(this.h, 8.0f));
            this.sz.setLayoutParams(layoutParams3);
            this.sz.setEllipsize(TextUtils.TruncateAt.END);
            this.sz.setSingleLine(true);
            this.sz.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iS2 = com.byazt.okk.s.s(this.h, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iS2, iS2);
            layoutParams4.addRule(14);
            this.cp.setLayoutParams(layoutParams4);
            this.d.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = com.byazt.okk.s.s(this.h, 8.0f);
            layoutParams5.topMargin = com.byazt.okk.s.s(this.h, 8.0f);
            layoutParams5.addRule(3, this.cp.getId());
            layoutParams5.addRule(14);
            this.oa.setLayoutParams(layoutParams5);
            this.oa.setTextSize(10.0f);
            com.byazt.okk.s.n((View) this.sz, 8);
            return;
        }
        int iS3 = com.byazt.okk.s.s(this.h, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iS3, iS3);
        layoutParams6.addRule(14);
        this.cp.setLayoutParams(layoutParams6);
        this.d.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = com.byazt.okk.s.s(this.h, 8.0f);
        layoutParams7.topMargin = com.byazt.okk.s.s(this.h, 8.0f);
        layoutParams7.addRule(3, this.cp.getId());
        layoutParams7.addRule(14);
        this.oa.setLayoutParams(layoutParams7);
        this.oa.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, com.byazt.okk.s.s(this.h, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.oa.getId());
        int iS4 = com.byazt.okk.s.s(this.h, 20.0f);
        int iS5 = com.byazt.okk.s.s(this.h, 25.0f);
        int iS6 = com.byazt.okk.s.s(this.h, 6.0f);
        TextPaint paint = this.sz.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.sz.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.sz.setTextSize(13.0f);
        if (this.sz.getWidth() > (iS5 * 2) + rect.width() && this.sz.getHeight() > (iS6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iS4;
            layoutParams8.rightMargin = iS4;
            this.sz.setPadding(iS5, com.byazt.okk.s.s(this.h, 5.0f), iS5, iS6);
        }
        this.sz.setEllipsize(TextUtils.TruncateAt.END);
        this.sz.setSingleLine(true);
        this.sz.setLayoutParams(layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.tj;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.n;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.n.getMeasuredHeight();
            int iS = com.byazt.okk.s.s(this.h, 200.0f);
            int iS2 = com.byazt.okk.s.s(this.h, 331.0f);
            int iS3 = com.byazt.okk.s.s(this.h, 110.0f);
            int iS4 = com.byazt.okk.s.s(this.h, 100.0f);
            if (measuredWidth >= iS && measuredHeight >= iS2) {
                w(1);
                return;
            }
            if (measuredWidth > iS3 && measuredHeight > iS4) {
                w(3);
                return;
            }
            w(2);
        } catch (Exception unused) {
        }
    }

    public void n(final ImageView imageView, String str) {
        if (imageView == null || !com.byazt.aci.n.n(this.hu) || com.byazt.aci.n.x(this.hu)) {
            return;
        }
        com.byazt.imu.s.n(str).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.ia.w.12
            @Override // com.byazt.si.m
            public void n(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                Bitmap bitmapS;
                if (cyVar == null || (bitmapS = cyVar.s()) == null) {
                    return;
                }
                final Bitmap bitmapN = com.byazt.cq.qg.n(w.this.h, bitmapS, 25);
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ia.w.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapN != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapN));
                        }
                    }
                });
            }
        }, 4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void n(pk pkVar, WeakReference<Context> weakReference, boolean z) {
        String strM19if;
        pk pkVar2;
        if (pkVar == null || ae()) {
            return;
        }
        n(false, this.py);
        if (com.byazt.gks.n.n(pkVar)) {
            n(rv.getContext(), this.n);
            cd();
            return;
        }
        n(this.n, rv.getContext());
        View view = this.fs;
        if (view != null) {
            com.byazt.okk.s.n(view, 0);
        }
        ImageView imageView = this.rv;
        if (imageView != null) {
            com.byazt.okk.s.n((View) imageView, 0);
        }
        if (com.byazt.vgx.w.q(this.hu)) {
            qg(this.n, rv.getContext());
            com.byazt.okk.s.n(this.tj, 8);
            com.byazt.okk.s.n((View) this.rv, 0);
            com.byazt.okk.s.n(this.f, 0);
            com.byazt.okk.s.n((View) this.fi, 0);
            com.byazt.okk.s.n((View) this.df, 0);
            if (this.df != null && hd.s(rv.getContext()) == 0) {
                com.byazt.okk.s.n((View) this.df, 8);
            }
            View view2 = this.fs;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.w.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (w.this.lh != null) {
                            ((com.byazt.iag.n) w.this.lh).n();
                            if (w.this.an != null) {
                                w.this.an.n();
                            }
                        }
                    }
                });
            }
            if (this.rv != null && !TextUtils.isEmpty(ta.qg(this.hu))) {
                if (com.byazt.aci.n.qg(pkVar)) {
                    com.byazt.imu.s.n(ta.qg(this.hu)).n(this.rv);
                    n(this.rv, ta.qg(this.hu));
                } else {
                    com.byazt.udy.qg.n(2147483647L, ta.n(this.hu), new com.byazt.udy.qg.InterfaceC0363qg() { // from class: com.byazt.ia.w.3
                        @Override // com.byazt.udy.qg.InterfaceC0363qg
                        public void n(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) w.this.rv.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    float height = (bitmap.getHeight() * com.byazt.okk.s.l(rv.getContext())) / bitmap.getWidth();
                                    layoutParams.width = com.byazt.okk.s.l(rv.getContext());
                                    layoutParams.height = (int) height;
                                    layoutParams.addRule(13);
                                    w.this.rv.setLayoutParams(layoutParams);
                                }
                                w.this.rv.setImageBitmap(bitmap);
                                return;
                            }
                            com.byazt.imu.s.n(ta.qg(w.this.hu)).n(w.this.rv);
                        }
                    });
                }
            }
        } else {
            com.byazt.okk.s.n(this.tj, 0);
            if (this.rv != null && !TextUtils.isEmpty(ta.qg(this.hu))) {
                com.byazt.imu.s.n(ta.qg(this.hu)).n(this.rv);
                n(this.rv, ta.qg(this.hu));
            }
            if (df()) {
                this.tj.post(new Runnable() { // from class: com.byazt.ia.w.4
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.fi();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(pkVar.yr())) {
            strM19if = pkVar.yr();
        } else if (!TextUtils.isEmpty(pkVar.E_())) {
            strM19if = pkVar.E_();
        } else {
            strM19if = !TextUtils.isEmpty(pkVar.m19if()) ? pkVar.m19if() : "";
        }
        if (this.cp != null && (pkVar2 = this.hu) != null && pkVar2.xu() != null && this.hu.xu().n() != null) {
            com.byazt.okk.s.n((View) this.cp, 0);
            com.byazt.okk.s.n((View) this.d, 4);
            com.byazt.imu.s.n(this.hu.xu()).n(this.cp);
            if (lh()) {
                this.cp.setOnClickListener(this.j);
                this.cp.setOnTouchListener(this.j);
            } else {
                this.cp.setOnClickListener(this.v);
                this.cp.setOnTouchListener(this.v);
            }
        } else if (!TextUtils.isEmpty(strM19if)) {
            com.byazt.okk.s.n((View) this.cp, 4);
            com.byazt.okk.s.n((View) this.d, 0);
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(strM19if.substring(0, 1));
                if (lh()) {
                    this.d.setOnClickListener(this.j);
                    this.d.setOnTouchListener(this.j);
                } else {
                    this.d.setOnClickListener(this.v);
                    this.d.setOnTouchListener(this.v);
                }
            }
        }
        if (this.oa != null && !TextUtils.isEmpty(strM19if)) {
            this.oa.setText(strM19if);
        }
        com.byazt.okk.s.n((View) this.oa, 0);
        com.byazt.okk.s.n((View) this.sz, 0);
        String strJb = pkVar.jb();
        if (TextUtils.isEmpty(strJb)) {
            int iRv = pkVar.rv();
            if (iRv != 4) {
                strJb = iRv != 5 ? "查看详情" : "立即拨打";
            } else {
                strJb = "立即下载";
            }
        }
        TextView textView2 = this.sz;
        if (textView2 != null) {
            textView2.setText(strJb);
            this.sz.setOnClickListener(this.v);
            this.sz.setOnTouchListener(this.v);
        }
        TextView textView3 = this.fi;
        if (textView3 != null) {
            textView3.setText(strJb);
            this.fi.setOnClickListener(this.v);
            this.fi.setOnTouchListener(this.v);
        }
        if (this.ae) {
            return;
        }
        fs(4);
    }

    private boolean df() {
        pk pkVar;
        return this.bb && this.tj != null && (pkVar = this.hu) != null && pkVar.np() == 1;
    }

    public void h() {
        pk pkVar = this.hu;
        if (pkVar == null) {
            return;
        }
        if (this.hu.yj() != 5 ? pkVar.yj() == 1 && cx.hd(this.hu) : true) {
            n(false, this.py);
            n(this.n, rv.getContext());
            if (this.rv == null || TextUtils.isEmpty(ta.qg(this.hu))) {
                return;
            }
            com.byazt.okk.s.n(this.fs, 0);
            com.byazt.okk.s.n((View) this.rv, 0);
            com.byazt.okk.s.n(this.tj, 8);
            com.byazt.imu.s.n(ta.qg(this.hu)).n(this.rv);
            n(this.rv, ta.qg(this.hu));
        }
    }

    public void t() {
        if (ae()) {
            com.byazt.okk.s.n((View) this.s, 8);
            com.byazt.okk.s.l(this.q);
            com.byazt.okk.s.l(this.l);
            ImageView imageView = this.w;
            if (imageView != null) {
                com.byazt.okk.s.l(imageView);
            }
        }
    }

    @Override // com.byazt.iag.qg
    public void qg() {
        if (ae()) {
            com.byazt.okk.s.n(this.q, 8);
            com.byazt.okk.s.n(this.l, 8);
            com.byazt.okk.s.n((View) this.w, 8);
            com.byazt.okk.s.n((View) this.s, 8);
            return;
        }
        com.byazt.okk.s.n((View) this.dg, 8);
        com.byazt.okk.s.l(this.q);
        com.byazt.okk.s.l(this.l);
        ImageView imageView = this.w;
        if (imageView != null) {
            com.byazt.okk.s.l(imageView);
        }
    }

    public void d() {
        if (com.byazt.gks.n.n(this.hu)) {
            com.byazt.okk.s.n((View) this.dg, 8);
        } else {
            com.byazt.okk.s.l(this.q);
        }
    }

    @Override // com.byazt.hlq.n
    public void n(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ou = true;
        if (py()) {
            this.ur.n(this, surfaceTexture);
        }
    }

    @Override // com.byazt.hlq.n
    public boolean n(SurfaceTexture surfaceTexture) {
        this.ou = false;
        if (!py()) {
            return true;
        }
        this.ur.qg(this, surfaceTexture);
        return true;
    }

    public void oa() {
        TTProgressBar tTProgressBar = this.k;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.k.setSecondaryProgress(0);
        }
        q(8);
        if (ur()) {
            this.qg.setVisibility(8);
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.w.setBackground(null);
        }
        ImageView imageView2 = this.rv;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.rv.setBackground(null);
        }
        q(8);
        com.byazt.okk.s.n(this.fs, 8);
        com.byazt.okk.s.n((View) this.rv, 8);
        com.byazt.okk.s.n(this.tj, 8);
        com.byazt.okk.s.n((View) this.cp, 8);
        com.byazt.okk.s.n((View) this.d, 8);
        com.byazt.okk.s.n((View) this.oa, 8);
        com.byazt.okk.s.n(this.y, 8);
        com.byazt.okk.s.n((View) this.rf, 8);
        k kVar = this.t;
        if (kVar != null) {
            kVar.n(true);
        }
    }

    public boolean sz() {
        return this.py;
    }

    public void n(boolean z, boolean z2, boolean z3) {
        com.byazt.okk.s.n((View) this.k, 0);
        com.byazt.okk.s.n((View) this.s, (z && (com.byazt.okk.s.q(this.q) && com.byazt.okk.s.q(this.dg))) ? 0 : 8);
    }

    public void n(boolean z, boolean z2) {
        com.byazt.okk.s.n((View) this.k, z ? 0 : 8);
        com.byazt.okk.s.n((View) this.s, 8);
    }

    public void w() {
        n(true, false);
    }

    public boolean k() {
        return this.ou;
    }

    public void q(int i) {
        this.wm = i;
        com.byazt.okk.s.n(this.n, i);
    }

    public boolean l() {
        k kVar = this.t;
        return kVar != null && kVar.n();
    }

    public boolean ur() {
        return !this.m.contains(com.byazt.iag.qg.n.alwayShowMediaView) || this.py;
    }

    public void n(com.byazt.vd.n nVar) {
        this.an = nVar;
        com.byazt.ys.n nVar2 = this.v;
        if (nVar2 != null) {
            ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).n(nVar);
        }
    }

    @Override // com.byazt.iag.qg
    public void n(Drawable drawable) {
        View view = this.n;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.byazt.iag.qg
    public void n(int i) {
        com.byazt.okk.s.n((View) this.wo, i);
    }

    public void l(boolean z) {
        this.e = z;
    }

    public void n(com.byazt.cs.n.InterfaceC0149n interfaceC0149n) {
        this.cx = interfaceC0149n;
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.ln;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.setVideoDataListener(interfaceC0149n);
        }
    }
}
