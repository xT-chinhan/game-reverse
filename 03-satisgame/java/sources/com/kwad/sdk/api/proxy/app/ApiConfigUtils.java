package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import com.kwad.sdk.api.loader.ApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public class ApiConfigUtils {
    private static final String PREFERENCE_NAME = "ksadsdk_config";

    public static String readString(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, str2);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return str2;
        }
    }

    public static int readInt(Context context, String str, int i) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getInt(str, i);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return i;
        }
    }
}
