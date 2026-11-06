package com.tapsdk.tapad.internal.storage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SafeSP {
    private static final Map<String, SafeSP> mSPCache = new ConcurrentHashMap();
    private static volatile Context sApplicationContext;
    private final SharedPreferences mSp;

    private SafeSP(String str) {
        this.mSp = sApplicationContext.getSharedPreferences(str, 0);
    }

    public static SafeSP getSP(String str) {
        if (sApplicationContext == null) {
            return null;
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("sp name empty");
        }
        Map<String, SafeSP> map = mSPCache;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        SafeSP safeSP = new SafeSP(str);
        map.put(str, safeSP);
        return safeSP;
    }

    public static synchronized void initialize(Context context) {
        if (isInitialized()) {
            return;
        }
        if (context != null) {
            sApplicationContext = context.getApplicationContext();
        }
    }

    public static boolean isInitialized() {
        return sApplicationContext != null;
    }

    public void clear() {
        if (isInitialized()) {
            this.mSp.edit().clear().apply();
        }
    }

    public boolean contains(String str) {
        if (isInitialized()) {
            return this.mSp.contains(str);
        }
        return false;
    }

    public Map<String, ?> getAll() {
        return !isInitialized() ? new ConcurrentHashMap() : this.mSp.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        return isInitialized() ? this.mSp.getBoolean(str, z) : z;
    }

    public int getInt(String str, int i) {
        if (isInitialized()) {
            return this.mSp.getInt(str, i);
        }
        return 0;
    }

    public Long getLong(String str, long j) {
        return Long.valueOf(isInitialized() ? this.mSp.getLong(str, j) : 0L);
    }

    public String getString(String str, String str2) {
        return isInitialized() ? this.mSp.getString(str, str2) : "";
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return isInitialized() ? this.mSp.getStringSet(str, set) : new HashSet();
    }

    public void putBoolean(String str, boolean z) {
        if (isInitialized()) {
            this.mSp.edit().putBoolean(str, z).apply();
        }
    }

    public void putInt(String str, int i) {
        if (isInitialized()) {
            this.mSp.edit().putInt(str, i).apply();
        }
    }

    public void putLong(String str, long j) {
        if (isInitialized()) {
            this.mSp.edit().putLong(str, j).apply();
        }
    }

    public void putString(String str, String str2) {
        if (isInitialized()) {
            this.mSp.edit().putString(str, str2).apply();
        }
    }

    public void putStringSet(String str, Set<String> set) {
        if (isInitialized()) {
            this.mSp.edit().putStringSet(str, set).apply();
        }
    }

    public void remove(String str) {
        if (isInitialized()) {
            this.mSp.edit().remove(str).apply();
        }
    }
}
