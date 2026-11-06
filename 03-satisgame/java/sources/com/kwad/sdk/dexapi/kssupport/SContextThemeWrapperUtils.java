package com.kwad.sdk.dexapi.kssupport;

import android.content.Context;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes3.dex */
public class SContextThemeWrapperUtils {
    public static boolean isSupportV7ContextThemeWrapper(Context context) {
        try {
            return context instanceof ContextThemeWrapper;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static int getThemeResIdV7(Context context) {
        if (isSupportV7ContextThemeWrapper(context)) {
            return ((ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }
}
