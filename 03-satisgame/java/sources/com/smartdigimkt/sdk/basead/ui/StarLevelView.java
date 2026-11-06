package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class StarLevelView extends ImageView {
    public StarLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setState(boolean z) {
        if (z) {
            setImageResource(k.a(getContext(), "myoffer_splash_star", "drawable"));
        } else {
            setImageResource(k.a(getContext(), "myoffer_splash_star_gray", "drawable"));
        }
    }

    public StarLevelView(Context context) {
        this(context, null);
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
