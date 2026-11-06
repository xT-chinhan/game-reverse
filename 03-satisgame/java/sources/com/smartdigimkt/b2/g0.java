package com.smartdigimkt.b2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;
import com.smartdigimkt.sdk.basead.ui.ShakeBorderThumbView;
import com.smartdigimkt.sdk.basead.ui.ShakeNativeBorderThumbView;
import com.smartdigimkt.sdk.basead.ui.ShakeThumbView;
import com.smartdigimkt.sdk.basead.ui.ShakeView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends f {
    public BaseShakeView i;
    public ShakeBorderThumbView j;
    public long o;
    public int p;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public final a0 q = new a0(this);

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e1  */
    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        boolean z;
        boolean z2;
        int i2;
        com.smartdigimkt.b3.e eVar2;
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        int i3 = this.e;
        if (i3 != 100) {
            switch (i3) {
                case 1:
                case 2:
                    this.i = new ShakeThumbView(context);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    if (i == 2 && com.smartdigimkt.r4.h.y(context) == 2 && aVar.s.e == 0) {
                        this.i.setPadding(0, 0, 0, com.smartdigimkt.r4.k.a(context, 42.0f));
                    }
                    this.i.setLayoutParams(layoutParams);
                    this.j = new ShakeBorderThumbView(context);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(12);
                    int iA = com.smartdigimkt.r4.k.a(context, 12.0f);
                    if (i == 1) {
                        if (com.smartdigimkt.r4.h.y(context) == 2) {
                            layoutParams2.setMargins(iA, 0, 0, (int) ((context.getResources().getDisplayMetrics().density * 132.0f) + 0.5f));
                        } else {
                            layoutParams2.setMargins(iA, 0, 0, (int) ((context.getResources().getDisplayMetrics().density * 252.0f) + 0.5f));
                        }
                    }
                    if (i == 2 && !com.smartdigimkt.z.c0.a(this.b)) {
                        if (aVar.s.e == 0) {
                            layoutParams2.setMargins(iA, 0, 0, (int) ((context.getResources().getDisplayMetrics().density * 48.0f) + 0.5f));
                        } else {
                            layoutParams2.setMargins(iA, 0, 0, (int) ((context.getResources().getDisplayMetrics().density * 86.0f) + 0.5f));
                        }
                    }
                    this.j.setLayoutParams(layoutParams2);
                    com.smartdigimkt.a3.a aVar2 = this.c;
                    com.smartdigimkt.d1.d dVarA = com.smartdigimkt.d1.f.a(aVar2 != null ? aVar2.s : null);
                    boolean z3 = aVar.s.e != 1;
                    a(this.i, z3, dVarA);
                    a(this.j, z3, dVarA);
                    break;
                case 3:
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    com.smartdigimkt.b3.e eVar3 = this.c.s;
                    if (eVar3.n0 != 1 || TextUtils.isEmpty(eVar3.p0)) {
                        com.smartdigimkt.b3.e eVar4 = this.c.s;
                        if (eVar4.a0 || eVar4.k0 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                    if (BaseSdkSplashATView.isSinglePicture(this.b, this.c.s)) {
                        this.i = new ShakeView(context);
                        layoutParams3.addRule(14);
                        layoutParams3.addRule(12);
                        int iA2 = this.c.s.m == 2 ? com.smartdigimkt.r4.k.a(context, 46.0f) : com.smartdigimkt.r4.k.a(context, 63.0f);
                        if (this.c.s.k0 == 1) {
                            iA2 = com.smartdigimkt.r4.k.a(context, 100.0f);
                        }
                        if (cVar.e() == 4) {
                            String directlySplashAdShakeIconString = SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashAdShakeIconString();
                            if (!TextUtils.isEmpty(directlySplashAdShakeIconString)) {
                                ((ShakeView) this.i).setShakeHintText(directlySplashAdShakeIconString);
                            }
                            View directlySplashShakeButton = SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashShakeButton();
                            if (directlySplashShakeButton != null) {
                                ((ShakeView) this.i).replaceShakeCTAButton(directlySplashShakeButton);
                            }
                        }
                        ((ShakeView) this.i).setNeedHideShakeIcon(z);
                        layoutParams3.setMargins(0, 0, 0, iA2);
                        z2 = true;
                    } else {
                        if (!z || this.c.s.m == 1) {
                            this.i = new ShakeThumbView(context);
                            layoutParams3.addRule(13);
                            if (this.c.s.m == 2) {
                                this.i.setPadding(0, 0, 0, com.smartdigimkt.r4.k.a(context, 26.0f));
                            }
                        } else {
                            this.i = new ShakeBorderThumbView(context);
                            layoutParams3.addRule(11);
                            layoutParams3.addRule(15);
                        }
                        z2 = false;
                    }
                    this.i.setLayoutParams(layoutParams3);
                    a(this.i, z2 || aVar.s.e != 1, null);
                    break;
                case 4:
                    this.i = new ShakeBorderThumbView(context);
                    com.smartdigimkt.a3.a aVar3 = this.c;
                    int i4 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
                    if (aVar3 == null || (eVar2 = aVar3.s) == null) {
                        i2 = 50;
                    } else {
                        String str = eVar2.n;
                        i2 = 90;
                        if (!TextUtils.equals(str, com.anythink.core.common.h.y.b)) {
                            if (TextUtils.equals(str, com.anythink.core.common.h.y.c)) {
                                i4 = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                                i2 = 250;
                            } else if (TextUtils.equals(str, com.anythink.core.common.h.y.d)) {
                                i4 = 720;
                            } else {
                                i2 = 50;
                            }
                        }
                    }
                    com.smartdigimkt.n1.a0 a0VarA = com.smartdigimkt.n1.a0.a(i4, i2, 1);
                    ((ShakeBorderThumbView) this.i).applyBannerForegroundProfile(a0VarA);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.smartdigimkt.r4.k.a(context, a0VarA.d), (int) ((a0VarA.e * context.getResources().getDisplayMetrics().density) + 0.5f));
                    if (a0VarA.c) {
                        layoutParams4.addRule(13);
                    } else {
                        layoutParams4.addRule(12);
                        layoutParams4.addRule(14);
                    }
                    this.i.setLayoutParams(layoutParams4);
                    this.i.setClickable(false);
                    this.i.setLongClickable(false);
                    a(this.i, false, null);
                    break;
                case 5:
                case 6:
                    this.i = new ShakeNativeBorderThumbView(context);
                    this.i.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    a(this.i, aVar.s.e != 1, null);
                    break;
            }
        } else {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            this.i = new ShakeBorderThumbView(context);
            layoutParams5.addRule(13);
            this.i.setAlpha(0.0f);
            this.i.setLayoutParams(layoutParams5);
            a(this.i, false, null);
        }
        BaseShakeView baseShakeView = this.i;
        if (baseShakeView != null) {
            baseShakeView.setShakeSetting(this.c.s, this.b.o);
        }
        ShakeBorderThumbView shakeBorderThumbView = this.j;
        if (shakeBorderThumbView != null) {
            shakeBorderThumbView.setShakeSetting(this.c.s, this.b.o);
        }
    }

    public final void b() {
        BaseShakeView baseShakeView;
        int i = this.e;
        if ((i == 5 || i == 6) && (baseShakeView = this.i) != null && (baseShakeView.getParent() instanceof View)) {
            View view = (View) this.i.getParent();
            if (view.getParent() instanceof View) {
                View view2 = (View) view.getParent();
                if (view2.getParent() instanceof ViewGroup) {
                    v.b((ViewGroup) view2.getParent());
                }
            }
        }
    }

    public final void c() {
        BaseShakeView baseShakeView = this.i;
        if (baseShakeView != null) {
            baseShakeView.setVisibility(8);
        }
        ShakeBorderThumbView shakeBorderThumbView = this.j;
        if (shakeBorderThumbView != null) {
            shakeBorderThumbView.setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        ShakeBorderThumbView shakeBorderThumbView;
        if (i == 102) {
            this.l = true;
            if (this.e == 1 && com.smartdigimkt.z.c0.h(this.b, this.c)) {
                c();
                com.smartdigimkt.a3.a aVar = this.c;
                if ((aVar == null || !aVar.t) && this.j != null && this.e == 1 && !com.smartdigimkt.z.c0.a(this.b)) {
                    if (this.c.s.e == 0 || com.smartdigimkt.r4.h.y(this.a) == 2) {
                        this.j.setAlpha(1.0f);
                        this.j.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i == 103) {
            Object obj = map.get("key_has_endcard_improve");
            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                c();
                return;
            }
            return;
        }
        if (i == 105) {
            c();
            return;
        }
        if (i == 118) {
            if (this.e == 3 && com.smartdigimkt.z.c0.g(this.b, this.c)) {
                c();
                return;
            }
            return;
        }
        if (i == 119) {
            c();
            return;
        }
        if (i == 303) {
            if (this.e == 100) {
                if (this.o <= 0) {
                    this.o = System.currentTimeMillis();
                }
                BaseShakeView baseShakeView = this.i;
                if (baseShakeView != null) {
                    baseShakeView.setAlpha(0.0f);
                }
                a(map);
                return;
            }
            return;
        }
        if (i != 304) {
            switch (i) {
                case 110:
                    this.m = true;
                    break;
                case 111:
                    this.m = false;
                    break;
                case 112:
                    b();
                    BaseShakeView baseShakeView2 = this.i;
                    if (baseShakeView2 != null) {
                        baseShakeView2.removeCallbacks(this.q);
                    }
                    c();
                    break;
                case 113:
                    if (com.smartdigimkt.i2.s.a(map)) {
                        b();
                        BaseShakeView baseShakeView3 = this.i;
                        if (baseShakeView3 != null) {
                            baseShakeView3.releaseShakeListener();
                        }
                        ShakeBorderThumbView shakeBorderThumbView2 = this.j;
                        if (shakeBorderThumbView2 != null) {
                            shakeBorderThumbView2.releaseShakeListener();
                        }
                        c();
                        BaseShakeView baseShakeView4 = this.i;
                        if (baseShakeView4 != null) {
                            baseShakeView4.removeCallbacks(this.q);
                        }
                        if (this.e == 4) {
                            BaseShakeView baseShakeView5 = this.i;
                            if (baseShakeView5 != null) {
                                com.smartdigimkt.o3.d.a(baseShakeView5);
                            }
                            ShakeBorderThumbView shakeBorderThumbView3 = this.j;
                            if (shakeBorderThumbView3 != null) {
                                com.smartdigimkt.o3.d.a(shakeBorderThumbView3);
                            }
                            this.i = null;
                            this.j = null;
                        }
                        break;
                    }
                    break;
                case 114:
                    com.smartdigimkt.a3.a aVar2 = this.c;
                    if (aVar2 == null || aVar2.s == null || !aVar2.t) {
                        this.o = System.currentTimeMillis();
                        Object obj2 = map.get("screen_style");
                        boolean z = (obj2 instanceof Integer) && ((Integer) obj2).intValue() == 1;
                        if (z && (shakeBorderThumbView = this.j) != null) {
                            ViewGroup.LayoutParams layoutParams = shakeBorderThumbView.getLayoutParams();
                            int iA = com.smartdigimkt.r4.k.a(this.a, 12.0f);
                            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                                ((RelativeLayout.LayoutParams) layoutParams).setMargins(iA, 0, 0, com.smartdigimkt.r4.k.a(this.a, 48.0f));
                            }
                        }
                        int i2 = this.e;
                        if (i2 == 1) {
                            a(map);
                            if (this.i != null && this.j != null && !this.k && a()) {
                                this.k = true;
                                this.i.setVisibility(0);
                                this.i.postDelayed(new d0(this), 3000L);
                                break;
                            }
                        } else if (!z && (i2 != 2 || com.smartdigimkt.z.c0.a(this.b))) {
                            int i3 = this.e;
                            if (i3 == 5 || i3 == 6 || i3 == 4) {
                                a(map);
                            } else if (i3 == 100) {
                                BaseShakeView baseShakeView6 = this.i;
                                if (baseShakeView6 != null) {
                                    baseShakeView6.setAlpha(1.0f);
                                }
                                a(map);
                            }
                            break;
                        } else {
                            a(map);
                            if (this.i != null && this.j != null && !this.k && a()) {
                                this.k = true;
                                this.i.setVisibility(0);
                                this.i.postDelayed(new d0(this), 3000L);
                                break;
                            }
                        }
                    }
                    break;
                case 115:
                    this.n = true;
                    break;
                case 116:
                    if (this.e == 3) {
                        a(map);
                    }
                    break;
            }
            return;
        }
        if (this.e == 100) {
            c();
        }
    }

    public final void a(HashMap map) {
        RelativeLayout relativeLayout;
        View view = this.g;
        int iIndexOfChild = (view == null || this.d.indexOfChild(view) <= 0) ? -1 : this.d.indexOfChild(this.g);
        int i = this.e;
        if (i != 100) {
            switch (i) {
                case 1:
                case 2:
                    try {
                        relativeLayout = (RelativeLayout) this.d.findViewById(com.smartdigimkt.r4.k.a(this.a, "myoffer_end_card_id", "id"));
                    } catch (Throwable unused) {
                        relativeLayout = null;
                    }
                    BaseShakeView baseShakeView = this.i;
                    if (baseShakeView != null) {
                        com.smartdigimkt.o3.d.a(baseShakeView);
                        this.i.setVisibility(8);
                        if (relativeLayout != null) {
                            relativeLayout.addView(this.i);
                        } else {
                            this.d.addView(this.i, iIndexOfChild);
                        }
                    }
                    break;
                case 3:
                    BaseShakeView baseShakeView2 = this.i;
                    if (baseShakeView2 != null) {
                        com.smartdigimkt.o3.d.a(baseShakeView2);
                        this.i.setVisibility(0);
                        if (iIndexOfChild > 0) {
                            iIndexOfChild++;
                        }
                        this.d.addView(this.i, iIndexOfChild);
                    }
                    break;
                case 4:
                    BaseShakeView baseShakeView3 = this.i;
                    if (baseShakeView3 != null && this.f != null) {
                        com.smartdigimkt.o3.d.a(baseShakeView3);
                        this.i.setVisibility(0);
                        this.f.addView(this.i);
                        this.f.bringChildToFront(this.i);
                        BaseShakeView baseShakeView4 = this.i;
                        if (baseShakeView4 != null) {
                            this.p = 0;
                            baseShakeView4.removeCallbacks(this.q);
                            this.i.post(this.q);
                            break;
                        }
                    }
                    break;
                case 5:
                case 6:
                    BaseShakeView baseShakeView5 = this.i;
                    if (baseShakeView5 != null) {
                        com.smartdigimkt.o3.d.a(baseShakeView5);
                        ViewGroup viewGroupA = v.a(this.d, this.e, map, this.c);
                        if (viewGroupA == null) {
                            Object obj = map.get("native_ad_event_listener");
                            if (obj instanceof com.smartdigimkt.j1.u) {
                                ((com.smartdigimkt.j1.u) obj).a(1);
                            }
                        } else {
                            BaseShakeView baseShakeView6 = this.i;
                            if (baseShakeView6 instanceof ShakeNativeBorderThumbView) {
                                ((ShakeNativeBorderThumbView) baseShakeView6).changeBackground();
                            }
                            v.b(viewGroupA);
                            FrameLayout frameLayoutA = v.a(viewGroupA);
                            if (frameLayoutA == null) {
                                Object obj2 = map.get("native_ad_event_listener");
                                if (obj2 instanceof com.smartdigimkt.j1.u) {
                                    ((com.smartdigimkt.j1.u) obj2).a(1);
                                }
                            } else {
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                layoutParams.gravity = 81;
                                frameLayoutA.addView(this.i, layoutParams);
                            }
                        }
                    }
                    break;
            }
        }
        BaseShakeView baseShakeView7 = this.i;
        if (baseShakeView7 != null) {
            com.smartdigimkt.o3.d.a(baseShakeView7);
            this.i.setVisibility(0);
            this.d.addView(this.i);
            this.i.bringToFront();
        }
    }

    public static void a(g0 g0Var, int i) {
        RelativeLayout.LayoutParams layoutParams;
        BaseShakeView baseShakeView = g0Var.i;
        if (baseShakeView == null) {
            return;
        }
        ViewGroup viewGroup = baseShakeView.getParent() instanceof ViewGroup ? (ViewGroup) g0Var.i.getParent() : null;
        if (viewGroup == null || viewGroup.getHeight() <= 0 || viewGroup.getWidth() <= 0) {
            if (i < 2) {
                int i2 = i + 1;
                BaseShakeView baseShakeView2 = g0Var.i;
                if (baseShakeView2 == null) {
                    return;
                }
                g0Var.p = i2;
                baseShakeView2.removeCallbacks(g0Var.q);
                g0Var.i.post(g0Var.q);
                return;
            }
            return;
        }
        if (g0Var.i.getHeight() <= 0 || g0Var.i.getWidth() <= 0) {
            if (i < 2) {
                int i3 = i + 1;
                BaseShakeView baseShakeView3 = g0Var.i;
                if (baseShakeView3 == null) {
                    return;
                }
                g0Var.p = i3;
                baseShakeView3.removeCallbacks(g0Var.q);
                g0Var.i.post(g0Var.q);
                return;
            }
            return;
        }
        com.smartdigimkt.n1.a0 a0VarA = com.smartdigimkt.n1.a0.a(com.smartdigimkt.r4.k.b(g0Var.i.getContext(), viewGroup.getWidth()), com.smartdigimkt.r4.k.b(g0Var.i.getContext(), viewGroup.getHeight()), 1);
        BaseShakeView baseShakeView4 = g0Var.i;
        if (baseShakeView4 instanceof ShakeBorderThumbView) {
            ((ShakeBorderThumbView) baseShakeView4).applyBannerForegroundProfile(a0VarA);
        }
        if (g0Var.i.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) g0Var.i.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(0, 0);
        }
        layoutParams.width = com.smartdigimkt.r4.k.a(g0Var.i.getContext(), a0VarA.d);
        layoutParams.height = com.smartdigimkt.r4.k.a(g0Var.i.getContext(), a0VarA.e);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(13, 0);
        layoutParams.addRule(12, 0);
        layoutParams.addRule(14, 0);
        if (a0VarA.c) {
            layoutParams.addRule(13, -1);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
        }
        g0Var.i.setLayoutParams(layoutParams);
        g0Var.i.setScaleX(1.0f);
        g0Var.i.setScaleY(1.0f);
    }

    public final void a(BaseShakeView baseShakeView, boolean z, com.smartdigimkt.d1.d dVar) {
        if (z) {
            baseShakeView.setOnClickListener(new e0(this));
        }
        f0 f0Var = new f0(this);
        if (dVar != null) {
            baseShakeView.setOnShakeListener(f0Var, dVar);
        } else {
            baseShakeView.setOnShakeListener(f0Var, this.c.s);
        }
    }

    public final boolean a() {
        com.smartdigimkt.a3.a aVar = this.c;
        if (aVar == null || aVar.s == null || !aVar.t) {
            return (this.e == 1 && com.smartdigimkt.z.c0.h(this.b, aVar) && this.l) ? false : true;
        }
        return false;
    }
}
