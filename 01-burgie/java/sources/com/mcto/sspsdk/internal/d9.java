package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class d9 implements j7, View.OnClickListener {
    public final int a;
    public final ve b;
    public final int c;
    public final a d;
    public final re e;
    public final ConstraintLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final String i;
    public final String j;
    public final String k;
    public a9 l;
    public boolean m = false;
    public boolean n = false;
    public long o = 0;
    public final CountDownLatch p = new CountDownLatch(2);
    public AnimatorSet q;
    public AnimatorSet r;

    public d9(ve veVar, p pVar, int i, String str, a aVar, re reVar) {
        this.i = "https://pic1.iqiyipic.com/lequ/20241216/gift_box_title.png";
        this.j = "点击屏幕领取福利，%dcd过期";
        this.k = "https://pic1.iqiyipic.com/lequ/20241216/gift_box.png";
        c9 c9Var = new c9(this);
        this.b = veVar;
        this.c = aVar.d;
        this.e = reVar;
        this.d = aVar;
        if (!TextUtils.isEmpty(aVar.f)) {
            this.i = aVar.f;
        }
        String strOptString = null;
        if (i == 1 && !TextUtils.isEmpty(str)) {
            strOptString = "点击屏幕" + str;
        }
        if (TextUtils.isEmpty(strOptString)) {
            if (!TextUtils.isEmpty(aVar.h)) {
                strOptString = aVar.h;
            } else if (i == 1) {
                strOptString = pVar.i().optString("fullScreenAnimationTitle");
            }
        }
        if (!TextUtils.isEmpty(strOptString)) {
            this.j = strOptString;
        }
        if (!TextUtils.isEmpty(aVar.g)) {
            this.k = aVar.g;
        }
        if (!this.j.contains("%dcd") || aVar.c > 0) {
            this.a = aVar.c;
        } else {
            this.a = 999;
        }
        Context context = veVar.getContext();
        boolean z = context.getResources().getConfiguration().orientation == 2;
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        this.f = constraintLayout;
        constraintLayout.setId(R.id.qy_reward_interactive_container);
        constraintLayout.setBackgroundResource(R.color.qy_dialog_bg);
        constraintLayout.setOnClickListener(this);
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        linearLayout.setId(R.id.qy_reward_interactive_background);
        QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
        qYNiceImageView.a(c9Var);
        qYNiceImageView.a(this.i);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        qYNiceImageView.setScaleType(scaleType);
        qYNiceImageView.setId(R.id.qy_trueview_welfare_title);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ((context.getResources().getDisplayMetrics().density * 48.0f) + 0.5f));
        qYNiceImageView.setOnClickListener(this);
        linearLayout.addView(qYNiceImageView, layoutParams);
        TextView textView = new TextView(context);
        this.h = textView;
        textView.setText(this.j.replace("%dcd", this.a + "s后"));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setId(R.id.qy_trueview_welfare_sub_title);
        textView.setSingleLine(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) ((context.getResources().getDisplayMetrics().density * 17.0f) + 0.5f));
        if (z) {
            layoutParams2.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f);
        } else {
            layoutParams2.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
            layoutParams2.bottomMargin = (int) ((context.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
        }
        textView.setOnClickListener(this);
        linearLayout.addView(textView, layoutParams2);
        QYNiceImageView qYNiceImageView2 = new QYNiceImageView(context);
        qYNiceImageView2.a(c9Var);
        qYNiceImageView2.a(this.k);
        qYNiceImageView2.setScaleType(scaleType);
        qYNiceImageView2.setId(R.id.qy_trueview_welfare_logo);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, (int) (((z ? 200.0f : 265.0f) * context.getResources().getDisplayMetrics().density) + 0.5f));
        if (z) {
            layoutParams3.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f);
        } else {
            layoutParams3.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
            layoutParams3.bottomMargin = (int) ((context.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
        }
        qYNiceImageView2.setOnClickListener(this);
        linearLayout.addView(qYNiceImageView2, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams4.leftToLeft = 0;
        layoutParams4.rightToRight = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.bottomToTop = R.id.qy_trueview_welfare_close;
        layoutParams4.verticalChainStyle = 2;
        if (!z) {
            layoutParams4.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 28.0f) + 0.5f);
        }
        constraintLayout.addView(linearLayout, layoutParams4);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.qy_ic_close);
        imageView.setScaleType(scaleType);
        imageView.setId(R.id.qy_trueview_welfare_close);
        if (Build.VERSION.SDK_INT >= 23) {
            imageView.setForeground(ContextCompat.getDrawable(context, R.drawable.qy_bg_white_stroke_2dp_round));
        }
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f));
        layoutParams5.leftToLeft = 0;
        layoutParams5.rightToRight = 0;
        layoutParams5.topToBottom = R.id.qy_reward_interactive_background;
        layoutParams5.bottomToBottom = 0;
        if (!z) {
            layoutParams5.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 28.0f) + 0.5f);
        }
        imageView.setOnClickListener(this);
        constraintLayout.addView(imageView, layoutParams5);
        TextView textView2 = new TextView(context);
        textView2.setText("以上为广告创意内容，请以广告详情页或第三方app中为准");
        textView2.setTextSize(5.0f);
        textView2.setTextColor(-7829368);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.bottomToBottom = 0;
        layoutParams6.rightToRight = 0;
        layoutParams6.setMargins(0, 0, 40, 40);
        constraintLayout.addView(textView2, layoutParams6);
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void a() {
        zg.a.a(new z8(this));
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final d b() {
        return null;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final boolean c() {
        return this.m;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void d() {
        a9 a9Var = this.l;
        if (a9Var != null) {
            a9Var.c();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void destroy() {
        if (this.n) {
            return;
        }
        this.n = true;
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.q.cancel();
            this.q = null;
        }
        AnimatorSet animatorSet2 = this.r;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.r.cancel();
            this.r = null;
        }
        a9 a9Var = this.l;
        if (a9Var != null) {
            a9Var.a();
        }
        this.b.removeView(this.f);
        this.m = false;
        re reVar = this.e;
        if (reVar != null) {
            reVar.a(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void e() {
        a9 a9Var = this.l;
        if (a9Var != null) {
            a9Var.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void f() {
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final int g() {
        return this.c;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final String h() {
        return "d" + this.d.a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (R.id.qy_reward_interactive_container == id) {
            return;
        }
        if (id == R.id.qy_trueview_welfare_close) {
            if (this.e != null) {
                a4 a4Var = new a4();
                a4Var.b = z3.FUNCTIONAL_BTN;
                a4Var.c = h() + "_close";
                a4Var.g = SystemClock.elapsedRealtime() - this.o;
                this.e.a.b(new b4(a4Var));
            }
            destroy();
            return;
        }
        a9 a9Var = this.l;
        if (a9Var != null) {
            a9Var.a();
        }
        if (this.e != null) {
            a4 a4Var2 = new a4();
            a4Var2.b = z3.GRAPHIC;
            a4Var2.c = h() + "_graphic";
            a4Var2.a = this.b;
            a4Var2.g = SystemClock.elapsedRealtime() - this.o;
            a4Var2.e = gj.a(view);
            this.e.a.b(new b4(a4Var2));
        }
    }

    public static void a(d9 d9Var) {
        d9Var.getClass();
        d9Var.o = SystemClock.elapsedRealtime();
        d9Var.b.addView(d9Var.f, new ViewGroup.LayoutParams(-1, -1));
        d9Var.m = true;
        re reVar = d9Var.e;
        if (reVar != null) {
            reVar.b(d9Var);
        }
        LinearLayout linearLayout = d9Var.g;
        AnimatorSet animatorSet = d9Var.q;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            d9Var.q.cancel();
            d9Var.q = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.ROTATION, 0.0f, 360.0f);
        objectAnimatorOfFloat.setDuration(1500L);
        objectAnimatorOfFloat2.setDuration(1500L);
        objectAnimatorOfFloat3.setDuration(1000L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        d9Var.q = animatorSet2;
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        d9Var.q.addListener(new b9(d9Var, linearLayout));
        d9Var.q.start();
    }

    public static void a(d9 d9Var, LinearLayout linearLayout) {
        AnimatorSet animatorSet = d9Var.r;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            d9Var.r.cancel();
            d9Var.r = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.SCALE_X, 1.0f, 1.2f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.SCALE_Y, 1.0f, 1.2f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat2.setDuration(1000L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        d9Var.r = animatorSet2;
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        d9Var.r.start();
    }
}
