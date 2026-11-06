package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.xr.ah;
import com.bytedance.sdk.component.adexpress.xr.d;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ub;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressView extends NativeExpressView implements hi {
    com.bytedance.sdk.openadsdk.core.video.xr.ms ah;
    private HashSet<String> b;
    private d d;
    private View i;
    private u ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    hi f2258ms;
    private ImageView nw;
    private com.bytedance.sdk.openadsdk.core.ugeno.ch.ms op;
    private ms re;
    private com.bytedance.sdk.openadsdk.core.video.ms.ms.InterfaceC0322ms w;
    FullRewardExpressBackupView xr;
    private FullSwiperItemView.ms yu;

    public interface ms {
        void ms(int i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(boolean z) {
    }

    public FullRewardExpressView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, boolean z) {
        super(context, lmVar, xrVar, str, z);
        this.b = new HashSet<>();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void sl() {
        this.ub = true;
        this.zb = new FrameLayout(this.c);
        super.sl();
        ub();
        if (getJsObject() != null) {
            getJsObject().sl(this.y);
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.i = view;
    }

    public void setInteractListener(FullSwiperItemView.ms msVar) {
        this.yu = msVar;
    }

    private void ub() {
        setBackupListener(new ah() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.xr.ah
            public boolean ms(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).y();
                    FullRewardExpressView.this.xr = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.xr.ms(FullRewardExpressView.this.ny, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    public void setExpressVideoListenerProxy(hi hiVar) {
        this.f2258ms = hiVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0045  */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void xr(d<? extends View> dVar, u uVar) {
        boolean z;
        FrameLayout frameLayoutH;
        View view;
        this.d = dVar;
        if (dVar instanceof ub) {
            ub ubVar = (ub) dVar;
            if (ubVar.E_() != null) {
                ubVar.E_().ms((hi) this);
            }
        }
        if (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ms) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.ms) dVar).ms(this);
        }
        if (uVar != null && uVar.ah()) {
            this.ka = uVar;
            if (uVar.xr() == 2) {
                View viewMs = uVar.ms();
                if (viewMs instanceof ViewGroup) {
                    ((ViewGroup) viewMs).addView(getVideoContainer());
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!z) {
                ms((ViewGroup) this.zb, true);
            }
            if (uVar.xr() == 10 && (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah)) {
                this.op = ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar).qv();
            }
            if (uVar.xr() == 10 && (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah) && (frameLayoutH = ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar).h()) != null && (view = this.i) != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                frameLayoutH.addView(this.i);
            }
        }
        super.xr(dVar, uVar);
        d(getVisibility());
    }

    public void ms(final ViewGroup viewGroup, final boolean z) {
        if (this.ka == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.xr(viewGroup, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    public void xr(ViewGroup viewGroup, boolean z) {
        u uVar = this.ka;
        if (uVar == null) {
            return;
        }
        double dC = uVar.c();
        double dAb = this.ka.ab();
        double dX = this.ka.x();
        double dNy = this.ka.ny();
        int iAh = ul.ah(this.c, (float) dC);
        int iAh2 = ul.ah(this.c, (float) dAb);
        int iAh3 = ul.ah(this.c, (float) dX);
        int iAh4 = ul.ah(this.c, (float) dNy);
        float fAh = this.ka.sl() > 0.0f ? ul.ah(this.c, this.ka.sl()) : 0.0f;
        float fAh2 = this.ka.zb() > 0.0f ? ul.ah(this.c, this.ka.zb()) : 0.0f;
        float fAh3 = this.ka.u() > 0.0f ? ul.ah(this.c, this.ka.u()) : 0.0f;
        float fAh4 = this.ka.ub() > 0.0f ? ul.ah(this.c, this.ka.ub()) : 0.0f;
        if (fAh2 < fAh) {
            fAh = fAh2;
        }
        if (fAh3 >= fAh) {
            fAh3 = fAh;
        }
        if (fAh4 >= fAh3) {
            fAh4 = fAh3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iAh3, iAh4);
        }
        layoutParams.width = iAh3;
        layoutParams.height = iAh4;
        layoutParams.topMargin = iAh2;
        layoutParams.leftMargin = iAh;
        viewGroup.setLayoutParams(layoutParams);
        ul.xr(viewGroup, fAh4);
        if (z) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.d.ah() == 7 || this.d.ah() == 10) {
                u uVar2 = this.ka;
                if (uVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah) {
                    FrameLayout frameLayoutAo = ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar2).ao();
                    if (frameLayoutAo != null) {
                        frameLayoutAo.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else {
                    this.t.addView(viewGroup);
                }
            } else {
                this.t.addView(viewGroup);
            }
            ms msVar = this.re;
            if (msVar == null || iAh4 == 0) {
                return;
            }
            msVar.ms(iAh4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
        super.ms(z);
        this.y = z;
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ms(z);
        }
        d dVar = this.d;
        if (dVar == null || !(dVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.ms.ms) dVar).ms(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
        super.ab();
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ab();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i) {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ms(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            return hiVar.ms();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            return hiVar.xr();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int ah() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            return hiVar.ah();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long getActualPlayDuration() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            return hiVar.getActualPlayDuration();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ny();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ch();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.hi();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f, float f2, float f3, float f4, int i) {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ms(f, f2, f3, f4, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void xr(int i) {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.xr(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void d() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ka() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ka();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final int i, final String str) {
        this.w = new com.bytedance.sdk.openadsdk.core.video.ms.ms.InterfaceC0322ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms.InterfaceC0322ms
            public void ms(long j, long j2) {
                int iAbs = (int) Math.abs(((long) i) - j);
                if (FullRewardExpressView.this.ah.of() && FullRewardExpressView.this.f2258ms != null) {
                    iAbs = (int) Math.abs(((long) i) - FullRewardExpressView.this.f2258ms.getActualPlayDuration());
                }
                int i2 = FullRewardExpressView.this.ah instanceof com.bytedance.sdk.openadsdk.core.component.reward.draw.d ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || iAbs > i2 || i3 > j2 || iAbs >= i2 || FullRewardExpressView.this.b.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.ah.c();
                            FullRewardExpressView.this.xr(i, str);
                            if (qf.h(FullRewardExpressView.this.ny) || fm.ms(FullRewardExpressView.this.ny)) {
                                FullRewardExpressView.this.f2258ms.ms(2);
                            }
                            if (FullRewardExpressView.this.f2258ms != null) {
                                FullRewardExpressView.this.f2258ms.setPauseFromExpressView(true);
                            }
                        }
                    }, iAbs);
                } else {
                    FullRewardExpressView.this.ah.c();
                    FullRewardExpressView.this.xr(i, str);
                    if (qf.h(FullRewardExpressView.this.ny) || fm.ms(FullRewardExpressView.this.ny)) {
                        FullRewardExpressView.this.f2258ms.ms(2);
                    }
                    if (FullRewardExpressView.this.f2258ms != null) {
                        FullRewardExpressView.this.f2258ms.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.b.add(str);
            }
        };
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVar = this.ah;
        if (msVar != null) {
            msVar.d(50);
            this.ah.ms(this.w);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f) {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.ms(f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
        hi hiVar = this.f2258ms;
        if (hiVar != null) {
            hiVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
        FullSwiperItemView.ms msVar = this.yu;
        if (msVar != null) {
            msVar.ms();
        }
        if (i != -1 && ahVar != null && i == 3) {
            ch();
            return;
        }
        if (i == 5) {
            ms(!this.y);
        } else if (i == 4) {
            re();
        } else {
            super.ms(view, i, ahVar);
        }
    }

    private void re() {
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVar;
        if ((this.d instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) && (msVar = this.ah) != null) {
            if (msVar.sa()) {
                this.ah.c();
                xr(true);
            } else {
                this.ah.x();
                xr(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
        FullSwiperItemView.ms msVar = this.yu;
        if (msVar != null) {
            msVar.ms();
        }
        if (i != -1 && ahVar != null && i == 3) {
            ch();
        } else {
            super.ms(view, i, ahVar, i2);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (nw()) {
            return this.xr.getVideoContainer();
        }
        return this.zb;
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.d.ah ahVar) {
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
            com.bytedance.sdk.openadsdk.core.video.xr.ms msVar = (com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVar;
            this.ah = msVar;
            msVar.d(50);
            this.ah.ms(this.w);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.d.ah getVideoController() {
        return this.ah;
    }

    protected void xr(boolean z) {
        if (this.nw == null) {
            this.nw = new ImageView(getContext());
            if (ch.ub().e() != null) {
                this.nw.setImageBitmap(ch.ub().e());
            } else {
                t.ms(re.getContext(), "tt_new_play_video", this.nw);
            }
            this.nw.setScaleType(ImageView.ScaleType.FIT_XY);
            int iAh = ul.ah(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iAh, iAh);
            layoutParams.gravity = 17;
            this.zb.addView(this.nw, layoutParams);
        }
        if (z) {
            this.nw.setVisibility(0);
        } else {
            this.nw.setVisibility(8);
        }
    }

    private void ah(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVar;
        if ((this.d instanceof com.bytedance.sdk.component.adexpress.dynamic.ms.ms) && z) {
            ImageView imageView = this.nw;
            if (imageView != null && imageView.getVisibility() == 0 && (msVar = this.ah) != null) {
                msVar.c();
            } else {
                ms(this.y);
            }
        }
    }

    public void setOnVideoSizeChangeListener(ms msVar) {
        this.re = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void zb() {
        super.zb();
        this.b.clear();
    }

    public boolean u() {
        u uVar = this.ka;
        if (uVar == null) {
            return true;
        }
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah) {
            return ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar).ao() != null;
        }
        return (uVar.x() == 0.0d || this.ka.ny() == 0.0d) ? false : true;
    }

    public u getRenderResult() {
        return this.ka;
    }

    public void ms(int i, int i2, int i3, int i4) {
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms msVar = this.op;
        if (msVar != null) {
            msVar.ms(i, i2, i3, i4);
        }
    }
}
