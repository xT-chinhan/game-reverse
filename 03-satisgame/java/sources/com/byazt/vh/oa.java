package com.byazt.vh;

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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public int l;
    public Paint n;
    public View q;
    public n qg;
    public AnimatorSet s = new AnimatorSet();
    public int w;
    public String x;

    public oa(View view, n nVar) {
        this.q = view;
        this.qg = nVar;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        List<n.C0370n> listS = this.qg.s();
        if (listS == null || listS.size() <= 0) {
            return;
        }
        for (n.C0370n c0370n : listS) {
            if (c0370n != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0370n.n());
                if (TextUtils.equals(c0370n.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0370n.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0370n.getType());
                }
                objectAnimator.setStartDelay(c0370n.q());
                objectAnimator.setTarget(this.q);
                if (TextUtils.equals(c0370n.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0370n.l(), (int) c0370n.w());
                } else {
                    objectAnimator.setFloatValues(c0370n.l(), c0370n.w());
                }
                int iQg = (int) this.qg.qg();
                if (iQg != 0) {
                    objectAnimator.setRepeatCount(iQg);
                } else {
                    objectAnimator.setRepeatCount((int) c0370n.qg());
                }
                if (TextUtils.equals(c0370n.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strW = this.qg.w();
                if (TextUtils.isEmpty(strW)) {
                    strW = c0370n.s();
                }
                if (TextUtils.equals(strW, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0370n.x() != null && c0370n.x().length > 0) {
                    objectAnimator.setFloatValues(c0370n.x());
                }
                if (TextUtils.equals(c0370n.getType(), "rotationX")) {
                    this.q.post(new Runnable() { // from class: com.byazt.vh.oa.1
                        @Override // java.lang.Runnable
                        public void run() {
                            oa.this.q.setPivotX(oa.this.q.getWidth() / 2.0f);
                            oa.this.q.setPivotY(oa.this.q.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0370n.getType(), "ripple")) {
                    this.x = c0370n.rv();
                }
                String strFs = c0370n.fs();
                strFs.hashCode();
                switch (strFs) {
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
        if (this.qg.q() != 0) {
            this.s.setDuration(this.qg.q());
        }
        this.s.setStartDelay(this.qg.l());
        if (TextUtils.equals(this.qg.n(), "sequentially")) {
            this.s.playSequentially(arrayList);
        } else {
            this.s.playTogether(arrayList);
        }
        this.s.start();
    }

    public void qg() {
        AnimatorSet animatorSet = this.s;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void n(Canvas canvas, l lVar) {
        try {
            if (lVar.getRipple() == 0.0f || TextUtils.isEmpty(this.x)) {
                return;
            }
            this.n.setColor(com.byazt.hb.n.n(this.x));
            this.n.setAlpha(90);
            ((ViewGroup) this.q.getParent()).setClipChildren(true);
            int i = this.l;
            int i2 = this.w;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * lVar.getRipple(), this.n);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void n(int i, int i2) {
        this.l = i / 2;
        this.w = i2 / 2;
    }
}
