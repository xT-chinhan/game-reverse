package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class SplashBottomShakeTextHintView extends ShakeTextHintView {
    public SplashBottomShakeTextHintView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView, com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void a() {
        super.a();
        setOrientation(1);
        setGravity(1);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView
    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_text_hint_splash_bottom", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView, com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        super.setShakeSetting(eVar, i);
        if (this.tvShakeTitleView != null) {
            if (TextUtils.isEmpty(this.i)) {
                this.tvShakeTitleView.setText(c0.a(getContext(), i));
            } else {
                this.tvShakeTitleView.setText(this.i);
            }
        }
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
}
