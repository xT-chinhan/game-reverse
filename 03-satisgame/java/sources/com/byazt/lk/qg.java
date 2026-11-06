package com.byazt.lk;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1266, 26})
public class qg implements com.byazt.gwu.s {
    public final com.byazt.eau.l n;

    public qg(com.byazt.eau.l lVar) {
        this.n = lVar;
    }

    @Override // com.byazt.gwu.n
    public void n(String str, int i) {
        this.n.n(str, i);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, long j) {
        this.n.n(str, j);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, float f) {
        this.n.n(str, f);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, boolean z) {
        this.n.n(str, z);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, String str2) {
        this.n.n(str, str2);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, Set<String> set) {
        this.n.n(str, set);
    }

    @Override // com.byazt.gwu.n
    public void n(String str) {
        this.n.n(str);
    }

    @Override // com.byazt.gwu.n
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.gwu.n
    public void qg() {
        this.n.qg();
    }

    @Override // com.byazt.gwu.n
    public void s() {
        this.n.s();
    }

    @Override // com.byazt.gwu.n
    public int qg(String str, int i) {
        return this.n.getInt(str, i);
    }

    @Override // com.byazt.gwu.n
    public long qg(String str, long j) {
        return this.n.getLong(str, j);
    }

    @Override // com.byazt.gwu.n
    public float qg(String str, float f) {
        return this.n.getFloat(str, f);
    }

    @Override // com.byazt.gwu.n
    public boolean qg(String str, boolean z) {
        return this.n.getBoolean(str, z);
    }

    @Override // com.byazt.gwu.n
    public String qg(String str, String str2) {
        return this.n.getString(str, str2);
    }

    @Override // com.byazt.gwu.n
    public Set<String> qg(String str, Set<String> set) {
        return this.n.getStringSet(str, set);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.n.getAll();
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.n.getString(str, str2);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.n.getStringSet(str, set);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.n.getInt(str, i);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.n.getLong(str, j);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.n.getFloat(str, f);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.n.getBoolean(str, z);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.n.contains(str);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.n.edit();
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
