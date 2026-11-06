package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends d {
    private float c;
    private ms d;
    private float ka;

    public ch(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        int i;
        String str;
        if ((this.ah instanceof ImageView) && (this.ah.getParent() instanceof DynamicBaseWidget)) {
            this.ah = (View) this.ah.getParent();
        }
        this.ah.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "alpha", 0.0f, 1.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        this.d = new ms(this.ah);
        final int i2 = this.ah.getLayoutParams().height;
        this.ka = i2;
        this.c = this.ah.getLayoutParams().width;
        if ("left".equals(this.xr.ms()) || "right".equals(this.xr.ms())) {
            i = (int) this.c;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.d, str, 0, i).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        arrayList.add(ms(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.ch.1
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
                ch.this.d.ms(i2);
            }
        });
        return arrayList;
    }

    private class ms {
        private View xr;

        public ms(View view) {
            this.xr = view;
        }

        public void ms(int i) {
            if ("top".equals(ch.this.xr.ms())) {
                if (ch.this.ah instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) ch.this.ah).getChildCount(); i2++) {
                        ((ViewGroup) ch.this.ah).getChildAt(i2).setTranslationY(i - ch.this.ka);
                    }
                }
                ch.this.ah.setTranslationY(ch.this.ka - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.xr.getLayoutParams();
            layoutParams.height = i;
            this.xr.setLayoutParams(layoutParams);
            this.xr.requestLayout();
        }
    }
}
