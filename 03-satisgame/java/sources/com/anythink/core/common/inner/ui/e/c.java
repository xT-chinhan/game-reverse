package com.anythink.core.common.inner.ui.e;

import android.content.Context;
import com.anythink.core.common.h.w;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 6;
    public static final int f = 7;

    public static int a(Context context, w wVar) {
        int iU = wVar.u();
        if (iU == 1 || iU == 4) {
            return p.a(context, "myoffer_cta_install_now", "string");
        }
        return p.a(context, "myoffer_cta_learn_more", "string");
    }

    private static int a(Context context, int i) {
        if (i == 1 || i == 4) {
            return p.a(context, "myoffer_shake_full_title_download_type", "string");
        }
        return p.a(context, "myoffer_shake_full_title", "string");
    }
}
