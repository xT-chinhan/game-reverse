package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class AdTextView extends TextView {
    public AdTextView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        setBackgroundResource(k.a(context, "myoffer_bg_banner_ad_choice", "drawable"));
        setTextColor(-1);
        setText(context.getResources().getString(k.a(context, "basead_ad_text", "string")));
        setTextSize(8.0f);
        setGravity(17);
        setPadding((int) ((context.getResources().getDisplayMetrics().density * 3.0f) + 0.5f), 0, (int) ((context.getResources().getDisplayMetrics().density * 3.0f) + 0.5f), 0);
    }

    public AdTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AdTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
