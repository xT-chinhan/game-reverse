package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.u.p;
import com.anythink.core.common.u.s;

/* JADX INFO: loaded from: classes.dex */
public class ATSDKUtils {
    public static int dip2px(Context context, float f) {
        return p.a(context, f);
    }

    public static int px2dip(Context context, float f) {
        return p.b(context, f);
    }

    public static double getUsdChangeToRmbRate() {
        return s.a();
    }

    public static double getRmbChangeToUsdRate() {
        return s.b();
    }
}
