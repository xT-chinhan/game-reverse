package com.byazt.ei;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.hb.uc;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.ww;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.xt.RewardFullBaseLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 13})
public class hw implements pr {
    public TranslateAnimation a;
    public int aj;
    public TextView c;
    public int fw;
    public int g;
    public hn hn;
    public LinearLayout ho;
    public final pr.InterfaceC0053pr hw;
    public TextView k;
    public LinearLayout lb;
    public TextView m;
    public boolean nt;
    public LinearLayout qa;
    public int uc;
    public int vk;
    public int w;
    public SmallSlideView yb;
    public int zo;
    public final AtomicBoolean pr = new AtomicBoolean(false);
    public boolean x = true;
    public boolean cz = false;
    public boolean ny = false;
    public boolean fo = false;

    public hw(pr.InterfaceC0053pr interfaceC0053pr) {
        this.hw = interfaceC0053pr;
    }

    @Override // com.byazt.ei.pr
    public void pr(hn hnVar, int i, x xVar) {
        of ofVar = null;
        try {
            JSONArray jSONArray = new JSONArray(this.hw.hn().kq());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                of ofVarPr = com.byazt.sd.pr.pr(jSONArray.getJSONObject(i2));
                if (pr(ofVarPr, i)) {
                    try {
                        jSONArray.remove(i2);
                        ofVarPr.qn(jSONArray.toString());
                        ofVar = ofVarPr;
                        break;
                    } catch (JSONException e) {
                        ofVar = ofVarPr;
                    }
                }
            }
        } catch (JSONException e2) {
        }
        if (ofVar != null) {
            if (i == 1 && xVar != null && xVar.pr) {
                if (!this.ny) {
                    this.hw.pr(i, xVar.hw);
                    return;
                }
                return;
            }
            if (i == 2 && xVar != null && xVar.pr) {
                if (!this.fo) {
                    this.hw.pr(i, xVar.hw);
                    return;
                }
                return;
            }
            if (i == 3 && xVar != null && xVar.pr) {
                if (!this.cz) {
                    this.hw.pr(i, xVar.hw);
                    return;
                }
                return;
            }
            com.byazt.qe.hw hwVarPr = com.byazt.bv.pr.pr().pr(ofVar, ls.pr(ofVar, ""));
            if (this.hw.hw()) {
                com.byazt.joa.hn hnVar2 = new com.byazt.joa.hn(a.getContext(), ofVar, hwVarPr);
                hnVar2.pr(hnVar);
                hnVar2.pr(this.hw.getActivity());
            } else {
                com.byazt.joa.hw hwVar = new com.byazt.joa.hw(a.getContext(), ofVar, hwVarPr);
                hwVar.pr(hnVar);
                hwVar.pr(this.hw.getActivity());
            }
            this.pr.set(true);
        }
    }

    private boolean pr(of ofVar, int i) {
        switch (i) {
            case 1:
                return ww.pr(this.hw.hw(), ofVar, true);
            case 2:
                if (ww.pr(ofVar, true)) {
                    return true;
                }
                return false;
            case 3:
                if (ww.hw(ofVar, true)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override // com.byazt.ei.pr
    public void pr(hn hnVar) {
        this.hn = hnVar;
    }

    @Override // com.byazt.ei.pr
    public int pr() {
        hn hnVar = this.hn;
        if (hnVar != null) {
            return Math.max(0, hnVar.hw() - this.hn.hn());
        }
        return 0;
    }

    @Override // com.byazt.ei.pr
    public void pr(boolean z) {
        this.x = z;
    }

    @Override // com.byazt.ei.pr
    public int hw() {
        hn hnVar = this.hn;
        if (hnVar != null) {
            return hnVar.fw();
        }
        return 0;
    }

    @Override // com.byazt.ei.pr
    public int pr(int i, boolean z) {
        if (!this.x || pr(i)) {
            return 0;
        }
        if (i == 1) {
            if (ww.pr(this.hw.hn()) != 1) {
                return 0;
            }
            if (!z) {
                if (!ww.pr(this.hw.hw(), x() ? this.hw.x() : of.hn(this.hw.hn()), this.hw.c())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (ww.hw(this.hw.hn()) != 1) {
                return 0;
            }
            if (!z && this.hw.fw() && ww.m() == 0) {
                return 0;
            }
            if (ww.m() == 1) {
                if (this.nt) {
                    return 0;
                }
                if (this.hw.aj()) {
                    if (this.hw.zo()) {
                        return i;
                    }
                    return 0;
                }
            }
            if (z || ww.pr(this.hw.c(), this.hw.hn(), this.hw.hw())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || ww.hn(this.hw.hn()) != 1 || this.hw.zo()) {
            return 0;
        }
        if (z || ww.pr(this.hw.c(), this.hw.hn())) {
            return i;
        }
        return 0;
    }

    @Override // com.byazt.ei.pr
    public boolean pr(int i) {
        if (!this.hw.aj()) {
            return false;
        }
        if (jn.ve(this.hw.hn()) == uc.c) {
            return true;
        }
        return jn.ve(this.hw.hn()) == uc.uc && !this.hw.zo();
    }

    @Override // com.byazt.ei.pr
    public void pr(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.c == null) {
            this.c = er.ho(this.hw.getActivity());
        }
        if (this.c.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        this.uc = ww.zo() * 2;
        frameLayout.addView(this.c);
        zo();
    }

    @Override // com.byazt.ei.pr
    public void pr(int i, int i2, int i3) {
        switch (i) {
            case -1:
            case 1:
            case 2:
                hw(i, i2, i3);
                break;
            case 3:
                vk();
                break;
        }
    }

    private void vk() {
        String str;
        this.fw = this.hw.c() + (ww.aj() / 1000);
        this.lb = new LinearLayout(this.hw.getActivity());
        int iHn = er.hn(this.hw.getActivity(), 10.0f);
        this.lb.setPadding(iHn, iHn, iHn, iHn);
        this.lb.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.byazt.rc.pr.hw().pr(this.hw.getActivity(), 12.0f));
        this.lb.setBackground(gradientDrawable);
        this.yb = new SmallSlideView(this.hw.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(er.hn(this.hw.getActivity(), 80.0f), er.hn(this.hw.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.lb.addView(this.yb, layoutParams);
        TextView textView = new TextView(this.hw.getActivity());
        if (ww.vk() > 0) {
            str = "上滑继续观看\n提前" + ww.vk() + "秒领奖";
        } else {
            str = "上滑继续观看\n才能领奖哦";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.lb.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(er.hn(this.hw.getActivity(), 160.0f), er.hn(this.hw.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.hw.pr().addView(this.lb, layoutParams2);
        this.qa = new LinearLayout(this.hw.getActivity());
        ImageView imageView = new ImageView(this.hw.getActivity());
        g.pr((Context) this.hw.getActivity(), "tt_ic_back_light", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = er.hn(this.hw.getActivity(), 10.0f);
        layoutParams3.bottomMargin = er.hn(this.hw.getActivity(), 10.0f);
        this.qa.addView(imageView, layoutParams3);
        this.hw.pr().getSceneFrameContainer().setClipChildren(false);
        this.qa.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.hw.pr().getSceneFrameContainer().addView(this.qa, layoutParams4);
        this.cz = true;
        this.qa.post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.byazt.ei.hw$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hw.this.hw.pr().pr(new RewardFullBaseLayout.pr() { // from class: com.byazt.ei.hw.1.1
                @Override // com.byazt.xt.RewardFullBaseLayout.pr
                public void pr() {
                    x xVar = new x();
                    xVar.pr = false;
                    xVar.hn = true;
                    xVar.x = true;
                    hw.this.hw.pr().pr();
                    hw.this.hw.getActivity().pr(3, xVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) hw.this.qa.getLayoutParams();
            layoutParams.bottomMargin = -hw.this.qa.getMeasuredHeight();
            hw.this.qa.setLayoutParams(layoutParams);
            hw.this.qa.setVisibility(0);
            hw.this.a = new TranslateAnimation(0.0f, 0.0f, 0.0f, -hw.this.qa.getMeasuredHeight());
            hw.this.a.setDuration(300L);
            hw.this.a.setRepeatCount(3);
            hw.this.a.setRepeatMode(2);
            hw.this.a.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.ei.hw.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    hw.this.yb.pr();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (hw.this.cz) {
                        hw.this.qa.postDelayed(new Runnable() { // from class: com.byazt.ei.hw.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (hw.this.cz && hw.this.a != null) {
                                    hw.this.hw.pr().getSceneFrameContainer().startAnimation(hw.this.a);
                                }
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (hw.this.a != null) {
                hw.this.hw.pr().getSceneFrameContainer().startAnimation(hw.this.a);
            }
        }
    }

    private void hw(final int i, int i2, int i3) {
        if (i == 1) {
            this.zo = i2;
        } else if (i == 2) {
            i2++;
            this.aj = i2;
        } else if (i != -1) {
            i2 = 0;
        } else {
            this.vk = i2;
            if (i3 > 0) {
                this.w = i3;
                return;
            }
            this.w = 0;
        }
        LinearLayout linearLayout = this.ho;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.hw.getActivity());
            this.ho = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.ho.setOrientation(0);
            this.ho.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.hw.getActivity().getWindow().getDecorView()).addView(this.ho, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.hw.getActivity());
        this.k = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.k.setText(String.valueOf(i2));
        this.k.setTypeface(Typeface.DEFAULT_BOLD);
        this.k.setTextSize(2, 14.0f);
        this.ho.addView(this.k);
        TextView textView2 = new TextView(this.hw.getActivity());
        this.m = textView2;
        textView2.setTextColor(-1);
        this.m.setTypeface(Typeface.DEFAULT_BOLD);
        this.m.setSingleLine();
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setText(ww.uc(this.hw.hn()));
        this.m.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(er.hn(this.hw.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.ho.addView(this.m, layoutParams2);
        TextView textView3 = new TextView(this.hw.getActivity());
        textView3.setText("取消");
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ei.hw.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                hw.this.nt = true;
                int i5 = i;
                if (i5 == 1) {
                    hw.this.zo = 0;
                } else if (i5 == 2) {
                    hw.this.aj = 0;
                    hw.this.g = 0;
                } else if (i5 == -1) {
                    hw.this.vk = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                } catch (JSONException e) {
                }
                com.byazt.xk.hw.pr().pr(hw.this.hw.hn(), "stats_switch_tip_cancel", jSONObject);
                hw.this.uc();
                hw.this.hw.vk();
            }
        });
        this.ho.addView(textView3);
        this.ho.setPadding(er.hn(this.hw.getActivity(), 20.0f), er.hn(this.hw.getActivity(), 16.0f), er.hn(this.hw.getActivity(), 20.0f), er.nt(this.hw.getActivity()));
        this.ho.setClickable(false);
        if (i == 1) {
            this.ny = true;
        } else if (i == 2) {
            this.fo = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, er.hn(this.hw.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.ho.startAnimation(translateAnimation);
    }

    @Override // com.byazt.ei.pr
    public void hn() {
        if (ww.m() == 1 && this.fo && this.k != null && this.m != null && !TextUtils.isEmpty(ww.w())) {
            this.k.setText("");
            this.m.setText(ww.w());
            int iK = ww.k();
            this.g = iK;
            if (iK == 0) {
                this.aj = 0;
                uc();
            }
        }
        if (!this.cz || !pr(3)) {
            return;
        }
        SmallSlideView smallSlideView = this.yb;
        if (smallSlideView != null) {
            smallSlideView.hw();
        }
        TranslateAnimation translateAnimation = this.a;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        LinearLayout linearLayout = this.lb;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            this.hw.pr().removeView(this.lb);
        }
        LinearLayout linearLayout2 = this.qa;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
            this.hw.pr().getSceneFrameContainer().removeView(this.qa);
        }
        this.hw.pr().pr();
        this.hw.pr(3);
        this.cz = false;
    }

    @Override // com.byazt.ei.pr
    public boolean x() {
        return this.hn != null;
    }

    @Override // com.byazt.ei.pr
    public boolean c() {
        return this.pr.get();
    }

    @Override // com.byazt.ei.pr
    public void fw() {
        int i;
        int i2;
        if (pr(3)) {
            return;
        }
        if (this.fw > 0 && this.hw.c() >= this.fw) {
            this.fw = 0;
            x xVar = new x();
            xVar.pr = false;
            xVar.hn = false;
            xVar.x = true;
            this.hw.getActivity().pr(3, xVar);
        }
        if (this.k != null && (i2 = this.zo) > 0) {
            this.zo = Math.max(0, i2 - 1);
            this.k.setText(new StringBuilder().append(this.zo).toString());
            if (this.zo == 0) {
                x xVar2 = new x();
                xVar2.pr = false;
                xVar2.hn = false;
                xVar2.x = true;
                this.hw.getActivity().pr(1, xVar2);
                uc();
            }
        }
        if (this.k != null) {
            if (ww.m() == 1 && ww.pr(this.hw.hn()) != 1 && !this.nt && this.hw.aj() && this.hw.zo()) {
                x xVar3 = new x();
                xVar3.pr = false;
                xVar3.hn = false;
                xVar3.x = true;
                this.hw.getActivity().pr(2, xVar3);
            }
            if (this.aj > 0 || this.g > 0) {
                if (ww.m() == 1) {
                    if (this.hw.aj()) {
                        int iMax = Math.max(0, this.g - 1);
                        this.g = iMax;
                        if (iMax == 0) {
                            uc();
                        }
                    } else {
                        this.aj = Math.max(0, this.aj - 1);
                        this.k.setText(new StringBuilder().append(this.aj).toString());
                        if (this.aj == 0) {
                            x xVar4 = new x();
                            xVar4.pr = false;
                            xVar4.hn = false;
                            xVar4.x = true;
                            this.hw.getActivity().pr(2, xVar4);
                            uc();
                        }
                    }
                } else {
                    this.aj = Math.max(0, this.aj - 1);
                    this.k.setText(new StringBuilder().append(this.aj).toString());
                    if (this.aj == 0) {
                        x xVar5 = new x();
                        xVar5.pr = false;
                        xVar5.hn = false;
                        xVar5.x = true;
                        this.hw.getActivity().pr(2, xVar5);
                        uc();
                    }
                }
            }
        }
        int i3 = this.w;
        if (i3 > 0) {
            int iMax2 = Math.max(0, i3 - 1);
            this.w = iMax2;
            if (iMax2 == 0) {
                this.hw.pr(-1, this.vk);
                return;
            }
            return;
        }
        if (this.k != null && (i = this.vk) > 0) {
            this.vk = Math.max(0, i - 1);
            this.k.setText(new StringBuilder().append(this.vk).toString());
            if (this.vk == 0) {
                uc();
                this.k = null;
                this.hw.w();
            }
        }
    }

    public void zo() {
        int iUc = this.hw.uc();
        String strConcat = "继续看" + iUc + "秒可领取奖励";
        hn hnVar = this.hn;
        if (hnVar != null) {
            if (hnVar.hn() > 0) {
                strConcat = iUc <= 0 ? "成功加速" + this.hn.hn() + "秒，奖励已下发" : "加速成功！".concat(String.valueOf(strConcat));
            } else if (iUc <= 0) {
                aj();
                return;
            }
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(strConcat);
        }
        int i = this.uc;
        if (i <= 0) {
            aj();
            return;
        }
        this.uc = i - 1;
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.byazt.ei.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.zo();
                }
            }, 500L);
        }
    }

    public void aj() {
        TextView textView = this.c;
        if (textView != null && textView.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
            this.c = null;
        }
    }

    @Override // com.byazt.ei.pr
    public void uc() {
        if (this.ho != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.ei.hw.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    hw.this.ho.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ho.startAnimation(alphaAnimation);
        }
    }

    @Override // com.byazt.ei.pr
    public void hw(boolean z) {
        this.w = 0;
        if (z) {
            this.vk = 0;
        }
    }
}
