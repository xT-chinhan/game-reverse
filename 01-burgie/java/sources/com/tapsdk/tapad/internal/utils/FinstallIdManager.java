package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class FinstallIdManager {
    private static final String KEY_FIRST_INSTALL_ID = "fInstallId";
    private static final String KEY_FIRST_INSTALL_TIME = "fInstall";
    private static final String PREFS_NAME = "tapad_device_info";
    private static final String TAG = "FinstallIdManager";
    private static volatile FinstallIdManager instance;
    private final Context appContext;
    private volatile String cachedFinstallId;
    private volatile Long cachedFinstallTime;
    private final Object lock = new Object();

    private FinstallIdManager(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public static FinstallIdManager getInstance(Context context) {
        if (instance == null) {
            synchronized (FinstallIdManager.class) {
                if (instance == null) {
                    instance = new FinstallIdManager(context);
                }
            }
        }
        return instance;
    }

    public void clearCache() {
        synchronized (this.lock) {
            this.cachedFinstallId = null;
            this.cachedFinstallTime = null;
        }
    }

    public String getFinstallId() {
        if (this.cachedFinstallId != null) {
            return this.cachedFinstallId;
        }
        synchronized (this.lock) {
            if (this.cachedFinstallId != null) {
                return this.cachedFinstallId;
            }
            Context context = this.appContext;
            if (context == null) {
                return UUID.randomUUID().toString();
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
                String string = sharedPreferences.getString(KEY_FIRST_INSTALL_ID, null);
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    long jCurrentTimeMillis = sharedPreferences.getLong(KEY_FIRST_INSTALL_TIME, 0L);
                    if (jCurrentTimeMillis == 0) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    sharedPreferences.edit().putString(KEY_FIRST_INSTALL_ID, string).putLong(KEY_FIRST_INSTALL_TIME, jCurrentTimeMillis).apply();
                    this.cachedFinstallTime = Long.valueOf(jCurrentTimeMillis);
                }
                this.cachedFinstallId = string;
                return string;
            } catch (Throwable th) {
                return UUID.randomUUID().toString();
            }
        }
    }

    public long getFirstInstallTime() {
        if (this.cachedFinstallTime != null) {
            return this.cachedFinstallTime.longValue();
        }
        synchronized (this.lock) {
            if (this.cachedFinstallTime != null) {
                return this.cachedFinstallTime.longValue();
            }
            Context context = this.appContext;
            if (context == null) {
                return 0L;
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
                long j = sharedPreferences.getLong(KEY_FIRST_INSTALL_TIME, 0L);
                if (j == 0) {
                    getFinstallId();
                    j = sharedPreferences.getLong(KEY_FIRST_INSTALL_TIME, System.currentTimeMillis());
                }
                this.cachedFinstallTime = Long.valueOf(j);
                return j;
            } catch (Throwable th) {
                return 0L;
            }
        }
    }
}
