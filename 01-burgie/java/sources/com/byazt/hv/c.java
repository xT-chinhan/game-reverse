package com.byazt.hv;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends x {
    public c(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        ArrayList arrayList = new ArrayList();
        switch (this.hw.cz()) {
            case "both":
                pr(arrayList);
                return arrayList;
            case "forwards":
                x(arrayList);
                return arrayList;
            case "backwards":
                hw(arrayList);
                return arrayList;
            case "none":
            default:
                hn(arrayList);
                return arrayList;
        }
    }

    private void pr(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationY", 0.0f, -com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.a())).setDuration(((int) (this.hw.vk() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.hw.uc(this.hw.ho() * 2);
        list.add(pr(duration));
    }

    private void hw(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationY", 0.0f, -com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.a())).setDuration((int) (this.hw.vk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.hv.c.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.hn.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        list.add(pr(duration));
    }

    private void hn(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationY", 0.0f, -com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.a())).setDuration((int) (this.hw.vk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.hv.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.hn.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        list.add(pr(duration));
    }

    private void x(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationY", 0.0f, -com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.a())).setDuration((int) (this.hw.vk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(pr(duration));
    }
}
