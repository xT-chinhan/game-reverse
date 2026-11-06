package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class p8 implements j7 {
    public final y6 a;
    public final a b;
    public final int c;
    public o8 d;
    public final re e;
    public boolean f;
    public final int g;
    public final String h;
    public boolean i = false;
    public final long j;

    public p8(ve veVar, p pVar, int i, String str, a aVar, re reVar) {
        this.f = false;
        this.b = aVar;
        this.g = aVar.d;
        this.e = reVar;
        if (i == 1 && !TextUtils.isEmpty(str)) {
            this.h = "点击屏幕" + str;
        }
        if (TextUtils.isEmpty(this.h)) {
            if (!TextUtils.isEmpty(aVar.h)) {
                this.h = aVar.h;
            } else if (i == 1) {
                this.h = pVar.i().optString("fullScreenAnimationTitle");
            }
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = "点击屏幕 " + pVar.g();
        }
        if (!this.h.contains("%dcd") || aVar.c > 0) {
            this.c = aVar.c;
        } else {
            this.c = 999;
        }
        this.j = SystemClock.elapsedRealtime();
        y6 y6Var = new y6(veVar.getContext());
        this.a = y6Var;
        y6Var.setId(R.id.qy_trueview_welfare_container);
        Point point = new Point(veVar.getWidth() / 2, veVar.getHeight() / 2);
        Size size = new Size(hk.a(veVar.getContext(), 22.0f), hk.a(veVar.getContext(), 22.0f));
        Size size2 = new Size(hk.a(veVar.getContext(), 64.0f), hk.a(veVar.getContext(), 64.0f));
        int i2 = R.color.qy_dialog_bg;
        String strReplace = this.h.replace("%dcd", this.c + "s后");
        y6Var.removeAllViews();
        Context context = y6Var.getContext();
        if (i2 != 0) {
            View view = new View(context);
            y6Var.c = view;
            view.setBackgroundColor(ContextCompat.getColor(context, i2));
            y6Var.addView(y6Var.c, new FrameLayout.LayoutParams(-1, -1));
            y6Var.c.setScaleX(0.0f);
            y6Var.c.setScaleY(0.0f);
        }
        y6Var.a = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size.getWidth(), size.getHeight());
        layoutParams.setMargins(point.x - (size.getWidth() / 2), point.y - (size.getHeight() / 2), 0, 0);
        y6Var.a.setImageResource(R.drawable.qy_ic_ripple);
        y6Var.a.setAlpha(0.0f);
        y6Var.addView(y6Var.a, layoutParams);
        y6Var.b = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(size2.getWidth(), size2.getHeight());
        layoutParams2.setMargins(point.x - (size2.getWidth() / 15), point.y - (size2.getHeight() / 15), 0, 0);
        y6Var.b.setImageResource(R.drawable.qy_lg_hand_click);
        y6Var.addView(y6Var.b, layoutParams2);
        if (!TextUtils.isEmpty(strReplace)) {
            y6Var.d = new TextView(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, hk.a(y6Var.getContext(), 20.0f) + size2.getHeight() + point.y, 0, 0);
            y6Var.d.setText(strReplace);
            y6Var.d.setGravity(17);
            y6Var.d.setTextColor(-1);
            y6Var.d.setTextSize(2, 14.0f);
            y6Var.addView(y6Var.d, layoutParams3);
        }
        y6Var.e = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(y6Var.b, "scaleX", 1.0f, 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(y6Var.b, "scaleY", 1.0f, 0.8f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat2.setDuration(1000L);
        y6Var.e.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        y6Var.f = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(y6Var.a, "scaleX", 0.8f, 2.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(y6Var.a, "scaleY", 0.8f, 2.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(y6Var.a, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat3.setDuration(1000L);
        objectAnimatorOfFloat4.setDuration(1000L);
        objectAnimatorOfFloat5.setDuration(1000L);
        y6Var.f.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        y6Var.f.setStartDelay(500L);
        if (y6Var.c != null) {
            y6Var.g = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(y6Var.c, "scaleX", 0.3f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(y6Var.c, "scaleY", 0.3f, 1.0f);
            objectAnimatorOfFloat6.setDuration(400L);
            objectAnimatorOfFloat7.setDuration(400L);
            y6Var.g.setInterpolator(new DecelerateInterpolator());
            y6Var.g.playTogether(objectAnimatorOfFloat6, objectAnimatorOfFloat7);
        }
        veVar.addView(y6Var, new FrameLayout.LayoutParams(-1, -1));
        if (reVar != null) {
            reVar.b(this);
        }
        this.f = true;
        if (pVar.n()) {
            return;
        }
        y6Var.setOnClickListener(new n8(this));
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void a() {
        this.a.a();
        int i = this.c;
        if (i > 0) {
            if (this.d == null) {
                this.d = new o8(this, ((long) i) * 1000);
            }
            o8 o8Var = this.d;
            synchronized (o8Var) {
                o8Var.c();
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final d b() {
        return null;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final boolean c() {
        return this.f;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void d() {
        o8 o8Var = this.d;
        if (o8Var != null) {
            o8Var.c();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void destroy() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.a.b();
        this.f = false;
        o8 o8Var = this.d;
        if (o8Var != null) {
            o8Var.a();
        }
        re reVar = this.e;
        if (reVar != null) {
            reVar.a(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void e() {
        o8 o8Var = this.d;
        if (o8Var != null) {
            o8Var.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void f() {
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final int g() {
        return this.g;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final String h() {
        return "d" + this.b.a;
    }
}
