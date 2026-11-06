package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d1.d;
import com.smartdigimkt.d1.f;
import com.smartdigimkt.n1.a2;
import com.smartdigimkt.n1.b2;
import com.smartdigimkt.n1.c2;
import com.smartdigimkt.n1.d2;
import com.smartdigimkt.n1.e2;
import com.smartdigimkt.n1.f2;
import com.smartdigimkt.n1.g2;
import com.smartdigimkt.n1.s1;
import com.smartdigimkt.n1.t1;
import com.smartdigimkt.n1.u1;
import com.smartdigimkt.n1.v1;
import com.smartdigimkt.n1.w1;
import com.smartdigimkt.n1.x1;
import com.smartdigimkt.n1.y1;
import com.smartdigimkt.n1.z1;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseShakeView extends LinearLayout {
    public ImageView a;
    public ImageView b;
    public int c;
    public ValueAnimator d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Bitmap j;
    public g2 k;
    public boolean l;
    public final x1 m;

    public BaseShakeView(Context context) {
        super(context);
        this.c = 0;
        this.m = new x1(this);
        a();
    }

    public abstract void a();

    public void b() {
        if (this.l || this.m.a == null || !isShown()) {
            return;
        }
        o.a().a(this.m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShakeIconAnimation();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        unRegisterShakeListener();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            b();
        } else {
            unRegisterShakeListener();
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            b();
        } else {
            unRegisterShakeListener();
        }
    }

    public void releaseShakeListener() {
        if (this.l) {
            return;
        }
        this.l = true;
        unRegisterShakeListener();
        this.m.a = null;
        this.k = null;
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setOnShakeListener(g2 g2Var, e eVar) {
        if (this.l) {
            return;
        }
        unRegisterShakeListener();
        x1 x1Var = this.m;
        x1Var.getClass();
        d dVarA = f.a(eVar);
        x1Var.a = dVarA;
        if (dVarA != null) {
            dVarA.a(x1Var.b);
        }
        this.k = g2Var;
        if (this.m.a == null || !isAttachedToWindow()) {
            return;
        }
        b();
    }

    public void setShakeSetting(e eVar, int i) {
        if (eVar != null) {
            this.e = eVar.r0;
            String str = eVar.s0;
            this.f = str;
            this.g = eVar.t0;
            this.h = eVar.u0;
            this.i = eVar.v0;
            if (TextUtils.isEmpty(str)) {
                com.smartdigimkt.q3.f.a().a(new w1(this));
            } else {
                com.smartdigimkt.q3.f.a().c(new v1(this));
            }
        }
    }

    public void startShakeIconAnimation() {
        ValueAnimator valueAnimatorOfFloat;
        if (this.l || this.a == null) {
            return;
        }
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = this.e;
        if (i == 1) {
            valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -25.0f, 0.0f, 25.0f, 0.0f);
            valueAnimatorOfFloat.setDuration(500L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new b2(this));
            valueAnimatorOfFloat.addListener(new c2(this));
            valueAnimatorOfFloat.setInterpolator(new d2(this));
            this.a.post(new e2(this));
        } else if (i != 2) {
            valueAnimatorOfFloat = ValueAnimator.ofFloat(-10.0f, 10.0f);
            valueAnimatorOfFloat.setDuration(150L);
            valueAnimatorOfFloat.setRepeatMode(2);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new f2(this));
            valueAnimatorOfFloat.addListener(new s1(this));
            valueAnimatorOfFloat.setInterpolator(new t1(this));
            this.a.post(new u1(this));
        } else {
            int iA = k.a(getContext(), 8.0f);
            float f = iA;
            int i2 = -iA;
            float f2 = i2;
            valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f, f2, f, f2, iA / 2, i2 / 2, iA / 4, i2 / 4, 0.0f);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new y1(this));
            valueAnimatorOfFloat.addListener(new z1(this));
            valueAnimatorOfFloat.setInterpolator(new a2(this));
        }
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    public void unRegisterShakeListener() {
        o.a().b(this.m);
    }

    public void setOnShakeListener(g2 g2Var, d dVar) {
        if (this.l) {
            return;
        }
        unRegisterShakeListener();
        x1 x1Var = this.m;
        x1Var.a = dVar;
        if (dVar != null) {
            dVar.a(x1Var.b);
        }
        this.k = g2Var;
        if (this.m.a == null || !isAttachedToWindow()) {
            return;
        }
        b();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.m = new x1(this);
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        this.m = new x1(this);
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = 0;
        this.m = new x1(this);
        a();
    }
}
