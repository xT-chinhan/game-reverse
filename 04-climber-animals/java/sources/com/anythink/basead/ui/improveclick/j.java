package com.anythink.basead.ui.improveclick;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.BaseSdkSplashATView;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.basead.ui.ShakeBorderThumbView;
import com.anythink.basead.ui.ShakeNativeBorderThumbView;
import com.anythink.basead.ui.ShakeThumbView;
import com.anythink.basead.ui.ShakeView;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j extends c {
    BaseShakeView a;
    BaseShakeView b;
    long p;
    private final int q = 12;
    private final int r = MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
    private final int s = 132;
    private final int t = 48;
    private final int u = 86;
    private boolean v = false;
    final long c = com.tapsdk.tapad.e.a.f;
    final long l = 500;
    boolean m = false;
    boolean n = false;
    boolean o = false;

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a() {
    }

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        boolean z;
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        int i2 = this.h;
        boolean z2 = true;
        if (i2 == 1 || i2 == 2) {
            this.a = new ShakeThumbView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            if (i == 2 && m.f(context) == 2 && xVar.o.H() == 0) {
                this.a.setPadding(0, 0, 0, q.a(context, 42.0f));
            }
            this.a.setLayoutParams(layoutParams);
            this.b = new ShakeBorderThumbView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            int iA = q.a(context, 12.0f);
            if (i == 1) {
                if (m.f(context) == 2) {
                    layoutParams2.setMargins(iA, 0, 0, q.a(context, 132.0f));
                } else {
                    layoutParams2.setMargins(iA, 0, 0, q.a(context, 252.0f));
                }
            }
            if (i == 2 && !com.anythink.basead.b.e.a(this.e)) {
                if (xVar.o.H() == 0) {
                    layoutParams2.setMargins(iA, 0, 0, q.a(context, 48.0f));
                } else {
                    layoutParams2.setMargins(iA, 0, 0, q.a(context, 86.0f));
                }
            }
            this.b.setLayoutParams(layoutParams2);
            a(this.a, xVar.o.H() != 1);
            a(this.b, xVar.o.H() != 1);
        } else if (i2 == 3) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            boolean z3 = (this.f.o.as() == 1 && !TextUtils.isEmpty(this.f.o.au())) || this.f.o.af() || this.f.o.ap();
            if (!this.e.n()) {
                if (BaseSdkSplashATView.isSinglePicture(this.e, this.f.o)) {
                    this.a = new ShakeView(context);
                    layoutParams3.addRule(14);
                    layoutParams3.addRule(12);
                    int iA2 = this.f.o.A() == 2 ? q.a(context, 46.0f) : q.a(context, 63.0f);
                    if (this.f.o.ap()) {
                        iA2 = q.a(context, 100.0f);
                    }
                    if (wVar.b() == 4) {
                        String directlySplashAdShakeIconString = ATSDKGlobalSetting.getDirectlySplashAdShakeIconString();
                        if (!TextUtils.isEmpty(directlySplashAdShakeIconString)) {
                            ((ShakeView) this.a).setShakeHintText(directlySplashAdShakeIconString);
                        }
                        View directlySplashShakeButton = ATSDKGlobalSetting.getDirectlySplashShakeButton();
                        if (directlySplashShakeButton != null) {
                            ((ShakeView) this.a).replaceShakeCTAButton(directlySplashShakeButton);
                        }
                    }
                    ((ShakeView) this.a).setNeedHideShakeIcon(z3);
                    layoutParams3.setMargins(0, 0, 0, iA2);
                    z = true;
                } else if (!z3 || this.f.o.A() == 1) {
                    this.a = new ShakeThumbView(context);
                    layoutParams3.addRule(13);
                    if (this.f.o.A() == 2) {
                        this.a.setPadding(0, 0, 0, q.a(context, 26.0f));
                    }
                } else {
                    this.a = new ShakeBorderThumbView(context);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(15);
                }
                this.a.setLayoutParams(layoutParams3);
                BaseShakeView baseShakeView = this.a;
                if (!z && xVar.o.H() == 1) {
                    z2 = false;
                }
                a(baseShakeView, z2);
            } else if (!z3) {
                this.a = new ShakeThumbView(context);
                layoutParams3.addRule(13);
                this.a.setPadding(0, 0, 0, q.a(context, 26.0f));
            } else {
                this.a = new ShakeBorderThumbView(context);
                layoutParams3.addRule(11);
                layoutParams3.addRule(15);
            }
            z = false;
            this.a.setLayoutParams(layoutParams3);
            BaseShakeView baseShakeView2 = this.a;
            if (!z) {
                z2 = false;
            }
            a(baseShakeView2, z2);
        } else if (i2 == 5 || i2 == 6) {
            this.a = new ShakeNativeBorderThumbView(context);
            this.a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            a(this.a, xVar.o.H() != 1);
        } else if (i2 == 100) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            this.a = new ShakeBorderThumbView(context);
            layoutParams4.addRule(13);
            this.a.setAlpha(0.0f);
            this.a.setLayoutParams(layoutParams4);
            a(this.a, false);
        }
        BaseShakeView baseShakeView3 = this.a;
        if (baseShakeView3 != null) {
            baseShakeView3.setShakeSetting(this.f.o, this.e.K());
        }
        BaseShakeView baseShakeView4 = this.b;
        if (baseShakeView4 != null) {
            baseShakeView4.setShakeSetting(this.f.o, this.e.K());
        }
    }

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(int i, Map<String, Object> map) {
        BaseShakeView baseShakeView;
        if (i == 102) {
            this.m = true;
            if (this.h == 1 && com.anythink.basead.b.e.a(this.e, this.f)) {
                e();
                if (this.b == null || this.h != 1 || com.anythink.basead.b.e.b(this.e) || com.anythink.basead.b.e.a(this.e)) {
                    return;
                }
                if (this.f.o.H() == 0 || m.f(this.d) == 2) {
                    this.b.setAlpha(1.0f);
                    this.b.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (i != 103) {
            if (i == 105) {
                e();
                return;
            }
            if (i == 106) {
                if (this.h == 3 && com.anythink.basead.b.e.b(this.e)) {
                    b(map);
                    return;
                }
                return;
            }
            if (i == 118) {
                if (this.h != 3 || !com.anythink.basead.b.e.b(this.e, this.f)) {
                    return;
                }
            } else {
                if (i == 119) {
                    e();
                    return;
                }
                if (i == 303) {
                    if (this.h == 100) {
                        b(map);
                        return;
                    }
                    return;
                }
                if (i != 304) {
                    switch (i) {
                        case 110:
                            this.n = true;
                            break;
                        case 111:
                            this.n = false;
                            break;
                        case 112:
                            break;
                        default:
                            switch (i) {
                                case 114:
                                    this.p = System.currentTimeMillis();
                                    Object obj = map.get(g.a.a);
                                    boolean z = (obj instanceof Integer) && ((Integer) obj).intValue() == 1;
                                    if (z && (baseShakeView = this.b) != null) {
                                        ViewGroup.LayoutParams layoutParams = baseShakeView.getLayoutParams();
                                        int iA = q.a(this.d, 12.0f);
                                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                                            ((RelativeLayout.LayoutParams) layoutParams).setMargins(iA, 0, 0, q.a(this.d, 48.0f));
                                        }
                                    }
                                    if (this.h == 1) {
                                        b(map);
                                        c();
                                    } else if (z || (this.h == 2 && !com.anythink.basead.b.e.a(this.e))) {
                                        b(map);
                                        c();
                                    } else if (this.h == 5 || this.h == 6) {
                                        b(map);
                                    }
                                    break;
                                case 115:
                                    this.o = true;
                                    break;
                                case 116:
                                    if (this.h == 3 && !com.anythink.basead.b.e.b(this.e)) {
                                        b(map);
                                        break;
                                    }
                                    break;
                            }
                            break;
                    }
                    return;
                }
                if (this.h != 100) {
                    return;
                }
            }
        } else if (!a(map)) {
            return;
        }
        e();
    }

    private void b(Map<String, Object> map) {
        BaseShakeView baseShakeView;
        int iIndexOfChild = (this.j == null || this.g.indexOfChild(this.j) <= 0) ? -1 : this.g.indexOfChild(this.j);
        int i = this.h;
        RelativeLayout relativeLayout = null;
        if (i == 1 || i == 2) {
            try {
                relativeLayout = (RelativeLayout) this.g.findViewById(q.a(this.d, "myoffer_end_card_id", "id"));
            } catch (Throwable unused) {
            }
            BaseShakeView baseShakeView2 = this.a;
            if (baseShakeView2 != null) {
                am.a(baseShakeView2);
                this.a.setVisibility(8);
                if (relativeLayout != null) {
                    relativeLayout.addView(this.a);
                    return;
                } else {
                    this.g.addView(this.a, iIndexOfChild);
                    return;
                }
            }
            return;
        }
        if (i == 3) {
            BaseShakeView baseShakeView3 = this.a;
            if (baseShakeView3 != null) {
                am.a(baseShakeView3);
                this.a.setVisibility(0);
                if (iIndexOfChild > 0) {
                    iIndexOfChild++;
                }
                this.g.addView(this.a, iIndexOfChild);
                return;
            }
            return;
        }
        if (i != 5 && i != 6) {
            if (i == 100 && (baseShakeView = this.a) != null) {
                am.a(baseShakeView);
                this.a.setVisibility(0);
                this.g.addView(this.a);
                return;
            }
            return;
        }
        BaseShakeView baseShakeView4 = this.a;
        if (baseShakeView4 != null) {
            am.a(baseShakeView4);
            Object obj = map != null ? map.get(g.a.b) : null;
            if (obj != null && (obj instanceof ViewGroup)) {
                BaseShakeView baseShakeView5 = this.a;
                if (baseShakeView5 instanceof ShakeNativeBorderThumbView) {
                    ((ShakeNativeBorderThumbView) baseShakeView5).changeBackground();
                    if (obj instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        this.a.setLayoutParams(layoutParams);
                    }
                }
                ((ViewGroup) obj).addView(this.a);
                return;
            }
            if (this.g.getMeasuredWidth() >= i.a().a(this.d) && this.g.getMeasuredHeight() >= i.a().b(this.d)) {
                if (this.g instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 21;
                    this.a.setLayoutParams(layoutParams2);
                }
                this.g.addView(this.a);
                return;
            }
            Object obj2 = map.get(g.a.c);
            if (obj2 == null || !(obj2 instanceof com.anythink.basead.g.f)) {
                return;
            }
            ((com.anythink.basead.g.f) obj2).onATImproveClickViewRenderFail(1);
        }
    }

    private void c() {
        if (this.a == null || this.b == null || this.v || !f()) {
            return;
        }
        this.v = true;
        this.a.setVisibility(0);
        this.a.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.improveclick.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.f()) {
                    try {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.2f);
                        valueAnimatorOfFloat.setDuration(500L);
                        valueAnimatorOfFloat.setRepeatCount(1);
                        valueAnimatorOfFloat.setRepeatMode(2);
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.improveclick.j.1.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (j.this.b != null) {
                                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    if (j.this.a != null && j.this.b.getParent() == null) {
                                        j.this.a.setAlpha(fFloatValue);
                                    }
                                    if (j.this.b.getParent() != null) {
                                        j.this.b.setAlpha(fFloatValue);
                                    }
                                }
                            }
                        });
                        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.improveclick.j.1.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationRepeat(Animator animator) {
                                super.onAnimationRepeat(animator);
                                try {
                                    if (j.this.b == null || !j.this.f()) {
                                        return;
                                    }
                                    am.a(j.this.b);
                                    RelativeLayout relativeLayout = (RelativeLayout) j.this.g.findViewById(q.a(j.this.d, "myoffer_end_card_id", "id"));
                                    if (relativeLayout != null) {
                                        relativeLayout.addView(j.this.b);
                                    } else {
                                        j.this.g.addView(j.this.b, (j.this.j == null || j.this.g.indexOfChild(j.this.j) <= 0) ? -1 : j.this.g.indexOfChild(j.this.j));
                                    }
                                    j.this.b.setAlpha(0.2f);
                                    j.this.a.setVisibility(8);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                        valueAnimatorOfFloat.start();
                    } catch (Throwable unused) {
                        if (j.this.f()) {
                            if (j.this.b != null && j.this.b.getParent() != null) {
                                j.this.a.setVisibility(8);
                                j.this.b.setVisibility(0);
                            } else {
                                j.this.a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }, com.tapsdk.tapad.e.a.f);
    }

    private void d() {
        e();
        if (this.b == null || this.h != 1 || com.anythink.basead.b.e.b(this.e) || com.anythink.basead.b.e.a(this.e)) {
            return;
        }
        if (this.f.o.H() == 0 || m.f(this.d) == 2) {
            this.b.setAlpha(1.0f);
            this.b.setVisibility(0);
        }
    }

    private void e() {
        BaseShakeView baseShakeView = this.a;
        if (baseShakeView != null) {
            baseShakeView.setVisibility(8);
        }
        BaseShakeView baseShakeView2 = this.b;
        if (baseShakeView2 != null) {
            baseShakeView2.setVisibility(8);
        }
    }

    protected final boolean b() {
        if (!com.anythink.basead.ui.f.b.a(this.p, this.f)) {
            return false;
        }
        int i = this.h;
        if (i == 1 || i == 2) {
            return this.n;
        }
        return (i == 3 && this.o) ? false : true;
    }

    private void a(BaseShakeView baseShakeView, boolean z) {
        if (z) {
            baseShakeView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.j.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (j.this.k != null) {
                        j.this.k.a(1, 5);
                    }
                }
            });
        }
        baseShakeView.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.improveclick.j.3
            @Override // com.anythink.basead.ui.BaseShakeView.a
            public final boolean a() {
                if (!j.this.b()) {
                    return false;
                }
                if (j.this.k == null) {
                    return true;
                }
                j.this.k.a(4, 5);
                return true;
            }
        }, this.f.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return (this.h == 1 && com.anythink.basead.b.e.a(this.e, this.f) && this.m) ? false : true;
    }
}
