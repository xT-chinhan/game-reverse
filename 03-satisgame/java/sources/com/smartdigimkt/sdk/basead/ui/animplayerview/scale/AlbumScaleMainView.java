package com.smartdigimkt.sdk.basead.ui.animplayerview.scale;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.smartdigimkt.q1.l;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.s1.c;
import com.smartdigimkt.s1.d;
import com.smartdigimkt.s1.e;
import com.smartdigimkt.s4.b;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlbumScaleMainView extends FrameLayout implements l, Handler.Callback {
    public static final int MAIN_VIEW_INIT_HEIGHT = 42;
    public static final int MAIN_VIEW_INIT_WIDTH = 90;
    public final RoundImageView a;
    public final WrapRoundImageView b;
    public AlbumScaleMainView c;
    public AnimatorSet d;
    public AnimatorSet e;
    public final Handler f;
    public long g;

    public AlbumScaleMainView(Context context) {
        this(context, null);
    }

    public float getMainViewScale() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return 1.0f;
        }
        return Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels) / Math.min(layoutParams.width, layoutParams.height);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AlbumScaleMainView albumScaleMainView;
        if (message.what == 100 && (albumScaleMainView = this.c) != null) {
            if (albumScaleMainView.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            if (this.e == null) {
                this.e = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.3f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.3f);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "alpha", 0.4f, 0.0f);
                this.e.setDuration(500L);
                this.e.setInterpolator(new LinearInterpolator());
                this.e.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
                this.e.addListener(new e(this));
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null && !animatorSet.isStarted()) {
                this.e.start();
            }
        }
        return false;
    }

    public void initView(Bitmap bitmap, boolean z) {
        f.a().c(new b(getContext(), bitmap, new com.smartdigimkt.s1.b(this)));
        this.b.post(new c(this, bitmap));
        if (z) {
            AlbumScaleMainView albumScaleMainView = new AlbumScaleMainView(getContext());
            this.c = albumScaleMainView;
            albumScaleMainView.initView(bitmap, false);
            this.c.setVisibility(4);
            addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.smartdigimkt.q1.l
    public void pause() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    public void release() {
        stop();
        removeAllViews();
    }

    public void resume() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.resume();
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
    }

    public void setStartDelay(long j) {
        this.g = j;
    }

    @Override // com.smartdigimkt.q1.l
    public void start() {
        float mainViewScale = getMainViewScale();
        if (mainViewScale == 1.0f) {
            return;
        }
        if (this.d == null) {
            this.d = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, mainViewScale);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, mainViewScale);
            long j = this.g;
            if (j > 0) {
                this.d.setStartDelay(j);
            }
            this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.d.setDuration(4000L);
            this.d.setInterpolator(new AccelerateDecelerateInterpolator());
            this.d.addListener(new d(this));
        }
        this.d.start();
    }

    @Override // com.smartdigimkt.q1.l
    public void stop() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.d.cancel();
            this.d = null;
        }
        AnimatorSet animatorSet2 = this.e;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.e.cancel();
            this.e = null;
        }
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public AlbumScaleMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RoundImageView roundImageView = new RoundImageView(context);
        this.a = roundImageView;
        WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(context);
        this.b = wrapRoundImageView;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        roundImageView.setScaleType(scaleType);
        wrapRoundImageView.setScaleType(scaleType);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(roundImageView, layoutParams);
        addView(wrapRoundImageView, layoutParams2);
        this.f = new Handler(Looper.getMainLooper(), this);
    }
}
