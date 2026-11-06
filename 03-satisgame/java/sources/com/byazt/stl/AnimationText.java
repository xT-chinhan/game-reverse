package com.byazt.stl;

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
import com.byazt.hkc.cp;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2051})
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, wo.n {
    public int cp;
    public int d;
    public int fs;
    public Context l;
    public Animation.AnimationListener n;
    public int oa;
    public final int q;
    public List<String> qg;
    public float rv;
    public int s;
    public Handler sz;
    public int tj;
    public TextView w;
    public int x;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.qg = new ArrayList();
        this.s = 0;
        this.q = 1;
        this.sz = new t(Looper.getMainLooper(), this);
        this.n = new Animation.AnimationListener() { // from class: com.byazt.stl.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.w != null) {
                    AnimationText.this.w.setText("");
                }
            }
        };
        this.l = context;
        this.fs = i;
        this.rv = f;
        this.tj = i2;
        this.oa = i3;
        s();
    }

    private void s() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.d = i;
    }

    public void setAnimationDuration(int i) {
        this.x = i;
    }

    public void n() {
        int i = this.d;
        if (i == 1) {
            setInAnimation(com.byazt.xta.n.qg());
            setOutAnimation(com.byazt.xta.n.s());
        } else if (i == 0) {
            setInAnimation(com.byazt.xta.n.n());
            setOutAnimation(com.byazt.xta.n.n());
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.n);
            getOutAnimation().setAnimationListener(this.n);
        }
        this.sz.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.qg = list;
    }

    public void qg() {
        List<String> list = this.qg;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.s;
        this.s = i + 1;
        this.cp = i;
        setText(this.qg.get(i));
        if (this.s > this.qg.size() - 1) {
            this.s = 0;
        }
    }

    public void setTextColor(int i) {
        this.fs = i;
    }

    public void setTextSize(float f) {
        this.rv = f;
    }

    public void setMaxLines(int i) {
        this.tj = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.w = textView;
        textView.setTextColor(this.fs);
        this.w.setTextSize(this.rv);
        this.w.setMaxLines(this.tj);
        this.w.setTextAlignment(this.oa);
        return this.w;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 1) {
            return;
        }
        qg();
        this.sz.sendEmptyMessageDelayed(1, this.x);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(cp.qg(this.qg.get(this.cp), this.rv, false)[0], C.ENCODING_PCM_32BIT), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.sz.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.sz.sendEmptyMessageDelayed(1, this.x);
    }
}
