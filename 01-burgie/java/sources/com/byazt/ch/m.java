package com.byazt.ch;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 108})
public class m {
    public int c;
    public String fw;
    public AnimatorSet hn = new AnimatorSet();
    public pr hw;
    public Paint pr;
    public int uc;
    public View x;

    public m(View view, pr prVar) {
        this.x = view;
        this.hw = prVar;
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
    }

    public void pr() {
        ArrayList arrayList = new ArrayList();
        List<pr.C0034pr> listHn = this.hw.hn();
        if (listHn == null || listHn.size() <= 0) {
            return;
        }
        for (pr.C0034pr c0034pr : listHn) {
            if (c0034pr != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0034pr.pr());
                if (TextUtils.equals(c0034pr.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0034pr.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0034pr.getType());
                }
                objectAnimator.setStartDelay(c0034pr.x());
                objectAnimator.setTarget(this.x);
                if (TextUtils.equals(c0034pr.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0034pr.c(), (int) c0034pr.uc());
                } else {
                    objectAnimator.setFloatValues(c0034pr.c(), c0034pr.uc());
                }
                int iHw = (int) this.hw.hw();
                if (iHw != 0) {
                    objectAnimator.setRepeatCount(iHw);
                } else {
                    objectAnimator.setRepeatCount((int) c0034pr.hw());
                }
                if (TextUtils.equals(c0034pr.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strUc = this.hw.uc();
                if (TextUtils.isEmpty(strUc)) {
                    strUc = c0034pr.hn();
                }
                if (TextUtils.equals(strUc, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0034pr.fw() != null && c0034pr.fw().length > 0) {
                    objectAnimator.setFloatValues(c0034pr.fw());
                }
                if (TextUtils.equals(c0034pr.getType(), "rotationX")) {
                    this.x.post(new Runnable() { // from class: com.byazt.ch.m.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.x.setPivotX(m.this.x.getWidth() / 2.0f);
                            m.this.x.setPivotY(m.this.x.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0034pr.getType(), "ripple")) {
                    this.fw = c0034pr.aj();
                }
                switch (c0034pr.zo()) {
                    case "standard":
                    case "linear":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.hw.x() != 0) {
            this.hn.setDuration(this.hw.x());
        }
        this.hn.setStartDelay(this.hw.c());
        if (TextUtils.equals(this.hw.pr(), "sequentially")) {
            this.hn.playSequentially(arrayList);
        } else {
            this.hn.playTogether(arrayList);
        }
        this.hn.start();
    }

    public void hw() {
        AnimatorSet animatorSet = this.hn;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void pr(Canvas canvas, c cVar) {
        try {
            if (cVar.getRipple() != 0.0f && !TextUtils.isEmpty(this.fw)) {
                this.pr.setColor(com.byazt.aa.pr.pr(this.fw));
                this.pr.setAlpha(90);
                ((ViewGroup) this.x.getParent()).setClipChildren(true);
                int i = this.c;
                int i2 = this.uc;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * cVar.getRipple(), this.pr);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void pr(int i, int i2) {
        this.c = i / 2;
        this.uc = i2 / 2;
    }
}
