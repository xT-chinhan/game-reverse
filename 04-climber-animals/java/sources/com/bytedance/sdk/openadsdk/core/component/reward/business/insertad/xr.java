package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.of;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms {
    private int ab;
    private ah ah;
    private int c;
    private LinearLayout ch;
    private SmallSlideView hi;
    private TextView ka;
    private TextView ny;
    private LinearLayout sl;
    private TranslateAnimation u;
    private int x;
    private final ms.InterfaceC0269ms xr;
    private LinearLayout zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final AtomicBoolean f2108ms = new AtomicBoolean(false);
    private boolean d = true;
    private boolean ub = false;
    private boolean ao = false;

    public xr(ms.InterfaceC0269ms interfaceC0269ms) {
        this.xr = interfaceC0269ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void ms(ah ahVar, int i, d dVar) {
        lm lmVar = null;
        try {
            JSONArray jSONArray = new JSONArray(this.xr.ah().sd());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(jSONArray.getJSONObject(i2));
                if (ms(lmVarMs, i)) {
                    try {
                        jSONArray.remove(i2);
                        lmVarMs.f(jSONArray.toString());
                        lmVar = lmVarMs;
                        break;
                    } catch (JSONException e) {
                        e = e;
                        lmVar = lmVarMs;
                        sl.ms(e);
                    }
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
        if (lmVar != null) {
            if (i == 1 && dVar != null && dVar.f2107ms) {
                if (this.ao) {
                    return;
                }
                this.xr.ms(i);
                return;
            }
            if (i == 3 && dVar != null && dVar.f2107ms) {
                if (this.ub) {
                    return;
                }
                this.xr.ms(i);
                return;
            }
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().ms(f.ms(lmVar, ""));
            if (this.xr.xr()) {
                com.bytedance.sdk.openadsdk.core.component.reward.ah ahVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.ah(re.getContext(), lmVar, xrVarMs);
                ahVar2.ms(ahVar);
                ahVar2.ms(this.xr.getActivity());
            } else {
                com.bytedance.sdk.openadsdk.core.component.reward.xr xrVar = new com.bytedance.sdk.openadsdk.core.component.reward.xr(re.getContext(), lmVar, xrVarMs);
                xrVar.ms(ahVar);
                xrVar.ms(this.xr.getActivity());
            }
            this.f2108ms.set(true);
        }
    }

    private boolean ms(lm lmVar, int i) {
        if (i == 1) {
            return of.ms(this.xr.xr(), lmVar, true);
        }
        if (i != 2) {
            return i == 3 && of.xr(lmVar, true);
        }
        return of.ms(lmVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void ms(ah ahVar) {
        this.ah = ahVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public int ms() {
        ah ahVar = this.ah;
        if (ahVar != null) {
            return Math.max(0, ahVar.xr() - this.ah.ah());
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void ms(boolean z) {
        this.d = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public int xr() {
        ah ahVar = this.ah;
        if (ahVar != null) {
            return ahVar.x();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public int ms(int i, boolean z) {
        if (!this.d || ms(i)) {
            return 0;
        }
        if (i == 1) {
            if (of.ms(this.xr.ah()) != 1) {
                return 0;
            }
            if (!z) {
                if (!of.ms(this.xr.xr(), d() ? this.xr.d() : lm.xr(this.xr.ah()), this.xr.c())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (of.xr(this.xr.ah()) != 1 || this.xr.x()) {
                return 0;
            }
            if (z || of.ms(this.xr.ka(), this.xr.ah())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || of.ah(this.xr.ah()) != 1 || this.xr.ny()) {
            return 0;
        }
        if (z || of.xr(this.xr.c(), this.xr.ah())) {
            return i;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public boolean ms(int i) {
        if (this.xr.ch()) {
            return qf.op(this.xr.ah()) == com.bytedance.sdk.openadsdk.core.x.d.ab || (qf.op(this.xr.ah()) == com.bytedance.sdk.openadsdk.core.x.d.x && !this.xr.ny());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void ms(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.ka == null) {
            this.ka = ul.h(this.xr.getActivity());
        }
        if (this.ka.getParent() != null) {
            ((ViewGroup) this.ka.getParent()).removeView(this.ka);
        }
        this.c = of.x() * 2;
        frameLayout.addView(this.ka);
        ab();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void xr(int i) {
        if (i == 1) {
            hi();
        } else {
            if (i != 3) {
                return;
            }
            ch();
        }
    }

    private void ch() {
        this.ab = this.xr.c() + (of.ny() / 1000);
        this.sl = new LinearLayout(this.xr.getActivity());
        int iAh = ul.ah(this.xr.getActivity(), 10.0f);
        this.sl.setPadding(iAh, iAh, iAh, iAh);
        this.sl.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(this.xr.getActivity(), 12.0f));
        this.sl.setBackground(gradientDrawable);
        this.hi = new SmallSlideView(this.xr.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ul.ah(this.xr.getActivity(), 80.0f), ul.ah(this.xr.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.sl.addView(this.hi, layoutParams);
        TextView textView = new TextView(this.xr.getActivity());
        textView.setText(of.ch() > 0 ? "上滑继续观看\n提前" + of.ch() + "秒领奖" : "上滑继续观看\n才能领奖哦");
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.sl.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ul.ah(this.xr.getActivity(), 160.0f), ul.ah(this.xr.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.xr.ms().addView(this.sl, layoutParams2);
        this.zb = new LinearLayout(this.xr.getActivity());
        ImageView imageView = new ImageView(this.xr.getActivity());
        t.ms((Context) this.xr.getActivity(), "tt_ic_back_light", imageView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = ul.ah(this.xr.getActivity(), 10.0f);
        layoutParams3.bottomMargin = ul.ah(this.xr.getActivity(), 10.0f);
        this.zb.addView(imageView, layoutParams3);
        this.xr.ms().getSceneFrameContainer().setClipChildren(false);
        this.zb.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.xr.ms().getSceneFrameContainer().addView(this.zb, layoutParams4);
        this.ub = true;
        this.zb.post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xr.this.xr.ms().ms(new RewardFullBaseLayout.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.1.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout.ms
                public void ms() {
                    d dVar = new d();
                    dVar.f2107ms = false;
                    dVar.xr = true;
                    dVar.ah = true;
                    xr.this.xr.ms().ms();
                    xr.this.xr.getActivity().ms(3, dVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) xr.this.zb.getLayoutParams();
            layoutParams.bottomMargin = -xr.this.zb.getMeasuredHeight();
            xr.this.zb.setLayoutParams(layoutParams);
            xr.this.zb.setVisibility(0);
            xr.this.u = new TranslateAnimation(0.0f, 0.0f, 0.0f, -xr.this.zb.getMeasuredHeight());
            xr.this.u.setDuration(300L);
            xr.this.u.setRepeatCount(3);
            xr.this.u.setRepeatMode(2);
            xr.this.u.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    xr.this.hi.ms();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (xr.this.ub) {
                        xr.this.zb.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (xr.this.ub && xr.this.u != null) {
                                    xr.this.xr.ms().getSceneFrameContainer().startAnimation(xr.this.u);
                                }
                            }
                        }, a.f);
                    }
                }
            });
            if (xr.this.u != null) {
                xr.this.xr.ms().getSceneFrameContainer().startAnimation(xr.this.u);
            }
        }
    }

    private void hi() {
        this.x = of.ms(this.xr.xr());
        LinearLayout linearLayout = new LinearLayout(this.xr.getActivity());
        this.ch = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor("#f0161823"));
        this.ch.setOrientation(0);
        this.ch.setGravity(16);
        TextView textView = new TextView(this.xr.getActivity());
        this.ny = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.ny.setText(new StringBuilder().append(this.x).toString());
        this.ny.setTypeface(Typeface.DEFAULT_BOLD);
        this.ny.setTextSize(2, 14.0f);
        this.ch.addView(this.ny);
        TextView textView2 = new TextView(this.xr.getActivity());
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setText("秒后将继续播放下一条广告");
        textView2.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.setMargins(ul.ah(this.xr.getActivity(), 4.0f), 0, 0, 0);
        layoutParams.weight = 1.0f;
        this.ch.addView(textView2, layoutParams);
        TextView textView3 = new TextView(this.xr.getActivity());
        textView3.setText("取消");
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.this.x = 0;
                xr.this.ny();
            }
        });
        this.ch.addView(textView3);
        this.ch.setPadding(ul.ah(this.xr.getActivity(), 20.0f), ul.ah(this.xr.getActivity(), 16.0f), ul.ah(this.xr.getActivity(), 20.0f), ul.qv(this.xr.getActivity()));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        this.ch.setClickable(false);
        this.ao = true;
        ((ViewGroup) this.xr.getActivity().getWindow().getDecorView()).addView(this.ch, layoutParams2);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, ul.ah(this.xr.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.ch.startAnimation(translateAnimation);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void ah() {
        if (this.ub && ms(3)) {
            SmallSlideView smallSlideView = this.hi;
            if (smallSlideView != null) {
                smallSlideView.xr();
            }
            TranslateAnimation translateAnimation = this.u;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.sl;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.xr.ms().removeView(this.sl);
            }
            LinearLayout linearLayout2 = this.zb;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.xr.ms().getSceneFrameContainer().removeView(this.zb);
            }
            this.xr.ms().ms();
            this.xr.xr(3);
            this.ub = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public boolean d() {
        return this.ah != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public boolean ka() {
        return this.f2108ms.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms
    public void c() {
        int i;
        if (ms(3)) {
            return;
        }
        if (this.ab > 0 && this.xr.c() >= this.ab) {
            this.ab = 0;
            d dVar = new d();
            dVar.f2107ms = false;
            dVar.xr = false;
            dVar.ah = true;
            this.xr.getActivity().ms(3, dVar);
        }
        if (this.ny == null || (i = this.x) <= 0) {
            return;
        }
        this.x = Math.max(0, i - 1);
        this.ny.setText(new StringBuilder().append(this.x).toString());
        if (this.x == 0) {
            d dVar2 = new d();
            dVar2.f2107ms = false;
            dVar2.xr = false;
            dVar2.ah = true;
            this.xr.getActivity().ms(1, dVar2);
            ny();
        }
    }

    public void ab() {
        int iAb = this.xr.ab();
        String strConcat = "继续看" + iAb + "秒可领取奖励";
        if (this.ah.ah() > 0) {
            if (iAb <= 0) {
                strConcat = "成功加速" + this.ah.ah() + "秒，奖励已下发";
            } else {
                strConcat = "加速成功！".concat(String.valueOf(strConcat));
            }
        } else if (iAb <= 0) {
            x();
            return;
        }
        this.ka.setText(strConcat);
        int i = this.c;
        if (i <= 0) {
            x();
            return;
        }
        this.c = i - 1;
        TextView textView = this.ka;
        if (textView != null) {
            textView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.3
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.ab();
                }
            }, 500L);
        }
    }

    public void x() {
        TextView textView = this.ka;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.ka.getParent()).removeView(this.ka);
        this.ka = null;
    }

    public void ny() {
        if (this.ch != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ((ViewGroup) xr.this.xr.getActivity().getWindow().getDecorView()).removeView(xr.this.ch);
                }
            });
            this.ch.startAnimation(alphaAnimation);
        }
    }
}
