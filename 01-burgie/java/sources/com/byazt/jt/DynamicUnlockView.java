package com.byazt.jt;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.uz.hw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1156})
public class DynamicUnlockView extends FrameLayout {
    public final FlowLightView hn;
    public final ImageView hw;
    public final TextView pr;
    public final RotateAnimation x;

    public DynamicUnlockView(Context context) {
        super(context);
        addView(hw.x(context));
        this.pr = (TextView) findViewById(2097610742);
        this.hw = (ImageView) findViewById(2097610745);
        this.hn = (FlowLightView) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.x = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "滑动或点击跳转至详情页或第三方应用";
        }
        TextView textView = this.pr;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void pr() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void hw() {
        this.x.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.byazt.jt.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.hw.startAnimation(DynamicUnlockView.this.x);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.jt.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.hn.pr(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.jt.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.hn.pr(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }
}
