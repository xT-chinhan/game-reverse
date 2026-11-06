package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ShakeTextHintWhiteView extends ShakeTextHintView {
    public ShakeTextHintWhiteView(Context context) {
        super(context);
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.ShakeTextHintView
    protected final int d() {
        return q.a(getContext(), "myoffer_shake_text_hint_white", "layout");
    }
}
