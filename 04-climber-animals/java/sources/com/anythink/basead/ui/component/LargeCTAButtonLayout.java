package com.anythink.basead.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public class LargeCTAButtonLayout extends CTAButtonLayout {
    @Override // com.anythink.basead.ui.component.CTAButtonLayout
    protected final int a(w wVar, x xVar, boolean z) {
        return 2;
    }

    public LargeCTAButtonLayout(Context context) {
        this(context, null);
    }

    public LargeCTAButtonLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LargeCTAButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
