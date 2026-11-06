package com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.smartdigimkt.q1.l;
import com.smartdigimkt.r1.a;
import com.smartdigimkt.r1.b;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RedPacketAnimatorView extends FrameLayout implements l, Handler.Callback {
    public static final /* synthetic */ int h = 0;
    public final RedPacketView a;
    public ObjectAnimator b;
    public Bitmap c;
    public boolean d;
    public boolean e;
    public int f;
    public final Handler g;

    public RedPacketAnimatorView(Context context) {
        this(context, null);
    }

    private ViewGroup.LayoutParams getRedPacketViewLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public final void a() {
        RedPacketView redPacketView = this.a;
        if (redPacketView == null) {
            return;
        }
        redPacketView.setTranslationY(-this.f);
        if (this.b == null) {
            this.a.setVisibility(0);
            this.a.initRedPacketList(this.c);
            RedPacketView redPacketView2 = this.a;
            int i = this.f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(redPacketView2, "translationY", -i, i);
            this.b = objectAnimatorOfFloat;
            objectAnimatorOfFloat.addListener(new a(this));
            this.b.setRepeatCount(0);
            this.b.setDuration(4000L);
            this.b.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && !objectAnimator.isStarted()) {
            this.b.start();
        }
        this.d = true;
        this.e = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 100) {
            return false;
        }
        a();
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f = getMeasuredHeight();
    }

    @Override // com.smartdigimkt.q1.l
    public void pause() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(100);
        }
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.pause();
        }
    }

    public void release() {
        if (this.e) {
            return;
        }
        stop();
        RedPacketView redPacketView = this.a;
        if (redPacketView != null) {
            redPacketView.release();
        }
        this.e = true;
    }

    public void resume() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            if (objectAnimator.isPaused()) {
                this.b.resume();
            } else {
                a();
            }
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c = list.get(0);
    }

    @Override // com.smartdigimkt.q1.l
    public void start() {
        if (this.d) {
            resume();
            return;
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(100, 500L);
        }
    }

    public void startWithBitmapNow(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.c = bitmap;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        post(new b(this));
    }

    @Override // com.smartdigimkt.q1.l
    public void stop() {
        RedPacketView redPacketView = this.a;
        if (redPacketView != null) {
            redPacketView.setTranslationY(-this.f);
        }
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.b.cancel();
            this.b = null;
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.d = false;
    }

    public RedPacketAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketAnimatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = false;
        this.g = new Handler(Looper.getMainLooper(), this);
        setClipChildren(false);
        RedPacketView redPacketView = new RedPacketView(getContext());
        this.a = redPacketView;
        addView(redPacketView, getRedPacketViewLayoutParams());
        redPacketView.setVisibility(4);
    }
}
