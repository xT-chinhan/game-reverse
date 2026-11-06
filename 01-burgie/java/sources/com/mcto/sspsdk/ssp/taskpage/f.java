package com.mcto.sspsdk.ssp.taskpage;

import android.animation.ValueAnimator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ QyTaskPageActivity a;

    public f(QyTaskPageActivity qyTaskPageActivity) {
        this.a = qyTaskPageActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.m.setText(String.format(Locale.CHINA, "当前进度 %d%%", Integer.valueOf(this.a.b)));
        this.a.l.a(this.a.b);
    }
}
