package com.byazt.aq;

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
import com.byazt.gct.cx;
import com.byazt.gct.j;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.rv.l;
import com.byazt.tk.sz;
import com.byazt.tkz.RewardFullBaseLayout;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 26})
public class qg implements n {
    public TranslateAnimation a;
    public LinearLayout cd;
    public int cp;
    public boolean cy;
    public TextView d;
    public int fs;
    public SmallSlideView hd;
    public LinearLayout k;
    public TextView l;
    public TextView oa;
    public final n.InterfaceC0124n qg;
    public int rv;
    public s s;
    public int sz;
    public int tj;
    public LinearLayout um;
    public int w;
    public int x;
    public final AtomicBoolean n = new AtomicBoolean(false);
    public boolean q = true;
    public boolean py = false;
    public boolean ou = false;
    public boolean wm = false;

    public qg(n.InterfaceC0124n interfaceC0124n) {
        this.qg = interfaceC0124n;
    }

    @Override // com.byazt.aq.n
    public void n(s sVar, int i, q qVar) {
        pk pkVar = null;
        try {
            JSONArray jSONArray = new JSONArray(this.qg.s().hj());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                pk pkVarN = com.byazt.vgx.qg.n(jSONArray.getJSONObject(i2));
                if (n(pkVarN, i)) {
                    try {
                        jSONArray.remove(i2);
                        pkVarN.pk(jSONArray.toString());
                    } catch (JSONException unused) {
                    }
                    pkVar = pkVarN;
                    break;
                }
            }
        } catch (JSONException unused2) {
        }
        if (pkVar != null) {
            if (i == 1 && qVar != null && qVar.n) {
                if (this.ou) {
                    return;
                }
                this.qg.n(i, qVar.qg);
                return;
            }
            if (i == 2 && qVar != null && qVar.n) {
                if (this.wm) {
                    return;
                }
                this.qg.n(i, qVar.qg);
                return;
            }
            if (i == 3 && qVar != null && qVar.n) {
                if (this.py) {
                    return;
                }
                this.qg.n(i, qVar.qg);
                return;
            }
            com.byazt.zq.qg qgVarN = com.byazt.tf.n.n().n(pkVar, w.n(pkVar, ""));
            if (this.qg.qg()) {
                l lVar = new l(rv.getContext(), pkVar, qgVarN);
                lVar.n(sVar);
                lVar.n(this.qg.getActivity());
            } else {
                com.byazt.rv.q qVar2 = new com.byazt.rv.q(rv.getContext(), pkVar, qgVarN);
                qVar2.n(sVar);
                qVar2.n(this.qg.getActivity());
            }
            this.n.set(true);
        }
    }

    private boolean n(pk pkVar, int i) {
        if (i == 1) {
            return j.n(this.qg.qg(), pkVar, true);
        }
        if (i != 2) {
            return i == 3 && j.qg(pkVar, true);
        }
        return j.n(pkVar, true);
    }

    @Override // com.byazt.aq.n
    public void n(s sVar) {
        this.s = sVar;
    }

    @Override // com.byazt.aq.n
    public int n() {
        s sVar = this.s;
        if (sVar != null) {
            return Math.max(0, sVar.qg() - this.s.s());
        }
        return 0;
    }

    @Override // com.byazt.aq.n
    public void n(boolean z) {
        this.q = z;
    }

    @Override // com.byazt.aq.n
    public int qg() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.x();
        }
        return 0;
    }

    @Override // com.byazt.aq.n
    public int n(int i, boolean z) {
        if (!this.q || n(i)) {
            return 0;
        }
        if (i == 1) {
            if (j.n(this.qg.s()) != 1) {
                return 0;
            }
            if (!z) {
                if (!j.n(this.qg.qg(), q() ? this.qg.q() : pk.s(this.qg.s()), this.qg.l())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (j.qg(this.qg.s()) != 1) {
                return 0;
            }
            if (!z && this.qg.x() && j.oa() == 0) {
                return 0;
            }
            if (j.oa() == 1) {
                if (this.cy) {
                    return 0;
                }
                if (this.qg.rv()) {
                    if (this.qg.fs()) {
                        return i;
                    }
                    return 0;
                }
            }
            if (z || j.n(this.qg.l(), this.qg.s(), this.qg.qg())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || j.s(this.qg.s()) != 1 || this.qg.fs()) {
            return 0;
        }
        if (z || j.n(this.qg.l(), this.qg.s())) {
            return i;
        }
        return 0;
    }

    @Override // com.byazt.aq.n
    public boolean n(int i) {
        if (this.qg.rv()) {
            return cx.ur(this.qg.s()) == com.byazt.rv.s.l || (cx.ur(this.qg.s()) == com.byazt.rv.s.w && !this.qg.fs());
        }
        return false;
    }

    @Override // com.byazt.aq.n
    public void n(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.l == null) {
            this.l = com.byazt.okk.s.k(this.qg.getActivity());
        }
        if (this.l.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        this.w = j.fs() * 2;
        frameLayout.addView(this.l);
        fs();
    }

    @Override // com.byazt.aq.n
    public void n(int i, int i2, int i3) {
        if (i == -1 || i == 1 || i == 2) {
            qg(i, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            tj();
        }
    }

    private void tj() {
        this.x = this.qg.l() + (j.rv() / 1000);
        this.cd = new LinearLayout(this.qg.getActivity());
        int iS = com.byazt.okk.s.s(this.qg.getActivity(), 10.0f);
        this.cd.setPadding(iS, iS, iS, iS);
        this.cd.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.byazt.nnl.n.qg().n(this.qg.getActivity(), 12.0f));
        this.cd.setBackground(gradientDrawable);
        this.hd = new SmallSlideView(this.qg.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.qg.getActivity(), 80.0f), com.byazt.okk.s.s(this.qg.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.cd.addView(this.hd, layoutParams);
        TextView textView = new TextView(this.qg.getActivity());
        textView.setText(j.tj() > 0 ? "上滑继续观看\n提前" + j.tj() + "秒领奖" : "上滑继续观看\n才能领奖哦");
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.cd.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.byazt.okk.s.s(this.qg.getActivity(), 160.0f), com.byazt.okk.s.s(this.qg.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.qg.n().addView(this.cd, layoutParams2);
        this.um = new LinearLayout(this.qg.getActivity());
        ImageView imageView = new ImageView(this.qg.getActivity());
        sz.n((Context) this.qg.getActivity(), "tt_ic_back_light", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.byazt.okk.s.s(this.qg.getActivity(), 10.0f);
        layoutParams3.bottomMargin = com.byazt.okk.s.s(this.qg.getActivity(), 10.0f);
        this.um.addView(imageView, layoutParams3);
        this.qg.n().getSceneFrameContainer().setClipChildren(false);
        this.um.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.qg.n().getSceneFrameContainer().addView(this.um, layoutParams4);
        this.py = true;
        this.um.post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.byazt.aq.qg$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 51})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qg.this.qg.n().n(new RewardFullBaseLayout.n() { // from class: com.byazt.aq.qg.1.1
                @Override // com.byazt.tkz.RewardFullBaseLayout.n
                public void n() {
                    q qVar = new q();
                    qVar.n = false;
                    qVar.s = true;
                    qVar.q = true;
                    qg.this.qg.n().n();
                    qg.this.qg.getActivity().n(3, qVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) qg.this.um.getLayoutParams();
            layoutParams.bottomMargin = -qg.this.um.getMeasuredHeight();
            qg.this.um.setLayoutParams(layoutParams);
            qg.this.um.setVisibility(0);
            qg.this.a = new TranslateAnimation(0.0f, 0.0f, 0.0f, -qg.this.um.getMeasuredHeight());
            qg.this.a.setDuration(300L);
            qg.this.a.setRepeatCount(3);
            qg.this.a.setRepeatMode(2);
            qg.this.a.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.aq.qg.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    qg.this.hd.n();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (qg.this.py) {
                        qg.this.um.postDelayed(new Runnable() { // from class: com.byazt.aq.qg.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (qg.this.py && qg.this.a != null) {
                                    qg.this.qg.n().getSceneFrameContainer().startAnimation(qg.this.a);
                                }
                            }
                        }, 2000L);
                    }
                }
            });
            if (qg.this.a != null) {
                qg.this.qg.n().getSceneFrameContainer().startAnimation(qg.this.a);
            }
        }
    }

    private void qg(final int i, int i2, int i3) {
        if (i == 1) {
            this.fs = i2;
        } else if (i == 2) {
            i2++;
            this.rv = i2;
        } else if (i == -1) {
            this.tj = i2;
            if (i3 > 0) {
                this.cp = i3;
                return;
            }
            this.cp = 0;
        } else {
            i2 = 0;
        }
        LinearLayout linearLayout = this.k;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.qg.getActivity());
            this.k = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.k.setOrientation(0);
            this.k.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.qg.getActivity().getWindow().getDecorView()).addView(this.k, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.qg.getActivity());
        this.d = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.d.setText(String.valueOf(i2));
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
        this.d.setTextSize(2, 14.0f);
        this.k.addView(this.d);
        TextView textView2 = new TextView(this.qg.getActivity());
        this.oa = textView2;
        textView2.setTextColor(-1);
        this.oa.setTypeface(Typeface.DEFAULT_BOLD);
        this.oa.setSingleLine();
        this.oa.setEllipsize(TextUtils.TruncateAt.END);
        this.oa.setText(j.w(this.qg.s()));
        this.oa.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(com.byazt.okk.s.s(this.qg.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.k.addView(this.oa, layoutParams2);
        TextView textView3 = new TextView(this.qg.getActivity());
        textView3.setText("取消");
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.aq.qg.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                qg.this.cy = true;
                int i5 = i;
                if (i5 == 1) {
                    qg.this.fs = 0;
                } else if (i5 == 2) {
                    qg.this.rv = 0;
                    qg.this.sz = 0;
                } else if (i5 == -1) {
                    qg.this.tj = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                } catch (JSONException unused) {
                }
                com.byazt.eji.s.n().n(qg.this.qg.s(), "stats_switch_tip_cancel", jSONObject);
                qg.this.w();
                qg.this.qg.tj();
            }
        });
        this.k.addView(textView3);
        this.k.setPadding(com.byazt.okk.s.s(this.qg.getActivity(), 20.0f), com.byazt.okk.s.s(this.qg.getActivity(), 16.0f), com.byazt.okk.s.s(this.qg.getActivity(), 20.0f), com.byazt.okk.s.cy(this.qg.getActivity()));
        this.k.setClickable(false);
        if (i == 1) {
            this.ou = true;
        } else if (i == 2) {
            this.wm = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, com.byazt.okk.s.s(this.qg.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.k.startAnimation(translateAnimation);
    }

    @Override // com.byazt.aq.n
    public void s() {
        if (j.oa() == 1 && this.wm && this.d != null && this.oa != null && !TextUtils.isEmpty(j.cp())) {
            this.d.setText("");
            this.oa.setText(j.cp());
            int iD = j.d();
            this.sz = iD;
            if (iD == 0) {
                this.rv = 0;
                w();
            }
        }
        if (this.py && n(3)) {
            SmallSlideView smallSlideView = this.hd;
            if (smallSlideView != null) {
                smallSlideView.qg();
            }
            TranslateAnimation translateAnimation = this.a;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.cd;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.qg.n().removeView(this.cd);
            }
            LinearLayout linearLayout2 = this.um;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.qg.n().getSceneFrameContainer().removeView(this.um);
            }
            this.qg.n().n();
            this.qg.n(3);
            this.py = false;
        }
    }

    @Override // com.byazt.aq.n
    public boolean q() {
        return this.s != null;
    }

    @Override // com.byazt.aq.n
    public boolean l() {
        return this.n.get();
    }

    @Override // com.byazt.aq.n
    public void x() {
        int i;
        int i2;
        if (n(3)) {
            return;
        }
        if (this.x > 0 && this.qg.l() >= this.x) {
            this.x = 0;
            q qVar = new q();
            qVar.n = false;
            qVar.s = false;
            qVar.q = true;
            this.qg.getActivity().n(3, qVar);
        }
        if (this.d != null && (i2 = this.fs) > 0) {
            this.fs = Math.max(0, i2 - 1);
            this.d.setText(new StringBuilder().append(this.fs).toString());
            if (this.fs == 0) {
                q qVar2 = new q();
                qVar2.n = false;
                qVar2.s = false;
                qVar2.q = true;
                this.qg.getActivity().n(1, qVar2);
                w();
            }
        }
        if (this.d != null) {
            if (j.oa() == 1 && j.n(this.qg.s()) != 1 && !this.cy && this.qg.rv() && this.qg.fs()) {
                q qVar3 = new q();
                qVar3.n = false;
                qVar3.s = false;
                qVar3.q = true;
                this.qg.getActivity().n(2, qVar3);
            }
            if (this.rv > 0 || this.sz > 0) {
                if (j.oa() == 1) {
                    if (this.qg.rv()) {
                        int iMax = Math.max(0, this.sz - 1);
                        this.sz = iMax;
                        if (iMax == 0) {
                            w();
                        }
                    } else {
                        this.rv = Math.max(0, this.rv - 1);
                        this.d.setText(new StringBuilder().append(this.rv).toString());
                        if (this.rv == 0) {
                            q qVar4 = new q();
                            qVar4.n = false;
                            qVar4.s = false;
                            qVar4.q = true;
                            this.qg.getActivity().n(2, qVar4);
                            w();
                        }
                    }
                } else {
                    this.rv = Math.max(0, this.rv - 1);
                    this.d.setText(new StringBuilder().append(this.rv).toString());
                    if (this.rv == 0) {
                        q qVar5 = new q();
                        qVar5.n = false;
                        qVar5.s = false;
                        qVar5.q = true;
                        this.qg.getActivity().n(2, qVar5);
                        w();
                    }
                }
            }
        }
        int i3 = this.cp;
        if (i3 > 0) {
            int iMax2 = Math.max(0, i3 - 1);
            this.cp = iMax2;
            if (iMax2 == 0) {
                this.qg.n(-1, this.tj);
                return;
            }
            return;
        }
        if (this.d == null || (i = this.tj) <= 0) {
            return;
        }
        this.tj = Math.max(0, i - 1);
        this.d.setText(new StringBuilder().append(this.tj).toString());
        if (this.tj == 0) {
            w();
            this.d = null;
            this.qg.cp();
        }
    }

    public void fs() {
        int iW = this.qg.w();
        String strConcat = "继续看" + iW + "秒可领取奖励";
        s sVar = this.s;
        if (sVar != null) {
            if (sVar.s() > 0) {
                strConcat = iW <= 0 ? "成功加速" + this.s.s() + "秒，奖励已下发" : "加速成功！".concat(String.valueOf(strConcat));
            } else if (iW <= 0) {
                rv();
                return;
            }
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(strConcat);
        }
        int i = this.w;
        if (i <= 0) {
            rv();
            return;
        }
        this.w = i - 1;
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.byazt.aq.qg.3
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.fs();
                }
            }, 500L);
        }
    }

    public void rv() {
        TextView textView = this.l;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.l.getParent()).removeView(this.l);
        this.l = null;
    }

    @Override // com.byazt.aq.n
    public void w() {
        if (this.k != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.aq.qg.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    qg.this.k.removeAllViews();
                }
            });
            this.k.startAnimation(alphaAnimation);
        }
    }

    @Override // com.byazt.aq.n
    public void qg(boolean z) {
        this.cp = 0;
        if (z) {
            this.tj = 0;
        }
    }
}
