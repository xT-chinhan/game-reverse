package com.byazt.ia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.fvm.oa;
import com.byazt.gct.k;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.lz.TTViewStub;
import com.byazt.nf.rv;
import com.byazt.shr.um;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.stl.GifView;
import com.byazt.tk.hd;
import com.byazt.tk.sz;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.wb.fs;
import com.byazt.za.NativeExpressVideoView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 1263})
public class NativeVideoTsView extends FrameLayout implements com.byazt.iag.s.n, wo.n, com.byazt.ia.q.n {
    public final AtomicBoolean a;
    public com.byazt.iag.s.InterfaceC0200s ae;
    public long an;
    public com.byazt.rg.l b;
    public long bb;
    public boolean cd;
    public ImageView cp;
    public boolean cx;
    public int cy;
    public ImageView d;
    public int df;
    public boolean dg;
    public ViewGroup dh;
    public boolean e;
    public boolean f;
    public boolean fi;
    public boolean fs;
    public boolean h;
    public AtomicBoolean hd;
    public boolean hu;
    public AtomicBoolean ic;
    public long j;
    public String k;
    public com.byazt.iag.s l;
    public boolean lh;
    public final t ln;
    public volatile boolean lq;
    public boolean m;
    public boolean n;
    public qg nf;
    public ImageView oa;
    public int oj;
    public boolean ou;
    public boolean pe;
    public boolean pk;
    public String py;
    public pk q;
    public boolean qg;
    public View.OnAttachStateChangeListener rf;
    public com.byazt.gwu.s ri;
    public boolean rv;
    public final Context s;
    public ViewTreeObserver.OnGlobalLayoutListener sh;
    public boolean sz;
    public NativeExpressVideoView t;
    public RelativeLayout tj;
    public boolean u;
    public q um;
    public boolean ur;
    public TTViewStub v;
    public ViewGroup w;
    public boolean wm;
    public s wo;
    public FrameLayout x;
    public ViewTreeObserver y;
    public boolean yw;

    public interface n {
        void n(View view, int i);
    }

    public interface q {
        void n(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    public void setNativeRenderAd(boolean z) {
        this.e = z;
    }

    public boolean tj() {
        return this.e;
    }

    public void setEasyPlayableEventSender(com.byazt.rg.l lVar) {
        this.b = lVar;
    }

    public void setDrawVideoListener(com.byazt.vd.n nVar) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            ((com.byazt.ia.q) sVar).n(nVar);
        }
    }

    public void setAdCreativeClickListener(n nVar) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            ((com.byazt.ia.q) sVar).n(nVar);
        }
    }

    public void setVideoAdClickListenerTTNativeAd(oa oaVar) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            ((com.byazt.ia.q) sVar).n(oaVar);
        }
    }

    public void setControllerStatusCallBack(q qVar) {
        this.um = qVar;
    }

    @Override // com.byazt.iag.s.n
    public void n(long j, int i) {
        this.pe = true;
        com.byazt.iag.s.InterfaceC0200s interfaceC0200s = this.ae;
        if (interfaceC0200s != null) {
            interfaceC0200s.v_();
        }
        com.byazt.rg.l lVar = this.b;
        if (lVar != null) {
            lVar.fs();
        }
    }

    private void l() {
        n(0L, 0);
        this.ae = null;
    }

    @Override // com.byazt.iag.s.n
    public void qg(long j, int i) {
        this.wm = true;
    }

    public boolean getVideoError() {
        return this.wm;
    }

    @Override // com.byazt.iag.s.n
    public void n() {
        if (this.ae == null || !h()) {
            return;
        }
        this.ae.v_();
    }

    @Override // com.byazt.iag.s.n
    public void n(long j, long j2) {
        com.byazt.iag.s sVar;
        if (j != j2) {
            this.pe = false;
        }
        com.byazt.iag.s.InterfaceC0200s interfaceC0200s = this.ae;
        if (interfaceC0200s != null) {
            interfaceC0200s.n(j, j2);
        }
        com.byazt.rg.l lVar = this.b;
        if (lVar != null) {
            lVar.n(j, j2);
        }
        if (ur() || (sVar = this.l) == null) {
            return;
        }
        sVar.w();
    }

    public NativeVideoTsView(Context context, pk pkVar) {
        this(context, pkVar, false, false);
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public NativeVideoTsView(Context context, pk pkVar, boolean z, boolean z2) {
        this(context, pkVar, z, z2, com.byazt.wg.qg.AD_TAG_FEED, false, false);
    }

    public NativeVideoTsView(Context context, pk pkVar, String str, boolean z, boolean z2) {
        this(context, pkVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, pk pkVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.n = true;
        this.fs = true;
        this.qg = false;
        this.ou = false;
        this.wm = false;
        this.m = false;
        this.hu = true;
        this.h = false;
        this.sz = true;
        this.k = com.byazt.wg.qg.AD_TAG_FEED;
        this.cy = 50;
        this.ur = true;
        this.hd = new AtomicBoolean(false);
        this.lh = false;
        this.cd = false;
        this.j = 50L;
        this.an = 500L;
        this.f = true;
        this.fi = false;
        this.dg = true;
        this.u = true;
        this.pe = false;
        this.a = new AtomicBoolean(false);
        this.yw = true;
        this.lq = false;
        this.ic = new AtomicBoolean(false);
        this.k = str;
        this.s = context;
        this.q = pkVar;
        this.qg = z;
        this.h = z2;
        this.m = z3;
        this.hu = z4;
        this.ln = new t(com.byazt.ag.qg.qg(), this);
        setContentDescription("NativeVideoAdView");
        r_();
        w();
        com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.ia.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.this.ri == null) {
                    NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                    nativeVideoTsView.ri = nativeVideoTsView.getKvCache();
                }
            }
        });
    }

    public void setEnableBlur(boolean z) {
        this.rv = z;
    }

    public void setMaterialMeta(pk pkVar) {
        this.q = pkVar;
    }

    public void r_() {
        pk pkVar = this.q;
        if (pkVar == null) {
            return;
        }
        int iL = rv.qg().l(com.byazt.vgx.w.cy(pkVar));
        if (iL == 1) {
            this.n = hd.q(this.s);
        } else if (iL == 2) {
            this.n = hd.l(this.s) || hd.q(this.s) || hd.w(this.s) || hd.s(rv.getContext()) == 1;
        } else if (iL == 3) {
            this.n = false;
        } else if (iL == 4) {
            this.cd = true;
        } else if (iL == 5) {
            this.n = hd.q(this.s) || hd.w(this.s);
        }
        if (!this.qg) {
            this.fs = this.q.kj() == 1;
        } else {
            this.fs = false;
        }
        if ("splash_ad".equals(this.k)) {
            this.n = true;
            this.fs = true;
        }
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.q(this.n);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cp();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void cp() {
        q qVar;
        com.byazt.iag.s sVar;
        if (this.qg || (qVar = this.um) == null || (sVar = this.l) == null) {
            return;
        }
        qVar.n(sVar.a(), this.l.sz(), this.l.sz() + this.l.d(), this.l.cp(), this.n, this.fs);
    }

    private View n(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.w = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.x = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.un.l());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.v = tTViewStub;
        return frameLayout;
    }

    private void w() {
        addView(n(this.s));
        oa();
    }

    public void n(final ImageView imageView, String str) {
        if (imageView == null || !com.byazt.aci.n.n(this.q) || com.byazt.aci.n.x(this.q)) {
            return;
        }
        com.byazt.imu.s.n(str).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.ia.NativeVideoTsView.2
            @Override // com.byazt.si.m
            public void n(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                Bitmap bitmapS;
                if (cyVar == null || (bitmapS = cyVar.s()) == null) {
                    return;
                }
                final Bitmap bitmapN = com.byazt.cq.qg.n(NativeVideoTsView.this.s, bitmapS, 25);
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ia.NativeVideoTsView.2.1
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

    public void d() {
        TTViewStub tTViewStub;
        if (h() || this.s == null || (tTViewStub = this.v) == null || tTViewStub.getParent() == null || this.q == null || this.tj != null) {
            return;
        }
        if (this.v.getParent() != null && (this.v.getParent() instanceof ViewGroup)) {
            this.tj = (RelativeLayout) this.v.n();
        }
        this.cp = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.oa = imageView;
        if (this.sz) {
            com.byazt.okk.s.n((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(ta.qg(this.q))) {
            com.byazt.imu.s.n(ta.qg(this.q)).n(this.cp);
            n(this.cp, ta.qg(this.q));
        }
        x();
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.v.getParent() != null && (this.v.getParent() instanceof ViewGroup)) {
            this.tj = (RelativeLayout) this.v.n();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.cp = imageView;
        imageView.setImageDrawable(null);
        this.oa = (ImageView) findViewById(2114387847);
        com.byazt.imu.s.n(str).n(this.cp);
        n(this.cp, str);
        com.byazt.okk.s.n((View) this.tj, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i, int i2) {
        if (um()) {
            return;
        }
        pk pkVar = this.q;
        k kVarGy = pkVar == null ? null : pkVar.gy();
        if (kVarGy != null && i2 > 0) {
            if (!kVarGy.fs()) {
                com.byazt.hm.n.n(this.q, this.k, 1);
                return;
            }
            this.df = i;
            this.oj = i2;
            if (this.wo == null) {
                this.wo = new s(kVarGy, this.w, this.q, this.k, this.df, this.oj);
            }
            com.byazt.imu.s.n(kVarGy.l()).s(3).n(Bitmap.Config.RGB_565).n(this.wo);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 2549})
    public static class s implements m {
        public String l;
        public k n;
        public pk q;
        public WeakReference<ViewGroup> qg;
        public WeakReference<GifView> s = new WeakReference<>(null);
        public int w;
        public int x;

        public s(k kVar, ViewGroup viewGroup, pk pkVar, String str, int i, int i2) {
            this.n = kVar;
            this.qg = new WeakReference<>(viewGroup);
            this.q = pkVar;
            this.l = str;
            this.w = i;
            this.x = i2;
        }

        @Override // com.byazt.si.m
        public void n(final cy cyVar) {
            try {
                ViewGroup viewGroup = this.qg.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.byazt.ia.NativeVideoTsView.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) s.this.qg.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            s sVar = s.this;
                            sVar.n(context, sVar.n, cyVar, viewGroup2);
                        } catch (Exception unused) {
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                n(1002, "", e);
            }
        }

        @Override // com.byazt.si.m
        public void n(int i, String str, Throwable th) {
            com.byazt.tk.k.qg("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.s.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.byazt.hm.n.n(this.q, this.l, 2);
        }

        private int n() {
            if (this.n.w() > 0.0d) {
                return (int) (((double) this.x) * this.n.w());
            }
            return this.x / 2;
        }

        private void n(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.n.s() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = com.byazt.okk.s.s(context, 19.0f);
            }
        }

        private void n(Object obj, cy cyVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (cyVar.fs()) {
                    gifView.n((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(com.byazt.imu.n.n((byte[]) obj, 0));
                }
            }
        }

        private void n(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Context context, k kVar, cy cyVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iS = com.byazt.okk.s.s(context, 12.0f);
            this.w = viewGroup.getWidth() <= 0 ? this.w : viewGroup.getWidth();
            this.x = viewGroup.getHeight() <= 0 ? this.x : viewGroup.getHeight();
            int iN = n();
            if (kVar.n() == 3) {
                if (iN > com.byazt.okk.s.s(context, 88.0f)) {
                    iN = com.byazt.okk.s.s(context, 88.0f);
                }
            } else if (kVar.n() == 4 && iN > com.byazt.okk.s.s(context, 178.0f)) {
                iN = com.byazt.okk.s.s(context, 178.0f);
            }
            int i = this.w - iS;
            int iX = (int) (((double) iN) * kVar.x());
            if (iX > i && iX > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iN);
            }
            n(context, layoutParams, iS);
            gifView.setVisibility(0);
            n(cyVar.s(), cyVar, gifView);
            n(this.s.get());
            viewGroup.addView(gifView, layoutParams);
            this.s = new WeakReference<>(gifView);
            com.byazt.hm.n.n(this.q, this.l, 0);
        }
    }

    private void x() {
        if (!(this instanceof NativeDrawVideoTsView) || this.hd.get() || com.byazt.vyf.s.cy().dg() == null) {
            return;
        }
        this.oa.setImageBitmap(com.byazt.vyf.s.cy().dg());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oa.getLayoutParams();
        int iS = com.byazt.okk.s.s(getContext(), this.cy);
        layoutParams.width = iS;
        layoutParams.height = iS;
        this.oa.setLayoutParams(layoutParams);
        this.hd.set(true);
    }

    public void oa() {
        this.l = n(this.s, this.x, this.q, this.k, !um(), this.m, this.hu);
        hu();
        this.rf = new View.OnAttachStateChangeListener() { // from class: com.byazt.ia.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.y = nativeVideoTsView.w.getViewTreeObserver();
                if (NativeVideoTsView.this.y == null || NativeVideoTsView.this.sh == null) {
                    return;
                }
                NativeVideoTsView.this.y.addOnGlobalLayoutListener(NativeVideoTsView.this.sh);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.m();
            }
        };
        this.sh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ia.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.w.getWidth();
                int height = NativeVideoTsView.this.w.getHeight();
                ((com.byazt.ia.q) NativeVideoTsView.this.l).n(width, height);
                NativeVideoTsView.this.m();
                NativeVideoTsView.this.qg(width, height);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.sh) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public com.byazt.iag.s n(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.byazt.ia.q(context, viewGroup, pkVar, str, z, z2, z3);
    }

    public void setVideoAdLoadListener(com.byazt.iag.s.q qVar) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.n(qVar);
        }
    }

    public void setNativeVideoAdListener(com.byazt.iag.s.n nVar) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.n(nVar);
        }
    }

    public boolean n(long j, boolean z, boolean z2) {
        boolean zN = false;
        this.w.setVisibility(0);
        if (this.l == null) {
            this.l = new com.byazt.ia.q(this.s, this.x, this.q, this.k, this.m, this.hu);
            hu();
        }
        this.bb = j;
        if (um()) {
            this.l.n(false);
            if (ta.k(this.q) != null) {
                com.byazt.zsl.l lVarN = ta.n(4, this.q);
                lVarN.qg(this.q.q());
                lVarN.qg(this.w.getWidth());
                lVarN.s(this.w.getHeight());
                lVarN.s(this.q.F_());
                lVarN.n(j);
                lVarN.qg(cd());
                if (z2) {
                    this.l.qg(lVarN);
                    return true;
                }
                zN = n(lVarN);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.h)) && (this.l instanceof com.byazt.du.n)) {
                um.n nVar = new um.n();
                nVar.n(this.l.cp());
                nVar.s(this.l.sz());
                nVar.qg(this.l.d());
                com.byazt.iag.s sVar = this.l;
                ((com.byazt.du.n) sVar).qg(sVar.cd(), nVar);
            }
            return zN;
        }
        if (sz() || this.rv) {
            n(this.s, 25, ta.qg(this.q));
        }
        return true;
    }

    public boolean sz() {
        pk pkVar = this.q;
        return pkVar != null && pkVar.ds() == 4 && nf.n(this.q) == 1 && !TextUtils.equals("draw_ad", this.k);
    }

    private void hu() {
        com.byazt.iag.s sVar = this.l;
        if (sVar == null) {
            return;
        }
        sVar.q(this.n);
        ((com.byazt.ia.q) this.l).n((com.byazt.ia.q.n) this);
        this.l.n(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.dg) {
            ViewGroup viewGroup = this.w;
            if (viewGroup != null && (onAttachStateChangeListener = this.rf) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            q();
            fs.n(this);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.dg) {
            q();
        }
    }

    public void q() {
        com.byazt.iag.s sVar = this.l;
        if (sVar == null) {
            oa();
        } else if ((sVar instanceof com.byazt.ia.q) && !um()) {
            ((com.byazt.ia.q) this.l).sh();
        }
        if (this.l == null || !this.a.get()) {
            return;
        }
        this.a.set(false);
        r_();
        if (hd()) {
            ImageView imageView = this.d;
            if (imageView != null) {
                com.byazt.okk.s.n((View) imageView, 8);
            }
            if (ta.k(this.q) != null) {
                com.byazt.zsl.l lVarN = ta.n(4, this.q);
                lVarN.qg(this.q.q());
                lVarN.qg(this.w.getWidth());
                lVarN.s(this.w.getHeight());
                lVarN.s(this.q.F_());
                lVarN.n(0L);
                lVarN.n(com.byazt.ql.s.n(this.q));
                lVarN.qg(cd());
                if (h()) {
                    String strQ = com.byazt.ql.qg.n(0).q();
                    if (this.q.bi()) {
                        strQ = com.byazt.ql.qg.n();
                    }
                    lVarN.n(strQ);
                }
                n(lVarN);
                this.l.s(false);
                return;
            }
            com.byazt.tk.k.qg("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.l.a()) {
            q(true);
        } else {
            d();
            com.byazt.okk.s.n((View) this.tj, 0);
        }
    }

    private boolean h() {
        return TextUtils.equals(this.k, "splash_ad") || TextUtils.equals(this.k, "cache_splash_ad");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.w;
        if (viewGroup != null && (onAttachStateChangeListener = this.rf) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        k();
        this.wo = null;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        k();
    }

    public void k() {
        this.um = null;
        a();
        cy();
    }

    public void cy() {
        if (!this.a.get()) {
            this.a.set(true);
            if (this.l != null) {
                t tVar = this.ln;
                if (tVar != null) {
                    tVar.removeCallbacksAndMessages(null);
                }
                this.l.n(true, 3);
            }
        }
        this.ic.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            cy();
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 1) {
            return;
        }
        t();
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.t = nativeExpressVideoView;
    }

    private void t() {
        boolean zUr = ur();
        if (this.lq && zUr) {
            com.byazt.iag.s sVar = this.l;
            if (sVar instanceof com.byazt.ia.q) {
                ((com.byazt.ia.q) sVar).j();
            }
            this.lq = false;
        } else {
            if (this.nf == null) {
                this.nf = new qg();
            } else {
                com.byazt.tk.rv.qg().removeCallbacks(this.nf);
            }
            this.nf.n(zUr);
            com.byazt.tk.rv.qg().post(this.nf);
        }
        this.ln.sendEmptyMessageDelayed(1, this.j);
    }

    private boolean ur() {
        View view;
        if (!com.byazt.ql.s.n(this.q)) {
            view = this;
        } else if (nf.n(this.q) == 2) {
            view = this.t;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return com.byazt.okk.q.qg(view, com.byazt.fr.s.n().n(50, this.q), 5);
    }

    private boolean bb() {
        if (um()) {
            return false;
        }
        if (this.ri == null) {
            this.ri = getKvCache();
        }
        return this.ri.qg("key_video_is_from_detail_page", false) || this.ri.qg("key_video_isfromvideodetailpage", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s getKvCache() {
        pk pkVar = this.q;
        return com.byazt.lk.l.n(pkVar == null ? null : pkVar.mk(), "sp_multi_native_video_data");
    }

    private void ln() {
        if (um()) {
            return;
        }
        if (this.ri == null) {
            this.ri = getKvCache();
        }
        this.ri.n("key_video_isfromvideodetailpage", false);
        this.ri.n("key_video_is_from_detail_page", false);
    }

    public void s(boolean z) {
        com.byazt.rg.l lVar = this.b;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        if (this.pe || this.ou == z) {
            return;
        }
        if (!z) {
            com.byazt.tk.rv.qg().removeCallbacks(this.nf);
        }
        this.ou = z;
        s(z);
        if (this.q == null || this.l == null) {
            return;
        }
        boolean zBb = bb();
        ln();
        if (zBb && this.l.a()) {
            q(true);
            l();
            return;
        }
        if (z && !this.l.a() && !this.l.cy()) {
            if (this.l.hd() != null && this.l.hd().d()) {
                if (this.n) {
                    if ("ALP-AL00".equals(((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg())) {
                        this.l.fs();
                    } else {
                        ((com.byazt.ia.q) this.l).w(zBb);
                    }
                    com.byazt.iag.s.InterfaceC0200s interfaceC0200s = this.ae;
                    if (interfaceC0200s != null) {
                        interfaceC0200s.u_();
                    }
                    com.byazt.rg.l lVar = this.b;
                    if (lVar != null) {
                        lVar.x();
                        return;
                    }
                    return;
                }
                this.ou = false;
                return;
            }
            if (this.n && this.l.hd() == null) {
                if (!this.a.get()) {
                    this.a.set(true);
                }
                this.ic.set(false);
                q();
                return;
            }
            return;
        }
        if (this.l.hd() == null || !this.l.hd().tj()) {
            return;
        }
        this.l.w();
        com.byazt.iag.s.InterfaceC0200s interfaceC0200s2 = this.ae;
        if (interfaceC0200s2 != null) {
            interfaceC0200s2.t_();
        }
        com.byazt.rg.l lVar2 = this.b;
        if (lVar2 != null) {
            lVar2.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.byazt.iag.s sVar;
        com.byazt.iag.s sVar2;
        com.byazt.iag.s sVar3;
        com.byazt.iag.s sVar4;
        super.onWindowFocusChanged(z);
        if (this.dg) {
            this.f = z;
            v();
            if (bb() && (sVar4 = this.l) != null && sVar4.a()) {
                ln();
                com.byazt.okk.s.n((View) this.tj, 8);
                q(true);
                l();
                return;
            }
            r_();
            if (um() || !hd() || (sVar2 = this.l) == null || sVar2.cy()) {
                if (hd()) {
                    return;
                }
                if (!z && (sVar = this.l) != null && sVar.hd() != null && this.l.hd().tj()) {
                    this.ln.removeMessages(1);
                    qg(false);
                    return;
                } else {
                    if (z) {
                        this.ln.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            if (this.ln != null) {
                if (z && (sVar3 = this.l) != null && !sVar3.a()) {
                    this.ln.obtainMessage(1).sendToTarget();
                } else {
                    this.ln.removeMessages(1);
                    qg(false);
                }
            }
        }
    }

    private void lh() {
        if (this.dh == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.dh.hashCode()) {
                    this.dh.hashCode();
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.byazt.iag.s sVar;
        com.byazt.iag.s sVar2;
        com.byazt.iag.s sVar3;
        super.onWindowVisibilityChanged(i);
        if (this.dg) {
            lh();
            v();
            if (this.yw) {
                this.yw = i == 0;
            }
            if (bb() && (sVar3 = this.l) != null && sVar3.a()) {
                ln();
                com.byazt.okk.s.n((View) this.tj, 8);
                q(true);
                l();
                return;
            }
            r_();
            if (um() || !hd() || (sVar = this.l) == null || sVar.cy() || this.q == null) {
                return;
            }
            boolean zQg = com.byazt.okk.q.qg(this, com.byazt.fr.s.n().n(20, this.q), 5);
            isShown();
            if (this.ur && ta.k(this.q) != null && zQg) {
                com.byazt.zsl.l lVarN = ta.n(4, this.q);
                lVarN.qg(this.q.q());
                lVarN.qg(this.w.getWidth());
                lVarN.s(this.w.getHeight());
                lVarN.s(this.q.F_());
                lVarN.n(this.bb);
                lVarN.qg(cd());
                n(lVarN);
                com.byazt.okk.s.n((View) this.tj, 8);
            } else {
                try {
                    com.byazt.tk.k.qg("NativeVideoAdView", "onWindowVisibilityChanged materialMeta.getVideo() is null " + (this.tj == null) + " " + this.yw + " " + hashCode());
                    if (this.yw && this.tj == null) {
                        d();
                        com.byazt.okk.s.n((View) this.tj, 0);
                    }
                } catch (Throwable unused) {
                }
            }
            if (i != 0 || !this.f || this.ln == null || (sVar2 = this.l) == null || sVar2.a()) {
                return;
            }
            this.ln.obtainMessage(1).sendToTarget();
        }
    }

    public boolean n(com.byazt.zsl.l lVar) {
        if (this.l == null) {
            return false;
        }
        this.ur = false;
        this.j = this.an;
        if (this.pk) {
            lVar.qg(this.u);
        }
        return this.l.n(lVar);
    }

    private void v() {
        if (this.ri == null) {
            this.ri = getKvCache();
        }
        com.byazt.iag.s sVar = this.l;
        if (sVar == null || um() || !this.ri.qg("key_video_is_update_flag", false)) {
            return;
        }
        boolean zQg = this.ri.qg("key_native_video_complete", false);
        long jQg = this.ri.qg("key_video_current_play_position", -1L);
        long jQg2 = this.ri.qg("key_video_total_play_duration", sVar.sz() + sVar.d());
        long jQg3 = this.ri.qg("key_video_duration", sVar.sz());
        sVar.s(zQg);
        if (zQg) {
            sVar.qg(jQg3);
        } else {
            sVar.qg(jQg);
        }
        sVar.s(jQg2);
        sVar.q(jQg3);
        this.ri.n("key_video_is_update_flag", false);
    }

    public void setNativeVideoController(com.byazt.iag.s sVar) {
        this.l = sVar;
    }

    public com.byazt.iag.s getNativeVideoController() {
        return this.l;
    }

    public boolean hd() {
        return this.n;
    }

    public void setIsAutoPlay(boolean z) {
        pk pkVar;
        if (this.lh || (pkVar = this.q) == null) {
            return;
        }
        int iL = rv.qg().l(com.byazt.vgx.w.cy(pkVar));
        if (z && iL != 4 && (!hd.l(this.s) ? !(!hd.w(this.s) ? hd.q(this.s) : j() || an()) : !j())) {
            z = false;
        }
        this.n = z;
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.q(z);
        }
        if (!this.n) {
            d();
            RelativeLayout relativeLayout = this.tj;
            if (relativeLayout != null) {
                com.byazt.okk.s.n((View) relativeLayout, 0);
                if (ta.k(this.q) != null) {
                    com.byazt.imu.s.n(ta.qg(this.q)).n(this.cp);
                    n(this.cp, ta.qg(this.q));
                } else {
                    com.byazt.tk.k.qg("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            com.byazt.okk.s.n((View) this.tj, 8);
        }
        this.lh = true;
    }

    private boolean j() {
        return 2 == rv.qg().l(com.byazt.vgx.w.cy(this.q));
    }

    private boolean an() {
        return 5 == rv.qg().l(com.byazt.vgx.w.cy(this.q));
    }

    public boolean cd() {
        return this.fs;
    }

    public void n(boolean z, boolean z2) {
        this.u = z;
        this.pk = z2;
    }

    public void setIsQuiet(boolean z) {
        this.fs = z;
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.qg(z);
        }
    }

    public void setPlayState(boolean z) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            if (z) {
                sVar.w();
                com.byazt.rg.l lVar = this.b;
                if (lVar != null) {
                    lVar.w();
                    return;
                }
                return;
            }
            sVar.fs();
            com.byazt.rg.l lVar2 = this.b;
            if (lVar2 != null) {
                lVar2.x();
            }
        }
    }

    public void setEnableAutoCheck(boolean z) {
        this.dg = z;
    }

    public boolean um() {
        return this.qg;
    }

    public void setVideoAdInteractionListener(com.byazt.iag.s.InterfaceC0200s interfaceC0200s) {
        this.ae = interfaceC0200s;
    }

    @Override // com.byazt.ia.q.n
    public void fs() {
        com.byazt.okk.s.n((View) this.tj, 8);
        com.byazt.iag.s.InterfaceC0200s interfaceC0200s = this.ae;
        if (interfaceC0200s != null && !this.cx) {
            this.cx = true;
            interfaceC0200s.s_();
        }
        com.byazt.okk.s.n((View) this.tj, 8);
        com.byazt.rg.l lVar = this.b;
        if (lVar != null) {
            lVar.n();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.sz = z;
    }

    @Override // com.byazt.ia.q.n
    public void n(int i) {
        r_();
    }

    @Override // com.byazt.ia.q.n
    public void rv() {
        this.lq = true;
        if (this.ln.hasMessages(1)) {
            return;
        }
        this.ln.sendEmptyMessage(1);
    }

    public void qg(int i) {
        if (hd.s(rv.getContext()) == 0) {
            return;
        }
        if (this.l.hd() != null) {
            if (this.l.hd().tj() && i == 2) {
                qg(false);
                t tVar = this.ln;
                if (tVar != null) {
                    tVar.removeMessages(1);
                }
                n(true);
                return;
            }
            if (this.l.hd().d() && i == 3) {
                this.n = true;
                qg(true);
                r_();
                t tVar2 = this.ln;
                if (tVar2 != null) {
                    tVar2.sendEmptyMessageDelayed(1, this.j);
                }
                n(false);
                return;
            }
        }
        if (hd() || this.ic.get()) {
            return;
        }
        this.ic.set(true);
        if (ta.k(this.q) != null) {
            ae();
            com.byazt.zsl.l lVarN = ta.n(4, this.q);
            lVarN.qg(this.q.q());
            lVarN.qg(this.w.getWidth());
            lVarN.s(this.w.getHeight());
            lVarN.s(this.q.F_());
            lVarN.n(this.bb);
            lVarN.qg(cd());
            lVarN.n(com.byazt.ql.qg.n(this.q.io()).n());
            n(lVarN);
        } else {
            com.byazt.tk.k.qg("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        t tVar3 = this.ln;
        if (tVar3 != null) {
            tVar3.sendEmptyMessageDelayed(1, this.j);
        }
        n(false);
    }

    public void qg() {
        if (hd.s(rv.getContext()) == 0) {
            return;
        }
        if (this.l.hd() != null) {
            if (this.l.hd().tj()) {
                qg(false);
                t tVar = this.ln;
                if (tVar != null) {
                    tVar.removeMessages(1);
                }
                n(true);
                return;
            }
            if (this.l.hd().d()) {
                this.n = true;
                qg(true);
                r_();
                t tVar2 = this.ln;
                if (tVar2 != null) {
                    tVar2.sendEmptyMessageDelayed(1, this.j);
                }
                n(false);
                return;
            }
        }
        if (hd() || this.ic.get()) {
            return;
        }
        this.ic.set(true);
        if (ta.k(this.q) != null) {
            ae();
            com.byazt.zsl.l lVarN = ta.n(4, this.q);
            lVarN.qg(this.q.q());
            lVarN.qg(this.w.getWidth());
            lVarN.s(this.w.getHeight());
            lVarN.s(this.q.F_());
            lVarN.n(this.bb);
            lVarN.qg(cd());
            n(lVarN);
        } else {
            com.byazt.tk.k.qg("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        t tVar3 = this.ln;
        if (tVar3 != null) {
            tVar3.sendEmptyMessageDelayed(1, this.j);
        }
        n(false);
    }

    public void n(boolean z) {
        if (this.d == null) {
            this.d = new ImageView(getContext());
            if (com.byazt.vyf.s.cy().dg() != null) {
                this.d.setImageBitmap(com.byazt.vyf.s.cy().dg());
            } else {
                sz.n(rv.getContext(), "tt_new_play_video", this.d, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            int iS = com.byazt.okk.s.s(getContext(), this.cy);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iS, iS);
            layoutParams.gravity = 17;
            this.w.addView(this.d, layoutParams);
        }
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }

    public void q(boolean z) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.s(z);
            com.byazt.iag.qg qgVarCd = this.l.cd();
            if (qgVarCd != null) {
                qgVarCd.qg();
                View viewS = qgVarCd.s();
                if (viewS != null) {
                    if (viewS.getParent() != null) {
                        ((ViewGroup) viewS.getParent()).removeView(viewS);
                    }
                    viewS.setVisibility(0);
                    addView(viewS);
                    qgVarCd.n(this.q, new WeakReference<>(this.s), false);
                }
            }
        }
    }

    public void a() {
        com.byazt.iag.qg qgVarCd;
        com.byazt.iag.s sVar = this.l;
        if (sVar == null || (qgVarCd = sVar.cd()) == null) {
            return;
        }
        qgVarCd.n();
        View viewS = qgVarCd.s();
        if (viewS != null) {
            viewS.setVisibility(8);
            if (viewS.getParent() != null) {
                ((ViewGroup) viewS.getParent()).removeView(viewS);
            }
        }
    }

    private void ae() {
        com.byazt.okk.s.l(this.d);
        com.byazt.okk.s.l(this.tj);
    }

    public void n(int i, int i2) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            ((com.byazt.ia.q) sVar).n(i, i2);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.py = str;
    }

    public void n(final Context context, final int i, String str) {
        final com.byazt.iag.qg qgVarCd;
        com.byazt.iag.s sVar = this.l;
        if (sVar == null || (qgVarCd = sVar.cd()) == null) {
            return;
        }
        com.byazt.imu.s.n(str).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.ia.NativeVideoTsView.5
            @Override // com.byazt.si.m
            public void n(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                Bitmap bitmapN = com.byazt.cq.qg.n(context, cyVar.s(), i);
                if (bitmapN == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapN);
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ia.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qgVarCd != null) {
                            qgVarCd.n(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }

    public void py() {
        if (this.l != null) {
            ae();
            this.l.qg();
        }
    }

    public void setComplete(boolean z) {
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.s(z);
        }
    }

    public void ou() {
        wm();
        com.byazt.iag.s sVar = this.l;
        if (sVar != null) {
            sVar.wm();
        }
    }

    public void wm() {
        t tVar = this.ln;
        if (tVar != null) {
            tVar.removeCallbacksAndMessages(null);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 1801})
    private class qg implements Runnable {
        public volatile boolean qg;

        private qg() {
        }

        public Runnable n(boolean z) {
            this.qg = z;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.qg(this.qg);
        }
    }
}
