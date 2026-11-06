package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SplashShakeTextHintView extends ShakeTextHintView {
    public SplashShakeTextHintView(Context context) {
        super(context);
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.ShakeTextHintView
    protected final int d() {
        return q.a(getContext(), "myoffer_shake_text_hint_splash", "layout");
    }

    public void setTextSize(int i) {
        if (this.l != null) {
            this.l.setTextSize(1, i);
        }
    }
}
