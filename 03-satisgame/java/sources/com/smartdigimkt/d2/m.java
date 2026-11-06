package com.smartdigimkt.d2;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ QAIncentiveTaskView a;

    public m(QAIncentiveTaskView qAIncentiveTaskView) {
        this.a = qAIncentiveTaskView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        QAIncentiveTaskView qAIncentiveTaskView = this.a;
        ((com.smartdigimkt.b2.n) qAIncentiveTaskView.b).a.o = 1;
        if (qAIncentiveTaskView.i != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setAnimationListener(new l(this));
            TextView textView = this.a.e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.a.f;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.a.g;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            this.a.i.setVisibility(0);
            this.a.i.startAnimation(alphaAnimation);
            this.a.b();
        }
    }
}
