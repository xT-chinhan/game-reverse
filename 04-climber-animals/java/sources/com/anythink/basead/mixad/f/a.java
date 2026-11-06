package com.anythink.basead.mixad.f;

import android.content.Context;
import android.widget.FrameLayout;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static FrameLayout.LayoutParams a(int i) {
        return a(i, 0, 0);
    }

    public static FrameLayout.LayoutParams a(int i, int i2, int i3) {
        Context contextG = t.b().g();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (i == 1) {
            layoutParams.gravity = 83;
            layoutParams.leftMargin = q.a(contextG, 2.0f);
            layoutParams.bottomMargin = q.a(contextG, 2.0f);
        } else {
            if (i2 > 0) {
                layoutParams.width = i2;
            }
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = q.a(contextG, 2.0f);
            layoutParams.rightMargin = q.a(contextG, 2.0f);
        }
        return layoutParams;
    }
}
