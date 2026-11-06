package com.byazt.stl;

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
import com.byazt.osr.DynamicImageFlipSlide;
import com.byazt.tk.sz;
import com.byazt.tk.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1183})
public class ImageFlipSlideGroup extends FrameLayout {
    public String cp;
    public String d;
    public ImageFlipSlide fs;
    public ObjectAnimator l;
    public FrameLayout n;
    public List<String> oa;
    public float q;
    public BookPageView qg;
    public String rv;
    public ImageView s;
    public String tj;
    public boolean w;
    public boolean x;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.q = 0.0f;
        this.x = z;
        q();
        setVisibility(4);
        post(new Runnable() { // from class: com.byazt.stl.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public float getRatio() {
        return this.q;
    }

    public void setRatio(float f) {
        this.q = f;
        post(new Runnable() { // from class: com.byazt.stl.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageFlipSlideGroup.this.x) {
                    ImageFlipSlideGroup.this.fs.n(ImageFlipSlideGroup.this.q);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.n.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.q) - 0.5f) * ImageFlipSlideGroup.this.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.n.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                point.x = ((int) (ImageFlipSlideGroup.this.getWidth() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.q))) - 100;
                point.y = ((int) (ImageFlipSlideGroup.this.getHeight() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.q))) - 100;
                if (ImageFlipSlideGroup.this.q > 0.3f) {
                    point.x = (int) (((double) point.x) - (((double) (ImageFlipSlideGroup.this.getWidth() * 2)) * (((double) ImageFlipSlideGroup.this.q) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (ImageFlipSlideGroup.this.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.q) - 0.3d)));
                }
                ImageFlipSlideGroup.this.qg.n(point);
                ImageFlipSlideGroup.this.qg.setAlpha(1.0f - (ImageFlipSlideGroup.this.q - 0.3f));
                ImageFlipSlideGroup.this.fs.n(ImageFlipSlideGroup.this.qg.getFilterAreaPath());
            }
        });
    }

    public void n(final DynamicImageFlipSlide.n nVar) {
        if (this.w) {
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        this.w = true;
        this.l.cancel();
        if (this.s != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.s.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.q;
        fArr[1] = this.x ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.stl.ImageFlipSlideGroup.3
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
                ImageFlipSlideGroup.this.n.setVisibility(8);
                DynamicImageFlipSlide.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void q() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.x);
        this.fs = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.n = frameLayout;
        addView(frameLayout);
        if (this.x) {
            View view = new View(getContext());
            view.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ur.n(getContext(), 2.0f), -1);
            layoutParams.gravity = 17;
            this.n.addView(view, layoutParams);
            ImageView imageView = new ImageView(getContext());
            sz.n(getContext(), "tt_im_fs_handle", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ur.n(getContext(), 44.0f), ur.n(getContext(), 44.0f));
            layoutParams2.gravity = 17;
            this.n.addView(imageView, layoutParams2);
            this.s = new ImageView(getContext());
            sz.n(getContext(), "tt_im_fs_tip", this.s, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ur.n(getContext(), 196.0f), ur.n(getContext(), 300.0f));
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = ur.n(getContext(), 6.0f);
            this.n.addView(this.s, layoutParams3);
            return;
        }
        BookPageView bookPageView = new BookPageView(getContext());
        this.qg = bookPageView;
        this.n.addView(bookPageView);
    }

    public void n() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.l = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.l.setInterpolator(new LinearInterpolator());
        this.l.setRepeatCount(-1);
        this.l.setRepeatMode(2);
        this.l.start();
    }

    public void qg() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void n(String str, String str2) {
        this.rv = str;
        this.cp = str2;
    }

    public void qg(String str, String str2) {
        this.tj = str;
        this.d = str2;
    }

    public void setFilterColors(List<String> list) {
        this.oa = list;
    }

    public void s() {
        if (!TextUtils.isEmpty(this.tj)) {
            this.fs.n(this.tj, this.d, (List<String>) null);
        } else {
            this.fs.n(this.rv, this.cp, this.oa);
        }
    }
}
