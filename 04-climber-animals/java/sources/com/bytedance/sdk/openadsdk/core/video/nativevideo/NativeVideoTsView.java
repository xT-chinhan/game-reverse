package com.bytedance.sdk.openadsdk.core.video.nativevideo;

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
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.jw.h;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.ub;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NativeVideoTsView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.d.ah.ms, le.ms, com.bytedance.sdk.openadsdk.core.video.nativevideo.d.ms {
    private static volatile com.bytedance.sdk.component.d.ms.xr tz;
    protected FrameLayout ab;
    protected final Context ah;
    private ViewGroup am;
    protected int ao;
    private boolean az;
    private boolean b;
    protected ViewGroup c;
    protected RelativeLayout ch;
    private long cv;
    protected lm d;
    private int e;
    private boolean eg;
    private long f;
    private boolean fm;
    private final le g;
    AtomicBoolean h;
    protected ImageView hi;
    private boolean i;
    private ViewTreeObserver.OnGlobalLayoutListener il;
    private long jw;
    private boolean k;
    protected com.bykv.vk.openvk.component.video.api.d.ah ka;
    private View.OnAttachStateChangeListener l;
    private boolean le;
    private int lm;
    private boolean m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3594ms;
    private String nw;
    protected boolean ny;
    private boolean of;
    private NativeExpressVideoView op;
    private final String p;
    private TTViewStub pc;
    private ViewTreeObserver qf;
    private boolean qk;
    boolean qv;
    private boolean re;
    private boolean s;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab sa;
    protected ImageView sl;
    protected final AtomicBoolean t;
    private xr ti;
    protected boolean u;
    protected String ub;
    private com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah ul;
    private boolean v;
    private volatile boolean vm;
    private boolean w;
    protected boolean x;
    private ah xn;
    private boolean xr;
    public d y;
    private boolean yu;
    protected ImageView zb;
    private AtomicBoolean zf;

    public interface d {
        void ms(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    public interface ms {
        void ms(View view, int i);
    }

    public void setEasyPlayableEventSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab abVar) {
        this.sa = abVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) ahVar).ms(msVar);
        }
    }

    public void setAdCreativeClickListener(ms msVar) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) ahVar).ms(msVar);
        }
    }

    public void setVideoAdClickListenerTTNativeAd(zb zbVar) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) ahVar).ms(zbVar);
        }
    }

    public void setControllerStatusCallBack(d dVar) {
        this.y = dVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
    public void ms(long j, int i) {
        this.s = true;
        com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah = this.ul;
        if (interfaceC0177ah != null) {
            interfaceC0177ah.C_();
        }
    }

    private void x() {
        ms(0L, 0);
        this.ul = null;
    }

    public void xr(long j, int i) {
        this.re = true;
    }

    public boolean getVideoError() {
        return this.re;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
    public void ms() {
        if (this.ul == null || !w()) {
            return;
        }
        this.ul.C_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
    public void ms(long j, long j2) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar;
        if (j != j2) {
            this.s = false;
        }
        com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah = this.ul;
        if (interfaceC0177ah != null) {
            interfaceC0177ah.ms(j, j2);
        }
        if (op() || (ahVar = this.ka) == null) {
            return;
        }
        ahVar.c();
    }

    public NativeVideoTsView(Context context, lm lmVar) {
        this(context, lmVar, false, false);
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public NativeVideoTsView(Context context, lm lmVar, boolean z, boolean z2) {
        this(context, lmVar, z, z2, "embeded_ad", false, false);
    }

    public NativeVideoTsView(Context context, lm lmVar, String str, boolean z, boolean z2) {
        this(context, lmVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, lm lmVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.f3594ms = true;
        this.x = true;
        this.xr = false;
        this.b = false;
        this.re = false;
        this.i = false;
        this.w = true;
        this.yu = false;
        this.u = true;
        this.ub = "embeded_ad";
        this.ao = 50;
        this.le = true;
        this.h = new AtomicBoolean(false);
        this.of = false;
        this.p = t.re();
        this.qv = false;
        this.jw = 50L;
        this.f = 500L;
        this.az = true;
        this.m = false;
        this.k = true;
        this.eg = true;
        this.s = false;
        this.t = new AtomicBoolean(false);
        this.v = true;
        this.vm = false;
        this.zf = new AtomicBoolean(false);
        this.ub = str;
        this.ah = context;
        this.d = lmVar;
        this.xr = z;
        this.yu = z2;
        this.i = z3;
        this.w = z4;
        this.g = new le(com.bytedance.sdk.openadsdk.op.ab.xr(), this);
        setContentDescription("NativeVideoAdView");
        ab();
        nw();
        com.bytedance.sdk.openadsdk.op.ab.xr(new ny("ts_video") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.tz == null) {
                    com.bytedance.sdk.component.d.ms.xr unused = NativeVideoTsView.tz = NativeVideoTsView.this.getKvCache();
                }
            }
        });
    }

    public void setEnableBlur(boolean z) {
        this.ny = z;
    }

    public void setMaterialMeta(lm lmVar) {
        this.d = lmVar;
    }

    protected void ab() {
        lm lmVar = this.d;
        if (lmVar == null) {
            return;
        }
        int iNy = f.ny(lmVar);
        int iAb = re.xr().ab(iNy);
        if (iAb == 1) {
            this.f3594ms = u.d(this.ah);
        } else if (iAb == 2) {
            this.f3594ms = u.ka(this.ah) || u.d(this.ah) || u.c(this.ah) || u.ah(re.getContext()) == 1;
        } else if (iAb == 3) {
            this.f3594ms = false;
        } else if (iAb == 4) {
            this.qv = true;
        } else if (iAb == 5) {
            this.f3594ms = u.d(this.ah) || u.c(this.ah);
        }
        if (!this.xr) {
            this.x = re.xr().d(iNy);
        } else {
            this.x = false;
        }
        if ("splash_ad".equals(this.ub)) {
            this.f3594ms = true;
            this.x = true;
        }
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.d(this.f3594ms);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ch();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void ch() {
        d dVar;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar;
        if (this.xr || (dVar = this.y) == null || (ahVar = this.ka) == null) {
            return;
        }
        dVar.ms(ahVar.t(), this.ka.u(), this.ka.u() + this.ka.sl(), this.ka.hi(), this.f3594ms, this.x);
    }

    private View ms(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387854);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.c = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387762);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.ab = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.ka());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387613);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.pc = tTViewStub;
        return frameLayout;
    }

    private void nw() {
        addView(ms(this.ah));
        A_();
    }

    protected void ms(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.ka.ms.ms(this.d) || com.bytedance.sdk.openadsdk.ka.ms.ab(this.d)) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(str).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi<Bitmap> hiVar) {
                Bitmap bitmapAh;
                if (hiVar == null || (bitmapAh = hiVar.ah()) == null) {
                    return;
                }
                final Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(NativeVideoTsView.this.ah, bitmapAh, 25);
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapMs != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapMs));
                        }
                    }
                });
            }
        }, 4);
    }

    public void hi() {
        TTViewStub tTViewStub;
        if (w() || this.ah == null || (tTViewStub = this.pc) == null || tTViewStub.getParent() == null || this.d == null || this.ch != null) {
            return;
        }
        if (this.pc.getParent() != null && (this.pc.getParent() instanceof ViewGroup)) {
            this.ch = (RelativeLayout) this.pc.ms();
        }
        this.hi = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387853);
        this.zb = imageView;
        if (this.u) {
            ul.ms((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(qr.xr(this.d))) {
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.d)).ms(this.hi);
            ms(this.hi, qr.xr(this.d));
        }
        b();
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.pc.getParent() != null && (this.pc.getParent() instanceof ViewGroup)) {
            this.ch = (RelativeLayout) this.pc.ms();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.hi = imageView;
        imageView.setImageDrawable(null);
        this.zb = (ImageView) findViewById(2114387853);
        com.bytedance.sdk.openadsdk.x.xr.ms(str).ms(this.hi);
        ms(this.hi, str);
        ul.ms((View) this.ch, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i, int i2) {
        if (ao()) {
            return;
        }
        lm lmVar = this.d;
        ub ubVarId = lmVar == null ? null : lmVar.id();
        if (ubVarId != null && i2 > 0) {
            if (!ubVarId.x()) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.d, this.ub, 1);
                return;
            }
            this.lm = i;
            this.e = i2;
            if (this.xn == null) {
                this.xn = new ah(ubVarId, this.c, this.d, this.ub, this.lm, this.e);
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(ubVarId.ka()).ah(3).ms(Bitmap.Config.RGB_565).ms(this.xn);
        }
    }

    public static class ah implements ao {
        private int ab;
        private WeakReference<GifView> ah = new WeakReference<>(null);
        private int c;
        private lm d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ub f3602ms;
        private WeakReference<ViewGroup> xr;

        public ah(ub ubVar, ViewGroup viewGroup, lm lmVar, String str, int i, int i2) {
            this.f3602ms = ubVar;
            this.xr = new WeakReference<>(viewGroup);
            this.d = lmVar;
            this.ka = str;
            this.c = i;
            this.ab = i2;
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(final hi hiVar) {
            try {
                ViewGroup viewGroup = this.xr.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ah.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) ah.this.xr.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            ah ahVar = ah.this;
                            ahVar.ms(context, ahVar.f3602ms, hiVar, viewGroup2);
                        } catch (Exception e) {
                            sl.ms(e);
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                ms(1002, "", e);
            }
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(int i, String str, Throwable th) {
            sl.d("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.ah.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.d, this.ka, 2);
        }

        private int ms() {
            if (this.f3602ms.c() > 0.0d) {
                return (int) (((double) this.ab) * this.f3602ms.c());
            }
            return this.ab / 2;
        }

        private void ms(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.f3602ms.ah() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = ul.ah(context, 19.0f);
            }
        }

        private void ms(Object obj, hi hiVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (hiVar.x()) {
                    gifView.ms((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(h.ms((byte[]) obj, 0));
                }
            }
        }

        private void ms(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(Context context, ub ubVar, hi hiVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iAh = ul.ah(context, 12.0f);
            this.c = viewGroup.getWidth() <= 0 ? this.c : viewGroup.getWidth();
            this.ab = viewGroup.getHeight() <= 0 ? this.ab : viewGroup.getHeight();
            int iMs = ms();
            if (ubVar.ms() == 3) {
                if (iMs > ul.ah(context, 88.0f)) {
                    iMs = ul.ah(context, 88.0f);
                }
            } else if (ubVar.ms() == 4 && iMs > ul.ah(context, 178.0f)) {
                iMs = ul.ah(context, 178.0f);
            }
            int i = this.c - iAh;
            int iAb = (int) (((double) iMs) * ubVar.ab());
            if (iAb > i && iAb > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iMs);
            }
            ms(context, layoutParams, iAh);
            gifView.setVisibility(0);
            ms(hiVar.ah(), hiVar, gifView);
            ms(this.ah.get());
            viewGroup.addView(gifView, layoutParams);
            this.ah = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.d, this.ka, 0);
        }
    }

    private void b() {
        if (!(this instanceof NativeDrawVideoTsView) || this.h.get() || ch.ub().e() == null) {
            return;
        }
        this.zb.setImageBitmap(ch.ub().e());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zb.getLayoutParams();
        int iAh = ul.ah(getContext(), this.ao);
        layoutParams.width = iAh;
        layoutParams.height = iAh;
        this.zb.setLayoutParams(layoutParams);
        this.h.set(true);
    }

    protected void A_() {
        this.ka = ms(this.ah, this.ab, this.d, this.ub, !ao(), this.i, this.w);
        i();
        this.l = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.qf = nativeVideoTsView.c.getViewTreeObserver();
                if (NativeVideoTsView.this.qf == null || NativeVideoTsView.this.il == null) {
                    return;
                }
                NativeVideoTsView.this.qf.addOnGlobalLayoutListener(NativeVideoTsView.this.il);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.re();
            }
        };
        this.il = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.c.getWidth();
                int height = NativeVideoTsView.this.c.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) NativeVideoTsView.this.ka).ms(width, height);
                NativeVideoTsView.this.re();
                NativeVideoTsView.this.xr(width, height);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.qf;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.il) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    protected com.bykv.vk.openvk.component.video.api.d.ah ms(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.d(context, viewGroup, lmVar, str, z, z2, z3);
    }

    public void setVideoAdLoadListener(com.bykv.vk.openvk.component.video.api.d.ah.d dVar) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ms(dVar);
        }
    }

    public void setNativeVideoAdListener(com.bykv.vk.openvk.component.video.api.d.ah.ms msVar) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ms(msVar);
        }
    }

    public boolean ms(long j, boolean z, boolean z2) {
        boolean zMs = false;
        this.c.setVisibility(0);
        if (this.ka == null) {
            this.ka = new com.bytedance.sdk.openadsdk.core.video.nativevideo.d(this.ah, this.ab, this.d, this.ub, this.i, this.w);
            i();
        }
        this.cv = j;
        if (ao()) {
            this.ka.ms(false);
            if (qr.u(this.d) != null) {
                com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
                dVarMs.xr(this.d.df());
                dVarMs.xr(this.c.getWidth());
                dVarMs.ah(this.c.getHeight());
                dVarMs.ah(this.d.lx());
                dVarMs.ms(j);
                dVarMs.xr(ub());
                if (z2) {
                    this.ka.xr(dVarMs);
                    return true;
                }
                zMs = ms(dVarMs);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.yu)) && (this.ka instanceof com.bytedance.sdk.openadsdk.core.video.ms.ms)) {
                com.bytedance.sdk.openadsdk.c.ah.h.ms msVar = new com.bytedance.sdk.openadsdk.c.ah.h.ms();
                msVar.ms(this.ka.hi());
                msVar.ah(this.ka.u());
                msVar.xr(this.ka.sl());
                com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
                ((com.bytedance.sdk.openadsdk.core.video.ms.ms) ahVar).xr(ahVar.qv(), msVar);
            }
            return zMs;
        }
        if (sl() || this.ny) {
            ms(this.ah, 25, qr.xr(this.d));
        }
        return true;
    }

    public boolean sl() {
        lm lmVar = this.d;
        return lmVar != null && lmVar.tf() == 4 && this.d.fm() == 1 && !TextUtils.equals("draw_ad", this.ub);
    }

    private void i() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar == null) {
            return;
        }
        ahVar.d(this.f3594ms);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) this.ka).ms((com.bytedance.sdk.openadsdk.core.video.nativevideo.d.ms) this);
        this.ka.ms(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.k) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null && (onAttachStateChangeListener = this.l) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            d();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.k) {
            d();
        }
    }

    public void d() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar == null) {
            A_();
        } else if ((ahVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) && !ao()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) this.ka).eg();
        }
        if (this.ka == null || !this.t.get()) {
            return;
        }
        this.t.set(false);
        ab();
        if (u()) {
            ImageView imageView = this.sl;
            if (imageView != null) {
                ul.ms((View) imageView, 8);
            }
            if (qr.u(this.d) != null) {
                com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
                dVarMs.xr(this.d.df());
                dVarMs.xr(this.c.getWidth());
                dVarMs.ah(this.c.getHeight());
                dVarMs.ah(this.d.lx());
                dVarMs.ms(0L);
                dVarMs.ms(com.bytedance.sdk.openadsdk.op.ch.ms(this.d));
                dVarMs.xr(ub());
                if (w()) {
                    String strAh = com.bytedance.sdk.openadsdk.op.ny.ms(0).ah();
                    if (this.d.gx()) {
                        strAh = com.bytedance.sdk.openadsdk.op.ny.ms();
                    }
                    dVarMs.ms(strAh);
                }
                ms(dVarMs);
                this.ka.ah(false);
                return;
            }
            sl.d("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.ka.t()) {
            d(true);
            return;
        }
        sl.ms("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
        hi();
        ul.ms((View) this.ch, 0);
    }

    private boolean w() {
        return TextUtils.equals(this.ub, "splash_ad") || TextUtils.equals(this.ub, "cache_splash_ad");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.c;
        if (viewGroup != null && (onAttachStateChangeListener = this.l) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        ka();
        this.xn = null;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ka();
    }

    public void ka() {
        this.y = null;
        h();
        zb();
    }

    public void zb() {
        if (!this.t.get()) {
            this.t.set(true);
            if (this.ka != null) {
                le leVar = this.g;
                if (leVar != null) {
                    leVar.removeCallbacksAndMessages(null);
                }
                this.ka.ms(true, 3);
            }
        }
        this.zf.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            zb();
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 1) {
            return;
        }
        yu();
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.op = nativeExpressVideoView;
    }

    private void yu() {
        boolean zOp = op();
        if (this.vm && zOp) {
            com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
            if (ahVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) ahVar).cv();
            }
            this.vm = false;
        } else {
            if (this.ti == null) {
                this.ti = new xr();
            } else {
                x.xr().removeCallbacks(this.ti);
            }
            this.ti.ms(zOp);
            x.xr().post(this.ti);
        }
        this.g.sendEmptyMessageDelayed(1, this.jw);
    }

    private boolean op() {
        View view;
        if (!com.bytedance.sdk.openadsdk.op.ch.ms(this.d)) {
            view = this;
        } else if (this.d.fm() == 2) {
            view = this.op;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return com.bytedance.sdk.openadsdk.core.f.xr(view, 50, 5);
    }

    private boolean le() {
        if (ao()) {
            return false;
        }
        if (tz == null) {
            tz = getKvCache();
        }
        return tz.xr("key_video_is_from_detail_page", false) || tz.xr("key_video_isfromvideodetailpage", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr getKvCache() {
        return g.ms("sp_multi_native_video_data");
    }

    private void cv() {
        if (ao()) {
            return;
        }
        if (tz == null) {
            tz = getKvCache();
        }
        tz.ms("key_video_isfromvideodetailpage", false);
        tz.ms("key_video_is_from_detail_page", false);
    }

    public void ah(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab abVar = this.sa;
        if (abVar != null) {
            abVar.ms(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (this.s || this.b == z) {
            return;
        }
        if (!z) {
            x.xr().removeCallbacks(this.ti);
        }
        this.b = z;
        ah(z);
        if (this.d == null || this.ka == null) {
            return;
        }
        boolean zLe = le();
        cv();
        if (zLe && this.ka.t()) {
            d(true);
            x();
            return;
        }
        if (z && !this.ka.t() && !this.ka.ao()) {
            if (this.ka.h() != null && this.ka.h().u()) {
                if (this.f3594ms) {
                    if ("ALP-AL00".equals(this.p)) {
                        this.ka.x();
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) this.ka).c(zLe);
                    }
                    com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah = this.ul;
                    if (interfaceC0177ah != null) {
                        interfaceC0177ah.q_();
                        return;
                    }
                    return;
                }
                this.b = false;
                return;
            }
            if (this.f3594ms && this.ka.h() == null) {
                if (!this.t.get()) {
                    this.t.set(true);
                }
                this.zf.set(false);
                d();
                return;
            }
            return;
        }
        if (this.ka.h() == null || !this.ka.h().zb()) {
            return;
        }
        this.ka.c();
        com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah2 = this.ul;
        if (interfaceC0177ah2 != null) {
            interfaceC0177ah2.p_();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar2;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar3;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar4;
        super.onWindowFocusChanged(z);
        if (this.k) {
            this.az = z;
            of();
            if (le() && (ahVar4 = this.ka) != null && ahVar4.t()) {
                cv();
                ul.ms((View) this.ch, 8);
                d(true);
                x();
                return;
            }
            ab();
            if (ao() || !u() || (ahVar2 = this.ka) == null || ahVar2.ao()) {
                if (u()) {
                    return;
                }
                if (!z && (ahVar = this.ka) != null && ahVar.h() != null && this.ka.h().zb()) {
                    this.g.removeMessages(1);
                    xr(false);
                    return;
                } else {
                    if (z) {
                        this.g.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            if (this.g != null) {
                if (z && (ahVar3 = this.ka) != null && !ahVar3.t()) {
                    this.g.obtainMessage(1).sendToTarget();
                } else {
                    this.g.removeMessages(1);
                    xr(false);
                }
            }
        }
    }

    private void g() {
        if (this.am == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.am.hashCode()) {
                    this.am.hashCode();
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar2;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar3;
        super.onWindowVisibilityChanged(i);
        if (this.k) {
            g();
            of();
            if (this.v) {
                this.v = i == 0;
            }
            if (le() && (ahVar3 = this.ka) != null && ahVar3.t()) {
                cv();
                ul.ms((View) this.ch, 8);
                d(true);
                x();
                return;
            }
            ab();
            if (ao() || !u() || (ahVar = this.ka) == null || ahVar.ao() || this.d == null) {
                return;
            }
            boolean zXr = com.bytedance.sdk.openadsdk.core.f.xr(this, 20, 5);
            isShown();
            if (this.le && qr.u(this.d) != null && zXr) {
                com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
                dVarMs.xr(this.d.df());
                dVarMs.xr(this.c.getWidth());
                dVarMs.ah(this.c.getHeight());
                dVarMs.ah(this.d.lx());
                dVarMs.ms(this.cv);
                dVarMs.xr(ub());
                ms(dVarMs);
                ul.ms((View) this.ch, 8);
            } else {
                try {
                    sl.d("NativeVideoAdView", "onWindowVisibilityChanged materialMeta.getVideo() is null " + (this.ch == null) + " " + this.v + " " + hashCode());
                    if (this.v && this.ch == null) {
                        hi();
                        ul.ms((View) this.ch, 0);
                    }
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
            if (i != 0 || !this.az || this.g == null || (ahVar2 = this.ka) == null || ahVar2.t()) {
                return;
            }
            this.g.obtainMessage(1).sendToTarget();
        }
    }

    protected boolean ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (this.ka == null) {
            return false;
        }
        this.le = false;
        this.jw = this.f;
        if (this.fm) {
            dVar.xr(this.eg);
        }
        return this.ka.ms(dVar);
    }

    private void of() {
        if (tz == null) {
            tz = getKvCache();
        }
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar == null || ao() || !tz.xr("key_video_is_update_flag", false)) {
            return;
        }
        boolean zXr = tz.xr("key_native_video_complete", false);
        long jXr = tz.xr("key_video_current_play_position", -1L);
        long jXr2 = tz.xr("key_video_total_play_duration", ahVar.u() + ahVar.sl());
        long jXr3 = tz.xr("key_video_duration", ahVar.u());
        ahVar.ah(zXr);
        if (zXr) {
            ahVar.xr(jXr3);
        } else {
            ahVar.xr(jXr);
        }
        ahVar.ah(jXr2);
        ahVar.d(jXr3);
        tz.ms("key_video_is_update_flag", false);
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.d.ah ahVar) {
        this.ka = ahVar;
    }

    public com.bykv.vk.openvk.component.video.api.d.ah getNativeVideoController() {
        return this.ka;
    }

    public boolean u() {
        return this.f3594ms;
    }

    public void setIsAutoPlay(boolean z) {
        lm lmVar;
        if (this.of || (lmVar = this.d) == null) {
            return;
        }
        int iAb = re.xr().ab(f.ny(lmVar));
        if (z && iAb != 4 && (!u.ka(this.ah) ? !(!u.c(this.ah) ? u.d(this.ah) : p() || pc()) : !p())) {
            z = false;
        }
        this.f3594ms = z;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.d(z);
        }
        if (!this.f3594ms) {
            hi();
            RelativeLayout relativeLayout = this.ch;
            if (relativeLayout != null) {
                ul.ms((View) relativeLayout, 0);
                if (qr.u(this.d) != null) {
                    com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.d)).ms(this.hi);
                    ms(this.hi, qr.xr(this.d));
                } else {
                    sl.d("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            ul.ms((View) this.ch, 8);
        }
        this.of = true;
    }

    private boolean p() {
        return 2 == re.xr().ab(f.ny(this.d));
    }

    private boolean pc() {
        return 5 == re.xr().ab(f.ny(this.d));
    }

    public boolean ub() {
        return this.x;
    }

    public void xr(boolean z, boolean z2) {
        this.eg = z;
        this.fm = z2;
    }

    public void setIsQuiet(boolean z) {
        this.x = z;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.xr(z);
        }
    }

    public void setEnableAutoCheck(boolean z) {
        this.k = z;
    }

    public boolean ao() {
        return this.xr;
    }

    public void setVideoAdInteractionListener(com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah) {
        this.ul = interfaceC0177ah;
    }

    public void B_() {
        ul.ms((View) this.ch, 8);
        com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah = this.ul;
        if (interfaceC0177ah != null && !this.qk) {
            this.qk = true;
            interfaceC0177ah.o_();
        }
        ul.ms((View) this.ch, 8);
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab abVar = this.sa;
        if (abVar != null) {
            abVar.ms();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d.ms
    public void ms(int i) {
        ab();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d.ms
    public void ny() {
        this.vm = true;
        if (this.g.hasMessages(1)) {
            return;
        }
        this.g.sendEmptyMessage(1);
    }

    protected void xr(int i) {
        if (u.ah(re.getContext()) == 0) {
            return;
        }
        if (this.ka.h() != null) {
            if (this.ka.h().zb() && i == 2) {
                xr(false);
                le leVar = this.g;
                if (leVar != null) {
                    leVar.removeMessages(1);
                }
                ms(true);
                return;
            }
            if (this.ka.h().u() && i == 3) {
                this.f3594ms = true;
                xr(true);
                ab();
                le leVar2 = this.g;
                if (leVar2 != null) {
                    leVar2.sendEmptyMessageDelayed(1, this.jw);
                }
                ms(false);
                return;
            }
        }
        if (u() || this.zf.get()) {
            return;
        }
        this.zf.set(true);
        if (qr.u(this.d) != null) {
            jw();
            com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
            dVarMs.xr(this.d.df());
            dVarMs.xr(this.c.getWidth());
            dVarMs.ah(this.c.getHeight());
            dVarMs.ah(this.d.lx());
            dVarMs.ms(this.cv);
            dVarMs.xr(ub());
            dVarMs.ms(com.bytedance.sdk.openadsdk.op.ny.ms(this.d.pd()).d());
            ms(dVarMs);
        } else {
            sl.d("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        le leVar3 = this.g;
        if (leVar3 != null) {
            leVar3.sendEmptyMessageDelayed(1, this.jw);
        }
        ms(false);
    }

    protected void xr() {
        if (u.ah(re.getContext()) == 0) {
            return;
        }
        if (this.ka.h() != null) {
            if (this.ka.h().zb()) {
                xr(false);
                le leVar = this.g;
                if (leVar != null) {
                    leVar.removeMessages(1);
                }
                ms(true);
                return;
            }
            if (this.ka.h().u()) {
                this.f3594ms = true;
                xr(true);
                ab();
                le leVar2 = this.g;
                if (leVar2 != null) {
                    leVar2.sendEmptyMessageDelayed(1, this.jw);
                }
                ms(false);
                return;
            }
        }
        if (u() || this.zf.get()) {
            return;
        }
        this.zf.set(true);
        if (qr.u(this.d) != null) {
            jw();
            com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
            dVarMs.xr(this.d.df());
            dVarMs.xr(this.c.getWidth());
            dVarMs.ah(this.c.getHeight());
            dVarMs.ah(this.d.lx());
            dVarMs.ms(this.cv);
            dVarMs.xr(ub());
            ms(dVarMs);
        } else {
            sl.d("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        le leVar3 = this.g;
        if (leVar3 != null) {
            leVar3.sendEmptyMessageDelayed(1, this.jw);
        }
        ms(false);
    }

    protected void ms(boolean z) {
        if (this.sl == null) {
            this.sl = new ImageView(getContext());
            if (ch.ub().e() != null) {
                this.sl.setImageBitmap(ch.ub().e());
            } else {
                com.bytedance.sdk.component.utils.t.ms(re.getContext(), "tt_new_play_video", this.sl);
            }
            this.sl.setScaleType(ImageView.ScaleType.FIT_XY);
            int iAh = ul.ah(getContext(), this.ao);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iAh, iAh);
            layoutParams.gravity = 17;
            this.c.addView(this.sl, layoutParams);
        }
        if (z) {
            this.sl.setVisibility(0);
        } else {
            this.sl.setVisibility(8);
        }
    }

    public void d(boolean z) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ah(z);
            com.bykv.vk.openvk.component.video.api.d.xr xrVarQv = this.ka.qv();
            if (xrVarQv != null) {
                xrVarQv.xr();
                View viewAh = xrVarQv.ah();
                if (viewAh != null) {
                    if (viewAh.getParent() != null) {
                        ((ViewGroup) viewAh.getParent()).removeView(viewAh);
                    }
                    viewAh.setVisibility(0);
                    addView(viewAh);
                    xrVarQv.ms(this.d, new WeakReference<>(this.ah), false);
                }
            }
        }
    }

    public void h() {
        com.bykv.vk.openvk.component.video.api.d.xr xrVarQv;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar == null || (xrVarQv = ahVar.qv()) == null) {
            return;
        }
        xrVarQv.ms();
        View viewAh = xrVarQv.ah();
        if (viewAh != null) {
            viewAh.setVisibility(8);
            if (viewAh.getParent() != null) {
                ((ViewGroup) viewAh.getParent()).removeView(viewAh);
            }
        }
    }

    private void jw() {
        ul.ka(this.sl);
        ul.ka(this.ch);
    }

    public void ms(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) ahVar).ms(i, i2);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.nw = str;
    }

    public void ms(final Context context, final int i, String str) {
        final com.bykv.vk.openvk.component.video.api.d.xr xrVarQv;
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar == null || (xrVarQv = ahVar.qv()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(str).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi<Bitmap> hiVar) {
                Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(context, hiVar.ah(), i);
                if (bitmapMs == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapMs);
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xrVarQv != null) {
                            xrVarQv.ms(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }

    public void qv() {
        if (this.ka != null) {
            jw();
            this.ka.xr();
        }
    }

    public void setComplete(boolean z) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ah(z);
        }
    }

    public void y() {
        le leVar = this.g;
        if (leVar != null) {
            leVar.removeCallbacksAndMessages(null);
        }
    }

    private class xr implements Runnable {
        private volatile boolean xr;

        private xr() {
        }

        public Runnable ms(boolean z) {
            this.xr = z;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.xr(this.xr);
        }
    }
}
