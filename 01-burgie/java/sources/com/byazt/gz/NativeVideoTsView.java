package com.byazt.gz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
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
import com.byazt.bs.TTViewStub;
import com.byazt.ca.aj;
import com.byazt.ca.iu;
import com.byazt.ca.yb;
import com.byazt.hg.ho;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.jt.GifView;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.mr.m;
import com.byazt.qx.NativeExpressVideoView;
import com.byazt.sd.a;
import com.byazt.sd.ww;
import com.byazt.vkw.g;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.k;
import com.byazt.zp.w;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 2323})
public class NativeVideoTsView extends FrameLayout implements com.byazt.w.hn.pr, qi.pr, com.byazt.gz.x.pr {
    public final AtomicBoolean a;
    public boolean aj;
    public boolean b;
    public hw bm;
    public com.byazt.w.hn c;
    public String cz;
    public long e;
    public boolean er;
    public com.byazt.zq.hn f;
    public boolean fo;
    public FrameLayout fw;
    public boolean g;
    public long gz;
    public final Context hn;
    public String ho;
    public ViewTreeObserver hs;
    public boolean hw;
    public hn i;
    public ViewGroup ie;
    public boolean ii;
    public NativeExpressVideoView iu;
    public boolean jn;
    public ImageView k;
    public boolean l;
    public boolean lb;
    public boolean ls;
    public boolean lv;
    public ImageView m;
    public AtomicBoolean mw;
    public long n;
    public final iu nl;
    public int nt;
    public View.OnAttachStateChangeListener nw;
    public boolean ny;
    public com.byazt.uq.fw o;
    public boolean od;
    public boolean of;
    public boolean pr;
    public x qa;
    public int qi;
    public boolean qn;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public boolean rc;
    public com.byazt.w.hn.InterfaceC0220hn s;
    public ViewGroup uc;
    public int v;
    public boolean ve;
    public volatile boolean vj;
    public RelativeLayout vk;
    public ImageView w;
    public TTViewStub ww;
    public of x;
    public boolean y;
    public AtomicBoolean yb;
    public boolean z;
    public boolean zo;

    public interface pr {
        void pr(View view, int i);
    }

    public interface x {
        void pr(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    public void setNativeRenderAd(boolean z) {
        this.l = z;
    }

    public boolean vk() {
        return this.l;
    }

    public void setEasyPlayableEventSender(com.byazt.uq.fw fwVar) {
        this.o = fwVar;
    }

    public void setDrawVideoListener(com.byazt.ng.pr prVar) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            ((com.byazt.gz.x) hnVar).pr(prVar);
        }
    }

    public void setAdCreativeClickListener(pr prVar) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            ((com.byazt.gz.x) hnVar).pr(prVar);
        }
    }

    public void setVideoAdClickListenerTTNativeAd(m mVar) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            ((com.byazt.gz.x) hnVar).pr(mVar);
        }
    }

    public void setControllerStatusCallBack(x xVar) {
        this.qa = xVar;
    }

    @Override // com.byazt.w.hn.pr
    public void pr(long j, int i) {
        this.jn = true;
        com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn = this.s;
        if (interfaceC0220hn != null) {
            interfaceC0220hn.p_();
        }
    }

    private void zo() {
        pr(0L, 0);
        this.s = null;
    }

    @Override // com.byazt.w.hn.pr
    public void hw(long j, int i) {
        this.fo = true;
    }

    public boolean getVideoError() {
        return this.fo;
    }

    @Override // com.byazt.w.hn.pr
    public void pr() {
        if (this.s != null && z()) {
            this.s.p_();
        }
    }

    @Override // com.byazt.w.hn.pr
    public void pr(long j, long j2) {
        com.byazt.w.hn hnVar;
        if (j != j2) {
            this.jn = false;
        }
        com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn = this.s;
        if (interfaceC0220hn != null) {
            interfaceC0220hn.pr(j, j2);
        }
        if (!iu() && (hnVar = this.c) != null) {
            hnVar.uc();
        }
    }

    public NativeVideoTsView(Context context, of ofVar) {
        this(context, ofVar, false, false);
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public NativeVideoTsView(Context context, of ofVar, boolean z, boolean z2) {
        this(context, ofVar, z, z2, com.byazt.pfl.hw.AD_TAG_FEED, false, false);
    }

    public NativeVideoTsView(Context context, of ofVar, String str, boolean z, boolean z2) {
        this(context, ofVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, of ofVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.pr = true;
        this.zo = true;
        this.hw = false;
        this.ny = false;
        this.fo = false;
        this.rc = false;
        this.z = true;
        this.b = false;
        this.g = true;
        this.ho = com.byazt.pfl.hw.AD_TAG_FEED;
        this.nt = 50;
        this.ve = true;
        this.yb = new AtomicBoolean(false);
        this.y = false;
        this.lb = false;
        this.n = 50L;
        this.e = 500L;
        this.ls = true;
        this.er = false;
        this.qn = true;
        this.of = true;
        this.jn = false;
        this.a = new AtomicBoolean(false);
        this.lv = true;
        this.vj = false;
        this.mw = new AtomicBoolean(false);
        this.ho = str;
        this.hn = context;
        this.x = ofVar;
        this.hw = z;
        this.b = z2;
        this.rc = z3;
        this.z = z4;
        this.nl = new iu(zo.hw(), this);
        setContentDescription("NativeVideoAdView");
        fw();
        cz();
        zo.hw(new Runnable() { // from class: com.byazt.gz.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.this.f == null) {
                    NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                    nativeVideoTsView.f = nativeVideoTsView.getKvCache();
                }
            }
        });
    }

    public void setEnableBlur(boolean z) {
        this.aj = z;
    }

    public void setMaterialMeta(of ofVar) {
        this.x = ofVar;
    }

    public void fw() {
        of ofVar = this.x;
        if (ofVar == null) {
            return;
        }
        switch (a.hw().uc(ls.m(ofVar))) {
            case 1:
                this.pr = yb.x(this.hn);
                break;
            case 2:
                this.pr = yb.c(this.hn) || yb.x(this.hn) || yb.uc(this.hn) || yb.hn(a.getContext()) == 1;
                break;
            case 3:
                this.pr = false;
                break;
            case 4:
                this.lb = true;
                break;
            case 5:
                this.pr = yb.x(this.hn) || yb.uc(this.hn);
                break;
        }
        if (!this.hw) {
            this.zo = this.x.ax() == 1;
        } else {
            this.zo = false;
        }
        if ("splash_ad".equals(this.ho)) {
            this.pr = true;
            this.zo = true;
        }
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.x(this.pr);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        w();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void w() {
        x xVar;
        com.byazt.w.hn hnVar;
        if (!this.hw && (xVar = this.qa) != null && (hnVar = this.c) != null) {
            xVar.pr(hnVar.a(), this.c.g(), this.c.g() + this.c.k(), this.c.w(), this.pr, this.zo);
        }
    }

    private View pr(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.uc = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.fw = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.jf.c());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.ww = tTViewStub;
        return frameLayout;
    }

    private void cz() {
        addView(pr(this.hn));
        M_();
    }

    public void pr(final ImageView imageView, String str) {
        if (imageView != null && com.byazt.ja.pr.pr(this.x) && !com.byazt.ja.pr.fw(this.x)) {
            com.byazt.ub.hw.pr(str).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.gz.NativeVideoTsView.2
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapHn;
                    if (ntVar != null && (bitmapHn = ntVar.hn()) != null) {
                        final Bitmap bitmapPr = com.byazt.js.hw.pr(NativeVideoTsView.this.hn, bitmapHn, 25);
                        zo.pr(new Runnable() { // from class: com.byazt.gz.NativeVideoTsView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bitmapPr != null) {
                                    imageView.setBackground(new BitmapDrawable(bitmapPr));
                                }
                            }
                        });
                    }
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str2, Throwable th) {
                }
            }, 4);
        }
    }

    public void k() {
        TTViewStub tTViewStub;
        if (z() || this.hn == null || (tTViewStub = this.ww) == null || tTViewStub.getParent() == null || this.x == null || this.vk != null) {
            return;
        }
        if (this.ww.getParent() != null && (this.ww.getParent() instanceof ViewGroup)) {
            this.vk = (RelativeLayout) this.ww.pr();
        }
        this.w = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.m = imageView;
        if (this.g) {
            er.pr((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(qv.hw(this.x))) {
            com.byazt.ub.hw.pr(qv.hw(this.x)).pr(this.w);
            pr(this.w, qv.hw(this.x));
        }
        ny();
    }

    public void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.ww.getParent() != null && (this.ww.getParent() instanceof ViewGroup)) {
            this.vk = (RelativeLayout) this.ww.pr();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.w = imageView;
        imageView.setImageDrawable(null);
        this.m = (ImageView) findViewById(2114387847);
        com.byazt.ub.hw.pr(str).pr(this.w);
        pr(this.w, str);
        er.pr((View) this.vk, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i, int i2) {
        if (!yb()) {
            of ofVar = this.x;
            ho hoVarEz = ofVar == null ? null : ofVar.ez();
            if (hoVarEz == null || i2 <= 0) {
                return;
            }
            if (!hoVarEz.zo()) {
                com.byazt.pj.pr.pr(this.x, this.ho, 1);
                return;
            }
            this.v = i;
            this.qi = i2;
            if (this.i == null) {
                this.i = new hn(hoVarEz, this.uc, this.x, this.ho, i, i2);
            }
            com.byazt.ub.hw.pr(hoVarEz.c()).hn(3).pr(Bitmap.Config.RGB_565).pr(this.i);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 672, 1552})
    public static class hn implements rc {
        public String c;
        public int fw;
        public WeakReference<GifView> hn = new WeakReference<>(null);
        public WeakReference<ViewGroup> hw;
        public ho pr;
        public int uc;
        public of x;

        public hn(ho hoVar, ViewGroup viewGroup, of ofVar, String str, int i, int i2) {
            this.pr = hoVar;
            this.hw = new WeakReference<>(viewGroup);
            this.x = ofVar;
            this.c = str;
            this.uc = i;
            this.fw = i2;
        }

        @Override // com.byazt.ld.rc
        public void pr(final nt ntVar) {
            try {
                ViewGroup viewGroup = this.hw.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.byazt.gz.NativeVideoTsView.hn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) hn.this.hw.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            hn hnVar = hn.this;
                            hnVar.pr(context, hnVar.pr, ntVar, viewGroup2);
                        } catch (Exception e) {
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                pr(1002, "", e);
            }
        }

        @Override // com.byazt.ld.rc
        public void pr(int i, String str, Throwable th) {
            com.byazt.ca.ho.hw("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.hn.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.byazt.pj.pr.pr(this.x, this.c, 2);
        }

        private int pr() {
            if (this.pr.uc() > 0.0d) {
                return (int) (((double) this.fw) * this.pr.uc());
            }
            return this.fw / 2;
        }

        private void pr(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.pr.hn() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = er.hn(context, 19.0f);
            }
        }

        private void pr(Object obj, nt ntVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (ntVar.zo()) {
                    gifView.pr((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(com.byazt.wt.yb.pr((byte[]) obj, 0));
                }
            }
        }

        private void pr(GifView gifView) {
            if (gifView != null && gifView.getParent() != null) {
                ((ViewGroup) gifView.getParent()).removeView(gifView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(Context context, ho hoVar, nt ntVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iHn = er.hn(context, 12.0f);
            this.uc = viewGroup.getWidth() <= 0 ? this.uc : viewGroup.getWidth();
            this.fw = viewGroup.getHeight() <= 0 ? this.fw : viewGroup.getHeight();
            int iPr = pr();
            if (hoVar.pr() == 3) {
                if (iPr > er.hn(context, 88.0f)) {
                    iPr = er.hn(context, 88.0f);
                }
            } else if (hoVar.pr() == 4 && iPr > er.hn(context, 178.0f)) {
                iPr = er.hn(context, 178.0f);
            }
            int i = this.uc - iHn;
            int iFw = (int) (((double) iPr) * hoVar.fw());
            if (iFw > i && iFw > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iPr);
            }
            pr(context, layoutParams, iHn);
            gifView.setVisibility(0);
            pr(ntVar.hn(), ntVar, gifView);
            pr(this.hn.get());
            viewGroup.addView(gifView, layoutParams);
            this.hn = new WeakReference<>(gifView);
            com.byazt.pj.pr.pr(this.x, this.c, 0);
        }
    }

    private void ny() {
        if ((this instanceof NativeDrawVideoTsView) && !this.yb.get() && com.byazt.sd.zo.nt().qi() != null) {
            this.m.setImageBitmap(com.byazt.sd.zo.nt().qi());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            int iHn = er.hn(getContext(), this.nt);
            layoutParams.width = iHn;
            layoutParams.height = iHn;
            this.m.setLayoutParams(layoutParams);
            this.yb.set(true);
        }
    }

    public void M_() {
        this.c = pr(this.hn, this.fw, this.x, this.ho, !yb(), this.rc, this.z);
        rc();
        this.nw = new View.OnAttachStateChangeListener() { // from class: com.byazt.gz.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.hs = nativeVideoTsView.uc.getViewTreeObserver();
                if (NativeVideoTsView.this.hs != null && NativeVideoTsView.this.r != null) {
                    NativeVideoTsView.this.hs.addOnGlobalLayoutListener(NativeVideoTsView.this.r);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.fo();
            }
        };
        this.r = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.gz.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.uc.getWidth();
                int height = NativeVideoTsView.this.uc.getHeight();
                ((com.byazt.gz.x) NativeVideoTsView.this.c).pr(width, height);
                NativeVideoTsView.this.fo();
                NativeVideoTsView.this.hw(width, height);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.hs;
        if (viewTreeObserver != null && (onGlobalLayoutListener = this.r) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public com.byazt.w.hn pr(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.byazt.gz.x(context, viewGroup, ofVar, str, z, z2, z3);
    }

    public void setVideoAdLoadListener(com.byazt.w.hn.x xVar) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr(xVar);
        }
    }

    public void setNativeVideoAdListener(com.byazt.w.hn.pr prVar) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr(prVar);
        }
    }

    public boolean pr(long j, boolean z, boolean z2) {
        boolean zPr = false;
        this.uc.setVisibility(0);
        if (this.c == null) {
            this.c = new com.byazt.gz.x(this.hn, this.fw, this.x, this.ho, this.rc, this.z);
            rc();
        }
        this.gz = j;
        if (yb()) {
            this.c.pr(false);
            if (qv.ho(this.x) != null) {
                com.byazt.n.uc ucVarPr = qv.pr(4, this.x);
                ucVarPr.hw(this.x.x());
                ucVarPr.hw(this.uc.getWidth());
                ucVarPr.hn(this.uc.getHeight());
                ucVarPr.hn(this.x.B_());
                ucVarPr.pr(j);
                ucVarPr.hw(nt());
                if (z2) {
                    this.c.hw(ucVarPr);
                    return true;
                }
                zPr = pr(ucVarPr);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.b)) && (this.c instanceof com.byazt.vr.pr)) {
                com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                prVar.pr(this.c.w());
                prVar.hn(this.c.g());
                prVar.hw(this.c.k());
                com.byazt.w.hn hnVar = this.c;
                ((com.byazt.vr.pr) hnVar).hw(hnVar.lb(), prVar);
            }
            return zPr;
        }
        if (m() || this.aj) {
            pr(this.hn, 25, qv.hw(this.x));
        }
        return true;
    }

    public boolean m() {
        of ofVar = this.x;
        return ofVar != null && ofVar.ab() == 4 && ie.pr(this.x) == 1 && !TextUtils.equals("draw_ad", this.ho);
    }

    private void rc() {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar == null) {
            return;
        }
        hnVar.x(this.pr);
        ((com.byazt.gz.x) this.c).pr((com.byazt.gz.x.pr) this);
        this.c.pr(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (!this.qn) {
            return;
        }
        ViewGroup viewGroup = this.uc;
        if (viewGroup != null && (onAttachStateChangeListener = this.nw) != null) {
            viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        x();
        com.byazt.mk.zo.pr(this);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (!this.qn) {
            return;
        }
        x();
    }

    public void x() {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar == null) {
            M_();
        } else if ((hnVar instanceof com.byazt.gz.x) && !yb()) {
            ((com.byazt.gz.x) this.c).qi();
        }
        if (this.c != null && this.a.get()) {
            this.a.set(false);
            fw();
            if (ho()) {
                ImageView imageView = this.k;
                if (imageView != null) {
                    er.pr((View) imageView, 8);
                }
                if (qv.ho(this.x) != null) {
                    com.byazt.n.uc ucVarPr = qv.pr(4, this.x);
                    ucVarPr.hw(this.x.x());
                    ucVarPr.hw(this.uc.getWidth());
                    ucVarPr.hn(this.uc.getHeight());
                    ucVarPr.hn(this.x.B_());
                    ucVarPr.pr(0L);
                    ucVarPr.pr(k.pr(this.x));
                    ucVarPr.hw(nt());
                    if (z()) {
                        String strX = w.pr(0).x();
                        if (this.x.oc()) {
                            strX = w.pr();
                        }
                        ucVarPr.pr(strX);
                    }
                    pr(ucVarPr);
                    this.c.hn(false);
                    return;
                }
                com.byazt.ca.ho.hw("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                return;
            }
            if (this.c.a()) {
                x(true);
            } else {
                k();
                er.pr((View) this.vk, 0);
            }
        }
    }

    private boolean z() {
        return TextUtils.equals(this.ho, "splash_ad") || TextUtils.equals(this.ho, "cache_splash_ad");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.uc;
        if (viewGroup != null && (onAttachStateChangeListener = this.nw) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        c();
        this.i = null;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    public void c() {
        this.qa = null;
        lb();
        g();
    }

    public void g() {
        if (!this.a.get()) {
            this.a.set(true);
            if (this.c != null) {
                iu iuVar = this.nl;
                if (iuVar != null) {
                    iuVar.removeCallbacksAndMessages(null);
                }
                this.c.pr(true, 3);
            }
        }
        this.mw.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            g();
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                b();
                break;
        }
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.iu = nativeExpressVideoView;
    }

    private void b() {
        boolean zIu = iu();
        if (this.vj && zIu) {
            com.byazt.w.hn hnVar = this.c;
            if (hnVar instanceof com.byazt.gz.x) {
                ((com.byazt.gz.x) hnVar).gz();
            }
            this.vj = false;
        } else {
            if (this.bm == null) {
                this.bm = new hw();
            } else {
                aj.hw().removeCallbacks(this.bm);
            }
            this.bm.pr(zIu);
            aj.hw().post(this.bm);
        }
        this.nl.sendEmptyMessageDelayed(1, this.n);
    }

    private boolean iu() {
        View view;
        if (k.pr(this.x)) {
            if (ie.pr(this.x) == 2) {
                view = this.iu;
            } else {
                ViewParent parent = getParent();
                if (!(parent instanceof ViewGroup)) {
                    view = null;
                } else {
                    view = (ViewGroup) parent;
                }
            }
        } else {
            view = this;
        }
        return ww.hw(view, com.byazt.rd.hn.pr().pr(50, this.x), 5);
    }

    private boolean ve() {
        if (yb()) {
            return false;
        }
        if (this.f == null) {
            this.f = getKvCache();
        }
        return this.f.hw("key_video_is_from_detail_page", false) || this.f.hw("key_video_isfromvideodetailpage", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.zq.hn getKvCache() {
        of ofVar = this.x;
        return com.byazt.qn.x.pr(ofVar == null ? null : ofVar.yn(), "sp_multi_native_video_data");
    }

    private void gz() {
        if (yb()) {
            return;
        }
        if (this.f == null) {
            this.f = getKvCache();
        }
        this.f.pr("key_video_isfromvideodetailpage", false);
        this.f.pr("key_video_is_from_detail_page", false);
    }

    public void hn(boolean z) {
        com.byazt.uq.fw fwVar = this.o;
        if (fwVar != null) {
            fwVar.pr(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(boolean z) {
        if (this.jn || this.ny == z) {
            return;
        }
        if (!z) {
            aj.hw().removeCallbacks(this.bm);
        }
        this.ny = z;
        hn(z);
        if (this.x == null || this.c == null) {
            return;
        }
        boolean zVe = ve();
        gz();
        if (zVe && this.c.a()) {
            x(true);
            zo();
            return;
        }
        if (z && !this.c.a() && !this.c.nt()) {
            if (this.c.yb() != null && this.c.yb().k()) {
                if (this.pr) {
                    if ("ALP-AL00".equals(((g) com.byazt.zs.uc.pr("device_info_new")).hw())) {
                        this.c.zo();
                    } else {
                        ((com.byazt.gz.x) this.c).uc(zVe);
                    }
                    com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn = this.s;
                    if (interfaceC0220hn != null) {
                        interfaceC0220hn.o_();
                        return;
                    }
                    return;
                }
                this.ny = false;
                return;
            }
            if (this.pr && this.c.yb() == null) {
                if (!this.a.get()) {
                    this.a.set(true);
                }
                this.mw.set(false);
                x();
                return;
            }
            return;
        }
        if (this.c.yb() != null && this.c.yb().vk()) {
            this.c.uc();
            com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn2 = this.s;
            if (interfaceC0220hn2 != null) {
                interfaceC0220hn2.n_();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.byazt.w.hn hnVar;
        com.byazt.w.hn hnVar2;
        com.byazt.w.hn hnVar3;
        com.byazt.w.hn hnVar4;
        super.onWindowFocusChanged(z);
        if (!this.qn) {
            return;
        }
        this.ls = z;
        y();
        if (ve() && (hnVar4 = this.c) != null && hnVar4.a()) {
            gz();
            er.pr((View) this.vk, 8);
            x(true);
            zo();
            return;
        }
        fw();
        if (yb() || !ho() || (hnVar2 = this.c) == null || hnVar2.nt()) {
            if (!ho()) {
                if (!z && (hnVar = this.c) != null && hnVar.yb() != null && this.c.yb().vk()) {
                    this.nl.removeMessages(1);
                    hw(false);
                    return;
                } else {
                    if (z) {
                        this.nl.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.nl != null) {
            if (z && (hnVar3 = this.c) != null && !hnVar3.a()) {
                this.nl.obtainMessage(1).sendToTarget();
            } else {
                this.nl.removeMessages(1);
                hw(false);
            }
        }
    }

    private void nl() {
        if (this.ie == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.ie.hashCode()) {
                    this.ie.hashCode();
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.byazt.w.hn hnVar;
        com.byazt.w.hn hnVar2;
        com.byazt.w.hn hnVar3;
        super.onWindowVisibilityChanged(i);
        if (!this.qn) {
            return;
        }
        nl();
        y();
        if (this.lv) {
            this.lv = i == 0;
        }
        if (ve() && (hnVar3 = this.c) != null && hnVar3.a()) {
            gz();
            er.pr((View) this.vk, 8);
            x(true);
            zo();
            return;
        }
        fw();
        if (yb() || !ho() || (hnVar = this.c) == null || hnVar.nt() || this.x == null) {
            return;
        }
        boolean zHw = ww.hw(this, com.byazt.rd.hn.pr().pr(20, this.x), 5);
        isShown();
        if (this.ve && qv.ho(this.x) != null && zHw) {
            com.byazt.n.uc ucVarPr = qv.pr(4, this.x);
            ucVarPr.hw(this.x.x());
            ucVarPr.hw(this.uc.getWidth());
            ucVarPr.hn(this.uc.getHeight());
            ucVarPr.hn(this.x.B_());
            ucVarPr.pr(this.gz);
            ucVarPr.hw(nt());
            pr(ucVarPr);
            er.pr((View) this.vk, 8);
        } else {
            try {
                com.byazt.ca.ho.hw("NativeVideoAdView", "onWindowVisibilityChanged materialMeta.getVideo() is null " + (this.vk == null) + " " + this.lv + " " + hashCode());
                if (this.lv && this.vk == null) {
                    k();
                    er.pr((View) this.vk, 0);
                }
            } catch (Throwable th) {
            }
        }
        if (i == 0 && this.ls && this.nl != null && (hnVar2 = this.c) != null && !hnVar2.a()) {
            this.nl.obtainMessage(1).sendToTarget();
        }
    }

    public boolean pr(com.byazt.n.uc ucVar) {
        if (this.c == null) {
            return false;
        }
        this.ve = false;
        this.n = this.e;
        if (this.ii) {
            ucVar.hw(this.of);
        }
        return this.c.pr(ucVar);
    }

    private void y() {
        if (this.f == null) {
            this.f = getKvCache();
        }
        com.byazt.w.hn hnVar = this.c;
        if (hnVar == null || yb() || !this.f.hw("key_video_is_update_flag", false)) {
            return;
        }
        boolean zHw = this.f.hw("key_native_video_complete", false);
        long jHw = this.f.hw("key_video_current_play_position", -1L);
        long jHw2 = this.f.hw("key_video_total_play_duration", hnVar.g() + hnVar.k());
        long jHw3 = this.f.hw("key_video_duration", hnVar.g());
        hnVar.hn(zHw);
        if (zHw) {
            hnVar.hw(jHw3);
        } else {
            hnVar.hw(jHw);
        }
        hnVar.hn(jHw2);
        hnVar.x(jHw3);
        this.f.pr("key_video_is_update_flag", false);
    }

    public void setNativeVideoController(com.byazt.w.hn hnVar) {
        this.c = hnVar;
    }

    public com.byazt.w.hn getNativeVideoController() {
        return this.c;
    }

    public boolean ho() {
        return this.pr;
    }

    public void setIsAutoPlay(boolean z) {
        of ofVar;
        if (this.y || (ofVar = this.x) == null) {
            return;
        }
        int iUc = a.hw().uc(ls.m(ofVar));
        if (z && iUc != 4) {
            if (yb.c(this.hn)) {
                if (!ww()) {
                    z = false;
                }
            } else if (yb.uc(this.hn)) {
                if (!ww() && !n()) {
                    z = false;
                }
            } else if (!yb.x(this.hn)) {
                z = false;
            }
        }
        this.pr = z;
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.x(z);
        }
        if (!this.pr) {
            k();
            RelativeLayout relativeLayout = this.vk;
            if (relativeLayout != null) {
                er.pr((View) relativeLayout, 0);
                if (qv.ho(this.x) != null) {
                    com.byazt.ub.hw.pr(qv.hw(this.x)).pr(this.w);
                    pr(this.w, qv.hw(this.x));
                } else {
                    com.byazt.ca.ho.hw("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            er.pr((View) this.vk, 8);
        }
        this.y = true;
    }

    private boolean ww() {
        return 2 == a.hw().uc(ls.m(this.x));
    }

    private boolean n() {
        return 5 == a.hw().uc(ls.m(this.x));
    }

    public boolean nt() {
        return this.zo;
    }

    public void hw(boolean z, boolean z2) {
        this.of = z;
        this.ii = z2;
    }

    public void setIsQuiet(boolean z) {
        this.zo = z;
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.hw(z);
        }
    }

    public void setEnableAutoCheck(boolean z) {
        this.qn = z;
    }

    public boolean yb() {
        return this.hw;
    }

    public void setVideoAdInteractionListener(com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn) {
        this.s = interfaceC0220hn;
    }

    @Override // com.byazt.gz.x.pr
    public void N_() {
        er.pr((View) this.vk, 8);
        com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn = this.s;
        if (interfaceC0220hn != null && !this.od) {
            this.od = true;
            interfaceC0220hn.m_();
        }
        er.pr((View) this.vk, 8);
        com.byazt.uq.fw fwVar = this.o;
        if (fwVar != null) {
            fwVar.pr();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.g = z;
    }

    @Override // com.byazt.gz.x.pr
    public void pr(int i) {
        fw();
    }

    @Override // com.byazt.gz.x.pr
    public void aj() {
        this.vj = true;
        if (!this.nl.hasMessages(1)) {
            this.nl.sendEmptyMessage(1);
        }
    }

    public void hw(int i) {
        if (yb.hn(a.getContext()) == 0) {
            return;
        }
        if (this.c.yb() != null) {
            if (this.c.yb().vk() && i == 2) {
                hw(false);
                iu iuVar = this.nl;
                if (iuVar != null) {
                    iuVar.removeMessages(1);
                }
                pr(true);
                return;
            }
            if (this.c.yb().k() && i == 3) {
                this.pr = true;
                hw(true);
                fw();
                iu iuVar2 = this.nl;
                if (iuVar2 != null) {
                    iuVar2.sendEmptyMessageDelayed(1, this.n);
                }
                pr(false);
                return;
            }
        }
        if (!ho() && !this.mw.get()) {
            this.mw.set(true);
            if (qv.ho(this.x) != null) {
                e();
                com.byazt.n.uc ucVarPr = qv.pr(4, this.x);
                ucVarPr.hw(this.x.x());
                ucVarPr.hw(this.uc.getWidth());
                ucVarPr.hn(this.uc.getHeight());
                ucVarPr.hn(this.x.B_());
                ucVarPr.pr(this.gz);
                ucVarPr.hw(nt());
                ucVarPr.pr(w.pr(this.x.sd()).pr());
                pr(ucVarPr);
            } else {
                com.byazt.ca.ho.hw("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            }
            iu iuVar3 = this.nl;
            if (iuVar3 != null) {
                iuVar3.sendEmptyMessageDelayed(1, this.n);
            }
            pr(false);
        }
    }

    public void hw() {
        if (yb.hn(a.getContext()) == 0) {
            return;
        }
        if (this.c.yb() != null) {
            if (this.c.yb().vk()) {
                hw(false);
                iu iuVar = this.nl;
                if (iuVar != null) {
                    iuVar.removeMessages(1);
                }
                pr(true);
                return;
            }
            if (this.c.yb().k()) {
                this.pr = true;
                hw(true);
                fw();
                iu iuVar2 = this.nl;
                if (iuVar2 != null) {
                    iuVar2.sendEmptyMessageDelayed(1, this.n);
                }
                pr(false);
                return;
            }
        }
        if (!ho() && !this.mw.get()) {
            this.mw.set(true);
            if (qv.ho(this.x) != null) {
                e();
                com.byazt.n.uc ucVarPr = qv.pr(4, this.x);
                ucVarPr.hw(this.x.x());
                ucVarPr.hw(this.uc.getWidth());
                ucVarPr.hn(this.uc.getHeight());
                ucVarPr.hn(this.x.B_());
                ucVarPr.pr(this.gz);
                ucVarPr.hw(nt());
                pr(ucVarPr);
            } else {
                com.byazt.ca.ho.hw("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            }
            iu iuVar3 = this.nl;
            if (iuVar3 != null) {
                iuVar3.sendEmptyMessageDelayed(1, this.n);
            }
            pr(false);
        }
    }

    public void pr(boolean z) {
        if (this.k == null) {
            this.k = new ImageView(getContext());
            if (com.byazt.sd.zo.nt().qi() != null) {
                this.k.setImageBitmap(com.byazt.sd.zo.nt().qi());
            } else {
                com.byazt.ca.g.pr(a.getContext(), "tt_new_play_video", this.k, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.k.setScaleType(ImageView.ScaleType.FIT_XY);
            int iHn = er.hn(getContext(), this.nt);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iHn, iHn);
            layoutParams.gravity = 17;
            this.uc.addView(this.k, layoutParams);
        }
        if (z) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void x(boolean z) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.hn(z);
            com.byazt.w.hw hwVarLb = this.c.lb();
            if (hwVarLb != null) {
                hwVarLb.hw();
                View viewHn = hwVarLb.hn();
                if (viewHn != null) {
                    if (viewHn.getParent() != null) {
                        ((ViewGroup) viewHn.getParent()).removeView(viewHn);
                    }
                    viewHn.setVisibility(0);
                    addView(viewHn);
                    hwVarLb.pr(this.x, new WeakReference<>(this.hn), false);
                }
            }
        }
    }

    public void lb() {
        com.byazt.w.hw hwVarLb;
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null && (hwVarLb = hnVar.lb()) != null) {
            hwVarLb.pr();
            View viewHn = hwVarLb.hn();
            if (viewHn != null) {
                viewHn.setVisibility(8);
                if (viewHn.getParent() != null) {
                    ((ViewGroup) viewHn.getParent()).removeView(viewHn);
                }
            }
        }
    }

    private void e() {
        er.c(this.k);
        er.c(this.vk);
    }

    public void pr(int i, int i2) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            ((com.byazt.gz.x) hnVar).pr(i, i2);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.cz = str;
    }

    public void pr(final Context context, final int i, String str) {
        final com.byazt.w.hw hwVarLb;
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null && (hwVarLb = hnVar.lb()) != null && Build.VERSION.SDK_INT >= 17) {
            com.byazt.ub.hw.pr(str).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.gz.NativeVideoTsView.5
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapPr = com.byazt.js.hw.pr(context, ntVar.hn(), i);
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapPr);
                    zo.pr(new Runnable() { // from class: com.byazt.gz.NativeVideoTsView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (hwVarLb != null) {
                                hwVarLb.pr(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.byazt.ld.rc
                public void pr(int i2, String str2, Throwable th) {
                }
            }, 4);
        }
    }

    public void qa() {
        if (this.c != null) {
            e();
            this.c.hw();
        }
    }

    public void setComplete(boolean z) {
        com.byazt.w.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.hn(z);
        }
    }

    public void a() {
        iu iuVar = this.nl;
        if (iuVar != null) {
            iuVar.removeCallbacksAndMessages(null);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 672, 1550})
    private class hw implements Runnable {
        public volatile boolean hw;

        private hw() {
        }

        public Runnable pr(boolean z) {
            this.hw = z;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.hw(this.hw);
        }
    }
}
