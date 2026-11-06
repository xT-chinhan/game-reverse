package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.anythink.basead.b.e;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SplashBottomShakeTextHintView extends ShakeTextHintView {
    public SplashBottomShakeTextHintView(Context context) {
        super(context);
    }

    public SplashBottomShakeTextHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashBottomShakeTextHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SplashBottomShakeTextHintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.ShakeTextHintView, com.anythink.basead.ui.BaseShakeView
    final void a() {
        super.a();
        setOrientation(1);
        setGravity(1);
    }

    @Override // com.anythink.basead.ui.ShakeTextHintView, com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(y yVar, int i) {
        super.setShakeSetting(yVar, i);
        if (this.l != null) {
            if (!TextUtils.isEmpty(this.h)) {
                this.l.setText(this.h);
            } else {
                this.l.setText(e.a(getContext(), i));
            }
        }
    }

    @Override // com.anythink.basead.ui.ShakeTextHintView
    protected final int d() {
        return q.a(getContext(), "myoffer_shake_text_hint_splash_bottom", "layout");
    }
}
