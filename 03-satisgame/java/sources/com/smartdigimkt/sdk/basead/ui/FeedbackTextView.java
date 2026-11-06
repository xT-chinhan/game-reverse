package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class FeedbackTextView extends AutoResizeTextView {
    public FeedbackTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(k.a(context, "myoffer_bg_feedback_textview", "drawable"));
    }
}
