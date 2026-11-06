package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.widget.u;
import com.bytedance.sdk.openadsdk.core.widget.ub;
import com.bytedance.sdk.openadsdk.core.xr.ms.ms.x;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bykv.vk.openvk.component.video.api.d.xr<lm>, com.bykv.vk.openvk.component.video.api.renderview.ms, le.ms, u.ms, ub.xr {
    protected TTViewStub ab;
    ImageView ah;
    private TextView am;
    protected TTViewStub ao;
    private TextView az;
    volatile boolean b;
    ImageView c;
    View ch;
    boolean cv;
    View d;
    private RelativeLayout e;
    private TextView eg;
    boolean f;
    private RelativeLayout fm;
    com.bytedance.sdk.openadsdk.core.hi.xr.ah g;
    int h;
    RoundImageView hi;
    EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> i;
    private View il;
    com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms jw;
    private RoundImageView k;
    View ka;
    private RoundImageView l;
    xr le;
    private NativeVideoTsView.ms lm;
    private TextView m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    View f3616ms;
    boolean nw;
    ImageView ny;
    com.bykv.vk.openvk.component.video.api.d.ah of;
    ub op;
    com.bytedance.sdk.openadsdk.core.xr.ms p;
    com.bytedance.sdk.openadsdk.core.xr.ms pc;
    private RelativeLayout qf;
    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms qk;
    int qv;
    int re;
    private final int rt;
    private boolean s;
    private TextView sa;
    private AtomicBoolean sk;
    TextView sl;
    int t;
    private int ti;
    private String tz;
    TextView u;
    TTProgressBar ub;
    private View ul;
    private com.bytedance.sdk.openadsdk.core.xr.ms v;
    private ab vm;
    private final int vy;
    lm w;
    View x;
    private TTViewStub xn;
    com.bykv.vk.openvk.component.video.api.renderview.xr xr;
    int y;
    Context yu;
    TextView zb;
    private final int zf;

    public void ah(boolean z) {
    }

    public boolean ah(int i) {
        return false;
    }

    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ub.xr
    public boolean ch() {
        return false;
    }

    public void ka() {
    }

    public void ms(long j) {
    }

    public void ms(long j, long j2) {
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.ms
    public void ms(View view, boolean z) {
    }

    public void ms(ViewGroup viewGroup) {
    }

    public void ms(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.ms
    public void u() {
    }

    public void xr(ViewGroup viewGroup) {
    }

    public void xr(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public /* bridge */ /* synthetic */ void ms(lm lmVar, WeakReference weakReference, boolean z) {
        ms2(lmVar, (WeakReference<Context>) weakReference, z);
    }

    public c(Context context, View view, boolean z, EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSet, lm lmVar, com.bykv.vk.openvk.component.video.api.d.ah ahVar, boolean z2, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.nw = true;
        this.cv = true;
        this.f = true;
        this.zf = 1;
        this.rt = 2;
        this.vy = 3;
        this.sk = new AtomicBoolean(false);
        if (this instanceof ka) {
            return;
        }
        this.yu = re.getContext().getApplicationContext();
        d(z2);
        this.f3616ms = view;
        this.nw = z;
        this.i = enumSet == null ? EnumSet.noneOf(com.bykv.vk.openvk.component.video.api.d.xr.ms.class) : enumSet;
        this.of = ahVar;
        this.v = msVar;
        this.w = lmVar;
        cv();
        d(8);
        ms(context, this.f3616ms, lmVar);
        d();
        ao();
    }

    public c(Context context, View view, boolean z, EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSet, lm lmVar, com.bykv.vk.openvk.component.video.api.d.ah ahVar, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this(context, view, z, enumSet, lmVar, ahVar, true, msVar);
    }

    private void cv() {
        this.ti = 1;
        String strXr = f.xr(this.w);
        String str = "embeded_ad_landingpage";
        if (strXr == null) {
            strXr = this.cv ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.ti = f.xr(strXr);
        if (!this.cv && strXr.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.cv || !strXr.equals("embeded_ad")) {
            str = strXr;
        }
        this.tz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.bytedance.sdk.openadsdk.op.ab.ms(new ny("native_video_layout_download_listener") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.g == null) {
                    c cVar = c.this;
                    cVar.g = com.bytedance.sdk.openadsdk.core.hi.ka.ms(cVar.yu, c.this.w, c.this.tz, false);
                }
                if (c.this.p != null) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) c.this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(c.this.g);
                }
                if (c.this.pc != null) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) c.this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(c.this.g);
                }
                if (c.this.qk != null) {
                    c.this.g.ms(c.this.qk);
                }
                if (c.this.g != null) {
                    c.this.g.ka(false);
                }
            }
        });
    }

    void ao() {
        View view;
        cv();
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.v;
            if (msVar != null) {
                this.p = msVar;
            } else {
                this.p = new com.bytedance.sdk.openadsdk.core.xr.ms(this.yu, this.w, this.tz, this.ti);
            }
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.5
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
                public void ms(View view2, int i) {
                    if (c.this.lm != null) {
                        c.this.lm.ms(view2, i);
                    }
                }
            });
            if (this.v == null && (view = this.f3616ms) != null) {
                view.setOnClickListener(this.p);
                this.f3616ms.setOnTouchListener(this.p);
            }
            if (ul.d(this.fm)) {
                this.fm.setOnClickListener(this.p);
                this.fm.setOnTouchListener(this.p);
                return;
            }
            return;
        }
        p();
        com.bytedance.sdk.openadsdk.core.xr.ms msVar2 = new com.bytedance.sdk.openadsdk.core.xr.ms(this.yu, this.w, this.tz, this.ti);
        this.p = msVar2;
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).xr(true);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.6
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
            public void ms(View view2, int i) {
                if (c.this.lm != null) {
                    c.this.lm.ms(view2, i);
                }
            }
        });
        xr(this.p);
        ((x) this.p.ms(x.class)).ka(true);
        if (this.cv) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(false);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
        }
        if (of()) {
            com.bytedance.sdk.openadsdk.core.xr.ms msVar3 = new com.bytedance.sdk.openadsdk.core.xr.ms(this.yu, this.w, this.tz, this.ti);
            this.pc = msVar3;
            xr(msVar3);
            this.vm = new ab(this);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab.class)).ms(this.vm);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).xr(true);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.7
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
                public void ms(View view2, int i) {
                    if (c.this.lm != null) {
                        c.this.lm.ms(view2, i);
                    }
                }
            });
            ((x) this.pc.ms(x.class)).ka(true);
            if (this.cv) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(false);
            }
            ms(this.pc);
            View view2 = this.f3616ms;
            if (view2 != null) {
                view2.setOnClickListener(this.pc);
                this.f3616ms.setOnTouchListener(this.pc);
            }
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        lm lmVar;
        if (msVar == null || (lmVar = this.w) == null || !com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
    }

    private boolean of() {
        lm lmVar = this.w;
        return lmVar != null && lmVar.si() == null && this.w.pl() == null && this.w.ti() == 1 && lm.xr(this.w);
    }

    public void ms(NativeVideoTsView.ms msVar) {
        this.lm = msVar;
    }

    public void ms(zb zbVar) {
        ms(zbVar, this.p);
        ms(zbVar, this.pc);
    }

    private void xr(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        lm lmVar;
        if (msVar == null || (lmVar = this.w) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ao.xr.xr.u uVarMs = com.bytedance.sdk.openadsdk.core.video.d.ms.ms(Integer.valueOf(lmVar.hashCode()));
        if (uVarMs instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.re) {
            ((com.bytedance.sdk.openadsdk.core.nativeexpress.re) uVarMs).ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        }
    }

    private void ms(zb zbVar, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        b bVarI;
        if (msVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(zbVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class);
        if ((zbVar instanceof com.bytedance.sdk.openadsdk.core.b.d) && (bVarI = ((com.bytedance.sdk.openadsdk.core.b.d) zbVar).i()) != null) {
            bVarI.ms(ahVar);
        }
    }

    private void p() {
        if (this.yu == null || this.f3616ms == null) {
            return;
        }
        View view = new View(this.yu) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.8
            private final AtomicBoolean xr = new AtomicBoolean(true);

            @Override // android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (c.this.g == null || !z) {
                    return;
                }
                c.this.g.x();
            }

            @Override // android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                c.this.sk.set(false);
                ms();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                ms();
            }

            private void ms() {
                if (this.xr.getAndSet(false) && (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(c.this.w) || c.this.w.jr() == 4)) {
                    c.this.g();
                }
                if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
                    i.ms(c.this.w.xg(), c.this.vm, ab.class);
                }
            }

            private void xr() {
                if (this.xr.getAndSet(true) || c.this.g == null) {
                    return;
                }
                c.this.g.ny();
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                c.this.sk.set(true);
                xr();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                xr();
            }
        };
        View view2 = this.f3616ms;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.xr h() {
        return this.xr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void ms(Context context, View view, lm lmVar) {
        View sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.bytedance.sdk.openadsdk.ka.ms.xr(lmVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.yu);
        } else if (com.bytedance.sdk.openadsdk.ka.ms.ah(lmVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.yu);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (f()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        ul.ms(sSRenderTextureView, 8);
        this.xr = (com.bykv.vk.openvk.component.video.api.renderview.xr) sSRenderTextureView;
        this.ah = (ImageView) view.findViewById(2114387632);
        this.ub = (TTProgressBar) view.findViewById(2114387659);
        this.d = view.findViewById(2114387906);
        this.ka = view.findViewById(2114387637);
        this.c = (ImageView) view.findViewById(2114387657);
        this.ab = (TTViewStub) view.findViewById(2114387750);
        this.xn = (TTViewStub) view.findViewById(2114387672);
        this.ao = (TTViewStub) view.findViewById(2114387834);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            xr(context, view);
        }
        System.currentTimeMillis();
    }

    private void xr(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387894);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387694);
        if (pc()) {
            ul.ms((View) relativeLayout, 0);
            ul.ms((View) relativeLayout2, 8);
            this.e = relativeLayout;
        } else {
            ul.ms((View) relativeLayout2, 0);
            ul.ms((View) relativeLayout, 8);
            this.e = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.e;
        if (relativeLayout3 == null) {
            return;
        }
        this.k = (RoundImageView) relativeLayout3.findViewById(2114387837);
        this.eg = (TextView) this.e.findViewById(2114387748);
        this.fm = (RelativeLayout) this.e.findViewById(2114387699);
    }

    private boolean pc() {
        if (this.w == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.tz) || "rewarded_video".equals(this.tz)) {
            int iOd = this.w.od();
            float fLd = this.w.ld();
            if (iOd == 1 && fLd == 100.0f) {
                return true;
            }
        }
        return false;
    }

    protected void ms(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.xn) == null || tTViewStub.getParent() == null || this.il != null) {
            return;
        }
        this.il = this.xn.ms();
        this.qf = (RelativeLayout) view.findViewById(2114387953);
        this.l = (RoundImageView) view.findViewById(2114387958);
        this.am = (TextView) view.findViewById(2114387932);
        this.sa = (TextView) view.findViewById(2114387883);
    }

    protected void qv() {
        if (this.w == null) {
            return;
        }
        if (this.s) {
            ul.ms((View) this.sa, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(this.w);
            String strAh = com.bytedance.sdk.openadsdk.core.nw.ul.ah(this.w);
            String strX = com.bytedance.sdk.openadsdk.core.nw.ul.x(this.w);
            ul.ms(this.il, 0);
            ul.ms((View) this.qf, 0);
            if (!TextUtils.isEmpty(strNy)) {
                com.bytedance.sdk.openadsdk.x.xr.ms(strNy).ms(this.l);
            }
            if (!TextUtils.isEmpty(strAh)) {
                ul.ms(this.am, strAh);
            }
            if (this.qf == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(strX).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.9
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(c.this.yu, hiVar.ah(), 25);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(c.this.qf.getResources(), bitmapMs);
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.qf != null) {
                                c.this.qf.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void jw() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        lm lmVar = this.w;
        if (lmVar != null && com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(this.w);
            if (!TextUtils.isEmpty(strNy)) {
                com.bytedance.sdk.openadsdk.x.xr.ms(strNy).ms(this.k);
            }
            String strAh = com.bytedance.sdk.openadsdk.core.nw.ul.ah(this.w);
            String strX = com.bytedance.sdk.openadsdk.core.nw.ul.x(this.w);
            if (!TextUtils.isEmpty(strAh)) {
                ul.ms(this.eg, strAh);
            }
            if (this.e == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(strX).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.10
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(c.this.yu, hiVar.ah(), 25);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(c.this.e.getResources(), bitmapMs);
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.e != null) {
                                c.this.e.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.zb.ah.d(c.this.w, c.this.tz, System.currentTimeMillis() - jCurrentTimeMillis);
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(c.this.w, c.this.tz, i, str);
                }
            }, 4);
        }
    }

    void ms(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.ab) == null || tTViewStub.getParent() == null || this.x != null) {
            return;
        }
        this.x = this.ab.ms();
        this.ab.setVisibility(0);
        this.ny = (ImageView) view.findViewById(2114387810);
        this.ch = view.findViewById(2114387961);
        this.hi = (RoundImageView) view.findViewById(2114387670);
        this.sl = (TextView) view.findViewById(2114387957);
        this.zb = (TextView) view.findViewById(2114387770);
        this.u = (TextView) view.findViewById(2114387692);
    }

    private void xr(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.ao) == null || tTViewStub.getParent() == null || this.ul != null) {
            return;
        }
        this.ao.ms();
        this.ul = view.findViewById(2114387680);
        this.az = (TextView) view.findViewById(2114387874);
        this.m = (TextView) view.findViewById(2114387848);
    }

    void y() {
        if (this.le == null || this.op != null) {
            return;
        }
        System.currentTimeMillis();
        ub ubVar = new ub();
        this.op = ubVar;
        ubVar.ms(this.yu, this.f3616ms);
        this.op.ms(this.le, this);
        System.currentTimeMillis();
    }

    public boolean ms(int i, com.bykv.vk.openvk.component.video.api.ah.ah ahVar, boolean z) {
        ub ubVar = this.op;
        return ubVar == null || ubVar.ms(i, ahVar, z);
    }

    public void t() {
        ub ubVar = this.op;
        if (ubVar != null) {
            ubVar.ms(false);
        }
    }

    public void ms(com.bykv.vk.openvk.component.video.api.d.ms msVar) {
        if (msVar instanceof xr) {
            this.le = (xr) msVar;
            y();
        }
    }

    boolean nw() {
        if (this.le != null) {
            return true;
        }
        sl.d("NewLiveViewLayout", "callback is null");
        return false;
    }

    void d() {
        this.xr.ms(this);
        ImageView imageView = this.ah;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.nw()) {
                        if (c.this.u == null || c.this.u.getVisibility() != 0) {
                            c.this.le.ms(c.this, view);
                        }
                    }
                }
            });
        }
    }

    public void ka(int i) {
        ul.ms(this.f3616ms, 0);
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.xr;
        if (xrVar != null) {
            xrVar.setVisibility(i);
        }
    }

    public void d(boolean z) {
        this.cv = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.p;
            if (msVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVar2 = this.pc;
            if (msVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.xr.ms msVar3 = this.p;
        if (msVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar3.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.p.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
        }
        com.bytedance.sdk.openadsdk.core.xr.ms msVar4 = this.pc;
        if (msVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar4.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.pc.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
        }
    }

    public void ms(int i, int i2) {
        if (i == -1) {
            i = ul.d(this.yu);
        }
        if (i <= 0) {
            return;
        }
        this.h = i;
        if (hi() || ch() || this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.fixedSize)) {
            this.qv = i2;
        } else {
            this.qv = ab(i);
        }
        xr(this.h, this.qv);
    }

    public void xr(boolean z, boolean z2) {
        ImageView imageView = this.ah;
        if (imageView != null) {
            if (z) {
                t.ms(this.yu, "tt_play_movebar_textpage", imageView);
            } else {
                t.ms(this.yu, "tt_stop_movebar_textpage", imageView);
            }
        }
    }

    public void xr(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f3616ms;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.f3616ms.setLayoutParams(layoutParams);
    }

    private int ab(int i) {
        if (this.y <= 0 || this.t <= 0) {
            return 0;
        }
        int iAh = ul.ah(this.yu, 228.0f);
        int iAh2 = ul.ah(this.yu, 160.0f);
        int i2 = (int) (this.t * ((i * 1.0f) / this.y));
        if (i2 > iAh) {
            return iAh;
        }
        return i2 < iAh2 ? iAh2 : i2;
    }

    public void ah(int i, int i2) {
        this.y = i;
        this.t = i2;
    }

    public void xr(int i) {
        sl.ms("Progress", "setSeekProgress-percent=".concat(String.valueOf(i)));
        ul.ms((View) this.ub, 0);
        TTProgressBar tTProgressBar = this.ub;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    public void ah(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f3616ms.getParent() == null) {
            viewGroup.addView(this.f3616ms);
        }
        d(0);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public View ah() {
        return this.f3616ms;
    }

    public void ab() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            b();
        } else {
            ul();
        }
        ImageView imageView = this.ah;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        ul.ms((View) this.ah, 8);
    }

    private boolean f() {
        return TextUtils.equals(this.tz, "splash_ad") || TextUtils.equals(this.tz, "cache_splash_ad");
    }

    private void ul() {
        if (f()) {
            ul.ms((View) this.ah, 8);
            if (!re.xr().qo()) {
                ul.ms(this.d, 8);
                ul.ms(this.ka, 8);
                ul.ms((View) this.c, 8);
                return;
            }
        }
        ul.ms(this.d, 0);
        ul.ms((View) this.e, 8);
        ul.c(this.d);
        if (f() && re.xr().qo()) {
            ul.ms(this.ka, 8);
        } else {
            ul.c(this.ka);
        }
        if (this.c == null || TextUtils.isEmpty(qr.xr(this.w))) {
            return;
        }
        ul.c(this.c);
        com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.c);
        ms(this.c, qr.xr(this.w));
    }

    protected void b() {
        ul.ms(this.d, 8);
        ul.ms((View) this.e, 0);
        jw();
    }

    public void re() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            b();
        } else {
            ul.ms((View) this.e, 8);
            ul.c(this.d);
            ul.c(this.ka);
        }
        ImageView imageView = this.ah;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        ul.ms((View) this.ah, 8);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public void ms() {
        ms(false, this.nw);
        w();
    }

    public void i() {
        ul.ms(this.f3616ms, 0);
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.xr;
        if (xrVar != null) {
            View view = xrVar.getView();
            ul.ms(view, 8);
            ul.ms(view, 0);
        }
    }

    void w() {
        ul.ms(this.x, 8);
        ul.ms((View) this.ny, 8);
        ul.ms(this.ch, 8);
        ul.ms((View) this.hi, 8);
        ul.ms((View) this.sl, 8);
        ul.ms((View) this.zb, 8);
        ul.ms((View) this.u, 8);
        ul.ms(this.il, 8);
        ul.ms((View) this.qf, 8);
    }

    private void x(int i) {
        ul.ms(this.ch, i);
        ul.ms(this.ul, i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public void ms(boolean z) {
        this.f = z;
    }

    public void c(int i) {
        lm lmVar;
        if (this.hi == null || (lmVar = this.w) == null || lmVar.qd() == null || this.w.qd().ms() == null) {
            return;
        }
        if (i == 1) {
            int iAh = ul.ah(this.yu, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iAh, iAh);
            layoutParams.addRule(14);
            this.hi.setLayoutParams(layoutParams);
            this.sl.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ul.ah(this.yu, 16.0f);
            layoutParams2.topMargin = ul.ah(this.yu, 8.0f);
            layoutParams2.leftMargin = ul.ah(this.yu, 16.0f);
            layoutParams2.rightMargin = ul.ah(this.yu, 16.0f);
            layoutParams2.addRule(3, this.hi.getId());
            layoutParams2.addRule(14);
            this.zb.setLayoutParams(layoutParams2);
            this.zb.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, ul.ah(this.yu, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.zb.getId());
            layoutParams3.leftMargin = ul.ah(this.yu, 20.0f);
            layoutParams3.rightMargin = ul.ah(this.yu, 20.0f);
            this.u.setPadding(ul.ah(this.yu, 36.0f), ul.ah(this.yu, 7.0f), ul.ah(this.yu, 36.0f), ul.ah(this.yu, 8.0f));
            this.u.setLayoutParams(layoutParams3);
            this.u.setEllipsize(TextUtils.TruncateAt.END);
            this.u.setSingleLine(true);
            this.u.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iAh2 = ul.ah(this.yu, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iAh2, iAh2);
            layoutParams4.addRule(14);
            this.hi.setLayoutParams(layoutParams4);
            this.sl.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = ul.ah(this.yu, 8.0f);
            layoutParams5.topMargin = ul.ah(this.yu, 8.0f);
            layoutParams5.addRule(3, this.hi.getId());
            layoutParams5.addRule(14);
            this.zb.setLayoutParams(layoutParams5);
            this.zb.setTextSize(10.0f);
            ul.ms((View) this.u, 8);
            return;
        }
        int iAh3 = ul.ah(this.yu, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iAh3, iAh3);
        layoutParams6.addRule(14);
        this.hi.setLayoutParams(layoutParams6);
        this.sl.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = ul.ah(this.yu, 8.0f);
        layoutParams7.topMargin = ul.ah(this.yu, 8.0f);
        layoutParams7.addRule(3, this.hi.getId());
        layoutParams7.addRule(14);
        this.zb.setLayoutParams(layoutParams7);
        this.zb.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, ul.ah(this.yu, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.zb.getId());
        int iAh4 = ul.ah(this.yu, 20.0f);
        int iAh5 = ul.ah(this.yu, 25.0f);
        int iAh6 = ul.ah(this.yu, 6.0f);
        TextPaint paint = this.u.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.u.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.u.setTextSize(13.0f);
        if (this.u.getWidth() > (iAh5 * 2) + rect.width() && this.u.getHeight() > (iAh6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iAh4;
            layoutParams8.rightMargin = iAh4;
            this.u.setPadding(iAh5, ul.ah(this.yu, 5.0f), iAh5, iAh6);
        }
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setSingleLine(true);
        this.u.setLayoutParams(layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.ch;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.f3616ms;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.f3616ms.getMeasuredHeight();
            int iAh = ul.ah(this.yu, 200.0f);
            int iAh2 = ul.ah(this.yu, 331.0f);
            int iAh3 = ul.ah(this.yu, 110.0f);
            int iAh4 = ul.ah(this.yu, 100.0f);
            if (measuredWidth >= iAh && measuredHeight >= iAh2) {
                c(1);
                return;
            }
            if (measuredWidth > iAh3 && measuredHeight > iAh4) {
                c(3);
                return;
            }
            c(2);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    protected void ms(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.ka.ms.ms(this.w) || com.bytedance.sdk.openadsdk.ka.ms.ab(this.w)) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(str).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.12
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
                final Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(c.this.yu, bitmapAh, 25);
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.12.1
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

    /* JADX INFO: renamed from: ms, reason: avoid collision after fix types in other method */
    public void ms2(lm lmVar, WeakReference<Context> weakReference, boolean z) {
        String strFs;
        lm lmVar2;
        if (lmVar == null || f()) {
            return;
        }
        ms(false, this.nw);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            ms(re.getContext(), this.f3616ms);
            qv();
            return;
        }
        ms(this.f3616ms, re.getContext());
        View view = this.x;
        if (view != null) {
            ul.ms(view, 0);
        }
        ImageView imageView = this.ny;
        if (imageView != null) {
            ul.ms((View) imageView, 0);
        }
        if (f.ah(this.w)) {
            xr(this.f3616ms, re.getContext());
            ul.ms(this.ch, 8);
            ul.ms((View) this.ny, 0);
            ul.ms(this.ul, 0);
            ul.ms((View) this.az, 0);
            ul.ms((View) this.m, 0);
            if (this.m != null && com.bytedance.sdk.component.utils.u.ah(re.getContext()) == 0) {
                ul.ms((View) this.m, 8);
            }
            View view2 = this.x;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (c.this.of != null) {
                            ((com.bykv.vk.openvk.component.video.api.d.ms) c.this.of).ms();
                            if (c.this.jw != null) {
                                c.this.jw.ms();
                            }
                        }
                    }
                });
            }
            if (this.ny != null && !TextUtils.isEmpty(qr.xr(this.w))) {
                if (com.bytedance.sdk.openadsdk.ka.ms.xr(lmVar)) {
                    com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.ny);
                    ms(this.ny, qr.xr(this.w));
                } else {
                    com.bykv.vk.openvk.component.video.ms.ka.xr.ms(2147483647L, qr.ms(this.w), new com.bykv.vk.openvk.component.video.ms.ka.xr.InterfaceC0181xr() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.3
                        @Override // com.bykv.vk.openvk.component.video.ms.ka.xr.InterfaceC0181xr
                        public void ms(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.ny.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    float height = (bitmap.getHeight() * ul.d(re.getContext())) / bitmap.getWidth();
                                    layoutParams.width = ul.d(re.getContext());
                                    layoutParams.height = (int) height;
                                    layoutParams.addRule(13);
                                    c.this.ny.setLayoutParams(layoutParams);
                                }
                                c.this.ny.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(c.this.w)).ms(c.this.ny);
                        }
                    });
                }
            }
        } else {
            ul.ms(this.ch, 0);
            if (this.ny != null && !TextUtils.isEmpty(qr.xr(this.w))) {
                com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.ny);
                ms(this.ny, qr.xr(this.w));
            }
            if (m()) {
                this.ch.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.az();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(lmVar.nq())) {
            strFs = lmVar.nq();
        } else if (!TextUtils.isEmpty(lmVar.eh())) {
            strFs = lmVar.eh();
        } else {
            strFs = !TextUtils.isEmpty(lmVar.fs()) ? lmVar.fs() : "";
        }
        if (this.hi != null && (lmVar2 = this.w) != null && lmVar2.qd() != null && this.w.qd().ms() != null) {
            ul.ms((View) this.hi, 0);
            ul.ms((View) this.sl, 4);
            com.bytedance.sdk.openadsdk.x.xr.ms(this.w.qd()).ms(this.hi);
            if (of()) {
                this.hi.setOnClickListener(this.pc);
                this.hi.setOnTouchListener(this.pc);
            } else {
                this.hi.setOnClickListener(this.p);
                this.hi.setOnTouchListener(this.p);
            }
        } else if (!TextUtils.isEmpty(strFs)) {
            ul.ms((View) this.hi, 4);
            ul.ms((View) this.sl, 0);
            TextView textView = this.sl;
            if (textView != null) {
                textView.setText(strFs.substring(0, 1));
                if (of()) {
                    this.sl.setOnClickListener(this.pc);
                    this.sl.setOnTouchListener(this.pc);
                } else {
                    this.sl.setOnClickListener(this.p);
                    this.sl.setOnTouchListener(this.p);
                }
            }
        }
        if (this.zb != null && !TextUtils.isEmpty(strFs)) {
            this.zb.setText(strFs);
        }
        ul.ms((View) this.zb, 0);
        ul.ms((View) this.u, 0);
        String strBn = lmVar.bn();
        if (TextUtils.isEmpty(strBn)) {
            int iJr = lmVar.jr();
            if (iJr != 4) {
                strBn = iJr != 5 ? "查看详情" : "立即拨打";
            } else {
                strBn = "立即下载";
            }
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            textView2.setText(strBn);
            this.u.setOnClickListener(this.p);
            this.u.setOnTouchListener(this.p);
        }
        TextView textView3 = this.az;
        if (textView3 != null) {
            textView3.setText(strBn);
            this.az.setOnClickListener(this.p);
            this.az.setOnTouchListener(this.p);
        }
        if (this.f) {
            return;
        }
        x(4);
    }

    private boolean m() {
        lm lmVar;
        return this.cv && this.ch != null && (lmVar = this.w) != null && lmVar.lm() == 1;
    }

    public void yu() {
        lm lmVar = this.w;
        if (lmVar == null) {
            return;
        }
        if (this.w.qw() != 5 ? lmVar.qw() == 1 && qf.h(this.w) : true) {
            ms(false, this.nw);
            ms(this.f3616ms, re.getContext());
            if (this.ny == null || TextUtils.isEmpty(qr.xr(this.w))) {
                return;
            }
            ul.ms(this.x, 0);
            ul.ms((View) this.ny, 0);
            ul.ms(this.ch, 8);
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.ny);
            ms(this.ny, qr.xr(this.w));
        }
    }

    public void op() {
        if (f()) {
            ul.ms((View) this.ah, 8);
            ul.ka(this.d);
            ul.ka(this.ka);
            ImageView imageView = this.c;
            if (imageView != null) {
                ul.ka(imageView);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public void xr() {
        if (f()) {
            ul.ms(this.d, 8);
            ul.ms(this.ka, 8);
            ul.ms((View) this.c, 8);
            ul.ms((View) this.ah, 8);
            return;
        }
        ul.ms((View) this.e, 8);
        ul.ka(this.d);
        ul.ka(this.ka);
        ImageView imageView = this.c;
        if (imageView != null) {
            ul.ka(imageView);
        }
    }

    public void x() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            ul.ms((View) this.e, 8);
        } else {
            ul.ka(this.d);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.ms
    public void ms(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.xr.getHolder()) {
            return;
        }
        this.b = true;
        if (nw()) {
            this.le.ms(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.ms
    public void ms(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.xr.getHolder()) {
            return;
        }
        nw();
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.ms
    public void xr(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.xr.getHolder()) {
            return;
        }
        this.b = false;
        if (nw()) {
            this.le.xr(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.ms
    public void ms(SurfaceTexture surfaceTexture, int i, int i2) {
        this.b = true;
        if (nw()) {
            this.le.ms(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.ms
    public boolean ms(SurfaceTexture surfaceTexture) {
        this.b = false;
        if (!nw()) {
            return true;
        }
        this.le.xr(this, surfaceTexture);
        return true;
    }

    public void ny() {
        TTProgressBar tTProgressBar = this.ub;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.ub.setSecondaryProgress(0);
        }
        d(8);
        if (le()) {
            this.xr.setVisibility(8);
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.c.setBackground(null);
        }
        ImageView imageView2 = this.ny;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.ny.setBackground(null);
        }
        d(8);
        ul.ms(this.x, 8);
        ul.ms((View) this.ny, 8);
        ul.ms(this.ch, 8);
        ul.ms((View) this.hi, 8);
        ul.ms((View) this.sl, 8);
        ul.ms((View) this.zb, 8);
        ul.ms(this.il, 8);
        ul.ms((View) this.qf, 8);
        ub ubVar = this.op;
        if (ubVar != null) {
            ubVar.ms(true);
        }
    }

    public boolean hi() {
        return this.nw;
    }

    public void ms(boolean z, boolean z2, boolean z3) {
        ul.ms((View) this.ub, 0);
        ul.ms((View) this.ah, (z && (ul.d(this.d) && ul.d(this.e))) ? 0 : 8);
    }

    public void ms(boolean z, boolean z2) {
        ul.ms((View) this.ub, z ? 0 : 8);
        ul.ms((View) this.ah, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ub.xr
    public void sl() {
        ms(true, false);
    }

    public boolean zb() {
        return this.b;
    }

    public void d(int i) {
        this.re = i;
        ul.ms(this.f3616ms, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.ms
    public boolean ub() {
        ub ubVar = this.op;
        return ubVar != null && ubVar.ms();
    }

    boolean le() {
        return !this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.alwayShowMediaView) || this.nw;
    }

    public void ms(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar) {
        this.jw = msVar;
        com.bytedance.sdk.openadsdk.core.xr.ms msVar2 = this.p;
        if (msVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(msVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public void ms(Drawable drawable) {
        View view = this.f3616ms;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.xr
    public void ms(int i) {
        ul.ms((View) this.fm, i);
    }

    public void ka(boolean z) {
        this.s = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms interfaceC0296ms) {
        this.qk = interfaceC0296ms;
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.g;
        if (ahVar != null) {
            ahVar.ms(interfaceC0296ms);
        }
    }
}
