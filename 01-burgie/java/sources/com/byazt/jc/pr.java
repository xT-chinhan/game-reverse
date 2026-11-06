package com.byazt.jc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 120, 37})
public class pr implements com.byazt.cr.c {
    public static final Map<String, com.byazt.cr.c> hw = new ConcurrentHashMap();
    public String pr;

    public static com.byazt.cr.c hw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.byazt.cr.c> map = hw;
        com.byazt.cr.c cVar = map.get(str);
        if (cVar == null) {
            pr prVar = new pr(str);
            map.put(str, prVar);
            return prVar;
        }
        return cVar;
    }

    private pr(String str) {
        this.pr = str;
    }

    @Override // com.byazt.cr.c
    public void pr(String str, int i) {
        hw.pr(this.pr, str, Integer.valueOf(i));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, long j) {
        hw.pr(this.pr, str, Long.valueOf(j));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, float f) {
        hw.pr(this.pr, str, Float.valueOf(f));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, boolean z) {
        hw.pr(this.pr, str, Boolean.valueOf(z));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, String str2) {
        hw.pr(this.pr, str, str2);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, Set<String> set) {
        hw.pr(this.pr, str, set);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return hw.hw(this.pr);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return hw.hw(this.pr, str, str2);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return hw.hw(this.pr, str, set);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return hw.pr(this.pr, str, i);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return hw.pr(this.pr, str, j);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return hw.pr(this.pr, str, f);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return hw.pr(this.pr, str, z);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean contains(String str) {
        return hw.pr(this.pr, str);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.cr.c
    public void pr(String str) {
        hw.hw(this.pr, str);
    }

    @Override // com.byazt.cr.c
    public void pr() {
        hw.pr(this.pr);
    }

    @Override // com.byazt.cr.c
    public void hw() {
    }

    @Override // com.byazt.cr.c
    public void hn() {
    }

    @Override // com.byazt.cr.c
    public int hw(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.cr.c
    public long hw(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.cr.c
    public float hw(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.cr.c
    public boolean hw(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.cr.c
    public String hw(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.cr.c
    public Set<String> hw(String str, Set<String> set) {
        return getStringSet(str, set);
    }
}
