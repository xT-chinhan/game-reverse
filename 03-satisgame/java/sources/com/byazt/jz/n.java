package com.byazt.jz;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2277, 19})
public class n implements com.byazt.eau.l {
    public static final Map<String, com.byazt.eau.l> qg = new ConcurrentHashMap();
    public String n;

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.byazt.eau.l
    public void qg() {
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.eau.l
    public void s() {
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public static com.byazt.eau.l qg(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.byazt.eau.l> map = qg;
        com.byazt.eau.l lVar = map.get(str);
        if (lVar != null) {
            return lVar;
        }
        n nVar = new n(str);
        map.put(str, nVar);
        return nVar;
    }

    private n(String str) {
        this.n = str;
    }

    @Override // com.byazt.eau.l
    public void n(String str, int i) {
        qg.n(this.n, str, Integer.valueOf(i));
    }

    @Override // com.byazt.eau.l
    public void n(String str, long j) {
        qg.n(this.n, str, Long.valueOf(j));
    }

    @Override // com.byazt.eau.l
    public void n(String str, float f) {
        qg.n(this.n, str, Float.valueOf(f));
    }

    @Override // com.byazt.eau.l
    public void n(String str, boolean z) {
        qg.n(this.n, str, Boolean.valueOf(z));
    }

    @Override // com.byazt.eau.l
    public void n(String str, String str2) {
        qg.n(this.n, str, str2);
    }

    @Override // com.byazt.eau.l
    public void n(String str, Set<String> set) {
        qg.n(this.n, str, set);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return qg.qg(this.n);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return qg.qg(this.n, str, str2);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return qg.qg(this.n, str, set);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return qg.n(this.n, str, i);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return qg.n(this.n, str, j);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return qg.n(this.n, str, f);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return qg.n(this.n, str, z);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean contains(String str) {
        return qg.n(this.n, str);
    }

    @Override // com.byazt.eau.l
    public void n(String str) {
        qg.qg(this.n, str);
    }

    @Override // com.byazt.eau.l
    public void n() {
        qg.n(this.n);
    }

    @Override // com.byazt.eau.l
    public int qg(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.eau.l
    public long qg(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.eau.l
    public float qg(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.eau.l
    public boolean qg(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.eau.l
    public String qg(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.eau.l
    public Set<String> qg(String str, Set<String> set) {
        return getStringSet(str, set);
    }
}
