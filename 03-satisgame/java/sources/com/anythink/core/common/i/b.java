package com.anythink.core.common.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b f;
    SharedPreferences a;
    final String b = "IABTCF_PurposeConsents";
    final String c = "IABTCF_TCString";
    final String d = "IABTCF_AddtlConsent";
    final String e = "IABTCF_VendorConsents";

    public static b a(Context context) {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b(context);
                }
            }
        }
        return f;
    }

    private b(Context context) {
        this.a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public final String a() {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString("IABTCF_PurposeConsents", "") : "";
    }

    public final String b() {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString("IABTCF_TCString", "") : "";
    }

    public final String c() {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString("IABTCF_AddtlConsent", "") : "";
    }

    public final String d() {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString("IABTCF_VendorConsents", "") : "";
    }
}
