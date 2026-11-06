package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.t;

/* JADX INFO: loaded from: classes.dex */
public class ATSDKUtils {
    public static int dip2px(Context context, float f) {
        return q.a(context, f);
    }

    public static int px2dip(Context context, float f) {
        return q.b(context, f);
    }

    public static double getUsdChangeToRmbRate() {
        return t.a();
    }

    public static double getRmbChangeToUsdRate() {
        return t.b();
    }
}
