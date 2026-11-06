package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressVideoView extends NativeExpressView implements com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah, com.bykv.vk.openvk.component.video.api.d.ah.d, hi {
    boolean ah;
    private long b;
    int d;
    private com.bytedance.sdk.component.adexpress.xr.d i;
    boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f2939ms;
    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms nw;
    private long re;
    private HashSet<String> w;
    boolean xr;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(boolean z) {
    }

    public NativeExpressVideoView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        super(context, lmVar, xrVar, str, true);
        this.f2939ms = 1;
        this.xr = false;
        this.ah = true;
        this.ka = true;
        this.y = com.bytedance.sdk.openadsdk.core.re.xr().d(f.ny(this.ny));
        u();
    }

    public NativeExpressVideoView(boolean z, Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        super(z, context, lmVar, xrVar, str, true);
        this.f2939ms = 1;
        this.xr = false;
        this.ah = true;
        this.ka = true;
        this.y = com.bytedance.sdk.openadsdk.core.re.xr().d(f.ny(this.ny));
        u();
    }

    protected void u() {
        this.zb = new FrameLayout(this.c);
        this.d = f.ny(this.ny);
        this.w = new HashSet<>();
        ah(this.d);
        re();
    }

    protected ExpressVideoView ms(Context context, lm lmVar, String str) {
        return new ExpressVideoView(context, lmVar, str, false);
    }

    private void re() {
        try {
            this.nw = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
            this.ch = ms(this.c, this.ny, this.ab);
            this.ch.setNativeExpressVideoView(this);
            this.ch.setAdCreativeClickListener(new NativeVideoTsView.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ms
                public void ms(View view, int i) {
                    ms expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.ms(view, i);
                }
            });
            this.ch.setShouldCheckNetChange(false);
            this.ch.setControllerStatusCallBack(new NativeVideoTsView.d() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.d
                public void ms(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                    NativeExpressVideoView.this.nw.f2932ms = z;
                    NativeExpressVideoView.this.nw.ka = j;
                    NativeExpressVideoView.this.nw.c = j2;
                    NativeExpressVideoView.this.nw.ab = j3;
                    NativeExpressVideoView.this.nw.d = z2;
                    NativeExpressVideoView.this.nw.x = z3;
                }
            });
            this.ch.setVideoAdLoadListener(this);
            this.ch.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.ab)) {
                this.ch.setIsAutoPlay(this.xr ? this.x.ka() : this.ah);
            } else if ("splash_ad".equals(this.ab)) {
                this.ch.setIsAutoPlay(true);
            } else {
                this.ch.setIsAutoPlay(this.ah);
            }
            if ("splash_ad".equals(this.ab)) {
                this.ch.setIsQuiet(true);
            } else {
                this.ch.setIsQuiet(com.bytedance.sdk.openadsdk.core.re.xr().d(this.d));
            }
            this.ch.ah();
        } catch (Exception e) {
            this.ch = null;
            com.bytedance.sdk.component.utils.sl.d("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    void ah(int i) {
        int iAb = com.bytedance.sdk.openadsdk.core.re.xr().ab(i);
        if (3 == iAb) {
            this.xr = false;
            this.ah = false;
        } else if (1 == iAb) {
            this.xr = false;
            this.ah = com.bytedance.sdk.component.utils.u.d(this.c);
        } else if (2 == iAb) {
            if (com.bytedance.sdk.component.utils.u.ka(this.c) || com.bytedance.sdk.component.utils.u.d(this.c) || com.bytedance.sdk.component.utils.u.c(this.c)) {
                this.xr = false;
                this.ah = true;
            }
        } else if (5 == iAb) {
            if (com.bytedance.sdk.component.utils.u.d(this.c) || com.bytedance.sdk.component.utils.u.c(this.c)) {
                this.xr = false;
                this.ah = true;
            }
        } else if (4 == iAb) {
            this.xr = true;
        }
        if (!this.ah) {
            this.f2939ms = 3;
        }
        com.bytedance.sdk.component.utils.sl.ms("NativeVideoAdView", "mIsAutoPlay=" + this.ah + ",status=" + iAb);
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms getVideoModel() {
        return this.nw;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.ch != null) {
            this.ch.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.ch != null) {
            this.ch.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void xr(com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar, com.bytedance.sdk.component.adexpress.xr.u uVar) {
        this.i = dVar;
        if ((dVar instanceof ub) && ((ub) dVar).E_() != null) {
            ((ub) this.i).E_().ms((hi) this);
        }
        if (uVar != null && uVar.ah()) {
            if ((uVar.xr() == 2 || uVar.xr() == 7) && this.ch != null) {
                this.ch.ms(this.c, 25, qr.xr(this.ny));
            }
            ms(uVar);
        }
        com.bytedance.sdk.component.adexpress.xr.d dVar2 = this.i;
        if (dVar2 != null && (dVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.ms.ms) dVar2).ms(com.bytedance.sdk.openadsdk.core.re.xr().d(this.d));
        }
        super.xr(dVar, uVar);
    }

    private void ms(final com.bytedance.sdk.component.adexpress.xr.u uVar) {
        if (uVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(uVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.xr(uVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.component.adexpress.xr.u uVar) {
        if (uVar == null) {
            return;
        }
        double dC = uVar.c();
        double dAb = uVar.ab();
        double dX = uVar.x();
        double dNy = uVar.ny();
        int iAh = ul.ah(this.c, (float) dC);
        int iAh2 = ul.ah(this.c, (float) dAb);
        int iAh3 = ul.ah(this.c, (float) dX);
        int iAh4 = ul.ah(this.c, (float) dNy);
        float fAh = uVar.sl() > 0.0f ? ul.ah(this.c, uVar.sl()) : 0.0f;
        float fAh2 = uVar.zb() > 0.0f ? ul.ah(this.c, uVar.zb()) : 0.0f;
        float fAh3 = uVar.u() > 0.0f ? ul.ah(this.c, uVar.u()) : 0.0f;
        float fAh4 = uVar.ub() > 0.0f ? ul.ah(this.c, uVar.ub()) : 0.0f;
        if (fAh2 < fAh) {
            fAh = fAh2;
        }
        if (fAh3 >= fAh) {
            fAh3 = fAh;
        }
        if (fAh4 >= fAh3) {
            fAh4 = fAh3;
        }
        if (uVar.xr() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.zb.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iAh3, iAh4);
            }
            layoutParams.width = iAh3;
            layoutParams.height = iAh4;
            layoutParams.topMargin = iAh2;
            layoutParams.leftMargin = iAh;
            this.zb.setLayoutParams(layoutParams);
        }
        ul.xr(this.zb, fAh4);
        this.zb.removeAllViews();
        if (this.ch != null) {
            this.zb.addView(this.ch);
            this.ch.ms(0L, true, false);
            ah(this.d);
            if (!com.bytedance.sdk.component.utils.u.d(this.c) && !this.ah && this.ka) {
                this.ch.y_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.zb.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.zb);
        }
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah) {
            FrameLayout frameLayoutAo = ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar).ao();
            if (frameLayoutAo != null) {
                if (this.ch != null) {
                    this.ch.setClickable(false);
                }
                frameLayoutAo.addView(this.zb, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (uVar.xr() == 2) {
            View viewMs = uVar.ms();
            if (viewMs instanceof ViewGroup) {
                if (this.ch != null) {
                    this.ch.setClickable(false);
                }
                ((ViewGroup) viewMs).addView(this.zb);
                return;
            }
            return;
        }
        this.t.addView(this.zb);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
        super.ms(z);
        this.y = z;
        this.ch.xr(z, true);
        if (this.ch != null && this.ch.getNativeVideoController() != null) {
            this.ch.getNativeVideoController().xr(z);
        }
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (dVar == null || !(dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.ms.ms) dVar).ms(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
        super.ab();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
        super.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i) {
        if (this.ch == null) {
            com.bytedance.sdk.component.utils.sl.d("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            this.ch.ms(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            this.ch.setVideoPlayStatus(i);
            this.ch.setCanInterruptVideoPlay(true);
            this.ch.performClick();
        } else if (i == 4) {
            this.ch.getNativeVideoController().ch();
        } else {
            if (i != 5) {
                return;
            }
            this.ch.ms(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
        if (i == -1 || ahVar == null) {
            return;
        }
        if (i == 4) {
            i();
        } else if (i == 5) {
            ms(!this.y);
        } else {
            super.ms(view, i, ahVar);
        }
    }

    private void i() {
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (((dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) || (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d)) && this.ch != null) {
            this.ch.xr(true);
            if (this.ch.z_()) {
                this.ch.setPauseIcon(true);
                this.ch.setVideoPlayStatus(2);
            } else {
                this.ch.setVideoPlayStatus(3);
                this.ch.setPauseIcon(false);
            }
            this.ch.performClick();
            this.ch.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if ((!(dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) && !(dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d)) || this.ch == null || (i = this.f2939ms) == 2 || i == 5) {
            return;
        }
        this.ch.setNeedNativeVideoPlayBtnVisible(true);
        this.ch.y_();
        this.ch.x_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (((dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) || (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d)) && this.ch != null && z && this.ch.xr != null && this.ch.xr.getVisibility() == 0) {
            this.ch.xr.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
        if (i == -1 || ahVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.ms(view, i, ahVar, i2);
                return;
            }
        } else if (this.ab == "draw_ad") {
            if (this.ch != null) {
                this.ch.performClick();
                return;
            }
            return;
        }
        ms(!this.y);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        if (this.f2939ms == 3 && this.ch != null) {
            this.ch.ah();
        }
        if (this.ch == null || !this.ch.getNativeVideoController().b()) {
            return this.f2939ms;
        }
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void o_() {
        this.ka = false;
        if (this.sl != null) {
            this.sl.o_();
        }
        this.f2939ms = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void p_() {
        this.ka = false;
        if (this.sl != null) {
            this.sl.p_();
        }
        this.u = true;
        this.f2939ms = 3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void q_() {
        this.ka = false;
        if (this.sl != null) {
            this.sl.q_();
        }
        this.u = false;
        this.f2939ms = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void ms(long j, long j2) {
        this.ka = false;
        if (this.sl != null) {
            this.sl.ms(j, j2);
        }
        if (ms(j)) {
            this.f2939ms = 2;
        }
        this.b = j;
        this.re = j2;
        if (!this.w.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.d.ah videoController = this.ch.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) videoController).d(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = this.nw;
        if (msVar != null) {
            msVar.ab = j;
        }
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.d) dVar).ms(j, j2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void C_() {
        this.ka = false;
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (dVar != null) {
            if (dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) {
                ((com.bytedance.sdk.component.adexpress.dynamic.ms.ms) dVar).d();
            }
            com.bytedance.sdk.component.adexpress.xr.d dVar2 = this.i;
            if (dVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.d) dVar2).sl();
            }
        }
        if (this.sl != null) {
            this.sl.C_();
        }
        this.f2939ms = 5;
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = this.nw;
        if (msVar != null) {
            msVar.f2932ms = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void D_() {
        if (this.hi != null) {
            this.hi.D_();
        }
        com.bytedance.sdk.component.adexpress.xr.d dVar = this.i;
        if (dVar != null) {
            if (dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) {
                ((com.bytedance.sdk.component.adexpress.dynamic.ms.ms) dVar).ka();
            }
            com.bytedance.sdk.component.adexpress.xr.d dVar2 = this.i;
            if (dVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.d) dVar2).zb();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void ms(int i, int i2) {
        if (this.hi != null) {
            this.hi.ms(i, i2);
        }
        this.b = this.re;
        this.f2939ms = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final int i, final String str) {
        super.ms(i, str);
        com.bykv.vk.openvk.component.video.api.d.ah videoController = this.ch.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.d) videoController;
            dVar.d(50);
            dVar.ms(new com.bytedance.sdk.openadsdk.core.video.ms.ms.InterfaceC0322ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms.InterfaceC0322ms
                public void ms(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.w.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.ch.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.ch.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.ch.performClick();
                                NativeExpressVideoView.this.xr(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.ch.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.ch.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.ch.performClick();
                        NativeExpressVideoView.this.xr(i, str);
                    }
                    NativeExpressVideoView.this.w.add(str);
                }
            });
        }
    }

    private boolean ms(long j) {
        int i = this.f2939ms;
        if (i == 5 || i == 3 || j <= this.b) {
            return this.ch != null && this.ch.z_();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.d.ah getVideoController() {
        if (this.ch != null) {
            return this.ch.getVideoController();
        }
        return null;
    }

    public void ub() {
        this.ch.ch();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void zb() {
        super.zb();
        if (this.ch != null) {
            this.ch.y();
        }
    }
}
