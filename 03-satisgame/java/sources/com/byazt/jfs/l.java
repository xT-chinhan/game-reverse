package com.byazt.jfs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 18})
public class l extends q {
    public l(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        byte b;
        ArrayList arrayList = new ArrayList();
        switch (this.qg.py()) {
            case "both":
                b = 0;
                break;
            case "none":
                b = 3;
                break;
            case "forwards":
                b = 1;
                break;
            case "backwards":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            n(arrayList);
        } else if (b == 1) {
            q(arrayList);
        } else if (b == 2) {
            qg(arrayList);
        } else {
            s(arrayList);
        }
        return arrayList;
    }

    private void n(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, -com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.a())).setDuration(((int) (this.qg.tj() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.qg.w(this.qg.k() * 2);
        list.add(n(duration));
    }

    private void qg(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, -com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.a())).setDuration((int) (this.qg.tj() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jfs.l.1
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
                l.this.s.setTranslationY(0.0f);
            }
        });
        list.add(n(duration));
    }

    private void s(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, -com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.a())).setDuration((int) (this.qg.tj() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jfs.l.2
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
                l.this.s.setTranslationY(0.0f);
            }
        });
        list.add(n(duration));
    }

    private void q(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, -com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.a())).setDuration((int) (this.qg.tj() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(n(duration));
    }
}
