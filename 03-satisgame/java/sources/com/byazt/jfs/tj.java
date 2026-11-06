package com.byazt.jfs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.osr.DynamicBaseWidget;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends q {
    public float l;
    public n q;
    public float w;

    public tj(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        int i;
        String str;
        if ((this.s instanceof ImageView) && (this.s.getParent() instanceof DynamicBaseWidget)) {
            this.s = (View) this.s.getParent();
        }
        this.s.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        this.q = new n(this.s);
        final int i2 = this.s.getLayoutParams().height;
        this.l = i2;
        this.w = this.s.getLayoutParams().width;
        if ("left".equals(this.qg.n()) || "right".equals(this.qg.n())) {
            i = (int) this.w;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.q, str, 0, i).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        arrayList.add(n(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.byazt.jfs.tj.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                tj.this.q.n(i2);
            }
        });
        return arrayList;
    }

    @com.byazt.cp.n(n = {0, 1, 1191, 855})
    private class n {
        public View qg;

        public n(View view) {
            this.qg = view;
        }

        public void n(int i) {
            if ("top".equals(tj.this.qg.n())) {
                if (tj.this.s instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) tj.this.s).getChildCount(); i2++) {
                        ((ViewGroup) tj.this.s).getChildAt(i2).setTranslationY(i - tj.this.l);
                    }
                }
                tj.this.s.setTranslationY(tj.this.l - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.qg.getLayoutParams();
            layoutParams.height = i;
            this.qg.setLayoutParams(layoutParams);
            this.qg.requestLayout();
        }
    }
}
