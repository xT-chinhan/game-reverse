package com.anythink.basead.ui.animplayerview.scale;

import android.animation.Animator;
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
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.basead.ui.animplayerview.a;
import com.anythink.basead.ui.animplayerview.b;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlbumScaleMainView extends FrameLayout implements Handler.Callback, b {
    public static final int MAIN_VIEW_INIT_HEIGHT = 42;
    public static final int MAIN_VIEW_INIT_WIDTH = 90;
    private final int a;
    private final int b;
    private RoundImageView c;
    private WrapRoundImageView d;
    private AlbumScaleMainView e;
    private AnimatorSet f;
    private AnimatorSet g;
    private Handler h;
    private long i;

    @Override // com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(List<Bitmap> list) {
    }

    public AlbumScaleMainView(Context context) {
        this(context, null);
    }

    public AlbumScaleMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 100;
        this.b = 500;
        this.c = new RoundImageView(context);
        this.d = new WrapRoundImageView(context);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(this.c, layoutParams);
        addView(this.d, layoutParams2);
        this.h = new Handler(Looper.getMainLooper(), this);
    }

    public void initView(final Bitmap bitmap, boolean z) {
        h.a(getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.1
            @Override // com.anythink.core.common.v.h.a
            public final void a() {
            }

            @Override // com.anythink.core.common.v.h.a
            public final void a(Bitmap bitmap2) {
                AlbumScaleMainView.this.c.setImageBitmap(bitmap2);
            }
        });
        this.d.post(new Runnable() { // from class: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.2
            @Override // java.lang.Runnable
            public final void run() {
                AlbumScaleMainView.this.d.setBitmapAndResize(bitmap, AlbumScaleMainView.this.getWidth(), AlbumScaleMainView.this.getHeight());
            }
        });
        if (z) {
            AlbumScaleMainView albumScaleMainView = new AlbumScaleMainView(getContext());
            this.e = albumScaleMainView;
            albumScaleMainView.initView(bitmap, false);
            this.e.setVisibility(4);
            addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public float getMainViewScale() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return 1.0f;
        }
        return Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels) / Math.min(layoutParams.width, layoutParams.height);
    }

    private void a() {
        float mainViewScale = getMainViewScale();
        if (mainViewScale == 1.0f) {
            return;
        }
        if (this.f == null) {
            this.f = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, mainViewScale);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, mainViewScale);
            long j = this.i;
            if (j > 0) {
                this.f.setStartDelay(j);
            }
            this.f.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.f.setDuration(4000L);
            this.f.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f.addListener(new AnonymousClass3());
        }
        this.f.start();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$3, reason: invalid class name */
    final class AnonymousClass3 extends a {
        AnonymousClass3() {
        }

        @Override // com.anythink.basead.ui.animplayerview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            AlbumScaleMainView.this.h.sendEmptyMessageDelayed(100, 500L);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        if (this.f != null) {
            this.f.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        if (this.f != null) {
            this.f.resume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        AnimatorSet animatorSet2 = this.g;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.g.cancel();
            this.g = null;
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void release() {
        stop();
        removeAllViews();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void b() {
        AlbumScaleMainView albumScaleMainView = this.e;
        if (albumScaleMainView == null) {
            return;
        }
        if (albumScaleMainView.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (this.g == null) {
            this.g = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.3f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.3f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.e, "alpha", 0.4f, 0.0f);
            this.g.setDuration(500L);
            this.g.setInterpolator(new LinearInterpolator());
            this.g.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
            this.g.addListener(new AnonymousClass4());
        }
        AnimatorSet animatorSet = this.g;
        if (animatorSet == null || animatorSet.isStarted()) {
            return;
        }
        this.g.start();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$4, reason: invalid class name */
    final class AnonymousClass4 extends a {
        AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.animplayerview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (AlbumScaleMainView.this.h != null) {
                AlbumScaleMainView.this.h.sendEmptyMessageDelayed(100, 500L);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AlbumScaleMainView albumScaleMainView;
        if (message.what == 100 && (albumScaleMainView = this.e) != null) {
            if (albumScaleMainView.getVisibility() != 0) {
                this.e.setVisibility(0);
            }
            if (this.g == null) {
                this.g = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.3f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.3f);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.e, "alpha", 0.4f, 0.0f);
                this.g.setDuration(500L);
                this.g.setInterpolator(new LinearInterpolator());
                this.g.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
                this.g.addListener(new AnonymousClass4());
            }
            AnimatorSet animatorSet = this.g;
            if (animatorSet != null && !animatorSet.isStarted()) {
                this.g.start();
            }
        }
        return false;
    }

    public void setStartDelay(long j) {
        this.i = j;
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void start() {
        float mainViewScale = getMainViewScale();
        if (mainViewScale != 1.0f) {
            if (this.f == null) {
                this.f = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, mainViewScale);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, mainViewScale);
                long j = this.i;
                if (j > 0) {
                    this.f.setStartDelay(j);
                }
                this.f.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
                this.f.setDuration(4000L);
                this.f.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f.addListener(new AnonymousClass3());
            }
            this.f.start();
        }
    }
}
