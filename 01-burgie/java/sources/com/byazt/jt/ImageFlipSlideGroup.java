package com.byazt.jt;

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
import com.byazt.ca.g;
import com.byazt.ca.ve;
import com.byazt.gx.DynamicImageFlipSlide;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1109})
public class ImageFlipSlideGroup extends FrameLayout {
    public String aj;
    public ObjectAnimator c;
    public boolean fw;
    public ImageView hn;
    public BookPageView hw;
    public String k;
    public List<String> m;
    public FrameLayout pr;
    public boolean uc;
    public String vk;
    public String w;
    public float x;
    public ImageFlipSlide zo;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.x = 0.0f;
        this.fw = z;
        x();
        setVisibility(4);
        post(new Runnable() { // from class: com.byazt.jt.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public float getRatio() {
        return this.x;
    }

    public void setRatio(float f) {
        this.x = f;
        post(new Runnable() { // from class: com.byazt.jt.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageFlipSlideGroup.this.fw) {
                    ImageFlipSlideGroup.this.zo.pr(ImageFlipSlideGroup.this.x);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.pr.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.x) - 0.5f) * ImageFlipSlideGroup.this.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.pr.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                point.x = ((int) (ImageFlipSlideGroup.this.getWidth() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.x))) - 100;
                point.y = ((int) (ImageFlipSlideGroup.this.getHeight() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.x))) - 100;
                if (ImageFlipSlideGroup.this.x > 0.3f) {
                    point.x = (int) (((double) point.x) - (((double) (ImageFlipSlideGroup.this.getWidth() * 2)) * (((double) ImageFlipSlideGroup.this.x) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (ImageFlipSlideGroup.this.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.x) - 0.3d)));
                }
                ImageFlipSlideGroup.this.hw.pr(point);
                ImageFlipSlideGroup.this.hw.setAlpha(1.0f - (ImageFlipSlideGroup.this.x - 0.3f));
                ImageFlipSlideGroup.this.zo.pr(ImageFlipSlideGroup.this.hw.getFilterAreaPath());
            }
        });
    }

    public void pr(final DynamicImageFlipSlide.pr prVar) {
        if (!this.uc) {
            this.uc = true;
            this.c.cancel();
            if (this.hn != null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setFillAfter(true);
                this.hn.setAnimation(alphaAnimation);
                alphaAnimation.start();
            }
            float[] fArr = new float[2];
            fArr[0] = this.x;
            fArr[1] = this.fw ? 1.1f : 1.3f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jt.ImageFlipSlideGroup.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ImageFlipSlideGroup.this.pr.setVisibility(8);
                    DynamicImageFlipSlide.pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
            return;
        }
        if (prVar != null) {
            prVar.pr();
        }
    }

    private void x() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.fw);
        this.zo = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.pr = frameLayout;
        addView(frameLayout);
        if (this.fw) {
            View view = new View(getContext());
            view.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ve.pr(getContext(), 2.0f), -1);
            layoutParams.gravity = 17;
            this.pr.addView(view, layoutParams);
            ImageView imageView = new ImageView(getContext());
            g.pr(getContext(), "tt_im_fs_handle", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ve.pr(getContext(), 44.0f), ve.pr(getContext(), 44.0f));
            layoutParams2.gravity = 17;
            this.pr.addView(imageView, layoutParams2);
            this.hn = new ImageView(getContext());
            g.pr(getContext(), "tt_im_fs_tip", this.hn, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ve.pr(getContext(), 196.0f), ve.pr(getContext(), 300.0f));
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = ve.pr(getContext(), 6.0f);
            this.pr.addView(this.hn, layoutParams3);
            return;
        }
        BookPageView bookPageView = new BookPageView(getContext());
        this.hw = bookPageView;
        this.pr.addView(bookPageView);
    }

    public void pr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.c = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(2);
        this.c.start();
    }

    public void hw() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void pr(String str, String str2) {
        this.aj = str;
        this.w = str2;
    }

    public void hw(String str, String str2) {
        this.vk = str;
        this.k = str2;
    }

    public void setFilterColors(List<String> list) {
        this.m = list;
    }

    public void hn() {
        if (!TextUtils.isEmpty(this.vk)) {
            this.zo.pr(this.vk, this.k, (List<String>) null);
        } else {
            this.zo.pr(this.aj, this.w, this.m);
        }
    }
}
