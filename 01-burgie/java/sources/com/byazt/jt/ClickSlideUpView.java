package com.byazt.jt;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.byazt.js.zo;
import com.byazt.uz.hw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1339})
public class ClickSlideUpView extends SlideUpView {
    public AnimatorSet hn;
    public View hw;
    public TextView pr;

    public ClickSlideUpView(Context context) {
        super(context);
        this.hn = new AnimatorSet();
        hw(context);
    }

    @Override // com.byazt.jt.SlideUpView
    public void pr(Context context) {
    }

    private void hw(Context context) {
        View viewPr = hw.pr(context);
        this.hw = viewPr;
        addView(viewPr);
        setClipChildren(false);
        this.pr = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.pr != null && !TextUtils.isEmpty(str)) {
            this.pr.setText(str);
        }
    }

    private void x() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hw, "translationY", 0.0f, zo.pr(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hw, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.hn.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.hn.setDuration(1000L);
        this.hn.start();
    }

    @Override // com.byazt.jt.SlideUpView
    public void pr() {
        x();
    }

    @Override // com.byazt.jt.SlideUpView
    public void hw() {
        this.hn.cancel();
    }
}
