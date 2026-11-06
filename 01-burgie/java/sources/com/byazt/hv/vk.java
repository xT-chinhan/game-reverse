package com.byazt.hv;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.gx.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 50})
public class vk extends x {
    public float c;
    public float uc;
    public pr x;

    public vk(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        int i;
        String str;
        if ((this.hn instanceof ImageView) && (this.hn.getParent() instanceof DynamicBaseWidget)) {
            this.hn = (View) this.hn.getParent();
        }
        this.hn.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "alpha", 0.0f, 1.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        this.x = new pr(this.hn);
        final int i2 = this.hn.getLayoutParams().height;
        this.c = i2;
        this.uc = this.hn.getLayoutParams().width;
        if ("left".equals(this.hw.pr()) || "right".equals(this.hw.pr())) {
            i = (int) this.uc;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.x, str, 0, i).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        arrayList.add(pr(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.byazt.hv.vk.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                vk.this.x.pr(i2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return arrayList;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 802, 590})
    private class pr {
        public View hw;

        public pr(View view) {
            this.hw = view;
        }

        public void pr(int i) {
            if ("top".equals(vk.this.hw.pr())) {
                if (vk.this.hn instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) vk.this.hn).getChildCount(); i2++) {
                        ((ViewGroup) vk.this.hn).getChildAt(i2).setTranslationY(i - vk.this.c);
                    }
                }
                vk.this.hn.setTranslationY(vk.this.c - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.hw.getLayoutParams();
            layoutParams.height = i;
            this.hw.setLayoutParams(layoutParams);
            this.hw.requestLayout();
        }
    }
}
