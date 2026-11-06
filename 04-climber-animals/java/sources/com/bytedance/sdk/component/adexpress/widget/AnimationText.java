package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, le.ms {
    private int ab;
    private int ah;
    private TextView c;
    private int ch;
    private final int d;
    private int hi;
    private Context ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Animation.AnimationListener f908ms;
    private float ny;
    private int sl;
    private Handler u;
    private int x;
    private List<String> xr;
    private int zb;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.xr = new ArrayList();
        this.ah = 0;
        this.d = 1;
        this.u = new le(Looper.getMainLooper(), this);
        this.f908ms = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.c != null) {
                    AnimationText.this.c.setText("");
                }
            }
        };
        this.ka = context;
        this.x = i;
        this.ny = f;
        this.ch = i2;
        this.zb = i3;
        ah();
    }

    private void ah() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.sl = i;
    }

    public void setAnimationDuration(int i) {
        this.ab = i;
    }

    public void ms() {
        int i = this.sl;
        if (i == 1) {
            setInAnimation(getContext(), t.hi(this.ka, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), t.hi(this.ka, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), t.hi(this.ka, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), t.hi(this.ka, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.f908ms);
            getOutAnimation().setAnimationListener(this.f908ms);
        }
        this.u.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.xr = list;
    }

    public void xr() {
        List<String> list = this.xr;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.ah;
        this.ah = i + 1;
        this.hi = i;
        setText(this.xr.get(i));
        if (this.ah > this.xr.size() - 1) {
            this.ah = 0;
        }
    }

    public void setTextColor(int i) {
        this.x = i;
    }

    public void setTextSize(float f) {
        this.ny = f;
    }

    public void setMaxLines(int i) {
        this.ch = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(this.x);
        this.c.setTextSize(this.ny);
        this.c.setMaxLines(this.ch);
        this.c.setTextAlignment(this.zb);
        return this.c;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 1) {
            return;
        }
        xr();
        this.u.sendEmptyMessageDelayed(1, this.ab);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(hi.xr(this.xr.get(this.hi), this.ny, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u.sendEmptyMessageDelayed(1, this.ab);
    }
}
