package com.anythink.basead.ui.improveclick.ambience;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.improveclick.c;
import com.anythink.core.common.a.b;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
public class BubbleDropAnimView extends BaseAmbienceView {
    boolean b;
    boolean c;
    private final int d;
    private BubbleDropChildView e;
    private ObjectAnimator f;
    private Bitmap g;
    private int h;
    private boolean i;

    public BubbleDropAnimView(Context context) {
        super(context);
        this.d = TTAdConstant.INIT_LOCAL_FAIL_CODE;
        this.b = false;
        this.c = false;
        this.i = false;
    }

    public BubbleDropAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = TTAdConstant.INIT_LOCAL_FAIL_CODE;
        this.b = false;
        this.c = false;
        this.i = false;
    }

    public BubbleDropAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = TTAdConstant.INIT_LOCAL_FAIL_CODE;
        this.b = false;
        this.c = false;
        this.i = false;
    }

    @Override // com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView
    public void initView() {
        RelativeLayout.LayoutParams layoutParams;
        BubbleDropChildView bubbleDropChildView = new BubbleDropChildView(getContext());
        this.e = bubbleDropChildView;
        bubbleDropChildView.initSetting(new BubbleDropChildView.a() { // from class: com.anythink.basead.ui.improveclick.ambience.BubbleDropAnimView.1
            @Override // com.anythink.basead.ui.improveclick.ambience.BubbleDropChildView.a
            public final void a() {
                if (BubbleDropAnimView.this.a != null) {
                    BubbleDropAnimView.this.a.a(17, 49);
                }
            }
        });
        Bitmap bitmapC = g.a().c(b.d.b);
        this.g = bitmapC;
        if (bitmapC == null || bitmapC.isRecycled()) {
            release();
            return;
        }
        if (q.c(getContext())) {
            layoutParams = new RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        addView(this.e, layoutParams);
        this.e.post(new Runnable() { // from class: com.anythink.basead.ui.improveclick.ambience.BubbleDropAnimView.2
            @Override // java.lang.Runnable
            public final void run() {
                BubbleDropAnimView bubbleDropAnimView = BubbleDropAnimView.this;
                bubbleDropAnimView.h = bubbleDropAnimView.e.getMeasuredHeight();
                BubbleDropAnimView.this.b();
            }
        });
    }

    @Override // com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView
    public void initSetting(x xVar, c.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView
    public void onResume() {
        if (this.f != null) {
            if (this.f.isPaused()) {
                this.f.resume();
            } else {
                b();
            }
        }
    }

    @Override // com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView
    public void onPause() {
        if (this.f != null) {
            this.f.pause();
        }
    }

    @Override // com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView
    public void release() {
        if (this.i) {
            return;
        }
        BubbleDropChildView bubbleDropChildView = this.e;
        if (bubbleDropChildView != null) {
            bubbleDropChildView.release();
        }
        a();
        this.i = true;
    }

    private void a() {
        BubbleDropChildView bubbleDropChildView = this.e;
        if (bubbleDropChildView != null) {
            bubbleDropChildView.setTranslationY(-this.h);
        }
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BubbleDropChildView bubbleDropChildView = this.e;
        if (bubbleDropChildView == null) {
            return;
        }
        if (this.f == null && !this.c) {
            bubbleDropChildView.setVisibility(0);
            this.e.initRedPacketList(this.g);
            BubbleDropChildView bubbleDropChildView2 = this.e;
            int i = this.h;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(bubbleDropChildView2, "translationY", -i, i);
            this.f = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setRepeatCount(0);
            this.f.setDuration(4000L);
            this.f.setInterpolator(new LinearInterpolator());
            this.f.addListener(new Animator.AnimatorListener() { // from class: com.anythink.basead.ui.improveclick.ambience.BubbleDropAnimView.3
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    BubbleDropAnimView.this.c = true;
                }
            });
        }
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null && !objectAnimator.isStarted() && !this.c) {
            this.e.setTranslationY(-this.h);
            this.f.start();
        }
        this.b = true;
        this.i = false;
    }
}
