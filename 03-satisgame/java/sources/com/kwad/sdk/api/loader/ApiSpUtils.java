package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.util.ApiExecutorUtils;
import com.kwad.sdk.api.util.ApiSafeRunnable;

/* JADX INFO: loaded from: classes3.dex */
public class ApiSpUtils {
    private static final String PREFERENCE_NAME = "kssdk_api_pref";
    public static final String SP_INTERVAL = "interval";
    public static final String SP_LASTUPDATE_TIME = "lastUpdateTime";
    public static final String SP_SDKCONFIG = "sdkconfig";

    public static void saveSdkConfigAsync(final Context context, final SdkConfig sdkConfig) {
        ApiExecutorUtils.submit(new ApiSafeRunnable() { // from class: com.kwad.sdk.api.loader.ApiSpUtils.1
            @Override // com.kwad.sdk.api.util.ApiSafeRunnable
            public void doTask() {
                ApiSpUtils.setString(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    public static void setString(Context context, String str, String str2) {
        try {
            context.getSharedPreferences(PREFERENCE_NAME, 0).edit().putString(str, str2).commit();
        } catch (Throwable th) {
            ApiLogger.handleException(th);
        }
    }

    public static String getString(Context context, String str) {
        return getString(context, str, "");
    }

    public static String getString(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, str2);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return str2;
        }
    }

    public static void setBoolean(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences(PREFERENCE_NAME, 0).edit().putBoolean(str, z).commit();
        } catch (Throwable th) {
            ApiLogger.handleException(th);
        }
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getBoolean(str, z);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return z;
        }
    }

    public static void setLong(Context context, String str, long j) {
        try {
            context.getSharedPreferences(PREFERENCE_NAME, 0).edit().putLong(str, j).commit();
        } catch (Throwable th) {
            ApiLogger.handleException(th);
        }
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, 0L);
    }

    public static long getLong(Context context, String str, long j) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getLong(str, j);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return j;
        }
    }
}
