package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class AdTextView extends TextView {
    public AdTextView(Context context) {
        super(context);
        a(context);
    }

    public AdTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AdTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setBackgroundResource(q.a(context, "myoffer_bg_banner_ad_choice", "drawable"));
        setTextColor(-1);
        setText(context.getResources().getString(q.a(context, "basead_ad_text", "string")));
        setTextSize(8.0f);
        setGravity(17);
        setPadding(q.a(context, 3.0f), 0, q.a(context, 3.0f), 0);
    }
}
