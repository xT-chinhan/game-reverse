package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class StarLevelView extends ImageView {
    Context a;

    public StarLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.a = context;
    }

    public StarLevelView(Context context) {
        this(context, null);
        this.a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public void setState(boolean z) {
        if (z) {
            setImageResource(q.a(getContext(), "myoffer_splash_star", "drawable"));
        } else {
            setImageResource(q.a(getContext(), "myoffer_splash_star_gray", "drawable"));
        }
    }
}
