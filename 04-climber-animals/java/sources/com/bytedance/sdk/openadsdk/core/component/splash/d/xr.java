package com.bytedance.sdk.openadsdk.core.component.splash.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ka;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yu;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.vm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms implements ah.InterfaceC0177ah, ah.d, ms.xr, com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms {
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr e;
    private int eg;
    private final AtomicBoolean fm = new AtomicBoolean(false);
    private d il;
    private String k;
    private Context lm;
    private NativeExpressView m;
    private WeakReference<ViewGroup> xn;

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void D_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public boolean m_() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void ms(long j, long j2) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void q_() {
    }

    public xr(Context context, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new AnonymousClass1(context, xrVar, str, i, ahVar, dVar, msVar));
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.d.xr$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.ms.ms ab;
        final /* synthetic */ String ah;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d c;
        final /* synthetic */ int d;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ Context f2414ms;
        final /* synthetic */ com.bytedance.sdk.openadsdk.ao.xr.ah.xr xr;

        AnonymousClass1(Context context, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d dVar, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
            this.f2414ms = context;
            this.xr = xrVar;
            this.ah = str;
            this.d = i;
            this.ka = ahVar;
            this.c = dVar;
            this.ab = msVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            try {
                xr.this.lm = this.f2414ms;
                xr.this.e = this.xr;
                xr.this.k = this.ah;
                xr.this.eg = this.d;
                xr xrVar = xr.this;
                xrVar.ms((ms.xr) xrVar);
                xr.this.ms(this.ka, this.c, this.ab);
                xr.this.il = new d(xr.this.xr, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public int ah() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void c() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void d() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public long getActualPlayDuration() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void ka() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public long ms() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void ms(float f) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void ms(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void ms(int i, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void setPauseFromExpressView(boolean z) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public int xr() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
                    public void xr(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
                    public void ms(View view) {
                        if (xr.this.x != null) {
                            xr.this.x.xr(xr.this);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
                    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                        if (xr.this.m != null) {
                            xr.this.m.ms(view, i, ahVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
                    public void xr(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                        if (xr.this.m != null) {
                            xr.this.m.ms(view, i, ahVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
                    public void ms(ViewGroup viewGroup) {
                        if (op.c(xr.this.xr).c()) {
                            TextView textView = new TextView(xr.this.lm);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            textView.setTextSize(1, 20.0f);
                            int iAh = ul.ah(re.getContext(), 80.0f);
                            textView.setText("跳转至详情页或第三方应用");
                            layoutParams.bottomMargin = iAh;
                            int i = iAh / 3;
                            layoutParams.leftMargin = i;
                            layoutParams.rightMargin = i;
                            layoutParams.gravity = 81;
                            textView.setTextColor(-1);
                            int i2 = iAh / 6;
                            textView.setPadding(0, i2, 0, i2);
                            textView.setGravity(17);
                            textView.setLayoutParams(layoutParams);
                            textView.setClickable(true);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.1.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (xr.this.m != null) {
                                        xr.this.m.ms(view, 2, new i.ms().ms());
                                    }
                                }
                            });
                            textView.bringToFront();
                            viewGroup.addView(textView);
                        }
                    }
                });
            } catch (Throwable th) {
                sl.d("splrender", th.getMessage());
            }
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar) {
        this.zb = 3;
        ms(dVar);
        nw();
    }

    public void xr(int i) {
        this.eg = i;
    }

    private void b() {
        if (this.xr.od() == 2) {
            this.m = new NativeExpressView(true, this.lm, this.xr, this.e, this.k, true);
        } else {
            this.m = new NativeExpressView(false, this.lm, this.xr, this.e, this.k, true);
        }
    }

    private void re() {
        if (this.xr.od() == 2) {
            this.m = new NativeExpressVideoView(true, this.lm, this.xr, this.e, this.k);
        } else {
            this.m = new NativeExpressVideoView(false, this.lm, this.xr, this.e, this.k);
        }
        if (this.m.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
            this.of = (com.bytedance.sdk.openadsdk.core.video.nativevideo.d) this.m.getVideoController();
        }
        this.m.setVideoAdListener(this);
        this.m.setVideoAdInteractionListener(this);
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar) {
        if (dVar == null || this.xr == null) {
            return;
        }
        if (this.cv) {
            this.nw = true;
            re();
        } else {
            this.nw = false;
            b();
        }
        this.w.ms(this);
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView == null) {
            this.w.xr(3);
            this.w.ms("no render express");
            dVar.ms(this.w);
        } else {
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.2
                @Override // com.bytedance.sdk.component.adexpress.xr.ah
                public boolean ms(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(xr.this.lm);
                        splashExpressBackupView.ms(xr.this.le, xr.this.xr, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
                            xr.this.of = (com.bytedance.sdk.openadsdk.core.video.nativevideo.d) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(xr.this);
                        xr.this.hi();
                        if (xr.this.f2400ms == null) {
                            return true;
                        }
                        xr.this.f2400ms.ms();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.zb = 3;
            this.m.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.3
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, int i) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.xr(xr.this.ao, xr.this.xr);
                    if (xr.this.x != null) {
                        xr.this.x.xr(xr.this);
                    }
                    xr.this.ch();
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, String str, int i) {
                    sl.d("splash", "onRenderFail:".concat(String.valueOf(str)));
                    xr.this.w.xr(3);
                    xr.this.w.ms("render splash express fail");
                    dVar.ms(xr.this.w);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, float f, float f2) {
                    if (view != null && f > 0.0f && f2 > 0.0f) {
                        ny nyVar = new ny(xr.this.p.get(), xr.this);
                        boolean zNw = xr.this.m.nw();
                        if (xr.this.m != null && !zNw) {
                            xr.this.f2400ms.setComplianceBarVisibility(8);
                        }
                        nyVar.ms(zNw);
                        xr.this.ul.set(zNw ? 1 : 2);
                        xr.this.yu.set(true);
                        xr.this.f2400ms.setExpressView(xr.this.m);
                        xr.this.fm.set(true);
                        if (xr.this.op.get()) {
                            xr xrVar = xr.this;
                            xrVar.ms((WeakReference<ViewGroup>) xrVar.xn);
                            xr.this.op.set(false);
                        }
                        if (!xr.this.ny.get() && !zNw && vm.ms(xr.this.xr)) {
                            xr.this.w();
                        }
                        dVar.xr(nyVar);
                        xr.this.il.ms(xr.this.f2400ms.getEasyPlayableLayout(), xr.this.m.getVideoContainer());
                        return;
                    }
                    xr.this.w.xr(3);
                    xr.this.w.ms("render splash view error");
                    dVar.ms(xr.this.w);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.d.ms, com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(ViewGroup viewGroup) {
        if (viewGroup == null) {
            sl.d("splash", "展示开屏的容器不能为空");
            return;
        }
        i();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.xn = weakReference;
        if (this.yu.get() && this.f2400ms != null) {
            ms(weakReference);
        } else {
            this.op.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (this.f2400ms.getParent() != null) {
            ((ViewGroup) this.f2400ms.getParent()).removeView(this.f2400ms);
        }
        viewGroup.addView(this.f2400ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.d.ms, com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public View u() {
        if (this.jw == -1) {
            this.jw = 0;
        }
        return this.f2400ms;
    }

    public void nw() {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.ka(this.eg);
        this.m.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.d.ms.xr
    public void v_() {
        if (this.xr == null || this.y == null) {
            return;
        }
        if (this.xr.fm() == 2) {
            if (this.fm.get()) {
                NativeExpressView nativeExpressView = this.m;
                if (nativeExpressView != null) {
                    nativeExpressView.ao();
                    yu.ms(this.y, this.xr, this.m);
                }
                this.y.put("splash_show_type", 3);
            }
        } else if (!this.cv) {
            this.y.put("splash_show_type", 0);
        } else {
            if (TextUtils.isEmpty(qr.ms(this.xr))) {
                this.y.put("splash_show_type", 2);
            }
            this.y.put("splash_show_type", 1);
        }
        ms(this.xr);
    }

    private void ms(lm lmVar) {
        if (this.m == null || lmVar == null) {
            return;
        }
        Context context = this.lm;
        String str = this.k;
        c cVar = new c(context, lmVar, str, f.xr(str));
        cVar.ms(this.m);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.ch);
        this.m.setClickListener(cVar);
        Context context2 = this.lm;
        String str2 = this.k;
        ka kaVar = new ka(context2, lmVar, str2, f.xr(str2));
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        kaVar.ms(this.m);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.ch);
        this.m.setClickCreativeListener(kaVar);
        if (this.ah != null) {
            this.ah.ms(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms r_() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
        ah videoController = this.of;
        if (videoController == null && (nativeExpressView = this.m) != null) {
            videoController = nativeExpressView.getVideoController();
        }
        if (videoController != null) {
            msVar.ab = videoController.hi();
            msVar.f2932ms = videoController.t();
            msVar.x = videoController.y();
        }
        return msVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void ms(int i, int i2) {
        this.re = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void C_() {
        this.re = false;
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ao, this.xr);
        if (this.x != null) {
            this.hi = true;
            this.x.ms(this, 4);
            ah(false);
        }
        zb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.d.ms, com.bytedance.sdk.openadsdk.core.component.splash.TsView.ms
    public void ab() {
        super.ab();
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.zb();
        }
        this.m = null;
        this.ab = null;
        this.c = null;
        if (this.ch != null) {
            this.ch.clear();
        }
        d dVar = this.il;
        if (dVar != null) {
            dVar.xr();
        }
        ah(false);
        zb();
    }

    private void i() {
        if (this.jw > 0) {
            return;
        }
        if (this.pc == 1) {
            this.jw = 1;
        } else {
            this.jw = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.xr(this.sl, 0);
        this.m.setDynamicSkipListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.ah() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.4
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.ah
            public void ms() {
                xr.this.x();
            }
        });
        this.f2400ms.xr();
        this.az = new com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr();
        this.az.ms(this.sl);
        this.az.ms(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.xr.5
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr.ms
            public void ms() {
                xr.this.sl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr.ms
            public void ms(int i) {
                if (xr.this.m != null) {
                    xr.this.m.xr(xr.this.sl, i);
                }
            }
        });
        if (this.f.get()) {
            this.az.xr();
        }
    }
}
