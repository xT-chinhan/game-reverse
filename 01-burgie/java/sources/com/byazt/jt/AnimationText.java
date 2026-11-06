package com.byazt.jt;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.byazt.ca.iu;
import com.byazt.uko.w;
import com.byazt.vkw.qi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1885})
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, qi.pr {
    public float aj;
    public Context c;
    public int fw;
    public Handler g;
    public int hn;
    public List<String> hw;
    public int k;
    public int m;
    public Animation.AnimationListener pr;
    public TextView uc;
    public int vk;
    public int w;
    public final int x;
    public int zo;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.hw = new ArrayList();
        this.hn = 0;
        this.x = 1;
        this.g = new iu(Looper.getMainLooper(), this);
        this.pr = new Animation.AnimationListener() { // from class: com.byazt.jt.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.uc != null) {
                    AnimationText.this.uc.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.c = context;
        this.zo = i;
        this.aj = f;
        this.vk = i2;
        this.m = i3;
        hn();
    }

    private void hn() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.k = i;
    }

    public void setAnimationDuration(int i) {
        this.fw = i;
    }

    public void pr() {
        int i = this.k;
        if (i == 1) {
            setInAnimation(com.byazt.uz.pr.hw());
            setOutAnimation(com.byazt.uz.pr.hn());
        } else if (i == 0) {
            setInAnimation(com.byazt.uz.pr.pr());
            setOutAnimation(com.byazt.uz.pr.pr());
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.pr);
            getOutAnimation().setAnimationListener(this.pr);
        }
        this.g.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.hw = list;
    }

    public void hw() {
        List<String> list = this.hw;
        if (list != null && list.size() > 0) {
            int i = this.hn;
            this.hn = i + 1;
            this.w = i;
            setText(this.hw.get(i));
            if (this.hn > this.hw.size() - 1) {
                this.hn = 0;
            }
        }
    }

    public void setTextColor(int i) {
        this.zo = i;
    }

    public void setTextSize(float f) {
        this.aj = f;
    }

    public void setMaxLines(int i) {
        this.vk = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.uc = textView;
        textView.setTextColor(this.zo);
        this.uc.setTextSize(this.aj);
        this.uc.setMaxLines(this.vk);
        if (Build.VERSION.SDK_INT >= 17) {
            this.uc.setTextAlignment(this.m);
        }
        return this.uc;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                hw();
                this.g.sendEmptyMessageDelayed(1, this.fw);
                break;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(w.hw(this.hw.get(this.w), this.aj, false)[0], 1073741824), i);
        } catch (Exception e) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g.sendEmptyMessageDelayed(1, this.fw);
    }
}
