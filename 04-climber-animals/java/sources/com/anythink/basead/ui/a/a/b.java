package com.anythink.basead.ui.a.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.SimpleGuideToClickView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    SimpleGuideToClickView e;

    @Override // com.anythink.basead.ui.a.a.a
    protected final ValueAnimator e() {
        return null;
    }

    public b(View view) {
        super(view);
    }

    @Override // com.anythink.basead.ui.a.a.a, com.anythink.basead.ui.a.b
    public final synchronized void a() {
        if (this.a != null && this.a.getParent() != null && (this.a.getParent() instanceof RelativeLayout)) {
            Context context = this.a.getContext();
            if (this.e == null) {
                try {
                    RelativeLayout relativeLayout = (RelativeLayout) this.a.getParent();
                    relativeLayout.setClipChildren(false);
                    SimpleGuideToClickView simpleGuideToClickView = new SimpleGuideToClickView(context);
                    this.e = simpleGuideToClickView;
                    simpleGuideToClickView.init(q.a(context, "myoffer_simple_guide_to_click_cta", "layout"), q.a(context, 1.0f), q.a(context, 3.0f), q.a(context, 6.0f), q.a(context, 6.0f));
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
