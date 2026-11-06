package com.umeng.cconfig.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("cconfig_sharedpreference", 0);
        } catch (Exception e) {
            return null;
        }
    }
}
