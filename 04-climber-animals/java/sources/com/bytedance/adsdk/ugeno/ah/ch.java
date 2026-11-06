package com.bytedance.adsdk.ugeno.ah;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private String ab;
    private AnimatorSet ah = new AnimatorSet();
    private int c;
    private View d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Paint f326ms;
    private ms xr;

    public ch(View view, ms msVar) {
        this.d = view;
        this.xr = msVar;
        Paint paint = new Paint();
        this.f326ms = paint;
        paint.setAntiAlias(true);
    }

    public void ms() {
        ArrayList arrayList = new ArrayList();
        List<ms.C0191ms> listAh = this.xr.ah();
        if (listAh == null || listAh.size() <= 0) {
            return;
        }
        for (ms.C0191ms c0191ms : listAh) {
            if (c0191ms != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0191ms.ms());
                if (TextUtils.equals(c0191ms.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0191ms.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0191ms.getType());
                }
                objectAnimator.setStartDelay(c0191ms.d());
                objectAnimator.setTarget(this.d);
                if (TextUtils.equals(c0191ms.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0191ms.ka(), (int) c0191ms.c());
                } else {
                    objectAnimator.setFloatValues(c0191ms.ka(), c0191ms.c());
                }
                int iXr = (int) this.xr.xr();
                if (iXr != 0) {
                    objectAnimator.setRepeatCount(iXr);
                } else {
                    objectAnimator.setRepeatCount((int) c0191ms.xr());
                }
                if (TextUtils.equals(c0191ms.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strC = this.xr.c();
                if (TextUtils.isEmpty(strC)) {
                    strC = c0191ms.ah();
                }
                if (TextUtils.equals(strC, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0191ms.ab() != null && c0191ms.ab().length > 0) {
                    objectAnimator.setFloatValues(c0191ms.ab());
                }
                if (TextUtils.equals(c0191ms.getType(), "rotationX")) {
                    this.d.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.ah.ch.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ch.this.d.setPivotX(ch.this.d.getWidth() / 2.0f);
                            ch.this.d.setPivotY(ch.this.d.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0191ms.getType(), "ripple")) {
                    this.ab = c0191ms.ny();
                }
                String strX = c0191ms.x();
                strX.hashCode();
                switch (strX) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.xr.d() != 0) {
            this.ah.setDuration(this.xr.d());
        }
        this.ah.setStartDelay(this.xr.ka());
        if (TextUtils.equals(this.xr.ms(), "sequentially")) {
            this.ah.playSequentially(arrayList);
        } else {
            this.ah.playTogether(arrayList);
        }
        this.ah.start();
    }

    public void xr() {
        AnimatorSet animatorSet = this.ah;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void ms(Canvas canvas, ka kaVar) {
        try {
            if (kaVar.getRipple() == 0.0f || TextUtils.isEmpty(this.ab)) {
                return;
            }
            this.f326ms.setColor(com.bytedance.adsdk.ugeno.c.ms.ms(this.ab));
            this.f326ms.setAlpha(90);
            ((ViewGroup) this.d.getParent()).setClipChildren(true);
            int i = this.ka;
            int i2 = this.c;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * kaVar.getRipple(), this.f326ms);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void ms(int i, int i2) {
        this.ka = i / 2;
        this.c = i2 / 2;
    }
}
