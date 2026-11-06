package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
class DVersionUtils {
    private static final String APIVERSION = "apiversion";
    static String AUTOREVERT = "autoRevert";
    private static final String CURVERSION = "curversion";
    private static final String NEWVERSION = "newversion";
    private static final String SEPARATOR = "\\.";

    DVersionUtils() {
    }

    private static void setVersion(Context context, String str, String str2) {
        ApiSpUtils.setString(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return ApiSpUtils.getString(context, str, "");
    }

    public static String getCurrentDynamicVersion(Context context) {
        return getVersion(context, CURVERSION);
    }

    public static void setCurrentDynamicVersion(Context context, String str) {
        setVersion(context, CURVERSION, str);
    }

    public static String getNewDynamicVersion(Context context) {
        return getVersion(context, NEWVERSION);
    }

    public static void setNewDynamicVersion(Context context, String str) {
        setVersion(context, NEWVERSION, str);
    }

    static String getApiVersion(Context context) {
        return getVersion(context, APIVERSION);
    }

    static void setApiVersion(Context context, String str) {
        setVersion(context, APIVERSION, str);
    }

    static boolean isGreaterThan(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] strArrSplit = str.split(SEPARATOR);
        String[] strArrSplit2 = str2.split(SEPARATOR);
        for (int i = 0; i < strArrSplit.length && i < strArrSplit2.length; i++) {
            try {
                int i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                if (i2 > 0) {
                    return true;
                }
                if (i2 < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return strArrSplit.length > strArrSplit2.length;
    }
}
