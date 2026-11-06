package com.mar.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class StoreUtils {
    public static String mGgControleData = "mGgControleData";
    public static String mNavigateControleData = "mNavigateControleData";
    private static SharedPreferences sp;

    public static SharedPreferences getSharedPreferences(Context context) {
        if (sp == null) {
            String pname = context.getPackageName() + "mar_preferences";
            sp = context.getSharedPreferences(pname, 0);
        }
        return sp;
    }

    public static int getInt(Context context, String key, int defaultVal) {
        return getSharedPreferences(context).getInt(key, 0);
    }

    public static void putInt(Context context, String key, int val) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(key, val);
        edit.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultVal) {
        return getSharedPreferences(context).getBoolean(key, defaultVal);
    }

    public static void putBoolean(Context context, String key, boolean val) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(key, val);
        edit.commit();
    }

    public static String getString(Context context, String key) {
        return getSharedPreferences(context).getString(key, "");
    }

    public static void putString(Context context, String key, String value) {
        if (!TextUtils.isEmpty(value) && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString(key, value);
            edit.commit();
        }
    }

    public static Long getLong(Context context, String key, long defaultVal) {
        return Long.valueOf(getSharedPreferences(context).getLong(key, 0L));
    }

    public static void putlong(Context context, String key, long val) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(key, val);
        edit.commit();
    }
}
