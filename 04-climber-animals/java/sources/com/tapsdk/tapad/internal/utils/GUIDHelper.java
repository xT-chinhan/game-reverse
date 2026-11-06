package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public enum GUIDHelper {
    INSTANCE;

    private static final String GUID_KEY = "GUID";
    private static final String TAG = "GUIDHelper";
    private SharedPreferences mSp;

    private void saveGUIDToSP(String str) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(GUID_KEY, str).apply();
        }
    }

    public String getUID() {
        String string = "";
        try {
            String string2 = this.mSp.getString(GUID_KEY, "");
            if (!TextUtils.isEmpty(string2)) {
                return string2;
            }
            string = UUID.randomUUID().toString();
            saveGUIDToSP(string);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public void init(Context context) {
        synchronized (GUIDHelper.class) {
            if (this.mSp != null) {
                return;
            }
            this.mSp = context.getApplicationContext().getSharedPreferences(TAG, 0);
        }
    }

    public boolean initialized() {
        return this.mSp != null;
    }
}
