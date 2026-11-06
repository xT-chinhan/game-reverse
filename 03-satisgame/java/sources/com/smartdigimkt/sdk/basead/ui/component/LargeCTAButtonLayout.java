package com.smartdigimkt.sdk.basead.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;

/* JADX INFO: loaded from: classes3.dex */
public class LargeCTAButtonLayout extends CTAButtonLayout {
    public LargeCTAButtonLayout(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout
    public final int a(c cVar, a aVar, boolean z) {
        return 2;
    }

    public LargeCTAButtonLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LargeCTAButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
