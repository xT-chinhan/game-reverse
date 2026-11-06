package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.cv;
import com.bytedance.sdk.component.utils.t;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageFlipSlideGroup extends FrameLayout {
    boolean ab;
    ImageView ah;
    boolean c;
    private String ch;
    float d;
    private String hi;
    ObjectAnimator ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    FrameLayout f950ms;
    private String ny;
    private String sl;
    private ImageFlipSlide x;
    BookPageView xr;
    private List<String> zb;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.d = 0.0f;
        this.ab = z;
        d();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public float getRatio() {
        return this.d;
    }

    public void setRatio(float f) {
        this.d = f;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageFlipSlideGroup.this.ab) {
                    ImageFlipSlideGroup.this.x.ms(ImageFlipSlideGroup.this.d);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.f950ms.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.d) - 0.5f) * ImageFlipSlideGroup.this.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.f950ms.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                point.x = ((int) (ImageFlipSlideGroup.this.getWidth() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.d))) - 100;
                point.y = ((int) (ImageFlipSlideGroup.this.getHeight() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.d))) - 100;
                if (ImageFlipSlideGroup.this.d > 0.3f) {
                    point.x = (int) (((double) point.x) - (((double) (ImageFlipSlideGroup.this.getWidth() * 2)) * (((double) ImageFlipSlideGroup.this.d) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (ImageFlipSlideGroup.this.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.d) - 0.3d)));
                }
                ImageFlipSlideGroup.this.xr.ms(point);
                ImageFlipSlideGroup.this.xr.setAlpha(1.0f - (ImageFlipSlideGroup.this.d - 0.3f));
                ImageFlipSlideGroup.this.x.ms(ImageFlipSlideGroup.this.xr.getFilterAreaPath());
            }
        });
    }

    public void ms(final DynamicImageFlipSlide.ms msVar) {
        if (this.c) {
            if (msVar != null) {
                msVar.ms();
                return;
            }
            return;
        }
        this.c = true;
        this.ka.cancel();
        if (this.ah != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.ah.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.d;
        fArr[1] = this.ab ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.f950ms.setVisibility(8);
                DynamicImageFlipSlide.ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void d() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.ab);
        this.x = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f950ms = frameLayout;
        addView(frameLayout);
        if (this.ab) {
            View view = new View(getContext());
            view.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cv.ms(getContext(), 2.0f), -1);
            layoutParams.gravity = 17;
            this.f950ms.addView(view, layoutParams);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(t.ka(getContext(), "tt_im_fs_handle"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(cv.ms(getContext(), 44.0f), cv.ms(getContext(), 44.0f));
            layoutParams2.gravity = 17;
            this.f950ms.addView(imageView, layoutParams2);
            ImageView imageView2 = new ImageView(getContext());
            this.ah = imageView2;
            imageView2.setImageResource(t.ka(getContext(), "tt_im_fs_tip"));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(cv.ms(getContext(), 196.0f), cv.ms(getContext(), 300.0f));
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = cv.ms(getContext(), 6.0f);
            this.f950ms.addView(this.ah, layoutParams3);
            return;
        }
        BookPageView bookPageView = new BookPageView(getContext());
        this.xr = bookPageView;
        this.f950ms.addView(bookPageView);
    }

    public void ms() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.ka = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.ka.setInterpolator(new LinearInterpolator());
        this.ka.setRepeatCount(-1);
        this.ka.setRepeatMode(2);
        this.ka.start();
    }

    public void xr() {
        ObjectAnimator objectAnimator = this.ka;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void ms(String str, String str2) {
        this.ny = str;
        this.hi = str2;
    }

    public void xr(String str, String str2) {
        this.ch = str;
        this.sl = str2;
    }

    public void setFilterColors(List<String> list) {
        this.zb = list;
    }

    public void ah() {
        if (!TextUtils.isEmpty(this.ch)) {
            this.x.ms(this.ch, this.sl, (List<String>) null);
        } else {
            this.x.ms(this.ny, this.hi, this.zb);
        }
    }
}
