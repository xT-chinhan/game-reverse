package com.smartdigimkt.p1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.SimpleGuideToClickView;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    public SimpleGuideToClickView e;

    public c(View view) {
        super(view);
    }

    @Override // com.smartdigimkt.p1.b
    public final ValueAnimator b() {
        return null;
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final synchronized void start() {
        View view = this.a;
        if (view != null && view.getParent() != null && (this.a.getParent() instanceof RelativeLayout)) {
            Context context = this.a.getContext();
            if (this.e == null) {
                try {
                    RelativeLayout relativeLayout = (RelativeLayout) this.a.getParent();
                    relativeLayout.setClipChildren(false);
                    SimpleGuideToClickView simpleGuideToClickView = new SimpleGuideToClickView(context);
                    this.e = simpleGuideToClickView;
                    simpleGuideToClickView.init(k.a(context, "myoffer_simple_guide_to_click_cta", "layout"), k.a(context, 1.0f), (int) ((context.getResources().getDisplayMetrics().density * 3.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 6.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 6.0f) + 0.5f));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(7, this.a.getId());
                    layoutParams.addRule(15);
                    relativeLayout.addView(this.e, layoutParams);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
