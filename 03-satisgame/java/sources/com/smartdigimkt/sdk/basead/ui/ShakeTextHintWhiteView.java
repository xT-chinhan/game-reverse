package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeTextHintWhiteView extends ShakeTextHintView {
    public ShakeTextHintWhiteView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView
    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_text_hint_white", "layout");
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
