package com.byazt.stl;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.xta.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1269})
public class DynamicUnlockView extends FrameLayout {
    public final TextView n;
    public final RotateAnimation q;
    public final ImageView qg;
    public final FlowLightView s;

    public DynamicUnlockView(Context context) {
        super(context);
        addView(qg.q(context));
        this.n = (TextView) findViewById(2097610742);
        this.qg = (ImageView) findViewById(2097610745);
        this.s = (FlowLightView) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.q = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "滑动或点击跳转至详情页或第三方应用";
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void n() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void qg() {
        this.q.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.byazt.stl.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.qg.startAnimation(DynamicUnlockView.this.q);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.stl.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.s.n(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.stl.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.s.n(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }
}
